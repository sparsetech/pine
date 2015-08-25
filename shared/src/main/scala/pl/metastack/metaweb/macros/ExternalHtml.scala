package pl.metastack.metaweb.macros

import pl.metastack.metaweb.tree.reactive.Node

import scala.language.experimental.macros
import scala.language.reflectiveCalls
import scala.reflect.macros.blackbox.Context
import scala.xml.XML

object ExternalHtml {
  trait Import {
    def html(fileName: String): Node = macro HtmlImpl
  }

  def iter(c: Context)(node: scala.xml.Node): c.Expr[Node] = {
    import c.universe._
    node.label match {
      case "#PCDATA" => c.Expr(q"tree.reactive.Text(Var(${node.text}))")
      case tagName =>
        val tagNameIdent = TypeName(tagName.toLowerCase)

        val tagAttrs = node.attributes.asAttrMap.map { case (k, v) =>
          q"t.setAttribute($k, $v)"
        }

        val tagChildren = node.child.map { n =>
          q"t += ${iter(c)(n)}"
        }

        c.Expr(q"""
          import pl.metastack.metarx.Var
          import pl.metastack.metaweb.tag
          import pl.metastack.metaweb.tree.reactive

          val t = new tag.$tagNameIdent
          ..$tagAttrs
          ..$tagChildren
          t
        """)
    }
  }

  def HtmlImpl(c: Context)(fileName: c.Expr[String]): c.Expr[Node] = {
    val fileNameValue = Helpers.literalValueExpr(c)(fileName)
    val xml = XML.loadFile(fileNameValue)
    iter(c)(xml)
  }
}