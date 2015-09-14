package pl.metastack.metaweb.numberguess

import pl.metastack.metarx.Var

import pl.metastack.metaweb.ServerOps
import pl.metastack.metaweb.NumberGuessResponse

import scala.concurrent.ExecutionContext.Implicits.global

class RemoteModel {
  val Max = 50

  val session = Var("")
  val guesses = Var(0)
  val solved = Var(false)
  val message = Var("")

  reset()

  def reset() {
    ServerOps.NumberGuess.requestSession().foreach(session := _)
    guesses := 0
    message := s"Guess a number between 0 and $Max."
    solved := false
  }

  def guess(guess: Int) {
    ServerOps.NumberGuess.guess(session.get, guess).foreach {
      case NumberGuessResponse(msg, slvd) =>
        message := msg
        solved := slvd
    }
  }
}
