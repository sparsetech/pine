package pine

import scala.collection.mutable

trait RenderContext {
  def render[T <: Singleton](tagRef: TagRef[T], diff: Diff): Unit
}

class NodeRenderContext extends RenderContext {
  val diffs = mutable.Queue.empty[(TagRef[Singleton], Diff)]

  override def render[T <: Singleton](tagRef: TagRef[T], diff: Diff): Unit =
    diffs.enqueue((tagRef.asInstanceOf[TagRef[Singleton]], diff))

  /** Recursively iterates over `node` and applies changes in place while
    * `diffs.nonEmpty` */
  def render(tag: Node): List[Node] =
    tag match {
      case acc @ Tag(_, _, _) if diffs.nonEmpty =>
        diffs.find { case (ref, _) => acc.matches(ref) } match {
          case None => List(acc.set(acc.children.flatMap(render)))
          case Some(rd @ (ref, diff)) =>
            val result = DiffRender.render(acc)(diff)
            if (ref.isInstanceOf[TagRef.Each[_]]) result
            else {
              diffs.dequeueFirst(_ == rd)
              result.flatMap(render)
            }
        }

      case result => List(result)
    }

  def commit[T <: Singleton](tag: Tag[T]): Tag[T] = {
    val r = render(tag)
    if (r.length != 1) throw new Exception("The root must consist of exactly one node")
    else {
      if (diffs.exists {
        case (TagRef.Each(_), _) => false
        case (TagRef.Opt(_), _) => false
        case _ => true
      }) throw new Exception(s"Some diffs could not be applied: $diffs")

      r.head.asInstanceOf[Tag[T]]
    }
  }
}
