package pine.macros

import scala.language.reflectiveCalls
import scala.language.experimental.macros

import scala.reflect.macros.blackbox.Context

import pine._
import pine.internal.HtmlParser

object InlineHtml {
  trait Implicit {
    implicit class HtmlString(sc: StringContext) {
      def xml (args: Any*): Tag[Singleton] = macro XmlImpl
      def html(args: Any*): Tag[Singleton] = macro HtmlImpl
    }
  }

  def convertTag[T <: Singleton](c: Context)(tag: Tag[T],
                                             args: Seq[c.Expr[Any]]
                                            ): c.Expr[Tag[T]] = {
    import c.universe._

    val integerType = definitions.IntTpe
    val booleanType = definitions.BooleanTpe
    val stringType = definitions.StringClass.toType
    val optionStringType =
      appliedType(definitions.OptionClass, List(stringType))
    val nodeType = c.mirror.staticClass("pine.Node").toType
    val listType = c.mirror.staticClass("scala.collection.immutable.List")
    val listNodeType = appliedType(listType, List(nodeType))

    val tagAttrs = tag.attributes.mapValues(_.toString).map { case (k, v) =>
      if (!v.startsWith("${") || !v.endsWith("}"))
        c.Expr(q"List($k -> $v)")
      else {
        val index = v.drop(2).init.toInt

        args(index) match {
          case a if a.tree.tpe =:= stringType =>
            c.Expr(q"List($k -> $a)")
          case a if a.tree.tpe <:< optionStringType =>
            c.Expr(q"$a.map($k -> _).toList")
          case a =>
            c.error(c.enclosingPosition,
              s"Type ${a.tree.tpe} (${a.tree.symbol}) not supported")
            null
        }
      }
    }

    val tagChildren = tag.children.flatMap {
      case t @ Tag(_, _, _) =>
        val tag = convertTag(c)(t, args)
        List(c.Expr(q"List($tag)"))

      case Text(text) =>
        // TODO Find a better solution
        val parts = text.replaceAll("""\$\{\d+\}""", "_$0_").split("_")
          .toList.filter(_.nonEmpty)

        parts.map { v =>
          if (!v.startsWith("${") || !v.endsWith("}"))
            c.Expr(q"List(pine.Text($v))")
          else {
            val index = v.drop(2).init.toInt

            args(index) match {
              case n if n.tree.tpe <:< nodeType => c.Expr(q"List($n)")
              case n if n.tree.tpe <:< listNodeType =>
                n.asInstanceOf[c.Expr[List[Node]]]
              case n if n.tree.tpe =:= integerType ||
                        n.tree.tpe =:= booleanType =>
                c.Expr(q"List(pine.Text($n.toString))")
              case n if n.tree.tpe =:= stringType =>
                c.Expr(q"List(pine.Text($n))")
              case n =>
                c.error(c.enclosingPosition,
                  s"Type ${n.tree.tpe} (${n.tree.symbol}) not supported")
                null
            }
          }
        }
    }

    c.Expr(q"""
      pine.Tag(
        ${tag.tagName},
        List(..$tagAttrs).flatten.toMap,
        List(..$tagChildren).flatten
      )
    """)
  }

  def insertPlaceholders(c: Context)(parts: List[c.universe.Tree]): String =
    parts.zipWithIndex.map { case (tree, i) =>
      val p = Helpers.literalValueTree[String](c)(tree)

      if (i == parts.length - 1) p
      else if (p.lastOption.contains('=')) p + "\"${" + i + "}\""
      else p + "${" + i + "}"
    }.mkString

  def convert(c: Context, xml: Boolean)
             (parts: List[c.universe.Tree],
              args: Seq[c.Expr[Any]]
             ): c.Expr[Tag[Singleton]] = {
    val html = insertPlaceholders(c)(parts)
    val node = HtmlParser.fromString(html, xml)
    convertTag(c)(node, args)
  }

  def XmlImpl(c: Context)(args: c.Expr[Any]*): c.Expr[Tag[Singleton]] = {
    import c.universe._

    c.prefix.tree match {
      case Apply(_, List(Apply(_, parts))) =>
        convert(c, xml = true)(parts, args)
    }
  }

  def HtmlImpl(c: Context)(args: c.Expr[Any]*): c.Expr[Tag[Singleton]] = {
    import c.universe._

    c.prefix.tree match {
      case Apply(_, List(Apply(_, parts))) =>
        convert(c, xml = false)(parts, args)
    }
  }
}
