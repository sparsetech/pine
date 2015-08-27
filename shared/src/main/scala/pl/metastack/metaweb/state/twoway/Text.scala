package pl.metastack.metaweb.state.twoway

import pl.metastack.metaweb.state

class Text extends state.oneway.Text with Node {
  override def ways = 2
}
