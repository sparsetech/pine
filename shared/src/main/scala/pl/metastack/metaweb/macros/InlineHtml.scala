package pl.metastack.metaweb.macros

import pl.metastack.metaweb.tree.Node

import scala.language.experimental.macros
import scala.language.reflectiveCalls
import scala.reflect.macros.blackbox.Context
import scala.xml.XML

import pl.metastack.metarx.Var

object InlineHtml {
  trait Import {
    implicit class Html(sc: StringContext) {
      def html(vars: Var[String]*): Node = macro HtmlImpl
    }
  }

  def iter(c: Context)(node: scala.xml.Node,
                       vars: Seq[c.Expr[Var[String]]]): Seq[c.Expr[Node]] = {
    import c.universe._

    node.label match {
      case "#PCDATA" =>
        // TODO Find a better solution
        val parts = node.text.replaceAll("""\$\{\d+\}""", "_$0_").split("_").toSeq

        parts.map { v =>
          if (v.startsWith("${") && v.endsWith("}")) {
            val index = v.drop(2).init.toInt
            c.Expr(q"tree.Text(${vars(index)})")
          } else {
            c.Expr(q"tree.Text(Var($v))")
          }
        }

      case tagName =>
        val tagNameIdent = TypeName(tagName.toLowerCase)

        val tagAttrs = node.attributes.asAttrMap.map { case (k, v) =>
          if (v.startsWith("${") && v.endsWith("}")) {
            val index = v.drop(2).init.toInt
            q"t.bind($k, ${vars(index)})"
          } else {
            q"t.bind($k, Var($v))"
          }
        }

        val tagChildren = node.child.flatMap { n =>
          val children = iter(c)(n, vars)
          children.map { child =>
            q"t += $child"
          }
        }

        Seq(
          c.Expr(q"""
            import pl.metastack.metarx.Var
            import pl.metastack.metaweb.tag
            import pl.metastack.metaweb.tree

            val t = new tag.$tagNameIdent
            ..$tagAttrs
            ..$tagChildren
            t
          """)
        )
    }
  }

  def insertPlaceholders(c: Context)(parts: Seq[c.universe.Tree]): String = {
    parts.zipWithIndex.map { case (tree, i) =>
      val p = Helpers.literalValueTree[String](c)(tree)

      if (i == parts.length - 1) p
      else if (p.lastOption.contains('=')) p + "\"${" + i + "}\""
      else p + "${" + i + "}"
    }.mkString
  }

  def convert(c: Context)(parts: Seq[c.universe.Tree],
                          vars: Seq[c.Expr[Var[String]]]): c.Expr[Node] = {
    val html = insertPlaceholders(c)(parts)
    val xml = XML.loadString(html)
    iter(c)(xml, vars).head
  }

  def HtmlImpl(c: Context)(vars: c.Expr[Var[String]]*): c.Expr[Node] = {
    import c.universe._

    c.prefix.tree match {
      case Apply(_, List(Apply(_, parts))) =>
        convert(c)(parts, vars)
    }
  }
}
