package pl.metastack.metaweb.state

trait Container extends Node {
  def set(value: Seq[Node])
  def get: Seq[Node]
}
