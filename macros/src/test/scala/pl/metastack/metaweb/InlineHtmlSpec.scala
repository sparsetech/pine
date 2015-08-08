package pl.metastack.metaweb

import scala.collection.mutable.ArrayBuffer

import pl.metastack.metarx.Var
import pl.metastack.metaweb.HtmlMacro._

import minitest._

object InlineHtmlSpec extends SimpleTestSuite {
  test("toHtml") {
    val url = Var("http://github.com/")
    val title = Var("GitHub")
    val parsedHtml = html"""<a href=$url>$title</a>"""

    // translates into:
    // val root = tag.a()
    // root.bind("href", url)
    // root += Text(title)

    parsedHtml.head match {
      case root: tag.a =>
        assertEquals(root.toHtml, """<a href="http://github.com/">GitHub</a>""")

        url := "http://google.com/"
        assertEquals(root.href.get, "http://google.com/")
        assertEquals(root.toHtml, """<a href="http://google.com/">GitHub</a>""")

        root.clear()
        assertEquals(root.toHtml, """<a href="http://google.com/"></a>""")
    }
  }

  test("toHtmlLive") {
    val url = Var("http://github.com/")
    val title = Var("GitHub")
    val parsedHtml = html"""<a href=$url>$title</a>"""

    parsedHtml.head match {
      case root: tag.a =>
        val changes = ArrayBuffer.empty[String]

        root.toHtmlLive.attach(changes += _)

        title := "Google"
        url := "http://google.com/"

        assertEquals(changes, Seq(
          """<a href="http://github.com/">GitHub</a>""",
          """<a href="http://github.com/">Google</a>""",
          """<a href="http://google.com/">Google</a>"""
        ))
    }
  }
}
