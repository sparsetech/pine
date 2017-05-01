package pl.metastack.metaweb.dom

import org.scalajs.dom.document
import org.scalatest.FunSuite

import pl.metastack.metaweb._

class TagRefSpec extends FunSuite {
  test("Get value of String attribute") {
    val node = document.createElement("a")
    node.setAttribute("id", "test")
    node.setAttribute("href", "http://google.com/")
    node.appendChild(document.createTextNode("Google"))

    document.body.appendChild(node)

    val tagRef = TagRef[tag.A]("test")
    assert(DOM.get(tagRef.href).contains("http://google.com/"))

    document.body.removeChild(node)
  }

  test("Get value of Boolean attribute") {
    val node = document.createElement("input")
    node.setAttribute("id", "test")
    node.setAttribute("type", "checkbox")

    document.body.appendChild(node)

    val tagRef = TagRef[tag.Input]("test")
    assert(!DOM.get(tagRef.checked))

    document.body.removeChild(node)
  }

  test("Get value of Boolean attribute (2)") {
    val node = document.createElement("input")
    node.setAttribute("id", "test")
    node.setAttribute("type", "checkbox")
    node.setAttribute("checked", "")

    document.body.appendChild(node)

    val tagRef = TagRef[tag.Input]("test")
    assert(DOM.get(tagRef.checked))

    document.body.removeChild(node)
  }

  test("Set value of Boolean attribute") {
    val node = document.createElement("input")
    node.setAttribute("id", "test")
    node.setAttribute("type", "checkbox")

    val tagRef = TagRef[tag.Input]("test")

    document.body.appendChild(node)

    DOM.render(tagRef.checked := true)
    assert(DOM.get(tagRef.checked))

    DOM.render(tagRef.checked := false)
    assert(!DOM.get(tagRef.checked))

    document.body.removeChild(node)
  }

  test("Set value of String attribute") {
    val node = document.createElement("a")
    node.setAttribute("id", "test")
    node.setAttribute("href", "http://google.com/")
    node.appendChild(document.createTextNode("Google"))

    val tagRef = TagRef[tag.A]("test")

    document.body.appendChild(node)

    DOM.render(tagRef.href := "http://github.com/")
    assert(DOM.get(tagRef.href).contains("http://github.com/"))

    DOM.render(tagRef.href := "")
    assert(DOM.get(tagRef.href).contains(""))

    DOM.render(tagRef.href.remove())
    assert(DOM.get(tagRef.href).isEmpty)

    document.body.removeChild(node)
  }

  test("Update value of String attribute") {
    val node = document.createElement("a")
    node.setAttribute("id", "test")
    node.setAttribute("href", "http://google.com/")
    node.appendChild(document.createTextNode("Google"))

    val tagRef = TagRef[tag.A]("test")
    document.body.appendChild(node)

    DOM.render(tagRef.href.update(_ => None))
    assert(DOM.get(tagRef.href).isEmpty)

    DOM.render(tagRef.href.update(x => Some(x.toString)))
    assert(DOM.get(tagRef.href).contains("None"))

    document.body.removeChild(node)
  }

  test("Update value of Boolean attribute") {
    val node = document.createElement("input")
    node.setAttribute("id", "test")
    node.setAttribute("type", "checkbox")

    val tagRef = TagRef[tag.Input]("test")
    document.body.appendChild(node)

    DOM.render(tagRef.checked.update(!_))
    assert(DOM.get(tagRef.checked))

    DOM.render(tagRef.checked.update(!_))
    assert(!DOM.get(tagRef.checked))

    document.body.removeChild(node)
  }

  test("Use DSL to update CSS tag") {
    val node = document.createElement("input")
    node.setAttribute("id", "test")
    node.setAttribute("type", "checkbox")
    node.setAttribute("class", "a b c")

    val tagRef = TagRef[tag.Input]("test")
    document.body.appendChild(node)

    DOM.render(tagRef.css(false, "b"))
    assert(DOM.get(tagRef.`class`).contains("a c"))
    assert(DOM.get(tagRef).className == "a c")

    document.body.removeChild(node)
  }

  test("Match by tag") {
    val node = document.createElement("input")
    val div  = document.createElement("div")

    document.body.appendChild(node)
    document.body.appendChild(div)

    val tagRef1 = TagRef(tag.Input())
    val tagRef2 = TagRef(tag.Div())

    assert(DOM.get(tagRef1) == node)
    assert(DOM.get(tagRef2) == div)

    document.body.removeChild(div)
    document.body.removeChild(node)
  }
}
