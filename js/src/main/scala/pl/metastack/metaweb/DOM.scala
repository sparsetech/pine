package pl.metastack.metaweb

import org.scalajs.dom

import pl.metastack.metaweb.tag.HTMLTag

object DOM {
  trait Extensions {
    implicit class DomExtensions(parent: dom.Node) {
      def clear(): Unit =
        while (parent.lastChild != null)
          parent.removeChild(parent.lastChild)

      def replaceFirst(node: dom.Node): Unit =
        if (parent.firstChild == null) parent.appendChild(node)
        else parent.replaceChild(node, parent.firstChild)

      def prependChild(node: dom.Node): Unit =
        if (parent.firstChild == null) parent.appendChild(node)
        else parent.insertBefore(node, parent.firstChild)

      def insertAfter(reference: dom.Node, node: dom.Node): Unit =
        if (reference == null || reference.nextSibling == null) parent.appendChild(node)
        else parent.insertBefore(node, reference.nextSibling)

      def toTree[T <: tree.Node]: T = DOM.toTree(parent)
    }
  }

  def toTree[T <: tree.Node](node: dom.Node): T =
    node match {
      case t: dom.raw.Text => tree.Text(t.textContent).asInstanceOf[T]

      case e: dom.Element =>
        val attributes = (0 until e.attributes.length)
          .map(e.attributes(_))
          .map { attr =>
            val isBooleanAttr = HtmlHelpers.BooleanAttributes.contains(attr.name)
            if (isBooleanAttr) attr.name -> true
            else attr.name -> attr.value
          }.toMap

        val children = (0 until e.childNodes.length)
          .map(e.childNodes(_))
          .filter {
            case _: dom.Comment => false
            case _              => true
          }.map(toTree[tree.Node])

        HTMLTag.fromTag(
          tagName    = e.tagName,
          attributes = attributes,
          children   = children
        ).asInstanceOf[T]
    }

  def toTree[T <: tree.Tag](id: String): T =
    toTree[T](dom.document.getElementById(id))
}
