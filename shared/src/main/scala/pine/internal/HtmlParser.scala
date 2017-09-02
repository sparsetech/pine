package pine.internal

import pine._

import scala.annotation.tailrec

class ParseError(e: String) extends Exception(e)

/* In shared/, otherwise it cannot be used by macros in Scala.js */
object HtmlParser {
  def parseAttr(reader: Reader): (String, String) = {
    val name  = identifier(reader)
    val value =
      if (reader.prefix('=')) parseAttrValue(reader)
      else if (HtmlHelpers.BooleanAttributes.contains(name)) name
      else ""

    name -> value
  }

  def parseAttrs(reader: Reader): Map[String, String] = {
    @tailrec def f(acc: Map[String, String]): Map[String, String] =
      if (reader.lookahead("/>") || reader.lookahead(">")) acc
      else {
        val attr = parseAttr(reader)
        reader.skip(_.isWhitespace)
        f(acc + attr)
      }

    f(Map.empty)
  }

  def rest(reader: Reader): String = reader.rest().take(20) + "[...]"
  def expected(reader: Reader, expected: String) =
    throw new ParseError(s"""Expected '$expected', found '${rest(reader)}'""")

  def parseAttrValue(reader: Reader): String = {
    if (!reader.prefix('"')) expected(reader, "\"")
    val str = reader.collect('"').getOrElse(expected(reader, "\""))
    HtmlHelpers.decodeAttributeValue(str)
  }

  def identifier(reader: Reader): String =
    reader.collectUntil { c =>
      !c.isLetterOrDigit && c != '-' && c != '_' && c != ':'
    } match {
      case None | Some("") =>
        throw new ParseError(s"Identifier expected, found '${rest(reader)}'")
      case Some(value) => value
    }

  def parseChildren(reader: Reader, tagName: String, xml: Boolean): List[Node] =
    if (!xml && HtmlHelpers.VoidElements.contains(tagName)) List.empty
    else if (!xml && HtmlHelpers.CdataElements.contains(tagName)) {
      val result = reader.collect(s"</$tagName>").getOrElse(
        expected(reader, s"</$tagName>"))
      List(Text(result))
    } else {
      @tailrec def f(nodes: List[Node]): List[Node] =
        if (reader.prefix(s"</$tagName>")) nodes
        else parseNode(reader, xml) match {
          case None    => nodes
          case Some(t) => f(nodes :+ t)
        }

      f(List.empty)
    }

  def skipComment(reader: Reader): Unit =
    if (reader.prefix("<!--"))
      reader.collect("-->").orElse(expected(reader, "-->"))

  def skipDocType(reader: Reader): Unit =
    if (reader.prefix("<!DOCTYPE"))
      reader.collect('>').orElse(expected(reader, ">"))

  def skipXml(reader: Reader): Unit =
    if (reader.prefix("<?xml"))
      reader.collect('>').orElse(expected(reader, ">"))

  def parseTag(reader: Reader, xml: Boolean): Option[Tag[_]] =
    if (!reader.prefix("<")) None
    else {
      val tagName = identifier(reader)
      reader.skip(_.isWhitespace)
      val tagAttrs = parseAttrs(reader)
      val tagChildren =
        if (reader.prefix("/>")) List.empty
        else if (reader.prefix(">")) parseChildren(reader, tagName, xml)
        else expected(reader, "/>")

      Some(Tag(tagName, tagAttrs, tagChildren))
    }

  def parseText(reader: Reader, xml: Boolean): Option[Text] = {
    val text = reader.collectUntil('<').getOrElse(reader.rest())
    if (text.isEmpty) None
    else Some(Text(HtmlHelpers.decodeText(text, xml)))
  }

  def parseNode(reader: Reader, xml: Boolean): Option[Node] = {
    skipComment(reader)
    parseTag(reader, xml).orElse(parseText(reader, xml))
  }

  def fromString(html: String, xml: Boolean): Node = {
    val reader = new Reader(html)
    reader.skip(_.isWhitespace)
    skipDocType(reader)
    reader.skip(_.isWhitespace)
    if (xml) skipXml(reader)
    reader.skip(_.isWhitespace)
    parseNode(reader, xml).getOrElse(Text(""))
  }
}
