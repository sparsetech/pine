package pl.metastack.metaweb.diff

import pl.metastack.metaweb._
import pl.metastack.metaweb.tree.Tag

sealed trait NodeRef[+T <: tree.Tag] {
  def matches(tag: tree.Tag): Boolean

  def set[U](values: List[U], value: U => tree.Tag)(implicit id: Id[U]): Diff =
    Diff.ReplaceChildren(this, values.map(v => Render.suffixIds(value(v), id.f(v))))
  def set(value: List[tree.Node]): Diff = Diff.ReplaceChildren(this, value)
  def set(value: tree.Node): Diff = set(List(value))
  def remove(): Diff = Diff.RemoveChild(this)
  def append(value: tree.Node): Diff = Diff.AppendChild(this, value)

  def :=(value: List[tree.Node]) = set(value)
  def :=(value: tree.Node) = set(value)
  def +=(value: tree.Node) = append(value)
}

object NodeRef {
  case class ById[+T <: tree.Tag](id: String) extends NodeRef[T] {
    override def matches(tag: tree.Tag): Boolean = tag.id.contains(id)
    def apply[U](value: U)(implicit id: Id[U]): NodeRef[T] =
      copy(id = this.id + id.f(value))
  }

  case class ByTag[+T <: tree.Tag](tagName: String) extends NodeRef[T] {
    override def matches(tag: Tag): Boolean =
      tag.tagName.equalsIgnoreCase(tagName)
  }

  def apply[T <: tree.Tag](id: String): NodeRef.ById[T] = NodeRef.ById[T](id)
  def apply[T <: tree.Tag](node: T): NodeRef.ByTag[T] = NodeRef.ByTag[T](node.tagName)
}