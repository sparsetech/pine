package pl.metastack.metaweb.tree

import pl.metastack.metaweb

case class Text(text: String) extends metaweb.Text with Node {
  override def state: metaweb.state.Text = {
    val target = new metaweb.state.Text
    target.set(text)
    target
  }
}
