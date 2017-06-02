package pine

import org.scalatest.FunSuite

class TagRefSpec extends FunSuite {
  test("Use DSL to set boolean attribute to true") {
    val node = tag.Input()
      .id("test")

    val tagRef = TagRef[tag.Input]("test")

    assert(!node.checked)

    val updated = node.update(tagRef.checked.update(!_))
    assert(updated == node.checked(true))
  }

  test("Use DSL to set boolean attribute to false") {
    val node = tag.Input()
      .id("test")
      .checked(true)

    val tagRef = TagRef[tag.Input]("test")

    assert(node.checked)

    val updated = node.update(tagRef.checked.update(!_))
    assert(updated == node.checked(false))
  }

  test("Use DSL to set CSS tag") {
    val node = tag.Input()
      .id("test")
      .`type`("checkbox")

    val tagRef = TagRef[tag.Input]("test")

    val updated = node.update(tagRef.css(true, "a"))
    assert(updated == node.`class`("a"))
  }

  test("Use DSL to remove CSS tag") {
    val node = tag.Input()
      .id("test")
      .`type`("checkbox")
      .`class`("a b c")

    val tagRef = TagRef[tag.Input]("test")

    val updated = node.update(tagRef.css(false, "b"))
    assert(updated == node.`class`("a c"))
  }

  test("Match by tag") {
    val node = tag.Div(children = List(tag.Span()))
    val ref = TagRef(tag.Span())
    val updated = node.update(ref := tag.B())

    assert(updated ==
      tag.Div(children = List(tag.Span(children = List(tag.B())))))
  }

  test("Replace node") {
    val node = tag.Div(children = List(tag.Span()))
    val ref = TagRef(tag.Span())
    val updated = node.update(ref.replace(tag.B()))

    assert(updated == tag.Div(children = List(tag.B())))
  }

  test("Resolve child references") {
    val itemRef = TagRef[tag.Div]("item", "0")
    assert(itemRef == TagRef[tag.Div]("item0"))
  }
}
