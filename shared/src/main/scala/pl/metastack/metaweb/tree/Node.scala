package pl.metastack.metaweb.tree

import pl.metastack.metaweb.tag.HTMLTag

sealed trait Node {
  def map(f: Node => Node): Node
}

case class Text(text: String) extends Node {
  def map(f: Node => Node): Node = f(this)
}

trait Tag extends Node {
  def tagName: String
  def children: Seq[Node]
  def attributes: Map[String, Any]
  def copy(attributes: Map[String, Any] = attributes, children: Seq[Node] = children): Tag

  def id: Option[String]
  def id(value: String): Tag

  // TODO Rewrite in a more functional style
  def find(f: Node => Boolean): Option[Node] = {
    if (f(this)) Some(this)
    else {
      for (child <- children) {
        if (f(child)) return Some(child)
        else child match {
          case t: Tag =>
            val result = t.find(f)
            if (result.nonEmpty) return result

          case _ =>
        }
      }

      None
    }
  }

  def prepend(node: Node): Tag = copy(children = node +: children)
  def +:(node: Node): Tag = prepend(node)

  def append(node: Node): Tag = copy(children = children :+ node)
  def :+(node: Node): Tag = append(node)

  def appendAll(nodes: Seq[Node]): Tag = copy(children = children ++ nodes)
  def ++(nodes: Seq[Node]): Tag = appendAll(nodes)

  def set(node: Node): Tag = copy(children = Seq(node))
  def set(nodes: Seq[Node]): Tag = copy(children = nodes)

  def clearAll: Tag = copy(children = Seq.empty)

  def remove(node: Node): Tag = copy(children = children.diff(Seq(node)))
  def -(node: Node): Tag = remove(node)

  def removeAll(node: Seq[Node]): Tag = copy(children = children.diff(Seq(node)))
  def --(node: Seq[Node]): Tag = removeAll(node)

  def replace(reference: Node, node: Node): Tag =
    copy(children = children.map(n => if (n == reference) node else n))

  def attr(attribute: String): Option[Any] = attributes.get(attribute)
  def setAttr(attribute: String, value: Any): Tag =
    copy(attributes = attributes + (attribute -> value))
  def remAttr(attribute: String): Tag =
    copy(attributes = attributes - attribute)
  def clearAttr: Tag = copy(attributes = Map.empty)

  def map(f: Node => Node): Node = f(copy(children = children.map(f)))

  def partialMap(f: PartialFunction[Node, Node]): Node =
    map(node => f.lift(node).getOrElse(node))

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

  def updateChild[T <: Tag](id: String, f: T => Node): Node = {
    val attrId = attributes.get("id")

    if (attrId.contains(id)) f(this.asInstanceOf[T])
    else
      copy(
        children = children.map {
          case tag: Tag => tag.updateChild(id, f)
          case n => n
        }
      )
  }

  def byIdOpt[T <: Tag](id: String): Option[T] =
    find {
      case t: Tag => t.id.contains(id)
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

  def byClassOpt[T <: HTMLTag[_]](`class`: String): Option[T] =
    find {
      case t: HTMLTag[_] => t.`class`.exists(_.split(' ').toSet.contains(`class`))
      case _             => false
    }.map(_.asInstanceOf[T])

  def byClass[T <: Tag](`class`: String): T = byClassOpt(`class`).get
}

case class CustomTag(tagName: String,
                     attributes: Map[String, Any] = Map.empty,
                     children: Seq[Node] = Seq.empty) extends Tag {
  override def copy(attributes: Map[String, Any] = attributes,
                    children: Seq[Node] = children): CustomTag =
    CustomTag(tagName, attributes, children)

  override def id: Option[String] = attributes.get("id")
    .asInstanceOf[Option[String]]
  override def id(value: String): Tag = setAttr("id", value)
}
