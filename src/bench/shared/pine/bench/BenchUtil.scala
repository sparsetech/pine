package pine.bench

import pine._

object BenchUtil {
  def binaryTree(depth: Int): Node =
    if (depth == 0) tag.Span // empty leaf
    else tag.Div
      .append(binaryTree(depth - 1))
      .append(binaryTree(depth - 1))

  def binaryTreeMacro(depth: Int): Node =
    if (depth == 0) html"""<span/>""" // empty leaf
    else html"""<div>${binaryTree(depth - 1)}${binaryTree(depth - 1)}</div>"""

  def binaryTreeWithAttribute(depth: Int): Node =
    if (depth == 0) tag.Span.setAttr("attr", "value")
    else tag.Div
      .append(binaryTree(depth - 1))
      .append(binaryTree(depth - 1))

  def binaryTreeWithAttributesMacro(depth: Int): Node =
    if (depth == 0) html"""<span attr="value"/>""" // empty leaf
    else html"""<div>${binaryTree(depth - 1)}${binaryTree(depth - 1)}</div>"""

  /** @return total number of nodes in binary tree, including leaves */
  @inline def numberOfNodes(depth: Int): Long = (1L << (depth + 1)) - 1
}
