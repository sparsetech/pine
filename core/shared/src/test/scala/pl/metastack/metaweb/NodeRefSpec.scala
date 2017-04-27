package pl.metastack.metaweb

import org.scalatest.AsyncFunSuite

import pl.metastack.metaweb.dsl._
import pl.metastack.metaweb.diff.NodeRef

class NodeRefSpec extends AsyncFunSuite {
  test("Use DSL to set boolean attribute to true") {
    val node = tag.Input()
      .id("test")

    val nodeRef = NodeRef[tag.Input]("test")

    assert(!node.checked)

    val updated = diff.render.Tree.RenderNode.render(node, nodeRef.checked.update(!_))
    updated.map { n =>
      assert(n == node.checked(true))
    }
  }

  test("Use DSL to set boolean attribute to false") {
    val node = tag.Input()
      .id("test")
      .checked(true)

    val nodeRef = NodeRef[tag.Input]("test")

    assert(node.checked)

    val updated = diff.render.Tree.RenderNode.render(node, nodeRef.checked.update(!_))
    updated.map { n =>
      assert(n == node.checked(false))
    }
  }

  test("Use DSL to set CSS tag") {
    val node = tag.Input()
      .id("test")
      .`type`("checkbox")

    val nodeRef = NodeRef[tag.Input]("test")

    val updated = diff.render.Tree.RenderNode.render(node, nodeRef.css(true, "a"))
    updated.map { n =>
      assert(n == node.`class`("a"))
    }
  }

  test("Use DSL to remove CSS tag") {
    val node = tag.Input()
      .id("test")
      .`type`("checkbox")
      .`class`("a b c")

    val nodeRef = NodeRef[tag.Input]("test")

    val updated = diff.render.Tree.RenderNode.render(node, nodeRef.css(false, "b"))
    updated.map { n =>
      assert(n == node.`class`("a c"))
    }
  }
}
