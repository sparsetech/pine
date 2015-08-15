package pl.metastack.metaweb

import pl.metastack.metarx.{Buffer, Var}

import minitest._

object ImplicitsSpec extends SimpleTestSuite {
  test("Convert values") {
    val parsed = html"""<span></span>"""

    parsed match {
      case span: tag.span =>
        span := "Hello world"
        assertEquals(span.toHtml, "<span>Hello world</span>")

        span := 42
        assertEquals(span.toHtml, "<span>42</span>")

        span := true
        assertEquals(span.toHtml, "<span>true</span>")
    }
  }

  test("Convert value channels") {
    val parsed = html"""<span></span>"""

    parsed match {
      case span: tag.span =>
        val v = Var("GitHub")
        span := v
        assertEquals(span.toHtml, "<span>GitHub</span>")

        v := "Google"
        assertEquals(span.toHtml, "<span>Google</span>")

        val v2 = Var(42)
        span := v2
        assertEquals(span.toHtml, "<span>42</span>")

        v2 := 23
        assertEquals(span.toHtml, "<span>23</span>")
    }
  }

  test("Convert node channels") {
    val parsed = html"""<span></span>"""

    parsed match {
      case span: tag.span =>
        val v = Var(html"""<div>42</div>""")
        span := v
        assertEquals(span.toHtml, "<span><div>42</div></span>")

        v := html"""<div>23</div>"""
        assertEquals(span.toHtml, "<span><div>23</div></span>")
    }
  }

  test("Convert string buffers") {
    val parsed = html"""<span></span>"""

    parsed match {
      case span: tag.span =>
        val buffer = Buffer("Hello")
        span := buffer
        assertEquals(span.toHtml, "<span>Hello</span>")

        buffer += " world"
        assertEquals(span.toHtml, "<span>Hello world</span>")
    }
  }
}
