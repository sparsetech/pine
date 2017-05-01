package pl.metastack.metaweb.tag

import pl.metastack.metaweb._

/**
 * The <em>HTML Preformatted Text</em>&nbsp;(<strong>&lt;pre&gt;</strong>)&nbsp;represents preformatted text. Text within this element is typically displayed in a non-proportional font exactly as it is laid out in the file. Whitespaces inside this element are displayed as typed.
 */
case class Pre(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[Node] = Seq.empty) extends HTMLTag {
  override type T = Pre
  override def tagName = "pre"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[Node] = children): Pre = Pre(attributes, children)
  /**
   * Contains the 
<em>preferred</em> count of characters that a line should have. It was a non-standard synonym of 
<code><a href="/en-US/docs/Web/HTML/Element/pre#attr-width">width</a></code>. To achieve such an effect, use CSS styling instead.
   */
  def cols: scala.Option[String] = attributes.get("cols").asInstanceOf[scala.Option[String]]
  def cols(value: String): Pre = copy(attributes = attributes + ("cols" -> value))
  /**
   * Contains the 
<em>preferred</em> count of characters that a line should have. Though technically still implemented, this attribute has no visual effect; to achieve such an effect, use CSS styling instead.
   */
  def width: scala.Option[String] = attributes.get("width").asInstanceOf[scala.Option[String]]
  def width(value: String): Pre = copy(attributes = attributes + ("width" -> value))
  /**
   * Is a 
<em>hint</em> indicating how the overflow must happen. In modern browser this hint is ignored and no visual effect results in its present; to achieve such an effect, use CSS styling instead.
   */
  def wrap: scala.Option[String] = attributes.get("wrap").asInstanceOf[scala.Option[String]]
  def wrap(value: String): Pre = copy(attributes = attributes + ("wrap" -> value))
}
