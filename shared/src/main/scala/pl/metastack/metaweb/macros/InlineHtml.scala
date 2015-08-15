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
      def html(args: Any*): Node = macro HtmlImpl
    }
  }

  def iter(c: Context)(node: scala.xml.Node,
                       args: Seq[c.Expr[Any]]): Seq[c.Expr[Node]] = {
    import c.universe._

    node.label match {
      case "#PCDATA" =>
        // TODO Find a better solution
        val parts = node.text.replaceAll("""\$\{\d+\}""", "_$0_").split("_").toSeq

        parts.map { v =>
          if (v.startsWith("${") && v.endsWith("}")) {
            val index = v.drop(2).init.toInt
            c.Expr(q"tree.Text(${args(index)})")
          } else {
            c.Expr(q"tree.Text(Var($v))")
          }
        }

      case tagName =>
        val tagNameIdent = TypeName(tagName.toLowerCase)

        val tagAttrs = node.attributes.asAttrMap.map { case (k, v) =>
          if (v.startsWith("${") && v.endsWith("}")) {
            val index = v.drop(2).init.toInt

            if (k.startsWith("on"))
              q"t.bindEvent(${k.drop(2)}, ${args(index)}.asInstanceOf[Any => Unit])"
            else q"t.bind($k, ${args(index)})"
          } else {
            if (k.startsWith("on")) q"t.bindEvent(${k.drop(2)}, $v.asInstanceOf[Any => Unit])"
            else q"t.bind($k, Var($v))"
          }
        }

        val tagChildren = node.child.flatMap { n =>
          val children = iter(c)(n, args)
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
                          args: Seq[c.Expr[Any]]): c.Expr[Node] = {
    val html = insertPlaceholders(c)(parts)
    val xml = XML.loadString(html)
    iter(c)(xml, args).head
  }

  def HtmlImpl(c: Context)(args: c.Expr[Any]*): c.Expr[Node] = {
    import c.universe._

    c.prefix.tree match {
      case Apply(_, List(Apply(_, parts))) =>
        convert(c)(parts, args)
    }
  }
}
