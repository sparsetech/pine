package pl.metastack.metaweb.numberguess

import pl.metastack.metarx.Var

import scala.util.Random

// Separate business logic from rendering for better testability.
class Model {
  val Max = 50

  val solution = Var(0)
  val guesses = Var(0)
  val solved = Var(false)
  val message = Var("")

  reset()

  def reset() {
    solution := new Random().nextInt(Max)
    guesses := 0
    message := s"Guess a number between 0 and $Max."
    solved := false
  }

  def guess(guess: Int) {
    guesses.update(_ + 1)
    guess match {
      case _ if guess < 0 || guess > Max =>
        message := s"Please enter a valid number between 0 and $Max."
      case _ if guess < solution.get =>
        message := s"$guess is too low, try a higher number!"
      case _ if guess > solution.get =>
        message := s"$guess is too high, try a lower number!"
      case _ =>
        message := s"$guess is correct! You got it in ${guesses.get} tries!"
        solved := true
    }
  }
}
