package pl.metastack.metaweb

import org.scalatest.FunSuite
import pl.metastack.metaweb.diff.{Id, NodeRef}

class NodeRefSpec extends FunSuite {
  test("Use DSL to set boolean attribute to true") {
    val node = tag.Input()
      .id("test")

    val nodeRef = NodeRef[tag.Input]("test")

    assert(!node.checked)

    val updated = node.update(nodeRef.checked.update(!_))
    assert(updated == node.checked(true))
  }

  test("Use DSL to set boolean attribute to false") {
    val node = tag.Input()
      .id("test")
      .checked(true)

    val nodeRef = NodeRef[tag.Input]("test")

    assert(node.checked)

    val updated = node.update(nodeRef.checked.update(!_))
    assert(updated == node.checked(false))
  }

  test("Use DSL to set CSS tag") {
    val node = tag.Input()
      .id("test")
      .`type`("checkbox")

    val nodeRef = NodeRef[tag.Input]("test")

    val updated = node.update(nodeRef.css(true, "a"))
    assert(updated == node.`class`("a"))
  }

  test("Use DSL to remove CSS tag") {
    val node = tag.Input()
      .id("test")
      .`type`("checkbox")
      .`class`("a b c")

    val nodeRef = NodeRef[tag.Input]("test")

    val updated = node.update(nodeRef.css(false, "b"))
    assert(updated == node.`class`("a c"))
  }

  test("Match by tag") {
    val node = tag.Div(children = List(tag.Span()))
    val ref = NodeRef(tag.Span())
    val updated = node.update(ref := tag.B())

    assert(updated ==
      tag.Div(children = List(tag.Span(children = List(tag.B())))))
  }

  test("Replace node") {
    val node = tag.Div(children = List(tag.Span()))
    val ref = NodeRef(tag.Span())
    val updated = node.update(ref.replace(tag.B()))

    assert(updated == tag.Div(children = List(tag.B())))
  }

  test("Resolve child references") {
    case class Item(id: Int, name: String)
    implicit def itemId: Id[Item] = Id(_.id.toString)

    val itemRef = NodeRef[tag.Div]("item")
    assert(itemRef(Item(0, "test")) == NodeRef[tag.Div]("item0"))
  }
}
