package pine

import org.scalajs.dom.{DOMParser, document, Document}
import pine.dom.DOM
import pine.internal.ParseError

private object DomParser {
  val parser = new DOMParser()
  val parserErrorNs = parser
    .parseFromString("invalid", "application/xml")
    .getElementsByTagName("parsererror")(0)
    .namespaceURI

  def parse(content: String, mimeType: String): Document = {
    val document   = parser.parseFromString(content, mimeType)
    val parseError = document.getElementsByTagNameNS(parserErrorNs, "parsererror")
    if (parseError.length != 0) throw new ParseError(parseError(0).textContent)
    document
  }
}

object HtmlParser {
  def fromString(html: String): Node = {
    val tag  = html.substring(0, 5).toLowerCase
    val node = tag match {
      case "<!doc" | "<html" =>
        DomParser.parse(html, "application/xhtml+xml").documentElement
      case "<head" | "<body" =>
        DomParser.parse(html, "application/xhtml+xml")
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
  def fromString(xml: String): Node = {
    val document = DomParser.parse(xml, "application/xml")
    DOM.toTree(document.documentElement)
  }
}
