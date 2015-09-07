package pl.metastack.metaweb.numberguess

import pl.metastack.metaweb
import pl.metastack.metaweb._

trait ViewBase extends metaweb.View {
  val view = html1("shared/src/main/html/NumberGuess.html")

  val form = view.byId[state.oneway.Tag]("form")
  val input = view.byId[state.oneway.Tag]("input")
  val message = view.byId[state.oneway.Tag]("message")
  val guess = view.byId[state.oneway.Tag]("guess")
  val reset = view.byId[state.oneway.Tag]("reset")
}
