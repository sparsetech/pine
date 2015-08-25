package pl.metastack.metaweb.tree.immutable

import pl.metastack.metaweb.tree

case class PlaceholderSeqNode(nodes: Seq[tree.Node]) extends Node with tree.PlaceholderSeqNode {
  override def copy(): Node = PlaceholderSeqNode(nodes)
  override def toHtml: String = nodes.map(_.toHtml).mkString("")
}
