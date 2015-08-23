package pl.metastack.metaweb

object HtmlHelpers {
  /** An end tag must not specified for void elements. List of elements taken
    * from http://www.w3.org/TR/html-markup/syntax.html#syntax-elements
    */
  val VoidElements = Set("area", "base", "br", "col", "command", "embed", "hr",
    "img", "input", "keygen", "link", "meta", "param", "source", "track", "wbr")

  def escapeAttribute(value: String): String = value.replaceAll("\"", "&quot;")
  def quoteAttribute(value: String): String = "\"" + escapeAttribute(value) + "\""

  /** See also scala.xml.Utility.escape() */
  def escape(text: String): String =
    text.flatMap {
      case '<' => "&lt;"
      case '>' => "&gt;"
      case '&' => "&amp;"
      case '"' => "&quot;"
      case '\n' => "\n"
      case '\r' => "\r"
      case '\t' => "\t"
      case c if c >= ' ' => c.toString
      case c => ""
    }
}
