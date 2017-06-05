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
        case t @ Tag(_, _, _) => RenderTag.render(t)
        case n: Text          => RenderText.render(n)
      }

    implicit case object RenderTag extends NodeRender[Tag[SString], String] {
      def render(node: Tag[SString]): String = {
        val isLiteral = node.tagName == "script"
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
        case t @ Tag(_, _, _) => RenderTag.render(t)
        case n: Text          => RenderText.render(n)
      }

    implicit case object RenderTag extends NodeRender[Tag[SString], String] {
      def render(node: Tag[SString]): String = {
        def children(): String =
          node.children.map { child =>
            if (!lineBreak) Text.render(child)
            else {
              val text = Text.render(child).span(_.isSpaceChar)._2
              lineBreak = false
              text
            }
          }.mkString

        node.tagName match {
          case tag.Script.tagName => ""
          case tag.Br.tagName =>
            lineBreak = true
            "\n"
          case tag.Ul.tagName =>
            node.children.map {
              case li @ Tag("li", _, _) => "- " + Text.render(li).trim + "\n"
              case _ => ""
            }.mkString + "\n" + { lineBreak = true; "" }
          case tag.Div.tagName =>
            children() + "\n" + { lineBreak = true; "" }
          case tag.H1.tagName | tag.H2.tagName | tag.H3.tagName | tag.H4.tagName | tag.H5.tagName | tag.H6.tagName =>
            children() + "\n\n" + { lineBreak = true; "" }
          case tag.P.tagName =>
            children() + "\n\n" + { lineBreak = true; "" }
          case _ => children()
        }
      }
    }

    implicit case object RenderText extends NodeRender[Text, String] {
      def render(node: Text): String = node.text.replaceAll("\\s+", " ")
    }
  }
}
