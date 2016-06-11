package pl.metastack.metaweb

import org.scalatest.FunSuite

class NodeSpec extends FunSuite {
  test("byClass") {
    val span = html"""<div class="test"><span class="test2">42</span></div>"""

    assert(span
      .byClass[tree.Tag]("test")
      .byClass[tree.Tag]("test2") == span.children.head)
  }
}
