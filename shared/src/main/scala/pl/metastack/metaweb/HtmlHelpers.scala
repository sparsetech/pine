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

  def escapeAttribute(value: String): String = value.replaceAll("\"", "&quot;")
  def quoteAttribute(value: Any): String =
    if (value == null) "\"\""
    else "\"" + escapeAttribute(value.toString) + "\""

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

  def encodedAttributes(attributes: Map[String, Any]): String =
    attributes.map { case (key, value) =>
      s"$key=" + HtmlHelpers.quoteAttribute(value)
    }.mkString(" ")

  def node(tagName: String,
           attributes: Map[String, Any],
           contents: Seq[String]): String = {
    val attrs =
      if (attributes.isEmpty) ""
      else s" ${encodedAttributes(attributes)}"

    if (HtmlHelpers.VoidElements.contains(tagName) && contents.isEmpty)
      s"<$tagName$attrs/>"
    else {
      val docType = if (tagName == "html") "<!DOCTYPE html>" else ""
      val children = contents.mkString
      s"$docType<$tagName$attrs>$children</$tagName>"
    }
  }
}
