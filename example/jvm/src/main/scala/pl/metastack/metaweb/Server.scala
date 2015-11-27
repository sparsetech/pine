package pl.metastack.metaweb

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

import akka.actor.ActorSystem

import spray.http.HttpEntity
import spray.http.MediaTypes._
import spray.routing.SimpleRoutingApp

class Controllers extends Protocol {
  val numberGuess = new controller.NumberGuess()
}

object AutowireServer extends autowire.Server[upickle.Js.Value, upickle.Reader, upickle.Writer] {
  def read[Result: upickle.Reader](p: upickle.Js.Value) = upickle.readJs[Result](p)
  def write[Result: upickle.Writer](r: Result) = upickle.writeJs(r)
}

object Server extends SimpleRoutingApp {
  import upickle._

  val impl = new Controllers()
  val router = AutowireServer.route[Protocol](impl)

  def dispatch(path: List[String], args: String): Future[String] =
    upickle.json.read(args) match {
      case Js.Obj(args @ _*) =>
        val fullPath = Protocol.Namespace ++ path
        router(autowire.Core.Request(fullPath, args.toMap))
          .map(upickle.json.write)
      case _ =>
        Future.failed(new Exception("Arguments need to be a valid JSON object"))
    }

  def main(args: Array[String]): Unit = {
    implicit val system = ActorSystem()

    startServer("0.0.0.0", port = 8080) {
      get {
        pathSingleSlash {
          complete {
            HttpEntity(`text/html`,
              controller.HelloWorld.render()
            )
          }
        } ~ path("numberguess") {
          complete {
            HttpEntity(`text/html`,
              controller.NumberGuess.render()
            )
          }
        } ~ pathPrefix("sjs") {
          getFromDirectory("js/target/scala-2.11/")
        }
      } ~
        post {
          path("api" / Segments) { segments =>
            extract(_.request.entity.asString) { entity =>
              complete {
                dispatch(segments, entity)
              }
            }
          }
        }
    }
  }
}