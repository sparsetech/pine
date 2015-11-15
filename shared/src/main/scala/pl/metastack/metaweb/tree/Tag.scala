package pl.metastack.metaweb.tree

import pl.metastack.metaweb

case class Tag(tagName: String,
               attributes: Map[String, Any] = Map.empty,
               events: Map[String, Any => Unit] = Map.empty,
               children: Seq[Node] = Seq.empty) extends metaweb.Tag with Node {
  def getAttribute(attribute: String): Option[Any] = attributes.get(attribute)

  def setAttribute(attribute: String, value: Any): Tag =
    copy(attributes = attributes + (attribute -> value))

  def clearAttribute(attribute: String): Tag =
    copy(attributes = attributes - attribute)

  def clearAttributes: Tag =
    copy(attributes = Map.empty)

  def withoutId: Tag = copy(attributes = attributes - "id")

  def instantiateMap(nodes: Map[String, Node]): Tag = {
    val attrId = attributes.get("id")

    if (nodes.exists { case (id, _) => attrId.contains(id) }) {
      val idString = attrId.get.toString
      copy(
        attributes = attributes - "id",
        children = Seq(nodes(idString)))
    } else
      copy(
        children = children.map {
          case tag: Tag => tag.instantiateMap(nodes)
          case n => n
        }
      )
  }

  def instantiate(nodes: (String, Node)*): Tag =
    instantiateMap(nodes.toMap)

  def updateChild(id: String, f: Tag => Node): Node = {
    val attrId = attributes.get("id")

    if (attrId.contains(id)) f(this)
    else
      copy(
        children = children.map {
          case tag: Tag => tag.updateChild(id, f)
          case n => n
        }
      )
  }

  def clearChildren: Tag =
    copy(children = Seq.empty)

  override def state: metaweb.state.Tag = {
    val target = new metaweb.state.Tag(tagName)

    attributes.foreach { case (k, v) => target.setAttribute(k, v) }
    events.foreach { case (k, v) => target.setEvent(k, v) }
    target ++= children.map(_.state)

    target
  }
}
