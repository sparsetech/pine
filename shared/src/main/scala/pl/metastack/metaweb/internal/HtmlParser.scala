package pl.metastack.metaweb.internal

import pl.metastack.metaweb._
import pl.metastack.metaweb.tag.HTMLTag

/* In shared/ because it cannot be used by macros in Scala.js otherwise */
object HtmlParser {
  def parseAttr(reader: Reader): Option[(String, String)] =
    if (reader.prefix("/>") || reader.prefix(">")) None
    else {
      val i = identifier(reader)
      reader.skip('=')
      val s = string(reader)
      Some(i -> s)
    }

  def parseAttrs(reader: Reader): Predef.Map[String, String] =
    parseAttr(reader) match {
      case None => Predef.Map.empty
      case Some(attr) =>
        reader.skip(_.isWhitespace)
        Predef.Map(attr) ++ parseAttrs(reader)
    }

  def string(reader: Reader): String = {
    reader.skip('"')
    val str = reader.collectUntil('"').get
    reader.advance(1)
    HtmlHelpers.decodeAttributeValue(str)
  }

  def identifier(reader: Reader): String =
    reader.collect(x => x.isLetterOrDigit || x == '-' || x == '_' || x == ':').get

  def closingTag(reader: Reader, tagName: String): Boolean =
    reader.prefix(s"</$tagName>")

  def advanceClosingTag(reader: Reader, tagName: String): Unit =
    reader.advance(s"</$tagName>".length)

  def parseChildren(reader: Reader, tagName: String): List[tree.Node] =
    if (reader.prefix("/>")) {
      reader.advance(2)
      List.empty
    } else if (reader.prefix(">")) {
      reader.advance(1)

      if (HtmlHelpers.VoidElements.contains(tagName)) List.empty[tree.Tag]
      else {
        def f(): List[tree.Node] =
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
      reader.collectUntil('>')
      reader.advance(1)
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

  def parseTag(reader: Reader): Option[tree.Tag] =
    if (!reader.prefix("<")) None
    else {
      reader.advance(1)
      val tagName = identifier(reader)
      reader.skip(_.isWhitespace)
      val tagAttrs = parseAttrs(reader)
      val tagChildren = parseChildren(reader, tagName)
      Some(HTMLTag.fromTag(tagName, tagAttrs, tagChildren))
    }

  def parseText(reader: Reader): Option[tree.Text] = {
    val text = reader.collectUntil('<').getOrElse(reader.rest())
    if (text.isEmpty) None
    else Some(tree.Text(HtmlHelpers.decodeText(text)))
  }

  def parseNode(reader: Reader): Option[tree.Node] = {
    skipComment(reader)
    parseTag(reader).orElse(parseText(reader))
  }

  def fromString(html: String): tree.Node = {
    val reader = new Reader(html)
    reader.skip(_.isWhitespace)
    skipDocType(reader)
    reader.skip(_.isWhitespace)
    skipXml(reader)
    reader.skip(_.isWhitespace)
    parseNode(reader).getOrElse(tree.Text(""))
  }
}
