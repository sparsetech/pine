package pl.metastack.metaweb.state.reactive

import pl.metastack.metarx._
import pl.metastack.metaweb.{Provider, state}

class Tag(val tagName: String) extends state.Tag with Node {
  protected val _attributes = Dict[String, Var[Any]]()
  private val contents = Buffer[state.Node]()
  private val _events = Dict[String, Any => Unit]()
  val eventProvider = Provider[(String, Seq[Any]), Unit]()

  def attributes: Map[String, Any] = _attributes.toMap.collect {
    case (k, v) => (k, v.get)
  }

  def events: Map[String, Any => Unit] = _events.toMap

  def watchAttributes: ReadChannel[Dict.Delta[String, Var[Any]]] =
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

  def subscribe(node: ReadChannel[state.Node]): ReadChannel[Unit] = {
    clearChildren()
    node.attach(set)
  }

  def subscribeChildren(list: DeltaBuffer[state.Node]): ReadChannel[Unit] = {
    clearChildren()
    contents.changes << list.changes
  }

  def attribute(attribute: String): Var[Any] =
    if (_attributes.isDefinedAt$(attribute)) _attributes(attribute)
    else {
      _attributes += attribute -> Var[Any](null)
      _attributes(attribute)
    }

  def getAttribute(attr: String): Option[Any] = Some(attribute(attr).get)
  def setAttribute[T](attr: String, value: T) = attribute(attr) := value

  def setEvent[T](event: String, f: Any => Unit) {
    _events.insertOrUpdate(event, f)
  }

  def triggerAction(action: String, arguments: Any*) {
    eventProvider.poll((action, arguments))
    if (_events.isDefinedAt$(action)) _events(action)(arguments)
  }
}
