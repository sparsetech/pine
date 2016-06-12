package pl.metastack.metaweb.tag

import pl.metastack.metaweb.tree

/**
 * The <strong>HTML <code>&lt;i&gt;</code> Element</strong> represents a range of text that is set off from the normal text for some reason, for example, technical terms, foreign language phrases, or fictional character thoughts. It is typically displayed in italic type.
 */
case class I(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[tree.Node] = Seq.empty) extends HTMLTag[I] {
  override def tagName = "i"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[tree.Node] = children): I = I(attributes, children)
}
