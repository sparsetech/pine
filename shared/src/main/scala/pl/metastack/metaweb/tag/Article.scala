package pl.metastack.metaweb.tag

import pl.metastack.metaweb.tree

/**
 * The <em>HTML <code>Article</code> Element</em> (<strong>&lt;article&gt;</strong>) represents a self-contained composition in a document, page, application, or site, which is intended to be independently distributable or reusable, e.g., in syndication. This could be a forum post, a magazine or newspaper article, a blog entry, or any other independent item of content. Each <em><code>&lt;article&gt;</code></em> should be identified, typically by including a heading (<a href="/en-US/docs/Web/HTML/Element/Heading_Elements">h1-h6</a> element) as a child of the <em><code>&lt;article&gt;</code></em> element.
<p><strong>Usage notes:</strong></p> 
<ul> 
 <li>When an <code>&lt;article&gt;</code> element is nested, the inner element represents an article related to the outer element. For example, the comments of a blog post can be <code>&lt;article&gt;</code> elements nested in the <code>&lt;article&gt;</code> representing the blog post.</li> 
 <li>Author information of an <code>&lt;article&gt;</code> element can be provided through the <a href="/en-US/docs/Web/HTML/Element/address" title="The HTML Address Element (<address>) should be used by authors to supply contact information for its nearest <article> or <body> ancestor; in the latter case, it applies to the whole document."><code>&lt;address&gt;</code></a> element, but it doesn't apply to nested <code>&lt;article&gt;</code> elements.</li> 
 <li>The publication date and time of an <code>&lt;article&gt;</code> element can be described using the <code><a href="/en-US/docs/Web/HTML/Element/time#attr-datetime">datetime</a></code> attribute of a <a href="/en-US/docs/Web/HTML/Element/time" title="The HTML <time> element represents either a time on a 24-hour clock or a precise date in the Gregorian calendar (with optional time and timezone information)."><code>&lt;time&gt;</code></a> element. <em>Note that the&nbsp;<code><a href="/en-US/docs/Web/HTML/Element/time#attr-pubdate">pubdate</a></code> attribute of <a href="/en-US/docs/Web/HTML/Element/time" title="The HTML <time> element represents either a time on a 24-hour clock or a precise date in the Gregorian calendar (with optional time and timezone information)."><code>&lt;time&gt;</code></a> is no longer a part of the W3C HTML 5 standard.</em></li> 
</ul>
 */
case class Article(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[tree.Node] = Seq.empty) extends tree.Tag with HTMLTag {
  override def tagName = "article"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[tree.Node] = children): Article = Article(attributes, children)
}
