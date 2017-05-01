package pl.metastack.metaweb.tag

import pl.metastack.metaweb._

/**
 * The HTML basefont element (<code>&lt;basefont&gt;</code>) establishes a default font size for a document. Font size then can be varied relative to the base font size using the <a href="/en-US/docs/Web/HTML/Element/font" title="The HTML Font Element (<font>) defines the font size, color and face for its content."><code>&lt;font&gt;</code></a> element.
<p><em>Usage note: </em></p> 
<p><strong>Do not use this element! </strong>Though once (imprecisely) normalized in HTML 3.2, it wasn't supported in all major browsers. Further, browsers, and even successive versions of browsers, never implemented it in the same way: practically, using it has always brought <em>indeterminate</em> results.</p> 
<p>The <code>&lt;basefont&gt; </code>element was deprecated in the standard at the same time as all elements related to styling only. Starting with HTML 4, HTML does not convey styling information anymore (outside the <a href="/en-US/docs/Web/HTML/Element/style" title="The HTML <style> element contains style information for a document, or a part of document. The specific style information is contained inside of this element, usually in the CSS."><code>&lt;style&gt;</code></a> element or the <strong>style</strong> attribute of each element). In HTML5, this element has been removed completely. For any new web development, styling should be written using <a href="/en-US/docs/CSS" title="CSS">CSS</a> only.</p> 
<p>The former behavior of the <a href="/en-US/docs/Web/HTML/Element/font" title="The HTML Font Element (<font>) defines the font size, color and face for its content."><code>&lt;font&gt;</code></a> element can be achieved, and even better controlled using the <a href="/en-US/docs/Web/CSS/font" title=""><code>font</code></a>, <a href="/en-US/docs/Web/CSS/font-family" title=""><code>font-family</code></a>, <a href="/en-US/docs/Web/CSS/font-size" title=""><code>font-size</code></a>, <a href="/en-US/docs/Web/CSS/font-size-adjust" title=""><code>font-size-adjust</code></a>, <a href="/en-US/docs/Web/CSS/font-stretch" title=""><code>font-stretch</code></a>, <a href="/en-US/docs/Web/CSS/font-style" title=""><code>font-style</code></a>, <a href="/en-US/docs/Web/CSS/font-variant" title=""><code>font-variant</code></a>, <a href="/en-US/docs/Web/CSS/font-weight" title=""><code>font-weight</code></a>, <a href="/en-US/docs/Web/CSS/@font-face" title=""><code>@font-face</code></a> properties.</p>
 */
case class Basefont(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[Node] = Seq.empty) extends HTMLTag {
  override type T = Basefont
  override def tagName = "basefont"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[Node] = children): Basefont = Basefont(attributes, children)
  /**
   * This attribute sets the text color using either a named color or a color specified in the hexadecimal #RRGGBB format.
   */
  def color: scala.Option[String] = attributes.get("color").asInstanceOf[scala.Option[String]]
  def color(value: String): Basefont = copy(attributes = attributes + ("color" -> value))
  /**
   * This attribute contains a list of one or more font names. The document text in the default style is rendered in the first font face that the client's browser supports. If no font listed is installed on the local system, the browser typically defaults to the proportional or fixed-width font for that system.
   */
  def face: scala.Option[String] = attributes.get("face").asInstanceOf[scala.Option[String]]
  def face(value: String): Basefont = copy(attributes = attributes + ("face" -> value))
  /**
   * This attribute specifies the font size as either a numeric or relative value. Numeric values range from 1 to 7 with 1 being the smallest and 3 the default.
   */
  def size: scala.Option[String] = attributes.get("size").asInstanceOf[scala.Option[String]]
  def size(value: String): Basefont = copy(attributes = attributes + ("size" -> value))
}
