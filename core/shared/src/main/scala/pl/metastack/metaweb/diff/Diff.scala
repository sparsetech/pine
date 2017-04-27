package pl.metastack.metaweb.diff

import pl.metastack.metaweb._

/** A Diff defines change operations */
trait Diff {
  def :+(other: Diff): Diff = Diff.Sequence(this, other)
}

object Diff {
  def apply(diffs: Diff*): Diff =
    diffs.headOption match {
      case None => Noop()
      case Some(head) => Sequence(head, diffs.tail: _*)
    }

  def fromSeq(diffs: Seq[Diff]): Diff = apply(diffs :_*)

  case class Noop() extends Diff
  case class Sequence(left: Diff, right: Diff*) extends Diff
  case class SetAttribute[T <: tree.Tag, U](node: NodeRef[T], attribute: Attribute[T, _, U], value: U) extends Diff
  case class UpdateAttribute[T <: tree.Tag, U](node: NodeRef[T], attribute: Attribute[T, U, _], f: U => U) extends Diff
  case class RemoveAttribute[T <: tree.Tag](node: NodeRef[T], attribute: Attribute[T, _, _]) extends Diff
  case class ReplaceChildren[T <: tree.Tag](node: NodeRef[T], children: Seq[tree.Node]) extends Diff
  case class PrependChild[T <: tree.Tag](node: NodeRef[T], child: tree.Node) extends Diff
  case class AppendChild[T <: tree.Tag](node: NodeRef[T], child: tree.Node) extends Diff
  case class RemoveChild[T <: tree.Tag](node: NodeRef[T]) extends Diff
}
