package pine.dom

import pine._

import scala.collection.mutable

object DiffRender {
  def render(diff: Diff): Unit =
    diff match {
      case Diff.SetAttribute(ref, attribute, value) =>
        val dom = DOM.get(ref)
        if (!HtmlHelpers.BooleanAttributes.contains(attribute.name))
          dom.setAttribute(attribute.name, value.toString)
        else {
          if (value.asInstanceOf[Boolean]) dom.setAttribute(attribute.name, "")
          else dom.removeAttribute(attribute.name)
        }

      case Diff.UpdateAttribute(ref, attribute, f) =>
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

      case Diff.RemoveAttribute(ref, attribute) =>
        DOM.get(ref).removeAttribute(attribute.name)

      case Diff.ReplaceChildren(ref, children) =>
        val dom = DOM.get(ref)
        dom.clear()
        children.foreach(child => dom.appendChild(DOM.render(child)))

      case Diff.Replace(ref, replacement) =>
        val dom = DOM.get(ref)
        dom.parentNode.replaceChild(DOM.render(replacement), dom)

      case Diff.PrependChild(ref, child) =>
        DOM.get(ref).prependChild(DOM.render(child))

      case Diff.AppendChild(ref, child) =>
        DOM.get(ref).appendChild(DOM.render(child))

      case Diff.RemoveChild(ref) =>
        val dom = DOM.get(ref)
        dom.parentNode.removeChild(dom)

      case Diff.Noop =>
    }
}

class DomRenderContext extends RenderContext {
  var committed = false
  val diffs = mutable.Queue.empty[Diff]

  override def render(diff: Diff): Unit = {
    if (committed) throw new Exception("Dangling rendering context")
    diffs += diff
  }

  def commit(): Unit = {
    diffs.foreach(DiffRender.render)
    diffs.clear()
    committed = true
  }
}
