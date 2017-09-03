package pine.dom

import org.scalajs.dom

import pine._

object NodeRender extends TagRender[Tag[_], dom.Element] {
  trait Implicit {
    implicit class TextToDom(node: Text) {
      def toDom: dom.raw.Text = renderText(node)
    }

    implicit class TagToDom[T <: Singleton](node: Tag[T]) {
      def toDom(implicit js: Js[T]): js.X = renderTag(node).asInstanceOf[js.X]
    }
  }

  override def render(tag: Tag[_]): dom.Element = renderTag(tag)

  @inline def renderChild(node: Node): dom.Node =
    node match {
      case n @ Tag(_, _, _) => renderTag(n)
      case n @ Text(_)      => renderText(n)
    }

  def renderTag(node: Tag[_]): dom.Element = {
    val element = dom.document.createElement(node.tagName)

    node.attributes.foreach { case (k, v) =>
      element.setAttribute(k, v.toString)
    }

    node.children.map(renderChild).foreach(element.appendChild)
    element
  }

  @inline def renderText(node: Text): dom.raw.Text =
    dom.document.createTextNode(node.text)
}
