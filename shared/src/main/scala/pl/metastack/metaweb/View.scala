package pl.metastack.metaweb

import pl.metastack.metaweb.diff.{Diff, NodeRef}

import scala.concurrent.Future

case class ViewId(value: String)

class IdMap {
  /* TODO Is there a better solution that doesn't require mutation? */
  private[metaweb] var f: String => Option[Any] = PlatformSupport.DefaultIdMap
}

/**
  * A view has the following life cycle:
  *
  * 1. node()
  * 2. populate()
  * 3. register()
  * 4. destroy()
  */
trait View {
  /** `idMap` contains a function that allows us to resolve NodeRefs used in
    * this view.
    */
  implicit val idMap = new IdMap

  /** Every view must be identifiable with an ID, otherwise we cannot remove it */
  val root: NodeRef[tree.Tag]

  /** Must be overridden when there are multiple instances of this view. Used to
    * give this view's ID a unique suffix. Needed to identify elements on the
    * client after pre-population.
    */
  implicit def id: ViewId

  /** Creates immutable tree node */
  def node(): Future[tree.Node]

  def populate(): Diff = Diff.Noop()

  /** Registers event handlers. Only called in JavaScript. The overridden
    * method can should have the @Js annotation.
    */
  def register(): Diff = Diff.Noop()

  def destroy(): Diff = Diff.RemoveChild(root)
}

object View {
  trait Implicits {
    implicit def NumericToView[T](value: T)(implicit num: Numeric[T]): View =
      View(value.toString)
    implicit def BooleanToView(value: Boolean): View = View(value.toString)
    implicit def StringToView(value: String): View = View(value)
  }

  def apply(text: String): View = new View {
    override val root: NodeRef[tree.Tag] = null  // TODO Text nodes cannot be removed
    override implicit def id: ViewId = ViewId("")
    override def node(): Future[tree.Node] = Future.successful(tree.Text(text))
  }
}
