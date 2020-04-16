package pine.bench

import pine._
import pine.bench.BenchUtil._

/**
  * Specifies parameters for tree benchmarks and caches trees to reduce run time
  */
trait TreeBench {
  val depths = (2 to 14 by 4).toList

  val treesWoAttributes = depths.map(d =>
    d -> binaryTree(d).asInstanceOf[Tag[Singleton]]
  ).toMap

  val htmlTreesWoAttributes = treesWoAttributes.view.mapValues(_.toHtml)

  val treesWithAttributes = depths.map(d =>
    d -> binaryTreeWithAttribute(d).asInstanceOf[Tag[Singleton]]
  ).toMap

  val htmlTreesWithAttributes = treesWithAttributes.view.mapValues(_.toHtml)
}
