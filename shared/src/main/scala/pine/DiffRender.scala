package pine

object DiffRender {
  def render[T <: Singleton](tag: Tag[T]): Diff => List[Node] = {
    case Diff.SetAttribute(attribute, value) =>
      if (!HtmlHelpers.BooleanAttributes.contains(attribute.name))
        List(tag.setAttr(attribute.name, value.toString))
      else {
        if (value.asInstanceOf[Boolean]) List(tag.setAttr(attribute.name, ""))
        else List(tag.remAttr(attribute.name))
      }

    case Diff.UpdateAttribute(attribute, f) =>
      // TODO May not work for custom boolean attributes
      if (HtmlHelpers.BooleanAttributes.contains(attribute.name)) {
        val fBoolean = f.asInstanceOf[Boolean => Boolean]
        if (fBoolean(tag.attributes.contains(attribute.name)))
          List(tag.setAttr(attribute.name, ""))
        else
          List(tag.remAttr(attribute.name))
      } else {
        val fString = f.asInstanceOf[Option[String] => Option[String]]
        val updated = fString(tag.attributes.get(attribute.name)
          .asInstanceOf[Option[String]])
        updated match {
          case None => List(tag.remAttr(attribute.name))
          case Some(s) => List(tag.setAttr(attribute.name, s))
        }
      }

    case Diff.RemoveAttribute(attribute) => List(tag.remAttr(attribute.name))
    case Diff.PrependChildren(children) => List(tag.prependAll(children))
    case Diff.AppendChildren(children) => List(tag.appendAll(children))
    case Diff.Replace(nodes) => nodes
    case Diff.SetChildren(children) => List(tag.set(children))
    case Diff.InsertAt(position, children) => List(tag.insertAt(position, children))
    case Diff.RemoveNode() => List.empty
  }
}
