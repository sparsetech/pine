package pine.tag

import pine._

/**
 * The <em>HTML Style Element</em> (<strong>&lt;style&gt;</strong>) contains style information for a document, or part of a document. By default, the style instructions written inside that element are expected to be <a href="/en-US/docs/Web/CSS">CSS</a>.
 */
case class Style(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[Node] = Seq.empty) extends HTMLTag {
  override type T = Style
  override def tagName = "style"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[Node] = children): Style = Style(attributes, children)
  /**
   * This attribute defines the styling language as a MIME type (charset should not be specified). This attribute is optional and default to 
<code>text/css</code> if it's missing.
   */
  def `type`: scala.Option[String] = attributes.get("type").asInstanceOf[scala.Option[String]]
  def `type`(value: String): Style = copy(attributes = attributes + ("type" -> value))
  /**
   * Which media should this style apply to. It's value is a 
<a href="/en-US/docs/Web/Guide/CSS/Media_queries">media query</a>, which default to 
<code>all</code> if the attribute is missing.
   */
  def media: scala.Option[String] = attributes.get("media").asInstanceOf[scala.Option[String]]
  def media(value: String): Style = copy(attributes = attributes + ("media" -> value))
  /**
   * If this attribute is present, then the style applies only to its parent element. If absent, the style applies to the whole document.
   */
  def scoped: scala.Option[String] = attributes.get("scoped").asInstanceOf[scala.Option[String]]
  def scoped(value: String): Style = copy(attributes = attributes + ("scoped" -> value))
  /**
   * If set, disables (does not apply) the style rules,&nbsp;specified within the element, to the 
<a href="/en-US/docs/Web/API/Document" title="Each web page loaded in the browser has its own document object. The Document interface serves as an entry point into the web page's content (the DOM tree, including elements such as <body> and <table>) and provides functionality which is global to the document (such as obtaining the page's URL and creating new elements in the document)."><code>Document</code></a>.
   */
  def disabled: scala.Option[String] = attributes.get("disabled").asInstanceOf[scala.Option[String]]
  def disabled(value: String): Style = copy(attributes = attributes + ("disabled" -> value))
}
