package pl.metastack.metaweb.macros

import scala.language.experimental.macros
import scala.language.reflectiveCalls
import scala.reflect.macros.blackbox.Context

object Helpers {
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
}
