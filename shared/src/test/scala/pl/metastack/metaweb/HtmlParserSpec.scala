package pl.metastack.metaweb

import org.scalatest.FunSuite

class HtmlParserSpec extends FunSuite {
  test("Empty text node") {
    val node = tree.Text("")
    assert(HtmlParser.fromString(node.toHtml) == node)
  }

  test("Parse text") {
    val text = "Hello world"
    val node = HtmlParser.fromString(text)
    assert(node == tree.Text(text))
  }

  test("Parse text (2)") {
    val node = tree.Text("'\"")
    assert(HtmlParser.fromString(node.toHtml) == node)
  }

  test("Parse attributes") {
    val node = tag.Span(Predef.Map("ä-ö_ü" -> "äöü"))
    assert(HtmlParser.fromString(node.toHtml) == node)
  }

  test("Parse text with entities") {
    val html = "&lpar;Hello world&rpar;"
    val node = HtmlParser.fromString(html)
    assert(node == tree.Text("(Hello world)"))
  }

  test("Parse text with entities (2)") {
    val html = "&grave;&DiacriticalGrave;&#x00060;&#96;"
    val node = HtmlParser.fromString(html)
    assert(node == tree.Text("````"))
  }

  test("Parse text with hex entities") {
    val html = "Hello world&#33;"
    val node = HtmlParser.fromString(html)
    assert(node == tree.Text("Hello world!"))
  }

  test("Parse invalid entities") {
    val text = "&;"
    val node = HtmlParser.fromString(text)
    assert(node == tree.Text(text))
  }

  test("Parse simple tag") {
    val html = "<br/>"
    val node = HtmlParser.fromString(html)
    assert(node == tag.Br())
  }

  test("Parse tag") {
    val html = """<a href="http://google.com/">Google</a>"""
    val node = HtmlParser.fromString(html)
    assert(node == (tag.A().href("http://google.com/") :+ tree.Text("Google")))
  }

  test("Parse HTML") {
    val html = """<div id="a"><span>42</span></div>"""
    val node = HtmlParser.fromString(html)
    assert(node.toHtml == html)
  }

  test("Decode arguments") {
    val html = """<a href="a&amp;b"></a>"""
    val node = HtmlParser.fromString(html)
    assert(node == tag.A().href("a&b"))
  }

  test("Ignore comments") {
    val html = """<div>test <!-- Ignore -->!</div>"""
    val node = HtmlParser.fromString(html)
    assert(node == (tag.Div() :+ tree.Text("test ") :+ tree.Text("!")))
  }

  test("Resolve node") {
    val html = """<div id="a"><b>test</b><span id="b"></span></div>"""
    val div = HtmlParser.fromString(html).asInstanceOf[tag.Div]
    assert(div.byId[tag.Span]("b") == html"""<span id="b"></span>""")
  }

  test("Parse DOCTYPE") {
    val html = """<!DOCTYPE html><html><head lang="en"></head><body><span>42</span></body></html>"""
    val node = HtmlParser.fromString(html)
    assert(node.toHtml == html)
  }
}