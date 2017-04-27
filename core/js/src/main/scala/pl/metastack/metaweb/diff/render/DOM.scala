package pl.metastack.metaweb.diff.render

import org.scalajs.dom

import pl.metastack.metaweb.diff._
import pl.metastack.metaweb.{tree, HtmlHelpers, PlatformSupport}

object DOM {
  implicit object RenderDom extends Render[dom.Node, Unit] with PlatformSupport {
    def render(node: dom.Node, diff: Diff): Unit =
      diff match {
        case Diff.Sequence(left, right @ _*) =>
          render(node, left)
          right.foreach(render(node, _))

        case Diff.SetAttribute(ref, attribute, value) =>
          if (!HtmlHelpers.BooleanAttributes.contains(attribute.name))
            ref.dom.setAttribute(attribute.name, value.toString)
          else {
            if (value.asInstanceOf[Boolean]) ref.dom.setAttribute(attribute.name, "")
            else ref.dom.removeAttribute(attribute.name)
          }

        case Diff.UpdateAttribute(ref, attribute, f) =>
          if (HtmlHelpers.BooleanAttributes.contains(attribute.name)) {
            val fBoolean = f.asInstanceOf[Boolean => Boolean]
            val current = ref.dom.hasAttribute(attribute.name)
            if (fBoolean(current)) ref.dom.setAttribute(attribute.name, "")
            else                   ref.dom.removeAttribute(attribute.name)
          } else {
            val fString = f.asInstanceOf[Option[String] => Option[String]]
            val current = Option(ref.dom.getAttribute(attribute.name))
            fString(current) match {
              case None    => ref.dom.removeAttribute(attribute.name)
              case Some(s) => ref.dom.setAttribute(attribute.name, s)
            }
          }

        case Diff.RemoveAttribute(ref, attribute) =>
          ref.dom.removeAttribute(attribute.name)

        case Diff.ReplaceChildren(ref, children) =>
          ref.dom.clear()
          children.foreach(child =>
            ref.dom.appendChild(tree.render.DOM.render(child)))

        case e: DiffDom.SubscribeEvent[_] =>
          val cast = e.asInstanceOf[DiffDom.SubscribeEvent[dom.Event]]
          cast.set { event: dom.Event =>
            render(node, cast.f(event))
          }

        case e: DiffDom.UnsubscribeEvent[_] =>
          val cast = e.asInstanceOf[DiffDom.SubscribeEvent[dom.Event]]
          cast.set(null)

        case Diff.PrependChild(ref, child) =>
          ref.dom.prependChild(tree.render.DOM.render(child))

        case Diff.AppendChild(ref, child) =>
          ref.dom.appendChild(tree.render.DOM.render(child))

        case Diff.RemoveChild(ref) =>
          ref.dom.parentNode.removeChild(ref.dom)
      }
  }

  def collectNodes(node: dom.Node): Map[String, dom.Element] =
    node match {
      case e: dom.Element =>
        val map =
          if (e.id != "") Map(e.id -> e)
          else Map.empty[String, dom.Element]

        import dom.ext._
        e.getElementsByTagName("*").collect {
          case e: dom.Element if e.id.nonEmpty => e.id -> e
        }.toMap ++ map

      case _ => Map.empty
    }
}
