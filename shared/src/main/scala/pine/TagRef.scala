package pine

sealed trait TagRef[T <: Singleton] {
  def matches(tag: Tag[T]): Boolean

  def set(nodes: List[Node])(implicit renderCtx: RenderContext): Unit =
    renderCtx.render(Diff.ReplaceChildren(this, nodes))

  def set(node: Node)(implicit renderCtx: RenderContext): Unit =
    renderCtx.render(Diff.ReplaceChildren(this, List(node)))

  def replace(node: Node)(implicit renderCtx: RenderContext): Unit =
    renderCtx.render(Diff.Replace(this, node))

  def remove()(implicit renderCtx: RenderContext): Unit =
    renderCtx.render(Diff.RemoveChild(this))

  def append(node: Node)(implicit renderCtx: RenderContext): Unit =
    renderCtx.render(Diff.AppendChild(this, node))

  def :=(value: List[Node])(implicit renderCtx: RenderContext): Unit = set(value)
  def :=(value: Node)(implicit renderCtx: RenderContext): Unit = set(value)
  def +=(value: Node)(implicit renderCtx: RenderContext): Unit = append(value)
}

object TagRef {
  // Do not rename `tagRefId` to `id`, otherwise it shadows `TagRefAttributes.id`
  case class ById[T <: Singleton](tagRefId: String) extends TagRef[T] {
    override def matches(tag: Tag[T]): Boolean = tag.id.contains(tagRefId)
  }

  case class ByTag[T <: Singleton](tagName: String with T) extends TagRef[T] {
    override def matches(tag: Tag[T]): Boolean = tag.tagName == tagName
    def each: TagRef[T] = ByTag(tagName)
  }

  def apply[T <: Singleton](id: String): TagRef.ById[T] = TagRef.ById[T](id)
  def apply[T <: Singleton](id: String, child: String): TagRef.ById[T] =
    TagRef.ById[T](id + child)
  def apply[T <: String with Singleton](implicit vt: ValueOf[T]): TagRef.ByTag[T] =
    TagRef.ByTag[T](vt.value)
}
