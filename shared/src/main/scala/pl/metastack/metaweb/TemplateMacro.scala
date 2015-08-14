package pl.metastack.metaweb

import scala.language.reflectiveCalls
import scala.language.experimental.macros
import scala.reflect.macros.blackbox.Context

import scala.xml.XML

object TemplateMacro {
  object Template {
    def apply(fileName: String): Node = macro TemplateImpl
  }

  def iter(c: Context)(node: scala.xml.Node): c.Expr[Node] = {
    import c.universe._
    node.label match {
      case "#PCDATA" => c.Expr(q"Text(Var(${node.text}))")
      case tagName =>
        val tagNameIdent = TypeName(tagName.toLowerCase)

        val tagAttrs = node.attributes.asAttrMap.map { case (k, v) =>
          q"t.bind($k, Var($v))"
        }

        val tagChildren = node.child.map { n =>
          q"t += ${iter(c)(n)}"
        }

        c.Expr(q"""
          import pl.metastack.metarx.Var
          import pl.metastack.metaweb.tag

          val t = new tag.$tagNameIdent
          ..$tagAttrs
          ..$tagChildren
          t
        """)
    }
  }

  def TemplateImpl(c: Context)(fileName: c.Expr[String]): c.Expr[Node] = {
    val fileNameValue = MacroHelpers.literalValueExpr(c)(fileName)
    val xml = XML.loadFile(fileNameValue)
    iter(c)(xml)
  }
}