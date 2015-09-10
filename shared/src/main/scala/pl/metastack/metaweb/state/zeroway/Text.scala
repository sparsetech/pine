package pl.metastack.metaweb.state.zeroway

import pl.metastack.metaweb.state

class Text extends state.Text with Node {
  private var text = ""

  def set(value: String) {
    text = value
  }

  def get: String = text
}
