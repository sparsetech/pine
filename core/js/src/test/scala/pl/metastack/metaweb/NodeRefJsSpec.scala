package pl.metastack.metaweb

import scala.concurrent.ExecutionContext.Implicits.global

import org.scalajs.dom
import org.scalatest.FunSuite

import pl.metastack.metaweb.diff.NodeRef

class NodeRefJsSpec extends FunSuite with DiffSupport {
  test("Get value of String attribute") {
    val node = dom.document.createElement("a")
    node.setAttribute("id", "test")
    node.setAttribute("href", "http://google.com/")
    node.appendChild(dom.document.createTextNode("Google"))

    dom.document.body.appendChild(node)

    val nodeRef = NodeRef[tag.A]("test")
    assert(nodeRef.href.get.contains("http://google.com/"))

    dom.document.body.removeChild(node)
  }

  test("Get value of Boolean attribute") {
    val node = dom.document.createElement("input")
    node.setAttribute("id", "test")
    node.setAttribute("type", "checkbox")

    dom.document.body.appendChild(node)

    val nodeRef = NodeRef[tag.Input]("test")
    assert(!nodeRef.checked.get)

    dom.document.body.removeChild(node)
  }

  test("Get value of Boolean attribute (2)") {
    val node = dom.document.createElement("input")
    node.setAttribute("id", "test")
    node.setAttribute("type", "checkbox")
    node.setAttribute("checked", "")

    dom.document.body.appendChild(node)

    val nodeRef = NodeRef[tag.Input]("test")
    assert(nodeRef.checked.get)

    dom.document.body.removeChild(node)
  }

  test("Set value of Boolean attribute") {
    val node = dom.document.createElement("input")
    node.setAttribute("id", "test")
    node.setAttribute("type", "checkbox")

    val nodeRef = NodeRef[tag.Input]("test")

    dom.document.body.appendChild(node)

    diff.render.DOM.RenderDom.render(node, nodeRef.checked := true)
    assert(nodeRef.checked.get)

    diff.render.DOM.RenderDom.render(node, nodeRef.checked := false)
    assert(!nodeRef.checked.get)

    dom.document.body.removeChild(node)
  }

  test("Set value of String attribute") {
    val node = dom.document.createElement("a")
    node.setAttribute("id", "test")
    node.setAttribute("href", "http://google.com/")
    node.appendChild(dom.document.createTextNode("Google"))

    val nodeRef = NodeRef[tag.A]("test")

    dom.document.body.appendChild(node)

    diff.render.DOM.RenderDom.render(node, nodeRef.href := "http://github.com/")
    assert(nodeRef.href.get.contains("http://github.com/"))

    diff.render.DOM.RenderDom.render(node, nodeRef.href := "")
    assert(nodeRef.href.get.contains(""))

    diff.render.DOM.RenderDom.render(node, nodeRef.href.remove())
    assert(nodeRef.href.get.isEmpty)

    dom.document.body.removeChild(node)
  }

  test("Update value of String attribute") {
    val node = dom.document.createElement("a")
    node.setAttribute("id", "test")
    node.setAttribute("href", "http://google.com/")
    node.appendChild(dom.document.createTextNode("Google"))

    val nodeRef = NodeRef[tag.A]("test")

    dom.document.body.appendChild(node)

    diff.render.DOM.RenderDom.render(node, nodeRef.href.update(_ => None))
    assert(nodeRef.href.get.isEmpty)

    diff.render.DOM.RenderDom.render(node, nodeRef.href.update(x => Some(x.toString)))
    assert(nodeRef.href.get.contains("None"))

    dom.document.body.removeChild(node)
  }

  test("Update value of Boolean attribute") {
    val node = dom.document.createElement("input")
    node.setAttribute("id", "test")
    node.setAttribute("type", "checkbox")

    val nodeRef = NodeRef[tag.Input]("test")

    dom.document.body.appendChild(node)

    diff.render.DOM.RenderDom.render(node, nodeRef.checked.update(!_))
    assert(nodeRef.checked.get)

    diff.render.DOM.RenderDom.render(node, nodeRef.checked.update(!_))
    assert(!nodeRef.checked.get)

    dom.document.body.removeChild(node)
  }

  test("Use DSL to update CSS tag") {
    import dsl._

    val node = dom.document.createElement("input")
    node.setAttribute("id", "test")
    node.setAttribute("type", "checkbox")
    node.setAttribute("class", "a b c")

    val nodeRef = NodeRef[tag.Input]("test")

    dom.document.body.appendChild(node)

    diff.render.DOM.RenderDom.render(node, nodeRef.css(false, "b"))
    assert(nodeRef.`class`.get.contains("a c"))
    assert(nodeRef.dom.className == "a c")

    dom.document.body.removeChild(node)
  }
}
