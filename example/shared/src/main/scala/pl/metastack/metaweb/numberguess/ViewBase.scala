package pl.metastack.metaweb.numberguess

import pl.metastack.metaweb
import pl.metastack.metaweb._

trait ViewBase extends metaweb.View {
  val view = html1("shared/src/main/html/NumberGuess.html")

  val form = view.byId[state.reactive.Tag]("form")
  val input = view.byId[state.reactive.Tag]("input")
  val message = view.byId[state.reactive.Tag]("message")
  val guess = view.byId[state.reactive.Tag]("guess")
  val reset = view.byId[state.reactive.Tag]("reset")
}
