package pl.metastack.metaweb.tree.render

import org.scalajs.dom

import pl.metastack.metaweb._
import pl.metastack.metaweb.tree._

trait DOM[N <: tree.Node] extends tree.Render[N, dom.Element]

object DOM extends DOM[tree.Node] {
  trait Implicit {
    implicit class NodeToDom(node: Node) {
      def toDom: dom.Element = DOM.render(node)
    }
  }

  override def render(node: tree.Node): dom.Element =
    node match {
      case n: tree.Tag  => RenderTag.render(n)
      case n: tree.Text => RenderText.render(n)
    }

  implicit case object RenderTag extends DOM[tree.Tag] {
    def render(node: tree.Tag): dom.Element = {
      val element = dom.document.createElement(node.tagName)

      node.attributes.foreach { case (k, v) =>
        element.setAttribute(k, v.toString)
      }

      node.children.map(DOM.render).foreach(element.appendChild)
      element
    }
  }

  implicit case object RenderText extends DOM[tree.Text] {
    def render(node: tree.Text): dom.Element =
      dom.document.createTextNode(node.text).asInstanceOf[dom.Element]
  }
}
