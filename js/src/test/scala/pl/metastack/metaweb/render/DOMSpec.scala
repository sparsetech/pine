package pl.metastack.metaweb.render

import minitest._

import pl.metastack.metarx.Var

import pl.metastack.metaweb._

object DOMSpec extends SimpleTestSuite
  with PlatformSupport {  // For IntelliJ
  test("Render node") {
    val title = Var("test")

    val span = html1"""<div id="text"></div>"""
    span.setChildren(Seq(title))

    val html = span.toDom.map(_.outerHTML).mkString
    assertEquals(html, """<div id="text"><span>test</span></div>""")

    title := "test2"
    val html2 = span.toDom.map(_.outerHTML).mkString
    assertEquals(html2, """<div id="text"><span>test2</span></div>""")
  }

  // TODO Simulate events, see http://stackoverflow.com/a/17469212
}
