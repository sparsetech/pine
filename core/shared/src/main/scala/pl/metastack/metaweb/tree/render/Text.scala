package pl.metastack.metaweb.tree.render

import pl.metastack.metaweb._
import pl.metastack.metaweb.tree

trait Text[N <: tree.Node] extends tree.Render[N, String]

object Text extends Text[tree.Node] {
  // TODO Don't mutate global state
  private var lineBreak = false

  trait Implicit {
    implicit class NodeToText(node: tree.Node) {
      def toText: String = {
        lineBreak = false
        Text.render(node).trim
      }
    }
  }

  override def render(node: tree.Node): String =
    node match {
      case n: tree.Tag  => RenderTag.render(n)
      case n: tree.Text => RenderText.render(n)
    }

  implicit case object RenderTag extends Text[tree.Tag] {
    def render(node: tree.Tag): String = {
      def children(): String =
        node.children.map { child =>
          if (!lineBreak) Text.render(child)
          else {
            val text = Text.render(child).span(_.isSpaceChar)._2
            lineBreak = false
            text
          }
        }.mkString

      node match {
        case t: tag.Script => ""
        case t: tag.Br =>
          lineBreak = true
          "\n"
        case t: tag.Ul =>
          node.children.map {
            case li: tag.Li => "- " + Text.render(li).trim + "\n"
            case n => ""
          }.mkString + "\n" + { lineBreak = true; "" }
        case _: tag.Div =>
          children() + "\n" + { lineBreak = true; "" }
        case _: tag.H1 | _: tag.H2 | _: tag.H3 | _: tag.H4 | _: tag.H5 | _: tag.H6 =>
          children() + "\n\n" + { lineBreak = true; "" }
        case t: tag.P =>
          children() + "\n\n" + { lineBreak = true; "" }
        case t: tree.Tag => children()
      }
    }
  }

  implicit case object RenderText extends Text[tree.Text] {
    def render(node: tree.Text): String = node.text.replaceAll("\\s+", " ")
  }
}
