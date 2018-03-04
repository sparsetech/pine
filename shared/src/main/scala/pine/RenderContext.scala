package pine

import scala.annotation.tailrec
import scala.collection.mutable

trait RenderContext {
  def render[T <: Singleton](tagRef: TagRef[T], diff: Diff): Unit
}

class NodeRenderContext extends RenderContext {
  val diffs = mutable.Queue.empty[(TagRef[Singleton], Diff)]

  override def render[T <: Singleton](tagRef: TagRef[T], diff: Diff): Unit =
    diffs.enqueue((tagRef.asInstanceOf[TagRef[Singleton]], diff))

  @tailrec final def matches[T <: Singleton](tagRef: TagRef[T], tag: Tag[T]): Boolean =
    tagRef match {
      case TagRef.Opt(tr)        => matches(tr, tag)
      case TagRef.Each(tr)       => matches(tr, tag)
      case TagRef.ById(tagRefId) => tag.id() == tagRefId
      case TagRef.ByTag(tagName) => tag.tagName == tagName
      case TagRef.ByClass(cls)   => tag.hasClass(cls)
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
    if (r.isEmpty) throw new Exception("Root node cannot be removed")
    else if (diffs.exists {
      case (TagRef.Each(_), _) => false
      case (TagRef.Opt (_), _) => false
      case _ => true
    }) throw new Exception(s"Some diffs could not be applied: $diffs")
    assert(r.length == 1)
    r.head.asInstanceOf[Tag[T]]
  }
}
