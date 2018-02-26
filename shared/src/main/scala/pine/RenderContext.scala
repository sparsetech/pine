package pine

import scala.collection.mutable

trait RenderContext {
  def render[T <: Singleton](tagRef: TagRef[T], diff: Diff): Unit
}

class NodeRenderContext extends RenderContext {
  val diffs = mutable.Queue.empty[(TagRef[Singleton], Diff)]

  override def render[T <: Singleton](tagRef: TagRef[T], diff: Diff): Unit =
    diffs.enqueue((tagRef.asInstanceOf[TagRef[Singleton]], diff))

  def matches[T <: Singleton](tagRef: TagRef[T], tag: Tag[T]): Boolean =
    tagRef match {
      case TagRef.ById(tagRefId)    => tag.id() == tagRefId
      case TagRef.ByTag(tagName, _) => tag.tagName == tagName
      case TagRef.ByClass(cls, _)   => tag.hasClass(cls)
    }

  /** Recursively iterates over `node` and applies changes in place while
    * `diffs.nonEmpty` */
  def render(tag: Node): List[Node] =
    tag match {
      case acc @ Tag(_, _, _) if diffs.nonEmpty =>
        diffs.find { case (ref, _) => matches(ref, acc) } match {
          case None => List(acc.set(acc.children.flatMap(render)))
          case Some(rd @ (ref, diff)) =>
            val result = DiffRender.render(acc)(diff)
            if (ref.enqueue) result
            else {
              diffs.dequeueFirst(_ == rd)
              result.flatMap(render)
            }
        }

      case result => List(result)
    }

  def commit[T <: Singleton](tag: Tag[T]): Tag[T] = {
    val r = render(tag)
    if (r.isEmpty) throw new Exception("Root node cannot be removed")
    else if (diffs.exists(!_._1.enqueue))
      throw new Exception(s"Some diffs could not be applied: $diffs")
    assert(r.length == 1)
    r.head.asInstanceOf[Tag[T]]
  }
}
