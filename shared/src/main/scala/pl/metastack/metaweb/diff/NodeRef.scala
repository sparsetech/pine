package pl.metastack.metaweb.diff

import pl.metastack.metaweb._
import pl.metastack.metaweb.dsl.Display

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

  /** Sets `style` to `display: none` if `state` is true, otherwise
    * sets `style` to `showDisplay` (empty string if None).
    */
  def hide(state: Boolean, showDisplay: Option[Display] = None): Diff =
    style := (
      if (state) Display.None.property
      else showDisplay.map(_.property).getOrElse(""))

  // TODO Generate and make available via implicits
  val href    = new Attribute[T, Option[String], String](this, "href")
  val value   = new Attribute[T, Option[String], String](this, "value")
  val style   = new Attribute[T, Option[String], String](this, "style")
  val `class` = new Attribute[T, Option[String], String](this, "class")
  val checked = new Attribute[T, Boolean, Boolean](this, "checked")
}

object NodeRef {
  def apply[T <: tree.Tag](baseId: String)(implicit id: ViewId, idMap: IdMap): NodeRef[T] =
    NodeRef[T](baseId, id.value, idMap)
}
