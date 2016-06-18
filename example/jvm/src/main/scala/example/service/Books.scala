package example.service

import scala.concurrent.Future

import cats.data.Xor

import example.Books._
import example.{BookDetails, BookListItem, Service}

object Books {
  case class Book(id: Int, author: String, title: String, price: Double)

  val ScalaBooks = Seq(
    Book(id = 1, author = "Martin Odersky", title = "Programming in Scala", price = 10.0),
    Book(id = 2, author = "Cay S. Horstmann", title = "Scala for the Impatient", price = 15.0),
    Book(id = 3, author = "Joshua Sureth", title = "Effective Scala", price = 20.0),
    Book(id = 4, author = "Nilanjan Raychaudhuri", title = "Scala in Action", price = 12.0),
    Book(id = 5, author = "Dean Wampler", title = "Programming Scala", price = 9.0))
}

class Books extends Service[example.Request, example.Response] {
  import Books._

  override val process: PartialFunction[example.Request, Future[example.Response]] = {
    case Request.List()      => Future.successful(list())
    case Request.Details(id) => Future.successful(details(id))
  }

  def list() =
    Response.List(ScalaBooks.map { book =>
      BookListItem(book.id, book.title)
    })

  def details(id: Int) =
    Response.Details(
      ScalaBooks.find(_.id == id) match {
        case None => Xor.left("Book not found")
        case Some(b) => Xor.right(BookDetails(b.id, b.title, b.author, b.price))
      }
    )
}
