package pine.bench

import scala.scalajs.js

import pine._
import pine.dom._
import pine.bench.BenchUtil._

class PlatformBench extends BenchmarkSuite with TreeBench {
  val isNodeJs = js.isUndefined(org.scalajs.dom.window)

  if (isNodeJs) println("[warn] Ignoring all tests requiring DOM access")
  else {
    bench("Render and update node in DOM", depths, measureMemory = false) { depth =>
      val ref      = TagRef.ByTag("span").each
      val rendered = treesWoAttributes(depth).toDom
      org.scalajs.dom.document.body.appendChild(rendered)
      DOM.render { implicit ctx => ref := "test" }
      org.scalajs.dom.document.body.removeChild(rendered)
      numberOfNodes(depth) -> ()
    }

    bench("Render as DOM node", depths, measureMemory = false) { depth =>
      numberOfNodes(depth) -> treesWithAttributes(depth).toDom
    }
  }
}
