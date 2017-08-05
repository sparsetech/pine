package pine

object HtmlParser {
  def fromString(html: String): Node =
    internal.HtmlParser.fromString(html, xml = false)
}

object XmlParser {
  def fromString(html: String): Node =
    internal.HtmlParser.fromString(html, xml = true)
}
