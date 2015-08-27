package pl.metastack.metaweb.state.oneway

import pl.metastack.metarx._
import pl.metastack.metaweb.state

class Tag(val name: String) extends state.Tag with Node {
  private[state] val _attributes = Dict[String, Any]()
  private val contents = Buffer[state.Node]()
  private val _events = Dict[String, Any => Unit]()

  def ways = 2

  def attributes: Map[String, Any] = _attributes.toMap

  def events: Map[String, Any => Unit] = _events.toMap

  def watchAttributes: ReadChannel[Dict.Delta[String, Any]] =
    _attributes.changes

  def watchEvents: ReadChannel[Dict.Delta[String, Any => Unit]] =
    _events.changes

  def children: Seq[state.Node] = contents.get

  def watchChildren: ReadChannel[Buffer.Delta[state.Node]] = contents.changes

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

  def subscribeChildren(list: DeltaBuffer[state.Node]): ReadChannel[Unit] = {
    clearChildren()
    contents.changes << list.changes
  }

  def setAttribute[T](attribute: String, value: T) {
    _attributes.insertOrUpdate(attribute, value)
  }

  def getAttribute(attribute: String): Option[Any] =
    _attributes.get(attribute)

  def subscribeAttribute[T](attribute: String, from: ReadChannel[T]): ReadChannel[Unit] =
    from.attach(value =>
      _attributes.insertOrUpdate(attribute, value)
    )

  def setEvent[T](event: String, f: Any => Unit) {
    _events.insertOrUpdate(event, f)
  }

  def triggerAction(action: String, arguments: Any*) {
    _events(action)(arguments)
  }
}
