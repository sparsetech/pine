package pine

import org.scalajs.dom.{DOMParser, document}
import pine.dom.DOM

object HtmlParser {
  def fromString(html: String): Node = {
    val tag  = html.substring(0, 5).toLowerCase
    val node = tag match {
      case "<!doc" | "<html" =>
        new DOMParser().parseFromString(html, "text/html").documentElement
      case "<head" | "<body" =>
        new DOMParser().parseFromString(html, "text/html")
          .getElementsByTagName(tag.tail)(0)
      case _ =>
        val node = document.createElement("body")
        node.innerHTML = html
        node.firstChild
    }

    Option(node)
      .map(DOM.toTree)
      .getOrElse(Text(""))
  }
}

object XmlParser {
  def fromString(html: String): Node = {
    val node = new DOMParser().parseFromString(html, "application/xml")
      .documentElement

    Option(node)
      .map(DOM.toTree)
      .getOrElse(Text(""))
  }
}
