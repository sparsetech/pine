package pl.metastack.metaweb.tree.render

import pl.metastack.metaweb._
import pl.metastack.metaweb.tree

trait HTML[N <: tree.Node] extends tree.Render[N, String]

object HTML extends HTML[tree.Node] {
  trait Implicit {
    implicit class NodeToHtml(node: tree.Node) {
      def toHtml: String = HTML.render(node)
    }
  }

  override def render(node: tree.Node): String =
    node match {
      case n: tree.Tag  => RenderTag.render(n)
      case n: tree.Text => RenderText.render(n)
    }

  implicit case object RenderTag extends HTML[tree.Tag] {
    def render(node: tree.Tag): String = {
      val isLiteral = node.isInstanceOf[tag.Script]
      val children =
        if (isLiteral) node.children.collect { case t: tree.Text => t.text }
        else node.children.map(HTML.render)

      HtmlHelpers.node(node.tagName, node.attributes, children)
    }
  }

  implicit case object RenderText extends HTML[tree.Text] {
    def render(node: tree.Text): String = HtmlHelpers.encodeText(node.text)
  }
}
