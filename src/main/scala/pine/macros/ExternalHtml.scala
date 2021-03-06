package pine.macros

import java.io.File

import scala.reflect.macros.blackbox.Context

import pine._

object ExternalHtml {
  trait Method {
    /** Expose `html` as a global method */
    def xml (fileName: String): Tag[Singleton] = macro XmlImpl
    def html(fileName: String): Tag[Singleton] = macro HtmlImpl
  }

  def convert(c: Context)(node: Node, root: Boolean): c.Expr[Node] = {
    import c.universe._

    node match {
      case Text(text) => c.Expr(q"pine.Text($text)")
      case tag @ Tag(_, _, _) =>
        val tagAttrs    = tag.attributes
        val tagChildren = tag.children.map(convert(c)(_, root = false))

        c.Expr(q"pine.Tag(${tag.tagName}, $tagAttrs, List(..$tagChildren))")
    }
  }

  def parse(c: Context, xml: Boolean)
           (fileName: c.Expr[String]): c.Expr[Tag[Singleton]] = {
    val path = new File(c.enclosingPosition.source.path).getParentFile
    val fileNameValue = Helpers.literalValueExpr(c)(fileName)
    val html = Helpers.readFile(new File(path, fileNameValue))
    val node = Parser.fromString(html, xml)
    convert(c)(node, root = true)
      .asInstanceOf[c.Expr[Tag[Singleton]]]
  }

  def XmlImpl(c: Context)(fileName: c.Expr[String]): c.Expr[Tag[Singleton]] =
    parse(c, xml = true)(fileName)

  def HtmlImpl(c: Context)(fileName: c.Expr[String]): c.Expr[Tag[Singleton]] =
    parse(c, xml = false)(fileName)
}
