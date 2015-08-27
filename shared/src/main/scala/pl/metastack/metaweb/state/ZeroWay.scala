package pl.metastack.metaweb.state

import pl.metastack.metaweb.State

object ZeroWay extends State[zeroway.Node] {
  override def tag(name: String) = new zeroway.Tag(name)
  override def text() = new zeroway.Text()
  override def placeholder(): Placeholder = new zeroway.Placeholder()
  override def container(): Container = new zeroway.Container()
  override def `null`(): Null = new zeroway.Null()
}
