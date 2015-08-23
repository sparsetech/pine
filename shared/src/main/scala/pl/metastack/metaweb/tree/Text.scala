package pl.metastack.metaweb.tree

import pl.metastack.metarx.{ReadChannel, Var}
import pl.metastack.metaweb.HtmlHelpers

case class Text(text: Var[String]) extends Node {
  def toHtml: String = HtmlHelpers.escape(text.get)
  val changes: ReadChannel[Unit] = text.map(_ => ())

  def copy(): Node = Text(text)
}
