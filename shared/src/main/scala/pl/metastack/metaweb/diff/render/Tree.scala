package pl.metastack.metaweb.diff.render

import scala.concurrent.{ExecutionContext, Future}

import pl.metastack.metaweb._
import pl.metastack.metaweb.diff._

object Tree {
  trait Implicit {
    implicit class ViewToTree(view: View) {
      def toTree(implicit ec: ExecutionContext): Future[tree.Node] = renderView(view)
      def toHtml(implicit ec: ExecutionContext): Future[String] = renderView(view).map(_.toHtml)
    }
  }

  implicit object RenderNode extends Render[tree.Node, tree.Node] {
    def render(node: tree.Node, diff: Diff)(implicit ec: ExecutionContext): Future[tree.Node] =
      diff match {
        case Diff.Sequence(left, right @ _*) =>
          right.foldLeft(render(node, left)) { case (acc, cur) =>
            acc.flatMap(render(_, cur))
          }

        case e: Diff.Effect =>
          e.f()
          Future.successful(node)
        case e: Diff.Map => render(node, e.f())
        case e: Diff.Async => e.f().flatMap(render(node, _))

        case _ =>
          node match {
            case text: tree.Text => Future.successful(text)

            case tag: tree.Tag =>
              diff match {
                case Diff.SetAttribute(ref, attribute, value) if ref.matches(tag) =>
                  Future.successful(tag.copy(attributes =
                    tag.attributes + (attribute.name -> value)))

                case Diff.RemoveAttribute(ref, attribute) if ref.matches(tag) =>
                  Future.successful(tag.copy(attributes = tag.attributes - attribute.name))

                case Diff.PrependChild(ref, child) if ref.matches(tag) =>
                  renderView(child).map { c =>
                    tag.copy(children = c +: tag.children)
                  }

                case Diff.AppendChild(ref, child) if ref.matches(tag) =>
                  renderView(child).map { c =>
                    tag.copy(children = tag.children :+ c)
                  }

                case Diff.ReplaceChildren(ref, children) if ref.matches(tag) =>
                  Future.sequence(children.map(renderView)).map { c =>
                    tag.copy(children = c)
                  }

                case Diff.RemoveChild(ref) if tag.children.collect { case t: tree.Tag => t }.exists(c => ref.matches(c)) =>
                  val child = tag.children.collect { case t: tree.Tag => t }.find(c => ref.matches(c)).get
                  Future.successful(tag.copy(children = tag.children.diff(Seq(child))))

                case _ =>
                  val children = Future.sequence(tag.children.map(render(_, diff)))
                  children.map(c => tag.copy(children = c))
              }
          }
      }
  }

  def renderView(view: View)(implicit ec: ExecutionContext): Future[tree.Node] = {
    import Render._
    for {
      n <- if (view.id.value.isEmpty) view.node()
           else view.node().map(suffixIds(_, view.id.value))
      p <- render(n, view.populate())
    } yield p
  }
}
