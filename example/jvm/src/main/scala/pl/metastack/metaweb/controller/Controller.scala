package pl.metastack.metaweb.controller

import pl.metastack.metaweb._

trait Controller {
  def head: tag.Head
  def body: tag.Body

  body += html"""<script type="text/javascript" src="/sjs/example-fastopt.js"></script>"""
  body += html"""<script type="text/javascript" src="/sjs/example-launcher.js"></script>"""

  def render(): String = {
    val container = new state.Container()
    container.set(Seq(head, body))
    container.toHtml
  }
}
