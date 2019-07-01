package pine.macros

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

  def leftOrErr[A, B](either: Either[A,B]): A =
    either.fold(
      left => left,
      _ => throw new NoSuchElementException("Either.left.get on Right")
    )

  /** @return Left if string value, Right if optional value */
  def convertAttribute(c: Context)(
    value: String, args: Seq[c.Expr[Any]]
  ): Either[c.Expr[Any], c.Expr[Any]] = {
    import c.universe._

    val stringType = definitions.StringClass.toType
    val optionStringType =
      appliedType(definitions.OptionClass, List(stringType))

    value.indexOf("${") match {
      case -1    => Left(c.Expr(q"$value"))
      case start =>
        val end    = value.indexOf("}")
        val index  = value.substring(start + 2, end).toInt
        val prefix = value.substring(0, start)
        val suffix = value.substring(end + 1)

        args(index) match {
          case a if a.tree.tpe =:= stringType =>
            Left(
              (prefix, suffix) match {
                case ("", "") => a
                case (p, "") => c.Expr(q"$p + $a")
                case ("", s) =>
                  c.Expr(q"$a + ${leftOrErr(convertAttribute(c)(s, args))}")
                case (p, s) =>
                  c.Expr(q"$p + $a + ${leftOrErr(convertAttribute(c)(s, args))}")
              }
            )

          case a if a.tree.tpe <:< optionStringType =>
            if (prefix.nonEmpty || suffix.nonEmpty)
              c.error(c.enclosingPosition,
                s"${a.tree.symbol} must not have a prefix or suffix")

            Right(a)

          case a =>
            c.error(c.enclosingPosition,
              s"Type ${a.tree.tpe} (${a.tree.symbol}) not supported")
            null
        }
    }
  }

  def convertTag[T <: Singleton](c: Context)(tag: Tag[T],
                                             args: Seq[c.Expr[Any]]
                                            ): c.Expr[Tag[T]] = {
    import c.universe._

    val integerType  = definitions.IntTpe
    val booleanType  = definitions.BooleanTpe
    val stringType   = definitions.StringClass.toType
    val nodeType     = c.mirror.staticClass("pine.Node").toType
    val listType     = c.mirror.staticClass("scala.collection.immutable.List")
    val listNodeType = appliedType(listType, List(nodeType))

    val tagAttrs = tag.attributes.map { case (k, v) =>
      convertAttribute(c)(v, args) match {
        case Left (a) => c.Expr(q"List($k -> $a)")
        case Right(a) => c.Expr(q"$a.map($k -> _).toList")
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
