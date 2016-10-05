package pl.metastack.metaweb.diff

import pl.metastack.metaweb.tree

class Attribute[+T <: tree.Tag, G, S](val parent: NodeRef[T], val name: String) {
  def set(value: S): Diff = Diff.SetAttribute(parent, this, value)
  def :=(value: S) = set(value)

  def update(f: G => G): Diff = Diff.UpdateAttribute(parent, this, f)
  def remove(): Diff = Diff.RemoveAttribute(parent, this)
}
