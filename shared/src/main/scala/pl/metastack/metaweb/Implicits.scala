package pl.metastack.metaweb

import pl.metastack.metarx.{DeltaBuffer, ReadChannel, Var}

import pl.metastack.metaweb.tree.Node
import pl.metastack.metaweb.tree.{mutable, immutable}

trait Implicits {
  private def varFor[T](ipt: ReadChannel[T], default: T): Var[T] = {
    val v = Var[T](default)
    v << ipt
    v
  }

  implicit def NumericToText[T](value: T)(implicit num: Numeric[T]): immutable.Text =
    immutable.Text(value.toString)

  implicit def BooleanToText(value: Boolean): immutable.Text =
    immutable.Text(value.toString)

  implicit def StringToText(value: String): immutable.Text =
    immutable.Text(value)

  implicit def StringChannelToText[T <: String](value: ReadChannel[T]): mutable.Text =
    mutable.Text(varFor(value.asInstanceOf[ReadChannel[String]], ""))

  implicit def NumericChannelToText[T](value: ReadChannel[T])
                                       (implicit num: Numeric[T]): mutable.Text =
    mutable.Text(varFor(value.map(_.toString), ""))

  implicit def BooleanChannelToText[T <: Boolean](value: ReadChannel[T]): mutable.Text =
    mutable.Text(varFor(value.map(_.toString), ""))

  implicit def NodeChannelToNode[T <: Node](value: ReadChannel[T]): mutable.PlaceholderNode =
    mutable.PlaceholderNode(value.asInstanceOf[ReadChannel[Node]])

  implicit def OptNodeChannelToNode[T <: Option[Node]](value: ReadChannel[T]):
    mutable.PlaceholderOptNode = mutable.PlaceholderOptNode(value.asInstanceOf[ReadChannel[Option[Node]]])

  implicit def NodeBufferToNode[T <: Node](value: DeltaBuffer[T]):
    mutable.PlaceholderListNode = mutable.PlaceholderListNode(value.asInstanceOf[DeltaBuffer[Node]])

  implicit def NodeSeqToNode[T <: Node](value: Seq[T]): immutable.PlaceholderSeqNode =
    immutable.PlaceholderSeqNode(value.asInstanceOf[Seq[Node]])

  implicit def StringBufferToNode[T <: String](value: DeltaBuffer[T]):
    mutable.PlaceholderListNode = mutable.PlaceholderListNode(value.map(immutable.Text(_)))
}
