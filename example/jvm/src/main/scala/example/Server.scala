package example

import java.io.File

import scala.concurrent.ExecutionContext.Implicits.global

import cats.data.Xor

import com.twitter.finagle
import com.twitter.finagle.{Http, http}
import com.twitter.io.{Buf, Reader}
import com.twitter.util.{Await, Future}

import io.circe._
import io.circe.generic.auto._
import io.circe.parser._
import io.circe.syntax._
import io.finch._

import pl.metastack.metaweb._

import example.TwitterUtils._

object Server extends App {
  def fileEndpoint(uri: String, path: String, contentType: String): Endpoint[Buf] =
    get(uri / string) { fileName: String =>
      val file = new File(path, fileName)
      val reader = Reader.fromFile(file)
      Ok(Reader.readAll(reader)).withContentType(Some(contentType))
    }

  def serviceEndpoint[Req, Resp](srv: Service[Req, Resp],
                                 uri: String
                                )(implicit decoder: Decoder[Req],
                                           encoder: Encoder[Resp]): Endpoint[String] = {
    post(uri :: body) { request: String =>
      decode[Req](request) match {
        case Xor.Left(error) => Future.value(BadRequest(error))
        case Xor.Right(req) => (srv ? req).map(x => Ok(x.asJson.noSpaces)).asTwitter
      }
    }
  }

  def renderView(page: Page): scala.concurrent.Future[String] =
    for {
      pageNode   <- page.toTree
      layoutNode <- Templates.Layout
    } yield layoutNode.map {
      case h: tag.Head =>
        val jsState = s"var State = ${page.saveState()};"

        h.map {
          case t: tag.Title => html"<title>${page.title}</title>"
          case n => n
        }.asInstanceOf[tag.Head] ++ Seq(
          html"""<script type="text/javascript">$jsState</script>""",
          html"""<script type="text/javascript" src="/sjs/example-fastopt.js"></script>""",
          html"""<script type="text/javascript" src="/sjs/example-launcher.js"></script>"""
        )

      case h: tag.Body => html"<body>$pageNode</body>"
      case n => n
    }.toHtml

  val index: Endpoint[String] = / {
    renderView(new page.Index).asTwitter.map(Ok(_).withContentType(Some("text/html")))
  }

  val numberGuess: Endpoint[String] = get("numberguess") {
    renderView(new page.NumberGuess).asTwitter.map(Ok(_).withContentType(Some("text/html")))
  }

  val books: Endpoint[String] = get("books") {
    renderView(new page.Books).asTwitter.map(Ok(_).withContentType(Some("text/html")))
  }

  val sjsFile = fileEndpoint("sjs", "js/target/scala-2.11", "text/javascript")
  val tplFile = fileEndpoint("tpl", "shared/src/main/html", "text/html")
  val api     = serviceEndpoint(MyService, "api")

  val server: finagle.Service[http.Request, http.Response] = (
    index :+: numberGuess :+: books :+: sjsFile :+: tplFile :+: api
  ).toService

  Await.ready(Http.server.serve(":8080", server))
}