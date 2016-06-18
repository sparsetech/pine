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
    implicit def NumericToTree[T](value: T)
                                 (implicit num: Numeric[T]): tree.Node =
      tree.Text(value.toString)
    implicit def BooleanToTree(value: Boolean): tree.Node =
      tree.Text(value.toString)
    implicit def StringToTree(value: String): tree.Node = tree.Text(value)

    implicit def TreeToView(value: tree.Node): View = View(value)

    // Scala cannot resolve these implicits automatically
    implicit def NumericToView[T](value: T)
                                 (implicit num: Numeric[T]): View =
      TreeToView(NumericToTree(value))
    implicit def BooleanToView(value: Boolean): View =
      TreeToView(BooleanToTree(value))
    implicit def StringToView(value: String): View =
      TreeToView(StringToTree(value))
  }

  /** @note The DOM node of resulting view cannot be accessed. The view cannot
    *       be manually removed from the DOM either.
    */
  def apply(value: tree.Node): View = new View {
    override val root: NodeRef[tree.Tag] = null
    override implicit def id: ViewId = ViewId("")
    override def node(): Future[tree.Node] = Future.successful(value)
  }
}
