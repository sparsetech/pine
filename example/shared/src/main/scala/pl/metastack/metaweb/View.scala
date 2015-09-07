package pl.metastack.metaweb

trait View {
  val view: state.Node
}

object View {
  def apply(node: state.Node): View = new View {
    val view = node
  }
}
