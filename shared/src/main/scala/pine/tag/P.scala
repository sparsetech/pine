package pine.tag

import pine._

/**
 * <span class="seoSummary">The <strong>HTML <code>&lt;p&gt;</code> element</strong> <em>(</em>or <em>HTML Paragraph Element)</em> represents a paragraph of text.</span> Paragraphs are <a href="/en-US/docs/HTML/Block-level_elements">block-level elements</a>.
 */
case class P(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[Node] = Seq.empty) extends HTMLTag {
  override type T = P
  override def tagName = "p"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[Node] = children): P = P(attributes, children)
}
