package pl.metastack.metaweb.tag

import pl.metastack.metaweb._

/**
 * The <em>HTML Code&nbsp;Element</em>&nbsp;(<strong>&lt;code&gt;</strong>) represents a fragment of computer code. By default, it is displayed in the browser's default monospace font.
 */
case class Code(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[Node] = Seq.empty) extends HTMLTag {
  override type T = Code
  override def tagName = "code"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[Node] = children): Code = Code(attributes, children)
}
