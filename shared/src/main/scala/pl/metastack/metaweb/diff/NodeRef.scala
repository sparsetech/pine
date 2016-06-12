package pl.metastack.metaweb.diff

import pl.metastack.metaweb._

case class NodeRef[+T <: tree.Tag](baseId: String, instanceId: String = "", idMap: IdMap) {
  def id: String = baseId + instanceId
  def matches(tag: tree.Tag): Boolean = tag.id.contains(id)

  def set(value: Seq[View]): Diff = Diff.ReplaceChildren(this, value)
  def set(value: View): Diff = set(Seq(value))
  def remove(): Diff = Diff.RemoveChild(this)
  def append(value: View): Diff = Diff.AppendChild(this, value)

  def :=(value: Seq[View]) = set(value)
  def :=(value: View) = set(value)
  def +=(value: View) = append(value)
}

object NodeRef {
  def apply[T <: tree.Tag](baseId: String)(implicit id: ViewId, idMap: IdMap): NodeRef[T] =
    NodeRef[T](baseId, id.value, idMap)
}
