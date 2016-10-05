package pl.metastack.metaweb

import org.scalatest.FunSuite

class ExternalHtmlSpec extends FunSuite {
  def checkTestHtml(value: String): Unit =
    assert(value ==
      """<!DOCTYPE html><html>
<body>
	<b>Hello World</b>
	<div id="div1">Div 1 contents</div>
	<div id="div2">Div 2 contents</div>
</body>
</html>""")

  test("Load immutable template") {
    val tpl = html("core/shared/src/test/html/test.html")
    checkTestHtml(tpl.toHtml)

    val tplOneWay = html("core/shared/src/test/html/test.html")
    checkTestHtml(tplOneWay.toHtml)
  }

  test("Load mutable template") {
    val tpl = html("core/shared/src/test/html/test.html")
    checkTestHtml(tpl.toHtml)

    val tplOneWay = html("core/shared/src/test/html/test.html")
    checkTestHtml(tplOneWay.toHtml)
  }

  test("Replacing nodes") {
    val tpl = html("core/shared/src/test/html/test2.html")

    val div2 = tpl.byId[tree.Tag]("div2")
    assert(div2.toHtml == """<div id="div2">Div 2 contents</div>""")

    val updated = div2.set(tree.Text("42"))
    assert(updated.toHtml == """<div id="div2">42</div>""")
  }

  test("Instantiate template") {
    val tpl = html("core/shared/src/test/html/list.html")
    val listItem = tpl.byId[tree.Tag]("list-item")

    val inst = listItem.instantiate(
      "list-item-title" -> tree.Text(s"Title"),
      "list-item-subtitle" -> tree.Text(s"Subtitle")
    ).toHtml

    assert(inst == """<div id="list-item"><div>Title</div><div>Subtitle</div></div>""")
  }

  test("Bind list item from template") {
    // Obtain tree without creating a state object
    val tpl = html("core/shared/src/test/html/list.html")

    // When embedding list items, we need to drop the ID attribute
    val listItem = tpl.byId[tree.Tag]("list-item").withoutId

    val items = Seq("a", "b", "c").map { i =>
      listItem.instantiate(
        "list-item-title" -> tree.Text(s"Title $i"),
        "list-item-subtitle" -> tree.Text(s"Subtitle $i")
      )
    }

    // Instantiate template and replace list
    val replaced = tpl.updateById[tree.Tag]("list", _.set(items))
      .asInstanceOf[tree.Tag]

    val list = replaced.byId[tree.Tag]("list")
    assert(list.children.size == 3)
    assert(list.children.last.toHtml ==
      """<div><div>Title c</div><div>Subtitle c</div></div>""")
  }
}
