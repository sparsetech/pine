package pl.metastack.metaweb.tag

import pl.metastack.metaweb._

/**
 * This element only includes the <a href="https://developer.mozilla.org/en-US/docs/HTML/Global_attributes">global attributes</a>.
 */
case class Legend(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[Node] = Seq.empty) extends HTMLTag {
  override type T = Legend
  override def tagName = "legend"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[Node] = children): Legend = Legend(attributes, children)
}
