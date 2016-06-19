package pl.metastack.metaweb.tag

import pl.metastack.metaweb.tree

/**
 * The <strong><a href="/en-US/docs/Web/HTML">HTML</a> <code>&lt;element&gt;</code> element</strong> is used to define new custom DOM elements.
 */
case class Element(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[tree.Node] = Seq.empty) extends HTMLTag {
  override type T = Element
  override def tagName = "element"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[tree.Node] = children): Element = Element(attributes, children)
}
