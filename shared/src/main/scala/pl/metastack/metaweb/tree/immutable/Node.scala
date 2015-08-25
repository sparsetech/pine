package pl.metastack.metaweb.tree.immutable

import pl.metastack.metaweb.tree

trait Node extends tree.Node {
  def byId[T <: tree.Tag](id: String): T =
    this match {
      case t: tree.Tag => t.byIdOpt(id).get
      case _ => throw new RuntimeException("Root node must be an HTML element")
    }
}
