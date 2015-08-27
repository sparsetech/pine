package pl.metastack.metaweb.state

import pl.metastack.metaweb.State

object TwoWay extends State[twoway.Node] {
  override def tag(name: String) = new twoway.Tag(name)
  override def text() = new twoway.Text()
  override def placeholder(): Placeholder = new twoway.Placeholder()
  override def container(): Container = new twoway.Container()
  override def `null`(): Null = new twoway.Null()
}
