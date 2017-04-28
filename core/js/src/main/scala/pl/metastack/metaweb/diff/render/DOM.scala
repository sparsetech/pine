package pl.metastack.metaweb.diff.render

import pl.metastack.metaweb
import pl.metastack.metaweb.diff._
import pl.metastack.metaweb.{DomDiff, HtmlHelpers, PlatformSupport}

object DOM extends PlatformSupport {
  def render(diff: Diff): Unit =
    diff match {
      case Diff.SetAttribute(ref, attribute, value) =>
        val dom = metaweb.DOM.get(ref)
        if (!HtmlHelpers.BooleanAttributes.contains(attribute.name))
          dom.setAttribute(attribute.name, value.toString)
        else {
          if (value.asInstanceOf[Boolean]) dom.setAttribute(attribute.name, "")
          else dom.removeAttribute(attribute.name)
        }

      case Diff.UpdateAttribute(ref, attribute, f) =>
        val dom = metaweb.DOM.get(ref)
        if (HtmlHelpers.BooleanAttributes.contains(attribute.name)) {
          val fBoolean = f.asInstanceOf[Boolean => Boolean]
          val current = dom.hasAttribute(attribute.name)
          if (fBoolean(current)) dom.setAttribute(attribute.name, "")
          else                   dom.removeAttribute(attribute.name)
        } else {
          val fString = f.asInstanceOf[Option[String] => Option[String]]
          val current = Option(dom.getAttribute(attribute.name))
          fString(current) match {
            case None    => dom.removeAttribute(attribute.name)
            case Some(s) => dom.setAttribute(attribute.name, s)
          }
        }

      case Diff.RemoveAttribute(ref, attribute) =>
        metaweb.DOM.get(ref).removeAttribute(attribute.name)

      case Diff.ReplaceChildren(ref, children) =>
        val dom = metaweb.DOM.get(ref)
        dom.clear()
        children.foreach(child => dom.appendChild(metaweb.DOM.render(child)))

      case Diff.Replace(ref, replacement) =>
        val dom = metaweb.DOM.get(ref)
        dom.parentNode.replaceChild(metaweb.DOM.render(replacement), dom)

      case Diff.PrependChild(ref, child) =>
        metaweb.DOM.get(ref).prependChild(metaweb.DOM.render(child))

      case Diff.AppendChild(ref, child) =>
        metaweb.DOM.get(ref).appendChild(metaweb.DOM.render(child))

      case Diff.RemoveChild(ref) =>
        val dom = metaweb.DOM.get(ref)
        dom.parentNode.removeChild(dom)

      case Diff.Noop =>
    }

  def render(diff: DomDiff): Unit =
    diff match {
      case DomDiff.SetEvent(set, f) => set(f)
      case DomDiff.DetachEvent(set) => set(null)
    }
}
