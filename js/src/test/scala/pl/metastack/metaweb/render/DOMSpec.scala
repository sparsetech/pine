package pl.metastack.metaweb.render

import scala.scalajs.js

import org.scalajs.dom

import minitest._

import pl.metastack.metarx.{StateChannel, Channel, Var}

import pl.metastack.metaweb._

object DOMSpec extends SimpleTestSuite
  with PlatformSupport {  // For IntelliJ
  test("Render node with one-way binding") {
    val title = Var("test")

    val span = htmlR"""<div id="text"></div>"""
    span.setChildren(Seq(title))

    val html = span.toDom.map(_.outerHTML).mkString
    assertEquals(html, """<div id="text">test</div>""")

    title := "test2"
    val html2 = span.toDom.map(_.outerHTML).mkString
    assertEquals(html2, """<div id="text">test2</div>""")
  }

  test("Update `value` attribute of `input` node") {
    val input = htmlR"""<input type="text" />"""
    val node = input.toDom.head.asInstanceOf[dom.html.Input]

    assertEquals(node.value, "")
    input.setAttribute("value", "Hello world")

    assertEquals(node.value, "Hello world")
  }

  test("Update `href` attribute of `a` node") {
    val input = htmlR"""<a>Action</a>"""
    val node = input.toDom.head.asInstanceOf[dom.html.Anchor]

    assertEquals(node.href, "")
    input.attribute("href") := "http://github.com/"

    assertEquals(node.href, "http://github.com/")
  }

  test("Update `disabled` attribute of `input` node") {
    val input = htmlR"""<input type="text" />"""
    val node = input.toDom.head.asInstanceOf[dom.html.Input]

    assertEquals(node.disabled, false)
    input.attribute("disabled") := true

    assertEquals(node.disabled, true)
  }

  test("Get updated `value` attribute of `input` node") {
    ignore("Detecting changes in externally modified DOM nodes")
    val input = htmlR"""<input type="text" />"""
    val node = input.toDom.head.asInstanceOf[dom.html.Input]

    assertEquals(input.attribute("value").get, ())

    node.value = "Hello world"
    assertEquals(input.attribute("value").get, "Hello world")
  }

  test("Listen to attribute `value` on `input` node") {
    val input = htmlR"""<input type="text" />"""
    val node = input.toDom.head.asInstanceOf[dom.html.Input]

    val value = Var("")
    input.attribute("value").asInstanceOf[StateChannel[String]].subscribe(value)

    assertEquals(node.value, "")
    assertEquals(input.attribute("value").get, "")

    value := "Hello world"
    assertEquals(node.value, "Hello world")
    assertEquals(input.attribute("value").get, "Hello world")
  }

  test("Listen to attribute `disabled` on `input` node") {
    val input = htmlR"""<input type="text" />"""
    val node = input.toDom.head.asInstanceOf[dom.html.Input]

    val value = Var(false)
    input.attribute("disabled").asInstanceOf[StateChannel[Boolean]].subscribe(value)

    assertEquals(node.disabled, false)

    value := true
    assertEquals(node.disabled, true)

    value := false
    assertEquals(node.disabled, false)
  }

  test("Call `focus` on `input` node") {
    val input = htmlR"""<input type="text" />"""
    val node = input.toDom.head.asInstanceOf[dom.html.Input]

    var eventTriggered = 0
    input.setEvent("focus", (event: Any) => eventTriggered += 1)

    node.focus()  // Should not trigger event
    assertEquals(eventTriggered, 0)

    input.triggerAction("focus")
    assertEquals(eventTriggered, 1)
  }

  test("Listen to `onclick` on `button` node") {
    val input = htmlR"""<button />"""
    val node = input.toDom.head.asInstanceOf[dom.html.Input]

    var eventTriggered = 0
    input.setEvent("click", (event: Any) => eventTriggered += 1)

    // TODO Support `new dom.Event("change")` in scala-js-dom
    val event = js.Dynamic.newInstance(js.Dynamic.global.Event)("click")
      .asInstanceOf[dom.raw.Event]
    node.dispatchEvent(event)

    assertEquals(eventTriggered, 1)
  }

  test("Listen to child channel on `span` node") {
    val span = htmlR"""<span></span>"""
    val node = span.toDom.head

    val text = Var("Hello world")
    span.subscribe(text)

    assertEquals(node.outerHTML, "<span>Hello world</span>")

    text := "42"
    assertEquals(node.outerHTML, "<span>42</span>")
  }

  test("Render node with two-way binding") {
    val text = Var("")

    val input = htmlR"""<input type="text" />"""
    input.attribute("value").bind(text.asInstanceOf[Channel[Any]])

    val domElement = input.toDom.head.asInstanceOf[dom.html.Input]
    domElement.value = "Hello World"

    assertEquals(text.get, "")

    val event = js.Dynamic.newInstance(js.Dynamic.global.Event)("change")
      .asInstanceOf[dom.raw.Event]
    domElement.dispatchEvent(event)

    assertEquals(text.get, "Hello World")

    text := "42"
    assertEquals(domElement.value, "42")
  }

  test("Set `class` attribute on nodes") {
    val div = htmlR"""<div id="a" class="b c"></div>"""
    val node = div.toDom.head

    assertEquals(node.outerHTML, """<div class="b c" id="a"></div>""")
  }

  test("Set `style` attribute on nodes") {
    val div = htmlR"""<div></div>"""
    val node = div.toDom.head

    div.attribute("style") := "display: none"

    assertEquals(node.outerHTML, """<div style="display: none"></div>""")
  }

  test("Listen to text value changes") {
    val text = Var("Initial value")

    val div = htmlR"""<div></div>"""
    div.setChildren(Seq(text))

    val node = div.toDom.head
    assertEquals(node.outerHTML, """<div>Initial value</div>""")

    text := "Changed value"
    assertEquals(node.outerHTML, """<div>Changed value</div>""")
  }

  test("Obtain `options` from `select` node") {
    ignore()
    val select = htmlR"""<select id="type">
      <option value="opt1">Option 1</option>
      <option value="opt2" selected="true">Option 2</option>
    </select>"""

    val node = select.toDom

    val options = select.attribute("options").get.asInstanceOf[js.Dynamic]
    val selectedIndex = select.attribute("selectedIndex").get.asInstanceOf[Int]

    assertEquals(options(selectedIndex).value, "opt2")
  }
}
