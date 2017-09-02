package pine

trait NodeRender[N <: Node, T] {
  def render(s: N): T
}

object NodeRender {
  trait Implicits {
    implicit class NodeToHtml(node: Node) {
      def toXml : String = XML.render(node)
      def toHtml: String = HTML.render(node)
      def toText: String = {
        Text.lineBreak = false
        Text.render(node).trim
      }
    }
  }

  object HTML extends NodeRender[Node, String] {
    def render(node: Node): String =
      node match {
        case t @ Tag("html", _, _) => "<!DOCTYPE html>" + renderChild(t)
        case n                     => renderChild(n)
      }

    def renderChild(node: Node): String =
      node match {
        case Tag(tagName, attributes, children)
          if HtmlHelpers.CdataElements.contains(tagName) =>
          HtmlHelpers.node(
            tagName, attributes, children.collect { case c: Text => c.text },
            xml = false)

        case Tag(tagName, attributes, children) =>
          HtmlHelpers.node(
            tagName, attributes, children.map(renderChild), xml = false)

        case pine.Text(text) => HtmlHelpers.encodeText(text, xml = false)
      }
  }

  object XML extends NodeRender[Node, String] {
    def render(node: Node): String =
      """<?xml version="1.0" encoding="UTF-8"?>""" + renderChild(node)

    def renderChild(node: Node): String =
      node match {
        case Tag(tagName, attributes, children) =>
          HtmlHelpers.node(
            tagName, attributes, children.map(renderChild), xml = true)

        case pine.Text(text) => HtmlHelpers.encodeText(text, xml = true)
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

    implicit case object RenderTag extends NodeRender[Tag[_], String] {
      def render(node: Tag[_]): String = {
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
