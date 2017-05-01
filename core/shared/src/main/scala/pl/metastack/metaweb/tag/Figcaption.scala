package pl.metastack.metaweb.tag

import pl.metastack.metaweb._

/**
 * The <strong>HTML <code>&lt;figcaption&gt;</code> Element</strong> represents a caption or a legend associated with a figure or an illustration described by the rest of the data of the <a href="/en-US/docs/Web/HTML/Element/figure" title="The HTML <figure> Element represents self-contained content, frequently with a caption&nbsp;(<figcaption>), and is&nbsp;typically referenced as a single unit. While it is related to the main flow, its position is independent of the main flow. Usually this is an image, an illustration, a diagram, a code snippet, or a schema that is referenced in the main text, but that can be moved to another page or to an appendix without affecting the main flow."><code>&lt;figure&gt;</code></a> element which is its immediate ancestor which means <code>&lt;figcaption&gt;</code> can be the first or last element inside a <a href="/en-US/docs/Web/HTML/Element/figure" title="The HTML <figure> Element represents self-contained content, frequently with a caption&nbsp;(<figcaption>), and is&nbsp;typically referenced as a single unit. While it is related to the main flow, its position is independent of the main flow. Usually this is an image, an illustration, a diagram, a code snippet, or a schema that is referenced in the main text, but that can be moved to another page or to an appendix without affecting the main flow."><code>&lt;figure&gt;</code></a> block.&nbsp;Also, the <em>HTML Figcaption Element&nbsp;</em>is optional; if not provided, then the parent figure element will have no caption.
 */
case class Figcaption(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[Node] = Seq.empty) extends HTMLTag {
  override type T = Figcaption
  override def tagName = "figcaption"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[Node] = children): Figcaption = Figcaption(attributes, children)
}
