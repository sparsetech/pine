package example

import java.io.File

import scala.io.Source
import scala.concurrent.Future

import pl.metastack.metaweb._

object Template {
  val TemplatePath = "shared/src/main/html"

  new FileWatcher(
    new File(TemplatePath),
    path => {
      val template = path.stripSuffix(".html")
      if (Templates.cache.contains(template)) {
        println(s"Template `$template` changed")
        Templates.cache -= template
      }
    })

  def fetch(template: String): Future[tree.Tag] = {
    val f = Source.fromFile(new File(s"$TemplatePath/$template.html")).mkString
    Future.successful(HtmlParser.fromString(f))
  }
}
