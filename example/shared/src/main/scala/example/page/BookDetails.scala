package example.page

import scala.concurrent.Future

import cats.data.Xor

import pl.metastack.metaweb._
import pl.metastack.metaweb.dsl._
import pl.metastack.metaweb.diff._

import example._
import example.{Books => BK}

class BookDetails(id: Int) extends Page with Routing {
  override def title: String = "Book details"

  val txtError  = NodeRef[tag.Div]("error")
  val ulDetails = NodeRef[tag.Ul]("details")
  val txtTitle  = NodeRef[tag.Span]("title")
  val txtAuthor = NodeRef[tag.Span]("author")
  val txtPrice  = NodeRef[tag.Span]("price")

  override def service() = MyService
  override def node(): Future[tree.Node] = Templates.BookDetails
  override def populate(): Diff = request(BK.Request.Details(id))
  override def response(): Response => Diff = {
    case BK.Response.Details(book) => renderDetails(book)
  }

  def renderDetails(details: Xor[String, example.BookDetails]): Diff = {
    details match {
      case Xor.Left(message) =>
        Diff(
          txtError.hide(false),
          ulDetails.hide(true),
          txtError := message)

      case Xor.Right(details) =>
        Diff(
          txtError.hide(true),
          ulDetails.hide(false),
          txtTitle := details.title,
          txtAuthor := details.author,
          txtPrice := details.price
        )
    }
  }
}
