package example

import java.io.File

import scala.io.Source
import scala.concurrent.Future

import pl.metastack.metaweb._

object Template {
  def fetch(template: String): Future[tree.Tag] = {
    val f = Source.fromFile(new File(s"shared/src/main/html/$template.html")).mkString
    Future.successful(HtmlParser.fromString(f))
  }
}
