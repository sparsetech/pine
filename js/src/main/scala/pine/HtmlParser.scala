package pine

import org.scalajs.dom.{Document, DOMParser, Element}

import pine.dom.DOM

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
  def fromString(html: String): Tag[Singleton] = {
    if (!html.startsWith("<")) throw new ParseError("Does not start with tag")

    val node =
      if (html.substring(1, 5).equalsIgnoreCase("!doc"))
        DomParser.parse(html, "text/html").documentElement
      else {
        val tagName = html.tail.takeWhile(HtmlHelpers.identifierCharacter)
        if (tagName.isEmpty) throw new ParseError("Empty tag name")
        val e = DomParser.parse(html, "text/html").getElementsByTagName(tagName)
        // TODO getElementsByTagName should return ElementList
        e(0).asInstanceOf[Element]
      }

    DOM.toTree(node)
  }
}

object XmlParser {
  def fromString(xml: String): Tag[Singleton] = {
    val document = DomParser.parse(xml, "application/xml")
    DOM.toTree(document.documentElement)
  }
}
