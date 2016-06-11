package pl.metastack.metaweb

import org.scalajs.dom

object HtmlParser {
  def fromString(html: String): tree.Tag = {
    val node = if (html.startsWith("<!DOCTYPE")) {
      val document = dom.document.implementation.createHTMLDocument("")
      document.documentElement.innerHTML = html
      document.firstChild.nextSibling
    } else {
      // TODO Not supported by PhantomJS?
      // val parser = new DOMParser()
      // val document = parser.parseFromString(html, "text/html")

      val node = dom.document.createElement("div")
      node.innerHTML = html
      node.firstChild
    }

    DOM.toTree[tree.Tag](node)
  }
}
