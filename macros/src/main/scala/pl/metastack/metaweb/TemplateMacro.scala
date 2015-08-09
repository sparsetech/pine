package pl.metastack.metaweb

import scala.language.reflectiveCalls
import scala.language.experimental.macros
import scala.reflect.macros.blackbox.Context

import pl.metastack.metarx.Var

import pl.metastack.metaweb.tag.HTMLTag

object TemplateMacro {
  class Template(val node: Node) {
    def byId[T <: Tag](id: String): T =
      node match {
        case t: Tag => t.byIdOpt(id).get
        case _ => throw new RuntimeException("Root node must be a tag")
      }

    override def toString: String = node.toHtml
  }

  object Template {
    def apply(fileName: String): Template = macro TemplateImpl
  }

  def iter(node: scala.xml.Node): Node = {
    node.label match {
      case "#PCDATA" => Text(Var(node.text))

      case s =>
        val tag = HTMLTag.fromTag(s)

        node.attributes.asAttrMap.foreach { case (k, v) =>
          tag.bind(k, Var(v))
        }

        node.child.foreach(tag += iter(_))
        tag
    }
  }

  def convert(c: Context)(fileName: c.Expr[String]): c.Expr[Template] = {
    import c.universe._

    val tree =
      q"""
      import scala.xml.XML
      val xml = XML.loadFile($fileName)
      new Template(iter(xml))
      """

    c.Expr(tree)
  }

  def TemplateImpl(c: Context)(fileName: c.Expr[String]): c.Expr[Template] = {
    convert(c)(fileName)
  }
}
