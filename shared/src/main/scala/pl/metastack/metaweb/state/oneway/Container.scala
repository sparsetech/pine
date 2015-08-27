package pl.metastack.metaweb.state.oneway

import pl.metastack.metarx.{ReadChannel, DeltaBuffer, Buffer}

import pl.metastack.metaweb.state

class Container extends state.Container with Node {
  private val nodes = Buffer[state.Node]()

  def ways = 1

  def set(value: Seq[state.Node]) {
    nodes.set(value)
  }

  def get: Seq[state.Node] = nodes.get

  def deltas: ReadChannel[Buffer.Delta[state.Node]] = nodes.changes

  /** May only be called once */
  def listen(delta: DeltaBuffer[state.Node]) {
    nodes.clear()
    nodes.changes << delta.changes
  }
}
