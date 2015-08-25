package pl.metastack.metaweb.tree.immutable

import pl.metastack.metaweb.tree
import pl.metastack.metaweb.HtmlHelpers

case class Text(text: String) extends Node with tree.Text {
  def toHtml: String = HtmlHelpers.escape(text)
  def copy(): Node = Text(text)
}
