package pl.metastack.metaweb.tag

import pl.metastack.metaweb.tree

/**
 * <span class="seoSummary">The <strong>HTML <code>&lt;p&gt;</code> element</strong> <em>(</em>or <em>HTML Paragraph Element)</em> represents a paragraph of text.</span> Paragraphs are <a href="/en-US/docs/HTML/Block-level_elements">block-level elements</a>.
 */
case class P(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[tree.Node] = Seq.empty) extends HTMLTag[P] {
  override def tagName = "p"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[tree.Node] = children): P = P(attributes, children)
}
