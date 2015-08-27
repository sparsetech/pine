package pl.metastack.metaweb

trait Actions {
  /* TODO Import actions from MDN */
  implicit class TagActions(tag: state.Tag) {
    def focus() {
      tag.triggerAction("focus")
    }

    def select() {
      tag.triggerAction("select")
    }

    def click() {
      tag.triggerAction("click")
    }
  }
}
