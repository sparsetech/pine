package pl.metastack.metaweb.state.twoway

import pl.metastack.metarx.{ReadChannel, Channel}
import pl.metastack.metaweb.state

class Tag(name: String) extends state.oneway.Tag(name) with Node {
  override def ways = 2

  def bindAttribute(attribute: String, ch: Channel[Any]): ReadChannel[Unit] = {
    val ignore = ch.attach { value =>
      _attributes.insertOrUpdate(attribute, value)
    }

    ch << (_attributes.value(attribute).values, ignore)
  }

  def bindAttributeOpt(attribute: String, ch: Channel[Option[Any]]): ReadChannel[Unit] = {
    // TODO Provide Dict.bind(key, ch)

    val ignore = ch.attach {
      case None => _attributes.removeIfExists(attribute)
      case Some(v) => _attributes.insertOrUpdate(attribute, v)
    }

    ch << (_attributes.value(attribute), ignore)
  }
}
