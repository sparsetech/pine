package pl.metastack.metaweb

trait Render[S, T] {
  def render(s: S): T
}
