package pl.metastack.metaweb.macros

import scala.language.experimental.macros
import scala.language.reflectiveCalls

import scala.collection.mutable

import scala.reflect.macros.blackbox.Context

import scala.xml.{NamespaceBinding, XML}

import pl.metastack.metaweb.tree
import pl.metastack.metaweb.state

object InlineHtml {
  trait Import {
    implicit class Html(sc: StringContext) {
      def html(args: Any*): state.zeroway.Tag = macro HtmlImpl0
      def htmlR(args: Any*): state.reactive.Tag = macro HtmlImplR
      def htmlT(args: Any*): tree.Tag = macro HtmlImplT
    }
  }

  def iter(c: Context)(node: scala.xml.Node,
                       args: Seq[c.Expr[Any]],
                       root: Boolean): Seq[c.Expr[tree.Node]] = {
    import c.universe._

    (node.label, Option(node.prefix)) match {
      case ("#PCDATA", _) =>
        // TODO Find a better solution
        val parts = node.text.replaceAll("""\$\{\d+\}""", "_$0_").split("_").toSeq

        parts.map { v =>
          if (!v.startsWith("${") || !v.endsWith("}")) c.Expr(q"pl.metastack.metaweb.tree.Text($v)")
          else {
            val index = v.drop(2).init.toInt

            args(index) match {
              // TODO proper type-check
              case n: c.Expr[tree.Node]
                if n.tree.tpe.toString == "pl.metastack.metaweb.tree.Node" => n
              case n: c.Expr[tree.Tag]
                if n.tree.tpe.toString == "pl.metastack.metaweb.tree.Tag" => n

              case n: c.Expr[Seq[tree.Node]]
                if n.tree.tpe.toString == "Seq[pl.metastack.metaweb.tree.Node]" =>
                  c.Expr(q"pl.metastack.metaweb.tree.Container($n)")
              case n: c.Expr[Seq[tree.Tag]]
                if n.tree.tpe.toString == "Seq[pl.metastack.metaweb.tree.Tag]" =>
                c.Expr(q"pl.metastack.metaweb.tree.Container($n)")

              case n: c.Expr[String]
                if n.tree.tpe.toString == "String" =>
                  c.Expr(q"pl.metastack.metaweb.tree.Text($n)")
              case n =>
                c.error(c.enclosingPosition, s"Type of $n not supported")
                null
            }
          }
        }

      case (tag, prefix) =>
        val tagName = prefix.map(pfx => s"$pfx:$tag").getOrElse(tag)
        val rootAttributes: Map[String, String] =
          if (root) Helpers.namespaceBinding(node.scope)
          else Map.empty

        val tagAttrs = mutable.ArrayBuffer.empty[c.Expr[Option[(String, Any)]]]
        val tagEvents = mutable.ArrayBuffer.empty[c.Expr[(String, Seq[Any] => Unit)]]

        (node.attributes.asAttrMap ++ rootAttributes).foreach { case (k, v) =>
          if (!v.startsWith("${") || !v.endsWith("}")) {
            if (k.startsWith("on")) tagEvents += c.Expr(q"${k.drop(2)} -> $v.asInstanceOf[Any => Unit]")
            else tagAttrs += c.Expr(q"Some($k -> $v)")
          } else {
            val index = v.drop(2).init.toInt

            if (k.startsWith("on"))
              tagEvents += c.Expr(q"${k.drop(2)} -> ${args(index)}.asInstanceOf[Any => Unit]")
            else {
              args(index) match {
                case a: c.Expr[String]
                  if a.tree.tpe.toString == "String" =>
                  tagAttrs += c.Expr(q"Some($k -> $a)")

                case a: c.Expr[Option[String]]
                  if a.tree.tpe.toString == "Option[String]" ||
                     a.tree.tpe.toString == "Some[String]" ||
                     a.tree.tpe.toString == "None.type" =>
                  tagAttrs += c.Expr(q"$a.map(v => $k -> v)")

                case a =>
                  c.error(c.enclosingPosition, s"Type of $a not supported")
                  null
              }
            }
          }
        }

        val tagChildren = node.child.flatMap(n => iter(c)(n, args, root = false))

        Seq(c.Expr(
          q"""new pl.metastack.metaweb.tree.Tag(
            $tagName,
            Seq[Option[(String, String)]](..$tagAttrs).collect { case Some(x) => x }.toMap,
            Seq(..$tagEvents).toMap,
            Seq(..$tagChildren)
          )
        """))
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
    val html = insertPlaceholders(c)(parts)
    val xml = XML.loadString(html)
    iter(c)(xml, args, root = true).head
      .asInstanceOf[c.Expr[tree.Tag]]
  }

  def HtmlImplT(c: Context)(args: c.Expr[Any]*): c.Expr[tree.Tag] = {
    import c.universe._

    c.prefix.tree match {
      case Apply(_, List(Apply(_, parts))) =>
        convert(c)(parts, args)
    }
  }

  def HtmlImpl0(c: Context)(args: c.Expr[Any]*): c.Expr[state.zeroway.Tag] =
    Helpers.treeToState(c)(HtmlImplT(c)(args: _*), way = 0)
      .asInstanceOf[c.Expr[state.zeroway.Tag]]

  def HtmlImplR(c: Context)(args: c.Expr[Any]*): c.Expr[state.reactive.Tag] =
    Helpers.treeToState(c)(HtmlImplT(c)(args: _*), way = 1)
      .asInstanceOf[c.Expr[state.reactive.Tag]]
}
