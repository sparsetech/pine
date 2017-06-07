package pine

case class Attribute[T <: Singleton, G, S](parent: TagRef[T], name: String) {
  def set(value: S)(implicit renderCtx: RenderContext): Unit =
    renderCtx.render(parent, Diff.SetAttribute(this, value))

  def update(f: G => G)(implicit renderCtx: RenderContext): Unit =
    renderCtx.render(parent, Diff.UpdateAttribute(this, f))

  def remove()(implicit renderCtx: RenderContext): Unit =
    renderCtx.render(parent, Diff.RemoveAttribute(this))

  def :=(value: S)(implicit renderCtx: RenderContext): Unit = set(value)
}
