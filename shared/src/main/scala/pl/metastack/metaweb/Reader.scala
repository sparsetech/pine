package pl.metastack.metaweb

private[metaweb] class Reader(str: String) {
  private var offset = 0

  def end(): Boolean = offset >= str.length
  def advance(length: Int): Unit = offset += length
  def prefix(s: String): Boolean = rest().startsWith(s)
  def rest(): String = str.substring(offset)

  def collect(f: Char => Boolean): Option[String] = {
    val prevOffset = offset
    var matches = false

    if (!end() && !f(str(offset))) Some("")
    else {
      while (!end() && f(str(offset))) {
        matches = true
        offset += 1
      }

      if (!end()) Some(str.substring(prevOffset, offset))
      else {
        offset = prevOffset
        None
      }
    }
  }

  def collectUntil(c: Char): Option[String] = collect(_ != c)

  def skip(c: Char): Boolean =
    if (end()) false
    else if (str(offset) != c) false
    else {
      offset += 1
      true
    }

  def skip(f: Char => Boolean): Boolean = {
    var skipped = false

    while (!end() && f(str(offset))) {
      skipped = true
      offset += 1
    }

    skipped
  }
}
