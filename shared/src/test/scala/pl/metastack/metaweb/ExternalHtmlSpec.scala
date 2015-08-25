package pl.metastack.metaweb

import pl.metastack.metarx.{Buffer, Var}

import minitest._
import pl.metastack.metaweb.tree.mutable.Text

object ExternalHtmlSpec extends SimpleTestSuite {
  def checkTestHtml(value: String) {
    assertEquals(value,
      """<!DOCTYPE html><html>
<body>
	<b>Hello World</b>
	<div id="div1">Div 1 contents</div>
	<div id="div2">Div 2 contents</div>
</body>
</html>"""
    )
  }

  test("Load immutable template") {
    val tpl = html("shared/src/test/html/test.html")
    checkTestHtml(tpl.toHtml)
  }

  test("Load mutable template") {
    val tpl = htmlMutable("shared/src/test/html/test.html")
    checkTestHtml(tpl.toHtml)
  }

  test("Replace nodes") {
    val tpl = htmlMutable("shared/src/test/html/test2.html")

    val div2 = tpl.byId[tag.div]("div2")
    assertEquals(div2.toHtml, """<div id="div2">Div 2 contents</div>""")

    div2 := Text(Var("42"))
    assertEquals(div2.toHtml, """<div id="div2">42</div>""")
  }

  test("Bind list item from template") {
    val tpl = htmlMutable("shared/src/test/html/list.html")

    val list = tpl.byId[tag.mutable.div]("list")
    val listItem = tpl.byId[tag.mutable.div]("list-item")

    list.bindChildrenBuffer(
      Buffer("a", "b", "c").map { i =>
        listItem.instantiate(
          "list-item-title" -> Text(s"Title $i"),
          "list-item-subtitle" -> Text(s"Subtitle $i"))
      }
    )

    assertEquals(list.contents.get.size, 3)
    assertEquals(list.contents.get.last.toHtml,
      """<div><div>Title c</div><div>Subtitle c</div></div>""")
  }
}
