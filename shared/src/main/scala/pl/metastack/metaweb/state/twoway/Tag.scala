package pl.metastack.metaweb.state.twoway

import pl.metastack.metarx.{ReadChannel, Channel}
import pl.metastack.metaweb.state

class Tag(name: String) extends state.oneway.Tag(name) with Node {
  override def ways = 2

  def bindAttribute[T](attribute: String, ch: Channel[T]): ReadChannel[Unit] = {
    val ignore = ch.attach { value =>
      _attributes.insertOrUpdate(attribute, value)
    }

    ch << (_attributes.value(attribute).values.tail.asInstanceOf[ReadChannel[T]], ignore)
  }

  def bindAttributeOpt[T](attribute: String, ch: Channel[Option[T]]): ReadChannel[Unit] = {
    // TODO Provide Dict.bind(key, ch)

    val ignore = ch.attach {
      case None => _attributes.removeIfExists(attribute)
      case Some(v) => _attributes.insertOrUpdate(attribute, v)
    }

    ch << (_attributes.value(attribute).tail.asInstanceOf[ReadChannel[Option[T]]], ignore)
  }
}
