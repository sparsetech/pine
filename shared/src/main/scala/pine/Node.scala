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

  def +:[U <: Singleton](node: Tag[U]): Tag[U] = node.prepend(this)
  def map(f: Node => Node): T
  def flatMap(f: Node => List[Node]): T
  def mapFirst(f: PartialFunction[Node, Node]): T
}

case class Text(text: String) extends Node {
  override type T = Text

  def map(f: Node => Node): T = this
  def flatMap(f: Node => List[Node]): T = this
  def mapFirst(f: PartialFunction[Node, Node]): T = this
}

case class Tag[TagName <: Singleton](tagName: String with TagName,
                                     attributes: Map[String, Any] = Map.empty,
                                     children: List[Node] = List.empty
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

  def prepend(node: Node): Tag[TagName] = set(node +: children)
  def prependAll(node: List[Node]): Tag[TagName] = set(node ++ children)

  def append(node: Node): Tag[TagName] = set(children :+ node)
  def :+(node: Node): Tag[TagName] = append(node)

  def appendAll(nodes: List[Node]): Tag[TagName] = set(children ++ nodes)
  def ++(nodes: List[Node]): Tag[TagName] = appendAll(nodes)

  def insertAt(position: Int, nodes: List[Node]): Tag[TagName] = {
    assert(position <= children.length)
    copy(children = children.patch(position, nodes, 0))
  }

  def insertAt(position: Int, node: Node): Tag[TagName] =
    insertAt(position, List(node))

  def set(node: Node): Tag[TagName] = copy(children = List(node))
  def set(nodes: List[Node]): Tag[TagName] = copy(children = nodes)

  def clearAll: Tag[TagName] = copy(children = List.empty)

  def remove(node: Node): Tag[TagName] = set(children.diff(List(node)))
  def -(node: Node): Tag[TagName] = remove(node)

  def removeAll(node: List[Node]): Tag[TagName] = set(children.diff(List(node)))
  def --(node: List[Node]): Tag[TagName] = removeAll(node)

  def replace(reference: Node, node: Node): Tag[TagName] =
    copy(children = children.map(n => if (n == reference) node else n))

  def attr(attribute: String): Option[Any] = attributes.get(attribute)
  def setAttr(attribute: String, value: Any): Tag[TagName] =
    copy(attributes = attributes + (attribute -> value))
  def remAttr(attribute: String): Tag[TagName] =
    copy(attributes = attributes - attribute)
  def clearAttr: Tag[TagName] = copy(attributes = Map.empty)

  private def filterChildren(f: Node => Boolean): List[Node] = {
    val seq = if (f(this)) List(this) else List.empty
    seq ++ children.flatMap {
      case t: Tag[_] => t.filterChildren(f)
      case n         => if (f(n)) List(n) else List.empty
    }
  }

  def filter(f: Node => Boolean): List[Node] =
    children.flatMap {
      case tag: Tag[_] => tag.filterChildren(f)
      case node        => if (f(node)) List(node) else List.empty
    }

  def filterTags(f: Tag[_] => Boolean): List[Tag[_]] =
    filter {
      case t: Tag[_] if f(t) => true
      case _                 => false
    }.map(_.asInstanceOf[Tag[_]])

  def as[T <: Singleton with String](implicit vu: ValueOf[T]): Tag[T] = {
    assert(tagName == vu.value)
    this.asInstanceOf[Tag[T]]
  }

  def update(f: NodeRenderContext => Unit): Tag[TagName] = {
    val ctx = new NodeRenderContext()
    f(ctx)
    ctx.commit(this)
  }

  /** Recursively map children, excluding root node */
  def map(f: Node => Node): Tag[TagName] = set(children.map(f(_).map(f)))

  /** Recursively map tag children, including root node */
  def mapRoot(f: Tag[_] => Tag[_]): Tag[TagName] = {
    def iter(node: Node): Node =
      node match {
        case tag: Tag[_] => f(tag.copy(children = tag.children.map(iter)))
        case n => n
      }

    iter(this).asInstanceOf[T]
  }

  def flatMap(f: Node => List[Node]): Tag[TagName] =
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
            case t: Tag[_] => t.copy(children = t.children.map(m))
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
      case t @ Tag(_, _, _) if t.id.nonEmpty => t.id(t.id.get + suffix)
      case n => n
    }

  def byIdOpt(id: String): Option[Tag[_]] =
    find {
      case t @ Tag(_, _, _) => t.id.contains(id)
      case _                => false
    }.map(_.asInstanceOf[Tag[_]])

  def byId(id: String): Tag[_] =
    byIdOpt(id)
      .getOrElse(throw new IllegalArgumentException(s"Invalid node ID '$id'"))

  def byTagOpt[U <: Singleton](implicit vu: ValueOf[U]): Option[Tag[U]] =
    find {
      case Tag(vu.value, _, _) => true
      case _                   => false
    }.map(_.asInstanceOf[Tag[U]])

  def byTag[U <: Singleton](implicit ct: ValueOf[U]): Tag[U] =
    byTagOpt[U].getOrElse(
      throw new IllegalArgumentException(s"Invalid tag name '$tagName'"))

  def hasClass(`class`: String): Boolean =
    this.`class`.exists(_.split(' ').toSet.contains(`class`))

  def byClassOpt(`class`: String): Option[Tag[_]] =
    find {
      case t: Tag[_] => t.hasClass(`class`)
      case _         => false
    }.map(_.asInstanceOf[Tag[_]])

  def byClass(`class`: String): Tag[_] = byClassOpt(`class`).get
}
