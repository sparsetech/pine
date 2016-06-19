package pl.metastack.metaweb.tag

import pl.metastack.metaweb.tree

/**
 * The <strong>HTML <code>&lt;dl&gt;</code> Element</strong> (or <em>HTML</em> <em>Description List Element</em>) encloses a list of pairs of terms and descriptions. Common uses for this element are to implement a glossary or to display metadata (a list of key-value pairs).
Prior to HTML5, &lt;dl&gt; was known as a Definition List.
 */
case class Dl(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[tree.Node] = Seq.empty) extends HTMLTag {
  override type T = Dl
  override def tagName = "dl"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[tree.Node] = children): Dl = Dl(attributes, children)
  /**
   * Forces the description to appear on the same line as the term. This attribute is currently unsupported
   */
  def compact: Boolean = attributes.contains("compact")
  def compact(value: Boolean): Dl = (if (value) copy(attributes = attributes + ("compact" -> "")) else copy(attributes = attributes - "compact"))
}
