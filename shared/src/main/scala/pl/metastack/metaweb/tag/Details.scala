package pl.metastack.metaweb.tag

import pl.metastack.metaweb.tree

/**
 * The <em>HTML Details&nbsp;Element</em>&nbsp;(<code><strong>&lt;details&gt;</strong></code>) is used as a disclosure widget from which the user can retrieve additional information.
 */
case class Details(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[tree.Node] = Seq.empty) extends HTMLTag {
  override type T = Details
  override def tagName = "details"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[tree.Node] = children): Details = Details(attributes, children)
  /**
   * This Boolean attribute indicates whether the details will be shown to the user on page load. Default is 
<code>false</code> and so details will be hidden.
   */
  def open: scala.Option[String] = attributes.get("open").asInstanceOf[scala.Option[String]]
  def open(value: String): Details = copy(attributes = attributes + ("open" -> value))
}
