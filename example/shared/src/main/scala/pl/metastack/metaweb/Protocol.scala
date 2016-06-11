package pl.metastack.metaweb

import cats.data.Xor
import io.circe._, io.circe.generic.auto._, io.circe.parser._, io.circe.syntax._
import io.circe.generic.JsonCodec

// TODO Separate Request, Response for NumberGuess, etc.

@JsonCodec sealed trait Request
@JsonCodec sealed trait Response

object NumberGuess {
  object Request {
    case class Reset() extends Request
    case class Guess(guess: Int) extends Request
  }

  object Response {
    case class Reset(message: String) extends Response
    case class Guess(solved: Boolean, message: String) extends Response
  }
}

@JsonCodec case class BookListItem(id: Int, title: String)
@JsonCodec case class BookDetails(id: Int, title: String, author: String, price: Double)

object Books {
  object Request {
    case class List() extends Request
    case class Details(id: Int) extends Request
  }
  object Response {
    case class List(books: Seq[BookListItem]) extends Response
    case class Details(book: Xor[String, BookDetails]) extends Response
  }
}

object Request
object Response
