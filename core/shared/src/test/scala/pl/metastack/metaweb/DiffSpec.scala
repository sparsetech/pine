package pl.metastack.metaweb

import scala.concurrent.Future
import org.scalatest.FunSuite
import pl.metastack.metaweb.diff._

class DiffSpec extends FunSuite {
  test("Replace children") {
    val spanAge  = NodeRef[tag.Span]("age")
    val spanName = NodeRef[tag.Span]("name")

    val node  = html"""<div id="child"><span id="age"></span><span id="name"></span></div>"""
    val diffs = Diff(spanAge := 42, spanName := "Joe")

    val x = diff.render.Tree.RenderNode.render(node, diffs)
    assert(x == html"""<div id="child"><span id="age">42</span><span id="name">Joe</span></div>""")
  }

  /*test("Replace children (views)") {
    def child(cid: Int, name: String): Future[tree.Node] = {
      val id = ViewId(cid.toString)

      val root     = NodeRef[tag.Div]("child")
      val spanName = NodeRef[tag.Span]("name")

      val node  = html"""<div id="child"><span id="name"></span></div>"""
      val diffs = Diff(spanName := name)

      diff.render.Tree.RenderNode.render(node, diffs)
    }

    val root = NodeRef[tag.Div]("page")

    val node  = Future.successful(html"""<div id="page"></div>""")
    val diffs = root := Seq(child(0, "Joe"), child(1, "Jeff"))

    val future = diff.render.Tree.RenderNode.render(node, diffs)
    future.map(x => assert(x == html"""<div id="page"><div id="child0"><span id="name0">Joe</span></div><div id="child1"><span id="name1">Jeff</span></div></div>"""))
  }*/
}
