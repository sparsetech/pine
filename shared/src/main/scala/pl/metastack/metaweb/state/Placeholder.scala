package pl.metastack.metaweb.state

trait Placeholder extends Node {
  def set(value: Option[Node])
  def get: Option[Node]
}
