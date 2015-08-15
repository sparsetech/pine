package pl.metastack.metaweb

trait View {
  val view: tree.Node
}

object View {
  def apply(node: tree.Node): View = new View {
    val view = node
  }
}
