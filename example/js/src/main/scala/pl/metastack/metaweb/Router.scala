package pl.metastack.metaweb

import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExport

object Router extends js.JSApp {
  def render(page: View) {
    dom.document.body.clear()
    page.view.toDom.foreach(dom.document.body.appendChild)
  }

  @JSExport
  def main() {
    render(new numberguess.View())
  }
}
