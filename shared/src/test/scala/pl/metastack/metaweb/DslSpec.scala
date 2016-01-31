package pl.metastack.metaweb

import minitest._
import pl.metastack.metaweb.dsl._

object DslSpec extends SimpleTestSuite {
  test("byClass") {
    val span = html"""<div class="test"><span class="test2">42</span></div>"""

    assertEquals(span
      .byClass[state.Tag]("test")
      .byClass[state.Tag]("test2"),
      span.children.head)
  }
}
