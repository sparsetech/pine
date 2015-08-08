package pl.metastack.metaweb

import java.io.File

import scala.language.reflectiveCalls
import scala.language.experimental.macros
import scala.reflect.macros.blackbox.Context

import pl.metastack.metarx.Var

import pl.metastack.metaweb.tag.HTMLTag

import scala.xml.XML

object TemplateMacro {
  class Template(val nodes: Seq[Node]) {
    def byId[T <: Tag](id: String): T =
      nodes.collectFirst {
        case t: Tag if t.byIdOpt(id).isDefined => t.byIdOpt(id).get  // TODO optimise
      }.get
  }

  object Template {
    def apply(fileName: String): Template = macro TemplateImpl
  }

  def iter(node: scala.xml.Node): Seq[Node] = {
    node.label match {
      case "#PCDATA" => Seq(Text(Var(node.text)))

      case s =>
        val tag = HTMLTag.fromTag(s)

        node.attributes.asAttrMap.foreach { case (k, v) =>
          tag.bind(k, Var(v))
        }

        node.child.flatMap(iter).foreach(tag += _)
        Seq(tag)
    }
  }

  def loadXml(file: String): Seq[scala.xml.Node] = {
    import scala.xml.XML
    val xml = scala.io.Source.fromFile(new File(file)).mkString
    XML.loadString(s"<xml>$xml</xml>").child
  }

  def convert(c: Context)(fileName: c.Expr[String]): c.Expr[Template] = {
    import c.universe._

    val tree =
      q"""
      val xml = loadXml($fileName)
      new Template(xml.flatMap(iter))
      """

    c.Expr(tree)
  }

  def TemplateImpl(c: Context)(fileName: c.Expr[String]): c.Expr[Template] = {
    convert(c)(fileName)
  }
}
