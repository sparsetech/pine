package pl.metastack.metaweb.diff.render

import scala.concurrent.{ExecutionContext, Future}
import scala.scalajs.js
import org.scalajs.dom
import pl.metastack.metaweb.{HtmlHelpers, PlatformSupport, View, tree}
import pl.metastack.metaweb.diff._

object DOM {
  def logFailingFuture[T](future: Future[T])(implicit ec: ExecutionContext): Future[T] = {
    future.onFailure { case t => t.printStackTrace() }
    future
  }

  implicit object RenderDom extends Render[dom.Node, Unit] with PlatformSupport {
    def render(node: dom.Node, diff: Diff)(implicit ec: ExecutionContext): Future[Unit] =
      diff match {
        case Diff.Sequence(left, right @ _*) =>
          right.foldLeft(render(node, left)) { case (acc, cur) =>
            acc.flatMap(_ => render(node, cur))
          }

        case Diff.SetAttribute(ref, attribute, value) =>
          Future.successful {
            if (!HtmlHelpers.BooleanAttributes.contains(attribute.name))
              ref.dom.setAttribute(attribute.name, value.toString)
            else {
              if (value.asInstanceOf[Boolean]) ref.dom.setAttribute(attribute.name, "")
              else ref.dom.removeAttribute(attribute.name)
            }
          }

        case Diff.UpdateAttribute(ref, attribute, f) =>
          Future.successful {
            if (HtmlHelpers.BooleanAttributes.contains(attribute.name)) {
              val fBoolean = f.asInstanceOf[Boolean => Boolean]
              val current = ref.dom.hasAttribute(attribute.name)
              if (fBoolean(current)) ref.dom.setAttribute(attribute.name, "")
              else                   ref.dom.removeAttribute(attribute.name)
            } else {
              val fString = f.asInstanceOf[Option[String] => Option[String]]
              val current = Option(ref.dom.getAttribute(attribute.name))
              fString(current) match {
                case None    => ref.dom.removeAttribute(attribute.name)
                case Some(s) => ref.dom.setAttribute(attribute.name, s)
              }
            }
          }

        case Diff.RemoveAttribute(ref, attribute) =>
          Future.successful(ref.dom.removeAttribute(attribute.name))

        case Diff.ReplaceChildren(ref, children) =>
          ref.dom.clear()
          children.foreach(child =>
            ref.dom.appendChild(tree.render.DOM.render(child)))
          Future.successful(())

        case e: Diff.Effect => Future.successful(e.f())
        case e: Diff.Map => render(node, e.f())
        case e: Diff.Async => e.f().flatMap(render(node, _))

        case Diff.Noop() => Future.successful(())

        case e: DiffDom.SubscribeEvent[_] =>
          val cast = e.asInstanceOf[DiffDom.SubscribeEvent[dom.Event]]
          cast.set { event: dom.Event =>
            logFailingFuture(render(node, cast.f(event)))
          }
          Future.successful(())

        case e: DiffDom.UnsubscribeEvent[_] =>
          val cast = e.asInstanceOf[DiffDom.SubscribeEvent[dom.Event]]
          Future.successful(cast.set(null))

        case Diff.PrependChild(ref, child) =>
          Future.successful(ref.dom.prependChild(tree.render.DOM.render(child)))

        case Diff.AppendChild(ref, child) =>
          ref.dom.appendChild(tree.render.DOM.render(child))
          Future.successful(())

        case Diff.RemoveChild(ref) =>
          ref.dom.parentNode.removeChild(ref.dom)
          Future.successful(())
      }
  }

  def collectNodes(node: dom.Node): Map[String, dom.Element] =
    node match {
      case e: dom.Element =>
        val map =
          if (e.id != "") Map(e.id -> e)
          else Map.empty[String, dom.Element]

        import dom.ext._
        e.getElementsByTagName("*").collect {
          case e: dom.Element if e.id.nonEmpty => e.id -> e
        }.toMap ++ map

      case _ => Map.empty
    }
}
