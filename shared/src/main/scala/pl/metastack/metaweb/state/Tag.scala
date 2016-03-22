package pl.metastack.metaweb.state

import pl.metastack.metarx._
import pl.metastack.metaweb
import pl.metastack.metaweb.Provider

class Tag(val tagName: String) extends metaweb.Tag with Node with Children {
  protected val _attributes = Dict[String, Var[Any]]()
  private[metaweb] val contents = Buffer[metaweb.Node]()
  private val _events = Dict[String, Any => Unit]()
  val eventProvider = Provider[(String, Seq[Any]), Unit]()
  val nodeProvider = Provider[Unit, Any]()

  def attributes: Map[String, Any] = _attributes.toMap.collect {
    case (k, v) => (k, v.get)
  }

  def events: Map[String, Any => Unit] = _events.toMap

  def watchAttributes: ReadChannel[Dict.Delta[String, Var[Any]]] =
    _attributes.changes

  def watchEvents: ReadChannel[Dict.Delta[String, Any => Unit]] =
    _events.changes

  def children: Seq[metaweb.Node] = contents.get

  override def watchChildren: ReadChannel[Buffer.Delta[metaweb.Node]] =
    contents.changes

  def clearChildren() {
    contents.clear()
  }

  def prepend(node: metaweb.Node) {
    contents.prepend(node)
  }

  def append(node: metaweb.Node) {
    contents += node
  }

  def appendAll(nodes: Seq[metaweb.Node]): Unit =
    contents ++= nodes

  def remove(node: metaweb.Node): Unit =
    contents.remove(node)

  def replace(reference: metaweb.Node, node: metaweb.Node): Unit =
    contents.replace(reference, node)

  def set(node: metaweb.Node): Unit = {
    clearChildren()
    append(node)
  }

  def setChildren(nodes: Seq[metaweb.Node]): Unit = {
    clearChildren()
    appendAll(nodes)
  }

  def subscribe(node: ReadChannel[metaweb.Node]): ReadChannel[Unit] = {
    clearChildren()
    node.attach(set)
  }

  def subscribeChildren(list: DeltaBuffer[metaweb.Node]): ReadChannel[Unit] = {
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

  def setEvent(event: String, f: Any => Unit): Unit =
    _events.insertOrUpdate(event, f)

  def removeEvent(event: String): Unit = _events.removeIfExists(event)

  def triggerAction(action: String, arguments: Any*) {
    eventProvider.poll((action, arguments))
    if (_events.isDefinedAt$(action)) _events(action)(arguments)
  }

  def domNode: Option[Any] = nodeProvider.poll(())

  def :=(node: metaweb.Node): Unit = set(node)
  def -=(node: metaweb.Node): Unit = remove(node)
  def +=(node: metaweb.Node): Unit = append(node)
  def ++=(nodes: Seq[metaweb.Node]): Unit = appendAll(nodes)
}
