package pl.metastack.metaweb.tree.mutable

import pl.metastack.metarx.{ReadChannel, Var}

import pl.metastack.metaweb.tree
import pl.metastack.metaweb.HtmlHelpers

class Text(val textVar: Var[String]) extends Node with tree.Text {
  def text: String = textVar.get

  def toHtml: String = HtmlHelpers.escape(text)
  val changes: ReadChannel[Unit] = textVar.map(_ => ())

  def copy(): Node = Text(textVar)
}

object Text {
  def apply(text: String): Text = new Text(Var(text))
  def apply(text: Var[String]): Text = new Text(text)
}
