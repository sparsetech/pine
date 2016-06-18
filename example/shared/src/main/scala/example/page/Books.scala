package example.page

import scala.collection.mutable.ListBuffer
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

import cats.data.Xor
import io.circe.generic.auto._
import io.circe.parser._
import io.circe.syntax._

import pl.metastack.metaweb._
import pl.metastack.metaweb.dsl._
import pl.metastack.metaweb.diff._
import pl.metastack.metaweb.macros.Js

import example._
import example.{Books => BK}

class Books extends Page with Routing {
  val books = ListBuffer.empty[BookListItem]

  override def title: String = "Books"

  override def saveState(): String = books.asJson.noSpaces

  @Js override def loadState(state: String): Diff =
    decode[Seq[BookListItem]](state) match {
      case Xor.Left(error) =>
        error.printStackTrace()
        Diff.Noop()

      case Xor.Right(items) =>
        books ++= items
        Diff.fromSeq(books.map(new ItemView(_).register()))
    }

  val lstBooks        = NodeRef[tag.Ul]("books")
  val edtAddBookTitle = NodeRef[tag.Input]("add-book-title")
  val btnAddBook      = NodeRef[tag.Button]("add-book")
  val btnRevert       = NodeRef[tag.Button]("revert")

  override def service() = MyService
  override def node(): Future[tree.Node] = Templates.Books
  override def populate(): Diff = request(BK.Request.List())
  override def response(): Response => Diff = {
    case BK.Response.List(books) => renderList(books)
  }

  @Js override def register(): Diff =
    super.register() :+
    btnAddBook.click.subscribe(_ => addBook(edtAddBookTitle.dom.value)) :+
    edtAddBookTitle.onEnter(addBook) :+
    btnRevert.click.subscribe(_ => revert())

  def nextId: Int = if (books.isEmpty) 1 else books.last.id + 1

  def addBook(title: String): Diff = {
    val book = BookListItem(nextId, title)
    books += book

    Diff(
      lstBooks += new ItemView(book),
      inserted())
  }

  @Js def inserted(): Diff = Diff.Effect {
    import org.scalajs.dom
    edtAddBookTitle.dom.value = ""
    dom.window.alert("Book added")
  }

  @Js def revert(): Diff = Diff.Map {
    import org.scalajs.dom
    if (dom.window.confirm("Really?")) request(BK.Request.List())
    else Diff.Noop()
  }

  def renderList(items: Seq[BookListItem]): Diff = {
    books.clear()
    books ++= items

    lstBooks := items.map(new ItemView(_))
  }
}

class ItemView(book: BookListItem) extends View {
  var hidden = true

  override implicit def id = ViewId(book.id.toString)

  val root = NodeRef[tag.Li]("book")
  val title = NodeRef[tag.A]("title")
  val btnRemove = NodeRef[tag.Button]("remove")
  val btnRenameToggle = NodeRef[tag.Button]("rename-toggle")
  val divRenameBox = NodeRef[tag.Div]("rename-box")
  val txtRename = NodeRef[tag.Input]("rename-text")
  val btnRenameSave = NodeRef[tag.Button]("rename-save")

  override def node(): Future[tree.Node] =
    Templates.Books.map(_.byId[tree.Tag]("book"))

  override def populate(): Diff =
    Diff(
      title := book.title,
      title.href := s"/book/${book.id}",
      txtRename.value := book.title,
      divRenameBox.hide(hidden)
    )

  @Js override def register(): Diff =
    btnRemove.click.subscribe(_ => destroy()) :+
    btnRenameToggle.click.subscribe { _ =>
      hidden = !hidden
      divRenameBox.hide(hidden) :+ Diff.Effect {
        if (!hidden) txtRename.dom.focus()
      }
    } :+
    txtRename.onEnter(rename) :+
    btnRenameSave.click.subscribe(_ => rename(txtRename.dom.value))

  @Js def rename(value: String): Diff = {
    hidden = true
    Diff(
      title := value,
      divRenameBox.hide(hidden)
    )
  }
}
