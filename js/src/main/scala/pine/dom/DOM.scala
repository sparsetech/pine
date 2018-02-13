package pine.dom

import org.scalajs.dom

import pine._

object DOM {
  trait Extensions {
    implicit class DomNodeExtensions(parent: dom.Node) {
      def removeChildren(): Unit =
        while (parent.lastChild != null)
          parent.removeChild(parent.lastChild)

      def replaceFirstChild(node: dom.Node): Unit =
        if (parent.firstChild == null) parent.appendChild(node)
        else parent.replaceChild(node, parent.firstChild)

      def prependChild(node: dom.Node): Unit =
        if (parent.firstChild == null) parent.appendChild(node)
        else parent.insertBefore(node, parent.firstChild)

      def insertChildAfter(reference: dom.Node, node: dom.Node): Unit =
        if (reference.nextSibling == null) parent.appendChild(node)
        else parent.insertBefore(node, reference.nextSibling)

      def insertChildAt(position: Int, node: dom.Node): Unit =
        if (parent.firstChild == null) parent.appendChild(node)
        else parent.insertBefore(node, parent.childNodes(position))
    }

    implicit class DomElementExtensions(parent: dom.Element) {
      def toTree: Tag[_] = DOM.toTree(parent)
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

  private def toTreeChild(node: dom.Node): Node =
    node match {
      case t: dom.raw.Text => Text(t.textContent)
      case e: dom.Element  => toTree(e)
    }

  def toTree(e: dom.Element): Tag[Singleton] = {
    val attributes = (0 until e.attributes.length)
      .map(e.attributes(_))
      .map { attr =>
        val isBooleanAttr = HtmlHelpers.BooleanAttributes.contains(attr.name)
        if (isBooleanAttr) attr.name -> attr.name
        else attr.name -> attr.value
      }.toMap

    val children = (0 until e.childNodes.length)
      .toList
      .map(e.childNodes(_))
      .filter {
        case _: dom.Comment => false
        case _              => true
      }.map(toTreeChild)

    Tag(
      // TODO See https://github.com/typelevel/scala/issues/154
      tagName    = e.tagName.toLowerCase.asInstanceOf[String with Singleton],
      attributes = attributes,
      children   = children
    )
  }

  def toTree(id: String): Tag[Singleton] =
    toTree(dom.document.getElementById(id))

  def render(f: DomRenderContext => Unit): Unit = {
    val ctx = new DomRenderContext
    f(ctx)
    ctx.commit()
  }
}
