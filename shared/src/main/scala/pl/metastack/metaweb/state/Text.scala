package pl.metastack.metaweb.state

import pl.metastack.metaweb
import pl.metastack.metarx.{ReadChannel, Var}

class Text extends metaweb.Text with Node {
  private val _text = Var("")

  def set(value: String) {
    _text := value
  }

  def text: String = _text.get

  def listen(ch: ReadChannel[String]) {
    _text << ch
  }

  def values: ReadChannel[String] = _text
}
