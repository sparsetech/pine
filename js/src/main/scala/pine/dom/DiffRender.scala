package pine.dom

import pine.HtmlHelpers

object DiffRender {
  def render(diff: pine.Diff): Unit =
    diff match {
      case pine.Diff.SetAttribute(ref, attribute, value) =>
        val dom = DOM.get(ref)
        if (!HtmlHelpers.BooleanAttributes.contains(attribute.name))
          dom.setAttribute(attribute.name, value.toString)
        else {
          if (value.asInstanceOf[Boolean]) dom.setAttribute(attribute.name, "")
          else dom.removeAttribute(attribute.name)
        }

      case pine.Diff.UpdateAttribute(ref, attribute, f) =>
        val dom = DOM.get(ref)
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

      case pine.Diff.RemoveAttribute(ref, attribute) =>
        DOM.get(ref).removeAttribute(attribute.name)

      case pine.Diff.ReplaceChildren(ref, children) =>
        val dom = DOM.get(ref)
        dom.clear()
        children.foreach(child => dom.appendChild(DOM.render(child)))

      case pine.Diff.Replace(ref, replacement) =>
        val dom = DOM.get(ref)
        dom.parentNode.replaceChild(DOM.render(replacement), dom)

      case pine.Diff.PrependChild(ref, child) =>
        DOM.get(ref).prependChild(DOM.render(child))

      case pine.Diff.AppendChild(ref, child) =>
        DOM.get(ref).appendChild(DOM.render(child))

      case pine.Diff.RemoveChild(ref) =>
        val dom = DOM.get(ref)
        dom.parentNode.removeChild(dom)

      case pine.Diff.Noop =>
    }

  def render(diff: Diff): Unit =
    diff match {
      case Diff.SetEvent(set, f) => set(f)
      case Diff.DetachEvent(set) => set(null)
    }
}
