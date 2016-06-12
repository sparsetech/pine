package pl.metastack.metaweb.tag

import pl.metastack.metaweb.tree

/**
 * <code>&lt;frameset&gt;</code> is an HTML element which is used to contain <a href="/en-US/docs/Web/HTML/Element/frame" title="<frame> is an HTML element which defines a particular area in which another HTML document can be displayed. A frame should be used within a <frameset>."><code>&lt;frame&gt;</code></a> elements.
<strong>Note:</strong> Because the use of frames is now discouraged in favor of using 
<a href="/en-US/docs/Web/HTML/Element/iframe" title="The HTML <iframe> Element (or HTML inline frame element) represents a nested browsing context, effectively embedding another HTML page into the current page. In HTML 4.01, a document may contain a head and a body or a head and a frame-set, but not both a body and a frame-set. However, an <iframe> can be used within a normal document body. Each browsing context has its own session history and active document. The browsing context that contains the embedded content is called the parent browsing context. The top-level browsing context (which has no parent) is typically the browser window."><code>&lt;iframe&gt;</code></a>, this element is not typically used by modern web sites.
 */
case class Frameset(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[tree.Node] = Seq.empty) extends HTMLTag[Frameset] {
  override def tagName = "frameset"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[tree.Node] = children): Frameset = Frameset(attributes, children)
  /**
   * This attribute specifies the number and size of horizontal spaces in a frameset.
   */
  def cols: scala.Option[String] = attributes.get("cols").asInstanceOf[scala.Option[String]]
  def cols(value: String): Frameset = copy(attributes = attributes + ("cols" -> value)).asInstanceOf[Frameset]
  /**
   * This attribute specifies the number and size of vertical spaces in a frameset.
   */
  def rows: scala.Option[String] = attributes.get("rows").asInstanceOf[scala.Option[String]]
  def rows(value: String): Frameset = copy(attributes = attributes + ("rows" -> value)).asInstanceOf[Frameset]
}
