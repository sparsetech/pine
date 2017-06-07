package pine.dom

import org.scalajs.dom

import pine._

object NodeRender extends NodeRender[Node, dom.Node] {
  trait Implicit {
    implicit class TextToDom(node: Text) {
      def toDom: dom.raw.Text = RenderText.render(node)
    }

    implicit class TagToDom[T <: Singleton](node: Tag[T]) {
      def toDom(implicit js: Js[T]): js.X =
        RenderTag.render(node).asInstanceOf[js.X]
    }
  }

  override def render(node: Node): dom.Node =
    node match {
      case n @ Tag(_, _, _) => RenderTag.render(n)
      case n: Text          => RenderText.render(n)
    }

  implicit case object RenderTag extends NodeRender[Tag[_], dom.Element] {
    def render(node: Tag[_]): dom.Element = {
      val element = dom.document.createElement(node.tagName)

      node.attributes.foreach { case (k, v) =>
        element.setAttribute(k, v.toString)
      }

      node.children.map(NodeRender.render).foreach(element.appendChild)
      element
    }
  }

  implicit case object RenderText extends NodeRender[Text, dom.raw.Text] {
    def render(node: Text): dom.raw.Text =
      dom.document.createTextNode(node.text)
  }
}
