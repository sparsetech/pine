package pine.macros

import java.io.File

import scala.language.reflectiveCalls
import scala.language.experimental.macros
import scala.reflect.macros.blackbox.Context

import pine._
import pine.internal.HtmlParser

object ExternalHtml {
  trait Method {
    /** Expose `html` as a global method */
    def html(fileName: String): Tag[Singleton] = macro HtmlImpl
  }

  def convert(c: Context)(node: Node, root: Boolean): c.Expr[Node] = {
    import c.universe._

    node match {
      case Text(text) => c.Expr(q"pine.Text($text)")
      case tag @ Tag(_, _, _) =>
        val tagAttrs    = tag.attributes.mapValues(_.toString)
        val tagChildren = tag.children.map(convert(c)(_, root = false))

        c.Expr(q"pine.Tag(${tag.tagName}, $tagAttrs, List(..$tagChildren))")
    }
  }

  def HtmlImpl(c: Context)(fileName: c.Expr[String]): c.Expr[Tag[Singleton]] = {
    val fileNameValue = Helpers.literalValueExpr(c)(fileName)
    val html = io.Source.fromFile(new File(fileNameValue)).mkString
    val node = HtmlParser.fromString(html)
    convert(c)(node, root = true)
      .asInstanceOf[c.Expr[Tag[Singleton]]]
  }
}