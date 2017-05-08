package pine.tag

import pine._

/**
 * <span class="seoSummary">The <strong><a href="/en-US/docs/Web/HTML">HTML</a> template element <code>&lt;template&gt;</code></strong> is a mechanism for holding client-side content that is not to be rendered when a page is loaded but may subsequently be instantiated during runtime using JavaScript.&nbsp;</span>
Think of a template as a content fragment that is being stored for subsequent use in the document. While the parser does process the contents of the <strong><code>&lt;template&gt;</code> </strong>element while loading the page, it does so only to ensure that those contents are valid; the element's contents are not rendered, however.
 */
case class Template(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[Node] = Seq.empty) extends HTMLTag {
  override type T = Template
  override def tagName = "template"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[Node] = children): Template = Template(attributes, children)
}
