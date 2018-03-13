package pine

import org.scalajs.dom.{Document, DOMParser, Element}

import pine.dom.DOM

private object DomParser {
  val parser = new DOMParser()

  def parse(content: String, mimeType: String): Document = {
    val document   = parser.parseFromString(content, mimeType)
    val parseError = document.getElementsByTagNameNS("*", "parsererror")
    if (parseError.length != 0) throw new ParseError(parseError(0).textContent)
    document
  }
}

object HtmlParser {
  def fromString(html: String): Tag[Singleton] = {
    if (!html.startsWith("<")) throw new ParseError("Does not start with tag")
    val reader = new Reader(html)
    val node =
      if (reader.prefix("<!DOCTYPE"))
        DomParser.parse(html, "text/html").documentElement
      else {
        // Skip leading comments
        while (reader.prefix("<!--")) reader.collect("-->")

        // Extract root tag name
        reader.collect('<').flatMap(_ =>
          reader.collectUntil(!HtmlHelpers.identifierCharacter(_))
        ) match {
          case None => throw new ParseError("Empty tag name")
          case Some(tn) =>
            val e = DomParser.parse(html, "text/html").getElementsByTagName(tn)
            // TODO getElementsByTagName should return ElementList
            e(0).asInstanceOf[Element]
        }
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
