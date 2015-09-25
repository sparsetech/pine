package pl.metastack.metaweb.render

import pl.metastack.metaweb._

trait HTML[N] extends Render[N, String]

trait HTMLImplicit {
  implicit class NodeToHtml(node: Node) {
    def toHtml: String = HTML.render(node)
  }
}

object HTML extends HTML[Node] with HTMLImplicit {
  override def render(node: Node): String =
    node match {
      case n: Null => RenderNull.render(n)
      case n: Placeholder => RenderPlaceholder.render(n)
      case n: Container => RenderContainer.render(n)
      case n: Text => RenderText.render(n)
      case n: Tag => RenderTag.render(n)
    }

  case object RenderNull extends HTML[Null] {
    def render(node: Null): String = ""
  }

  case object RenderPlaceholder extends HTML[Placeholder] {
    def render(node: Placeholder): String =
      node.node.map(_.toHtml).getOrElse("")
  }

  case object RenderContainer extends HTML[Container] {
    def render(node: Container): String =
      node.nodes.map(_.toHtml).mkString
  }

  case object RenderTag extends HTML[Tag] {
    def render(node: Tag): String = {
      val literal = node.tagName == "code"
      val children =
        if (literal) node.children.collect { case t: Text => t.text }
        else node.children.map(_.toHtml)

      HtmlHelpers.node(node.tagName, node.attributes, children)
    }
  }

  case object RenderText extends HTML[Text] {
    def render(node: Text): String =
      HtmlHelpers.escape(node.text)
  }
}
