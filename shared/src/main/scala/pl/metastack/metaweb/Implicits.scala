package pl.metastack.metaweb

import pl.metastack.metarx.{DeltaBuffer, ReadChannel}

import pl.metastack.metaweb.render.HTMLImplicit

trait Implicits extends HTMLImplicit {
  private def stateText(value: ReadChannel[String]): state.Text = {
    val t = new state.Text()
    t.listen(value)
    t
  }

  implicit def NumericToText[T](value: T)(implicit num: Numeric[T]): tree.Text =
    tree.Text(value.toString)

  implicit def BooleanToText(value: Boolean): tree.Text = tree.Text(value.toString)

  implicit def StringToText(value: String): tree.Text = tree.Text(value)

  implicit def StringChannelToText[T <: String](value: ReadChannel[T]): state.Text =
    stateText(value.asInstanceOf[ReadChannel[String]])

  implicit def NumericChannelToText[T](value: ReadChannel[T])
                                       (implicit num: Numeric[T]): state.Text =
    stateText(value.map(_.toString))

  implicit def BooleanChannelToText[T <: Boolean](value: ReadChannel[T]): state.Text =
    stateText(value.map(_.toString))

  implicit def StringChannelToTextChannel[T <: String](value: ReadChannel[T]):
    ReadChannel[Node] =
      value.asInstanceOf[ReadChannel[String]].map(tree.Text)

  implicit def NumericChannelToTextChannel[T](value: ReadChannel[T])
                                      (implicit num: Numeric[T]):
    ReadChannel[Node] = value.map(v => tree.Text(v.toString))

  implicit def BooleanChannelToTextChannel[T <: Boolean](value: ReadChannel[T]):
    ReadChannel[Node] = value.map(v => tree.Text(v.toString))

  implicit def NodeChannelToNode[T <: Node](value: ReadChannel[T]): state.Placeholder = {
    val ph = new state.Placeholder()
    ph.listen(value.map(v => Some(v)))
    ph
  }

  implicit def OptNodeChannelToNode[T <: Option[Node]](value: ReadChannel[T]): state.Placeholder = {
    val ph = new state.Placeholder()
    ph.listen(value.map(v => v.asInstanceOf[Option[Node]]))
    ph
  }

  implicit def NodeBufferToNode[T <: Node](value: DeltaBuffer[T]): state.Container = {
    val ctr = new state.Container()
    ctr.listen(value.asInstanceOf[DeltaBuffer[Node]])
    ctr
  }

  implicit def NodeSeqToNode[T <: Node](value: Seq[T]): state.Container = {
    val ctr = new state.Container()
    ctr.set(value.asInstanceOf[Seq[Node]])
    ctr
  }

  implicit def StringBufferToNode[T <: String](value: DeltaBuffer[T]): state.Container = {
    val ctr = new state.Container()
    ctr.listen(value.asInstanceOf[DeltaBuffer[String]].map(StringToText))
    ctr
  }
}
