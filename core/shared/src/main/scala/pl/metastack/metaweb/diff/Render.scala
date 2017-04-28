package pl.metastack.metaweb.diff

import pl.metastack.metaweb.tree

trait Render[Node, Diff, Result] {
  def render(node: Node, diff: Diff): Result
}

object Render {
  def render[Node, Diff, Result](node: Node, diff: Diff)
                                (implicit r: Render[Node, Diff, Result]): Result =
    r.render(node, diff)

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
