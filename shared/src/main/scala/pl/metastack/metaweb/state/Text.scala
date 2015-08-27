package pl.metastack.metaweb.state

trait Text extends Node {
  def get: String
  def set(text: String)
}
