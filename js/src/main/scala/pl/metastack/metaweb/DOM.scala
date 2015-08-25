package pl.metastack.metaweb

import scala.collection.mutable

import org.scalajs.dom

import pl.metastack.metarx.Buffer.Position
import pl.metastack.metarx.{Buffer, Dict}

import scala.scalajs.js

object DOM {
  trait Extensions {
    implicit class DomExtensions(parent: dom.Node) {
      def clear() {
        while (parent.lastChild != null)
          parent.removeChild(parent.lastChild)
      }

      def prependChild(node: dom.Node) {
        if (parent.firstChild != null) parent.insertBefore(node, parent.firstChild)
        else parent.appendChild(node)
      }

      def insertAfter(reference: dom.Node, node: dom.Node) {
        if (reference == null || reference.nextSibling == null) parent.appendChild(node)
        else parent.insertBefore(node, reference.nextSibling)
      }
    }
  }

  def render(node: tree.mutable.Tag): dom.Element = {
    val rendered = dom.document.createElement(node.tagName)

    node.actions.attach { case (action, arg) =>
      rendered.asInstanceOf[js.Dynamic]
        .applyDynamic(action)(arg.asInstanceOf[js.Dynamic])
    }

    node.attributes.changes.attach {
      case Dict.Delta.Insert(k, v) => rendered.setAttribute(k, v.toString)
      case Dict.Delta.Update(k, v) => rendered.setAttribute(k, v.toString)
      case Dict.Delta.Remove(k) => rendered.removeAttribute(k)
      case Dict.Delta.Clear() => rendered.removeAttribute()
    }

    node.events.changes.attach {
      case Dict.Delta.Insert(k, v) => rendered.addEventListener(k, v)
      case Dict.Delta.Update(k, v) =>
        rendered.removeEventListener(k, node.events(k))
        rendered.addEventListener(k, v)
      case Dict.Delta.Remove(k) =>
        rendered.removeEventListener(k, node.events(k))
      case Dict.Delta.Clear() =>
        node.events.foreach { case (k, v) =>
          rendered.removeEventListener(k, v)
        }
    }

    val mapping = mutable.Map.empty[tree.Node, dom.Node]

    node.contents.changes.attach {
      case Buffer.Delta.Insert(Position.Head(), element) =>
        mapping += element -> render(element)
        rendered.prependChild(mapping(element))

      case Buffer.Delta.Insert(Position.Last(), element) =>
        mapping += element -> render(element)
        rendered.appendChild(mapping(element))

      case Buffer.Delta.Insert(Position.Before(reference), element) =>
        mapping += element -> render(element)
        rendered.insertBefore(mapping(element), mapping(reference))

      case Buffer.Delta.Insert(Position.After(reference), element) =>
        mapping += element -> render(element)
        rendered.insertAfter(mapping(reference), mapping(element))

      case Buffer.Delta.Replace(reference, element) =>
        mapping += element -> render(element)
        rendered.replaceChild(mapping(element), mapping(reference))
        mapping -= reference

      case Buffer.Delta.Remove(element) =>
        rendered.removeChild(mapping(element))
        mapping -= element

      case Buffer.Delta.Clear() =>
        rendered.clear()
        mapping.clear()
    }

    rendered
  }

  def render(node: tree.immutable.Tag): dom.Element = {
    val rendered = dom.document.createElement(node.tagName)

    node.attributes.foreach { case (k, v) =>
      rendered.setAttribute(k, v.toString)
    }

    node.events.foreach { case (k, v) =>
      rendered.addEventListener(k, v)
    }

    node.contents.foreach { node =>
      rendered.appendChild(render(node))
    }

    rendered
  }

  def render(node: tree.mutable.Text): dom.Element = {
    val elem = dom.document.createElement("span")

    node.textVar.attach { s =>
      elem.clear()
      elem.appendChild(dom.document.createTextNode(s))
    }

    elem
  }

  def render(node: tree.immutable.Text): dom.Element =
    dom.document.createTextNode(node.text)
      .asInstanceOf[dom.Element]

  def renderNull(): dom.Element =
    dom.document.createComment("")
      .asInstanceOf[dom.Element]

  def render(node: tree.Node): dom.Element =
    node match {
      case tree.mutable.Null => renderNull()
      case n: tree.mutable.Tag => render(n)
      case n: tree.mutable.Text => render(n)

      case tree.immutable.Null => renderNull()
      case n: tree.immutable.Tag => render(n)
      case n: tree.immutable.Text => render(n)
    }
}
