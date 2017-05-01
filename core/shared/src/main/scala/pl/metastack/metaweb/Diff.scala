package pl.metastack.metaweb

case class Id[T](f: T => String)

/** A Diff defines change operations */
sealed trait Diff
object Diff {
  case object Noop extends Diff
  case class SetAttribute[T <: Tag, U](node: TagRef[T], attribute: Attribute[T, _, U], value: U) extends Diff
  case class UpdateAttribute[T <: Tag, U](node: TagRef[T], attribute: Attribute[T, U, _], f: U => U) extends Diff
  case class RemoveAttribute[T <: Tag](node: TagRef[T], attribute: Attribute[T, _, _]) extends Diff
  case class Replace[T <: Tag](node: TagRef[T], replacement: Node) extends Diff
  case class ReplaceChildren[T <: Tag](node: TagRef[T], children: List[Node]) extends Diff
  case class PrependChild[T <: Tag](node: TagRef[T], child: Node) extends Diff
  case class AppendChild[T <: Tag](node: TagRef[T], child: Node) extends Diff
  case class RemoveChild[T <: Tag](node: TagRef[T]) extends Diff
}
