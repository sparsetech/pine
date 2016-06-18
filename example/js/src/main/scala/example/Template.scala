package example

import scala.concurrent.Future
import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue

import org.scalajs.dom.ext.Ajax

import pl.metastack.metaweb._

object Template {
  def fetch(template: String): Future[tree.Tag] =
    Ajax.get(url = s"/tpl/$template.html")
      .map(_.responseText)
      .map(HtmlParser.fromString)
}
