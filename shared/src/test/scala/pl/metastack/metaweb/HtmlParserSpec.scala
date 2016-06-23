package pl.metastack.metaweb

import org.scalatest.FunSuite

class HtmlParserSpec extends FunSuite {
  test("Parse HTML") {
    val html = """<div id="a"><span>42</span></div>"""
    val node = HtmlParser.fromString(html)
    assert(node.toHtml == html)
  }

  test("Resolve node") {
    val html = """<div id="a"><b>test</b><span id="b"></span></div>"""
    val div = HtmlParser.fromString(html).asInstanceOf[tag.Div]
    assert(div.byId[tag.Span]("b") == html"""<span id="b"></span>""")
  }

  test("Don't ignore DOCTYPE") {
    val html = """<!DOCTYPE html><html><head lang="en"></head><body><span>42</span></body></html>"""
    val node = HtmlParser.fromString(html)
    assert(node.toHtml == html)
  }
}