package pl.metastack.metaweb.tree

import pl.metastack.metaweb
import pl.metastack.metaweb.tree

case class Container(nodes: Seq[tree.Node]) extends metaweb.Container with Node {
  override def state: metaweb.state.Container = {
    val container = new metaweb.state.Container
    container.set(nodes.map(_.state))
    container
  }
}
