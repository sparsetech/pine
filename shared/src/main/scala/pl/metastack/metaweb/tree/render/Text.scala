package pl.metastack.metaweb.tree.render

import pl.metastack.metaweb._
import pl.metastack.metaweb.tree

trait Text[N <: tree.Node] extends tree.Render[N, String]

object Text extends Text[tree.Node] {
  trait Implicit {
    implicit class NodeToText(node: tree.Node) {
      def toText: String = Text.render(node)
    }
  }

  override def render(node: tree.Node): String =
    node match {
      case n: tree.Tag  => RenderTag.render(n)
      case n: tree.Text => RenderText.render(n)
    }

  implicit case object RenderTag extends Text[tree.Tag] {
    def render(node: tree.Tag): String = {
      val isLiteral = node.isInstanceOf[tag.Script]
      val children =
        if (isLiteral) Seq.empty
        else node.children.map(Text.render)

      children.mkString
    }
  }

  implicit case object RenderText extends Text[tree.Text] {
    def render(node: tree.Text): String = node.text
  }
}
