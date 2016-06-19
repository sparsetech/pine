package pl.metastack.metaweb.tag

import pl.metastack.metaweb.tree

/**
 * The <em>HTML Datalist&nbsp;Element</em>&nbsp;(<strong>&lt;datalist&gt;</strong>) contains a set of <a href="/en-US/docs/Web/HTML/Element/option" title="In a Web form, the HTML <option> element is used to create a control representing an item within a <select>, an <optgroup> or a <datalist> HTML5 element."><code>&lt;option&gt;</code></a> elements that represent the values available for other controls.
 */
case class Datalist(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[tree.Node] = Seq.empty) extends HTMLTag {
  override type T = Datalist
  override def tagName = "datalist"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[tree.Node] = children): Datalist = Datalist(attributes, children)
}
