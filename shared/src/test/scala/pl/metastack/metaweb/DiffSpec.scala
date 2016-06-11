package pl.metastack.metaweb

import scala.concurrent.Future
import org.scalatest.AsyncFunSuite
import pl.metastack.metaweb.diff.{Diff, NodeRef}

class DiffSpec extends AsyncFunSuite {
  test("Replace children") {
    val view = new View {
      override implicit def id = ViewId("")

      val root     = NodeRef[tag.Div]("child")
      val spanAge  = NodeRef[tag.Span]("age")
      val spanName = NodeRef[tag.Span]("name")

      override def node() = Future.successful(
        html"""<div id="child"><span id="age"></span><span id="name"></span></div>""")
      override def populate() = Diff(spanAge := 42, spanName := "Joe")
    }

    val future = diff.render.Tree.renderView(view)
    future.map(x => assert(x == html"""<div id="child"><span id="age">42</span><span id="name">Joe</span></div>"""))
  }

  test("Replace children (async)") {
    val view = new View {
      override implicit def id = ViewId("")

      val root     = NodeRef[tag.Div]("child")
      val spanAge  = NodeRef[tag.Span]("age")
      val spanName = NodeRef[tag.Span]("name")

      override def node() = Future.successful(
        html"""<div id="child"><span id="age"></span><span id="name"></span></div>""")
      override def populate() =
        Diff.Async(Future(Diff(spanAge := 42, spanName := "Joe")))
    }

    val future = diff.render.Tree.renderView(view)
    future.map(x => assert(x == html"""<div id="child"><span id="age">42</span><span id="name">Joe</span></div>"""))
  }

  test("Replace children (views)") {
    def child(cid: Int, name: String): View = new View {
      override implicit def id = ViewId(cid.toString)

      val root     = NodeRef[tag.Div]("child")
      val spanName = NodeRef[tag.Span]("name")

      override def node() = Future.successful(
        html"""<div id="child"><span id="name"></span></div>""")
      override def populate() = Diff(spanName := name)
    }

    val view = new View {
      override implicit def id = ViewId("")

      val root = NodeRef[tag.Div]("page")

      override def node() = Future.successful(html"""<div id="page"></div>""")
      override def populate() = root := Seq(child(0, "Joe"), child(1, "Jeff"))
    }

    val future = diff.render.Tree.renderView(view)
    future.map(x => assert(x == html"""<div id="page"><div id="child0"><span id="name0">Joe</span></div><div id="child1"><span id="name1">Jeff</span></div></div>"""))
  }
}
