package pl.metastack.metaweb

object HtmlParser {
  def fromString(html: String): Node = internal.HtmlParser.fromString(html)
}

