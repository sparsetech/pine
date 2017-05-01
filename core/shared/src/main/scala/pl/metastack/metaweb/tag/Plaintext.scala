package pl.metastack.metaweb.tag

import pl.metastack.metaweb._

/**
 * The <em>HTML Plaintext Element</em> (<code>&lt;plaintext&gt;</code>) renders everything following the start tag as raw text, without interpreting any HTML. There is no closing tag, since everything after it is considered raw text.
<strong>Note: </strong>Do not use this element.&nbsp; 
<ul> 
 <li>This element has been deprecated since HTML 2 and was never implemented by all browsers; even those that did implement it didn't do so consistently. In addition, it is obsoleted in HTML 5; browsers that still accept it may simply treat it as a <a href="/en-US/docs/Web/HTML/Element/pre" title="The HTML <pre> Element (or HTML Preformatted Text) represents preformatted text. Text within this element is typically displayed in a non-proportional font exactly as it is laid out in the file. Whitespaces inside this element are displayed as typed."><code>&lt;pre&gt;</code></a> element, which still interprets HTML within, even though that's not what you probably want.</li> 
 <li>If the <a href="/en-US/docs/Web/HTML/Element/plaintext" title="Editorial review completed."><code>&lt;plaintext&gt;</code></a> element is the first element on the page (other than any non-displayed elements), do not use HTML at all. Configure your server to send your page with the <code>text/plain</code> <a href="/en-US/docs/Properly_Configuring_Server_MIME_Types" title="Properly Configuring Server MIME Types">MIME-type</a>.</li> 
 <li>Instead of using this element, you should use the <a href="/en-US/docs/Web/HTML/Element/pre" title="The HTML <pre> Element (or HTML Preformatted Text) represents preformatted text. Text within this element is typically displayed in a non-proportional font exactly as it is laid out in the file. Whitespaces inside this element are displayed as typed."><code>&lt;pre&gt;</code></a> element or, if semantically adequate, the <a href="/en-US/docs/Web/HTML/Element/code" title="The HTML <code> Element represents a fragment of computer code. By default, it is displayed in the browser's default monospace font."><code>&lt;code&gt;</code></a> element. Be sure to escape any "&lt;", "&gt;" and "&amp;" characters, to avoid inadvertently interpreting content as HTML.</li> 
 <li>A monospaced font can also be applied to a simple <a href="/en-US/docs/Web/HTML/Element/div" title="The HTML <div> element (or HTML Document Division Element) is the generic container for flow content, which does not inherently represent anything. It can be used to group elements for styling purposes (using the class or id attributes), or because they share attribute values, such as lang. It should be used only when no other semantic element (such as <article> or <nav>) is appropriate."><code>&lt;div&gt;</code></a> element by applying an adequate <a href="/en-US/docs/Web/CSS">CSS</a> style using <code>monospace</code> as the generic-font value in a <a href="/en-US/docs/Web/CSS/font-family" title=""><code>font-family</code></a> property.</li> 
</ul>
 */
case class Plaintext(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[Node] = Seq.empty) extends HTMLTag {
  override type T = Plaintext
  override def tagName = "plaintext"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[Node] = children): Plaintext = Plaintext(attributes, children)
}
