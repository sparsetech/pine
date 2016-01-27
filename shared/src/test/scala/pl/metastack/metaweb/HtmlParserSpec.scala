package pl.metastack.metaweb

import minitest._

object HtmlParserSpec extends SimpleTestSuite {
  test("Parse HTML") {
    val html = """<div id="a"><span>42</span></div>"""
    val node = HtmlParser.fromString(html)
    assertEquals(node.toHtml, html)
  }
}
