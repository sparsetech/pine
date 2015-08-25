package pl.metastack.metaweb

trait PlatformSupport extends DOM.Extensions {
  implicit class NodeToDom(node: tree.reactive.Node) {
    def toDom = DOM.render(node)
  }

  implicit class TextToDom(node: tree.reactive.Text) {
    def toDom = DOM.render(node)
  }

  implicit class TagToDom(node: tree.reactive.Tag) {
    def toDom = DOM.render(node)
  }
}
