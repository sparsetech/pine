package pine.tag

import pine._

/**
 * The <strong>HTML <code>&lt;embed&gt;</code> Element</strong> represents an integration point for an external application or interactive content (in other words, a plug-in).

<strong>Note:</strong>&nbsp;This topic documents only the element that is defined as part of HTML5. It does not address earlier, non-standardized implementation of the element.

 */
case class Embed(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[Node] = Seq.empty) extends HTMLTag {
  override type T = Embed
  override def tagName = "embed"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[Node] = children): Embed = Embed(attributes, children)
  /**
   * The displayed height of the resource, in CSS pixels.
   */
  def height: scala.Option[String] = attributes.get("height").asInstanceOf[scala.Option[String]]
  def height(value: String): Embed = copy(attributes = attributes + ("height" -> value))
  /**
   * The URL&nbsp;of the resource being embedded.
   */
  def src: scala.Option[String] = attributes.get("src").asInstanceOf[scala.Option[String]]
  def src(value: String): Embed = copy(attributes = attributes + ("src" -> value))
  /**
   * The MIME&nbsp;type to use to select the plug-in to instantiate.
   */
  def `type`: scala.Option[String] = attributes.get("type").asInstanceOf[scala.Option[String]]
  def `type`(value: String): Embed = copy(attributes = attributes + ("type" -> value))
  /**
   * The displayed width of the resource, in CSS pixels.
   */
  def width: scala.Option[String] = attributes.get("width").asInstanceOf[scala.Option[String]]
  def width(value: String): Embed = copy(attributes = attributes + ("width" -> value))
}
