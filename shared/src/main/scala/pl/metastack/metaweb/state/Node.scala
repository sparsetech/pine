package pl.metastack.metaweb.state

import pl.metastack.metarx.{ReadChannel, Buffer}
import pl.metastack.metaweb

trait Node extends metaweb.Node

private[metaweb] trait Children {
  private[metaweb] val contents: Buffer[metaweb.Node]
  def watchChildren: ReadChannel[Buffer.Delta[metaweb.Node]]
}
