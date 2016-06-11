package pl.metastack.metaweb.diff

import scala.concurrent.Future

import pl.metastack.metaweb._

/** A Diff defines change operations */
trait Diff {
  def :+(other: Diff): Diff = Diff.Sequence(this, other)
}

object Diff {
  def apply(diffs: Diff*): Diff =
    diffs.headOption match {
      case None => Noop()
      case Some(head) => new Sequence(head, diffs.tail: _*)
    }

  def fromSeq(diffs: Seq[Diff]): Diff = apply(diffs :_*)

  case class Noop() extends Diff
  case class Sequence(left: Diff, right: Diff*) extends Diff
  class Effect(val f: () => Unit) extends Diff
  object Effect { def apply(f: => Unit): Effect = new Effect(() => f) }
  class Map(val f: () => Diff) extends Diff
  object Map { def apply(f: => Diff): Map = new Map(() => f) }
  class Async(val f: () => Future[Diff]) extends Diff
  object Async { def apply(f: => Future[Diff]): Async = new Async(() => f) }
  case class SetAttribute[T <: tree.Tag, U](node: NodeRef[T], attribute: Attribute[T, _, U], value: U) extends Diff
  case class RemoveAttribute[T <: tree.Tag](node: NodeRef[T], attribute: Attribute[T, _, _]) extends Diff
  case class ReplaceChildren[T <: tree.Tag](node: NodeRef[T], children: Seq[View]) extends Diff
  case class PrependChild[T <: tree.Tag](node: NodeRef[T], child: View) extends Diff
  case class AppendChild[T <: tree.Tag](node: NodeRef[T], child: View) extends Diff
  case class RemoveChild[T <: tree.Tag](node: NodeRef[T]) extends Diff
}
