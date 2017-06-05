package pine.dom

import org.scalajs.dom

import pine._

object NodeRender extends NodeRender[Node, dom.Element] {
  trait Implicit {
    implicit class NodeToDom(node: Node) {
      def toDom: dom.Element = DOM.render(node)
    }
  }

  override def render(node: Node): dom.Element =
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

      node.children.map(DOM.render).foreach(element.appendChild)
      element
    }
  }

  implicit case object RenderText extends NodeRender[Text, dom.Element] {
    def render(node: Text): dom.Element =
      dom.document.createTextNode(node.text).asInstanceOf[dom.Element]
  }
}
