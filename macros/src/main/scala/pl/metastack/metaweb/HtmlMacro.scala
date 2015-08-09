package pl.metastack.metaweb

import scala.language.experimental.macros
import scala.language.reflectiveCalls
import scala.reflect.macros.blackbox.Context

import pl.metastack.metarx.Var

import pl.metastack.metaweb.tag.HTMLTag

object HtmlMacro {
  implicit class Html(sc: StringContext) {
    def html(vars: Var[String]*): Node = macro HtmlImpl
  }

  def iter(node: scala.xml.Node, vars: Seq[Var[String]]): Seq[Node] = {
    node.label match {
      case "#PCDATA" =>
        // TODO Find a better solution
        val parts = node.text.replaceAll("""\$\{\d+\}""", "_$0_").split("_").toSeq

        parts.map { v =>
          if (v.startsWith("${") && v.endsWith("}")) {
            val index = v.drop(2).init.toInt
            Text(vars(index))
          } else {
            Text(Var(v))
          }
        }

      case s =>
        val tag = HTMLTag.fromTag(s)

        node.attributes.asAttrMap.foreach { case (k, v) =>
          if (v.startsWith("${") && v.endsWith("}")) {
            val index = v.drop(2).init.toInt
            tag.bind(k, vars(index))
          } else {
            tag.bind(k, Var(v))
          }
        }

        node.child.flatMap(iter(_, vars)).foreach(tag += _)
        Seq(tag)
    }
  }

  def insertPlaceholders(c: Context)(parts: Seq[c.universe.Tree]): String = {
    import c.universe._
    parts.zipWithIndex.map { case (x, i) =>
      x match {
        case Literal(Constant(p: String)) =>
          if (i == parts.length - 1) p
          else if (p.lastOption.contains('=')) p + "\"${" + i + "}\""
          else p + "${" + i + "}"
      }
    }.mkString
  }

  def convert(c: Context)(parts: Seq[c.universe.Tree],
                          vars: Seq[c.Expr[Var[String]]]): c.Expr[Node] = {
    import c.universe._
    val html = insertPlaceholders(c)(parts)

    val tree =
      q"""
      import scala.xml.XML
      val xml = XML.loadString($html)
      iter(xml, Seq(..$vars)).head
      """

    c.Expr(tree)
  }

  def HtmlImpl(c: Context)(vars: c.Expr[Var[String]]*): c.Expr[Node] = {
    import c.universe._

    c.prefix.tree match {
      case Apply(_, List(Apply(_, parts))) =>
        convert(c)(parts, vars)
    }
  }
}
