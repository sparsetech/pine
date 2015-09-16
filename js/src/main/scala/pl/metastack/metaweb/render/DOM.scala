package pl.metastack.metaweb.render

import scala.collection.mutable

import scala.scalajs.js

import org.scalajs.dom

import pl.metastack.metarx._
import pl.metastack.metarx.Buffer.Position

import pl.metastack.metaweb._

trait DOM[N] extends Render[N, Seq[dom.Element]]

trait DOMImplicit {
  implicit class NodeToDom(node: Node) {
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
object DOM extends DOM[Node]
  with PlatformSupport  // TODO For IntelliJ
{
  override def render(node: Node): Seq[dom.Element] =
    node match {
      case n: Null => RenderNull.render(n)
      case n: Placeholder => RenderPlaceholder.render(n)
      case n: Container => RenderContainer.render(n)
      case n: Text => RenderText.render(n)
      case n: Tag => RenderTag.render(n)
    }

  def nullNode(): dom.Element =
    dom.document.createComment("")
      .asInstanceOf[dom.Element]

  case object RenderNull extends DOM[Null] {
    def render(node: Null): Seq[dom.Element] = Seq(nullNode())
  }

  case object RenderPlaceholder extends DOM[Placeholder] {
    def render(node: Placeholder): Seq[dom.Element] = {
      node match {
        case n: tree.Placeholder =>
          val dom = node.node.map(_.toDom)
          dom.getOrElse(Seq(nullNode()))
        case n: state.Placeholder =>
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
                   deltas: ReadChannel[Buffer.Delta[Node]]) {
    val mapping = mutable.Map.empty[Node, Seq[dom.Node]]

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

  case object RenderContainer extends DOM[Container] {
    def render(node: Container): Seq[dom.Element] = {
      node match {
        case n: tree.Container => n.nodes.flatMap(_.toDom)
        case n: state.Container =>
          // TODO Don't create <span>
          val rendered = dom.document.createElement("span")
          renderBuffer(rendered, n.deltas)
          Seq(rendered)
      }
    }
  }

  def renderTag(tag: state.Tag): dom.Element = {
    val rendered = dom.document.createElement(tag.tagName)
    val attrCallbacks = mutable.Map.empty[String, dom.Event => Unit]

    def nonStandard(k: String) =
      k == "style" ||
        k == "class" ||
        k.startsWith("aria-") ||
        k.startsWith("data-")

    val renderedDyn = rendered.asInstanceOf[js.Dynamic]

    def setAttr(k: String, v: Any) {
      if (nonStandard(k)) renderedDyn.setAttribute(k, v.asInstanceOf[js.Any])
      else renderedDyn.updateDynamic(k)(v.asInstanceOf[js.Any])
    }

    def setAttrCh(k: String, v: Var[Any]) {
      val ignore = v.attach(setAttr(k, _))

      // TODO Only register in DOM when there are subscribers in `ch`
      DOMObserverRules.resolveEvents(tag.tagName, k).foreach { events =>
        attrCallbacks += k -> ((e: dom.Event) =>
          v.produce(getAttr(k), ignore))

        events.foreach { event =>
          rendered.addEventListener(event,
            attrCallbacks(k),
            useCapture = false)
        }
      }
    }

    def getAttr(k: String): Any =
      if (nonStandard(k)) renderedDyn.getAttribute(k)
      else renderedDyn.selectDynamic(k)

    def remAttr(k: String) {
      rendered.removeAttribute(k)

      DOMObserverRules.resolveEvents(tag.tagName, k).foreach { events =>
        events.foreach { event =>
          rendered.removeEventListener(event,
            attrCallbacks(k),
            useCapture = false)
        }
      }

      attrCallbacks -= k
    }

    tag.nodeProvider.register { case () => rendered }

    tag.eventProvider.register { case (event, args) =>
      rendered
        .asInstanceOf[js.Dynamic]
        .applyDynamic(event)(args.map(_.asInstanceOf[js.Any]): _*)
    }

    tag.watchAttributes.attach {
      case Dict.Delta.Insert(k, v) => setAttrCh(k, v)
      case Dict.Delta.Update(k, v) => setAttrCh(k, v)
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

  case object RenderTag extends DOM[Tag] {
    def render(node: Tag): Seq[dom.Element] = {
      node match {
        case n: tree.Tag =>
          val element = dom.document.createElement(n.tagName)

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

        case n: state.Tag => Seq(renderTag(n))
      }
    }
  }

  case object RenderText extends DOM[Text] {
    def render(node: Text): Seq[dom.Element] = {
      node match {
        case n: tree.Text =>
          Seq(dom.document.createTextNode(n.text)
            .asInstanceOf[dom.Element])

        case n: state.Text =>
          val rendered = dom.document.createTextNode("")
            .asInstanceOf[dom.Element]

          n.values.attach { text =>
            // TODO Use `var` in scalajs-dom
            rendered.asInstanceOf[js.Dynamic].nodeValue = text
          }

          Seq(rendered)
      }
    }
  }
}
