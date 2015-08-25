package pl.metastack.metaweb.tree.mutable

import pl.metastack.metarx.{ReadChannel, Channel}

import pl.metastack.metaweb.tree

case object Null extends Node with tree.Null {
  override val changes: ReadChannel[Unit] = Channel()
  override def copy(): Node = Null
  override def toHtml: String = ""
}
