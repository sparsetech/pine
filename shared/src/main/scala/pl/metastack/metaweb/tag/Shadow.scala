package pl.metastack.metaweb.tag

import pl.metastack.metaweb.tree

/**
 * The <strong><a href="/en-US/docs/Web/HTML">HTML</a>&nbsp;<code>&lt;shadow&gt;</code></strong>&nbsp;element is used as a shadow DOM <a class="new glossaryLink" href="/en-US/docs/Glossary/insertion_point" title="The definition of that term (insertion point) has not been written yet; please consider contributing it!">insertion point</a>. You might use it if you have created multiple shadow roots under a shadow host. It is not useful in ordinary HTML. It is used with <a href="/en-US/docs/Web/Web_Components">Web Components</a>.
 */
case class Shadow(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[tree.Node] = Seq.empty) extends HTMLTag[Shadow] {
  override def tagName = "shadow"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[tree.Node] = children): Shadow = Shadow(attributes, children)
}
