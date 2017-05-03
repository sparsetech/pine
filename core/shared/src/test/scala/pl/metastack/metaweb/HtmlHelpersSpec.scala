package pl.metastack.metaweb

import org.scalatest.FunSuite

class HtmlHelpersSpec extends FunSuite {
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
    assert(HtmlHelpers.decodeText("Hello") == "Hello")
  }

  test("Decode text (2)") {
    assert(HtmlHelpers.decodeText("test&grave;42") == "test`42")
  }

  test("Decode text (3)") {
    assert(HtmlHelpers.decodeText("&#x00060;") == "`")
  }

  test("Decode text (4)") {
    assert(HtmlHelpers.decodeText("&#96;") == "`")
  }

  test("Decode text (5)") {
    assert(HtmlHelpers.decodeText("&plus;&equals;") == "+=")
  }
}
