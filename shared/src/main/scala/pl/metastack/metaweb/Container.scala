package pl.metastack.metaweb

trait Container extends Node {
  def children: Seq[Node]

  def find(f: Node => Boolean): Option[Node] = {
    if (f(this)) Some(this)
    else {
      for (child <- children) {
        if (f(child)) return Some(child)
        else child match {
          case c: Container =>
            val result = c.find(f)
            if (result.nonEmpty) return result

          case _ =>
        }
      }

      None
    }
  }
}
