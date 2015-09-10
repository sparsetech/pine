package pl.metastack.metaweb

trait Container extends Node {
  def nodes: Seq[Node]
}
