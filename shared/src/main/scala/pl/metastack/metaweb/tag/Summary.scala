package pl.metastack.metaweb.tag

import pl.metastack.metaweb.tree

/**
 * The HTML <em>summary </em>element (<code>&lt;summary&gt;</code>) is used as a summary, caption, or legend for the content of a <a href="/en-US/docs/Web/HTML/Element/details" title="The HTML Details&nbsp;Element&nbsp;(<details>) is used as a disclosure widget from which the user can retrieve additional information."><code>&lt;details&gt;</code></a> element.
<strong>Note:</strong> If the 
<code>&lt;summary&gt;</code> element is omitted, the heading "details" will be used.
 */
case class Summary(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[tree.Node] = Seq.empty) extends tree.Tag with HTMLTag {
  override def tagName = "summary"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[tree.Node] = children): Summary = Summary(attributes, children)
}
