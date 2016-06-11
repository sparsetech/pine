package pl.metastack.metaweb.tag

import pl.metastack.metaweb.tree

/**
 * The <strong>HTML <code>&lt;figure&gt;</code> Element</strong> represents self-contained content, frequently with a caption&nbsp;(<a href="/en-US/docs/Web/HTML/Element/figcaption" title="The HTML <figcaption> Element represents a caption or a legend associated with a figure or an illustration described by the rest of the data of the <figure> element which is its immediate ancestor which means <figcaption> can be the first or last element inside a <figure> block.&nbsp;Also, the HTML Figcaption Element&nbsp;is optional; if not provided, then the parent figure element will have no caption."><code>&lt;figcaption&gt;</code></a>)<em><code>,</code></em> and is&nbsp;typically referenced as a single unit. While it is related to the main flow, its position is independent of the main flow. Usually this is an image, an illustration, a diagram, a code snippet, or a schema that is referenced in the main text, but that can be moved to another page or to an appendix without affecting the main flow.
<p><em>Usage notes: </em></p> 
<ul> 
 <li>Being a <a href="/en-US/docs/Sections_and_Outlines_of_an_HTML5_document#Sectioning_root" title="Sections and Outlines of an HTML5 document#Sectioning root">sectioning root</a>, the outline of the content of the <span style="font-family: courier new;">&lt;figure&gt; </span>element is excluded from the main outline of the document.</li> 
 <li>A caption can be associated with the <code>&lt;figure&gt;</code> element by inserting a <a href="/en-US/docs/Web/HTML/Element/figcaption" title="The HTML <figcaption> Element represents a caption or a legend associated with a figure or an illustration described by the rest of the data of the <figure> element which is its immediate ancestor which means <figcaption> can be the first or last element inside a <figure> block.&nbsp;Also, the HTML Figcaption Element&nbsp;is optional; if not provided, then the parent figure element will have no caption."><code>&lt;figcaption&gt;</code></a> inside it (as the first or the last child).</li> 
</ul>
 */
case class Figure(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[tree.Node] = Seq.empty) extends tree.Tag with HTMLTag {
  override def tagName = "figure"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[tree.Node] = children): Figure = Figure(attributes, children)
}
