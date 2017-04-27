package pl.metastack.metaweb.cats

import org.scalatest._
import pl.metastack.metaweb.diff.Diff

import cats.Monoid
import cats.contrib.instances.diff._
import cats.syntax.all._

class ExampleSpec extends FlatSpec with Matchers {
  "Monoid[Diff]" should "have an identity equal to Noop" in {
    implicitly[Monoid[Diff]].empty shouldBe Diff.Noop()
  }

  it should "have a composition operation equal to `:+`" in {
    val e1: Diff = Diff.Noop()
    val e2: Diff = Diff.Noop()
    e1 |+| e2 shouldBe e1 :+ e2
  }
}
