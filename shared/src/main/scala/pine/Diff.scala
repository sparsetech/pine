package pine

/** A Diff defines a tree modification */
sealed trait Diff
object Diff {
  case class SetAttribute(name: String, value: String) extends Diff
  case class RemoveAttribute(name: String) extends Diff
  case class UpdateAttribute(name: String,
                             f: Option[String] => Option[String]) extends Diff
  case class Replace(nodes: List[Node]) extends Diff
  case class SetChildren(children: List[Node]) extends Diff
  case class PrependChildren(children: List[Node]) extends Diff
  case class AppendChildren(children: List[Node]) extends Diff
  case class InsertAt(position: Int, children: List[Node]) extends Diff
  case class RemoveNode() extends Diff
}
