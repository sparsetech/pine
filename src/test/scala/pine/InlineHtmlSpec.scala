package pine

import org.scalatest.funsuite.AnyFunSuite

class InlineHtmlSpec extends AnyFunSuite {
  test("toHtml on immutable tree") {
    val url = "http://github.com/"
    val title = "GitHub"
    val root = html"""<a href=$url>$title</a>"""

    assert(root.toHtml == """<a href="http://github.com/">GitHub</a>""")

    val updated = root.setAttr("href", "http://google.com/")
    assert(updated.attr("href").get == "http://google.com/")
    assert(updated.toHtml == """<a href="http://google.com/">GitHub</a>""")

    val updated2 = updated.clearAll
    assert(updated2.toHtml == """<a href="http://google.com/"></a>""")
  }

  test("Look up by ID") {
    val root = html"""<div></div>"""
    val appended = root ++ List(
      html"""<div id="a"></div>""",
      html"""<div id="b"></div>""")

    assert(appended.byIdOpt("b").nonEmpty)
  }

  test("String attribute placeholder") {
    val id = "test"
    val div = html"<div id=$id></div>"
    assert(div.toHtml == """<div id="test"></div>""")
  }

  test("String (type alias) attribute placeholder") {
    type Str = String
    val id: Str = "test"
    val div = html"<div id=$id></div>"
    assert(div.toHtml == """<div id="test"></div>""")
  }

  test("Option[String] attribute placeholder") {
    val id = Some("test")
    val div = html"<div id=$id></div>"
    assert(div.toHtml == """<div id="test"></div>""")

    val id2 = None
    val div2 = html"<div id=$id2></div>"
    assert(div2.toHtml == """<div></div>""")

    val id3 = Option.empty[String]
    val div3 = html"<div id=$id3></div>"
    assert(div3.toHtml == """<div></div>""")

    assertDoesNotCompile {
      """
      val id4 = Option.empty[Int]
      val div4 = html"<div id=$id4></div>"
      """
    }
  }

  test("Concatenated string attribute placeholder (suffix)") {
    val id   = "test"
    val node = html"""<ol id="$id-item"></ol>"""
    assert(node.toHtml == """<ol id="test-item"></ol>""")
  }

  test("Concatenated string attribute placeholder (prefix)") {
    val id   = "test"
    val node = html"""<ol id="item-$id"></ol>"""
    assert(node.toHtml == """<ol id="item-test"></ol>""")
  }

  test("Concatenated string attribute placeholder (infix)") {
    val id   = "test"
    val id2  = "test2"
    val node = html"""<ol id="$id-$id2"></ol>"""
    assert(node.toHtml == """<ol id="test-test2"></ol>""")
  }

  test("String content placeholder") {
    val text = "Hello world"
    val div = html"<div>$text</div>"
    assert(div.toHtml == "<div>Hello world</div>")
  }

  test("String (type alias) content placeholder") {
    type Str = String
    val text: Str = "Hello world"
    val div = html"<div>$text</div>"
    assert(div.toHtml == "<div>Hello world</div>")
  }

  test("Integer content placeholder") {
    val text = 42
    val div = html"<div>$text</div>"
    assert(div.toHtml == "<div>42</div>")
  }

  test("Boolean content placeholder") {
    val text = true
    val div = html"<div>$text</div>"
    assert(div.toHtml == "<div>true</div>")
  }

  test("Node content placeholder") {
    val span = html"<span>test</span>"
    val div = html"<div>$span</div>"
    assert(div.toHtml == "<div><span>test</span></div>")
  }

  test("List[Node] content placeholders") {
    val spans = List(
      html"<span>test</span>",
      html"<span>test2</span>"
    )

    val div = html"<div>$spans</div>"
    assert(div.toHtml == "<div><span>test</span><span>test2</span></div>")
  }

  test("List[Node] content placeholders (2)") {
    val children = List(Text("hello"))
    assert(html"<a>$children</a>" == tag.A.set("hello"))
  }

  test("Keep DOCTYPE") {
    val doctype = html"<!DOCTYPE html><html></html>"
    assert(doctype.toHtml == """<!DOCTYPE html><html></html>""")
  }

  test("Escape strings") {
    val id = "a < b"
    val div = html"<div>$id</div>"
    assert(div.toHtml == """<div>a &lt; b</div>""")
  }

  test("Escape attributes") {
    val id = "a\"b"
    val div = html"<div id=$id></div>"
    assert(div.toHtml == """<div id="a&quot;b"></div>""")
  }

  test("Void element") {
    val div = html"<meta/>"
    assert(div.toHtml == "<meta/>")
  }

  test("XML parsing") {
    val xml =
      xml"""<?xml version="1.0" encoding="UTF-8"?><rss version="2.0" xmlns:atom="http://www.w3.org/2005/Atom" xmlns:dc="http://purl.org/dc/elements/1.1/"><channel><atom:link type="application/rss+xml" /></channel></rss>"""

    assert(xml.attributes == Predef.Map(
      "version" -> "2.0",
      "xmlns:atom" -> "http://www.w3.org/2005/Atom",
      "xmlns:dc" -> "http://purl.org/dc/elements/1.1/"
    ))

    val atomLink = xml
      .children.head.asInstanceOf[Tag[_]]
      .children.head.asInstanceOf[Tag[_]]
    assert(atomLink.tagName == "atom:link")
  }

  test("Resolve node") {
    val div = html"""<div id="a"><b>test</b><span id="b"></span></div>"""
    val resolved = div.byId("b")
    assert(resolved == html"""<span id="b"></span>""")
  }

  test("Resolve node (2)") {
    val div = html"""
      <!DOCTYPE html>
      <html>
      <head>
        <meta charset="utf-8"/>
        <title>Example</title>
      </head>
      <body>
        <div id="page">
          <h1>Index</h1>
          <button id="guess">Number guess</button>
          <button id="books">Book listing</button>
        </div>
      </body>
      </html>
    """
    assert(div.byIdOpt("page").nonEmpty)
  }

  test("Getting value of Boolean attributes") {
    val input = html"""<input type="checkbox" />""".as["input"]
    assert(!input.checked())

    val input2 = html"""<input type="checkbox" checked="" />""".as["input"]
    assert(input2.checked())
  }

  test("Setting value of Boolean attributes") {
    val input = html"""<input type="checkbox" />""".as["input"]
    val input2 = input.checked(true)
    assert(input2.checked())
    assert(input2.toHtml == """<input type="checkbox" checked=""/>""")
    assert(input == input2.checked(false))
  }
}
