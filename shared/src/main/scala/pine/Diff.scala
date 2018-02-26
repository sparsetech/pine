package pine

/** A Diff defines change operations */
sealed trait Diff
object Diff {
  case class SetAttribute[T <: Singleton, U](attribute: TagRefAttribute[T, U],
                                             value: U) extends Diff
  case class UpdateAttribute[T <: Singleton, U](attribute: TagRefAttribute[T, U],
                                                f: U => U) extends Diff
  case class RemoveAttribute[T <: Singleton](attribute: TagRefAttribute[T, _]) extends Diff
  case class Replace(nodes: List[Node]) extends Diff
  case class SetChildren(children: List[Node]) extends Diff
  case class PrependChildren(children: List[Node]) extends Diff
  case class AppendChildren(children: List[Node]) extends Diff
  case class InsertAt(position: Int, children: List[Node]) extends Diff
  case class RemoveNode() extends Diff
}
