package pine

object DiffRender {
  def render[T <: Singleton](tag: Tag[T]): Diff => List[Node] = {
    case Diff.SetAttribute(name, value) => List(tag.setAttr(name, value))
    case Diff.RemoveAttribute(name) => List(tag.remAttr(name))
    case Diff.UpdateAttribute(name, f) =>
      List(f(tag.attr(name)) match {
        case None    => tag.remAttr(name)
        case Some(v) => tag.setAttr(name, v)
      })
    case Diff.PrependChildren(children) => List(tag.prependAll(children))
    case Diff.AppendChildren(children) => List(tag.appendAll(children))
    case Diff.Replace(nodes) => nodes
    case Diff.SetChildren(children) => List(tag.set(children))
    case Diff.InsertAt(position, children) => List(tag.insertAt(position, children))
    case Diff.RemoveNode() => List.empty
  }
}
