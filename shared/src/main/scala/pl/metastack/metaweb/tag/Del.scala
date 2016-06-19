package pl.metastack.metaweb.tag

import pl.metastack.metaweb.tree

/**
 * The&nbsp;<em>HTML Deleted Text Element</em>&nbsp;(<strong>&lt;del&gt;</strong>) represents a range of text that has been deleted from a document. This element is often (but need not be) rendered with strike-through text.
 */
case class Del(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[tree.Node] = Seq.empty) extends HTMLTag {
  override type T = Del
  override def tagName = "del"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[tree.Node] = children): Del = Del(attributes, children)
  /**
   * A URI for a resource that explains the change (for example, meeting minutes).
   */
  def cite: scala.Option[String] = attributes.get("cite").asInstanceOf[scala.Option[String]]
  def cite(value: String): Del = copy(attributes = attributes + ("cite" -> value))
  /**
   * This attribute indicates the time and date of the change and must be a 
<a href="http://www.w3.org/TR/html5/infrastructure.html#valid-date-string-with-optional-time" class="external" title="http://www.w3.org/TR/html5/common-microsyntaxes.html#valid-date-string-with-optional-time">valid date with an optional time string</a>. If the value cannot be parsed as a date with an optional time string, the element does not have an associated time stamp.
   */
  def datetime: scala.Option[String] = attributes.get("datetime").asInstanceOf[scala.Option[String]]
  def datetime(value: String): Del = copy(attributes = attributes + ("datetime" -> value))
}
