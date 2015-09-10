package pl.metastack.metaweb.state

import pl.metastack.metarx.{Opt, ReadChannel}
import pl.metastack.metaweb

class Placeholder extends metaweb.Placeholder with Node {
  private val _node = Opt[metaweb.Node]()

  def set(value: Option[metaweb.Node]) {
    _node := value
  }

  def node: Option[metaweb.Node] = _node.get

  def values: ReadChannel[Option[metaweb.Node]] = _node

  def listen(ch: ReadChannel[Option[metaweb.Node]]) {
    _node << ch
  }
}
