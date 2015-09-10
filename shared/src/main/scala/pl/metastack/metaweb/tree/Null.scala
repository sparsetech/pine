package pl.metastack.metaweb.tree

import pl.metastack.metaweb

case object Null extends metaweb.Null with Node {
  override def state: metaweb.state.Null = new metaweb.state.Null
}
