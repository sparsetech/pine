package pl.metastack.metaweb.tree.reactive

import pl.metastack.metarx.ReadChannel

trait Node {
  val changes: ReadChannel[Unit]

  def toHtml: String
  def toHtmlLive: ReadChannel[String] = changes.map(_ => toHtml)

  def copy(): Node

  def byId[T <: Tag](id: String): T =
    this match {
      case t: Tag => t.byIdOpt(id).get
      case _ => throw new RuntimeException("Root node must be an HTML element")
    }
}
