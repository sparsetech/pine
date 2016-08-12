package pl.metastack.metaweb

/*import java.io.{File, FileWriter}

object GenerateEntities extends App {
  // File can be obtained from https://hackage.haskell.org/package/html5-entity-0.2.0.3/src/generation/entities.json
  val entities = io.Source.fromFile(new java.io.File("entities.json")).getLines().toList.flatMap { line =>
    val entity = "&(\\w*);\"".r.findFirstMatchIn(line)

    entity.map { e =>
      val characters = "characters\": \"(.*)\"".r.findFirstMatchIn(line)

      val entityStr = e.group(1)
      val charactersStr =
        if (characters.get.group(1) == "\\u005C") "\\u005C\\u005C"
        else if (characters.get.group(1) == "\\u0022") "\\u005C\\u0022"
        else characters.get.group(1)

      s""""$entityStr" -> \"$charactersStr\""""
    }
  }

  val fw = new FileWriter(new File("shared/src/main/scala/pl/metastack/metaweb/HtmlEntities.scala"))
  fw.append("package pl.metastack.metaweb\n\n")
  fw.append("object HtmlEntities {\n")
  fw.append("  val entities: scala.collection.Map[String, String] = scala.collection.Map(\n")
  entities.zipWithIndex.foreach { case (entity, i) =>
    if (i + 1 == entities.length) fw.append("    " + entity + "\n")
    else fw.append("    " + entity + ",\n")
  }
  fw.append("  )\n")
  fw.append("}")
  fw.flush()
  fw.close()
}*/
