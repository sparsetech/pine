package pl.metastack.metaweb.state.twoway

import pl.metastack.metaweb.state

class Placeholder extends state.oneway.Placeholder with Node {
  override def ways = 2
}
