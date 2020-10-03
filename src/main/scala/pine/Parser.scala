package pine

import scala.annotation.tailrec

object Parser {
  def parseAttr(reader: Reader): (String, String) = {
    val name  = identifier(reader)
    reader.skip(_.isWhitespace)
    val value = if (reader.prefix('=')) {
      reader.skip(_.isWhitespace)
      parseAttrValue(reader)
    } else ""

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
    reader.collectUntil(!HtmlHelpers.identifierCharacter(_)) match {
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
        else if (skipComment(reader)) f(nodes)
        else parseNode(reader, xml) match {
          case None    => nodes
          case Some(t) => f(nodes :+ t)
        }

      f(List.empty)
    }

  def skipComment(reader: Reader): Boolean =
    if (!reader.prefix("<!--")) false
    else {
      reader.collect("-->").orElse(expected(reader, "-->"))
      true
    }

  def skipDocType(reader: Reader): Unit =
    if (reader.prefixIgnoreCase("<!DOCTYPE"))
      reader.collect('>').orElse(expected(reader, ">"))

  def skipXml(reader: Reader): Unit =
    if (reader.prefix("<?xml"))
      reader.collect('>').orElse(expected(reader, ">"))

  def parseCdata(reader: Reader): Option[Text] =
    if (!reader.prefix("<![CDATA[")) None
    else reader.collect("]]>").map(Text).orElse(expected(reader, "]]>"))

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
    val text = reader.collectUntil('<').getOrElse(reader.restAdvance())
    if (text.isEmpty) None
    else Some(Text(HtmlHelpers.decodeText(text, xml)))
  }

  def parseNode(reader: Reader, xml: Boolean): Option[Node] =
    (if (!xml) None else parseCdata(reader))
      .orElse(parseTag(reader, xml))
      .orElse(parseText(reader, xml))

  def parseRootNode(reader: Reader, xml: Boolean): Option[Tag[_]] = {
    while (skipComment(reader)) {}
    parseTag(reader, xml)
  }

  def fromString(html: String, xml: Boolean): Tag[Singleton] = {
    val reader = new Reader(html)
    reader.skip(_.isWhitespace)
    skipDocType(reader)
    reader.skip(_.isWhitespace)
    if (xml) skipXml(reader)
    reader.skip(_.isWhitespace)
    parseRootNode(reader, xml)
      .getOrElse(throw new ParseError("Invalid input"))
      .asInstanceOf[Tag[Singleton]]
  }
}

object HtmlParser {
  def fromString(html: String): Tag[Singleton] =
    Parser.fromString(html, xml = false)
}

object XmlParser {
  def fromString(html: String): Tag[Singleton] =
    Parser.fromString(html, xml = true)
}
