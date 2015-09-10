package pl.metastack.metaweb.state.zeroway

import pl.metastack.metaweb.state

import scala.collection.mutable

class Tag(val name: String) extends state.Tag with Node {
  private val attrs = mutable.Map.empty[String, Any]
  private val contents = mutable.ArrayBuffer.empty[state.Node]
  private val _events = mutable.Map.empty[String, Any => Unit]

  def attributes: Map[String, Any] = attrs.toMap

  def children: Seq[state.Node] = contents

  def events: Map[String, Any => Unit] = _events.toMap

  def clearChildren() {
    contents.clear()
  }

  def append(node: state.Node) {
    contents += node
  }

  def appendAll(nodes: Seq[state.Node]) {
    contents ++= nodes
  }

  def set(node: state.Node) {
    clearChildren()
    append(node)
  }

  def setChildren(nodes: Seq[state.Node]) {
    clearChildren()
    appendAll(nodes)
  }

  def setAttribute[T](attribute: String, value: T) {
    attrs += attribute -> value
  }

  def getAttribute(attribute: String): Option[Any] =
    attrs.get(attribute)

  def setEvent[T](event: String, f: Any => Unit) {
    _events += event -> f
  }

  def triggerAction(action: String, arguments: Any*) {
    _events(action)(arguments)
  }
}
