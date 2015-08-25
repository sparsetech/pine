package pl.metastack.metaweb

import scala.collection.mutable.ArrayBuffer

import pl.metastack.metarx.{Buffer, Var}

import minitest._

object InlineHtmlSpec extends SimpleTestSuite {
  test("toHtml on immutable tree") {
    val url = "http://github.com/"
    val title = "GitHub"
    val parsedHtml = html"""<a href=$url>$title</a>"""

    // translates into:
    // val root = tag.a()
    // root.setAttribute("href", url)
    // root += Text(title)

    parsedHtml match {
      case root: tag.a =>
        assertEquals(root.toHtml, """<a href="http://github.com/">GitHub</a>""")

        root.href("http://google.com/")
        assertEquals(root.href.get, "http://google.com/")
        assertEquals(root.toHtml, """<a href="http://google.com/">GitHub</a>""")

        root.clearChildren()
        assertEquals(root.toHtml, """<a href="http://google.com/"></a>""")
    }
  }

  test("toHtml on mutable tree") {
    val url = Var("http://github.com/")
    val title = Var("GitHub")
    val parsedHtml = htmlMutable"""<a href=$url>$title</a>"""

    // translates into:
    // val root = tag.a()
    // root.bindAttribute("href", url)
    // root += Text(title)

    parsedHtml match {
      case root: tag.a =>
        assertEquals(root.toHtml, """<a href="http://github.com/">GitHub</a>""")

        url := "http://google.com/"
        assertEquals(root.href.get, "http://google.com/")
        assertEquals(root.toHtml, """<a href="http://google.com/">GitHub</a>""")

        root.clearChildren()
        assertEquals(root.toHtml, """<a href="http://google.com/"></a>""")
    }
  }

  test("toHtmlLive") {
    val url = Var("http://github.com/")
    val title = Var("GitHub")
    val parsedHtml = htmlMutable"""<a href=$url>$title</a>"""

    parsedHtml match {
      case root: tag.mutable.a =>
        val changes = ArrayBuffer.empty[String]

        root.toHtmlLive.attach(changes += _)

        title := "Google"
        url := "http://google.com/"

        assertEquals(changes, Seq(
          """<a href="http://github.com/">GitHub</a>""",
          """<a href="http://github.com/">Google</a>""",
          """<a href="http://google.com/">Google</a>"""
        ))
    }
  }

  test("Bind list") {
    val tpl = htmlMutable"""<div id="list"></div>"""

    tpl match {
      case list: tag.mutable.div =>
        list.bindChildrenBuffer(Buffer("a", "b", "c").map { i =>
          val title = Var(s"Title $i")
          val subtitle = Var(s"Subtitle $i")
          htmlMutable"""<div><div>$title</div><div>$subtitle</div></div>"""
        })

        assertEquals(list.contents.get.size, 3)
        assertEquals(list.contents.get.last.toHtml,
          """<div><div>Title c</div><div>Subtitle c</div></div>""")
    }
  }

  // TODO Generate in MDNParser for all events and tags
  implicit class ButtonWithClick(button: tag.mutable.button) {
    def click() {
      button.events.get("click").foreach(_(()))
    }
  }

  test("Inline event handler") {
    var clicked = 0
    val tpl = htmlMutable"""<button onclick="${(_: Any) => clicked += 1}">Test</button>"""

    tpl match {
      case btn: tag.mutable.button =>
        btn.click()
        btn.disabled(true)
        assertEquals(clicked, 1)
    }
  }

  test("Function as event handler") {
    var clicked = 0
    def click(event: Any) { clicked += 1 }
    val tpl = htmlMutable"""<button onclick="${click(_: Any)}">Test</button>"""

    tpl match {
      case btn: tag.mutable.button =>
        btn.click()
        assertEquals(clicked, 1)
    }
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
    val span = html"<span>test</span>"
    val div = html"<div>$span</div>"
    assertEquals(div.toHtml, "<div><span>test</span></div>")
  }

  test("Seq[Node] placeholders") {
    val spans = Seq(
      html"<span>test</span>",
      html"<span>test2</span>"
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
