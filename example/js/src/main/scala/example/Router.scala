package example

import scala.concurrent.ExecutionContext.Implicits.global

import scala.scalajs.js
import scala.scalajs.js.JSON
import scala.scalajs.js.annotation.JSExport

import org.scalajs.dom

import pl.metastack.metaweb._
import pl.metastack.metaweb.diff.Diff
import pl.metastack.metaweb.macros.Js

@Js object Router extends js.JSApp {
  def pageNode(): dom.Element = dom.document.getElementById(Templates.PageId)

  def renderPage(page: Page): Diff =
    Diff.Async {
      page.toDom.map { node =>
        dom.document.title = page.title
        dom.document.body.appendChild(node)
        Diff.Noop()
      }
    }

  def attachPage(page: Page): Diff =
    page.register() :+
    page.loadState(JSON.stringify(js.Dynamic.global.State))

  def replaceUrl(route: String): Diff =
    Diff.Effect {
      dom.document.body.scrollTop = 0
      dom.window.history.pushState("", "", route)
    }

  def resolvePage(): Page = {
    val href = dom.window.location.href
    val uri = href.split('/').drop(3).toSeq.mkString("/").split('?')
    val path = uri.head
    path match {
      case "numberguess" => new page.NumberGuess
      case "books" => new page.Books
      // case "books/details" => new page.BooksDetails
      case _ => new page.Index
    }
  }

  @JSExport
  def main(): Unit =
    dom.window.onload = { (e: dom.Event) =>
      import diff.Render._
      import diff.render.DOM._
      logFailingFuture(render(pageNode(): dom.Node, attachPage(resolvePage())))
    }
}
