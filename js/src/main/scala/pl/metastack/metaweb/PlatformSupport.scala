package pl.metastack.metaweb

trait PlatformSupport extends DOM.Extensions {
  implicit class NodeToDom(node: tree.Node) {
    def toDom = DOM.render(node)
  }

  implicit class TextToDom(node: tree.Text) {
    def toDom = DOM.render(node)
  }

  implicit class TagToDom(node: tree.Tag) {
    def toDom = DOM.render(node)
  }
}
