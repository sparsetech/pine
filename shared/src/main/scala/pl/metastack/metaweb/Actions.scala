package pl.metastack.metaweb

trait Actions {
  /* TODO Import actions from MDN */
  implicit class InputActions(input: tag.input) {
    def focus() {
      input.triggerAction("focus", null)
    }

    def select() {
      input.triggerAction("select", null)
    }
  }
}
