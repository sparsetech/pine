package pl.metastack.metaweb.tag

import pl.metastack.metaweb.tree

/**
 * The <em>HTML Navigation Element</em> (<code>&lt;nav&gt;</code>) represents a section of a page that links to other pages or to parts within the page: a section with navigation links.
<p><em>Usage notes:</em></p> 
<ul> 
 <li>Not all links of a document must be in a <code>&lt;nav&gt;</code> element, which is intended only for major block of navigation links; typically the <a href="/en-US/docs/Web/HTML/Element/footer" title="The HTML Footer Element (<footer>) represents a footer for its nearest sectioning content or sectioning root element. A footer typically contains information about the author of the section, copyright data or links to related documents."><code>&lt;footer&gt;</code></a> element often has a list of links that don't need to be in a <a href="/en-US/docs/Web/HTML/Element/nav" title="The HTML Navigation Element (<nav>) represents a section of a page that links to other pages or to parts within the page: a section with navigation links."><code>&lt;nav&gt;</code></a> element.</li> 
 <li>A document may have several <a href="/en-US/docs/Web/HTML/Element/nav" title="The HTML Navigation Element (<nav>) represents a section of a page that links to other pages or to parts within the page: a section with navigation links."><code>&lt;nav&gt;</code></a> elements, for example, one for site navigation and one for intra-page navigation.</li> 
 <li>User agents, such as screen readers targeting disabled users, can use this element to determine whether to omit the initial rendering of this content.</li> 
</ul>
 */
case class Nav(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[tree.Node] = Seq.empty) extends HTMLTag[Nav] {
  override def tagName = "nav"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[tree.Node] = children): Nav = Nav(attributes, children)
}
