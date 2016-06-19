package pl.metastack.metaweb.tag

import pl.metastack.metaweb.tree

/**
 * The <strong><a href="/en-US/docs/Web/HTML">HTML</a>&nbsp;<code>&lt;content&gt;</code></strong>&nbsp;element is used inside of <a href="/en-US/docs/Web/Web_Components/Shadow_DOM">Shadow DOM</a> as an <a class="new glossaryLink" href="/en-US/docs/Glossary/insertion_point" title="The definition of that term (insertion point) has not been written yet; please consider contributing it!">insertion point</a>. It is not intended to be used in ordinary HTML. It is used with <a href="/en-US/docs/Web/Web_Components">Web Components</a>.
 */
case class Content(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[tree.Node] = Seq.empty) extends HTMLTag {
  override type T = Content
  override def tagName = "content"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[tree.Node] = children): Content = Content(attributes, children)
}
