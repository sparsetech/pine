package pl.metastack.metaweb.tree

import pl.metastack.metaweb
import pl.metastack.metaweb.State

trait Node {
  def state[T <: metaweb.state.Node](creator: State[T]): T
}
