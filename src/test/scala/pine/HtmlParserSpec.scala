package pine

import org.scalatest.funsuite.AnyFunSuite

class HtmlParserSpec extends AnyFunSuite {
  test("Empty text node") {
    assertThrows[ParseError] {
      HtmlParser.fromString("")
    }
  }

  test("Parse text") {
    assertThrows[ParseError] {
      HtmlParser.fromString("Hello world")
    }
  }

  test("Parse text (2)") {
    assertThrows[ParseError] {
      HtmlParser.fromString("'\"")
    }
  }

  test("Parse attributes") {
    val node = tag.Span.setAttr("ä-ö_ü", "äöü")
    assert(HtmlParser.fromString(node.toHtml) == node)
  }

  test("Parse HTML node") {
    val node = tag.Html.set(List(tag.Head, tag.Body))
    assert(HtmlParser.fromString(node.toHtml) == node)
  }

  test("Parse head node") {
    val node = tag.Head
    assert(HtmlParser.fromString(node.toHtml) == node)
  }

  test("Parse title node") {
    val node = tag.Title
    assert(HtmlParser.fromString(node.toHtml) == node)
  }

  test("Parse meta node") {
    val node = tag.Meta
    assert(HtmlParser.fromString(node.toHtml) == node)
  }

  test("Parse link node") {
    val node = tag.Link
    assert(HtmlParser.fromString(node.toHtml) == node)
  }

  test("Parse body node") {
    val node = tag.Body
    assert(HtmlParser.fromString(node.toHtml) == node)
  }

  test("Parse text with entities") {
    val html = "<span>&lpar;Hello world&rpar;</span>"
    val node = HtmlParser.fromString(html)
    assert(node == tag.Span.set(Text("(Hello world)")))
  }

  test("Parse text with entities (2)") {
    val html = "<span>&grave;&DiacriticalGrave;&#x00060;&#96;</span>"
    val node = HtmlParser.fromString(html)
    assert(node == tag.Span.set(Text("````")))
  }

  test("Parse text with hex entities") {
    val html = "<span>Hello world&#33;</span>"
    val node = HtmlParser.fromString(html)
    assert(node == tag.Span.set(Text("Hello world!")))
  }

  test("Parse invalid entities") {
    assertThrows[ParseError] {
      val text = "<span>&abcd;</span>"
      HtmlParser.fromString(text)
    }
  }

  test("Parse invalid entities (2)") {
    assertThrows[ParseError] {
      val text = "<span>&;</span>"
      HtmlParser.fromString(text)
    }
  }

  test("Parse simple tag") {
    val html = "<br/>"
    val node = HtmlParser.fromString(html)
    assert(node == tag.Br)
  }

  test("Parse tag") {
    val html = """<a href="http://google.com/">Google</a>"""
    val node = HtmlParser.fromString(html)
    assert(node == (tag.A.href("http://google.com/") :+ Text("Google")))
  }

  test("Parse HTML") {
    val html = """<div id="a"><span>42</span></div>"""
    val node = HtmlParser.fromString(html)
    assert(node.toHtml == html)
  }

  test("Decode arguments") {
    val html = """<a href="a&amp;b"></a>"""
    val node = HtmlParser.fromString(html)
    assert(node == tag.A.href("a&b"))

    val html2 = """<a href="a&amp;&gt;b"></a>"""
    val node2 = HtmlParser.fromString(html2)
    assert(node2 == tag.A.href("a&>b"))
  }

  test("Parse node with boolean attribute") {
    val html       = """<input type="checkbox" checked/>"""
    val htmlParsed = """<input type="checkbox" checked=""/>"""
    val node = HtmlParser.fromString(html)
    assert(node.toHtml == htmlParsed)
  }

  test("Parse node with custom data attribute") {
    val html       = """<input type="checkbox" data-key="value" data-key2/>"""
    val htmlParsed = """<input type="checkbox" data-key="value" data-key2=""/>"""
    val node = HtmlParser.fromString(html)
    assert(node.toHtml == htmlParsed)
  }

  test("Parse node with attribute which contains spaces before and after equal sign") {
    val html       = """<input type =  "checkbox"/>"""
    val htmlParsed = """<input type="checkbox"/>"""
    val node = HtmlParser.fromString(html)
    assert(node.toHtml == htmlParsed)
  }

  test("Ignore comments") {
    val html = """<div>test <!-- Ignore -->!</div>"""
    val node = HtmlParser.fromString(html)
    assert(node == (tag.Div :+ Text("test ") :+ Text("!")))
  }

  test("Ignore comments (2)") {
    val html = """<div>test <!-- <br/> -->!</div>"""
    val node = HtmlParser.fromString(html)
    assert(node == (tag.Div :+ Text("test ") :+ Text("!")))
  }

  test("Resolve node") {
    val html = """<div id="a"><b>test</b><span id="b"></span></div>"""
    val div = HtmlParser.fromString(html).asInstanceOf[Tag[_]].byId("b")
    assert(div == html"""<span id="b"></span>""")
  }

  test("Parse DOCTYPE") {
    val html = """<!DOCTYPE html><html><head lang="en"></head><body><span>42</span></body></html>"""
    val node = HtmlParser.fromString(html)
    assert(node.toHtml == html)
  }

  test("Parse DOCTYPE (2)") {
    // Parser must match DOCTYPE case-insensitively
    // See https://html.spec.whatwg.org/multipage/syntax.html#the-doctype
    val html = """<!doctype html><html><head lang="en"></head><body><span>42</span></body></html>"""
    val node = HtmlParser.fromString(html)
    assert(node.toHtml == html.replace("<!doctype", "<!DOCTYPE"))
  }

  test("Do not handle CDATA") {
    val html = """<script>// <![CDATA[
var x = 42;
// ]]></script>"""

    val node = HtmlParser.fromString(html)
    assert(node == tag.Script.set(
      """// <![CDATA[
var x = 42;
// ]]>"""))
  }

  test("Parse script nodes") {
    val html = """<script>i < len</script>"""
    val node = HtmlParser.fromString(html)
    assert(node.toHtml == html)
  }

  test("Parse style nodes") {
    val html = """<style>.outer > div {}</style>"""
    val node = HtmlParser.fromString(html)
    assert(node.toHtml == html)

    val html2 = """<style><</style>"""
    val node2 = HtmlParser.fromString(html2)
    assert(node2.toHtml == html2)
  }

  test("Parse multiple root comments (prefix)") {
    val html = """<!--test--><!----><a></a>"""
    assert(HtmlParser.fromString(html) == tag.A)
  }

  test("Parse multiple root comments (suffix)") {
    val html = """<a></a><!--test--><!---->"""
    assert(HtmlParser.fromString(html) == tag.A)
  }

  test("Parse multiple child comments") {
    val html = """<a><!--test--><!----></a>"""
    assert(HtmlParser.fromString(html) == tag.A)
  }

  test("Cannot parse XML tags") {
    assertThrows[ParseError] {
      HtmlParser.fromString("""<item><link></link><guid></guid></item>""")
    }
  }

  test("Parse XML tags") {
    XmlParser.fromString("""<item><link></link><guid></guid></item>""")
    xml"""<item><link></link><guid></guid></item>"""
  }

  test("Read unambiguous ampersand") {
    assert(HtmlParser.fromString("<div>editable && copy</div>") ==
      tag.Div.set("editable && copy"))
  }

  test("Detect ambiguous ampersand") {
    assertThrows[ParseError] {
      HtmlParser.fromString("<div>editable&&copy</div>")
    }
  }

  test("Ignore unclosed tags") {
    assert(HtmlParser.fromString("<html>") == tag.Html)
    assert(HtmlParser.fromString("<html>\n") == tag.Html.set("\n"))

    assert(XmlParser.fromString("<html>") == tag.Html)
    assert(XmlParser.fromString("<html>\n") == tag.Html.set("\n"))
  }
}
