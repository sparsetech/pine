package pl.metastack.metaweb.macros

import scala.language.experimental.macros
import scala.language.reflectiveCalls

import scala.reflect.macros.blackbox.Context

import scala.xml.NamespaceBinding

object Helpers {
  def namespaceBinding(scope: NamespaceBinding): Map[String, String] =
    if (scope == null || scope.prefix == null) Map.empty
    else Map(s"xmlns:${scope.prefix}" -> scope.uri) ++
      namespaceBinding(scope.parent)

  def literalValueTree[T](c: Context)(tree: c.Tree): T = {
    import c.universe._
    tree match {
      case Literal(Constant(value)) => value.asInstanceOf[T]
      case _ =>
        c.error(c.enclosingPosition, "Literal expected")
        throw new RuntimeException()
    }
  }

  def literalValueExpr[T](c: Context)(expr: c.Expr[T]): T =
    literalValueTree[T](c)(expr.tree)
}
