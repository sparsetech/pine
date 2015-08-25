package pl.metastack.metaweb

import pl.metastack.metarx.{Buffer, Var}

import minitest._
import pl.metastack.metaweb.tree.reactive.Text

object ExternalHtmlSpec extends SimpleTestSuite {
  test("Load template") {
    val tpl = html("shared/src/test/html/test.html")

    assertEquals(tpl.toHtml,
    """<!DOCTYPE html><html>
<body>
	<b>Hello World</b>
	<div id="div1">Div 1 contents</div>
	<div id="div2">Div 2 contents</div>
</body>
</html>"""
    )
  }

  test("Replace nodes") {
    val tpl = html("shared/src/test/html/test2.html")

    val div2 = tpl.byId[tag.div]("div2")
    assertEquals(div2.toHtml, """<div id="div2">Div 2 contents</div>""")

    div2 := Text(Var("42"))
    assertEquals(div2.toHtml, """<div id="div2">42</div>""")
  }

  test("Bind list item from template") {
    val tpl = html("shared/src/test/html/list.html")

    val list = tpl.byId[tag.div]("list")
    val listItem = tpl.byId[tag.div]("list-item")

    list.bindChildren(
      Buffer("a", "b", "c").map { i =>
        val title = Var(s"Title $i")
        val subtitle = Var(s"Subtitle $i")

        listItem.instantiate(
          "list-item-title" -> Text(title),
          "list-item-subtitle" -> Text(subtitle))
      }
    )

    assertEquals(list.contents.get.size, 3)
    assertEquals(list.contents.get.last.toHtml,
      """<div><div>Title c</div><div>Subtitle c</div></div>""")
  }
}
