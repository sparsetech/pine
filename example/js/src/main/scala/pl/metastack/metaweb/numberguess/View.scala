package pl.metastack.metaweb.numberguess

import scalajs.js

import pl.metastack.metarx._

import pl.metastack.metaweb
import pl.metastack.metaweb._

class View extends metaweb.View {
  val view = new metaweb.view.NumberGuess
  val model = new Model

  // TODO These functions must request an `EventContext` implicit, so that
  // dispose() can be called automatically on the channels when the page changes.
  view.input.disabled.subscribe(model.solved)
  view.guess.disabled.subscribe(model.solved)
  view.input.value.subscribe(model.solved.collect {
    case true => ""
  })
  view.message.subscribe(model.message)

  view.form.onsubmit { e =>
    model.guess(view.input.value.get.toInt)
    view.input.focus()
    view.input.select()
    e.asInstanceOf[js.Dynamic].preventDefault()
  }

  view.reset.onclick { _ =>
    model.reset()
  }
}
