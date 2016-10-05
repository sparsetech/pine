package pl.metastack.metaweb

private[metaweb] class Reader(str: String) {
  private var offset = 0

  def end(): Boolean = offset >= str.length
  def advance(length: Int): Unit = offset += length
  def prefix(c: Char): Boolean = str(offset) == c
  def prefix(s: String): Boolean = rest().startsWith(s)
  def current(): Char = str(offset)
  def rest(): String = str.substring(offset)

  def collect(f: () => Boolean): Option[String] = {
    val prevOffset = offset
    var matches = false

    if (!end() && !f()) Some("")
    else {
      while (!end() && f()) {
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

  def collectUntil(s: String): Option[String] = collect(() => !prefix(s))
  def collectUntil(c: Char): Option[String] = collect(() => !prefix(c))

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
