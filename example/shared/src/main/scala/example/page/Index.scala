package example.page

import scala.concurrent.Future

import pl.metastack.metaweb._
import pl.metastack.metaweb.diff._
import pl.metastack.metaweb.macros.Js

import example._

class Index extends Page with Routing {
  val btnGuess = NodeRef[tag.Button]("guess")
  val btnBooks = NodeRef[tag.Button]("books")

  override def title: String = "Index"
  override def service() = MyService
  override def node(): Future[tree.Tag] = Templates.Index

  @Js override def register(): Diff =
    super.register() :+
    btnGuess.click.subscribe(_ =>
      redirect(Routes.numberGuess(Routes.NumberGuess()))) :+
    btnBooks.click.subscribe(_ => redirect(Routes.books(Routes.Books())))

  override def destroy(): Diff = {
    println("On redirect")
    super.destroy()
  }
}
