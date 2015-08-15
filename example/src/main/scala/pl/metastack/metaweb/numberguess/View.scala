package pl.metastack.metaweb.numberguess

import pl.metastack.metaweb
import pl.metastack.metaweb._

class View(model: Model = new Model) extends metaweb.View {
  val view = html("src/main/html/NumberGuess.html")

  val form = view.byId[tag.form]("form")
  val input = view.byId[tag.input]("input")
  val message = view.byId[tag.h5]("message")
  val btnGuess = view.byId[tag.button]("guess")
  val btnReset = view.byId[tag.button]("reset")

  form.onsubmit { _ =>
    model.guess(input.value.get.toInt)
    input.focus()
    input.select()
  }

  btnReset.onclick { _ =>
    model.reset()
  }

  // TODO attach() must ask for EventContext, so that dispose() can be called
  // automatically when the page changes
  model.solved.attach { solved =>
    btnGuess.disabled(solved)
    input.disabled(solved)

    if (solved) input.value("")
  }

  model.message.attach(message := _)
}
