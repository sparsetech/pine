package pl.metastack.metaweb.page

import pl.metastack.metaweb.diff.{Diff, NodeRef}
import pl.metastack.metaweb.{NumberGuess => NG, _}
import pl.metastack.metaweb.macros.Js

import scala.concurrent.Future
import scala.util.Try

class NumberGuess extends Page with Routing {
  val input   = NodeRef[tag.Input]("input")
  val guess   = NodeRef[tag.Button]("guess")
  val message = NodeRef[tag.H5]("message")
  val form    = NodeRef[tag.Form]("form")
  val reset   = NodeRef[tag.Button]("reset")

  override def title: String = "Number guess"
  override def service() = MyService
  override def node(): Future[tree.Node] = Templates.NumberGuess

  @Js override def register(): Diff =
    super.register() :+
    form.submit.subscribe { e =>
      e.preventDefault()
      Try(input.dom.value.toInt).toOption
        .fold[Diff](Diff.Noop())(formSubmit)
    } :+
    reset.click.subscribe(_ => request(NG.Request.Reset()))

  override def populate(): Diff = request(NG.Request.Reset())

  override def response(): Response => Diff = {
    case NG.Response.Reset(msg) =>
      setSolved(false) :+ resetInput() :+ setMessage(msg)
    case NG.Response.Guess(solved, msg) => setSolved(solved) :+ setMessage(msg)
  }

  def formSubmit(guess: Int): Diff =
    request(NG.Request.Guess(guess)) :+ focusInput()

  @Js def focusInput(): Diff = Diff.Effect {
    input.dom.focus()
    input.dom.select()
  }

  @Js def setSolved(value: Boolean): Diff = Diff.Effect {
    input.dom.disabled = value
    guess.dom.disabled = value
  }

  @Js def resetInput(): Diff = Diff.Effect(input.dom.value = "0")

  def setMessage(value: String): Diff = message := value
}
