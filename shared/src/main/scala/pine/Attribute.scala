package pine

trait AttributeCodec[T] {
  def encode(value: T): Option[String]
  def decode(value: Option[String]): T
}

case class TagAttribute[T <: Singleton, U](parent: Tag[T], name: String)
                                          (implicit val codec: AttributeCodec[U]) {
  def apply(): U = codec.decode(parent.attr(name))
  def apply(value: U): Tag[T] =
    codec.encode(value) match {
      case None    => parent.remAttr(name)
      case Some(v) => parent.setAttr(name, v)
    }
}

case class TagRefAttribute[T <: Singleton, U](parent: TagRef[T], name: String)
                                             (implicit val codec: AttributeCodec[U]) {
  def set(value: U)(implicit renderCtx: RenderContext): Unit =
    renderCtx.render(parent, Diff.SetAttribute(this, value))

  def update(f: U => U)(implicit renderCtx: RenderContext): Unit =
    renderCtx.render(parent, Diff.UpdateAttribute(this, f))

  def remove()(implicit renderCtx: RenderContext): Unit =
    renderCtx.render(parent, Diff.RemoveAttribute(this))

  def :=(value: U)(implicit renderCtx: RenderContext): Unit = set(value)
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
