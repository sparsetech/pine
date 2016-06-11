package pl.metastack.metaweb.service

import scala.concurrent.Future
import scala.util.Random

import pl.metastack.metaweb
import pl.metastack.metaweb.NumberGuess._
import pl.metastack.metaweb.Service

object NumberGuess {
  val Max = 50
}

// Separate business logic from rendering for better testability.
class NumberGuess extends Service[metaweb.Request, metaweb.Response] {
  import NumberGuess._

  var solution = 0
  var guesses  = 0

  override val process: PartialFunction[metaweb.Request, Future[metaweb.Response]] = {
    case Request.Reset()  => Future.successful(reset())
    case Request.Guess(g) => Future.successful(guess(g))
  }

  def reset() = {
    solution = new Random().nextInt(Max)
    guesses  = 0

    val message = s"Guess a number between 0 and $Max."
    Response.Reset(message)
  }

  def guess(guess: Int) = {
    guesses += 1
    guess match {
      case _ if guess < 0 || guess > Max =>
        val message = s"Please enter a valid number between 0 and $Max."
        Response.Guess(solved = false, message)
      case _ if guess < solution =>
        val message = s"$guess is too low, try a higher number!"
        Response.Guess(solved = false, message)
      case _ if guess > solution =>
        val message = s"$guess is too high, try a lower number!"
        Response.Guess(solved = false, message)
      case _ =>
        val message = s"$guess is correct! You got it in $guesses tries!"
        Response.Guess(solved = true, message)
    }
  }
}
