package pl.metastack.metaweb

import minitest._

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

    val tplOneWay = html("shared/src/test/html/test.html")
    checkTestHtml(tplOneWay.toHtml)
  }

  test("Load mutable template") {
    val tpl = html("shared/src/test/html/test.html")
    checkTestHtml(tpl.toHtml)

    val tplOneWay = html("shared/src/test/html/test.html")
    checkTestHtml(tplOneWay.toHtml)
  }

  test("Replace nodes") {
    val tpl = html("shared/src/test/html/test2.html")

    val div2 = tpl.byId[state.Tag]("div2")
    assertEquals(div2.toHtml, """<div id="div2">Div 2 contents</div>""")

    div2 := tree.Text("42").state
    assertEquals(div2.toHtml, """<div id="div2">42</div>""")
  }

  test("Instantiate template") {
    val tpl = htmlT("shared/src/test/html/list.html")
    val listItem = tpl.byId[tree.Tag]("list-item")

    val html = listItem.instantiate(
      "list-item-title" -> tree.Text(s"Title"),
      "list-item-subtitle" -> tree.Text(s"Subtitle")
    ).state.toHtml

    assertEquals(html, """<div id="list-item"><div>Title</div><div>Subtitle</div></div>""")
  }

  test("Bind list item from template") {
    // Obtain tree without creating a state object
    val tpl = htmlT("shared/src/test/html/list.html")

    // When embedding list items, we need to drop the ID attribute
    val listItem = tpl.byId[tree.Tag]("list-item").withoutId

    val items = Seq("a", "b", "c").map { i =>
      listItem.instantiate(
        "list-item-title" -> tree.Text(s"Title $i"),
        "list-item-subtitle" -> tree.Text(s"Subtitle $i")
      ).state
    }

    // Instantiate template and replace list
    val tplState = tpl.state
    tplState.byId[state.Tag]("list").setChildren(items)

    val list = tplState.byId[state.Tag]("list")
    assertEquals(list.children.size, 3)
    assertEquals(list.children.last.toHtml,
      """<div><div>Title c</div><div>Subtitle c</div></div>""")
  }
}
