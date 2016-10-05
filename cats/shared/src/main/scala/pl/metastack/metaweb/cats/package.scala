package pl.metastack.metaweb

import _root_.cats.Monoid
import pl.metastack.metaweb.diff.Diff

package object cats {
  /**
   * A Monoid for Diff, who's `empty` is `Diff.Noop()`
   * and `combine` - the `:+` operation.
   */
  implicit val diffMonoid = new Monoid[Diff] {
    override def empty: Diff = Diff.Noop()
    override def combine(a: Diff, b: Diff): Diff = a :+ b
  }
}