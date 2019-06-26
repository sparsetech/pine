package pine

sealed trait TagRef[T <: Singleton] {
  def set(nodes: List[Node])(implicit renderCtx: RenderContext): Unit =
    renderCtx.render(this, Diff.SetChildren(nodes))

  def set(node: Node)(implicit renderCtx: RenderContext): Unit =
    renderCtx.render(this, Diff.SetChildren(List(node)))

  def replace(nodes: List[Node])(implicit renderCtx: RenderContext): Unit =
    renderCtx.render(this, Diff.Replace(nodes))

  def replace(node: Node)(implicit renderCtx: RenderContext): Unit =
    renderCtx.render(this, Diff.Replace(List(node)))

  def remove()(implicit renderCtx: RenderContext): Unit =
    renderCtx.render(this, Diff.RemoveNode)

  def prepend(nodes: List[Node])(implicit renderCtx: RenderContext): Unit =
    renderCtx.render(this, Diff.PrependChildren(nodes))

  def prepend(node: Node)(implicit renderCtx: RenderContext): Unit =
    renderCtx.render(this, Diff.PrependChildren(List(node)))

  def append(nodes: List[Node])(implicit renderCtx: RenderContext): Unit =
    renderCtx.render(this, Diff.AppendChildren(nodes))

  def append(node: Node)(implicit renderCtx: RenderContext): Unit =
    renderCtx.render(this, Diff.AppendChildren(List(node)))

  def insertBefore[U <: Singleton](childRef: TagRef[U], nodes: List[Node])
                                  (implicit renderCtx: RenderContext): Unit =
    renderCtx.render(this, Diff.InsertBefore(childRef, nodes))

  def insertBefore[U <: Singleton](childRef: TagRef[U], node: Node)
                                  (implicit renderCtx: RenderContext): Unit =
    renderCtx.render(this, Diff.InsertBefore(childRef, List(node)))

  def insertAfter[U <: Singleton](childRef: TagRef[U], nodes: List[Node])
                                 (implicit renderCtx: RenderContext): Unit =
    renderCtx.render(this, Diff.InsertAfter(childRef, nodes))

  def insertAfter[U <: Singleton](childRef: TagRef[U], node: Node)
                                 (implicit renderCtx: RenderContext): Unit =
    renderCtx.render(this, Diff.InsertAfter(childRef, List(node)))

  def insertAt(position: Int, nodes: List[Node])
              (implicit renderCtx: RenderContext): Unit =
    renderCtx.render(this, Diff.InsertAt(position, nodes))

  def insertAt(position: Int, node: Node)
              (implicit renderCtx: RenderContext): Unit =
    renderCtx.render(this, Diff.InsertAt(position, List(node)))

  def clearAll()(implicit renderCtx: RenderContext): Unit =
    renderCtx.render(this, Diff.SetChildren(List.empty))

  def :=(nodes: List[Node])(implicit renderCtx: RenderContext): Unit =
    set(nodes)
  def :=(node: Node)(implicit renderCtx: RenderContext): Unit = set(node)
  def +=(node: Node)(implicit renderCtx: RenderContext): Unit = append(node)
  def ++=(nodes: List[Node])(implicit renderCtx: RenderContext): Unit =
    append(nodes)
}

object TagRef {
  case class Opt [T <: Singleton](tagRef: TagRef[T]) extends TagRef[T]
  case class Each[T <: Singleton](tagRef: TagRef[T]) extends TagRef[T]

  // Do not rename `tagRefId` to `id`, otherwise it shadows
  // `TagRefAttributes.id`.
  case class ById[T <: Singleton](tagRefId: String) extends TagRef[T] {
    def opt = TagRef.Opt(this)
  }

  case class ByTag[T <: Singleton](tagName: String with T) extends TagRef[T] {
    def opt  = TagRef.Opt (this)
    def each = TagRef.Each(this)
  }

  case class ByClass[T <: Singleton](_class: String) extends TagRef[T] {
    def opt  = TagRef.Opt (this)
    def each = TagRef.Each(this)
  }

  def apply[T <: Singleton](id: String): ById[T] = ById[T](id)
  def apply[T <: Singleton](id: String, child: String): ById[T] =
    ById[T](id + child)
  def apply[T <: String with Singleton](implicit vt: ValueOf[T]): ByTag[T] =
    ByTag[T](vt.value)
  def byClass[T <: Singleton](`class`: String): ByClass[T] = ByClass(`class`)
}
