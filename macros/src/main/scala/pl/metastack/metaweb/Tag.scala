package pl.metastack.metaweb

import scala.collection.mutable

import pl.metastack.metarx._

object Tag {
  def apply(tagName: String): Tag = new Tag(tagName)
}

class Tag(tagName: String) extends Node {
  private[metaweb] val attributes = Dict[String, Any]()
  private val contents = Buffer[Node]()

  val changes = Var[Unit](())
  changes << attributes.changes.map(_ => ())

  val bound = mutable.ArrayBuffer.empty[ReadChannel[Unit]]

  def byIdOpt[T <: Tag](id: String): Option[T] = {
    contents.get.collectFirst {
      case t: Tag if t.attributes.get("id").contains(id) => t.asInstanceOf[T]
      case t: Tag if t.byIdOpt[T](id).isDefined => t.byIdOpt[T](id).get  // TODO optimise
    }
  }

  def byId[T <: Tag](id: String): Option[T] = byIdOpt(id).get

  def clear() {
    bound.foreach(_.dispose())
    bound.clear()

    contents.clear()
    changes := (())
  }

  def append(value: Node) {
    bound += changes << value.changes
    contents += value
  }

  def set(node: Node) {
    clear()
    append(node)
  }

  def bind[T](attribute: String, from: ReadChannel[T]) {
    from.attach(value =>
      attributes.insertOrUpdate(attribute, value)
    )
  }

  def toHtml: String = {
    val attrs =
      attributes.toMap.map { case (k, v) =>
        s"""$k="$v""""
      }.mkString(" ")
    val attrsSpace = if (attrs.isEmpty) "" else s" $attrs"
    val cont = contents.get.map(_.toHtml).mkString

    s"<$tagName$attrsSpace>$cont</$tagName>"
  }

  def :=(node: Node) { set(node) }
  def +=(node: Node) { append(node) }
}
