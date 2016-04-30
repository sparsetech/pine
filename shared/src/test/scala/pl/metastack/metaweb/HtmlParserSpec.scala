package pl.metastack.metaweb

import minitest._

object HtmlParserSpec extends SimpleTestSuite {
  test("Parse HTML") {
    val html = """<div id="a"><span>42</span></div>"""
    val node = HtmlParser.fromString(html)
    assertEquals(node.toHtml, html)
  }

  test("Don't ignore DOCTYPE") {
    val html = """<!DOCTYPE html><html><head lang="en"></head><body><span>42</span></body></html>"""
    val node = HtmlParser.fromString(html)
    assertEquals(node.toHtml, html)
  }
}