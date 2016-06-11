package pl.metastack.metaweb.tree.render

import pl.metastack.metaweb._
import pl.metastack.metaweb.tree._

trait HTML[N <: tree.Node] extends Render[N, String]

object HTML extends HTML[Node] {
  trait Implicit {
    implicit class NodeToHtml(node: Node) {
      def toHtml: String = HTML.render(node)
    }
  }

  override def render(node: Node): String =
    node match {
      case n: Tag  => RenderTag.render(n)
      case n: Text => RenderText.render(n)
    }

  implicit case object RenderTag extends HTML[Tag] {
    def render(node: Tag): String = {
      val isLiteral = node.isInstanceOf[tag.Script]
      val children =
        if (isLiteral) node.children.collect { case t: Text => t.text }
        else node.children.map(HTML.render)

      HtmlHelpers.node(node.tagName, node.attributes, children)
    }
  }

  implicit case object RenderText extends HTML[Text] {
    def render(node: Text): String = HtmlHelpers.escape(node.text)
  }
}
