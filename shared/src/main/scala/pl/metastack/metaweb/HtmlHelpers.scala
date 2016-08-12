package pl.metastack.metaweb

object HtmlHelpers {
  /** An end tag must not specified for void elements. List of elements taken
    * from http://www.w3.org/TR/html-markup/syntax.html#syntax-elements
    */
  val VoidElements = Set("area", "base", "br", "col", "command", "embed", "hr",
    "img", "input", "keygen", "link", "meta", "param", "source", "track", "wbr")

  /** Boolean attributes don't require a value */
  val BooleanAttributes = Set("allowfullscreen", "async", "autofocus",
    "autoplay", "checked", "compact", "controls", "declare", "default",
    "defaultchecked", "defaultmuted", "defaultselected", "defer", "disabled",
    "draggable", "enabled", "formnovalidate", "hidden", "indeterminate", "inert",
    "ismap", "itemscope", "loop", "multiple", "muted", "nohref", "noresize",
    "noshade", "novalidate", "nowrap", "open", "pauseonexit", "readonly",
    "required", "reversed", "scoped", "seamless", "selected", "sortable",
    "spellcheck", "translate", "truespeed", "typemustmatch", "visible")

  def encodeAttributeValue(value: Any): String =
    "\"" +
      value.toString
        .replaceAll("&", "&amp;")
        .replaceAll("\"", "&quot;") +
      "\""

  def decodeAttributeValue(value: String): String =
    value
      .replaceAll("&amp;", "&")
      .replaceAll("&quot;", "\"")

  /** See also scala.xml.Utility.escape() */
  def encodeText(text: String): String =
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

  /** From http://hohonuuli.blogspot.com/2012/10/simple-hex-string-to-ascii-function-for.html */
  def parseHexBinary(hex: String): String = {
    val sb = new StringBuilder

    for (i <- 0 until hex.length by 2) {
      val str = hex.substring(i, i + 2)
      sb.append(Integer.parseInt(str, 16).toChar)
    }

    sb.toString
  }

  def decodeEntity(e: String): String = {
    def stripLeading(str: String, c: Char): String =
      if (str.isEmpty) str
      else {
        var i = 0
        while (str(i) == c) i += 1
        str.substring(i)
      }

    if (e.startsWith("#x0"))
      new String(parseHexBinary(stripLeading(e.substring(3), '0')))
    else if (e.startsWith("#"))
      "" + e.substring(1).toInt.toChar
    else if (e.isEmpty) "&;"
    else HtmlEntities.entities(e)
  }

  def decodeText(text: String): String = {
    val reader = new Reader(text)

    def f(): String =
      reader.collectUntil('&') match {
        case None => reader.rest()
        case Some(prefix) =>
          reader.advance(1)
          reader.collectUntil(';') match {
            case None => reader.rest()
            case Some(e) =>
              reader.advance(1)
              prefix + decodeEntity(e) + f()
          }
      }

    f()
  }

  def encodeAttributes(attributes: Map[String, Any]): String =
    attributes.map { case (key, value) =>
      s"$key=" + encodeAttributeValue(value)
    }.mkString(" ")

  def node(tagName: String,
           attributes: Map[String, Any],
           contents: Seq[String]): String = {
    val attrs =
      if (attributes.isEmpty) ""
      else s" ${encodeAttributes(attributes)}"

    if (HtmlHelpers.VoidElements.contains(tagName) && contents.isEmpty)
      s"<$tagName$attrs/>"
    else {
      val docType = if (tagName == "html") "<!DOCTYPE html>" else ""
      val children = contents.mkString
      s"$docType<$tagName$attrs>$children</$tagName>"
    }
  }
}
