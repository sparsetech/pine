package pl.metastack.metaweb

trait View {
  def head: tag.Head
  def body: tag.Body
}
