package pine

import org.scalatest.FunSuite

class DiffSpec extends FunSuite {
  test("Replace nodes") {
    val spanAge  = TagRef[tag.Span]("age")
    val spanName = TagRef[tag.Span]("name")

    val node   = html"""<div id="child"><span id="age"></span><span id="name"></span></div>"""
    val result = node.update(spanAge := 42, spanName := "Joe")

    assert(result == html"""<div id="child"><span id="age">42</span><span id="name">Joe</span></div>""")
  }

  test("Render lists") {
    case class Item(id: Int, name: String)
    implicit def itemId: Id[Item] = Id(_.id.toString)

    def render(item: Item): Tag = {
      val node     = html"""<div id="child"><span id="name"></span></div>"""
      val spanName = TagRef[tag.Span]("name")
      node.update(spanName := item.name)
    }

    val node   = html"""<div id="page"></div>"""
    val root   = TagRef[tag.Div]("page")
    val items  = List(Item(0, "Joe"), Item(1, "Jeff"))
    val result = node.update(root.set(items, render))
    assert(result == html"""<div id="page"><div id="child0"><span id="name0">Joe</span></div><div id="child1"><span id="name1">Jeff</span></div></div>""")
  }
}
