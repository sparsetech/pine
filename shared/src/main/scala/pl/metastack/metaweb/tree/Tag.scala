package pl.metastack.metaweb.tree

import pl.metastack.metaweb
import pl.metastack.metaweb.State

case class Tag(tagName: String,
               attributes: Map[String, Any] = Map.empty,
               events: Map[String, Any => Unit],
               children: Seq[Node] = Seq.empty) extends Node {
  def withoutId: Tag = copy(attributes = attributes - "id")

  def instantiateMap(nodes: Map[String, Node]): Node = {
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

  def instantiate(nodes: (String, Node)*): Node =
    instantiateMap(nodes.toMap)

  def byIdOpt(id: String): Option[Tag] = {
    if (attributes.get("id").contains(id)) Some(this)
    else children.collectFirst {
      case t: Tag if t.byIdOpt(id).isDefined => t.byIdOpt(id).get  // TODO optimise
    }
  }

  def byId(id: String): Tag = byIdOpt(id).get

  override def state[T <: metaweb.state.Node](creator: State[T]): T with metaweb.state.Tag = {
    val target = creator.tag(tagName)

    attributes.foreach { case (k, v) => target.setAttribute(k, v) }
    events.foreach { case (k, v) => target.setEvent(k, v) }
    target ++= children.map(_.state(creator))

    target.asInstanceOf[T with metaweb.state.Tag]
  }
}
