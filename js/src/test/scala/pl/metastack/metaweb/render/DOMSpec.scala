package pl.metastack.metaweb.render

import scala.scalajs.js

import org.scalajs.dom

import minitest._

import pl.metastack.metarx.{Channel, Var}

import pl.metastack.metaweb._

object DOMSpec extends SimpleTestSuite
  with PlatformSupport {  // For IntelliJ
  test("Render node with one-way binding") {
    val title = Var("test")

    val span = html1"""<div id="text"></div>"""
    span.setChildren(Seq(title))

    val html = span.toDom.map(_.outerHTML).mkString
    assertEquals(html, """<div id="text"><span>test</span></div>""")

    title := "test2"
    val html2 = span.toDom.map(_.outerHTML).mkString
    assertEquals(html2, """<div id="text"><span>test2</span></div>""")
  }

  test("Update `value` attribute of `input` node") {
    val input = html1"""<input type="text" />"""
    val node = input.toDom.head.asInstanceOf[dom.html.Input]

    assertEquals(node.value, "")
    input.setAttribute("value", "Hello world")

    assertEquals(node.value, "Hello world")
  }

  test("Update `href` attribute of `a` node") {
    val input = html1"""<a>Action</a>"""
    val node = input.toDom.head.asInstanceOf[dom.html.Anchor]

    assertEquals(node.href, "")
    input.setAttribute("href", "http://github.com/")

    assertEquals(node.href, "http://github.com/")
  }

  test("Update `disabled` attribute of `input` node") {
    val input = html1"""<input type="text" />"""
    val node = input.toDom.head.asInstanceOf[dom.html.Input]

    assertEquals(node.disabled, false)
    input.setAttribute("disabled", true)

    assertEquals(node.disabled, true)
  }

  test("Get updated `value` attribute of `input` node") {
    val input = html1"""<input type="text" />"""
    val node = input.toDom.head.asInstanceOf[dom.html.Input]

    assertEquals(input.getAttribute("value").get, "")

    node.value = "Hello world"
    assertEquals(input.getAttribute("value").get, "Hello world")
  }

  test("Listen to attribute `value` on `input` node") {
    val input = html1"""<input type="text" />"""
    val node = input.toDom.head.asInstanceOf[dom.html.Input]

    val value = Var("")
    input.subscribeAttribute("value", value)

    assertEquals(node.value, "")
    assertEquals(input.getAttribute("value").get, "")

    value := "Hello world"
    assertEquals(node.value, "Hello world")
    assertEquals(input.getAttribute("value").get, "Hello world")
  }

  test("Listen to attribute `disabled` on `input` node") {
    val input = html1"""<input type="text" />"""
    val node = input.toDom.head.asInstanceOf[dom.html.Input]

    val value = Var(false)
    input.subscribeAttribute("disabled", value)

    assertEquals(node.disabled, false)

    value := true
    assertEquals(node.disabled, true)

    value := false
    assertEquals(node.disabled, false)
  }

  test("Call `focus` on `input` node") {
    val input = html1"""<input type="text" />"""
    val node = input.toDom.head.asInstanceOf[dom.html.Input]

    var eventTriggered = 0
    input.setEvent("focus", (event: Any) => eventTriggered += 1)

    node.focus()  // Should not trigger event
    assertEquals(eventTriggered, 0)

    input.triggerAction("focus")
    assertEquals(eventTriggered, 1)
  }

  test("Listen to `onclick` on `button` node") {
    val input = html1"""<button />"""
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
    val span = html1"""<span></span>"""
    val node = span.toDom.head

    val text = Var("Hello world")
    span.subscribe(text)

    assertEquals(node.outerHTML, "<span>Hello world</span>")

    text := "42"
    assertEquals(node.outerHTML, "<span>42</span>")
  }

  test("Render node with two-way binding") {
    val text = Var("")

    val input = html2"""<input type="text" />"""
    input.bindAttribute("value", text.asInstanceOf[Channel[Any]])

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
    val div = html1"""<div id="a" class="b c"></div>"""
    val node = div.toDom.head

    assertEquals(node.outerHTML, """<div class="b c" id="a"></div>""")
  }
}
