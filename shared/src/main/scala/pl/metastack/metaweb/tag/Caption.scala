package pl.metastack.metaweb.tag

import pl.metastack.metaweb.tree

/**
 * The <strong>HTML <code>&lt;caption&gt;</code> Element</strong> (or <em>HTML Table Caption Element</em>) represents the title of a table. Though it is always the first descendant of a <a href="/en-US/docs/Web/HTML/Element/table" title="The HTML Table Element (<table>) represents data in two dimensions or more."><code>&lt;table&gt;</code></a>, its styling, using CSS, may place it elsewhere, relative to the table.
<strong>Usage note</strong>: When the 
<a href="/en-US/docs/Web/HTML/Element/table" title="The HTML Table Element (<table>) represents data in two dimensions or more."><code>&lt;table&gt;</code></a> element that is the parent of this 
<a href="/en-US/docs/Web/HTML/Element/caption" title="The HTML <caption> Element (or HTML Table Caption Element) represents the title of a table. Though it is always the first descendant of a <table>, its styling, using CSS, may place it elsewhere, relative to the table."><code>&lt;caption&gt;</code></a> is the only descendant of a 
<a href="/en-US/docs/Web/HTML/Element/figure" title="The HTML <figure> Element represents self-contained content, frequently with a caption&nbsp;(<figcaption>), and is&nbsp;typically referenced as a single unit. While it is related to the main flow, its position is independent of the main flow. Usually this is an image, an illustration, a diagram, a code snippet, or a schema that is referenced in the main text, but that can be moved to another page or to an appendix without affecting the main flow."><code>&lt;figure&gt;</code></a> element, use the 
<a href="/en-US/docs/Web/HTML/Element/figcaption" title="The HTML <figcaption> Element represents a caption or a legend associated with a figure or an illustration described by the rest of the data of the <figure> element which is its immediate ancestor which means <figcaption> can be the first or last element inside a <figure> block.&nbsp;Also, the HTML Figcaption Element&nbsp;is optional; if not provided, then the parent figure element will have no caption."><code>&lt;figcaption&gt;</code></a> element instead.
 */
case class Caption(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[tree.Node] = Seq.empty) extends HTMLTag[Caption] {
  override def tagName = "caption"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[tree.Node] = children): Caption = Caption(attributes, children)
  /**
   * This enumerated attribute indicates how the caption must be aligned with respect to the table. It may have the following values: 
<ul> 
 <li><code>left</code>, displayed to the left of the table</li> 
 <li><code>top</code>, displayed before the the table</li> 
 <li><code>right</code>, displayed to the right of the table</li> 
 <li><code>bottom</code>, displayed under the table</li> 
</ul> 
<div class="note"> 
 <strong>Usage note: </strong>Do not use this attribute, as it has been deprecated: the 
 <a href="/en-US/docs/Web/HTML/Element/caption" title="The HTML <caption> Element (or HTML Table Caption Element) represents the title of a table. Though it is always the first descendant of a <table>, its styling, using CSS, may place it elsewhere, relative to the table."><code>&lt;caption&gt;</code></a> element should be styled using 
 <a href="/en-US/docs/CSS" title="CSS">CSS</a>. To give a similar effect to the 
 <code>align</code> attribute, use the the 
 <a href="/en-US/docs/CSS" title="CSS">CSS</a> properties 
 <a href="/en-US/docs/Web/CSS/caption-side" title="The caption-side CSS property positions the content of a table's <caption> on the specified side."><code>caption-side</code></a> and 
 <a href="/en-US/docs/Web/CSS/text-align" title="The text-align CSS property describes how inline content like text is aligned in its parent block element. text-align does not control the alignment of block elements itself, only their inline content."><code>text-align</code></a>.
</div>
   */
  def align: scala.Option[String] = attributes.get("align").asInstanceOf[scala.Option[String]]
  def align(value: String): Caption = copy(attributes = attributes + ("align" -> value)).asInstanceOf[Caption]
}
