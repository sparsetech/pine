package pl.metastack.metaweb

import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExport

object Router extends js.JSApp {
  def render(page: View) {
    dom.document.body.clear()
    dom.document.body.appendChild(page.view.toDom)
  }

  def dispatch(url: String) {
    val path = url.split('#').last
    if (path == "/numberguess") render(new numberguess.View())
    else if (path == "/") render(new events.View())
    else render(View(html"<h1>Page Not Found</h1>"))
  }

  @JSExport
  def main() {
    dom.window.onhashchange = { (e: dom.HashChangeEvent) => dispatch(e.newURL) }
    if (dom.window.location.hash.isEmpty) dom.window.location.hash = "/"
    else dispatch(dom.window.location.hash)
  }
}
