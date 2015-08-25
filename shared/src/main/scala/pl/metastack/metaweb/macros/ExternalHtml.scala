package pl.metastack.metaweb.macros

import scala.xml.XML
import scala.language.reflectiveCalls
import scala.language.experimental.macros
import scala.reflect.macros.blackbox.Context

import pl.metastack.metaweb.tree.Node
import pl.metastack.metaweb.tree.{mutable, immutable}

object ExternalHtml {
  trait Import {
    def html(fileName: String): immutable.Node = macro HtmlImplImmutable

    // TODO Rename
    def htmlMutable(fileName: String): mutable.Node = macro HtmlImplMutable
  }

  def convert(c: Context)
             (node: scala.xml.Node, mutable: Boolean): c.Expr[Node] = {
    import c.universe._
    val namespace = TermName(if (mutable) "mutable" else "immutable")

    node.label match {
      case "#PCDATA" => c.Expr(q"tree.$namespace.Text(${node.text})")
      case tagName =>
        val tagNameIdent = TypeName(tagName.toLowerCase)

        val tagAttrs = node.attributes.asAttrMap.map { case (k, v) =>
          q"t.setAttribute($k, $v)"
        }

        val tagChildren = node.child.map { n =>
          q"t += ${convert(c)(n, mutable)}"
        }

        c.Expr(q"""
          import pl.metastack.metarx.Var
          import pl.metastack.metaweb.tag
          import pl.metastack.metaweb.tree

          val t = new tag.$namespace.$tagNameIdent
          ..$tagAttrs
          ..$tagChildren
          t
        """)
    }
  }

  def HtmlImpl(c: Context)(fileName: c.Expr[String],
                           mutable: Boolean): c.Expr[Node] = {
    val fileNameValue = Helpers.literalValueExpr(c)(fileName)
    val xml = XML.loadFile(fileNameValue)
    convert(c)(xml, mutable)
  }

  def HtmlImplImmutable(c: Context)
                       (fileName: c.Expr[String]): c.Expr[immutable.Node] =
    HtmlImpl(c)(fileName, mutable = false)
      .asInstanceOf[c.Expr[immutable.Node]]

  def HtmlImplMutable(c: Context)
                     (fileName: c.Expr[String]): c.Expr[mutable.Node] =
    HtmlImpl(c)(fileName, mutable = true)
      .asInstanceOf[c.Expr[mutable.Node]]
}