package pine

import scala.language.implicitConversions

object Node {
  trait Implicits {
    implicit def StringToNode(value: String): Node = Text(value)
    implicit def BooleanToNode(value: Boolean): Node = Text(value.toString)
    implicit def NumericToNode[T](value: T)(implicit num: Numeric[T]): Node =
      Text(value.toString)
  }
}

sealed trait Node {
  type T <: Node

  def +:[T <: SString](node: Tag[T]): Tag[T] = node.prepend(this)
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

case class Tag[TagName <: SString](tagName: TagName,
                                   attributes: Map[String, Any] = Map.empty,
                                   children: Seq[Node] = Seq.empty
                                  ) extends Node {
  override type T = Tag[TagName]

  // TODO Rewrite in a more functional style
  def find(f: Node => Boolean): Option[Node] = {
    if (f(this)) Some(this)
    else {
      for (child <- children) {
        if (f(child)) return Some(child)
        else child match {
          case t: Tag[_] =>
            val result = t.find(f)
            if (result.nonEmpty) return result

          case _ =>
        }
      }

      None
    }
  }

  def prepend(node: Node): Tag[TagName] = copy(children = node +: children)

  def append(node: Node): Tag[TagName] = copy(children = children :+ node)
  def :+(node: Node): Tag[TagName] = append(node)

  def appendAll(nodes: Seq[Node]): Tag[TagName] = copy(children = children ++ nodes)
  def ++(nodes: Seq[Node]): Tag[TagName] = appendAll(nodes)

  def set(node: Node): Tag[TagName] = copy(children = Seq(node))
  def set(nodes: Seq[Node]): Tag[TagName] = copy(children = nodes)

  def clearAll: Tag[TagName] = copy(children = Seq.empty)

  def remove(node: Node): Tag[TagName] = copy(children = children.diff(Seq(node)))
  def -(node: Node): Tag[TagName] = remove(node)

  def removeAll(node: Seq[Node]): Tag[TagName] = copy(children = children.diff(Seq(node)))
  def --(node: Seq[Node]): Tag[TagName] = removeAll(node)

  def replace(reference: Node, node: Node): Tag[TagName] =
    copy(children = children.map(n => if (n == reference) node else n))

  def attr(attribute: String): Option[Any] = attributes.get(attribute)
  def setAttr(attribute: String, value: Any): Tag[TagName] =
    copy(attributes = attributes + (attribute -> value))
  def remAttr(attribute: String): Tag[TagName] =
    copy(attributes = attributes - attribute)
  def clearAttr: Tag[TagName] = copy(attributes = Map.empty)

  private def filterChildren(f: Node => Boolean): Seq[Node] = {
    val seq = if (f(this)) Seq(this) else Seq.empty
    seq ++ children.flatMap {
      case t: Tag[_] => t.filterChildren(f)
      case n         => if (f(n)) Seq(n) else Seq.empty
    }
  }

  def filter(f: Node => Boolean): Seq[Node] =
    children.flatMap {
      case tag: Tag[_] => tag.filterChildren(f)
      case node        => if (f(node)) Seq(node) else Seq.empty
    }

  def filterTags(f: Tag[_] => Boolean): Seq[Tag[_]] =
    filter {
      case t: Tag[_] if f(t) => true
      case _                 => false
    }.map(_.asInstanceOf[Tag[_]])

  def as[T <: SString]: Tag[T] = this.asInstanceOf[Tag[T]]

  def update(f: NodeRenderContext => Unit): Tag[TagName] = {
    val ctx = new NodeRenderContext()
    f(ctx)
    ctx.commit(this)
  }

  /** Recursively map children, excluding root node */
  def map(f: Node => Node): Tag[TagName] = copy(children = children.map(f(_).map(f)))

  /** Recursively map tag children, including root node */
  def mapRoot(f: Tag[_] => Tag[_]): Tag[TagName] = {
    def iter(node: Node): Node =
      node match {
        case tag: Tag[_] => f(tag.copy(children = tag.children.map(iter)))
        case n => n
      }

    iter(this).asInstanceOf[T]
  }

  def flatMap(f: Node => Seq[Node]): Tag[TagName] =
    copy(children = children.flatMap(n => f(n.flatMap(f))))

  def mapFirst(f: PartialFunction[Node, Node]): Tag[TagName] = {
    var done = false

    def m(n: Node): Node =
      if (done) n
      else f.lift(n) match {
        case Some(mapped) =>
          done = true
          mapped

        case None =>
          n match {
            case t: Tag[_] => t.copy(children = t.children.map(child => m(child)))
            case _         => n
          }
      }

    copy(children = children.map(m))
  }

  def partialMap(f: PartialFunction[Node, Node]): Tag[TagName] =
    map(node => f.lift(node).getOrElse(node))

  /** Recursively adds `suffix` to every ID attribute */
  def suffixIds(suffix: String): Tag[TagName] =
    if (suffix.isEmpty) copy()
    else mapRoot {
      case t: Tag[_] if t.id.nonEmpty => t.id(t.id.get + suffix)
      case n => n
    }

  def withoutId: Tag[TagName] = copy(attributes = attributes - "id")

  def instantiateMap(nodes: Map[String, Node]): Tag[TagName] = {
    val attrId = attributes.get("id")

    if (nodes.exists { case (id, _) => attrId.contains(id) }) {
      val idString = attrId.get.toString
      copy(
        attributes = attributes - "id",
        children = Seq(nodes(idString)))
    } else
      copy(
        children = children.map {
          case tag: Tag[_] => tag.instantiateMap(nodes)
          case n => n
        }
      )
  }

  def instantiate(nodes: (String, Node)*): Tag[TagName] =
    instantiateMap(nodes.toMap)

  def updateByTag[U <: SString](f: Tag[U] => Tag[_])(implicit vu: ValueOf[U]): Node =
    partialMap {
      case t @ Tag(vu.value, _, _) => f(t.asInstanceOf[Tag[U]])
    }

  def updateFirstByTag[U <: SString](f: Tag[U] => Tag[_])(implicit vu: ValueOf[U]): Node =
    mapFirst {
      case t @ Tag(vu.value, _, _) => f(t.asInstanceOf[Tag[U]])
    }

  def updateById[U <: SString](id: String, f: Tag[U] => Node): Node =
    mapFirst {
      case tag: Tag[_] if tag.attributes.get("id").contains(id) =>
        f(tag.asInstanceOf[Tag[U]])
    }

  def byIdOpt[U <: SString](id: String): Option[Tag[U]] =
    find {
      case t: Tag[_] => t.id.contains(id)
      case _         => false
    }.map(_.asInstanceOf[Tag[U]])

  def byId[U <: SString](id: String): Tag[U] = byIdOpt[U](id)
    .getOrElse(throw new IllegalArgumentException(s"Invalid node ID '$id'"))

  def byTagOpt[U <: SString](implicit vu: ValueOf[U]): Option[Tag[U]] =
    find {
      case Tag(vu.value, _, _) => true
      case _                   => false
    }.map(_.asInstanceOf[Tag[U]])

  def byTag[U <: SString](implicit ct: ValueOf[U]): Tag[U] =
    byTagOpt[U].getOrElse(
      throw new IllegalArgumentException(s"Invalid tag name '$tagName'"))

  def byClassOpt[U <: SString](`class`: String): Option[Tag[U]] =
    find {
      case t: Tag[_] => t.`class`.exists(_.split(' ').toSet.contains(`class`))
      case _         => false
    }.map(_.asInstanceOf[Tag[U]])

  def byClass[U <: SString](`class`: String): Tag[U] = byClassOpt(`class`).get

  def id: Option[String] = attributes.get("id")
    .asInstanceOf[Option[String]]
  def id(value: String): Tag[TagName] = setAttr("id", value)
}
