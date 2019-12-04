package pine

import scala.annotation.tailrec

private[pine] class Reader(data: String) {
  private var offset = 0

  def rest(): String = data.drop(offset)

  def restAdvance(): String = {
    val result = data.drop(offset)
    offset = data.length
    result
  }

  /** Return next `n` characters (or less) without advancing pointer */
  def take(n: Int): String = data.slice(offset, offset + n)

  /** Returns true if `value` matches */
  def lookahead(value: Char): Boolean = data(offset) == value

  /** Returns true if `value` matches */
  def lookahead(value: String): Boolean = {
    if (value.length > data.length - offset) false
    else {
      var i = 0
      while (i < value.length) {
        if (value(i) != data(offset + i)) return false
        i += 1
      }

      true
    }
  }

  /** Returns true if `value` matches and places pointer afterwards */
  def prefix(value: Char): Boolean =
    data(offset) == value && {
      offset += 1
      true
    }

  /** Returns true if `value` matches and places pointer afterwards */
  def prefix(value: String): Boolean =
    lookahead(value) && {
      offset += value.length
      true
    }

  /** Returns true if `value` matches regardless of case and places pointer
    * afterwards
    */
  def prefixIgnoreCase(value: String): Boolean =
    take(value.length).equalsIgnoreCase(value) && {
      offset += value.length
      true
    }

  /** Aggregates all characters until f(c) returns true */
  def collectUntil(f: Char => Boolean): Option[String] = {
    @tailrec def iter(ofs: Int): Option[Int] =
      if (ofs == data.length) None
      else if (f(data(ofs))) Some(ofs)
      else iter(ofs + 1)

    iter(offset).map { ofs =>
      val result = data.slice(offset, ofs)
      offset = ofs
      result
    }
  }

  /** Aggregates all characters until `value` */
  def collectUntil(value: Char): Option[String] = collectUntil(_ == value)

  /** Aggregates all characters until `value` and places pointer afterwards */
  def collect(value: Char): Option[String] =
    collectUntil(_ == value).map { result =>
      offset += 1
      result
    }

  /** Aggregates all characters until `value` and places pointer afterwards */
  def collect(value: String): Option[String] = {
    val sub = data.drop(offset)
    sub.indexOf(value) match {
      case -1  => None
      case len =>
        offset += len + value.length
        Some(sub.take(len))
    }
  }

  /** Advances pointer while f(c) returns true */
  @tailrec final def skip(f: Char => Boolean): Unit =
    if (offset < data.length && f(data(offset))) {
      offset += 1
      skip(f)
    }
}
