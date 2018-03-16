package pine.dom

import org.scalajs.dom
import org.scalajs.dom.html.Element
import org.scalajs.dom.document

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

      def insertAfter(node: dom.Node, refChild: dom.Node): Unit =
        if (refChild.nextSibling == null) parent.appendChild(node)
        else parent.insertBefore(node, refChild.nextSibling)

      def insertChildAt(position: Int, node: dom.Node): Unit =
        if (parent.firstChild == null) parent.appendChild(node)
        else parent.insertBefore(node, parent.childNodes(position))
    }

    implicit class DomElementExtensions(parent: dom.Element) {
      def toTree: Tag[_] = DOM.toTree(parent)
    }
  }

  /** Resolve relative tag reference */
  def resolve[T <: Singleton](element: Element, tagRef: TagRef[T])
                             (implicit js: Js[T]): js.X =
    tagRef match {
      case TagRef.ById(id) =>
        document.getElementById(id).asInstanceOf[js.X]
      case TagRef.ByTag(tag) =>
        element.getElementsByTagName(tag)(0).asInstanceOf[js.X]
      case TagRef.ByClass(cls) =>
        element.getElementsByClassName(cls)(0).asInstanceOf[js.X]
      case TagRef.Each(tr) => resolve(element, tr)(js)
      case TagRef.Opt(tr) => resolve(element, tr)(js)
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
      .map(attr => attr.name -> attr.value).toMap

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
