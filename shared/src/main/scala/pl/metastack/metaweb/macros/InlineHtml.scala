package pl.metastack.metaweb.macros

import scala.language.experimental.macros
import scala.language.reflectiveCalls
import scala.reflect.macros.blackbox.Context
import scala.xml.XML

import pl.metastack.metaweb.tree.Node
import pl.metastack.metaweb.tree.{mutable, immutable}

object InlineHtml {
  trait Import {
    implicit class Html(sc: StringContext) {
      def html(args: Any*): Node = macro HtmlImplImmutable
      def htmlMutable(args: Any*): Node = macro HtmlImplMutable
    }
  }

  val nodeTypes = Set(
    "pl.metastack.metaweb.tree.Node",
    "pl.metastack.metaweb.tree.mutable.Node",
    "pl.metastack.metaweb.tree.immutable.Node")

  def iter(c: Context)(node: scala.xml.Node,
                       args: Seq[c.Expr[Any]],
                       mutable: Boolean): Seq[c.Expr[Node]] = {
    import c.universe._
    val namespace = TermName(if (mutable) "mutable" else "immutable")

    node.label match {
      case "#PCDATA" =>
        // TODO Find a better solution
        val parts = node.text.replaceAll( """\$\{\d+\}""", "_$0_").split("_").toSeq

        parts.map { v =>
          if (v.startsWith("${") && v.endsWith("}")) {
            val index = v.drop(2).init.toInt

            args(index) match {
              case n: c.Expr[Node]
                if nodeTypes.contains(n.tree.tpe.toString) => n
              case n: c.Expr[Seq[Node]]
                if nodeTypes.map(t => s"Seq[$t]").contains(n.tree.tpe.toString) =>
                  c.Expr(q"tree.$namespace.PlaceholderSeqNode($n)")
              case n: c.Expr[String]
                if n.tree.tpe.toString == "String" =>
                  c.Expr(q"tree.$namespace.Text($n)")
              case n if mutable => c.Expr(q"tree.$namespace.Text($n)")
              case n if !mutable =>
                c.error(c.enclosingPosition, "Use `mutable` variant")
                null
            }
          } else {
            c.Expr(q"tree.$namespace.Text($v)")
          }
        }

      case tagName =>
        val tagNameIdent = TypeName(tagName.toLowerCase)

        val tagAttrs = node.attributes.asAttrMap.map { case (k, v) =>
          if (v.startsWith("${") && v.endsWith("}")) {
            val index = v.drop(2).init.toInt

            if (k.startsWith("on"))
              q"t.setEvent(${k.drop(2)}, ${args(index)}.asInstanceOf[Any => Unit])"
            else {
              args(index) match {
                case a: c.Expr[String]
                  if a.tree.tpe.toString == "String" => q"t.setAttribute($k, $a)"

                case a: c.Expr[Option[String]]
                  if a.tree.tpe.toString == "Option[String]" ||
                     a.tree.tpe.toString == "Some[String]" ||
                     a.tree.tpe.toString == "None.type" =>
                  q"$a.foreach(v => t.setAttribute($k, v))"

                case a if mutable => q"t.bindAttribute($k, $a)"

                case a if !mutable =>
                  c.error(c.enclosingPosition, "Use `mutable` variant")
                  null
              }
            }
          } else {
            if (k.startsWith("on")) q"t.setEvent(${k.drop(2)}, $v.asInstanceOf[Any => Unit])"
            else q"t.setAttribute($k, $v)"
          }
        }

        val tagChildren = node.child.flatMap { n =>
          val children = iter(c)(n, args, mutable)
          children.map { child =>
            q"t += $child"
          }
        }

        Seq(
          c.Expr(q"""
            import pl.metastack.metaweb.tag
            import pl.metastack.metaweb.tree

            val t = new tag.mutable.$tagNameIdent
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
                          args: Seq[c.Expr[Any]],
                          mutable: Boolean): c.Expr[Node] = {
    val html = insertPlaceholders(c)(parts)
    val xml = XML.loadString(html)
    iter(c)(xml, args, mutable).head
  }

  def HtmlImpl(c: Context)(args: Seq[c.Expr[Any]],
                           mutable: Boolean): c.Expr[Node] = {
    import c.universe._

    c.prefix.tree match {
      case Apply(_, List(Apply(_, parts))) =>
        convert(c)(parts, args, mutable)
    }
  }

  def HtmlImplImmutable(c: Context)
                       (args: c.Expr[Any]*): c.Expr[immutable.Node] =
    HtmlImpl(c)(args, mutable = false)
      .asInstanceOf[c.Expr[immutable.Node]]

  def HtmlImplMutable(c: Context)(args: c.Expr[Any]*): c.Expr[mutable.Node] =
    HtmlImpl(c)(args, mutable = true)
      .asInstanceOf[c.Expr[mutable.Node]]
}
