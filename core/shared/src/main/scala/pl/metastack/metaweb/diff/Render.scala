package pl.metastack.metaweb.diff

import pl.metastack.metaweb.tree

object Render {
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
