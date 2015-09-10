package pl.metastack.metaweb

trait View {
  val view: Node
}

object View {
  def apply(node: Node): View = new View {
    val view = node
  }
}
