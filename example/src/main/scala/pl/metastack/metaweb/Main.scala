package pl.metastack.metaweb

import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExport

import pl.metastack.metarx.Var

object Test extends js.JSApp {
  @JSExport
  def main() {
    val v = Var("")

    val body =
      html"""
       <div>
         <h1>MetaWeb example</h1>
         <input type="text" value=$v />
         <button id="submit">Validate</button>
       </div>
      """

    v := "Hello World"
    dom.document.body.appendChild(body.toDom)
  }
}
