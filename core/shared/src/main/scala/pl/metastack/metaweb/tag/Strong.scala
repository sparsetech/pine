package pl.metastack.metaweb.tag

import pl.metastack.metaweb._

/**
 * The HTML Strong Element (<code>&lt;strong&gt;</code>) gives text strong importance, and is typically displayed in bold.
 */
case class Strong(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[Node] = Seq.empty) extends HTMLTag {
  override type T = Strong
  override def tagName = "strong"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[Node] = children): Strong = Strong(attributes, children)
}
