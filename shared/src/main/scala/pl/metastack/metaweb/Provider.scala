package pl.metastack.metaweb

import scala.collection.mutable

/** TODO Move to MetaRx */
case class Provider[A, B]() {
  val subscriptions = mutable.ArrayBuffer.empty[PartialFunction[A, B]]

  def register(f: PartialFunction[A, B]) {
    subscriptions += f
  }

  def unregister(f: PartialFunction[A, B]) {
    subscriptions -= f
  }

  def poll(input: A): Option[B] = {
    subscriptions.toList match {
      case head :: tail =>
        tail.foldLeft(head) { case (acc, cur) =>
          acc.orElse(cur)
        }.lift(input)

      case _ => None
    }
  }
}
