package pl.metastack.metaweb.diff

import pl.metastack.metaweb._

class NodeRef[+T <: tree.Tag](val id: String) {
  def matches(tag: tree.Tag): Boolean = tag.id.contains(id)

  def set(value: Seq[tree.Node]): Diff = Diff.ReplaceChildren(this, value)
  def set(value: tree.Node): Diff = set(Seq(value))
  def remove(): Diff = Diff.RemoveChild(this)
  def append(value: tree.Node): Diff = Diff.AppendChild(this, value)

  def :=(value: Seq[tree.Node]) = set(value)
  def :=(value: tree.Node) = set(value)
  def +=(value: tree.Node) = append(value)
}

object NodeRef {
  def apply[T <: tree.Tag](id: String): NodeRef[T] = new NodeRef[T](id)
}
