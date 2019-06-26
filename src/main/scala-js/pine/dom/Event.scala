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

class EventN[T <: dom.Event](nodes: List[dom.Element], setF: (dom.Element, js.Function1[T, _]) => Unit) {
  def set(f: => Unit): Unit = set((_: T) => f)
  def set(f: T => Unit): Unit = nodes.foreach(setF(_, f))

  def detach(): Unit = nodes.foreach(setF(_, null))

  def :=(diff: => Unit): Unit = set(diff)
  def :=(diff: T => Unit): Unit = set(diff)
}

class EventHtml[T <: dom.Event](nodes: List[dom.html.Element], setF: (dom.html.Element, js.Function1[T, _]) => Unit) {
  def set(f: => Unit): Unit = set((_: T) => f)
  def set(f: T => Unit): Unit = nodes.foreach(setF(_, f))

  def detach(): Unit = nodes.foreach(setF(_, null))

  def :=(diff: => Unit): Unit = set(diff)
  def :=(diff: T => Unit): Unit = set(diff)
}
