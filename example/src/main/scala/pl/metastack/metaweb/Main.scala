package pl.metastack.metaweb

import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExport

import pl.metastack.metarx.Var

object Main extends js.JSApp {
  def replace(event: dom.MouseEvent, v: Var[String]) {
    v := "Coordinates: " + (event.clientX, event.clientY)
  }

  @JSExport
  def main() {
    val v = Var("")

    val body =
      html"""
       <div>
         <h1>MetaWeb example</h1>
         <input type="text" value=$v />
         <button onclick="${(e: dom.MouseEvent) => replace(e, v)}">Replace</button>
       </div>
      """

    dom.document.body.appendChild(body.toDom)
  }
}
