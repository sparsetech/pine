package example.service

import scala.concurrent.Future
import scala.util.Random

import example._
import example.{NumberGuess => NG}

object NumberGuess {
  val Max = 50
}

// Separate business logic from rendering for better testability.
class NumberGuess extends Service[Request, Response] {
  import NumberGuess._

  var solution = 0
  var guesses  = 0

  override val process: PartialFunction[Request, Future[Response]] = {
    case NG.Request.Reset()  => Future.successful(reset())
    case NG.Request.Guess(g) => Future.successful(guess(g))
  }

  def reset() = {
    solution = new Random().nextInt(Max)
    guesses  = 0

    val message = s"Guess a number between 0 and $Max."
    NG.Response.Reset(message)
  }

  def guess(guess: Int) = {
    guesses += 1
    guess match {
      case _ if guess < 0 || guess > Max =>
        val message = s"Please enter a valid number between 0 and $Max."
        NG.Response.Guess(solved = false, message)
      case _ if guess < solution =>
        val message = s"$guess is too low, try a higher number!"
        NG.Response.Guess(solved = false, message)
      case _ if guess > solution =>
        val message = s"$guess is too high, try a lower number!"
        NG.Response.Guess(solved = false, message)
      case _ =>
        val message = s"$guess is correct! You got it in $guesses tries!"
        NG.Response.Guess(solved = true, message)
    }
  }
}
