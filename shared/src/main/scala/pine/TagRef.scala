package pine

sealed trait TagRef[T <: Singleton] {
  def enqueue: Boolean

  def set(nodes: List[Node])(implicit renderCtx: RenderContext): Unit =
    renderCtx.render(this, Diff.SetChildren(nodes))

  def set(node: Node)(implicit renderCtx: RenderContext): Unit =
    renderCtx.render(this, Diff.SetChildren(List(node)))

  def replace(nodes: List[Node])(implicit renderCtx: RenderContext): Unit =
    renderCtx.render(this, Diff.Replace(nodes))

  def replace(node: Node)(implicit renderCtx: RenderContext): Unit =
    renderCtx.render(this, Diff.Replace(List(node)))

  def remove()(implicit renderCtx: RenderContext): Unit =
    renderCtx.render(this, Diff.RemoveNode())

  def prepend(nodes: List[Node])(implicit renderCtx: RenderContext): Unit =
    renderCtx.render(this, Diff.PrependChildren(nodes))

  def prepend(node: Node)(implicit renderCtx: RenderContext): Unit =
    renderCtx.render(this, Diff.PrependChildren(List(node)))

  def append(nodes: List[Node])(implicit renderCtx: RenderContext): Unit =
    renderCtx.render(this, Diff.AppendChildren(nodes))

  def append(node: Node)(implicit renderCtx: RenderContext): Unit =
    renderCtx.render(this, Diff.AppendChildren(List(node)))

  def :=(nodes: List[Node])(implicit renderCtx: RenderContext): Unit =
    set(nodes)
  def :=(node: Node)(implicit renderCtx: RenderContext): Unit = set(node)
  def +=(node: Node)(implicit renderCtx: RenderContext): Unit = append(node)
  def ++=(nodes: List[Node])(implicit renderCtx: RenderContext): Unit =
    append(nodes)
}

object TagRef {
  // Do not rename `tagRefId` to `id`, otherwise it shadows
  // `TagRefAttributes.id`.
  case class ById[T <: Singleton](tagRefId: String) extends TagRef[T] {
    override def enqueue: Boolean = false
  }

  case class ByTag[T <: Singleton](tagName: String with T,
                                   _each: Boolean = false) extends TagRef[T] {
    override def enqueue: Boolean = _each
    def each: TagRef[T] = ByTag(tagName, true)
  }

  case class ByClass[T <: Singleton](_class: String,
                                     _each: Boolean = false) extends TagRef[T] {
    override def enqueue: Boolean = _each
    def each: TagRef[T] = ByClass(_class, true)
  }

  def apply[T <: Singleton](id: String): ById[T] = ById[T](id)
  def apply[T <: Singleton](id: String, child: String): ById[T] =
    ById[T](id + child)
  def apply[T <: String with Singleton](implicit vt: ValueOf[T]): ByTag[T] =
    ByTag[T](vt.value)
  def byClass[T <: Singleton](`class`: String): ByClass[T] = ByClass(`class`)
}
