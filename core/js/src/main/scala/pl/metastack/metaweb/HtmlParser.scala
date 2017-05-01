package pl.metastack.metaweb

import org.scalajs
import pl.metastack.metaweb.dom.DOM

object HtmlParser {
  def fromString(html: String): Node = {
    val node = if (html.startsWith("<!DOCTYPE")) {
      val document = scalajs.dom.document.implementation.createHTMLDocument("")
      document.documentElement.innerHTML = html
      document.firstChild.nextSibling
    } else {
      // TODO Not supported by PhantomJS?
      // val parser = new DOMParser()
      // val document = parser.parseFromString(html, "text/html")

      val node = scalajs.dom.document.createElement("div")
      node.innerHTML = html
      node.firstChild
    }

    Option(node)
      .map(DOM.toTree[Node])
      .getOrElse(Text(""))
  }
}
