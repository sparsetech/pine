package pl.metastack.metaweb

import pl.metastack.metarx.Var
import pl.metastack.metaweb.TemplateMacro._

import minitest._

object ExternalHtmlSpec extends SimpleTestSuite {
  test("Load template") {
    val tpl = Template("test/test.html")

    assertEquals(tpl.nodes.map(_.toHtml),
      Seq(
        "<b>Hello World</b>", "\n",
        """<div id="div1">Div 1 contents</div>""", "\n",
        """<div id="div2">Div 2 contents</div>""", "\n"
      )
    )
  }

  test("Replace nodes") {
    val tpl = Template("test/test2.html")

    val div2 = tpl.byId[tag.div]("div2")
    assertEquals(div2.toHtml, """<div id="div2">Div 2 contents</div>""")

    div2 := Text(Var("42"))
    assertEquals(div2.toHtml, """<div id="div2">42</div>""")
  }
}
