package pl.metastack.metaweb.tag

import pl.metastack.metaweb._

/**
 * The <em>HTML Strikethrough Element</em> (<code>&lt;strike&gt;</code>) renders text with a strikethrough, or a line through it.
<strong>Usage Note: </strong>As with all purely styling elements, 
<a href="/en-US/docs/Web/HTML/Element/strike" title="This article hasn't been written yet. Please consider contributing!"><code>&lt;strike&gt;</code></a> has been deprecated in HTML 4 and XHTML 1, and obsoleted in HTML5. If semantically appropriate, i.e., if it represents 
<em>deleted</em> content, use the 
<a href="/en-US/docs/Web/HTML/Element/del" title="This article hasn't been written yet. Please consider contributing!"><code>&lt;del&gt;</code></a> instead; in all other cases use a 
<a href="/en-US/docs/Web/HTML/Element/span" title="The HTML <span> element is a generic inline container for phrasing content, which does not inherently represent anything. It can be used to group elements for styling purposes (using the class or id attributes), or because they share attribute values, such as lang. It should be used only when no other semantic element is appropriate. <span> is very much like a <div> element, but <div> is a block-level element whereas a <span> is an inline element."><code>&lt;span&gt;</code></a> element and style it with the 
<a href="/en-US/docs/CSS" title="CSS">CSS</a> 
<a href="/en-US/docs/Web/CSS/text-decoration" title=""><code>text-decoration</code></a> property, with the 
<code>line-through</code> value.
 */
case class Strike(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[Node] = Seq.empty) extends HTMLTag {
  override type T = Strike
  override def tagName = "strike"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[Node] = children): Strike = Strike(attributes, children)
}
