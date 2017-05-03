package pl.metastack.metaweb

import scala.annotation.tailrec

private[metaweb] class Reader(data: String) {
  private var offset = 0

  def end()               : Boolean = offset >= data.length
  def advance(length: Int): Unit    = offset += length

  def current(): Char   = data(offset)
  def rest()   : String = data.drop(offset)

  def prefix(value : Char  ): Boolean = data(offset) == value
  def prefix(values: String): Boolean = rest().startsWith(values)

  def collectUntil(f: Char => Boolean): Option[String] = {
    @tailrec def iter(ofs: Int): Option[Int] =
      if (ofs == data.length) None
      else if (!f(data(ofs))) Some(ofs)
      else iter(ofs + 1)

    iter(offset).map { ofs =>
      val result = data.slice(offset, ofs)
      offset = ofs
      result
    }
  }

  def collectUntil(value : Char  ): Option[String] = collectUntil(value != _)
  def collectUntil(values: String): Option[String] = {
    val sub = data.drop(offset)
    sub.indexOf(values) match {
      case -1  => None
      case len =>
        offset += len
        Some(sub.take(len))
    }
  }

  def skip(value: Char): Unit = if (!end() && current() == value) advance(1)

  @tailrec final def skip(f: Char => Boolean): Unit =
    if (!end() && f(current())) {
      advance(1)
      skip(f)
    }
}
