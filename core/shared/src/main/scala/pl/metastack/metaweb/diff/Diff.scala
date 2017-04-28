package pl.metastack.metaweb.diff

import pl.metastack.metaweb._

/** A Diff defines change operations */
sealed trait Diff
object Diff {
  case object Noop extends Diff
  case class SetAttribute[T <: tree.Tag, U](node: NodeRef[T], attribute: Attribute[T, _, U], value: U) extends Diff
  case class UpdateAttribute[T <: tree.Tag, U](node: NodeRef[T], attribute: Attribute[T, U, _], f: U => U) extends Diff
  case class RemoveAttribute[T <: tree.Tag](node: NodeRef[T], attribute: Attribute[T, _, _]) extends Diff
  case class ReplaceChildren[T <: tree.Tag](node: NodeRef[T], children: Seq[tree.Node]) extends Diff
  case class PrependChild[T <: tree.Tag](node: NodeRef[T], child: tree.Node) extends Diff
  case class AppendChild[T <: tree.Tag](node: NodeRef[T], child: tree.Node) extends Diff
  case class RemoveChild[T <: tree.Tag](node: NodeRef[T]) extends Diff
}
