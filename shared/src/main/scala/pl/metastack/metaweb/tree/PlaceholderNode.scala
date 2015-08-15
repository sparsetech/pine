package pl.metastack.metaweb.tree

import pl.metastack.metarx.{Channel, DeltaBuffer, ReadChannel}

case class PlaceholderNode(channel: ReadChannel[Node]) extends Node {
  val node = channel.cache

  override val changes = channel.flatMap(_.changes)
  override def copy(): Node = PlaceholderNode(channel)
  override def toHtml: String = node.get.map(_.toHtml).getOrElse("")
}

case class PlaceholderOptNode(channel: ReadChannel[Option[Node]]) extends Node {
  val node = channel.cache(None)

  override val changes = channel.flatMap[Unit] {
    case Some(n) => n.changes
    case None    => Channel()
  }

  override def copy(): Node = PlaceholderOptNode(channel)
  override def toHtml: String = node.get.map(_.toHtml).getOrElse("")
}

case class PlaceholderListNode(delta: DeltaBuffer[Node]) extends Node {
  val buffer = delta.buffer

  // TODO Also produce value when children change
  override val changes = delta.changes.map(_ => ())
  override def copy(): Node = PlaceholderListNode(delta)
  override def toHtml: String = buffer.get.map(_.toHtml).mkString("")
}

case class PlaceholderSeqNode(nodes: Seq[Node]) extends Node {
  override val changes =
    nodes.foldLeft[ReadChannel[Unit]](Channel[Unit]()) { (acc, cur) =>
      acc | cur.changes
    }
  override def copy(): Node = PlaceholderSeqNode(nodes)
  override def toHtml: String = nodes.map(_.toHtml).mkString("")
}
