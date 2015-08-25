package pl.metastack.metaweb.tree.immutable

import pl.metastack.metaweb.tree
import pl.metastack.metaweb.HtmlHelpers

import scala.collection.mutable

object Tag {
  def apply(tagName: String): Tag = new Tag(tagName)
}

class Tag(val tagName: String) extends Node with tree.Tag {
  private[metaweb] val attributes = mutable.Map.empty[String, Any]
  private[metaweb] val contents = mutable.ArrayBuffer[tree.Node]()
  private[metaweb] val events = mutable.Map.empty[String, Any => Unit]

  def copy(): Tag = {
    val tag = Tag(tagName)
    tag.attributes ++= attributes
    contents.foreach { node =>
      tag.append(node.copy())
    }
    tag
  }

  def instantiate(nodes: (String, tree.Node)*): Tag = {
    val tag = copy()
    tag.attributes -= "id"

    nodes.foreach { case (id, node) =>
      val n = tag.byId[Tag](id)
      n.attributes -= "id"
      n := node
    }

    tag
  }

  def byIdOpt[T <: tree.Tag](id: String): Option[T] = {
    contents.collectFirst {
      case t: tree.Tag if t.getAttribute("id").contains(id) => t.asInstanceOf[T]
      case t: tree.Tag if t.byIdOpt[T](id).isDefined => t.byIdOpt[T](id).get  // TODO optimise
    }
  }

  def clearChildren() {
    contents.clear()
  }

  def append(node: tree.Node) {
    contents += node
  }

  def appendAll(nodes: Seq[tree.Node]) {
    nodes.foreach(append)
  }

  def set(node: tree.Node) {
    clearChildren()
    append(node)
  }

  def bindChildren(list: Seq[tree.Node]) {
    clearChildren()
    contents ++= list
  }

  def setAttribute[T](attribute: String, value: T) {
    attributes += attribute -> value
  }

  def getAttribute(attribute: String): Option[Any] =
    attributes.get(attribute)

  def setEvent[T](event: String, f: Any => Unit) {
    events += event -> f
  }

  // TODO Take arbitrary number of arguments
  def triggerAction[T](action: String, argument: T) {
    events(action)(argument)
  }

  def toHtml: String =
    HtmlHelpers.node(tagName, attributes.toMap, contents.map(_.toHtml))
}
