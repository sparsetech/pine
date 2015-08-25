package pl.metastack.metaweb.numberguess

import pl.metastack.metaweb
import pl.metastack.metaweb._

class View(model: Model = new Model) extends metaweb.View {
  val view = htmlMutable"""
<html>
<body>
<h1>Number Guess Example</h1>
<h5 id="message"></h5>
<form id="form" onsubmit="${(_: Any) => onsubmit()}">
	<input type="number" id="input" disabled=${model.solved} />
	<button type="submit" id="guess" disabled=${model.solved}>Guess</button>
	<button id="reset" onclick=${(_: Any) => model.reset()}>Reset</button>
</form>
<a href="#/">Back to index</a>
</body>
</html>"""

  val input = view.byId[tag.input]("input")
  val message = view.byId[tag.h5]("message")

  def onsubmit() {
    model.guess(input.value.get.toInt)
    input.focus()
    input.select()
  }

  // TODO attach() must ask for EventContext, so that dispose() can be called
  // automatically when the page changes
  model.solved.attach { solved =>
    if (solved) input.value("")
  }

  model.message.attach(message := _)
}

class ViewFile(model: Model = new Model) extends metaweb.View {
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

  model.solved.attach { solved =>
    btnGuess.disabled(solved)
    input.disabled(solved)

    if (solved) input.value("")
  }

  model.message.attach(message := _)
}
