package pl.metastack.metaweb

import pl.metastack.metarx.ReadChannel

trait Node {
  val changes: ReadChannel[Unit]

  def toHtml: String
  def toHtmlLive: ReadChannel[String] = changes.map(_ => toHtml)

  def copy(): Node
}
