package pine

/** A Diff defines change operations */
sealed trait Diff
object Diff {
  case class SetAttribute[T <: SString, U](node: TagRef[T], attribute: Attribute[T, _, U], value: U) extends Diff
  case class UpdateAttribute[T <: SString, U](node: TagRef[T], attribute: Attribute[T, U, _], f: U => U) extends Diff
  case class RemoveAttribute[T <: SString](node: TagRef[T], attribute: Attribute[T, _, _]) extends Diff
  case class Replace[T <: SString](node: TagRef[T], replacement: Node) extends Diff
  case class ReplaceChildren[T <: SString](node: TagRef[T], children: List[Node]) extends Diff
  case class PrependChild[T <: SString](node: TagRef[T], child: Node) extends Diff
  case class AppendChild[T <: SString](node: TagRef[T], child: Node) extends Diff
  case class RemoveChild[T <: SString](node: TagRef[T]) extends Diff
}
