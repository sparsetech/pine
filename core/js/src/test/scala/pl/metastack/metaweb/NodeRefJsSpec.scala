package pl.metastack.metaweb

import org.scalajs.dom
import org.scalatest.FunSuite

import pl.metastack.metaweb.diff.NodeRef

class NodeRefJsSpec extends FunSuite {
  test("Get value of String attribute") {
    val node = dom.document.createElement("a")
    node.setAttribute("id", "test")
    node.setAttribute("href", "http://google.com/")
    node.appendChild(dom.document.createTextNode("Google"))

    dom.document.body.appendChild(node)

    val nodeRef = NodeRef[tag.A]("test")
    assert(DOM.get(nodeRef.href).contains("http://google.com/"))

    dom.document.body.removeChild(node)
  }

  test("Get value of Boolean attribute") {
    val node = dom.document.createElement("input")
    node.setAttribute("id", "test")
    node.setAttribute("type", "checkbox")

    dom.document.body.appendChild(node)

    val nodeRef = NodeRef[tag.Input]("test")
    assert(!DOM.get(nodeRef.checked))

    dom.document.body.removeChild(node)
  }

  test("Get value of Boolean attribute (2)") {
    val node = dom.document.createElement("input")
    node.setAttribute("id", "test")
    node.setAttribute("type", "checkbox")
    node.setAttribute("checked", "")

    dom.document.body.appendChild(node)

    val nodeRef = NodeRef[tag.Input]("test")
    assert(DOM.get(nodeRef.checked))

    dom.document.body.removeChild(node)
  }

  test("Set value of Boolean attribute") {
    val node = dom.document.createElement("input")
    node.setAttribute("id", "test")
    node.setAttribute("type", "checkbox")

    val nodeRef = NodeRef[tag.Input]("test")

    dom.document.body.appendChild(node)

    DOM.render(nodeRef.checked := true)
    assert(DOM.get(nodeRef.checked))

    DOM.render(nodeRef.checked := false)
    assert(!DOM.get(nodeRef.checked))

    dom.document.body.removeChild(node)
  }

  test("Set value of String attribute") {
    val node = dom.document.createElement("a")
    node.setAttribute("id", "test")
    node.setAttribute("href", "http://google.com/")
    node.appendChild(dom.document.createTextNode("Google"))

    val nodeRef = NodeRef[tag.A]("test")

    dom.document.body.appendChild(node)

    DOM.render(nodeRef.href := "http://github.com/")
    assert(DOM.get(nodeRef.href).contains("http://github.com/"))

    DOM.render(nodeRef.href := "")
    assert(DOM.get(nodeRef.href).contains(""))

    DOM.render(nodeRef.href.remove())
    assert(DOM.get(nodeRef.href).isEmpty)

    dom.document.body.removeChild(node)
  }

  test("Update value of String attribute") {
    val node = dom.document.createElement("a")
    node.setAttribute("id", "test")
    node.setAttribute("href", "http://google.com/")
    node.appendChild(dom.document.createTextNode("Google"))

    val nodeRef = NodeRef[tag.A]("test")
    dom.document.body.appendChild(node)

    DOM.render(nodeRef.href.update(_ => None))
    assert(DOM.get(nodeRef.href).isEmpty)

    DOM.render(nodeRef.href.update(x => Some(x.toString)))
    assert(DOM.get(nodeRef.href).contains("None"))

    dom.document.body.removeChild(node)
  }

  test("Update value of Boolean attribute") {
    val node = dom.document.createElement("input")
    node.setAttribute("id", "test")
    node.setAttribute("type", "checkbox")

    val nodeRef = NodeRef[tag.Input]("test")
    dom.document.body.appendChild(node)

    DOM.render(nodeRef.checked.update(!_))
    assert(DOM.get(nodeRef.checked))

    DOM.render(nodeRef.checked.update(!_))
    assert(!DOM.get(nodeRef.checked))

    dom.document.body.removeChild(node)
  }

  test("Use DSL to update CSS tag") {
    val node = dom.document.createElement("input")
    node.setAttribute("id", "test")
    node.setAttribute("type", "checkbox")
    node.setAttribute("class", "a b c")

    val nodeRef = NodeRef[tag.Input]("test")
    dom.document.body.appendChild(node)

    DOM.render(nodeRef.css(false, "b"))
    assert(DOM.get(nodeRef.`class`).contains("a c"))
    assert(DOM.get(nodeRef).className == "a c")

    dom.document.body.removeChild(node)
  }

  test("Match by tag") {
    val node = dom.document.createElement("input")
    val div  = dom.document.createElement("div")

    dom.document.body.appendChild(node)
    dom.document.body.appendChild(div)

    val nodeRef1 = NodeRef(tag.Input())
    val nodeRef2 = NodeRef(tag.Div())

    assert(DOM.get(nodeRef1) == node)
    assert(DOM.get(nodeRef2) == div)

    dom.document.body.removeChild(div)
    dom.document.body.removeChild(node)
  }
}
