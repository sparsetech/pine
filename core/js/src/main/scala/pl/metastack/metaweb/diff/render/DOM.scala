package pl.metastack.metaweb.diff.render

import org.scalajs.dom
import pl.metastack.metaweb.diff._
import pl.metastack.metaweb.{DomDiff, HtmlHelpers, PlatformSupport, tree}

object DOM {
  implicit object RenderDom extends Render[dom.Node, Diff, Unit] with PlatformSupport {
    def render(node: dom.Node, diff: Diff): Unit =
      diff match {
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

        case Diff.PrependChild(ref, child) =>
          ref.dom.prependChild(tree.render.DOM.render(child))

        case Diff.AppendChild(ref, child) =>
          ref.dom.appendChild(tree.render.DOM.render(child))

        case Diff.RemoveChild(ref) =>
          ref.dom.parentNode.removeChild(ref.dom)

        case Diff.Noop =>
      }
  }

  implicit object RenderDomDiff extends Render[dom.Node, DomDiff, Unit] with PlatformSupport {
    def render(node: dom.Node, diff: DomDiff): Unit =
      diff match {
        case e: DomDiff.SubscribeEvent[_] =>
          val cast = e.asInstanceOf[DomDiff.SubscribeEvent[dom.Event]]
          cast.set { event: dom.Event =>
            RenderDom.render(node, cast.f(event))
          }

        case e: DomDiff.UnsubscribeEvent[_] =>
          val cast = e.asInstanceOf[DomDiff.SubscribeEvent[dom.Event]]
          cast.set(null)
      }
  }
}
