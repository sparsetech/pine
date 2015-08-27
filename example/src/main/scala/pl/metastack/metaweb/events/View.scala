package pl.metastack.metaweb.events

import org.scalajs.dom

import pl.metastack.metarx.{Channel, Var}

import pl.metastack.metaweb
import pl.metastack.metaweb._

class View extends metaweb.View {
  def replace(event: dom.MouseEvent, v: Var[String]) {
    v := "Coordinates: " + (event.clientX, event.clientY)
  }

  val v = Var("")

  val view =
    html2"""
       <div>
         <h1>MetaWeb example</h1>
         <input id="text" type="text" />
         <button onclick="${(e: dom.MouseEvent) => replace(e, v)}">Replace</button><br />
         <a href="#/numberguess">Number guess</a>
       </div>
      """

  view.byId[state.twoway.Tag]("text")
    .bindAttribute("value", v.asInstanceOf[Channel[Any]])
}
