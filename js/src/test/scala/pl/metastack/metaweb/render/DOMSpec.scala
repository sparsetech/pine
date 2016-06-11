package pl.metastack.metaweb.render

import org.scalajs.dom
import org.scalatest.FunSuite
import pl.metastack.metaweb._

class DOMSpec extends FunSuite {
  /*
  test("Render node with one-way binding") {
    val title = Var("test")

    val span = html"""<div id="text"></div>"""
    span.setChildren(Seq(title))

    val html = span.toDom.map(_.outerHTML).mkString
    assert(html, """<div id="text">test</div>""")

    title := "test2"
    val html2 = span.toDom.map(_.outerHTML).mkString
    assert(html2, """<div id="text">test2</div>""")
  }

  test("Update `value` attribute of `input` node") {
    val input = html"""<input type="text" />"""
    val node = input.toDom.head.asInstanceOf[dom.html.Input]

    assert(node.value, "")
    input.setAttribute("value", "Hello world")

    assert(node.value, "Hello world")
  }

  test("Update `href` attribute of `a` node") {
    val input = html"""<a>Action</a>"""
    val node = input.toDom.head.asInstanceOf[dom.html.Anchor]

    assert(node.href, "")
    input.attribute("href") := "http://github.com/"

    assert(node.href, "http://github.com/")
  }

  test("Update `disabled` attribute of `input` node") {
    val input = html"""<input type="text" />"""
    val node = input.toDom.head.asInstanceOf[dom.html.Input]

    assert(node.disabled, false)
    input.attribute("disabled") := true

    assert(node.disabled, true)
  }

  test("Get updated `value` attribute of `input` node") {
    ignore("Detecting changes in externally modified DOM nodes")
    val input = html"""<input type="text" />"""
    val node = input.toDom.head.asInstanceOf[dom.html.Input]

    assert(input.attribute("value").get, ())

    node.value = "Hello world"
    assert(input.attribute("value").get, "Hello world")
  }

  test("Listen to attribute `value` on `input` node") {
    val input = html"""<input type="text" />"""
    val node = input.toDom.head.asInstanceOf[dom.html.Input]

    val value = Var("")
    input.attribute("value").asInstanceOf[StateChannel[String]].subscribe(value)

    assert(node.value, "")
    assert(input.attribute("value").get, "")

    value := "Hello world"
    assert(node.value, "Hello world")
    assert(input.attribute("value").get, "Hello world")
  }

  test("Listen to attribute `disabled` on `input` node") {
    val input = html"""<input type="text" />"""
    val node = input.toDom.head.asInstanceOf[dom.html.Input]

    val value = Var(false)
    input.attribute("disabled").asInstanceOf[StateChannel[Boolean]].subscribe(value)

    assert(node.disabled, false)

    value := true
    assert(node.disabled, true)

    value := false
    assert(node.disabled, false)
  }

  test("Call `focus` on `input` node") {
    val input = html"""<input type="text" />"""
    val node = input.toDom.head.asInstanceOf[dom.html.Input]

    var eventTriggered = 0
    input.setEvent("focus", (event: Any) => eventTriggered += 1)

    node.focus()  // Should not trigger event
    assert(eventTriggered, 0)

    input.triggerAction("focus")
    assert(eventTriggered, 1)
  }

  test("Listen to `onclick` on `button` node") {
    val input = html"""<button />"""
    val node = input.toDom.head.asInstanceOf[dom.html.Input]

    var eventTriggered = 0
    input.setEvent("click", (event: Any) => eventTriggered += 1)

    // TODO Support `new dom.Event("change")` in scala-js-dom
    val event = js.Dynamic.newInstance(js.Dynamic.global.Event)("click")
      .asInstanceOf[dom.raw.Event]
    node.dispatchEvent(event)

    assert(eventTriggered, 1)
  }

  test("Override event handler") {
    val input = html"""<button />"""
    val node = input.toDom.head.asInstanceOf[dom.html.Input]

    val eventTriggered = ListBuffer.empty[Int]
    input.setEvent("click", (event: Any) => eventTriggered += 23)
    input.setEvent("click", (event: Any) => eventTriggered += 42)

    val event = js.Dynamic.newInstance(js.Dynamic.global.Event)("click")
      .asInstanceOf[dom.raw.Event]
    node.dispatchEvent(event)

    assert(eventTriggered, Seq(42))
  }

  test("Listen to child channel on `span` node") {
    val span = html"""<span></span>"""
    val node = span.toDom.head

    val text = Var("Hello world")
    span.subscribe(text)

    assert(node.outerHTML, "<span>Hello world</span>")

    text := "42"
    assert(node.outerHTML, "<span>42</span>")
  }

  test("Render node with two-way binding") {
    val text = Var("")

    val input = html"""<input type="text" />"""
    input.attribute("value").bind(text.asInstanceOf[Channel[Any]])

    val domElement = input.toDom.head.asInstanceOf[dom.html.Input]
    domElement.value = "Hello World"

    assert(text.get, "")

    val event = js.Dynamic.newInstance(js.Dynamic.global.Event)("change")
      .asInstanceOf[dom.raw.Event]
    domElement.dispatchEvent(event)

    assert(text.get, "Hello World")

    text := "42"
    assert(domElement.value, "42")
  }

  test("Set `class` attribute on nodes") {
    val div = html"""<div id="a" class="b c"></div>"""
    val node = div.toDom.head

    assert(node.outerHTML, """<div class="b c" id="a"></div>""")
  }

  test("Set `style` attribute on nodes") {
    val div = html"""<div></div>"""
    val node = div.toDom.head

    div.attribute("style") := "display: none"

    assert(node.outerHTML, """<div style="display: none"></div>""")
  }

  test("Listen to text value changes") {
    val text = Var("Initial value")

    val div = html"""<div></div>"""
    div.setChildren(Seq(text))

    val node = div.toDom.head
    assert(node.outerHTML, """<div>Initial value</div>""")

    text := "Changed value"
    assert(node.outerHTML, """<div>Changed value</div>""")
  }

  test("Obtain `options` from `select` node") {
    ignore()
    val select = html"""<select id="type">
      <option value="opt1">Option 1</option>
      <option value="opt2" selected="true">Option 2</option>
    </select>"""

    val node = select.toDom

    val options = select.attribute("options").get.asInstanceOf[js.Dynamic]
    val selectedIndex = select.attribute("selectedIndex").get.asInstanceOf[Int]

    assert(options(selectedIndex).value, "opt2")
  }*/

  test("Convert DOM node") {
    val node = dom.document.createElement("span")
    node.setAttribute("id", "test")
    node.appendChild(dom.document.createTextNode("Hello world"))

    val s = DOM.toTree[tag.Span](node)
    assert(s.isInstanceOf[tag.Span])
    assert(s.children.size == 1)
    s.children.head match {
      case t: tree.Text => assert(t.text == "Hello world")
      case _ => fail()
    }
  }

  test("Convert DOM node (2)") {
    val node = dom.document.createElement("span")
    val node2 = dom.document.createTextNode("Hello world")
    node.appendChild(node2)

    val test = DOM.toTree[tag.Span](node)
    assert(test.children.nonEmpty, true)

    val text = test.children.head.asInstanceOf[tree.Text]
    assert(text.text == "Hello world")
  }

  test("Convert DOM node with Boolean attribute") {
    val node = dom.document.createElement("span")
    node.setAttribute("id", "test")

    val node2 = dom.document.createElement("input")
    node2.setAttribute("checked", "")
    node.appendChild(node2)

    val test = DOM.toTree[tag.Span](node)
    assert(test.id.get == "test")
    assert(test.children.nonEmpty, true)

    val input = test.children.head.asInstanceOf[tag.Input]
    assert(input.checked.get, true)

    assert(node.childNodes.length == 1)
    assert(node2.childNodes.length == 0)
  }

  /*
  test("Remove child from attached DOM node") {
    val node = dom.document.createElement("span")
    val node2 = dom.document.createTextNode("Hello world")
    node.appendChild(node2)

    val test = DOM.toTree[tag.Span](node)
    assert(test.toHtml == "<span>Hello world</span>")
    test -= test.children.head

    assert(node.outerHTML, "<span></span>")
  }

  test("Set attribute on attached DOM node") {
    val node = dom.document.createElement("span")
    val node2 = dom.document.createElement("div")
    node2.setAttribute("id", "node2")
    node2.setAttribute("class", "test")
    node.appendChild(node2)

    val test = DOM.toTree[tag.Span](node)
    test.byId[tag.Div]("node2").`class` := "changed"

    assert(node2.asInstanceOf[js.Dynamic].className, "changed")
  }*/
}
