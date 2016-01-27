package pl.metastack.metaweb

import org.scalajs.dom

object HtmlParser {
  def fromString(html: String): tree.Tag = {
    val node = dom.document.createElement("div")
    node.innerHTML = html
    render.DOM.proxyTree[tree.Tag](node.firstChild)
  }
}
