package pl.metastack.metaweb

import scala.collection.mutable.ArrayBuffer

import pl.metastack.metarx.{Buffer, Var}

import minitest._

object InlineHtmlSpec extends SimpleTestSuite {
  test("toHtml on immutable tree") {
    val url = "http://github.com/"
    val title = "GitHub"
    val root = html"""<a href=$url>$title</a>"""

    assertEquals(root.toHtml, """<a href="http://github.com/">GitHub</a>""")

    root.setAttribute("href", "http://google.com/")
    assertEquals(root.getAttribute("href").get, "http://google.com/")
    assertEquals(root.toHtml, """<a href="http://google.com/">GitHub</a>""")

    root.clearChildren()
    assertEquals(root.toHtml, """<a href="http://google.com/"></a>""")
  }

  test("one-way binding tree") {
    val url = Var("http://github.com/")
    val title = Var("GitHub")

    val root = html1"""<a></a>"""
    root.subscribeAttribute("href", url)
    root.subscribeChildren(Buffer({
      val s = state.OneWay.text()
      s.listen(title)
      s
    }))

    assertEquals(root.toHtml, """<a href="http://github.com/">GitHub</a>""")

    url := "http://google.com/"
    assertEquals(root.getAttribute("href").get, "http://google.com/")
    assertEquals(root.toHtml, """<a href="http://google.com/">GitHub</a>""")

    root.clearChildren()
    assertEquals(root.toHtml, """<a href="http://google.com/"></a>""")
  }

  test("Listen to changes") {
    val url = Var("http://github.com/")
    val title = Var("GitHub")

    val root = html1"""<a></a>"""
    root.subscribeAttribute("href", url)
    root := {
      val s = state.OneWay.text()
      s.listen(title)
      s
    }

    val changes = ArrayBuffer.empty[String]

    root.watchAttributes.attach(_ => changes += root.toHtml)

    url := "http://google.com/"
    title := "Google"

    changes += root.toHtml

    assertEquals(changes, Seq(
      """<a href="http://github.com/">GitHub</a>""",
      """<a href="http://google.com/">GitHub</a>""",
      """<a href="http://google.com/">Google</a>"""
    ))
  }

  test("Bind list") {
    val list = html1"""<div id="list"></div>"""

    list.subscribeChildren(Buffer("a", "b", "c").map { i =>
      val title = s"Title $i"
      val subtitle = s"Subtitle $i"
      html"""<div><div>$title</div><div>$subtitle</div></div>"""
    })

    assertEquals(list.children.size, 3)
    assertEquals(list.children.last.toHtml,
      """<div><div>Title c</div><div>Subtitle c</div></div>""")
  }

  test("Inline event handler") {
    var clicked = 0
    val btn = html"""<button onclick="${(_: Any) => clicked += 1}">Test</button>"""

    btn.click()
    assertEquals(clicked, 1)
  }

  test("Function as event handler") {
    var clicked = 0
    def click(event: Any) { clicked += 1 }
    val btn = html"""<button onclick="${click(_: Any)}">Test</button>"""
    btn.click()
    assertEquals(clicked, 1)
  }

  test("String attribute placeholder") {
    val id = "test"
    val div = html"<div id=$id></div>"
    assertEquals(div.toHtml, """<div id="test"></div>""")
  }

  test("Option[String] attribute placeholder") {
    val id = Some("test")
    val div = html"<div id=$id></div>"
    assertEquals(div.toHtml, """<div id="test"></div>""")

    val id2 = None
    val div2 = html"<div id=$id2></div>"
    assertEquals(div2.toHtml, """<div></div>""")

    val id3 = Option.empty[String]
    val div3 = html"<div id=$id3></div>"
    assertEquals(div3.toHtml, """<div></div>""")
  }

  test("String placeholder") {
    val text = "Hello world"
    val div = html"<div>$text</div>"
    assertEquals(div.toHtml, "<div>Hello world</div>")
  }

  test("Node placeholder") {
    val span = htmlT"<span>test</span>"
    val div = html"<div>$span</div>"
    assertEquals(div.toHtml, "<div><span>test</span></div>")
  }

  test("Seq[Node] placeholders") {
    val spans = Seq(
      htmlT"<span>test</span>",
      htmlT"<span>test2</span>"
    )

    val div = html"<div>$spans</div>"
    assertEquals(div.toHtml, "<div><span>test</span><span>test2</span></div>")
  }

  test("Keep DOCTYPE") {
    val doctype = html"<!DOCTYPE html><html></html>"
    assertEquals(doctype.toHtml, """<!DOCTYPE html><html></html>""")
  }

  test("Escape strings") {
    val id = "a < b"
    val div = html"<div>$id</div>"
    assertEquals(div.toHtml, """<div>a &lt; b</div>""")
  }

  test("Escape attributes") {
    val id = "a\"b"
    val div = html"<div id=$id></div>"
    assertEquals(div.toHtml, """<div id="a&quot;b"></div>""")
  }

  test("Void element") {
    val div = html"<meta/>"
    assertEquals(div.toHtml, "<meta/>")
  }
}
