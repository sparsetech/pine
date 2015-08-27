package pl.metastack.metaweb.tree

import pl.metastack.metaweb
import pl.metastack.metaweb.State

case class Text(text: String) extends Node {
  override def state[T <: metaweb.state.Node](creator: State[T]): T with metaweb.state.Text = {
    val target = creator.text()
    target.set(text)
    target.asInstanceOf[T with metaweb.state.Text]
  }
}
