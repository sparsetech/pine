package pl.metastack.metaweb.tree

import pl.metastack.metaweb.HtmlHelpers

import scala.collection.mutable

import pl.metastack.metarx._

object Tag {
  def apply(tagName: String): Tag = new Tag(tagName)
}

class Tag(val tagName: String) extends Node {
  private[metaweb] val attributes = Dict[String, Any]()
  private[metaweb] val contents = Buffer[Node]()
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

  def instantiate(nodes: (String, Node)*): Tag = {
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

  def byIdOpt[T <: Tag](id: String): Option[T] = {
    contents.get.collectFirst {
      case t: Tag if t.attributes.get("id").contains(id) => t.asInstanceOf[T]
      case t: Tag if t.byIdOpt[T](id).isDefined => t.byIdOpt[T](id).get  // TODO optimise
    }
  }

  def clearChildren() {
    bound.foreach(_.dispose())
    bound.clear()

    contents.clear()
    changes := (())
  }

  def append(node: Node) {
    bound += changes << node.changes
    contents += node
  }

  def appendAll(nodes: Seq[Node]) {
    nodes.foreach(append)
  }

  def set(node: Node) {
    clearChildren()
    append(node)
  }

  def bindChildren(list: DeltaBuffer[Node]): ReadChannel[Unit] = {
    clearChildren()
    contents.changes << list.changes
  }

  // TODO Rename to bindAttribute
  def bind[T](attribute: String, from: ReadChannel[T]) {
    from.attach(value =>
      attributes.insertOrUpdate(attribute, value)
    )
  }

  def bindEvent[T](event: String, f: Any => Unit) {
    events.insertOrUpdate(event, f)
  }

  def triggerAction(action: String) {
    actions := action
  }

  def encodedAttributes: String =
    attributes.toMap.map { case (key, value) =>
      s"$key=" + HtmlHelpers.quoteAttribute(value.toString)
    }.mkString(" ")

  def toHtml: String = {
    val attrs = if (attributes.isEmpty$) "" else s" $encodedAttributes"

    if (HtmlHelpers.VoidElements.contains(tagName) && contents.get.isEmpty)
      s"<$tagName$attrs/>"
    else {
      val docType = if (tagName == "html") "<!DOCTYPE html>" else ""
      val children = contents.get.map(_.toHtml).mkString
      s"$docType<$tagName$attrs>$children</$tagName>"
    }
  }

  def :=(node: Node) { set(node) }

  def +=(node: Node) { append(node) }
  def ++=(nodes: Seq[Node]) { appendAll(nodes) }
}
