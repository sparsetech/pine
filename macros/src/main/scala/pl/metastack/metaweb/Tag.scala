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

  def clear() {
    bound.foreach(_.dispose())
    bound.clear()

    contents.clear()
    changes := (())
  }

  def +=(value: Node) {
    bound += changes << value.changes
    contents += value
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
}
