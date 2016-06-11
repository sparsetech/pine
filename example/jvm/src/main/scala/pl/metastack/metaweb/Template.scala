package pl.metastack.metaweb

import java.io.File

import scala.io.Source
import scala.concurrent.Future

object Template {
  def fetch(template: String): Future[tree.Tag] = {
    val f = Source.fromFile(new File(s"shared/src/main/html/$template.html")).mkString
    Future.successful(HtmlParser.fromString(f))
  }
}
