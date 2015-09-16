package pl.metastack.metaweb.numberguess

import scalajs.js

import pl.metastack.metarx._

import pl.metastack.metaweb
import pl.metastack.metaweb._

class View extends metaweb.view.NumberGuess with metaweb.View {
  val model = new RemoteModel

  // TODO These functions must request an `EventContext` implicit, so that
  // dispose() can be called automatically on the channels when the page changes.
  input.disabled.subscribe(model.solved)
  guess.disabled.subscribe(model.solved)
  input.value.subscribe(model.solved.collect {
    case true => ""
  })
  message.subscribe(model.message)

  form.onsubmit { e =>
    model.guess(input.value.get.toInt)
    input.focus()
    input.select()
    e.asInstanceOf[js.Dynamic].preventDefault()
  }

  reset.onclick { _ =>
    model.reset()
  }
}
