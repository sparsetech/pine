package pl.metastack.metaweb.diff

import pl.metastack.metaweb.tree

trait Render[T, U] {
  def render(node: T, diff: Diff): U
}

object Render {
  def render[T, U](value: T, diff: Diff)(implicit r: Render[T, U]): U =
    r.render(value, diff)

  /** Recursively adds `suffix` to every ID attribute of `node` */
  def suffixIds(node: tree.Node, suffix: String): tree.Node =
    if (suffix.isEmpty) node
    else node match {
      case tag: tree.Tag if tag.id.nonEmpty =>
        tag.copy(
          attributes = tag.attributes + ("id" -> (tag.id.get + suffix)),
          children   = tag.children.map(suffixIds(_, suffix)))

      case tag: tree.Tag =>
        tag.copy(children = tag.children.map(suffixIds(_, suffix)))

      case n => n
    }
}
