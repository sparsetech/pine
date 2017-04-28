package pl.metastack.metaweb

import scala.scalajs.js

class DomEvent[T <: org.scalajs.dom.Event](set: js.Function1[T, _] => Unit) {
  def set(f: => Unit): DomDiff = DomDiff.SetEvent(set, (_: T) => f)
  def set(f: T => Unit): DomDiff = DomDiff.SetEvent(set, f)

  def detach(): DomDiff = DomDiff.DetachEvent(set)

  def :=(diff: => Unit): DomDiff = set(diff)
  def :=(diff: T => Unit): DomDiff = set(diff)
}
