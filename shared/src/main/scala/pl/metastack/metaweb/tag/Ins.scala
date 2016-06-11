package pl.metastack.metaweb.tag

import pl.metastack.metaweb.tree

/**
 * The <strong>HTML <code>&lt;ins&gt;</code> Element</strong> (or <em>HTML Inserted Text</em>) HTML represents a range of text that has been added to a document.
 */
case class Ins(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[tree.Node] = Seq.empty) extends tree.Tag with HTMLTag {
  override def tagName = "ins"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[tree.Node] = children): Ins = Ins(attributes, children)
  /**
   * This attribute defines the URI of a resource that explains the change, like a link to some meeting minutes or a ticket in a troubleshooting sytem.
   */
  def cite: scala.Option[String] = attributes.get("cite").asInstanceOf[scala.Option[String]]
  /**
   * This attribute indicates the time and date of the change and must be a 
<a class="external" href="http://www.w3.org/TR/2011/WD-html5-20110525/common-microsyntaxes.html#valid-date-string-with-optional-time" title="http://www.w3.org/TR/html5/common-microsyntaxes.html#valid-date-string-with-optional-time">valid date with an optional time string</a>. If the value cannot be parsed as a date with an optional time string, the element does not have an associated time stamp.
   */
  def datetime: scala.Option[String] = attributes.get("datetime").asInstanceOf[scala.Option[String]]
}
