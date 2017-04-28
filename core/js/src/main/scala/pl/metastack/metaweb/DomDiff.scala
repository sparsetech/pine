package pl.metastack.metaweb

import pl.metastack.metaweb.diff.Diff

import scala.scalajs.js

sealed trait DomDiff
object DomDiff {
  case class SetEvent[T <: org.scalajs.dom.Event](set: js.Function1[T, _] => Unit, f: T => Diff) extends DomDiff
  case class DetachEvent[T <: org.scalajs.dom.Event](set: js.Function1[T, _] => Unit) extends DomDiff
}
