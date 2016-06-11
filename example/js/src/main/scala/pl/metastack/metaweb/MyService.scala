package pl.metastack.metaweb

import scala.concurrent.Future
import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.util.{Failure, Success}

import cats.data.Xor
import io.circe.generic.auto._
import io.circe.parser._
import io.circe.syntax._
import org.scalajs.dom
import org.scalajs.dom.ext.{Ajax, AjaxException}

object MyService extends Service[Request, Response] {
  def waitingCursor(): Unit = dom.window.document.body.style.cursor = "wait"
  def resetCursor(): Unit = dom.window.document.body.style.cursor = "default"

  override val process: PartialFunction[Request, Future[Response]] = { case r =>
    waitingCursor()

    val future = Ajax.post(
      url = "/api",
      data = r.asJson.noSpaces
    ).flatMap(resp => decode[Response](resp.responseText) match {
      case Xor.Left(error) => Future.failed(error)
      case Xor.Right(response) => Future.successful(response)
    })

    future.onComplete {
      case Success(_) => resetCursor()
      case Failure(error) =>
        resetCursor()

        error match {
          case a: AjaxException =>  // The browser already logs this event
          case e => e.printStackTrace()
        }
    }

    future
  }
}
