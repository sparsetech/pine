package pl.metastack.metaweb.state

import pl.metastack.metarx.{Buffer, DeltaBuffer, ReadChannel}

import pl.metastack.metaweb

class Container extends metaweb.Container with Node {
  private val _nodes = Buffer[metaweb.Node]()

  def set(value: Seq[metaweb.Node]) {
    _nodes.set(value)
  }

  def nodes: Seq[metaweb.Node] = _nodes.get

  def deltas: ReadChannel[Buffer.Delta[metaweb.Node]] = _nodes.changes

  /** May only be called once */
  def listen(delta: DeltaBuffer[metaweb.Node]) {
    _nodes.clear()
    _nodes.changes << delta.changes
  }
}
