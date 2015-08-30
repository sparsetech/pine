package pl.metastack.metaweb.numberguess

import pl.metastack.metaweb
import pl.metastack.metaweb._

class View(model: Model = new Model) extends metaweb.View {
  val view = html1("src/main/html/NumberGuess.html")

  val form = view.byId[state.oneway.Tag]("form")
  val input = view.byId[state.oneway.Tag]("input")
  val message = view.byId[state.oneway.Tag]("message")
  val guess = view.byId[state.oneway.Tag]("guess")
  val reset = view.byId[state.oneway.Tag]("reset")

  // TODO These functions must request an `EventContext` implicit, so that
  // dispose() can be called automatically on the channels when the page changes.
  input.subscribeAttribute("disabled", model.solved)
  guess.subscribeAttribute("disabled", model.solved)
  input.subscribeAttribute("value", model.solved.collect {
    case true => ""
  })
  message.subscribe(model.message)

  form.onsubmit { _ =>
    model.guess(input.getAttribute("value").get.asInstanceOf[String].toInt)
    input.focus()
    input.select()
  }

  reset.onclick { _ =>
    model.reset()
  }
}
