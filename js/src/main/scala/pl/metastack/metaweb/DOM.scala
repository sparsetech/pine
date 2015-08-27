package pl.metastack.metaweb

import org.scalajs.dom

object DOM {
  trait Extensions {
    implicit class DomExtensions(parent: dom.Node) {
      def clear() {
        while (parent.lastChild != null)
          parent.removeChild(parent.lastChild)
      }

      def replaceFirst(node: dom.Node) {
        if (parent.firstChild == null) parent.appendChild(node)
        else parent.replaceChild(node, parent.firstChild)
      }

      def prependChild(node: dom.Node) {
        if (parent.firstChild == null) parent.appendChild(node)
        else parent.insertBefore(node, parent.firstChild)
      }

      def insertAfter(reference: dom.Node, node: dom.Node) {
        if (reference == null || reference.nextSibling == null) parent.appendChild(node)
        else parent.insertBefore(node, reference.nextSibling)
      }
    }
  }
}
