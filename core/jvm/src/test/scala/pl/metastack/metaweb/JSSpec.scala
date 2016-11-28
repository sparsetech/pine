package pl.metastack.metaweb

import org.scalatest.FunSuite

import pl.metastack.metaweb.macros.Js

class JSSpec extends FunSuite {
  test("Value annotation") {
    var i = 0
    @Js val j = { i = 1 }
    assert(i == 0)
  }

  test("Variable annotation") {
    var i = 0
    @Js var j = { i = 1 }
    assert(i == 0)
  }

  test("Lambda annotation") {
    trait Diff
    object Diff { case class Noop() extends Diff }
    var i = 0
    type T = (Int, Int) => Diff
    @Js def f: T = (_, _) => { i = 1; Diff.Noop() }
    f(1, 2)
    assert(i == 0)
  }

  test("Object annotation") {
    var run = 0
    @Js object Test { run += 1 }
    Test.hashCode()
    assert(run == 0)
  }

  test("Case class annotation") {
    var run = 0
    @Js case class Test() { run += 1 }
    new Test()
    assert(run == 0)
  }

  test("Class annotation") {
    var run = 0
    @Js class Test() { run += 1 }
    new Test()
    assert(run == 0)
  }

  test("Trait annotation") {
    var run = 0
    @Js trait Test { run += 1 }
    new Test {}
    assert(run == 0)
  }

  test("Trait annotation with self-type") {
    var run = 0
    @Js trait Test { this: Test => run += 1 }
    new Test {}
    assert(run == 0)
  }

  test("Method annotation") {
    trait Diff
    object Diff { case class Noop() extends Diff }
    @Js def f(): Diff = ???
    assert(f() == Diff.Noop())
  }
}
