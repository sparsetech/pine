package pl.metastack.metaweb.tree

/** TODO Rename */
case class PlaceholderSeqNode(nodes: Seq[Node]) extends Node {
  override def copy(): Node = PlaceholderSeqNode(nodes)
  override def toHtml: String = nodes.map(_.toHtml).mkString("")
}
