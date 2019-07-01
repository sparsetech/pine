package pine

trait AttributeCodec[T] {
  def encode(value: T): Option[String]
  def decode(value: Option[String]): T
}

case class TagAttribute[T <: Singleton, U](parent: Tag[T], name: String)
                                          (implicit val codec: AttributeCodec[U]) {
  def get: U = codec.decode(parent.attr(name))
  def set(value: U): Tag[T] =
    codec.encode(value) match {
      case None    => parent.remAttr(name)
      case Some(v) => parent.setAttr(name, v)
    }

  def apply(): U = get
  def apply(value: U): Tag[T] = set(value)
}

case class TagRefAttribute[T <: Singleton, U](parent: TagRef[T], name: String)
                                             (implicit val codec: AttributeCodec[U]) {
  def set(value: U)(implicit renderCtx: RenderContext): Unit = {
    val diff = codec.encode(value) match {
      case None    => Diff.RemoveAttribute(name)
      case Some(v) => Diff.SetAttribute(name, v)
    }

    renderCtx.render(parent, diff)
  }

  def update(f: U => U)(implicit renderCtx: RenderContext): Unit = {
    val diff = Diff.UpdateAttribute(name, { curValue =>
      val newValue = f(codec.decode(curValue))
      codec.encode(newValue)
    })

    renderCtx.render(parent, diff)
  }

  def remove()(implicit renderCtx: RenderContext): Unit =
    renderCtx.render(parent, Diff.RemoveAttribute(name))

  def :=(value: U)(implicit renderCtx: RenderContext): Unit = set(value)
}

/**
  * Insertion order preserving set of space-separated tokens
  *
  * @see https://html.spec.whatwg.org/#ordered-set-of-unique-space-separated-tokens
  * @see https://dom.spec.whatwg.org/#interface-domtokenlist
  */
case class TagTokenSetAttribute[T <: Singleton](parent: Tag[T], name: String) {
  def get: List[String] =
    parent.attr(name).map(HtmlHelpers.parseTokenSet).getOrElse(List.empty)
  def set(value: String): Tag[T] = parent.setAttr(name, value)
  def set(values: Seq[String]): Tag[T] =
    if (values.isEmpty) parent.remAttr(name)
    else parent.setAttr(name, values.mkString(" "))
  def has(value: String): Boolean = get.contains(value)
  def add(value: String): Tag[T] = {
    val current = get
    if (current.contains(value)) parent else set(current :+ value)
  }
  def remove(value: String): Tag[T] = set(get.diff(List(value)))
  def clear(): Tag[T] = parent.remAttr(name)
  def toggle(value: String): Tag[T] = {
    val current = get
    if (current.contains(value)) set(current.diff(List(value)))
    else set(current :+ value)
  }
  def state(state: Boolean, value: String): Tag[T] =
    if (state) add(value) else remove(value)
  def update(f: List[String] => List[String]): Tag[T] = set(f(get))

  def apply(): List[String] = get
  def apply(values: String*): Tag[T] = set(values)
}

case class TagRefTokenSetAttribute[T <: Singleton](
  parent: TagRef[T], name: String
) {
  def set(value: String)(implicit renderCtx: RenderContext): Unit =
    renderCtx.render(parent, Diff.SetAttribute(name, value))

  def set(values: Seq[String])(implicit renderCtx: RenderContext): Unit = {
    val diff =
      if (values.isEmpty) Diff.RemoveAttribute(name)
      else Diff.SetAttribute(name, values.mkString(" "))

    renderCtx.render(parent, diff)
  }

  def add(value: String)(implicit renderCtx: RenderContext): Unit =
    update { current =>
      if (current.contains(value)) current
      else current :+ value
    }

  def remove(value: String)(implicit renderCtx: RenderContext): Unit =
    update(_.diff(List(value)))

  def clear()(implicit renderCtx: RenderContext): Unit =
    renderCtx.render(parent, Diff.RemoveAttribute(name))

  def toggle(value: String)(implicit renderCtx: RenderContext): Unit =
    update(values =>
      if (!values.contains(value)) values :+ value
      else values.diff(List(value)))

  def state(state: Boolean, value: String)
            (implicit renderCtx: RenderContext): Unit =
    update(values =>
      if (!state) values.diff(List(value))
      else if (values.contains(value)) values
      else values :+ value)

  def update(f: List[String] => List[String])
            (implicit renderCtx: RenderContext): Unit =
    renderCtx.render(parent, Diff.UpdateAttribute(name, { oldValue =>
      val current =
        oldValue.map(HtmlHelpers.parseTokenSet).getOrElse(List.empty)
      val updated = f(current)
      if (updated.isEmpty) None else Some(updated.mkString(" "))
    }))

  def :=(value: String)(implicit renderCtx: RenderContext): Unit = set(value)
}

object AttributeCodec {
  implicit case object StringAttributeCodec extends AttributeCodec[String] {
    override def encode(value: String): Option[String] = Some(value)
    override def decode(value: Option[String]): String = value.getOrElse("")
  }

  implicit case object IntAttributeCodec extends AttributeCodec[Int] {
    override def encode(value: Int): Option[String] =
      Some(value.toString)

    override def decode(value: Option[String]): Int =
      value.map(_.toInt).getOrElse(0)
  }

  implicit case object LongAttributeCodec extends AttributeCodec[Long] {
    override def encode(value: Long): Option[String] =
      Some(value.toString)

    override def decode(value: Option[String]): Long =
      value.map(_.toLong).getOrElse(0L)
  }

  implicit case object DoubleAttributeCodec extends AttributeCodec[Double] {
    override def encode(value: Double): Option[String] =
      Some(value.toString)

    override def decode(value: Option[String]): Double =
      value.map(_.toDouble).getOrElse(0)
  }

  implicit case object BooleanAttributeCodec extends AttributeCodec[Boolean] {
    override def encode(value: Boolean): Option[String] =
      if (!value) None else Some("")

    override def decode(value: Option[String]): Boolean = value.nonEmpty
  }
}
