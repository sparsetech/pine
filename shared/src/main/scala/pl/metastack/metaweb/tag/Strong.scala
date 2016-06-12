package pl.metastack.metaweb.tag

import pl.metastack.metaweb.tree

/**
 * The HTML Strong Element (<code>&lt;strong&gt;</code>) gives text strong importance, and is typically displayed in bold.
 */
case class Strong(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[tree.Node] = Seq.empty) extends HTMLTag[Strong] {
  override def tagName = "strong"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[tree.Node] = children): Strong = Strong(attributes, children)
}
