package pine

import org.scalatest.FunSuite

class NodeSpec extends FunSuite {
  test("Instantiate node") {
    val a = tag.A
      .href("http://github.com/")
      .set(Text("GitHub"))
    assert((a: Tag["a"]) == a)
    assert(a == html"""<a href="http://github.com/">GitHub</a>""")
    assert(a.toHtml == """<a href="http://github.com/">GitHub</a>""")
  }

  test("Instantiate node with Boolean attribute") {
    val opt = tag.Option.selected(true)
    assert(opt.toHtml == """<option selected=""></option>""")

    val opt2 = html"""<option></option>"""
    val opt3 = html"""<option selected=""></option>"""
    val opt4 = html"""<option selected="selected"></option>"""

    assert(!opt2.as[tag.Option].selected())
    assert(opt3.as[tag.Option].selected())
    assert(opt4.as[tag.Option].selected())
  }

  test("byClass") {
    val span = html"""<div class="test"><span class="test2">42</span></div>"""
    val result = span.byClass("test").byClass("test2")
    assert(result == span.children.head)
  }

  test("as") {
    val list: Tag["div"] = html"<div>Test</div>".as["div"]
    assert(list.tagName == "div")
    assert(list.isInstanceOf[Tag["div"]])

    assertThrows[java.lang.AssertionError] {
      list.as["span"]  // Invalid type
    }
  }

  test("Change tag") {
    val span = tag.Span.`class`("cls")
    val div  = span.tag[tag.Div]
    assert((div: Tag["div"]) == div)
    assert(div.toHtml == """<div class="cls"></div>""")
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
    """.as["html"]

    val modified = h.map {
      case Tag("title", _, _) => html"<title>Changed</title>"
      case n => n
    }

    assert((modified: Tag["html"]) == modified)
    assert(modified.byTag["title"] == html"<title>Changed</title>")
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
      case t @ Tag("b", _, _) => t.copy(tagName = "i")
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
      case t @ Tag("b", _, _) => t.copy(tagName = "i")
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

  test("suffixIds") {
    val div = html"""
      <div id="d" other="o">
        <label for="dd">hello</label>
        <input id="dd" value="world" list="ddlist">
        <br>
        <div><span data-a="c">hello</span></div>
        <div><span data-b="c">world</span></div>
      </div>
    """

    val expectedDiv = html"""
      <div id="d-suffix" other="o">
        <label for="dd-suffix">hello</label>
        <input id="dd-suffix" value="world" list="ddlist-suffix">
        <br>
        <div><span data-a="c">hello</span></div>
        <div><span data-b="c-suffix">world</span></div>
      </div>
    """

    assert(div.suffixIds("-suffix", Set("id", "for", "list", "data-b")) == expectedDiv)
  }

  test("byTagAll") {
    val div = html"""
      <div>
        <div><span>hello</span></div>
        <div><span>world</span></div>
      </div>
    """

    assert(div.byTagAll["span"] == List(
      tag.Span.set("hello"), tag.Span.set("world")
    ))
  }

  test("Prepend") {
    val div = html"""<div><br/></div>"""
    val str = (div +: html"""<span></span>""").toHtml
    assert(str == "<div><span></span><br/></div>")
  }

  test("Prepend all") {
    val div = html"""<div><br/></div>"""
    val str = div.prependAll(List(
      html"""<span></span>""",
      html"""<div></div>"""
    )).toHtml

    assert(str == "<div><span></span><div></div><br/></div>")
  }

  test("Append") {
    val div = html"""<div><br/></div>"""
    val str = (div :+ html"""<span></span>""").toHtml
    assert(str == "<div><br/><span></span></div>")
  }

  test("Update by tag") {
    val div  = html"""<div><span></span></div>"""
    val html = div.update(implicit ctx =>
      TagRef["span"] += html"<b>Hello</b>").toHtml
    assert(html == "<div><span><b>Hello</b></span></div>")
  }

  test("Update by ID") {
    val div  = html"""<div><span id="test"></span></div>"""
    val html = div.update(implicit ctx =>
      TagRef("test") += html"<b>Hello</b>").toHtml

    assert(html == """<div><span id="test"><b>Hello</b></span></div>""")
  }

  test("Update first by tag") {
    val div = html"""<div><span></span><span></span></div>"""
    val html = div.update(implicit ctx =>
      TagRef["span"] := html"<b>Hello</b>").toHtml
    assert(html == "<div><span><b>Hello</b></span><span></span></div>")
  }

  test("Update by tag using optional TagRef") {
    val div = html"""<div><span></span><span></span></div>"""
    val html = div.update(implicit ctx =>
      TagRef["span"].opt += html"<b>Hello</b>").toHtml
    assert(html == "<div><span><b>Hello</b></span><span></span></div>")
  }

  test("Update by tag using optional TagRef (2)") {
    val div = html"""<div><span></span><span></span></div>"""
    val html = div.update(implicit ctx =>
      TagRef["strong"].opt += html"<b>Hello</b>").toHtml
    assert(html == "<div><span></span><span></span></div>")
  }

  test("Update by tag with multiple matches") {
    val div = html"""<div><span></span><span></span></div>"""
    val html = div.update(implicit ctx =>
      TagRef["span"].each += html"<b>Hello</b>").toHtml
    assert(html == "<div><span><b>Hello</b></span><span><b>Hello</b></span></div>")
  }

  test("Update tag attributes with multiple matches") {
    val div  = html"""<div><a href="/a">A</a><a href="/b">B</a></div>"""
    val html = div.update(implicit ctx =>
      TagRef["a"].each.href.update(url => s"$url/test")).toHtml
    assert(html == """<div><a href="/a/test">A</a><a href="/b/test">B</a></div>""")
  }

  test("Remove") {
    val div = html"""<div><br/></div>"""
    val str = (div - html"""<br/>""").toHtml
    assert(str == "<div></div>")
  }

  test("Remove first by tag") {
    val div = html"""<div><span></span><span></span></div>"""
    val html = div.update(implicit ctx => TagRef["span"].remove()).toHtml
    assert(html == "<div><span></span></div>")
  }

  test("Remove by tag with multiple matches") {
    val div = html"""<div><span></span><span></span></div>"""
    val html = div.update(implicit ctx => TagRef["span"].each.remove()).toHtml
    assert(html == "<div></div>")
  }

  test("flatMap") {
    val div = html"<div><span>world</span></div>"
    val html = div.flatMap {
      case t: Text => List(html"<b>Hello </b>", t)
      case n => List(n)
    }.toHtml
    assert(html == "<div><span><b>Hello </b>world</span></div>")
  }

  test("Find elements by class") {
    val div = html"""<div><span class="a test"></span><span class="b test"></span></div>""".as[tag.Div]
    val input = TagRef.byClass[tag.Span]("test").each
    val updated = div.update { implicit ctx =>
      input.`class`.clear()
    }
    assert(updated.toHtml == "<div><span></span><span></span></div>")
  }

  test("Update `disabled` attribute of `input` node") {
    val input = html"""<input type="text" />""".as[tag.Input]
    assert(!input.disabled())

    val updated = input.update { implicit ctx =>
      TagRef[tag.Input].disabled := true
    }
    assert(updated.disabled())

    val updated2 = input.update { implicit ctx =>
      TagRef[tag.Input].disabled := false
    }
    assert(!updated2.disabled())
  }

  test("toXml on empty tags") {
    val node = Tag("test")
    assert(node.toXml == """<?xml version="1.0" encoding="UTF-8"?><test></test>""")

    val node2 = Tag("br")
    assert(node2.toXml == """<?xml version="1.0" encoding="UTF-8"?><br></br>""")
  }

  test("toXml on non-empty tags") {
    val node = Tag("test").set("Hello")
    assert(node.toXml == """<?xml version="1.0" encoding="UTF-8"?><test>Hello</test>""")

    val node2 = Tag("test").set("'\"")
    assert(node2.toXml == """<?xml version="1.0" encoding="UTF-8"?><test>'"</test>""")
  }

  test("Specify multiple classes") {
    val span = tag.Div.`class`("a", "b")
    assert(span.toHtml == """<div class="a b"></div>""")
  }

  test("Toggle class") {
    val div    = tag.Div.`class`("a", "b")
    val result = div.`class`.toggle("a")
    assert(result.toHtml == """<div class="b"></div>""")
  }

  test("Toggle class (2)") {
    val div    = tag.Div.`class`("a")
    val result = div.`class`.toggle("a")
    assert(result.toHtml == """<div></div>""")
  }

  test("Toggle class (3)") {
    val result = tag.Div.`class`.toggle("a")
    assert(result.toHtml == """<div class="a"></div>""")
  }

  test("Add existing class") {
    val div = html"""<div class="a b"></div>""".`class`.add("a")
    assert(div.toHtml == """<div class="a b"></div>""")
  }

  test("Add existing class (2)") {
    // Retain order
    val div = html"""<div class="b a"></div>""".`class`.add("a")
    assert(div.toHtml == """<div class="b a"></div>""")
  }

  test("Add existing class (3)") {
    val div = html"""<div class="b a"></div>""".`class`
      .state(true, "a")
    assert(div.toHtml == """<div class="b a"></div>""")
  }

  test("Remove non-existing class") {
    val div = html"""<div class="a b"></div>""".`class`.remove("c")
    assert(div.toHtml == """<div class="a b"></div>""")
  }

  test("Remove non-existing class (2)") {
    val div = html"""<div class="b a"></div>""".`class`.remove("c")
    assert(div.toHtml == """<div class="b a"></div>""")
  }

  test("Encode Long attribute") {
    val input = html"""<input></input>"""
    val updated = input.update { implicit ctx =>
      TagRef[tag.Input].size := 42
    }
    assert(updated.toHtml == "<input size=\"42\"/>")
  }

  test("Custom attribute codec") {
    sealed abstract class Language(val id: String)
    object Language {
      case object French  extends Language("french")
      case object Spanish extends Language("spanish")
      case object Unknown extends Language("unknown")
      val All = Set(French, Spanish)
    }

    implicit case object LanguageAttributeCodec extends AttributeCodec[Language] {
      override def encode(value: Language): Option[String] = Some(value.id)
      override def decode(value: Option[String]): Language =
        value.flatMap(id => Language.All.find(_.id == id))
          .getOrElse(Language.Unknown)
    }

    implicit class TagAttributesCustomDiv(tag: Tag[pine.tag.Div]) {
      val dataLanguage = TagAttribute[pine.tag.Div, Language](tag, "data-language")
    }

    assert(tag.Div.dataLanguage(Language.Spanish).toHtml ==
      """<div data-language="spanish"></div>""")
  }
}
