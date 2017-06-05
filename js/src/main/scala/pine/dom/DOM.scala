package pine.dom

import org.scalajs.dom

import pine._

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

      def toTree[T <: SString]: Tag[T] = DOM.toTree[T](parent)
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

  private def _toTree(node: dom.Node): Node =
    node match {
      case t: dom.raw.Text => Text(t.textContent)

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
          }.map(_toTree)

        Tag(
          tagName    = e.tagName.asInstanceOf[SString],  // TODO Remove cast
          attributes = attributes,
          children   = children
        )
    }

  def toTree[T <: SString](node: dom.Node): Tag[T] =
    _toTree(node).asInstanceOf[Tag[T]]

  def toTree[T <: SString](id: String): Tag[T] =
    toTree(dom.document.getElementById(id)).as[T]

  def render(node: Node): dom.Element = NodeRender.render(node)

  def render(f: DomRenderContext => Unit): Unit = {
    val ctx = new DomRenderContext
    f(ctx)
    ctx.commit()
  }
}
