package pl.metastack.metaweb.tag

import pl.metastack.metaweb.tree

/**
 * The <strong>HTML <code>&lt;dt&gt;</code> element</strong> (or HTML Definition Term Element) identifies a term in a definition list. This element can occur only as a child element of a <a href="/en-US/docs/Web/HTML/Element/dl" title="The HTML <dl> Element (or HTML Description List Element) encloses a list of pairs of terms and descriptions. Common uses for this element are to implement a glossary or to display metadata (a list of key-value pairs)."><code>&lt;dl&gt;</code></a>. It is usually followed by a <a href="/en-US/docs/Web/HTML/Element/dd" title="The HTML <dd> Element (or HTML Description Element) indicates the description of a term in a description list (<dl>) element. This element can occur only as a child element of a definition list and it must follow a <dt> element."><code>&lt;dd&gt;</code></a> element; however, multiple <code>&lt;dt&gt;</code> elements in a row indicate several terms that are all defined by the immediate next <a href="/en-US/docs/Web/HTML/Element/dd" title="The HTML <dd> Element (or HTML Description Element) indicates the description of a term in a description list (<dl>) element. This element can occur only as a child element of a definition list and it must follow a <dt> element."><code>&lt;dd&gt;</code></a> element.
 */
case class Dt(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[tree.Node] = Seq.empty) extends HTMLTag {
  override type T = Dt
  override def tagName = "dt"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[tree.Node] = children): Dt = Dt(attributes, children)
}
