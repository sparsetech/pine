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

  test("map") {
    val h = html"""
      <html>
      <head>
        <meta charset="utf-8" />
        <title>MetaWeb</title>
      </head>
      <body></body>
      </html>
    """.asInstanceOf[tag.Html]

    val modified = h.map {
      case t: tag.Title => html"<title>Changed</title>"
      case n => n
    }

    assert((modified: tag.Html) == modified)
    assert(modified.byTag[tag.Title]("title") == html"<title>Changed</title>")
  }

  test("map with multiple occurrences") {
    val div = html"""
      <div>
        <span>
          <b>Hello</b>
          <i>World</i>
          <b>!</b>
        </span>
      </div>
    """

    val modified = div.map {
      case t: tag.B => tag.I(t.attributes, t.children)
      case n => n
    }

    val div2 = html"""
      <div>
        <span>
          <i>Hello</i>
          <i>World</i>
          <i>!</i>
        </span>
      </div>
    """

    assert(modified == div2)
  }
}
