package pl.metastack.metaweb.tree

trait Node {
  def toHtml: String
  def copy(): Node
  def byId[T <: Tag](id: String): T
}
