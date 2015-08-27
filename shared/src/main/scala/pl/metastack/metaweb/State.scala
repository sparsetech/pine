package pl.metastack.metaweb

trait State[T <: state.Node] {
  def tag(tagName: String): state.Tag
  def text(): state.Text
  def placeholder(): state.Placeholder
  def container(): state.Container
  def `null`(): state.Null
}
