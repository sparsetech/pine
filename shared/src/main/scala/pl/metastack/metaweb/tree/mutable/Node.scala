package pl.metastack.metaweb.tree.mutable

import pl.metastack.metarx.ReadChannel

import pl.metastack.metaweb.tree

trait Node extends tree.Node {
  val changes: ReadChannel[Unit]
  def toHtmlLive: ReadChannel[String] = changes.map(_ => toHtml)

  // TODO Same as in immutable.Node, merge?
  def byId[T <: tree.Tag](id: String): T =
    this match {
      case t: tree.Tag => t.byIdOpt(id).get
      case _ => throw new RuntimeException("Root node must be an HTML element")
    }
}
