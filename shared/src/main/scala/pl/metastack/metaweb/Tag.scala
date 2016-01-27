package pl.metastack.metaweb

trait Tag extends Container {
  def tagName: String
  def attributes: Map[String, Any]
  def events: Map[String, Any => Unit]
  def children: Seq[Node]
  def getAttribute(attribute: String): Option[Any]

  def byIdOpt[T <: Tag](id: String): Option[T] =
    find {
      case t: Tag => t.attributes.get("id").contains(id)
      case _      => false
    }.map(_.asInstanceOf[T])

  def byId[T <: Tag](id: String): T = byIdOpt(id)
    .getOrElse(throw new IllegalArgumentException(s"Invalid node ID '$id'"))

  def byTagOpt[T <: Tag](tag: String): Option[T] =
    find {
      case t: Tag => t.tagName == tag
      case _      => false
    }.map(_.asInstanceOf[T])

  def byTag[T <: Tag](tagName: String): T =
    byTagOpt(tagName).getOrElse(
      throw new IllegalArgumentException(s"Invalid tag name '$tagName'"))
}
