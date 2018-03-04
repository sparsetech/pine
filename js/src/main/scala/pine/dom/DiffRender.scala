package pine.dom

import org.scalajs.dom.html.Element
import pine._

import scala.collection.mutable

object DiffRender {
  def render(dom: Element, diff: Diff): Unit =
    diff match {
      case Diff.SetAttribute(attribute, value) =>
        attribute.codec.encode(value) match {
          case None    => dom.removeAttribute(attribute.name)
          case Some(v) => dom.setAttribute(attribute.name, v)
        }

      case Diff.UpdateAttribute(attribute, f) =>
        val curValue = Option(dom.getAttribute(attribute.name))
        val newValue = f(attribute.codec.decode(curValue))

        attribute.codec.encode(newValue) match {
          case None    => dom.removeAttribute(attribute.name)
          case Some(v) => dom.setAttribute(attribute.name, v)
        }

      case Diff.RemoveAttribute(attribute) =>
        dom.removeAttribute(attribute.name)

      case Diff.SetChildren(children) =>
        dom.removeChildren()
        children.foreach(child =>
          dom.appendChild(NodeRender.renderChild(child)))

      case Diff.Replace(nodes) =>
        nodes.foreach(node =>
          dom.parentNode.insertBefore(NodeRender.renderChild(node), dom))
        dom.parentNode.removeChild(dom)

      case Diff.PrependChildren(children) =>
        children.reverse.foreach(child =>
          dom.prependChild(NodeRender.renderChild(child)))

      case Diff.AppendChildren(children) =>
        children.foreach(child =>
          dom.appendChild(NodeRender.renderChild(child)))

      case Diff.InsertAt(position, children) =>
        children.reverse.foreach(child =>
          dom.insertChildAt(position, NodeRender.renderChild(child)))

      case Diff.RemoveNode() =>
        dom.parentNode.removeChild(dom)
    }
}

class DomRenderContext extends RenderContext {
  var committed = false
  val diffs = mutable.Queue.empty[(TagRef[Singleton], Diff)]

  override def render[T <: Singleton](tagRef: TagRef[T], diff: Diff): Unit = {
    if (committed) throw new Exception("Dangling rendering context")
    diffs.enqueue((tagRef.asInstanceOf[TagRef[Singleton]], diff))
  }

  def commit(): Unit = {
    while (diffs.nonEmpty) {
      val (ref, diff) = diffs.dequeue()
      ref.resolve.foreach(node => DiffRender.render(node, diff))
    }

    committed = true
  }
}
