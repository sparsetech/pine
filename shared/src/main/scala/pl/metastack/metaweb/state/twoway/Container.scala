package pl.metastack.metaweb.state.twoway

import pl.metastack.metaweb.state

class Container extends state.oneway.Container with Node {
  override def ways = 2
}
