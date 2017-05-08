package pine.tag

import pine._

/**
 * <strong>Heading</strong> elements implement six levels of document headings, <code>&lt;h1&gt;</code> is the most important and <code>&lt;h6&gt;</code> is the least. A heading element briefly describes the topic of the section it introduces. Heading information may be used by user agents, for example, to construct a table of contents for a document automatically.
 */
case class H6(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[Node] = Seq.empty) extends HTMLTag {
  override type T = H6
  override def tagName = "h6"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[Node] = children): H6 = H6(attributes, children)
}
