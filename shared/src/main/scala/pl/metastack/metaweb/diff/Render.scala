package pl.metastack.metaweb.diff

import scala.concurrent.Future

import pl.metastack.metaweb.tree

trait Render[T, U] {
  def render(node: T, diff: Diff): Future[U]
}

object Render {
  def render[T, U](value: T, diff: Diff)(implicit r: Render[T, U]): Future[U] =
    r.render(value, diff)

  def suffixIds(node: tree.Node, suffix: String): tree.Node =
    if (suffix.isEmpty) node
    else node match {
      case tag: tree.Tag if tag.attributes.contains("id") =>
        tag.copy(
          attributes = tag.attributes +
            ("id" -> (tag.attributes("id").asInstanceOf[String] + suffix)),
          children = tag.children.map(suffixIds(_, suffix)))
      case tag: tree.Tag =>
        tag.copy(children = tag.children.map(suffixIds(_, suffix)))
      case n => n
    }
}
