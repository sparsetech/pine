package pl.metastack.metaweb.state

trait Tag extends Node {
  def name: String
  def attributes: Map[String, Any]
  def events: Map[String, Any => Unit]
  def children: Seq[Node]

  def clearChildren()
  def append(node: Node)
  def appendAll(nodes: Seq[Node])
  def set(node: Node)
  def setChildren(nodes: Seq[Node])
  def setAttribute[T](attribute: String, value: T)
  def getAttribute(attribute: String): Option[Any]
  def setEvent[T](event: String, f: Any => Unit)
  def triggerAction(action: String, arguments: Any*)

  def :=(node: Node) { set(node) }
  def +=(node: Node) { append(node) }
  def ++=(nodes: Seq[Node]) { appendAll(nodes) }

  def byIdOpt[T <: Tag](id: String): Option[T] = {
    children.collectFirst {
      case t: Tag if t.getAttribute("id").contains(id) => t.asInstanceOf[T]
      case t: Tag if t.byIdOpt[T](id).isDefined => t.byIdOpt[T](id).get  // TODO optimise
    }
  }

  def byId[T <: Tag](id: String): T = byIdOpt(id).get

  def byTagOpt[T <: Tag](tag: String): Option[T] = {
    children.collectFirst {
      case t: Tag if t.name == tag => t.asInstanceOf[T]
      case t: Tag if t.byTagOpt[T](tag).isDefined => t.byTagOpt[T](tag).get  // TODO optimise
    }
  }

  def byTag[T <: Tag](tag: String): T = byTagOpt(tag).get
}
