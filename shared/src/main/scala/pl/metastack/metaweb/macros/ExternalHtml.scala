package pl.metastack.metaweb.macros

import scala.language.reflectiveCalls
import scala.language.experimental.macros

import scala.reflect.macros.blackbox.Context

import scala.xml.XML

import pl.metastack.metaweb.tree
import pl.metastack.metaweb.state

object ExternalHtml {
  trait Import {
    def html(fileName: String): state.zeroway.Tag = macro HtmlImpl0
    def html1(fileName: String): state.oneway.Tag = macro HtmlImpl1
    def html2(fileName: String): state.twoway.Tag = macro HtmlImpl2
    def htmlT(fileName: String): tree.Tag = macro HtmlImplT
  }

  def convert(c: Context)(node: scala.xml.Node): c.Expr[tree.Node] = {
    import c.universe._

    node.label match {
      case "#PCDATA" => c.Expr(q"pl.metastack.metaweb.tree.Text(${node.text})")
      case tagName =>
        val tagAttrs = node.attributes.asAttrMap
        val tagChildren = node.child.map(convert(c)(_))
        c.Expr(q"new pl.metastack.metaweb.tree.Tag($tagName, $tagAttrs, Map.empty, Seq(..$tagChildren))")
    }
  }

  def HtmlImplT(c: Context)(fileName: c.Expr[String]): c.Expr[tree.Tag] = {
    val fileNameValue = Helpers.literalValueExpr(c)(fileName)
    val xml = XML.loadFile(fileNameValue)
    convert(c)(xml)
      .asInstanceOf[c.Expr[tree.Tag]]
  }

  def HtmlImpl0(c: Context)(fileName: c.Expr[String]): c.Expr[state.zeroway.Tag] =
    Helpers.treeToState(c)(HtmlImplT(c)(fileName), way = 0)
      .asInstanceOf[c.Expr[state.zeroway.Tag]]

  def HtmlImpl1(c: Context)(fileName: c.Expr[String]): c.Expr[state.oneway.Tag] =
    Helpers.treeToState(c)(HtmlImplT(c)(fileName), way = 1)
      .asInstanceOf[c.Expr[state.oneway.Tag]]

  def HtmlImpl2(c: Context)(fileName: c.Expr[String]): c.Expr[state.twoway.Tag] =
    Helpers.treeToState(c)(HtmlImplT(c)(fileName), way = 2)
      .asInstanceOf[c.Expr[state.twoway.Tag]]
}