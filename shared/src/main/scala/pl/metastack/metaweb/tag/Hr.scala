package pl.metastack.metaweb.tag

import pl.metastack.metaweb.tree

/**
 * The <strong>HTML <code>&lt;hr&gt;</code> element</strong> represents a thematic break between paragraph-level elements (for example, a change of scene in a story, or a shift of topic with a section). In previous versions of HTML, it represented a horizontal rule. It may still be displayed as a horizontal rule in visual browsers, but is now defined in semantic terms, rather than presentational terms.
 */
case class Hr(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[tree.Node] = Seq.empty) extends tree.Tag with HTMLTag {
  override def tagName = "hr"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[tree.Node] = children): Hr = Hr(attributes, children)
  /**
   * Sets the alignment of the rule on the page. If no value is specified, the default value is 
<code>left</code>.
   */
  def align: scala.Option[String] = attributes.get("align").asInstanceOf[scala.Option[String]]
  /**
   * Sets the color of the rule through color name or hexadecimal value.
   */
  def color: scala.Option[String] = attributes.get("color").asInstanceOf[scala.Option[String]]
  /**
   * Sets the rule to have no shading.
   */
  def noshade: scala.Option[Boolean] = attributes.get("noshade").asInstanceOf[scala.Option[Boolean]]
  /**
   * Sets the height, in pixels, of the rule.
   */
  def size: scala.Option[String] = attributes.get("size").asInstanceOf[scala.Option[String]]
  /**
   * Sets the length of the rule on the page through a pixel or percentage value.
   */
  def width: scala.Option[String] = attributes.get("width").asInstanceOf[scala.Option[String]]
}
