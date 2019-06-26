package pine

object XmlEntities {
  /** @see https://www.w3.org/TR/REC-xml/#sec-predefined-ent */
  val entities: Map[String, String] = Map(
    "lt" -> "\u003C",
    "gt" -> "\u003E",
    "amp" -> "\u0026",
    "apos" -> "\u0027",
    "quot" -> "\u005C\u0022"
  )
}
