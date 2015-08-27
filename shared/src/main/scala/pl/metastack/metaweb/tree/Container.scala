package pl.metastack.metaweb.tree

import pl.metastack.metaweb
import pl.metastack.metaweb.{tree, State}

case class Container(nodes: Seq[tree.Node]) extends Node {
  override def state[T <: metaweb.state.Node](creator: State[T]): T with metaweb.state.Container = {
    val container = creator.container()
    container.set(nodes.map(_.state(creator)))
    container.asInstanceOf[T with metaweb.state.Container]
  }
}
