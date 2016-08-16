package pl.metastack.metaweb.tree

import pl.metastack.metaweb.tag.HTMLTag

import scala.reflect.ClassTag

sealed trait Node {
  type T <: Node

  def +:[T <: Tag](node: T): node.T = node.prepend(this)
  def map(f: Node => Node): T
  def flatMap(f: Node => Seq[Node]): T
  def mapFirst(f: PartialFunction[Node, Node]): T
}

case class Text(text: String) extends Node {
  override type T = Text

  def map(f: Node => Node): T = this
  def flatMap(f: Node => Seq[Node]): T = this
  def mapFirst(f: PartialFunction[Node, Node]): T = this
}

trait Tag extends Node {
  type T <: Tag

  def tagName: String
  def children: Seq[Node]
  def attributes: Map[String, Any]
  def copy(attributes: Map[String, Any] = attributes,
           children: Seq[Node] = children): T

  def id: Option[String]
  def id(value: String): T

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

  def prepend(node: Node): T = copy(children = node +: children)

  def append(node: Node): T = copy(children = children :+ node)
  def :+(node: Node): T = append(node)

  def appendAll(nodes: Seq[Node]): T = copy(children = children ++ nodes)
  def ++(nodes: Seq[Node]): T = appendAll(nodes)

  def set(node: Node): T = copy(children = Seq(node))
  def set(nodes: Seq[Node]): T = copy(children = nodes)

  def clearAll: T = copy(children = Seq.empty)

  def remove(node: Node): T = copy(children = children.diff(Seq(node)))
  def -(node: Node): T = remove(node)

  def removeAll(node: Seq[Node]): T = copy(children = children.diff(Seq(node)))
  def --(node: Seq[Node]): T = removeAll(node)

  def replace(reference: Node, node: Node): T =
    copy(children = children.map(n => if (n == reference) node else n))

  def attr(attribute: String): Option[Any] = attributes.get(attribute)
  def setAttr(attribute: String, value: Any): T =
    copy(attributes = attributes + (attribute -> value))
  def remAttr(attribute: String): T =
    copy(attributes = attributes - attribute)
  def clearAttr: T = copy(attributes = Map.empty)

  private def filterChildren(f: Node => Boolean): Seq[Node] = {
    val seq = if (f(this)) Seq(this) else Seq.empty
    seq ++ children.flatMap {
      case t: Tag => t.filterChildren(f)
      case n => if (f(n)) Seq(n) else Seq.empty
    }
  }

  def filter(f: Node => Boolean): Seq[Node] =
    children.flatMap {
      case tag: Tag => tag.filterChildren(f)
      case node => if (f(node)) Seq(node) else Seq.empty
    }

  def map(f: Node => Node): T = copy(children = children.map(f(_).map(f)))

  def flatMap(f: Node => Seq[Node]): T =
    copy(children = children.flatMap(n => f(n.flatMap(f))))

  def mapFirst(f: PartialFunction[Node, Node]): T = {
    var done = false

    def m(n: Node): Node =
      if (done) n
      else f.lift(n) match {
        case Some(mapped) =>
          done = true
          mapped

        case None =>
          n match {
            case t: Tag => t.copy(children = t.children.map(child => m(child)))
            case _      => n
          }
      }

    copy(children = children.map(m))
  }

  def partialMap(f: PartialFunction[Node, Node]): T =
    map(node => f.lift(node).getOrElse(node))

  def withoutId: T = copy(attributes = attributes - "id")

  def instantiateMap(nodes: Map[String, Node]): T = {
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

  def instantiate(nodes: (String, Node)*): T =
    instantiateMap(nodes.toMap)

  def updateByTag[U <: Tag](f: U => Tag)(implicit ct: ClassTag[U]): Node =
    partialMap {
      case n if n.getClass == ct.runtimeClass => f(n.asInstanceOf[U])
    }

  def updateFirstByTag[U <: Tag](f: U => Tag)(implicit ct: ClassTag[U]): Node =
    mapFirst {
      case n if n.getClass == ct.runtimeClass => f(n.asInstanceOf[U])
    }

  def updateById[U <: Tag](id: String, f: U => Node): Node =
    mapFirst {
      case tag: Tag if tag.attributes.get("id").contains(id) =>
        f(tag.asInstanceOf[U])
    }

  def byIdOpt[U <: Tag](id: String): Option[U] =
    find {
      case t: Tag => t.id.contains(id)
      case _      => false
    }.map(_.asInstanceOf[U])

  def byId[U <: Tag](id: String): U = byIdOpt(id)
    .getOrElse(throw new IllegalArgumentException(s"Invalid node ID '$id'"))

  def byTagOpt[U <: Tag](implicit ct: ClassTag[U]): Option[U] =
    find {
      case t: Tag => t.getClass == ct.runtimeClass
      case _      => false
    }.map(_.asInstanceOf[U])

  def byTag[U <: Tag](implicit ct: ClassTag[U]): U =
    byTagOpt[U].getOrElse(
      throw new IllegalArgumentException(s"Invalid tag name '$tagName'"))

  def byClassOpt[U <: HTMLTag](`class`: String): Option[U] =
    find {
      case t: HTMLTag => t.`class`.exists(_.split(' ').toSet.contains(`class`))
      case _          => false
    }.map(_.asInstanceOf[U])

  def byClass[U <: Tag](`class`: String): U = byClassOpt(`class`).get
}

case class CustomTag(tagName: String,
                     attributes: Map[String, Any] = Map.empty,
                     children: Seq[Node] = Seq.empty) extends Tag {
  override type T = CustomTag

  override def copy(attributes: Map[String, Any] = attributes,
                    children: Seq[Node] = children): CustomTag =
    CustomTag(tagName, attributes, children)

  override def id: Option[String] = attributes.get("id")
    .asInstanceOf[Option[String]]
  override def id(value: String): CustomTag = setAttr("id", value)
}
