package pine

sealed trait TagRef[+T <: Tag] {
  def matches(tag: Tag): Boolean

  /** Recursively adds `suffix` to every ID attribute of `node` */
  def suffixIds(node: Node, suffix: String): Node =
    if (suffix.isEmpty) node
    else node match {
      case tag: Tag if tag.id.nonEmpty =>
        tag.copy(
          attributes = tag.attributes + ("id" -> (tag.id.get + suffix)),
          children   = tag.children.map(suffixIds(_, suffix)))

      case tag: Tag =>
        tag.copy(children = tag.children.map(suffixIds(_, suffix)))

      case n => n
    }

  def set[U](values: List[U], f: U => Tag)(implicit id: Id[U]): Diff =
    Diff.ReplaceChildren(this, values.map(v => suffixIds(f(v), id.f(v))))
  def set(nodes: List[Node]): Diff = Diff.ReplaceChildren(this, nodes)
  def set(node: Node): Diff = set(List(node))
  def replace(node: Node): Diff = Diff.Replace(this, node)
  def remove(): Diff = Diff.RemoveChild(this)
  def append[U](value: U, f: U => Tag)(implicit id: Id[U]): Diff =
    Diff.AppendChild(this, suffixIds(f(value), id.f(value)))
  def append(node: Node): Diff = Diff.AppendChild(this, node)

  def :=(value: List[Node]): Diff = set(value)
  def :=(value: Node): Diff = set(value)
  def +=(value: Node): Diff = append(value)
}

object TagRef {
  case class ById[+T <: Tag](id: String) extends TagRef[T] {
    override def matches(tag: Tag): Boolean = tag.id.contains(id)
    def apply[U](value: U)(implicit id: Id[U]): TagRef[T] =
      copy(id = this.id + id.f(value))
  }

  case class ByTag[+T <: Tag](tagName: String) extends TagRef[T] {
    override def matches(tag: Tag): Boolean =
      tag.tagName.equalsIgnoreCase(tagName)
  }

  def apply[T <: Tag](id: String): TagRef.ById[T] = TagRef.ById[T](id)
  def apply[T <: Tag](node: T): TagRef.ByTag[T] = TagRef.ByTag[T](node.tagName)
}
