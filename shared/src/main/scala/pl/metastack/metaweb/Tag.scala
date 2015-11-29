package pl.metastack.metaweb

trait Tag extends Node {
  def tagName: String
  def attributes: Map[String, Any]
  def events: Map[String, Any => Unit]
  def children: Seq[Node]
  def getAttribute(attribute: String): Option[Any]

  def byIdOpt[T <: Tag](id: String): Option[T] = {
    if (attributes.get("id").contains(id)) Some(this.asInstanceOf[T])
    else children.collectFirst {
      case t: Tag if t.byIdOpt(id).isDefined => t.byIdOpt(id).get  // TODO optimise
    }
  }

  def byId[T <: Tag](id: String): T = byIdOpt(id)
    .getOrElse(throw new IllegalArgumentException(s"Invalid node ID '$id'"))

  def byTagOpt[T <: Tag](tag: String): Option[T] = {
    if (tagName == tag) Some(this.asInstanceOf[T])
    else children.collectFirst {
      case t: Tag if t.byTagOpt(tag).isDefined => t.byTagOpt(tag).get  // TODO optimise
    }
  }

  def byTag[T <: Tag](tagName: String): T =
    byTagOpt(tagName).getOrElse(
      throw new IllegalArgumentException(s"Invalid tag name '$tagName'"))
}
