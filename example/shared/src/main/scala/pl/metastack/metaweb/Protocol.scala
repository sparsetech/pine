package pl.metastack.metaweb

trait Protocol {
  val numberGuess: Protocol.NumberGuess
}

case class NumberGuessResponse(message: String, solved: Boolean)

object Protocol {
  val Namespace = Seq("pl", "metastack", "metaweb", "Protocol")

  trait NumberGuess {
    def requestSession(): String
    def guess(session: String, answer: Int): NumberGuessResponse
  }
}
