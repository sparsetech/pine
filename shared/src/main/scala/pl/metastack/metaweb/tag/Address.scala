package pl.metastack.metaweb.tag

import pl.metastack.metaweb.tree

/**
 * The <em>HTML <code>Address</code> Element</em> (<strong>&lt;address&gt;</strong>) should be used by authors to supply contact information for its nearest <a href="/en-US/docs/Web/HTML/Element/article" title="The HTML Article Element (<article>) represents a self-contained composition in a document, page, application, or site, which is intended to be independently distributable or reusable, e.g., in syndication. This could be a forum post, a magazine or newspaper article, a blog entry, or any other independent item of content. Each <article> should be identified, typically by including a heading (h1-h6 element) as a child of the <article> element."><code>&lt;article&gt;</code></a> or <a href="/en-US/docs/Web/HTML/Element/body" title="The HTML Body Element (<body>) represents the content of an HTML&nbsp;document. There can be only one <body> element in a document."><code>&lt;body&gt;</code></a> ancestor; in the latter case, it applies to the whole document.
<p><strong>Usage note:</strong></p> 
<ul> 
 <li>To represent an arbitrary address, one that is not related to the contact information, use a <a href="/en-US/docs/Web/HTML/Element/p" title="The HTML <p> element (or HTML Paragraph Element) represents a paragraph of text."><code>&lt;p&gt;</code></a> element rather than the <span style="font-family: Courier New;">&lt;address&gt;</span> element.</li> 
 <li>This element should not contain more information than the contact information, like a publication date (which belongs in a <a href="/en-US/docs/Web/HTML/Element/time" title="The HTML <time> element represents either a time on a 24-hour clock or a precise date in the Gregorian calendar (with optional time and timezone information)."><code>&lt;time&gt;</code></a> element).</li> 
 <li>Typically an <span style="font-family: Courier New;">&lt;address&gt;</span> element can be placed inside the <a href="/en-US/docs/Web/HTML/Element/footer" title="The HTML Footer Element (<footer>) represents a footer for its nearest sectioning content or sectioning root element. A footer typically contains information about the author of the section, copyright data or links to related documents."><code>&lt;footer&gt;</code></a> element of the current section, if any.</li> 
</ul>
 */
case class Address(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[tree.Node] = Seq.empty) extends HTMLTag[Address] {
  override def tagName = "address"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[tree.Node] = children): Address = Address(attributes, children)
}
