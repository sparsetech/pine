package pl.metastack.metaweb.tree

import pl.metastack.metaweb
import pl.metastack.metaweb.tree

case class Container(children: Seq[tree.Node]) extends metaweb.Container with Node {
  override def state: metaweb.state.Container = {
    val container = new metaweb.state.Container
    container.set(children.map(_.state))
    container
  }
}
