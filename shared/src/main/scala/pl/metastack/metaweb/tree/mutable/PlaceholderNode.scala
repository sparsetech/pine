package pl.metastack.metaweb.tree.mutable

import pl.metastack.metarx.{Channel, DeltaBuffer, ReadChannel}

import pl.metastack.metaweb.tree

case class PlaceholderNode(channel: ReadChannel[tree.Node]) extends Node {
  val node = channel.cache

  override val changes = channel.flatMap[Unit] {
    case mutable: Node => mutable.changes
    case _ => Channel()
  }

  override def copy(): Node = PlaceholderNode(channel)
  override def toHtml: String = node.get.map(_.toHtml).getOrElse("")
}

case class PlaceholderOptNode(channel: ReadChannel[Option[tree.Node]]) extends Node {
  val node = channel.cache(None)

  override val changes = channel.flatMap[Unit] {
    case Some(n: Node) if n.isInstanceOf[Node] => n.changes
    case _ => Channel()
  }

  override def copy(): Node = PlaceholderOptNode(channel)
  override def toHtml: String = node.get.map(_.toHtml).getOrElse("")
}

case class PlaceholderListNode(delta: DeltaBuffer[tree.Node]) extends Node {
  val buffer = delta.buffer

  // TODO Also produce value when children change
  override val changes = delta.changes.map(_ => ())
  override def copy(): Node = PlaceholderListNode(delta)
  override def toHtml: String = buffer.get.map(_.toHtml).mkString("")
}

case class PlaceholderSeqNode(nodes: Seq[tree.Node])
  extends Node with tree.PlaceholderSeqNode
{
  override val changes =
    nodes.foldLeft[ReadChannel[Unit]](Channel[Unit]()) { (acc, cur) =>
      cur match {
        case n: tree.mutable.Node => acc | n.changes
        case _ => acc
      }
    }
  override def copy(): Node = PlaceholderSeqNode(nodes)
  override def toHtml: String = nodes.map(_.toHtml).mkString("")
}
