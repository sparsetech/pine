package pl.metastack.metaweb.tree

import pl.metastack.metaweb

trait Node extends metaweb.Node {
  def state: metaweb.state.Node
}
