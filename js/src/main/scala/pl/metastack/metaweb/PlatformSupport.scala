package pl.metastack.metaweb

trait PlatformSupport extends DOM.Extensions {
  implicit class NodeToDom(node: tree.mutable.Node) {
    def toDom = DOM.render(node)
  }

  implicit class TextToDom(node: tree.mutable.Text) {
    def toDom = DOM.render(node)
  }

  implicit class TagToDom(node: tree.mutable.Tag) {
    def toDom = DOM.render(node)
  }
}
