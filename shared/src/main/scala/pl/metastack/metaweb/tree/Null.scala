package pl.metastack.metaweb.tree

case object Null extends Node {
  override def copy(): Node = Null
  override def toHtml: String = ""
}
