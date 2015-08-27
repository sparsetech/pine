package pl.metastack.metaweb.render

import pl.metastack.metaweb.state
import pl.metastack.metaweb.{HtmlHelpers, Render}

trait HTML[N] extends Render[N, String]

trait HTMLImplicit {
  implicit class NodeToHtml(node: state.Node) {
    def toHtml: String = HTML.render(node)
  }
}

object HTML extends HTML[state.Node] with HTMLImplicit {
  override def render(node: state.Node): String =
    node match {
      case n: state.Null => RenderNull.render(n)
      case n: state.Placeholder => RenderPlaceholder.render(n)
      case n: state.Container => RenderContainer.render(n)
      case n: state.Text => RenderText.render(n)
      case n: state.Tag => RenderTag.render(n)
    }

  case object RenderNull extends HTML[state.Null] {
    def render(node: state.Null): String = ""
  }

  case object RenderPlaceholder extends HTML[state.Placeholder] {
    def render(node: state.Placeholder): String =
      node.get.map(_.toHtml).getOrElse("")
  }

  case object RenderContainer extends HTML[state.Container] {
    def render(node: state.Container): String =
      node.get.map(_.toHtml).mkString
  }

  case object RenderTag extends HTML[state.Tag] {
    def render(node: state.Tag): String =
      HtmlHelpers.node(
        node.name,
        node.attributes,
        node.children.map(_.toHtml))
  }

  case object RenderText extends HTML[state.Text] {
    def render(node: state.Text): String =
      HtmlHelpers.escape(node.get)
  }
}
