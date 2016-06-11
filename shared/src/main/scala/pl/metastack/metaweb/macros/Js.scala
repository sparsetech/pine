package pl.metastack.metaweb.macros

import scala.reflect.macros.blackbox.Context
import scala.language.experimental.macros
import scala.annotation.StaticAnnotation
import scala.annotation.compileTimeOnly

@compileTimeOnly("Enable macro paradise to expand macro annotations")
class Js extends StaticAnnotation {
  def macroTransform(annottees: Any*): Any = macro Js.impl
}

object Js {
  def impl(c: Context)(annottees: c.Expr[Any]*): c.Expr[Any] = {
    import c.universe._

    val isScalaJs = try {
      c.typecheck(q"scala.scalajs.js.Any")
      true
    } catch { case t: Throwable =>
      false
    }

    val result = annottees.map(_.tree) match {
      case q"$mods val $name = $body" :: Nil =>
        if (!isScalaJs) q"" else q"$mods val $name = $body"

      case q"$mods var $name = $body" :: Nil =>
        if (!isScalaJs) q"" else q"$mods var $name = $body"

      case q"object $objectName extends ..$bases { ..$body }" :: Nil =>
        val myBody = if (isScalaJs) body else Seq.empty
        q"object $objectName extends ..$bases { ..$myBody }"

      case q"$mods class $className(..$fields) extends ..$bases { ..$body }" :: Nil =>
        val myBody = if (isScalaJs) body else Seq.empty
        q"$mods class $className(..$fields) extends ..$bases { ..$myBody }"

      case q"$mods trait $traitName extends ..$bases { $selfType => ..$body }" :: Nil =>
        val myBody = if (isScalaJs) body else Seq.empty
        q"$mods trait $traitName extends ..$bases { $selfType => ..$myBody }"

      case q"$mods def $methodName[..$tpes](...$args): $returnType = { ..$body }" :: Nil =>
        val myBody = if (isScalaJs) body else Seq(q"Diff.Noop()")
        q"""$mods def $methodName[..$tpes](...$args): $returnType = { ..$myBody }"""

      case _ => c.abort(c.enclosingPosition, "@Js cannot be used here")
    }

    c.Expr[Any](result)
  }
}
