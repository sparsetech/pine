package pl.metastack.metaweb.state.reactive

import pl.metastack.metarx.{Var, ReadChannel}

import pl.metastack.metaweb.state

class Text extends state.Text with Node {
  private val text = Var("")

  def set(value: String) {
    text := value
  }

  def get: String = text.get

  def listen(ch: ReadChannel[String]) {
    text << ch
  }

  def values: ReadChannel[String] = text
}
