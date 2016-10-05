package pl.metastack.metaweb.tag

import pl.metastack.metaweb.tree

/**
 * The HTML Small Element (<span style="font-family: Courier New;">&lt;small&gt;</span>) makes the text <em>font size</em> one size smaller (for example, from large to medium, or from small to x-small) down to the browser's minimum font size.&nbsp; In HTML5, this element is repurposed to represent side-comments and small print, including copyright and legal text, independent of its styled presentation.
 */
case class Small(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[tree.Node] = Seq.empty) extends HTMLTag {
  override type T = Small
  override def tagName = "small"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[tree.Node] = children): Small = Small(attributes, children)
}
