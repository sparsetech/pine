package pl.metastack.metaweb.state

import pl.metastack.metaweb.State

object Reactive extends State[reactive.Node] {
  override def tag(name: String) = new reactive.Tag(name)
  override def text() = new reactive.Text()
  override def placeholder(): Placeholder = new reactive.Placeholder()
  override def container(): Container = new reactive.Container()
  override def `null`(): Null = new reactive.Null()
}
