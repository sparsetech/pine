package pine

object DiffRender {
  def render[T <: Singleton](tag: Tag[T]): Diff => List[Node] = {
    case Diff.SetAttribute(attribute, value) =>
      List(attribute.codec.encode(value) match {
        case None    => tag.remAttr(attribute.name)
        case Some(v) => tag.setAttr(attribute.name, v)
      })

    case Diff.UpdateAttribute(attribute, f) =>
      val curValue = tag.attr(attribute.name)
      val newValue = f(attribute.codec.decode(curValue))

      List(attribute.codec.encode(newValue) match {
        case None    => tag.remAttr(attribute.name)
        case Some(v) => tag.setAttr(attribute.name, v)
      })

    case Diff.RemoveAttribute(attribute) => List(tag.remAttr(attribute.name))
    case Diff.PrependChildren(children) => List(tag.prependAll(children))
    case Diff.AppendChildren(children) => List(tag.appendAll(children))
    case Diff.Replace(nodes) => nodes
    case Diff.SetChildren(children) => List(tag.set(children))
    case Diff.InsertAt(position, children) => List(tag.insertAt(position, children))
    case Diff.RemoveNode() => List.empty
  }
}
