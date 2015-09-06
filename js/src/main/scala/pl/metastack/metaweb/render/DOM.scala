package pl.metastack.metaweb.render

import scala.collection.mutable

import scala.scalajs.js

import org.scalajs.dom

import pl.metastack.metarx.{ReadChannel, Dict, Buffer}
import pl.metastack.metarx.Buffer.Position

import pl.metastack.metaweb.{PlatformSupport, state, Render}

trait DOM[N] extends Render[N, Seq[dom.Element]]

trait DOMImplicit {
  implicit class NodeToDom(node: state.Node) {
    def toDom: Seq[dom.Element] = DOM.render(node)
  }
}

object DOMObserverRules {
  /** Hierarchy: Tag -> Field -> Events */
  val rules = Map(
    "input" -> Map(
      "value" -> Set("keyup", "paste", "blur", "change")
    )
  )

  def resolveEvents(tag: String, field: String): Option[Set[String]] =
    for {
      tagRule <- DOMObserverRules.rules.get(tag)
      attrEvents <- tagRule.get(field)
    } yield attrEvents
}

/* The rendering rules make sure that the resulting Seq[dom.Element] node is
 * non-empty. Otherwise state.Null cannot be located in the DOM.
 */
object DOM extends DOM[state.Node]
  with PlatformSupport  // TODO For IntelliJ
{
  override def render(node: state.Node): Seq[dom.Element] =
    node match {
      case n: state.Null => RenderNull.render(n)
      case n: state.Placeholder => RenderPlaceholder.render(n)
      case n: state.Container => RenderContainer.render(n)
      case n: state.Text => RenderText.render(n)
      case n: state.Tag => RenderTag.render(n)
    }

  def nullNode(): dom.Element =
    dom.document.createComment("")
      .asInstanceOf[dom.Element]

  case object RenderNull extends DOM[state.Null] {
    def render(node: state.Null): Seq[dom.Element] = Seq(nullNode())
  }

  case object RenderPlaceholder extends DOM[state.Placeholder] {
    def render(node: state.Placeholder): Seq[dom.Element] = {
      node match {
        case n: state.zeroway.Placeholder =>
          val dom = node.get.map(_.toDom)
          dom.getOrElse(Seq(nullNode()))
        case n: state.oneway.Placeholder =>
          // TODO Don't create <span>
          val elem = dom.document.createElement("span")
          n.values.attach {
            case None => elem.clear()
            case Some(child) =>
              elem.clear()
              child.toDom.foreach(elem.appendChild)
          }
          Seq(elem)
      }
    }
  }

  def renderBuffer(rendered: dom.Element,
                   deltas: ReadChannel[Buffer.Delta[state.Node]]) {
    val mapping = mutable.Map.empty[state.Node, Seq[dom.Node]]

    deltas.attach {
      case Buffer.Delta.Insert(Position.Head(), element) =>
        mapping += element -> element.toDom
        mapping(element).reverse.foreach(rendered.prependChild)

      case Buffer.Delta.Insert(Position.Last(), element) =>
        mapping += element -> element.toDom
        mapping(element).foreach(rendered.appendChild)

      case Buffer.Delta.Insert(Position.Before(reference), element) =>
        mapping += element -> element.toDom
        val hd = mapping(element).head
        mapping(reference).reverse.foreach(rendered.insertBefore(hd, _))

      case Buffer.Delta.Insert(Position.After(reference), element) =>
        mapping += element -> element.toDom
        val lst = mapping(reference).last
        mapping(element).reverse.foreach(rendered.insertAfter(lst, _))

      case Buffer.Delta.Replace(reference, element) =>
        mapping += element -> element.toDom
        val lst = mapping(reference).last
        mapping(element).reverse.foreach(rendered.insertAfter(lst, _))
        mapping(reference).foreach(rendered.removeChild)
        mapping -= reference

      case Buffer.Delta.Remove(element) =>
        mapping(element).foreach(rendered.removeChild)
        mapping -= element

      case Buffer.Delta.Clear() =>
        rendered.clear()
        mapping.clear()
    }
  }

  case object RenderContainer extends DOM[state.Container] {
    def render(node: state.Container): Seq[dom.Element] = {
      node match {
        case n: state.zeroway.Container => node.get.flatMap(_.toDom)
        case n: state.oneway.Container =>
          // TODO Don't create <span>
          val rendered = dom.document.createElement("span")
          renderBuffer(rendered, n.deltas)
          Seq(rendered)
      }
    }
  }

  def renderTag(tag: state.oneway.Tag): dom.Element = {
    val rendered = dom.document.createElement(tag.name)
    val attrCallbacks = mutable.Map.empty[String, dom.Event => Unit]

    var ignoreNext = false

    def nonStandard(k: String) =
      k == "class" ||
        k.startsWith("aria-") ||
        k.startsWith("data-")

    val renderedDyn = rendered.asInstanceOf[js.Dynamic]

    def setAttr(k: String, v: Any) {
      if (nonStandard(k)) renderedDyn.setAttribute(k, v.asInstanceOf[js.Any])
      else renderedDyn.updateDynamic(k)(v.asInstanceOf[js.Any])
    }

    def getAttr(k: String): Any =
      if (nonStandard(k)) renderedDyn.getAttribute(k)
      else renderedDyn.selectDynamic(k)

    def remAttr(k: String) {
      rendered.removeAttribute(k)

      if (tag.ways == 2) {
        DOMObserverRules.resolveEvents(tag.name, k).foreach { events =>
          events.foreach { event =>
            rendered.removeEventListener(event,
              attrCallbacks(k),
              useCapture = false)
          }
        }

        attrCallbacks -= k
      }
    }

    tag.attributeProvider.register { case attr =>
      getAttr(attr)
    }

    tag.eventProvider.register { case (event, args) =>
      rendered
        .asInstanceOf[js.Dynamic]
        .applyDynamic(event)(args.map(_.asInstanceOf[js.Any]): _*)
    }

    tag.watchAttributes.attach {
      case Dict.Delta.Insert(k, v) =>
        setAttr(k, v)

        if (tag.ways == 2) {
          DOMObserverRules.resolveEvents(tag.name, k).foreach { events =>
            attrCallbacks += k -> ((e: dom.Event) => {
              ignoreNext = true
              tag.updateAttribute(k, getAttr(k))
            })

            events.foreach { event =>
              rendered.addEventListener(event,
                attrCallbacks(k),
                useCapture = false)
            }
          }
        }

      case Dict.Delta.Update(k, v) =>
        if (!ignoreNext) {
          setAttr(k, v)
        }

        ignoreNext = false

      case Dict.Delta.Remove(k) => remAttr(k)
      case Dict.Delta.Clear() =>
        tag.attributes.foreach { case (k, _) =>
          remAttr(k)
        }
    }

    tag.watchEvents.attach {
      case Dict.Delta.Insert(k, v) => rendered.addEventListener(k, v)
      case Dict.Delta.Update(k, v) =>
        rendered.removeEventListener(k, tag.events(k))
        rendered.addEventListener(k, v)
      case Dict.Delta.Remove(k) =>
        rendered.removeEventListener(k, tag.events(k))
      case Dict.Delta.Clear() =>
        tag.events.foreach { case (k, v) =>
          rendered.removeEventListener(k, v)
        }
    }

    renderBuffer(rendered, tag.watchChildren)
    rendered
  }

  case object RenderTag extends DOM[state.Tag] {
    def render(node: state.Tag): Seq[dom.Element] = {
      node match {
        case n: state.zeroway.Tag =>
          val element = dom.document.createElement(n.name)

          n.attributes.foreach { case (k, v) =>
            element.setAttribute(k, v.toString)
          }

          n.events.foreach { case (k, v) =>
            // TODO Check support for multiple arguments
            element.addEventListener(k, v)
          }

          n.children.flatMap(_.toDom)
            .foreach(element.appendChild)

          Seq(element)

        case n: state.oneway.Tag => Seq(renderTag(n))
      }
    }
  }

  case object RenderText extends DOM[state.Text] {
    def render(node: state.Text): Seq[dom.Element] = {
      node match {
        case n: state.zeroway.Text =>
          Seq(dom.document.createTextNode(n.get)
            .asInstanceOf[dom.Element])

        case n: state.oneway.Text =>
          // TODO Don't create <span>
          val rendered = dom.document.createElement("span")
          n.values.attach { text =>
            rendered.replaceFirst(dom.document.createTextNode(text))
          }
          Seq(rendered)
      }
    }
  }
}
