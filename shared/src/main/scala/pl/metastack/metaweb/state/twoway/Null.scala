package pl.metastack.metaweb.state.twoway

import pl.metastack.metaweb.state

class Null extends state.oneway.Null with Node {
  override def ways = 2
}
