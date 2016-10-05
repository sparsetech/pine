package pl.metastack.metaweb.tag

import pl.metastack.metaweb.tree

/**
 * The <strong>HTML <code>&lt;span&gt;</code> element</strong> is a generic inline container for phrasing content, which does not inherently represent anything. It can be used to group elements for styling purposes (using the <code>class</code> or <code>id</code> attributes), or because they share attribute values, such as <code>lang</code>. It should be used only when no other semantic element is appropriate. <code>&lt;span&gt;</code> is very much like a <a href="/en-US/docs/Web/HTML/Element/div" title="The HTML <div> element (or HTML Document Division Element) is the generic container for flow content, which does not inherently represent anything. It can be used to group elements for styling purposes (using the class or id attributes), or because they share attribute values, such as lang. It should be used only when no other semantic element (such as <article> or <nav>) is appropriate."><code>&lt;div&gt;</code></a> element, but <a href="/en-US/docs/Web/HTML/Element/div" title="The HTML <div> element (or HTML Document Division Element) is the generic container for flow content, which does not inherently represent anything. It can be used to group elements for styling purposes (using the class or id attributes), or because they share attribute values, such as lang. It should be used only when no other semantic element (such as <article> or <nav>) is appropriate."><code>&lt;div&gt;</code></a> is a <a href="/en-US/docs/HTML/Block-level_elements">block-level element</a> whereas a <code>&lt;span&gt;</code> is an<a href="/en-US/docs/HTML/Inline_elements"> inline element</a>.
 */
case class Span(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[tree.Node] = Seq.empty) extends HTMLTag {
  override type T = Span
  override def tagName = "span"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[tree.Node] = children): Span = Span(attributes, children)
}
