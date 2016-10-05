package cats.contrib.instances

import cats.Monoid
import pl.metastack.metaweb.diff.Diff

trait DiffInstances {
  /**
   * A Monoid for Diff, who's `empty` is `Diff.Noop()`
   * and `combine` - the `:+` operation.
   */
  implicit val diffMonoid = new Monoid[Diff] {
    override def empty: Diff = Diff.Noop()
    override def combine(a: Diff, b: Diff): Diff = a :+ b
  }
}

object diff extends DiffInstances