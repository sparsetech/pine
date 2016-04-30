package pl.metastack.metaweb

import pl.metastack.metaweb.macros.Helpers

import scala.xml.XML

object HtmlParser {
  def convert(node: scala.xml.Node, root: Boolean): tree.Node =
    (node.label, Option(node.prefix)) match {
      case ("#PCDATA", _) => new pl.metastack.metaweb.tree.Text(node.text)
      case (tag, prefix) =>
        val tagName = prefix.map(pfx => s"$pfx:$tag").getOrElse(tag)
        val rootAttributes: Map[String, String] =
          if (root) Helpers.namespaceBinding(node.scope)
          else Map.empty

        val tagAttrs = node.attributes.asAttrMap ++ rootAttributes
        val tagChildren = node.child.map(convert(_, root = false))
        tree.Tag(tagName, tagAttrs, Map.empty, tagChildren)
    }

  def fromString(html: String): tree.Tag = {
    val xml = XML.loadString(html)
    convert(xml, root = true).asInstanceOf[tree.Tag]
  }

  def fromFile(fileName: String): tree.Tag = {
    val xml = XML.loadFile(fileName)
    convert(xml, root = true).asInstanceOf[tree.Tag]
  }
}
