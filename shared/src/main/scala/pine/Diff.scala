package pine

/** A Diff defines change operations */
sealed trait Diff
object Diff {
  case class SetAttribute[T <: Singleton, U](attribute: Attribute[T, _, U], value: U) extends Diff
  case class UpdateAttribute[T <: Singleton, U](attribute: Attribute[T, U, _], f: U => U) extends Diff
  case class RemoveAttribute[T <: Singleton](attribute: Attribute[T, _, _]) extends Diff
  case class Replace(replacement: Node) extends Diff
  case class ReplaceChildren(children: List[Node]) extends Diff
  case class PrependChild(child: Node) extends Diff
  case class AppendChild(child: Node) extends Diff
  case class RemoveChild() extends Diff
}
