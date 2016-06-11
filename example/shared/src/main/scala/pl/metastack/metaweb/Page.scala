package pl.metastack.metaweb

import pl.metastack.metaweb.diff.{Diff, NodeRef}

import scala.concurrent.ExecutionContext.Implicits.global

/** A page adds functionality for restoring the server state and dealing with
  * requests.
  */
trait Page extends View {
  override implicit def id = ViewId("")

  override val root = NodeRef[tag.Div]("page")

  /** Page title */
  def title: String

  /** Save state to JSON */
  def saveState(): String = "{}"

  /** Load state and attach event handlers in terms of Diff objects */
  def loadState(state: String): Diff = Diff.Noop()

  def service(): Service[Request, Response]

  def request(request: Request): Diff =
    Diff.Async((service ? request).map(response()))

  def response(): Response => Diff = { case _ => Diff.Noop() }
}
