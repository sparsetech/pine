package pl.metastack.metaweb

import org.scalatest.FunSuite

class NodeSpec extends FunSuite {
  test("Instantiate") {
    val a = tag.A()
      .href("http://github.com/")
      .set(tree.Text("GitHub"))
    assert((a: tag.A) == a)
    assert(a == html"""<a href="http://github.com/">GitHub</a>""")
    assert(a.toHtml == """<a href="http://github.com/">GitHub</a>""")
  }

  test("byClass") {
    val span = html"""<div class="test"><span class="test2">42</span></div>"""

    assert(span
      .byClass[tree.Tag]("test")
      .byClass[tree.Tag]("test2") == span.children.head)
  }
}
