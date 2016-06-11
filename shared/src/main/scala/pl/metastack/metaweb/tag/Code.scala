package pl.metastack.metaweb.tag

import pl.metastack.metaweb.tree

/**
 * The <em>HTML Code&nbsp;Element</em>&nbsp;(<strong>&lt;code&gt;</strong>) represents a fragment of computer code. By default, it is displayed in the browser's default monospace font.
 */
case class Code(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[tree.Node] = Seq.empty) extends tree.Tag with HTMLTag {
  override def tagName = "code"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[tree.Node] = children): Code = Code(attributes, children)
}
