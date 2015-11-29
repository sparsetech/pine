package pl.metastack.metaweb.state

import pl.metastack.metarx.{Buffer, DeltaBuffer, ReadChannel}

import pl.metastack.metaweb

class Container extends metaweb.Container with Node with Children {
  override private[metaweb] val contents = Buffer[metaweb.Node]()

  def set(value: Seq[metaweb.Node]): Unit =
    contents.set(value)

  def nodes: Seq[metaweb.Node] = contents.get

  override def watchChildren: ReadChannel[Buffer.Delta[metaweb.Node]] =
    contents.changes

  /** May only be called once */
  def listen(delta: DeltaBuffer[metaweb.Node]) {
    contents.clear()
    contents.changes << delta.changes
  }
}
