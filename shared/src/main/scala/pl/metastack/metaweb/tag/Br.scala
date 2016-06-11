package pl.metastack.metaweb.tag

import pl.metastack.metaweb.tree

/**
 * The <strong>HTML <code>&lt;br&gt;</code> Element</strong> (or <em>HTML </em><em>Line Break Element</em>) produces a line break in text (carriage-return). It is useful for writing a poem or an address, where the division of lines is significant.
Do not use <code>&lt;br&gt;</code> to increase the gap between lines of text; use the <a href="/en-US/docs/CSS" title="CSS">CSS</a> <a href="/en-US/docs/Web/CSS/margin"><code>margin</code></a> property or the <a href="/en-US/docs/Web/HTML/Element/p" title="The HTML <p> element (or HTML Paragraph Element) represents a paragraph of text."><code>&lt;p&gt;</code></a> element.
 */
case class Br(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[tree.Node] = Seq.empty) extends tree.Tag with HTMLTag {
  override def tagName = "br"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[tree.Node] = children): Br = Br(attributes, children)
  /**
   * Indicates where to begin the next line after the break. 
<div class="note"> 
 <p><strong>Usage note: </strong>This attribute is obsolete in <span class="inlineIndicator htmlVer htmlVerInline"><a href="/en-US/docs/HTML/HTML5">HTML5</a></span> and <strong>should not be used by authors</strong>. Use the CSS <a href="/en-US/docs/Web/CSS/clear"><code>clear</code></a> property instead.</p> 
</div>
   */
  def clear: scala.Option[String] = attributes.get("clear").asInstanceOf[scala.Option[String]]
}
