package pl.metastack.metaweb

import minitest._

object BindingsSpec extends SimpleTestSuite {
  test("Binding `href` on `a` tags") {
    val a = new tag.A
    a.href := "http://example.com/"

    assertEquals(a.toHtml, """<a href="http://example.com/"></a>""")
  }

  test("Don't escape <script>") {
    val script = new tag.Script
    script += """$("a")"""

    assertEquals(script.toHtml, """<script>$("a")</script>""")
  }
}
