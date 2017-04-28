package pl.metastack.metaweb

import org.scalatest.FunSuite
import pl.metastack.metaweb.dsl._
import pl.metastack.metaweb.diff.{Id, NodeRef}

class NodeRefSpec extends FunSuite {
  test("Use DSL to set boolean attribute to true") {
    val node = tag.Input()
      .id("test")

    val nodeRef = NodeRef[tag.Input]("test")

    assert(!node.checked)

    val updated = diff.render.Tree.RenderNode.render(node, nodeRef.checked.update(!_))
    assert(updated == node.checked(true))
  }

  test("Use DSL to set boolean attribute to false") {
    val node = tag.Input()
      .id("test")
      .checked(true)

    val nodeRef = NodeRef[tag.Input]("test")

    assert(node.checked)

    val updated = diff.render.Tree.RenderNode.render(node, nodeRef.checked.update(!_))
    assert(updated == node.checked(false))
  }

  test("Use DSL to set CSS tag") {
    val node = tag.Input()
      .id("test")
      .`type`("checkbox")

    val nodeRef = NodeRef[tag.Input]("test")

    val updated = diff.render.Tree.RenderNode.render(node, nodeRef.css(true, "a"))
    assert(updated == node.`class`("a"))
  }

  test("Use DSL to remove CSS tag") {
    val node = tag.Input()
      .id("test")
      .`type`("checkbox")
      .`class`("a b c")

    val nodeRef = NodeRef[tag.Input]("test")

    val updated = diff.render.Tree.RenderNode.render(node, nodeRef.css(false, "b"))
    assert(updated == node.`class`("a c"))
  }

  test("Resolve child references") {
    case class Item(id: Int, name: String)
    implicit def itemId: Id[Item] = Id(_.id.toString)

    val itemRef = NodeRef[tag.Div]("item")
    assert(itemRef(Item(0, "test")) == NodeRef[tag.Div]("item0"))
  }
}
