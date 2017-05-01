package pl.metastack.metaweb

case class Attribute[+T <: Tag, G, S](parent: TagRef[T], name: String) {
  def set(value: S): Diff = Diff.SetAttribute(parent, this, value)
  def :=(value: S): Diff = set(value)

  def update(f: G => G): Diff = Diff.UpdateAttribute(parent, this, f)
  def remove(): Diff = Diff.RemoveAttribute(parent, this)
}
