package pl.metastack.metaweb.tree

import pl.metastack.metaweb
import pl.metastack.metaweb.{State, tree}

case class Placeholder(node: Option[tree.Node]) extends Node {
  override def state[T <: metaweb.state.Node](creator: State[T]): T with metaweb.state.Placeholder = {
    val st = creator.placeholder()
    st.set(node.map(_.state(creator)))
    st.asInstanceOf[T with metaweb.state.Placeholder]
  }
}
