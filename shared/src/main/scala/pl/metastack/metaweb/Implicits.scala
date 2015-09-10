package pl.metastack.metaweb

import pl.metastack.metarx.{DeltaBuffer, ReadChannel}
import pl.metastack.metaweb.render.HTMLImplicit

trait Implicits extends HTMLImplicit {
  private def zeroWayText(value: String) = {
    val t = new state.zeroway.Text()
    t.set(value)
    t
  }

  private def oneWayText(value: ReadChannel[String]) = {
    val t = new state.reactive.Text()
    t.listen(value)
    t
  }

  implicit def NumericToText[T](value: T)(implicit num: Numeric[T]): state.zeroway.Text =
    zeroWayText(value.toString)

  implicit def BooleanToText(value: Boolean): state.zeroway.Text =
    zeroWayText(value.toString)

  implicit def StringToText(value: String): state.zeroway.Text =
    zeroWayText(value)

  implicit def StringChannelToText[T <: String](value: ReadChannel[T]): state.reactive.Text =
    oneWayText(value.asInstanceOf[ReadChannel[String]])

  implicit def NumericChannelToText[T](value: ReadChannel[T])
                                       (implicit num: Numeric[T]): state.reactive.Text =
    oneWayText(value.map(_.toString))

  implicit def BooleanChannelToText[T <: Boolean](value: ReadChannel[T]): state.reactive.Text =
    oneWayText(value.map(_.toString))

  implicit def StringChannelToTextChannel[T <: String](value: ReadChannel[T]):
    ReadChannel[state.Node] =
      value.asInstanceOf[ReadChannel[String]].map(zeroWayText)

  implicit def NumericChannelToTextChannel[T](value: ReadChannel[T])
                                      (implicit num: Numeric[T]):
    ReadChannel[state.Node] = value.map(v => zeroWayText(v.toString))

  implicit def BooleanChannelToTextChannel[T <: Boolean](value: ReadChannel[T]):
    ReadChannel[state.Node] = value.map(v => zeroWayText(v.toString))

  implicit def NodeChannelToNode[T <: state.Node](value: ReadChannel[T]): state.reactive.Placeholder = {
    val ph = new state.reactive.Placeholder()
    ph.listen(value.map(v => Some(v)))
    ph
  }

  implicit def OptNodeChannelToNode[T <: Option[state.Node]](value: ReadChannel[T]):
    state.reactive.Placeholder =
  {
    val ph = new state.reactive.Placeholder()
    ph.listen(value.map(v => v.asInstanceOf[Option[state.Node]]))
    ph
  }

  implicit def NodeBufferToNode[T <: state.Node](value: DeltaBuffer[T]):
    state.reactive.Container = {
    val ctr = new state.reactive.Container()
    ctr.listen(value.asInstanceOf[DeltaBuffer[state.Node]])
    ctr
  }

  implicit def NodeSeqToNode[T <: state.Node](value: Seq[T]): state.reactive.Container = {
    val ctr = new state.reactive.Container()
    ctr.set(value.asInstanceOf[Seq[state.Node]])
    ctr
  }

  implicit def StringBufferToNode[T <: String](value: DeltaBuffer[T]): state.reactive.Container = {
    val ctr = new state.reactive.Container()
    ctr.listen(value.asInstanceOf[DeltaBuffer[String]].map(StringToText))
    ctr
  }
}
