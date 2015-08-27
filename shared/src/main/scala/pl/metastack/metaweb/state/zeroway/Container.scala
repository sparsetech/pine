package pl.metastack.metaweb.state.zeroway

import pl.metastack.metaweb.state

class Container extends state.Container with Node {
  private var nodes = Seq.empty[state.Node]

  def ways = 1

  def set(value: Seq[state.Node]) {
    nodes = value
  }

  def get: Seq[state.Node] = nodes
}
