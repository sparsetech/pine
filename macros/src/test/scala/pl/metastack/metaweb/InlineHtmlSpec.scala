package pl.metastack.metaweb

import scala.collection.mutable.ArrayBuffer

import pl.metastack.metarx.{Buffer, Var}
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

    parsedHtml match {
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

    parsedHtml match {
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

  test("Bind list") {
    val tpl = html"""<div id="list"></div>"""

    tpl match {
      case list: tag.div =>
        list.bindChildren(Buffer("a", "b", "c").map { i =>
          val title = Var(s"Title $i")
          val subtitle = Var(s"Subtitle $i")
          html"""<div><div>$title</div><div>$subtitle</div></div>"""
        })

        assertEquals(list.contents.get.size, 3)
        assertEquals(list.contents.get.last.toHtml,
          """<div><div>Title c</div><div>Subtitle c</div></div>""")
    }
  }
}
