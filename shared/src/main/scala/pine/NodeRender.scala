package pine

trait NodeRender[N <: Node, T] {
  def render(s: N): T
}

object NodeRender {
  trait Implicits {
    implicit class NodeToHtml(node: Node) {
      def toHtml: String = HTML.render(node)
      def toText: String = {
        Text.lineBreak = false
        Text.render(node).trim
      }
    }
  }

  object HTML extends NodeRender[Node, String] {
    override def render(node: Node): String =
      node match {
        case n: Tag  => RenderTag.render(n)
        case n: Text => RenderText.render(n)
      }

    implicit case object RenderTag extends NodeRender[Tag, String] {
      def render(node: Tag): String = {
        val isLiteral = node.isInstanceOf[tag.Script]
        val children =
          if (isLiteral) node.children.collect { case t: Text => t.text }
          else node.children.map(HTML.render)

        HtmlHelpers.node(node.tagName, node.attributes, children)
      }
    }

    implicit case object RenderText extends NodeRender[Text, String] {
      def render(node: Text): String = HtmlHelpers.encodeText(node.text)
    }
  }

  object Text extends NodeRender[Node, String] {
    // TODO Don't mutate global state
    private[pine] var lineBreak = false

    override def render(node: Node): String =
      node match {
        case n: Tag  => RenderTag.render(n)
        case n: Text => RenderText.render(n)
      }

    implicit case object RenderTag extends NodeRender[Tag, String] {
      def render(node: Tag): String = {
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
          case _: tag.Script => ""
          case _: tag.Br =>
            lineBreak = true
            "\n"
          case _: tag.Ul =>
            node.children.map {
              case li: tag.Li => "- " + Text.render(li).trim + "\n"
              case _ => ""
            }.mkString + "\n" + { lineBreak = true; "" }
          case _: tag.Div =>
            children() + "\n" + { lineBreak = true; "" }
          case _: tag.H1 | _: tag.H2 | _: tag.H3 | _: tag.H4 | _: tag.H5 | _: tag.H6 =>
            children() + "\n\n" + { lineBreak = true; "" }
          case _: tag.P =>
            children() + "\n\n" + { lineBreak = true; "" }
          case _: Tag => children()
        }
      }
    }

    implicit case object RenderText extends NodeRender[Text, String] {
      def render(node: Text): String = node.text.replaceAll("\\s+", " ")
    }
  }
}
