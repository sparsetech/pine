package pine

import org.scalatest.FunSuite

class TagRefSpec extends FunSuite {
  test("Use DSL to set boolean attribute to true") {
    val node = tag.Input.id("test")

    val tagRef = TagRef["input"]("test")

    assert(!node.checked())

    val updated = node.update(implicit ctx => tagRef.checked.update(!_))
    assert(updated == node.checked(true))
  }

  test("Use DSL to set boolean attribute to false") {
    val node = tag.Input
      .id("test")
      .checked(true)

    val tagRef = TagRef[tag.Input]("test")

    assert(node.checked())

    val updated = node.update(implicit ctx => tagRef.checked.update(!_))
    assert(updated == node.checked(false))
  }

  test("Use DSL to set CSS tag") {
    val node = tag.Input
      .id("test")
      .`type`("checkbox")

    val tagRef = TagRef["input"]("test")

    val updated = node.update(implicit ctx => tagRef.css(true, "a"))
    assert(updated == node.`class`("a"))
  }

  test("Use DSL to remove CSS tag") {
    val node = tag.Input
      .id("test")
      .`type`("checkbox")
      .`class`("a", "b", "c")

    val tagRef = TagRef["input"]("test")

    val updated = node.update(implicit ctx => tagRef.css(false, "b"))
    assert(updated == node.`class`("a c"))
  }

  test("Match by tag") {
    val node = tag.Div.set(tag.Span)
    val ref = TagRef["span"]
    val updated = node.update(implicit ctx => ref := tag.B)

    assert(updated == tag.Div.set(tag.Span.set(tag.B)))
  }

  test("Prepend nodes") {
    val div  = html"""<div><span><hr/></span></div>"""
    val html = div.update(implicit ctx =>
      TagRef["span"].prepend(List(
        html"<b>Hello</b>",
        html"<i>World</i>"
      ))
    ).toHtml
    assert(html == "<div><span><b>Hello</b><i>World</i><hr/></span></div>")
  }

  test("Append nodes") {
    val div  = html"""<div><span><hr/></span></div>"""
    val html = div.update(implicit ctx =>
      TagRef["span"] ++= List(
        html"<b>Hello</b>",
        html"<i>World</i>"
      )
    ).toHtml
    assert(html == "<div><span><hr/><b>Hello</b><i>World</i></span></div>")
  }

  test("Replace node") {
    val node = tag.Div.set(tag.Span)
    val ref = TagRef["span"]
    val updated = node.update(implicit ctx => ref.replace(tag.B))

    assert(updated == tag.Div.set(tag.B))
  }

  test("Clear nodes") {
    val div  = html"""<div><span><hr/></span></div>"""
    val html = div.update(implicit ctx => TagRef["span"].clearAll()).toHtml
    assert(html == "<div><span></span></div>")
  }

  test("Add class") {
    val div  = html"""<div class="b"></div>"""
    val html = div.update(implicit ctx =>
      TagRef["div"].`class`.add("a")).toHtml
    assert(html == """<div class="b a"></div>""")
  }

  test("Toggle class") {
    val div  = html"""<div class="b"></div>"""
    val html = div.update(implicit ctx =>
      TagRef["div"].`class`.toggle("b")).toHtml
    assert(html == """<div></div>""")
  }

  test("Toggle class (2)") {
    val div  = html"""<div></div>"""
    val html = div.update(implicit ctx =>
      TagRef["div"].`class`.toggle("b")).toHtml
    assert(html == """<div class="b"></div>""")
  }

  test("Update class on ByClass reference") {
    val node = tag.Div.`class`("test")
    val ref  = TagRef.ByClass[tag.Div]("test")

    val updated = node.update(implicit ctx => ref.`class` := "test2")
    assert(updated == tag.Div.`class`("test2"))
  }

  test("Resolve child references") {
    val itemRef = TagRef["div"]("item", "0")
    assert(itemRef == TagRef["div"]("item0"))
  }

  test("Invalid reference") {
    val node = tag.Div
    val ref = TagRef["span"]

    assertThrows[Exception] {
      node.update(implicit ctx => ref.replace(tag.B))
    }
  }
}
