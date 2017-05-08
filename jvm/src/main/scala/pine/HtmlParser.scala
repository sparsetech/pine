package pine

object HtmlParser {
  def fromString(html: String): Node = internal.HtmlParser.fromString(html)
}

