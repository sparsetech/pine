package pine

import org.scalatest.FunSuite

class HtmlParserSpec extends FunSuite {
  test("Empty text node") {
    val node = Text("")
    assert(HtmlParser.fromString(node.toHtml) == node)
  }

  test("Parse text") {
    val text = "Hello world"
    val node = HtmlParser.fromString(text)
    assert(node == Text(text))
  }

  test("Parse text (2)") {
    val node = Text("'\"")
    assert(HtmlParser.fromString(node.toHtml) == node)
  }

  test("Parse attributes") {
    val node = tag.Span.setAttr("ä-ö_ü", "äöü")
    assert(HtmlParser.fromString(node.toHtml) == node)
  }

  test("Parse HTML node") {
    val node = tag.Html.set(List(tag.Head, tag.Body))
    assert(HtmlParser.fromString(node.toHtml) == node)
  }

  test("Parse head node") {
    val node = tag.Head
    assert(HtmlParser.fromString(node.toHtml) == node)
  }

  test("Parse title node") {
    val node = tag.Title
    assert(HtmlParser.fromString(node.toHtml) == node)
  }

  test("Parse meta node") {
    val node = tag.Meta
    assert(HtmlParser.fromString(node.toHtml) == node)
  }

  test("Parse link node") {
    val node = tag.Link
    assert(HtmlParser.fromString(node.toHtml) == node)
  }

  test("Parse body node") {
    val node = tag.Body
    assert(HtmlParser.fromString(node.toHtml) == node)
  }

  test("Parse text with entities") {
    val html = "&lpar;Hello world&rpar;"
    val node = HtmlParser.fromString(html)
    assert(node == Text("(Hello world)"))
  }

  test("Parse text with entities (2)") {
    val html = "&grave;&DiacriticalGrave;&#x00060;&#96;"
    val node = HtmlParser.fromString(html)
    assert(node == Text("````"))
  }

  test("Parse text with hex entities") {
    val html = "Hello world&#33;"
    val node = HtmlParser.fromString(html)
    assert(node == Text("Hello world!"))
  }

  test("Parse invalid entities") {
    val text = "&;"
    val node = HtmlParser.fromString(text)
    assert(node == Text(text))
  }

  test("Parse simple tag") {
    val html = "<br/>"
    val node = HtmlParser.fromString(html)
    assert(node == tag.Br)
  }

  test("Parse tag") {
    val html = """<a href="http://google.com/">Google</a>"""
    val node = HtmlParser.fromString(html)
    assert(node == (tag.A.href("http://google.com/") :+ Text("Google")))
  }

  test("Parse HTML") {
    val html = """<div id="a"><span>42</span></div>"""
    val node = HtmlParser.fromString(html)
    assert(node.toHtml == html)
  }

  test("Decode arguments") {
    val html = """<a href="a&amp;b"></a>"""
    val node = HtmlParser.fromString(html)
    assert(node == tag.A.href("a&b"))
  }

  test("Parse node with boolean attribute") {
    val html = """<input type="checkbox" checked/>"""
    val htmlParsed = """<input type="checkbox" checked="checked"/>"""
    val node = HtmlParser.fromString(html)
    assert(node.toHtml == htmlParsed)
  }

  test("Parse node with custom data attribute") {
    val html = """<input type="checkbox" data-key="value" data-key2/>"""
    val htmlParsed = """<input type="checkbox" data-key="value" data-key2=""/>"""
    val node = HtmlParser.fromString(html)
    assert(node.toHtml == htmlParsed)
  }

  test("Ignore comments") {
    val html = """<div>test <!-- Ignore -->!</div>"""
    val node = HtmlParser.fromString(html)
    assert(node == (tag.Div :+ Text("test ") :+ Text("!")))
  }

  test("Ignore comments (2)") {
    val html = """<div>test <!-- <br/> -->!</div>"""
    val node = HtmlParser.fromString(html)
    assert(node == (tag.Div :+ Text("test ") :+ Text("!")))
  }

  test("Resolve node") {
    val html = """<div id="a"><b>test</b><span id="b"></span></div>"""
    val div = HtmlParser.fromString(html).asInstanceOf[Tag[_]].byId("b")
    assert(div == html"""<span id="b"></span>""")
  }

  test("Parse DOCTYPE") {
    val html = """<!DOCTYPE html><html><head lang="en"></head><body><span>42</span></body></html>"""
    val node = HtmlParser.fromString(html)
    assert(node.toHtml == html)
  }

  test("Parse script nodes") {
    val html = """<script>i < len</script>"""
    val node = HtmlParser.fromString(html)
    assert(node.toHtml == html)
  }
}