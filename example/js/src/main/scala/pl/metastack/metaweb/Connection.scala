package pl.metastack.metaweb

import org.scalajs.dom
import org.scalajs.dom.ext.Ajax

import scala.concurrent.Future
import scala.scalajs.concurrent.JSExecutionContext.Implicits.runNow

object Connection extends autowire.Client[upickle.Js.Value, upickle.Reader, upickle.Writer] {
  def waitingCursor() { dom.window.document.body.style.cursor = "wait" }
  def resetCursor() { dom.window.document.body.style.cursor = "default" }

  override def doCall(req: Request): Future[upickle.Js.Value] = {
    waitingCursor()

    try {
      val future = Ajax.post(
        url = "/api/" + req.path.drop(Protocol.Namespace.length).mkString("/"),
        data = upickle.json.write(upickle.Js.Obj(req.args.toSeq: _*))
      )

      future.onFailure { case error =>
        dom.alert("The server couldn't process the request. Try again later.")
        println(error)
      }

      future.map(x => upickle.json.read(x.responseText))
    } finally {
      resetCursor()
    }
  }

  def read[Result: upickle.Reader](p: upickle.Js.Value) = upickle.readJs[Result](p)
  def write[Result: upickle.Writer](r: Result) = upickle.writeJs(r)
}

object ServerOps {
  import autowire._
  import upickle._

  object NumberGuess {
    def requestSession() =
      Connection[Protocol].numberGuess.requestSession().call()

    def guess(session: String, answer: Int) =
      Connection[Protocol].numberGuess.guess(session, answer).call()
  }
}