package pine

trait RenderContext {
  def render(diff: Diff): Unit
}

class NodeRenderContext extends RenderContext {
  var diffs = List.empty[Diff]

  override def render(diff: Diff): Unit = diffs = diffs :+ diff

  // TODO Optimise by recursively iterating over `tag`'s children and applying
  // changes in place while `diffs.nonEmpty`
  def commit(tag: Tag): Tag =
    diffs.foldLeft(tag) { case (a, b) =>
      DiffRender.render(a, b).asInstanceOf[Tag]
    }
}
