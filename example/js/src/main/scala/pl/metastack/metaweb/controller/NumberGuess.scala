package pl.metastack.metaweb.controller

import pl.metastack.metaweb
import pl.metastack.metaweb._
import pl.metastack.metaweb.model.RemoteModel

import scala.scalajs.js

class NumberGuess(val view: metaweb.view.NumberGuess) {
  val model = new RemoteModel

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
