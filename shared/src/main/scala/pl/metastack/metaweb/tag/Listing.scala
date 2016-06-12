package pl.metastack.metaweb.tag

import pl.metastack.metaweb.tree

/**
 * The <em>HTML Listing Element</em> (<code>&lt;listing&gt;</code>) renders text between the start and end tags without interpreting the HTML in between and using a monospaced font. The HTML 2 standard recommended that lines shouldn't be broken when not greater than 132 characters.
<strong>Note: </strong>Do not use this element. 
<ul> 
 <li>It is deprecated since HTML 3.2 and was neither implemented by all browsers, nor in a consistent way. Even more it is obsoleted in HTML5 and may be rendered by conforming user-agents as the <a href="/en-US/docs/Web/HTML/Element/pre" title="The HTML <pre> Element (or HTML Preformatted Text) represents preformatted text. Text within this element is typically displayed in a non-proportional font exactly as it is laid out in the file. Whitespaces inside this element are displayed as typed."><code>&lt;pre&gt;</code></a> element, which will interpret the internal HTML!</li> 
 <li>Instead use the <a href="/en-US/docs/Web/HTML/Element/pre" title="The HTML <pre> Element (or HTML Preformatted Text) represents preformatted text. Text within this element is typically displayed in a non-proportional font exactly as it is laid out in the file. Whitespaces inside this element are displayed as typed."><code>&lt;pre&gt;</code></a> element or if semantically adequate the <a href="/en-US/docs/Web/HTML/Element/code" title="The HTML <code> Element represents a fragment of computer code. By default, it is displayed in the browser's default monospace font."><code>&lt;code&gt;</code></a> element, eventually escaping the HTML '<code>&lt;</code>' and '<code>&gt;</code>' so that they don't get interpreted.</li> 
 <li>A monospaced font can also be obtained on a simple <a href="/en-US/docs/Web/HTML/Element/div" title="The HTML <div> element (or HTML Document Division Element) is the generic container for flow content, which does not inherently represent anything. It can be used to group elements for styling purposes (using the class or id attributes), or because they share attribute values, such as lang. It should be used only when no other semantic element (such as <article> or <nav>) is appropriate."><code>&lt;div&gt;</code></a> element, by applying an adequate <a href="/en-US/docs/Web/CSS" title="CSS">CSS</a> style using <code>monospace</code> as the generic-font value in a <a href="/en-US/docs/Web/CSS/font-family" title=""><code>font-family</code></a> property.</li> 
</ul>
 */
case class Listing(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[tree.Node] = Seq.empty) extends HTMLTag[Listing] {
  override def tagName = "listing"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[tree.Node] = children): Listing = Listing(attributes, children)
}
