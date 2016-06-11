package pl.metastack.metaweb.macros

import scala.language.reflectiveCalls
import scala.language.experimental.macros

import scala.reflect.macros.blackbox.Context

import scala.xml.XML

import pl.metastack.metaweb.tree

object ExternalHtml {
  trait Method {
    /** Expose `html` as a global method */
    def html(fileName: String): tree.Tag = macro HtmlImpl
  }

  def convert(c: Context)(node: scala.xml.Node,
                          root: Boolean): c.Expr[tree.Node] = {
    import c.universe._

    (node.label, Option(node.prefix)) match {
      case ("#PCDATA", _) => c.Expr(q"pl.metastack.metaweb.tree.Text(${node.text})")
      case (tag, prefix) =>
        val tagName = prefix.map(pfx => s"$pfx:$tag").getOrElse(tag)
        val rootAttributes: Map[String, String] =
          if (root) Helpers.namespaceBinding(node.scope)
          else Map.empty

        val tagType = TypeName(tag.capitalize)
        val tagAttrs = node.attributes.asAttrMap ++ rootAttributes
        val tagChildren = node.child.map(convert(c)(_, root = false))

        try {
          c.typecheck(q"val x: pl.metastack.metaweb.tag.$tagType")
          c.Expr(q"new pl.metastack.metaweb.tag.$tagType($tagAttrs, Seq(..$tagChildren))")
        } catch { case t: Throwable =>
          c.Expr(q"pl.metastack.metaweb.tag.HTMLTag.fromTag($tagName, $tagAttrs, Seq(..$tagChildren))")
        }
    }
  }

  def HtmlImpl(c: Context)(fileName: c.Expr[String]): c.Expr[tree.Tag] = {
    val fileNameValue = Helpers.literalValueExpr(c)(fileName)
    val xml = XML.loadFile(fileNameValue)
    convert(c)(xml, root = true)
      .asInstanceOf[c.Expr[tree.Tag]]
  }
}