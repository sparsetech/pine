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
    assert(modified.byTag[tag.Title] == html"<title>Changed</title>")
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

  test("Map first") {
    val div = html"""
      <div>
        <span>
          <b>Hello</b>
          <i>World</i>
          <b>!</b>
        </span>
      </div>
    """

    val modified = div.mapFirst {
      case t: tag.B => tag.I(t.attributes, t.children)
    }

    val div2 = html"""
      <div>
        <span>
          <i>Hello</i>
          <i>World</i>
          <b>!</b>
        </span>
      </div>
    """

    assert(modified == div2)
  }

  test("Prepend") {
    val div = html"""<div><br/></div>"""
    val str = (div +: html"""<span></span>""").toHtml
    assert(str == "<div><span></span><br/></div>")
  }

  test("Append") {
    val div = html"""<div><br/></div>"""
    val str = (div :+ html"""<span></span>""").toHtml
    assert(str == "<div><br/><span></span></div>")
  }

  test("Update by tag") {
    val div = html"""<div><span></span></div>"""
    val html = div.updateByTag[tag.Span](_ +: html"<b>Hello</b>").toHtml
    assert(html == "<div><span><b>Hello</b></span></div>")
  }

  test("Update by ID") {
    val div = html"""<div><span id="test"></span></div>"""
    val html = div.updateById[tag.Span]("test", _ +: html"<b>Hello</b>").toHtml
    assert(html == """<div><span id="test"><b>Hello</b></span></div>""")
  }

  test("Update by tag with multiple matches") {
    val div = html"""<div><span></span><span></span></div>"""
    val html = div.updateByTag[tag.Span](_ +: html"<b>Hello</b>").toHtml
    assert(html == "<div><span><b>Hello</b></span><span><b>Hello</b></span></div>")
  }

  test("Update first by tag") {
    val div = html"""<div><span></span><span></span></div>"""
    val html = div.updateFirstByTag[tag.Span](_ +: html"<b>Hello</b>").toHtml
    assert(html == "<div><span><b>Hello</b></span><span></span></div>")
  }

  test("flatMap") {
    val div = html"<div><span>world</span></div>"
    val html = div.flatMap {
      case t: tree.Text => Seq(html"<b>Hello </b>", t)
      case n => Seq(n)
    }.toHtml
    assert(html == "<div><span><b>Hello </b>world</span></div>")
  }
}
