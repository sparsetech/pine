package pl.metastack.metaweb.controller

import pl.metastack.metaweb._

import pl.metastack.metaweb

import scala.collection.mutable
import scala.util.Random

class SessionManager[T] {
  private var sessions = mutable.HashMap.empty[String, T]

  def allocateId(default: T) = {
    val id = System.currentTimeMillis().toString
    sessions += id -> default
    id
  }

  def getData(id: String): T = sessions(id)

  def setData(id: String, data: T) {
    sessions += id -> data
  }
}

case class NumberGuessResult(solution: Int, guesses: Int)
object NumberGuessSessions extends SessionManager[NumberGuessResult]

class NumberGuess extends Protocol.NumberGuess {
  val Max = 50

  def guess(session: String, guess: Int): NumberGuessResponse = {
    val sess = NumberGuessSessions.getData(session)
    NumberGuessSessions.setData(session, sess.copy(guesses = sess.guesses + 1))

    guess match {
      case _ if guess < 0 || guess > Max =>
        NumberGuessResponse(s"Please enter a valid number between 0 and $Max.", solved = false)
      case _ if guess < sess.solution =>
        NumberGuessResponse(s"$guess is too low, try a higher number!", solved = false)
      case _ if guess > sess.solution =>
        NumberGuessResponse(s"$guess is too high, try a lower number!", solved = false)
      case _ =>
        NumberGuessResponse(s"$guess is correct! You got it in ${sess.guesses} tries!", solved = true)
    }
  }

  def requestSession(): String =
    NumberGuessSessions.allocateId(
      NumberGuessResult(new Random().nextInt(Max), 0))
}

object NumberGuess extends metaweb.view.NumberGuess {
  val b = view.byTag[tag.Body]("body")
  b += html"""<script type="text/javascript" src="/sjs/example-fastopt.js"></script>"""
  b += html"""<script type="text/javascript" src="/sjs/example-launcher.js"></script>"""
  val html = view.toHtml

  def render(): String = html
}
