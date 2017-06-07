package pine

object DiffRender {
  def render[T <: Singleton](tag: Tag[T]): Diff => Option[Node] = {
    case Diff.SetAttribute(attribute, value) =>
      if (!HtmlHelpers.BooleanAttributes.contains(attribute.name))
        Some(tag.setAttr(attribute.name, value.toString))
      else {
        if (value.asInstanceOf[Boolean]) Some(tag.setAttr(attribute.name, ""))
        else Some(tag.remAttr(attribute.name))
      }

    case Diff.UpdateAttribute(attribute, f) =>
      // TODO May not work for custom boolean attributes
      if (HtmlHelpers.BooleanAttributes.contains(attribute.name)) {
        val fBoolean = f.asInstanceOf[Boolean => Boolean]
        if (fBoolean(tag.attributes.contains(attribute.name)))
          Some(tag.setAttr(attribute.name, ""))
        else
          Some(tag.remAttr(attribute.name))
      } else {
        val fString = f.asInstanceOf[Option[String] => Option[String]]
        val updated = fString(tag.attributes.get(attribute.name)
          .asInstanceOf[Option[String]])
        updated match {
          case None => Some(tag.remAttr(attribute.name))
          case Some(s) => Some(tag.setAttr(attribute.name, s))
        }
      }

    case Diff.RemoveAttribute(attribute) => Some(tag.remAttr(attribute.name))
    case Diff.PrependChild(child) => Some(tag.prepend(child))
    case Diff.AppendChild(child) => Some(tag.append(child))
    case Diff.Replace(replacement) => Some(replacement)
    case Diff.ReplaceChildren(children) => Some(tag.set(children))
    case Diff.RemoveChild() => None
  }
}
