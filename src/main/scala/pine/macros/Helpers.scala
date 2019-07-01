package pine.macros

import java.io.File

import scala.reflect.macros.blackbox.Context

object Helpers {
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

  def readFile(file: File): String = {
    val source = io.Source.fromFile(file)
    try source.mkString finally source.close()
  }
}
