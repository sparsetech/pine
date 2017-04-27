package pl.metastack.metaweb

import org.scalatest.FunSuite
import pl.metastack.metaweb.dsl._
import pl.metastack.metaweb.diff.NodeRef

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
}
