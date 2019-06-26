package pine

object HtmlParser {
  def fromString(html: String): Tag[Singleton] =
    internal.HtmlParser.fromString(html, xml = false)
}

object XmlParser {
  def fromString(html: String): Tag[Singleton] =
    internal.HtmlParser.fromString(html, xml = true)
}
