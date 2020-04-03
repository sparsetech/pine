package pine

import org.scalatest.funsuite.AnyFunSuite

class DiffSpec extends AnyFunSuite {
  test("Replace nodes") {
    val spanAge  = TagRef["span"]("age")
    val spanName = TagRef["span"]("name")

    val node   = html"""<div id="child"><span id="age"></span><span id="name"></span></div>"""
    val result = node.update { implicit ctx =>
      spanAge := 42
      spanName := "Joe"
    }

    assert(result == html"""<div id="child"><span id="age">42</span><span id="name">Joe</span></div>""")
  }

  test("Render lists") {
    case class Item(id: Int, name: String)
    val itemView = html"""<div id="child"><span id="name"></span></div>"""

    def renderItem(item: Item): Tag[_] = {
      val id   = item.id.toString
      val node = itemView.suffixIds(id)
      val spanName = TagRef["span"]("name", id)
      node.update { implicit ctx =>
        spanName := item.name
      }
    }

    val node   = html"""<div id="page"></div>"""
    val root   = TagRef["div"]("page")
    val items  = List(Item(0, "Joe"), Item(1, "Jeff"))
    val result = node.update(implicit ctx => root.set(items.map(renderItem)))
    assert(result == html"""<div id="page"><div id="child0"><span id="name0">Joe</span></div><div id="child1"><span id="name1">Jeff</span></div></div>""")
  }

  test("insertAt()") {
    val node  = html"""<div id="nodes"></div>"""
    val result = node.update { implicit ctx =>
      TagRef("nodes").insertAt(0, tag.Span.set("a"))
    }

    assert(result == html"""<div id="nodes"><span>a</span></div>""")
  }

  test("insertAt() (2)") {
    val node  = html"""<div id="nodes"><span>a</span><span>b</span><span>c</span></div>"""
    val result = node.update { implicit ctx =>
      TagRef("nodes").insertAt(1, List(tag.Span.set("d"), tag.Span.set("e")))
    }

    assert(result == html"""<div id="nodes"><span>a</span><span>d</span><span>e</span><span>b</span><span>c</span></div>""")
  }
}
