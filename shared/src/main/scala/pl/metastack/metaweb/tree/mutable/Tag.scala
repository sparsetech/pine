package pl.metastack.metaweb.tree.mutable

import scala.collection.mutable

import pl.metastack.metarx._

import pl.metastack.metaweb.tree
import pl.metastack.metaweb.HtmlHelpers

object Tag {
  def apply(tagName: String): Tag = new Tag(tagName)
}

class Tag(val tagName: String) extends Node with tree.Tag {
  private[metaweb] val attributes = Dict[String, Any]()
  private[metaweb] val contents = Buffer[tree.Node]()
  private[metaweb] val events = Dict[String, Any => Unit]()
  private[metaweb] val actions = Channel[String]()

  def copy(): Tag = {
    val tag = Tag(tagName)
    tag.attributes.set(attributes.toMap)
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

  val changes = Var[Unit](())
  changes << attributes.changes.map(_ => ())

  val bound = mutable.ArrayBuffer.empty[ReadChannel[Unit]]

  // TODO Same as immutable.Tag, merge?
  def byIdOpt[T <: tree.Tag](id: String): Option[T] = {
    contents.get.collectFirst {
      case t: tree.Tag if t.getAttribute("id").contains(id) => t.asInstanceOf[T]
      case t: tree.Tag if t.byIdOpt[T](id).isDefined => t.byIdOpt[T](id).get  // TODO optimise
    }
  }

  def clearChildren() {
    bound.foreach(_.dispose())
    bound.clear()

    contents.clear()
    changes := (())
  }

  def append(node: tree.Node) {
    node match {
      case n: Node => bound += changes << n.changes
      case _ =>
    }

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
    appendAll(list)
  }

  def bindChildrenBuffer(list: DeltaBuffer[tree.Node]): ReadChannel[Unit] = {
    clearChildren()
    contents.changes << list.changes
  }

  def bindAttribute[T](attribute: String, from: ReadChannel[T]) {
    from.attach(value =>
      attributes.insertOrUpdate(attribute, value)
    )
  }

  def setAttribute[T](attribute: String, value: T) {
    attributes.insertOrUpdate(attribute, value)
  }

  def getAttribute(attribute: String): Option[Any] =
    attributes.get(attribute)

  def setEvent[T](event: String, f: Any => Unit) {
    events.insertOrUpdate(event, f)
  }

  /** TODO Don't ignore `argument` */
  def triggerAction[T](action: String, argument: T) {
    actions := action
  }

  def toHtml: String =
    HtmlHelpers.node(tagName, attributes.toMap, contents.get.map(_.toHtml))
}
