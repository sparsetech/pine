package pl.metastack.metaweb.macros

import scala.language.experimental.macros
import scala.language.reflectiveCalls

import scala.reflect.macros.blackbox.Context

import pl.metastack.metaweb.tree
import pl.metastack.metaweb.state

import scala.xml.NamespaceBinding

object Helpers {
  def namespaceBinding(scope: NamespaceBinding): Map[String, String] =
    if (scope == null || scope.prefix == null) Map.empty
    else Map(s"xmlns:${scope.prefix}" -> scope.uri) ++
      namespaceBinding(scope.parent)

  def literalValueTree[T](c: Context)(tree: c.Tree): T = {
    import c.universe._
    tree match {
      case Literal(Constant(value: T)) => value
      case _ =>
        c.error(c.enclosingPosition, "Literal expected")
        throw new RuntimeException()
    }
  }

  def literalValueExpr[T](c: Context)(expr: c.Expr[T]): T =
    literalValueTree[T](c)(expr.tree)

  def treeToState(c: Context)(node: c.Expr[tree.Tag],
                              way: Int): c.Expr[state.Tag] = {
    import c.universe._

    val wayObj = TermName(
      if (way == 0) "ZeroWay"
      else if (way == 1) "OneWay"
      else "TwoWay")

    val ns = TermName(
      if (way == 0) "zeroway"
      else if (way == 1) "oneway"
      else "twoway")

    c.Expr(q"""
      import pl.metastack.metaweb
      $node.state(metaweb.state.$wayObj).asInstanceOf[state.$ns.Tag]
    """)
  }
}
