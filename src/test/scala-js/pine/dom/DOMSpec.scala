package pine.dom

import org.scalajs.dom
import org.scalatest.funsuite.AnyFunSuite
import pine._

import scala.collection.mutable.ListBuffer
import scala.scalajs.js

class DOMSpec extends AnyFunSuite {
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
  }*/

  test("Obtain `options` from `select` node") {
    val select = html"""<select id="type">
      <option value="opt1">Option 1</option>
      <option value="opt2" selected="true">Option 2</option>
    </select>""".as[tag.Select]

    val node = select.toDom
    assert(node.options(node.selectedIndex).value == "opt2")
  }

  test("Convert DOM node") {
    val node = dom.document.createElement("span")
    node.setAttribute("id", "test")
    node.appendChild(dom.document.createTextNode("Hello world"))

    val s = DOM.toTree(node).asInstanceOf[Tag[tag.Span]]
    assert(s.children.size == 1)
    s.children.head match {
      case t: Text => assert(t.text == "Hello world")
      case _ => fail()
    }
  }

  test("Convert DOM node (2)") {
    val node = dom.document.createElement("span")
    val node2 = dom.document.createTextNode("Hello world")
    node.appendChild(node2)

    val test = DOM.toTree(node).asInstanceOf[Tag[tag.Span]]
    assert(test.children.nonEmpty)

    val text = test.children.head.asInstanceOf[Text]
    assert(text.text == "Hello world")
  }

  test("Convert DOM node with Boolean attribute") {
    val node = dom.document.createElement("span")
    node.setAttribute("id", "test")

    val node2 = dom.document.createElement("input")
    node2.setAttribute("checked", "")
    node.appendChild(node2)

    val test = DOM.toTree(node).asInstanceOf[Tag[tag.Span]]
    assert(test.id() == "test")
    assert(test.children.nonEmpty)

    val input = test.children.head.asInstanceOf[Tag[tag.Input]]
    assert(input.checked())

    assert(node.childNodes.length == 1)
    assert(node2.childNodes.length == 0)
  }

  test("Replace first occurrence") {
    val div = html"""<div id="test"><span id="hello">Hello</span></div>""".toDom
    dom.document.body.appendChild(div)

    val ref = TagRef[tag.Span]
    DOM.render { implicit ctx =>
      ref.replace(html"<div>World</div>")
    }

    assert(
      DOM.toTree(dom.document.getElementById("test")).toHtml ==
      """<div id="test"><div>World</div></div>""")
    dom.document.body.removeChild(div)
  }

  test("Replace first occurrence with multiple children") {
    val div = html"""<div id="test"><span id="hello">Hello</span></div>""".toDom
    dom.document.body.appendChild(div)

    val ref = TagRef[tag.Span]
    DOM.render { implicit ctx =>
      ref.replace(List(html"<div>Hello</div>", html"<div>World</div>"))
    }

    assert(
      DOM.toTree(dom.document.getElementById("test")).toHtml ==
        """<div id="test"><div>Hello</div><div>World</div></div>""")
    dom.document.body.removeChild(div)
  }

  test("Replace all occurrences") {
    val div = html"""<div id="test"><span></span><span></span></div>""".toDom
    dom.document.body.appendChild(div)

    val ref = TagRef[tag.Span]
    DOM.render { implicit ctx =>
      ref.each.replace(html"<div>test</div>")
    }

    assert(
      DOM.toTree(dom.document.getElementById("test")).toHtml ==
        """<div id="test"><div>test</div><div>test</div></div>""")
    dom.document.body.removeChild(div)
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

  test("Find elements by class") {
    val div = html"""<div><span class="a test"></span><span class="b test"></span></div>""".as[tag.Div]
    val node = div.toDom
    dom.document.body.appendChild(node)

    val input = TagRef.byClass[tag.Span]("test").each
    assert(input.dom.isInstanceOf[List[dom.html.Span]])
    assert(input.dom.length == 2)

    DOM.render(implicit ctx => input.`class`.clear())
    assert(DOM.toTree(node).toHtml == "<div><span></span><span></span></div>")

    dom.document.body.removeChild(node)
  }

  test("Listen to `onfocus` on `input` node") {
    val input = html"""<input type="text" />""".as[tag.Input]
    val node = input.toDom
    dom.document.body.appendChild(node)

    var eventTriggered = 0
    TagRef[tag.Input].focus := { eventTriggered += 1 }

    node.focus()
    assert(eventTriggered == 1)

    dom.document.body.removeChild(node)
  }

  test("Resolve optional node") {
    val span = html"""<span></span>""".as[tag.Span]
    val node = span.toDom
    dom.document.body.appendChild(node)

    val ref = TagRef[tag.Span].opt
    assert(ref.dom.isInstanceOf[Option[_]])
    assert(ref.dom.contains(node))

    dom.document.body.removeChild(node)
  }

  test("Resolve optional node (2)") {
    val span = html"""<span></span>""".as[tag.Span]
    val node = span.toDom
    dom.document.body.appendChild(node)

    val ref = TagRef[tag.Input].opt
    assert(ref.dom.isInstanceOf[Option[_]])
    assert(ref.dom.isEmpty)

    dom.document.body.removeChild(node)
  }

  test("Listen to `onclick` on `input` nodes") {
    val div = html"""<div><input type="text" /><input type="test" /></div>""".as[tag.Div]
    val node = div.toDom
    dom.document.body.appendChild(node)

    val input = TagRef[tag.Input].each
    assert(input.dom.length == 2)

    var eventTriggered = 0
    input.click := { eventTriggered += 1 }

    input.dom.foreach(_.click())
    assert(eventTriggered == 2)

    dom.document.body.removeChild(node)
  }

  test("Listen to `onclick` on `button` node") {
    val input = html"""<button />""".as[tag.Button]
    val node = input.toDom
    dom.document.body.appendChild(node)

    var eventTriggered = 0
    TagRef[tag.Button].click := { eventTriggered += 1 }

    // TODO Support `new dom.Event("change")` in scala-js-dom
    val event = js.Dynamic.newInstance(js.Dynamic.global.Event)("click")
      .asInstanceOf[dom.raw.Event]
    node.dispatchEvent(event)

    assert(eventTriggered == 1)
    dom.document.body.removeChild(node)
  }

  test("Override event handler") {
    val input = html"""<button />""".as[tag.Button]
    val node = input.toDom
    dom.document.body.appendChild(node)

    val eventTriggered = ListBuffer.empty[Int]
    TagRef[tag.Button].click := { _ => eventTriggered += 23 }
    TagRef[tag.Button].click := { _ => eventTriggered += 42 }

    val event = js.Dynamic.newInstance(js.Dynamic.global.Event)("click")
      .asInstanceOf[dom.raw.Event]
    node.dispatchEvent(event)

    assert(eventTriggered == Seq(42))
    dom.document.body.removeChild(node)
  }

  test("Update `disabled` attribute of `input` node") {
    val input = html"""<input type="text" />""".as[tag.Input]
    val node = input.toDom
    dom.document.body.appendChild(node)

    assert(!node.disabled)
    DOM.render { implicit ctx =>
      TagRef[tag.Input].disabled := true
    }

    assert(node.disabled)
    dom.document.body.removeChild(node)
  }

  test("Render attributes in a namespace") {
    val node = tag.Div.setAttr("a:b:c", "test").toDom
    assert(node.getAttribute("a:b:c") == "test")
    assert(node.getAttributeNS("a:b", "c") == null)
  }

  test("Render SVG node") {
    val input =
      xml"""
        <svg viewBox="0 0 300 100" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" class="test">
          <circle pn:id="circle" a:b:c="test" cx="50" cy="50" r="40" fill="blue" />
        </svg>
      """.as[tag.Svg]
    val node = input.toDom

    assert(node.getAttribute("xmlns") == "http://www.w3.org/2000/svg")
    assert(node.getAttribute("xmlns:xlink") == "http://www.w3.org/1999/xlink")

    assert(node.getAttributeNS("xmlns", "xlink") == null)

    // TODO These two assertions were commented out because jsdom's behaviour
    //      diverges from Chromium's
    // assert(node.getAttributeNS(null, "xmlns") == null)
    // assert(node.getAttributeNS(null, "xmlns:xlink") == null)

    assert(node.getAttribute("class") == "test")
    assert(node.getAttributeNS(null, "class") == "test")
    assert(node.getAttributeNS(null, "viewBox") == "0 0 300 100")

    assert(node
      .getElementsByTagNameNS(null, "circle")
      .length == 0)

    val circle = node
      .getElementsByTagNameNS("http://www.w3.org/2000/svg", "circle")
      .item(0)

    assert(circle.getAttributeNS(null, "cx") == "50")
    assert(circle.getAttribute("pn:id") == "circle")
    assert(circle.getAttributeNS("pn", "id") == null)
    assert(circle.getAttribute("a:b:c") == "test")
    assert(circle.getAttributeNS("a:b", "c") == null)
  }
}
