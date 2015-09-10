package pl.metastack.metaweb.macros

import scala.language.reflectiveCalls
import scala.language.experimental.macros

import scala.reflect.macros.blackbox.Context

import scala.xml.XML

import pl.metastack.metaweb.tree
import pl.metastack.metaweb.state

object ExternalHtml {
  trait Import {
    def html(fileName: String): state.Tag = macro HtmlImpl
    def htmlT(fileName: String): tree.Tag = macro HtmlImplT
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

        val tagAttrs = node.attributes.asAttrMap ++ rootAttributes
        val tagChildren = node.child.map(convert(c)(_, root = false))
        c.Expr(q"new pl.metastack.metaweb.tree.Tag($tagName, $tagAttrs, Map.empty, Seq(..$tagChildren))")
    }
  }

  def HtmlImplT(c: Context)(fileName: c.Expr[String]): c.Expr[tree.Tag] = {
    val fileNameValue = Helpers.literalValueExpr(c)(fileName)
    val xml = XML.loadFile(fileNameValue)
    convert(c)(xml, root = true)
      .asInstanceOf[c.Expr[tree.Tag]]
  }

  def HtmlImpl(c: Context)(fileName: c.Expr[String]): c.Expr[state.Tag] =
    Helpers.treeToState(c)(HtmlImplT(c)(fileName))
      .asInstanceOf[c.Expr[state.Tag]]
}