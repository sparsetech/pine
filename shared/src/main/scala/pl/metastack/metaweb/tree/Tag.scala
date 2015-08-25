package pl.metastack.metaweb.tree

trait Tag extends Node {
  def tagName: String
  def copy(): Tag
  def instantiate(nodes: (String, Node)*): Tag
  def byIdOpt[T <: Tag](id: String): Option[T]
  def clearChildren()
  def append(node: Node)
  def appendAll(nodes: Seq[Node])
  def set(node: Node)
  def bindChildren(list: Seq[Node])
  def setAttribute[T](attribute: String, value: T)
  def getAttribute(attribute: String): Option[Any]
  def setEvent[T](event: String, f: Any => Unit)
  def triggerAction[T](action: String, argument: T)
  def toHtml: String

  def :=(node: Node) { set(node) }
  def +=(node: Node) { append(node) }
  def ++=(nodes: Seq[Node]) { appendAll(nodes) }
}
