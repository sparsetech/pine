package pl.metastack.metaweb

object HtmlParser {
  def fromString(html: String): tree.Node =
    internal.HtmlParser.fromString(html)
}

