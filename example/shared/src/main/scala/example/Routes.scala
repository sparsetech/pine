package example

import pl.metastack.metarouter._

object Routes {
  case class NumberGuess()
  case class Books()
  case class BookDetails(id: Int)
  case class Index()

  val numberGuess = (Root / "numberguess").as[NumberGuess]
  val books       = (Root / "books").as[Books]
  val bookDetails = (Root / "book" / Arg[Int]).as[BookDetails]
  val index       = Root.as[Index]

  val composed = ComposedRoute(numberGuess)
    .orElse(books)
    .orElse(bookDetails)
    .orElse(index)

  def instantiate(uri: String): Option[Page] =
    composed.parse(uri).map {
      case NumberGuess()   => new page.NumberGuess
      case Books()         => new page.Books
      case BookDetails(id) => new page.BookDetails(id)
      case Index()         => new page.Index
    }
}
