package pl.metastack.metaweb.tag

import pl.metastack.metaweb._

/**
 * The <em>HTML Example Element</em> (<code>&lt;xmp&gt;</code>) renders text between the start and end tags without interpreting the HTML in between and using a monospaced font. The HTML2 specification recommended that it should be rendered wide enough to allow 80 characters per line.
<strong>Note: </strong>Do not use this element. 
<ul> 
 <li>It has been deprecated since HTML3.2 and was not implemented in a consistent way. It was completely removed from the language in HTML5.</li> 
 <li>Use the <a href="/en-US/docs/Web/HTML/Element/pre" title="The HTML <pre> Element (or HTML Preformatted Text) represents preformatted text. Text within this element is typically displayed in a non-proportional font exactly as it is laid out in the file. Whitespaces inside this element are displayed as typed."><code>&lt;pre&gt;</code></a> element or, if semantically adequate, the <a href="/en-US/docs/Web/HTML/Element/code" title="The HTML <code> Element represents a fragment of computer code. By default, it is displayed in the browser's default monospace font."><code>&lt;code&gt;</code></a> element instead. Note that you will need to escape the '<code>&lt;</code>' character as '<code>&amp;lt;</code>' to make sure it is not interpreted as markup.</li> 
 <li>A monospaced font can also be obtained on any element, by applying an adequate <a href="/en-US/docs/CSS" title="CSS">CSS</a> style using <code>monospace</code> as the generic-font value for the <a href="/en-US/docs/Web/CSS/font-family" title=""><code>font-family</code></a> property.</li> 
</ul>
 */
case class Xmp(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[Node] = Seq.empty) extends HTMLTag {
  override type T = Xmp
  override def tagName = "xmp"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[Node] = children): Xmp = Xmp(attributes, children)
}
