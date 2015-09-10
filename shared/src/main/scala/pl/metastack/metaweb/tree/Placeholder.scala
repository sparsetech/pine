package pl.metastack.metaweb.tree

import pl.metastack.metaweb

case class Placeholder(node: Option[Node]) extends metaweb.Placeholder with Node {
  override def state: metaweb.state.Placeholder = {
    val st = new metaweb.state.Placeholder
    st.set(node.map(_.state))
    st
  }
}
