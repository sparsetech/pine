package pl.metastack.metaweb.numberguess

import pl.metastack.metaweb
import pl.metastack.metaweb._

trait ViewBase extends metaweb.View {
  val view = html("shared/src/main/html/NumberGuess.html")

  val form = view.byId[state.Tag]("form")
  val input = view.byId[state.Tag]("input")
  val message = view.byId[state.Tag]("message")
  val guess = view.byId[state.Tag]("guess")
  val reset = view.byId[state.Tag]("reset")
}
