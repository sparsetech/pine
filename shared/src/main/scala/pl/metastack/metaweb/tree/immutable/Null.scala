package pl.metastack.metaweb.tree.immutable

import pl.metastack.metaweb.tree

case object Null extends Node with tree.Null {
  override def copy(): tree.Node = Null
  override def toHtml: String = ""
}
