package pine.dom

import org.scalajs.dom

import pine._
import pine.tag.HTMLTag

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

      def toTree[T <: Node]: T = DOM.toTree(parent)
    }
  }

  def collectNodes(node: dom.Node): Map[String, dom.Element] =
    node match {
      case e: dom.Element =>
        val map =
          if (e.id != "") Map(e.id -> e)
          else Map.empty[String, dom.Element]

        import dom.ext._
        e.getElementsByTagName("*").collect {
          case e: dom.Element if e.id.nonEmpty => e.id -> e
        }.toMap ++ map

      case _ => Map.empty
    }

  def toTree[T <: Node](node: dom.Node): T =
    node match {
      case t: dom.raw.Text => Text(t.textContent).asInstanceOf[T]

      case e: dom.Element =>
        val attributes = (0 until e.attributes.length)
          .map(e.attributes(_))
          .map { attr =>
            val isBooleanAttr = HtmlHelpers.BooleanAttributes.contains(attr.name)
            if (isBooleanAttr) attr.name -> attr.name
            else attr.name -> attr.value
          }.toMap

        val children = (0 until e.childNodes.length)
          .map(e.childNodes(_))
          .filter {
            case _: dom.Comment => false
            case _              => true
          }.map(toTree[Node])

        HTMLTag.fromTag(
          tagName    = e.tagName,
          attributes = attributes,
          children   = children
        ).asInstanceOf[T]
    }

  def toTree[T <: Tag](id: String): T =
    toTree[T](dom.document.getElementById(id))

  def render(node: Node): dom.Element = NodeRender.render(node)

  def render(f: DomRenderContext => Unit): Unit = {
    val ctx = new DomRenderContext
    f(ctx)
    ctx.commit()
  }
}
