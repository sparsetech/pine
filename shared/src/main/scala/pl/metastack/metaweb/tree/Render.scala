package pl.metastack.metaweb.tree

trait Render[N <: Node, T] {
  def render(s: N): T
}
