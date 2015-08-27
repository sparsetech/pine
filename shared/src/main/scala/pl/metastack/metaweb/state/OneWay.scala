package pl.metastack.metaweb.state

import pl.metastack.metaweb.State

object OneWay extends State[oneway.Node] {
  override def tag(name: String) = new oneway.Tag(name)
  override def text() = new oneway.Text()
  override def placeholder(): Placeholder = new oneway.Placeholder()
  override def container(): Container = new oneway.Container()
  override def `null`(): Null = new oneway.Null()
}
