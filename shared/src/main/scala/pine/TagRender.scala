package pine

trait TagRender[N <: Tag[_], T] {
  def render(s: N): T
}

object TagRender {
  trait Implicits {
    implicit class TagToHtml(tag: Tag[_]) {
      def toXml : String = XML.render(tag)
      def toHtml: String = HTML.render(tag)
      def toText: String = Text.render(tag)
    }
  }

  object HTML extends TagRender[Tag[_], String] {
    override def render(tag: Tag[_]): String =
      tag match {
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

  object XML extends TagRender[Tag[_], String] {
    override def render(tag: Tag[_]): String =
      """<?xml version="1.0" encoding="UTF-8"?>""" + renderChild(tag)

    def renderChild(node: Node): String =
      node match {
        case Tag(tagName, attributes, children) =>
          HtmlHelpers.node(
            tagName, attributes, children.map(renderChild), xml = true)

        case pine.Text(text) => HtmlHelpers.encodeText(text, xml = true)
      }
  }

  object Text extends TagRender[Tag[_], String] {
    // TODO Don't mutate global state
    private[pine] var lineBreak = false

    override def render(tag: Tag[_]): String = {
      lineBreak = false
      renderChild(tag).trim
    }

    def renderChild(node: Node): String =
      node match {
        case node @ Tag(_, _, _) =>
          def children(): String =
            node.children.map { child =>
              if (!lineBreak) Text.renderChild(child)
              else {
                val text = Text.renderChild(child).span(_.isSpaceChar)._2
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
                case li @ Tag("li", _, _) => "- " + renderChild(li).trim + "\n"
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

      case pine.Text(text) => text.replaceAll("\\s+", " ")
    }
  }
}
