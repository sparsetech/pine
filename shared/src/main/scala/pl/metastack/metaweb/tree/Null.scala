package pl.metastack.metaweb.tree

import pl.metastack.metarx.{ReadChannel, Channel}

case object Null extends Node {
  override val changes: ReadChannel[Unit] = Channel()
  override def copy(): Node = Null
  override def toHtml: String = ""
}
