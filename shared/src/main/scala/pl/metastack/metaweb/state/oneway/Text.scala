package pl.metastack.metaweb.state.oneway

import pl.metastack.metarx.{Var, ReadChannel}

import pl.metastack.metaweb.state

class Text extends state.Text with Node {
  private val text = Var("")

  def ways = 1

  def set(value: String) {
    text := value
  }

  def get: String = text.get

  def listen(ch: ReadChannel[String]) {
    text << ch
  }

  def values: ReadChannel[String] = text
}
