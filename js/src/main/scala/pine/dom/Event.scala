package pine.dom

import org.scalajs.dom

import scala.scalajs.js

class Event[T <: dom.Event](set: js.Function1[T, _] => Unit) {
  def set(f: => Unit): Diff = Diff.SetEvent(set, (_: T) => f)
  def set(f: T => Unit): Diff = Diff.SetEvent(set, f)

  def detach(): Diff = Diff.DetachEvent(set)

  def :=(diff: => Unit): Diff = set(diff)
  def :=(diff: T => Unit): Diff = set(diff)
}
