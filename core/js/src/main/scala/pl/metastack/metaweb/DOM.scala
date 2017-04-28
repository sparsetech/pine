package pl.metastack.metaweb

import org.scalajs.dom
import pl.metastack.metaweb.diff.{Attribute, Diff, NodeRef}
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

  /** Resolve DOM node */
  def get[T <: tree.Tag](nodeRef: NodeRef[T])(implicit js: Js[T]): js.X = {
    val node = nodeRef match {
      case NodeRef.ById(id)   => dom.document.getElementById(id)
      case NodeRef.ByTag(tag) => dom.document.getElementsByTagName(tag).item(0)
    }

    Option(node).getOrElse(
      throw new Exception(s"Invalid node reference '$nodeRef'")
    ).asInstanceOf[js.X]
  }

  /** TODO Introduce BooleanAttribute and StringAttribute for better type-safety? */
  def get[T <: tree.Tag, G](attribute: Attribute[T, G, _])(implicit js: Js[T]): G =
    if (HtmlHelpers.BooleanAttributes.contains(attribute.name))
      get(attribute.parent).hasAttribute(attribute.name).asInstanceOf[G]
    else Option(get(attribute.parent).getAttribute(attribute.name)).asInstanceOf[G]

  def render(node: tree.Node): dom.Element = tree.render.DOM.render(node)
  def render(diffs: Diff*): Unit = diffs.foreach(diff.render.DOM.render)
  def renderDom(diffs: DomDiff*): Unit = diffs.foreach(diff.render.DOM.render)
}
