package pl.metastack.metaweb

import pl.metastack.metaweb.macros.Helpers
import pl.metastack.metaweb.tag.HTMLTag

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
        HTMLTag.fromTag(tagName, tagAttrs, tagChildren)
    }

  def fromString(html: String): tree.Node =
    if (html.trim.startsWith("<")) {
      val xml = XML.loadString(html)
      convert(xml, root = true)
    } else {
      val xml = XML.loadString(s"<div>$html</div>")
      convert(xml, root = true).asInstanceOf[tree.Tag]
        .children
        .headOption
        .getOrElse(tree.Text(""))
    }
}
