package pl.metastack.metaweb

trait PlatformSupport extends DOM.Extensions {
  implicit class NodeToDom(node: tree.Node) {
    def toDom = DOM.render(node)
  }
}
