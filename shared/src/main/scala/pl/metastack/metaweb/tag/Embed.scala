package pl.metastack.metaweb.tag

import pl.metastack.metaweb.tree

/**
 * The <strong>HTML <code>&lt;embed&gt;</code> Element</strong> represents an integration point for an external application or interactive content (in other words, a plug-in).

<strong>Note:</strong>&nbsp;This topic documents only the element that is defined as part of HTML5. It does not address earlier, non-standardized implementation of the element.

 */
case class Embed(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[tree.Node] = Seq.empty) extends tree.Tag with HTMLTag {
  override def tagName = "embed"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[tree.Node] = children): Embed = Embed(attributes, children)
  /**
   * The displayed height of the resource, in CSS pixels.
   */
  def height: scala.Option[String] = attributes.get("height").asInstanceOf[scala.Option[String]]
  /**
   * The URL&nbsp;of the resource being embedded.
   */
  def src: scala.Option[String] = attributes.get("src").asInstanceOf[scala.Option[String]]
  /**
   * The MIME&nbsp;type to use to select the plug-in to instantiate.
   */
  def `type`: scala.Option[String] = attributes.get("type").asInstanceOf[scala.Option[String]]
  /**
   * The displayed width of the resource, in CSS pixels.
   */
  def width: scala.Option[String] = attributes.get("width").asInstanceOf[scala.Option[String]]
}
