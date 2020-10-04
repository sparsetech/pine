package pine.dom

import org.scalajs.dom.document
import org.scalatest.funsuite.AnyFunSuite

import pine._

class TagRefSpec extends AnyFunSuite {
  test("Get value of String attribute") {
    val node = document.createElement("a")
    node.setAttribute("id", "test")
    node.setAttribute("href", "http://google.com/")
    node.appendChild(document.createTextNode("Google"))

    document.body.appendChild(node)

    val tagRef = TagRef[tag.A]("test")
    assert(tagRef.href.get.contains("http://google.com/"))

    document.body.removeChild(node)
  }

  test("Get value of Boolean attribute") {
    val node = document.createElement("input")
    node.setAttribute("id", "test")
    node.setAttribute("type", "checkbox")

    document.body.appendChild(node)

    val tagRef = TagRef[tag.Input]("test")
    assert(!tagRef.checked.get)

    document.body.removeChild(node)
  }

  test("Get value of Boolean attribute (2)") {
    val node = document.createElement("input")
    node.setAttribute("id", "test")
    node.setAttribute("type", "checkbox")
    node.setAttribute("checked", "")

    document.body.appendChild(node)

    val tagRef = TagRef[tag.Input]("test")
    assert(tagRef.checked.get)

    document.body.removeChild(node)
  }

  test("Set value of Boolean attribute") {
    val node = document.createElement("input")
    node.setAttribute("id", "test")
    node.setAttribute("type", "checkbox")

    val tagRef = TagRef[tag.Input]("test")

    document.body.appendChild(node)

    DOM.render(implicit ctx => tagRef.checked := true)
    assert(tagRef.checked.get)

    DOM.render(implicit ctx => tagRef.checked := false)
    assert(!tagRef.checked.get)

    document.body.removeChild(node)
  }

  test("Set value of String attribute") {
    val node = document.createElement("a")
    node.setAttribute("id", "test")
    node.setAttribute("href", "http://google.com/")
    node.appendChild(document.createTextNode("Google"))

    val tagRef = TagRef[tag.A]("test")

    document.body.appendChild(node)

    DOM.render(implicit ctx => tagRef.href := "http://github.com/")
    assert(tagRef.href.get.contains("http://github.com/"))

    DOM.render(implicit ctx => tagRef.href := "")
    assert(tagRef.href.get.contains(""))

    DOM.render(implicit ctx => tagRef.href.remove())
    assert(tagRef.href.get.isEmpty)

    document.body.removeChild(node)
  }

  test("Update value of String attribute") {
    val node = document.createElement("a")
    node.setAttribute("id", "test")
    node.setAttribute("href", "http://google.com/")
    node.appendChild(document.createTextNode("Google"))

    val tagRef = TagRef[tag.A]("test")
    document.body.appendChild(node)

    DOM.render(implicit ctx => tagRef.href.update(_ => ""))
    assert(tagRef.href.get.isEmpty)

    DOM.render(implicit ctx => tagRef.href.update(_ => "test"))
    assert(tagRef.href.get.contains("test"))

    document.body.removeChild(node)
  }

  test("Update value of Boolean attribute") {
    val node = document.createElement("input")
    node.setAttribute("id", "test")
    node.setAttribute("type", "checkbox")

    val tagRef = TagRef[tag.Input]("test")
    document.body.appendChild(node)

    DOM.render(implicit ctx => tagRef.checked.update(!_))
    assert(tagRef.checked.get)

    DOM.render(implicit ctx => tagRef.checked.update(!_))
    assert(!tagRef.checked.get)

    document.body.removeChild(node)
  }

  test("Use DSL to update CSS tag") {
    val node = document.createElement("input")
    node.setAttribute("id", "test")
    node.setAttribute("type", "checkbox")
    node.setAttribute("class", "a b c")

    val tagRef = TagRef[tag.Input]("test")
    document.body.appendChild(node)

    DOM.render(implicit ctx => tagRef.`class`.state(false, "b"))
    assert(tagRef.`class`.get == List("a", "c"))
    assert(tagRef.dom.className == "a c")

    document.body.removeChild(node)
  }

  test("Match by tag") {
    val node = document.createElement("input")
    val div  = document.createElement("div")

    document.body.appendChild(node)
    document.body.appendChild(div)

    val tagRef1 = TagRef[tag.Input]
    val tagRef2 = TagRef[tag.Div]

    assert(tagRef1.dom == node)
    assert(tagRef2.dom == div)

    document.body.removeChild(div)
    document.body.removeChild(node)
  }

  test("Prepend nodes") {
    val div = html"""<div><span><hr/></span></div>""".toDom
    document.body.appendChild(div)

    DOM.render(implicit ctx =>
      TagRef["span"].prepend(List(
        html"<b>Hello</b>",
        html"<i>World</i>"
      ))
    )

    val html = DOM.toTree(div).toHtml
    document.body.removeChild(div)

    assert(html == "<div><span><b>Hello</b><i>World</i><hr/></span></div>")
  }

  test("Insert before") {
    val div = html"""<div><span><hr/><hr/></span></div>""".toDom
    document.body.appendChild(div)

    DOM.render(implicit ctx =>
      TagRef["span"].insertBefore(TagRef["hr"], tag.Div))

    val html = DOM.toTree(div).toHtml
    document.body.removeChild(div)

    assert(html == "<div><span><div></div><hr/><hr/></span></div>")
  }

  test("Insert after") {
    val div = html"""<div><span><hr/></span></div>""".toDom
    document.body.appendChild(div)

    DOM.render(implicit ctx =>
      TagRef["span"].insertAfter(TagRef["hr"], tag.Div))

    val html = DOM.toTree(div).toHtml
    document.body.removeChild(div)

    assert(html == "<div><span><hr/><div></div></span></div>")
  }

  test("Insert after (2)") {
    val div = html"""<div><span><hr/><hr/></span></div>""".toDom
    document.body.appendChild(div)

    DOM.render(implicit ctx =>
      TagRef["span"].insertAfter(TagRef["hr"], tag.Div))

    val html = DOM.toTree(div).toHtml
    document.body.removeChild(div)

    assert(html == "<div><span><hr/><div></div><hr/></span></div>")
  }

  test("Insert at position") {
    val div = html"""<div id="nodes"></div>""".toDom
    document.body.appendChild(div)

    DOM.render { implicit ctx =>
      TagRef("nodes").insertAt(0, tag.Span.set("a"))
    }

    val html = DOM.toTree(div).toHtml
    document.body.removeChild(div)

    assert(html == """<div id="nodes"><span>a</span></div>""")
  }

  test("Insert at position (2)") {
    val div = html"""<div id="nodes"><span>a</span><span>b</span><span>c</span></div>""".toDom
    document.body.appendChild(div)

    DOM.render { implicit ctx =>
      TagRef("nodes").insertAt(1, List(tag.Span.set("d"), tag.Span.set("e")))
    }

    val html = DOM.toTree(div).toHtml
    document.body.removeChild(div)

    assert(html == """<div id="nodes"><span>a</span><span>d</span><span>e</span><span>b</span><span>c</span></div>""")
  }
}
