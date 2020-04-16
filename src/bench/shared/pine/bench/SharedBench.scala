package pine.bench

import pine._
import pine.bench.BenchUtil._

class SharedBench extends BenchmarkSuite with TreeBench {
  bench("Build binary tree via combinators", depths, measureMemory = true) { depth =>
    val tree = binaryTree(depth).asInstanceOf[Tag[Singleton]]
    numberOfNodes(depth) -> tree
  }

  bench("Build binary tree via macros", depths, measureMemory = true) { depth =>
    val tree = binaryTreeMacro(depth).asInstanceOf[Tag[Singleton]]
    numberOfNodes(depth) -> tree
  }

  bench("Build binary tree with attributes via combinators", depths, measureMemory = true) { depth =>
    val tree = binaryTreeWithAttribute(depth).asInstanceOf[Tag[Singleton]]
    numberOfNodes(depth) -> tree
  }

  bench("Build binary tree with attributes via macros", depths, measureMemory = true) { depth =>
    val tree = binaryTreeWithAttributesMacro(depth).asInstanceOf[Tag[Singleton]]
    numberOfNodes(depth) -> tree
  }

  bench("Modify tree via map()", depths, measureMemory = false) { depth =>
    numberOfNodes(depth) -> treesWoAttributes(depth).map {
      case t @ Tag("span", _, _) => t.set("test")
      case n => n
    }
  }

  bench("Modify tree via TagRef", depths, measureMemory = false) { depth =>
    val ref = TagRef.ByTag("span").each
    numberOfNodes(depth) -> treesWoAttributes(depth).update { implicit ctx => ref := "test" }
  }

  bench("Generate HTML w/o attributes", depths, measureMemory = false) { depth =>
    numberOfNodes(depth) -> treesWoAttributes(depth).toHtml
  }

  bench("Generate HTML w/ attributes", depths, measureMemory = false) { depth =>
    numberOfNodes(depth) -> treesWithAttributes(depth).toHtml
  }

  bench("Parse HTML w/o attributes", depths, measureMemory = false) { depth =>
    numberOfNodes(depth) -> internal.HtmlParser.fromString(htmlTreesWoAttributes(depth), xml = false)
  }

  bench("Parse HTML w/ attributes", depths, measureMemory = false) { depth =>
    numberOfNodes(depth) -> internal.HtmlParser.fromString(htmlTreesWithAttributes(depth), xml = false)
  }
}
