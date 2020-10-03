package pine

import org.scalatest.FunSuite

class XmlParserSpec extends FunSuite {
  test("Simple node") {
    val xml = "<b>test</b>"
    assert(XmlParser.fromString(xml) == tag.B.set("test"))
  }

  test("Empty entity") {
    val xml = "<b>&;</b>"
    assertThrows[ParseError] {
      XmlParser.fromString(xml)
    }
  }

  test("Invalid entity") {
    val xml = "<b>&lambda;</b>"
    assertThrows[ParseError] {
      XmlParser.fromString(xml)
    }
  }

  test("Invalid entity (2)") {
    val xml = "<b>&abcd;</b>"
    assertThrows[ParseError] {
      XmlParser.fromString(xml)
    }
  }

  test("Valid entity") {
    val xml = "<b>&amp;</b>"
    assert(XmlParser.fromString(xml) == tag.B.set("&"))
  }

  test("Parse CDATA") {
    val html = "<node><![CDATA[hello]]></node>"
    val node = XmlParser.fromString(html)
    assert(node == Tag("node").set(Text("hello")))
  }

  // From https://www.soapui.org/docs/functional-testing/working-with-cdata.html
  test("Parse CDATA (2)") {
    val html = "<message><![CDATA[<data>embedded XML</data>]]></message>"
    val node = XmlParser.fromString(html)
    assert(node == Tag("message").set(Text("<data>embedded XML</data>")))
  }

  test("Parse CDATA (3)") {
    val html = "<message><![CDATA[<data>embedded XML <![CDATA[<text>with XML</text>]]]]>><![CDATA[</data>]]></message>"
    val node = XmlParser.fromString(html)
    assert(node == Tag("message").set(List(
      Text("<data>embedded XML <![CDATA[<text>with XML</text>]]"),
      Text(">"),
      Text("</data>"))
    ))
  }
}
