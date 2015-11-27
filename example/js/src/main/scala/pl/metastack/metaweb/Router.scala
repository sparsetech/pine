package pl.metastack.metaweb

import org.scalajs.dom

import pl.metastack.metaweb._
import pl.metastack.metaweb.view._

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExport

object Router extends js.JSApp {
  def render(pageBody: tag.Body): Unit = {
    val body = dom.document.body
    body.clear()
    pageBody.toDom.foreach(body.appendChild)
  }

  def replaceUrl(route: String): Unit = {
    dom.document.body.scrollTop = 0
    dom.window.history.pushState("", "", route)
  }

  @JSExport
  def main(): Unit = {
    val href = dom.window.location.href
    val uri = href.split('/').drop(3).toSeq.mkString("/").split('?')
    val path = uri.head
    path match {
      case "numberguess" => new controller.NumberGuess(new NumberGuessAttach)
      case _ => new controller.HelloWorld(new HelloWorldAttach)
    }
  }
}
