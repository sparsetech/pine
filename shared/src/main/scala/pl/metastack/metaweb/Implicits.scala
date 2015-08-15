package pl.metastack.metaweb

import pl.metastack.metarx.{DeltaBuffer, ReadChannel, Var}
import pl.metastack.metaweb.tree._

trait Implicits {
  private def varFor[T](ipt: ReadChannel[T], default: T): Var[T] = {
    val v = Var[T](default)
    v << ipt
    v
  }

  implicit def NumericToText[T](value: T)(implicit num: Numeric[T]): Text =
    Text(Var(value.toString))

  implicit def BooleanToText(value: Boolean): Text =
    Text(Var(value.toString))

  implicit def StringToText(value: String): Text = Text(Var(value))

  implicit def StringChannelToText[T <: String](value: ReadChannel[T]): Text =
    Text(varFor(value.asInstanceOf[ReadChannel[String]], ""))

  implicit def NumericChannelToText[T](value: ReadChannel[T])
                                       (implicit num: Numeric[T]): Text =
    Text(varFor(value.map(_.toString), ""))

  implicit def BooleanChannelToText[T <: Boolean](value: ReadChannel[T]): Text =
    Text(varFor(value.map(_.toString), ""))

  implicit def NodeChannelToNode[T <: Node](value: ReadChannel[T]): PlaceholderNode =
    PlaceholderNode(value.asInstanceOf[ReadChannel[Node]])

  implicit def OptNodeChannelToNode[T <: Option[Node]](value: ReadChannel[T]):
    PlaceholderOptNode = PlaceholderOptNode(value.asInstanceOf[ReadChannel[Option[Node]]])

  implicit def NodeBufferToNode[T <: Node](value: DeltaBuffer[T]):
    PlaceholderListNode = PlaceholderListNode(value.asInstanceOf[DeltaBuffer[Node]])

  implicit def NodeSeqToNode[T <: Node](value: Seq[T]): PlaceholderSeqNode =
    PlaceholderSeqNode(value.asInstanceOf[Seq[Node]])

  implicit def StringBufferToNode[T <: String](value: DeltaBuffer[T]):
    PlaceholderListNode = PlaceholderListNode(value.map(v => Text(Var(v))))
}
