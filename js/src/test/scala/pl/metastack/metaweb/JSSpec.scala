package pl.metastack.metaweb

import org.scalatest.FunSuite

import pl.metastack.metaweb.macros.Js

class JSSpec extends FunSuite {
  test("Value annotation") {
    var i = 0
    @Js val j = { i = 1 }
    assert(i == 1 && j == ())
  }

  test("Variable annotation") {
    var i = 0
    @Js var j = { i = 1 }
    assert(i == 1 && j == ())
  }

  test("Object annotation") {
    var run = 0
    @Js object Test { run += 1 }
    Test.hashCode()
    assert(run == 1)
  }

  test("Case class annotation") {
    var run = 0
    @Js case class Test() { run += 1 }
    new Test()
    assert(run == 1)
  }

  test("Class annotation") {
    var run = 0
    @Js class Test() { run += 1 }
    new Test()
    assert(run == 1)
  }

  test("Trait annotation") {
    var run = 0
    @Js trait Test { run += 1 }
    new Test {}
    assert(run == 1)
  }

  test("Method annotation") {
    trait Diff
    object Diff {
      case class Noop() extends Diff
      case class Test() extends Diff
    }
    @Js def f(): Diff = Diff.Test()
    assert(f() == Diff.Test())
  }
}
