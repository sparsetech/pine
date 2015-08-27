package pl.metastack.metaweb.state.zeroway

import pl.metastack.metaweb.state

class Placeholder extends state.Placeholder with Node {
  private var node = Option.empty[state.Node]

  def ways = 0

  def set(value: Option[state.Node]) {
    node = value
  }

  def get: Option[state.Node] = node
}
