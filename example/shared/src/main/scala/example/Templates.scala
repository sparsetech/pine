package example

import scala.collection.mutable
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

import pl.metastack.metaweb._

object Templates {
  val cache = mutable.HashMap.empty[String, tree.Tag]

  val PageId = "page"

  def Index       = page("Index")
  def Books       = page("Books")
  def BookDetails = page("BookDetails")
  def NumberGuess = page("NumberGuess")
  def Layout      = get("Layout")

  def get(template: String): Future[tree.Tag] =
    cache.get(template) match {
      case Some(t) => Future.successful(t)
      case None =>
        val f = Template.fetch(template)
        f.foreach(cache(template) = _)
        f
    }

  def page(name: String): Future[tree.Tag] =
    get(name).map(_.byId[tree.Tag](PageId))
}

