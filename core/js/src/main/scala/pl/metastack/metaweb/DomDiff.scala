package pl.metastack.metaweb

import pl.metastack.metaweb.diff.Diff

import scala.scalajs.js

sealed trait DomDiff
object DomDiff {
  case class SubscribeEvent[T <: org.scalajs.dom.Event](set: js.Function1[T, _] => Unit, f: T => Diff) extends DomDiff
  case class UnsubscribeEvent[T <: org.scalajs.dom.Event](set: js.Function1[T, _] => Unit) extends DomDiff
}
