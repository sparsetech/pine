package pl.metastack.metaweb.numberguess

import scalajs.js

import pl.metastack.metarx._

import pl.metastack.metaweb
import pl.metastack.metaweb._

class View extends ViewBase {
  val model: Model = new Model

  // TODO These functions must request an `EventContext` implicit, so that
  // dispose() can be called automatically on the channels when the page changes.
  input.attribute("disabled").asInstanceOf[Var[Boolean]].subscribe(model.solved)
  guess.attribute("disabled").asInstanceOf[Var[Boolean]].subscribe(model.solved)
  input.attribute("value").subscribe(model.solved.collect {
    case true => ""
  })
  message.subscribe(model.message)

  form.onsubmit { e =>
    model.guess(input.getAttribute("value").get.asInstanceOf[String].toInt)
    input.focus()
    input.select()
    e.asInstanceOf[js.Dynamic].preventDefault()
  }

  reset.onclick { _ =>
    model.reset()
  }
}
