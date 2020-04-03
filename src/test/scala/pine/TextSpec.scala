package pine

import org.scalatest.funsuite.AnyFunSuite

class TextSpec extends AnyFunSuite {
  test("Text node") {
    val node = tag.Span.set(Text("Hello\nworld"))
    assert(node.toText == "Hello world")
  }

  test("Text node (2)") {
    val node = tag.Span.set(Text("Hello\tworld"))
    assert(node.toText == "Hello world")
  }

  test("Text node (3)") {
    val node = tag.Span.set(Text("Hello \t\n world"))
    assert(node.toText == "Hello world")
  }

  test("Script node") {
    val node = html"""<script>Hello world</script>"""
    assert(node.toText == "")
  }

  test("List node") {
    val node = html"""<ul><li>Hello</li><li>World</li></ul>"""
    assert(node.toText == "- Hello\n- World")
  }

  test("List node (2)") {
    val node = html"""<ul> <li>Hello</li> <li>World</li> </ul>"""
    assert(node.toText == "- Hello\n- World")
  }

  test("List node (3)") {
    val node = html"""<ul> <li> Hello </li> <li> World </li> </ul>"""
    assert(node.toText == "- Hello\n- World")
  }

  test("Div node") {
    val node = html"""<div>Hello</div>"""
    assert(node.toText == "Hello")
  }

  test("Div nodes") {
    val node = html"""<div><div>Hello</div><div>World</div></div>"""
    assert(node.toText == "Hello\nWorld")
  }

  test("Heading nodes") {
    val node = html"""<div><h1>Heading</h1>Text</div>"""
    assert(node.toText == "Heading\n\nText")
  }

  test("Heading nodes (2)") {
    val node = html"""<div><h1>Heading</h1><p>Text</p></div>"""
    assert(node.toText == "Heading\n\nText")
  }

  test("Heading nodes (3)") {
    val node = html"""<div><h1>Heading</h1><p>Text</p><h1>Heading</h1><p>Text</p></div>"""
    assert(node.toText == "Heading\n\nText\n\nHeading\n\nText")
  }

  test("Paragraph nodes") {
    val node = html"""<div><p>First</p><p>Second</p></div>"""
    assert(node.toText == "First\n\nSecond")
  }

  test("Line break node") {
    val node = html"""<div>Hello<br /> world</div>"""
    assert(node.toText == "Hello\nworld")
  }
}
