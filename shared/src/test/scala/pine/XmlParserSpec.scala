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
      // TODO JavaScript's HtmlParser accepts &lambda;
      internal.HtmlParser.fromString(xml, xml = true)
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
}
