package pl.metastack.metaweb.tag

import pl.metastack.metaweb.tree

/**
 * The <strong><a href="/en-US/docs/Web/HTML">HTML</a> <code>&lt;div&gt;</code> element</strong> (or <em>HTML Document Division Element</em>) is the generic container for flow content, which does not inherently represent anything. It can be used to group elements for styling purposes (using the <strong>class</strong> or <strong>id</strong> attributes), or because they share attribute values, such as <strong>lang</strong>. It should be used only when no other semantic element (such as <a href="/en-US/docs/Web/HTML/Element/article" title="The HTML <article> Element represents a self-contained composition in a document, page, application, or site, which is intended to be independently distributable or reusable, e.g., in syndication. This could be a forum post, a magazine or newspaper article, a blog entry, a user-submitted comment, an interactive widget or gadget, or any other independent item of content."><code>&lt;article&gt;</code></a> or <a href="/en-US/docs/Web/HTML/Element/nav" title="The HTML Navigation Element (<nav>) represents a section of a page that links to other pages or to parts within the page: a section with navigation links."><code>&lt;nav&gt;</code></a>) is appropriate.
 */
case class Div(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[tree.Node] = Seq.empty) extends HTMLTag[Div] {
  override def tagName = "div"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[tree.Node] = children): Div = Div(attributes, children)
}
