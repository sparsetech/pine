package pl.metastack.metaweb.tag

import pl.metastack.metaweb._

/**
 * The <em>HTML Footer Element</em> (<strong>&lt;footer&gt;</strong>) represents a footer for its nearest <a href="/en-US/docs/Web/Guide/HTML/Sections_and_Outlines_of_an_HTML5_document#Defining_Sections_in_HTML5">sectioning content</a> or <a href="/en-US/docs/Web/Guide/HTML/Sections_and_Outlines_of_an_HTML5_document#Sectioning_root" title="Sections and Outlines of an HTML5 document#Sectioning root">sectioning root</a> element. A footer typically contains information about the author of the section, copyright data or links to related documents.
<p><strong>Usage notes:</strong></p> 
<ul> 
 <li>Enclose information about the author in an <a href="/en-US/docs/Web/HTML/Element/address" title="The HTML <address> Element may be used by authors to supply contact information for its nearest <article> or <body> ancestor; in the latter case, it applies to the whole document."><code>&lt;address&gt;</code></a> element that can be included into the <code>&lt;footer&gt;</code> element.</li> 
 <li>The <code>&lt;footer&gt;</code> element is not sectioning content and therefore doesn't introduce a new section in the <a href="/en-US/docs/Sections_and_Outlines_of_an_HTML5_document" title="Sections and Outlines of an HTML5 document">outline</a>.</li> 
</ul>
 */
case class Footer(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[Node] = Seq.empty) extends HTMLTag {
  override type T = Footer
  override def tagName = "footer"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[Node] = children): Footer = Footer(attributes, children)
}
