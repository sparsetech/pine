package pl.metastack.metaweb.tag

import pl.metastack.metaweb.tree

/**
 * The <strong>HTML <code>&lt;header&gt;</code> Element</strong> represents a group of introductory or navigational aids. It may contain some heading elements but also other elements like a logo, wrapped section's header, a search form, and so on.
<p><strong>Usage note:</strong></p> 
<ul> 
 <li>The <code>&lt;header&gt;</code> element is not sectioning content and therefore doesn't introduce a new section in the <a href="/en-US/docs/Sections_and_Outlines_of_an_HTML5_document" title="Sections and Outlines of an HTML5 document">outline</a>.</li> 
</ul>
 */
case class Header(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[tree.Node] = Seq.empty) extends HTMLTag {
  override type T = Header
  override def tagName = "header"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[tree.Node] = children): Header = Header(attributes, children)
}
