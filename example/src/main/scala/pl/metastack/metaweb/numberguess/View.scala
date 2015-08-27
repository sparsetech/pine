package pl.metastack.metaweb.numberguess

import pl.metastack.metarx.Channel

import pl.metastack.metaweb
import pl.metastack.metaweb._

class View(model: Model = new Model) extends metaweb.View {
  val view = html2("src/main/html/NumberGuess.html")

  val form = view.byId[state.twoway.Tag]("form")
  val input = view.byId[state.twoway.Tag]("input")
  val message = view.byId[state.twoway.Tag]("message")
  val guess = view.byId[state.twoway.Tag]("guess")
  val reset = view.byId[state.twoway.Tag]("reset")

  input.bindAttribute("disabled", model.solved.asInstanceOf[Channel[Any]])
  guess.bindAttribute("disabled", model.solved.asInstanceOf[Channel[Any]])

  form.onsubmit { _ =>
    model.guess(input.getAttribute("value").get.asInstanceOf[String].toInt)
    input.focus()
    input.select()
  }

  reset.onclick { _ =>
    model.reset()
  }

  // TODO attach() must ask for EventContext, so that dispose() can be called
  // automatically when the page changes
  model.solved.attach { solved =>
    if (solved) input.setAttribute("value", "")
  }

  model.message.attach(message := _)
}
