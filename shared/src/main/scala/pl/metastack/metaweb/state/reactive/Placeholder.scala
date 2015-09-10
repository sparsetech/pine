package pl.metastack.metaweb.state.reactive

import pl.metastack.metarx.{Opt, ReadChannel}

import pl.metastack.metaweb.state

class Placeholder extends state.Placeholder with Node {
  private val node = Opt[state.Node]()

  def set(value: Option[state.Node]) {
    node := value
  }

  def get: Option[state.Node] = node.get

  def values: ReadChannel[Option[state.Node]] = node

  def listen(ch: ReadChannel[Option[state.Node]]) {
    node << ch
  }
}
