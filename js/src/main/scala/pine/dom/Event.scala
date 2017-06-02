package pine.dom

import org.scalajs.dom

import scala.scalajs.js

class Event[T <: dom.Event](setF: js.Function1[T, _] => Unit) {
  def set(f: => Unit): Unit = set((_: T) => f)
  def set(f: T => Unit): Unit = setF(f)

  def detach(): Unit = setF(null)

  def :=(diff: => Unit): Unit = set(diff)
  def :=(diff: T => Unit): Unit = set(diff)
}
