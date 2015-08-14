package pl.metastack.metaweb

import pl.metastack.metarx.{ReadChannel, Var}

case class Text(text: Var[String]) extends Node {
  def toHtml: String = text.get
  val changes: ReadChannel[Unit] = text.map(_ => ())

  def copy(): Node = Text(text)
}
