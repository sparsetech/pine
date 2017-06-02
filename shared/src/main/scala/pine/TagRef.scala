package pine

sealed trait TagRef[+T <: Tag] {
  def matches(tag: Tag): Boolean

  def set(nodes: List[Node]): Diff = Diff.ReplaceChildren(this, nodes)
  def set(node: Node): Diff = set(List(node))
  def replace(node: Node): Diff = Diff.Replace(this, node)
  def remove(): Diff = Diff.RemoveChild(this)
  def append(node: Node): Diff = Diff.AppendChild(this, node)

  def :=(value: List[Node]): Diff = set(value)
  def :=(value: Node): Diff = set(value)
  def +=(value: Node): Diff = append(value)
}

object TagRef {
  case class ById[+T <: Tag](id: String) extends TagRef[T] {
    override def matches(tag: Tag): Boolean = tag.id.contains(id)
  }

  case class ByTag[+T <: Tag](tagName: String) extends TagRef[T] {
    override def matches(tag: Tag): Boolean =
      tag.tagName.equalsIgnoreCase(tagName)
  }

  def apply[T <: Tag](id: String): TagRef.ById[T] = TagRef.ById[T](id)
  def apply[T <: Tag](id: String, child: String): TagRef.ById[T] = TagRef.ById[T](id + child)
  def apply[T <: Tag](node: T): TagRef.ByTag[T] = TagRef.ByTag[T](node.tagName)
}
