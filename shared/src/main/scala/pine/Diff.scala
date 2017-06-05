package pine

/** A Diff defines change operations */
sealed trait Diff
object Diff {
  case class SetAttribute[T <: Singleton, U](node: TagRef[T], attribute: Attribute[T, _, U], value: U) extends Diff
  case class UpdateAttribute[T <: Singleton, U](node: TagRef[T], attribute: Attribute[T, U, _], f: U => U) extends Diff
  case class RemoveAttribute[T <: Singleton](node: TagRef[T], attribute: Attribute[T, _, _]) extends Diff
  case class Replace[T <: Singleton](node: TagRef[T], replacement: Node) extends Diff
  case class ReplaceChildren[T <: Singleton](node: TagRef[T], children: List[Node]) extends Diff
  case class PrependChild[T <: Singleton](node: TagRef[T], child: Node) extends Diff
  case class AppendChild[T <: Singleton](node: TagRef[T], child: Node) extends Diff
  case class RemoveChild[T <: Singleton](node: TagRef[T]) extends Diff
}
