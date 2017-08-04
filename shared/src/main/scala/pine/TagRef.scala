package pine

sealed trait TagRef[T <: Singleton] {
  def enqueue: Boolean

  def set(nodes: List[Node])(implicit renderCtx: RenderContext): Unit =
    renderCtx.render(this, Diff.ReplaceChildren(nodes))

  def set(node: Node)(implicit renderCtx: RenderContext): Unit =
    renderCtx.render(this, Diff.ReplaceChildren(List(node)))

  def replace(node: List[Node])(implicit renderCtx: RenderContext): Unit =
    renderCtx.render(this, Diff.Replace(node))

  def replace(node: Node)(implicit renderCtx: RenderContext): Unit =
    renderCtx.render(this, Diff.Replace(List(node)))

  def remove()(implicit renderCtx: RenderContext): Unit =
    renderCtx.render(this, Diff.RemoveChild())

  def append(node: Node)(implicit renderCtx: RenderContext): Unit =
    renderCtx.render(this, Diff.AppendChild(node))

  def :=(value: List[Node])(implicit renderCtx: RenderContext): Unit = set(value)
  def :=(value: Node)(implicit renderCtx: RenderContext): Unit = set(value)
  def +=(value: Node)(implicit renderCtx: RenderContext): Unit = append(value)
}

object TagRef {
  // Do not rename `tagRefId` to `id`, otherwise it shadows `TagRefAttributes.id`
  case class ById[T <: Singleton](tagRefId: String) extends TagRef[T] {
    override def enqueue: Boolean = false
  }

  case class ByTag[T <: Singleton](tagName: String with T, _each: Boolean = false) extends TagRef[T] {
    override def enqueue: Boolean = _each
    def each: TagRef[T] = ByTag(tagName, true)
  }

  case class ByClass[T <: Singleton](`class`: String, _each: Boolean = false) extends TagRef[T] {
    override def enqueue: Boolean = _each
    def each: TagRef[T] = ByClass(`class`, true)
  }

  def apply[T <: Singleton](id: String): ById[T] = ById[T](id)
  def apply[T <: Singleton](id: String, child: String): ById[T] =
    ById[T](id + child)
  def apply[T <: String with Singleton](implicit vt: ValueOf[T]): ByTag[T] =
    ByTag[T](vt.value)
  def byClass[T <: Singleton](`class`: String): ByClass[T] = ByClass(`class`)
}
