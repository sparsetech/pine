package pine

import org.scalatest.funsuite.AnyFunSuite

class HtmlHelpersSpec extends AnyFunSuite {
  test("Reader") {
    val reader = new Reader("test;bc")
    assert(reader.collect(';').contains("test"))
    assert(reader.rest() == "bc")

    val reader2 = new Reader(";bc")
    assert(reader2.collect(';').contains(""))
    assert(reader2.rest() == "bc")

    val reader3 = new Reader(";bc")
    assert(reader3.collect('!').isEmpty)
    assert(reader3.rest() == ";bc")
  }

  test("Decode text") {
    assert(HtmlHelpers.decodeText("Hello", xml = false) == "Hello")
  }

  test("Decode text (2)") {
    assert(HtmlHelpers.decodeText("test&grave;42", xml = false) == "test`42")
  }

  test("Decode text (3)") {
    assert(HtmlHelpers.decodeText("&#x00060;", xml = false) == "`")
  }

  test("Decode text (4)") {
    assert(HtmlHelpers.decodeText("&#96;", xml = false) == "`")
  }

  test("Decode text (5)") {
    assert(HtmlHelpers.decodeText("&plus;&equals;", xml = false) == "+=")
  }
}
