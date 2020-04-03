package pine

import org.scalatest.funsuite.AnyFunSuite

class ExternalHtmlSpec extends AnyFunSuite {
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
    val tpl = html("../../html/test.html")
    checkTestHtml(tpl.toHtml)

    val tplOneWay = html("../../html/test.html")
    checkTestHtml(tplOneWay.toHtml)
  }

  test("Load mutable template") {
    val tpl = html("../../html/test.html")
    checkTestHtml(tpl.toHtml)

    val tplOneWay = html("../../html/test.html")
    checkTestHtml(tplOneWay.toHtml)
  }

  test("Replacing nodes") {
    val tpl = html("../../html/test2.html")

    val div2 = tpl.byId("div2")
    assert(div2.toHtml == """<div id="div2">Div 2 contents</div>""")

    val updated = div2.set(Text("42"))
    assert(updated.toHtml == """<div id="div2">42</div>""")
  }

  test("Instantiate template") {
    val tpl = html("../../html/list.html")
    val listItem = tpl.byId("list-item")

    val inst = listItem.update { implicit ctx =>
      TagRef("list-item-title")    := "Title"
      TagRef("list-item-subtitle") := "Subtitle"
    }.toHtml

    assert(inst == """<div id="list-item"><div id="list-item-title">Title</div><div id="list-item-subtitle">Subtitle</div></div>""")
  }

  test("Bind list item from template") {
    // Obtain tree without creating a state object
    val tpl = html("../../html/list.html")

    // When embedding list items, we need to drop the ID attribute
    val listItem = tpl.byId("list-item").remAttr("id")

    val items = List("a", "b", "c").map { i =>
      listItem.update { implicit ctx =>
        TagRef("list-item-title") := s"Title $i"
        TagRef("list-item-title").id.remove()

        TagRef("list-item-subtitle") := s"Subtitle $i"
        TagRef("list-item-subtitle").id.remove()
      }
    }

    // Instantiate template and replace list
    val replaced = tpl.update(implicit ctx => TagRef("list").set(items))

    val list = replaced.byId("list")
    assert(list.children.size == 3)
    assert(list.children.last.asInstanceOf[Tag[_]].toHtml ==
      """<div><div>Title c</div><div>Subtitle c</div></div>""")
  }
}
