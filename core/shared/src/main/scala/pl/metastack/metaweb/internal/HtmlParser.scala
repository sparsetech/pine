package pl.metastack.metaweb.internal

import pl.metastack.metaweb._
import pl.metastack.metaweb.tag.HTMLTag

class ParseError(e: String) extends Exception(e)

/* In shared/, otherwise it cannot be used by macros in Scala.js */
object HtmlParser {
  def parseAttr(reader: Reader): Option[(String, String)] =
    if (reader.prefix("/>") || reader.prefix(">")) None
    else {
      val name  = identifier(reader)
      val value =
        if (reader.current() != '=') name
        else {
          reader.advance(1)
          parseAttrValue(reader)
        }

      Some(name -> value)
    }

  def parseAttrs(reader: Reader): Map[String, String] =
    parseAttr(reader) match {
      case None => Map.empty
      case Some(attr) =>
        reader.skip(_.isWhitespace)
        Map(attr) ++ parseAttrs(reader)
    }

  def parseAttrValue(reader: Reader): String = {
    reader.skip('"')
    val str = reader.collectUntil('"')
      .getOrElse(throw new ParseError(s"""Expected '"', found '${reader.rest()}'"""))
    reader.advance(1)
    HtmlHelpers.decodeAttributeValue(str)
  }

  def identifier(reader: Reader): String =
    reader.collectUntil { c =>
      c.isLetterOrDigit || c == '-' || c == '_' || c == ':'
    }.get

  def closingTag(reader: Reader, tagName: String): Boolean =
    reader.prefix(s"</$tagName>")

  def advanceClosingTag(reader: Reader, tagName: String): Unit =
    reader.advance(s"</$tagName>".length)

  def parseChildren(reader: Reader, tagName: String): List[Node] =
    if (reader.prefix("/>")) {
      reader.advance(2)
      List.empty
    } else if (reader.prefix(">")) {
      reader.advance(1)

      if (HtmlHelpers.VoidElements.contains(tagName)) List.empty[Tag]
      else {
        def f(): List[Node] =
          if (closingTag(reader, tagName)) {
            advanceClosingTag(reader, tagName)
            List.empty
          } else parseNode(reader) match {
            case None => List.empty
            case Some(t) => t +: f()
          }

        f()
      }
    } else List.empty

  def skipComment(reader: Reader): Unit =
    if (reader.prefix("<!--")) {
      reader.collectUntil("-->")
      reader.advance(3)
    }

  def skipDocType(reader: Reader): Unit =
    if (reader.prefix("<!DOCTYPE")) {
      reader.collectUntil('>')
      reader.advance(1)
    }

  def skipXml(reader: Reader): Unit =
    if (reader.prefix("<?xml")) {
      reader.collectUntil('>')
      reader.advance(1)
    }

  def parseTag(reader: Reader): Option[Tag] =
    if (!reader.prefix("<")) None
    else {
      reader.advance(1)
      val tagName = identifier(reader)
      if (tagName.isEmpty)
        throw new ParseError(s"Identifier cannot be empty (rest: ${reader.rest()})")
      reader.skip(_.isWhitespace)
      val tagAttrs = parseAttrs(reader)
      val tagChildren = parseChildren(reader, tagName)
      Some(HTMLTag.fromTag(tagName, tagAttrs, tagChildren))
    }

  def parseText(reader: Reader): Option[Text] = {
    val text = reader.collectUntil('<').getOrElse(reader.rest())
    if (text.isEmpty) None
    else Some(Text(HtmlHelpers.decodeText(text)))
  }

  def parseNode(reader: Reader): Option[Node] = {
    skipComment(reader)
    parseTag(reader).orElse(parseText(reader))
  }

  def fromString(html: String): Node = {
    val reader = new Reader(html)
    reader.skip(_.isWhitespace)
    skipDocType(reader)
    reader.skip(_.isWhitespace)
    skipXml(reader)
    reader.skip(_.isWhitespace)
    parseNode(reader).getOrElse(Text(""))
  }
}
