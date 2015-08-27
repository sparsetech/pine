package pl.metastack.metaweb.tree

import pl.metastack.metaweb
import pl.metastack.metaweb.State

case object Null extends Node {
  override def state[T <: metaweb.state.Node](creator: State[T]): T with metaweb.state.Null =
    creator.`null`().asInstanceOf[T with metaweb.state.Null]
}
