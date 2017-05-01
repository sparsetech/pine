package pl.metastack.metaweb.dom

import scala.scalajs.js

sealed trait Diff
object Diff {
  case class SetEvent[T <: org.scalajs.dom.Event](set: js.Function1[T, _] => Unit, f: T => Unit) extends Diff
  case class DetachEvent[T <: org.scalajs.dom.Event](set: js.Function1[T, _] => Unit) extends Diff
}
