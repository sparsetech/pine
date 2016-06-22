package pl.metastack.metaweb.macros

import scala.language.experimental.macros
import scala.language.reflectiveCalls

import scala.collection.mutable

import scala.reflect.macros.blackbox.Context

import scala.xml.XML

import pl.metastack.metaweb.tree

object InlineHtml {
  trait Implicit {
    implicit class HtmlString(sc: StringContext) {
      def html(args: Any*): tree.Tag = macro HtmlImpl
    }
  }

  def iter(c: Context)(node: scala.xml.Node,
                       args: Seq[c.Expr[Any]],
                       root: Boolean): Seq[c.Expr[Seq[tree.Node]]] = {
    import c.universe._

    val integerType = definitions.IntTpe
    val booleanType = definitions.BooleanTpe
    val stringType = definitions.StringClass.toType
    val optionStringType =
      appliedType(definitions.OptionClass, List(stringType))
    val nodeType = c.mirror.staticClass("pl.metastack.metaweb.tree.Node")
       .toType
    val seqType = c.mirror.staticClass("scala.collection.Seq")
    val seqNodeType = appliedType(seqType, List(nodeType))

    (node.label, Option(node.prefix)) match {
      case ("#PCDATA", _) =>
        // TODO Find a better solution
        val parts = node.text.replaceAll("""\$\{\d+\}""", "_$0_").split("_").toSeq

        parts.map { v =>
          if (!v.startsWith("${") || !v.endsWith("}"))
            c.Expr(q"Seq(pl.metastack.metaweb.tree.Text($v))")
          else {
            val index = v.drop(2).init.toInt

            args(index) match {
              case n if n.tree.tpe <:< nodeType => c.Expr(q"Seq($n)")
              case n if n.tree.tpe <:< seqNodeType =>
                n.asInstanceOf[c.Expr[Seq[tree.Node]]]
              case n if n.tree.tpe =:= integerType ||
                        n.tree.tpe =:= booleanType =>
                c.Expr(q"Seq(pl.metastack.metaweb.tree.Text($n.toString))")
              case n if n.tree.tpe =:= stringType =>
                c.Expr(q"Seq(pl.metastack.metaweb.tree.Text($n))")
              case n =>
                c.error(c.enclosingPosition, s"Type ${n.tree.tpe} (${n.tree.symbol}) not supported")
                null
            }
          }
        }

      case (tag, prefix) =>
        val tagName = prefix.map(pfx => s"$pfx:$tag").getOrElse(tag)
        val rootAttributes: Map[String, String] =
          if (root) Helpers.namespaceBinding(node.scope)
          else Map.empty

        val tagType = TypeName(tag.capitalize)
        val tagAttrs = mutable.ArrayBuffer.empty[c.Expr[Option[(String, Any)]]]

        (node.attributes.asAttrMap ++ rootAttributes).foreach { case (k, v) =>
          if (!v.startsWith("${") || !v.endsWith("}"))
            tagAttrs += c.Expr(q"Some($k -> $v)")
          else {
            val index = v.drop(2).init.toInt

            args(index) match {
              case a if a.tree.tpe =:= stringType =>
                tagAttrs += c.Expr(q"Some($k -> $a)")
              case a if a.tree.tpe <:< optionStringType =>
                tagAttrs += c.Expr(q"$a.map($k -> _)")
              case a =>
                c.error(c.enclosingPosition, s"Type ${a.tree.tpe} (${a.tree.symbol}) not supported")
                null
            }
          }
        }

        val tagChildren = node.child.flatMap(n => iter(c)(n, args, root = false))
        val qAttrs = q"Seq[Option[(String, String)]](..$tagAttrs).collect { case Some(x) => x }.toMap"

        try {
          c.typecheck(q"val x: pl.metastack.metaweb.tag.$tagType")
          Seq(c.Expr(q"Seq(new pl.metastack.metaweb.tag.$tagType($qAttrs, Seq(..$tagChildren).flatten))"))
        } catch { case t: Throwable =>
          Seq(c.Expr(q"Seq(pl.metastack.metaweb.tag.HTMLTag.fromTag($tagName, $qAttrs, Seq(..$tagChildren).flatten))"))
        }
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
                          args: Seq[c.Expr[Any]]): c.Expr[tree.Tag] = {
    import c.universe._
    val html = insertPlaceholders(c)(parts)
    val xml = XML.loadString(html)
    val nodes = iter(c)(xml, args, root = true).head
    c.Expr(q"$nodes.head").asInstanceOf[c.Expr[tree.Tag]]
  }

  def HtmlImpl(c: Context)(args: c.Expr[Any]*): c.Expr[tree.Tag] = {
    import c.universe._

    c.prefix.tree match {
      case Apply(_, List(Apply(_, parts))) =>
        convert(c)(parts, args)
    }
  }
}
