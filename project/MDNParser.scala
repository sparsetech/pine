import java.io.{PrintWriter, File}
import java.nio.file.{Paths, Files}

import org.jsoup.Jsoup
import org.jsoup.nodes.Document

import scala.collection.JavaConverters._

import scalaj.http._

object MDNParser {
  case class Element(tag: String, description: String, attributes: Seq[Attribute])
  case class Attribute(name: String, deprecated: Boolean, description: String)

  val cache = new File("cache/")
  cache.mkdir()

  val ElementsUrl = "https://developer.mozilla.org/en-US/docs/Web/HTML/Element"
  val GlobalAttributesUrl = "https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes"
  val AdditionalTagUrls = Set("a", "b", "span")
    .map(ElementsUrl + "/" + _)

  def encodeFileName(url: String) =
    url.flatMap {
      case ':' | '/' => Seq('_')
      case c => Seq(c)
    } + ".html"

  def printToFile(f: java.io.File)(op: java.io.PrintWriter => Unit) {
    val p = new java.io.PrintWriter(f)
    try op(p) finally p.close()
  }

  def request(url: String): String = {
    val fileName = encodeFileName(url)
    val file = new File(cache, fileName)

    if (file.exists()) io.Source.fromFile(file).mkString
    else {
      val response = Http(url).asString

      response.location match {
        case Some(location) =>
          val link = Paths.get(file.getPath)
          val target = Paths.get(encodeFileName(location))
          Files.createSymbolicLink(link, target)

          request(location)

        case _ =>
          val result = response.body
          printToFile(file)(_.write(result))
          result
      }
    }
  }

  def writeGlobalAttrs(path: File,
                       elements: Set[Element],
                       attributes: Seq[Attribute]): File = {
    val file = new File(path, "HTMLTag.scala")
    printToFile(file) { p =>
      writeHeader(p)
      p.println(s"""trait HTMLTag { self: Tag =>""")
      writeAttributes(p, attributes)
      p.println("}")
      p.println()
      p.println("""object HTMLTag {""")
      p.println("""  def fromTag(tag: String): Tag =""")
      p.println("""    tag match {""")
      elements.toList.sortBy(_.tag).foreach { element =>
        val className = escapeScalaName(element.tag)
        p.println(s"""      case "${element.tag}" => new $className""")
      }
      p.println("""    }""")
      p.println("""}""")
    }
    file
  }

  def writeHeader(p: PrintWriter) {
    p.println("package pl.metastack.metaweb.tag")
    p.println()
    p.println("import pl.metastack.metaweb.Tag")
    p.println()
  }

  def writeElement(path: File,
                   globalAttributes: Seq[Attribute],
                   element: Element): File = {
    val file = new File(path, element.tag + ".scala")
    printToFile(file) { p =>
      writeHeader(p)
      val scalaTagName = escapeScalaName(element.tag)

      // TODO Use absolute URLs
      val description = escapeScalaComment(element.description)

      p.println( s"""/**""")
      p.println( s""" * $description""")
      p.println( s""" */""")
      p.println(s"""class $scalaTagName extends Tag("${element.tag}") with HTMLTag {""")

      val uniqueAttrs = element.attributes.filter { attr =>
        val exists = globalAttributes.exists(_.name == attr.name)
        if (exists) println(s"`${element.tag}` redefines global attribute `${attr.name}`")
        !exists
      }

      writeAttributes(p, uniqueAttrs)
      p.println("}")
      p.println()
      p.println(s"""object $scalaTagName { def apply() = new $scalaTagName }""")
    }
    file
  }

  def escapeScalaName(name: String): String =
    name match {
      case "type" | "class" | "object" | "for" => "`" + name + "`"
      case _ if name.contains("-") => "`" + name + "`"
      case _ => name
    }

  def escapeScalaComment(comment: String): String =
    comment.replaceAll("""\/\*""", "/")

  def writeAttributes(p: PrintWriter, attributes: Seq[Attribute]) {
    attributes.foreach { attribute =>
      if (attribute.name != "data-*") {
        val attrName = escapeScalaName(attribute.name)
        val description = escapeScalaComment(attribute.description)

        p.println( s"""  /**""")
        p.println( s"""   * $description""")
        p.println( s"""   */""")
        p.println( s"""  def $attrName: Option[String] = attributes.get("${attribute.name}").asInstanceOf[Option[String]]""")
        p.println( s"""  def $attrName(value: String) = attributes.insertOrUpdate("${attribute.name}", value)""")
      }
    }
  }

  def globalAttributes(): Seq[Attribute] = {
    val document = Jsoup.parse(request(GlobalAttributesUrl))
    document.setBaseUri(GlobalAttributesUrl)

    parseAttributes(document)
  }

  def parseAttributes(document: Document): Seq[Attribute] = {
    val attributes = document.select("article > dl > dt").asScala

    attributes.flatMap { attr =>
      val docs = attr.nextElementSibling() match {
        case next if next != null && next.nodeName() == "dd" => next.html()
        case _ => ""
      }

      val name = attr.select("code").text()

      // See https://developer.mozilla.org/en-US/docs/Web/HTML/Element/li
      val deprecated = attr.select("i.icon-thumbs-down-alt").size() != 0

      // See https://developer.mozilla.org/en-US/docs/Web/HTML/Element/link
      val deleted = attr.select("i.icon-trash").size() != 0

      // See https://developer.mozilla.org/en-US/docs/Web/HTML/Element/a
      val obsolete = attr.select("span.obsolete").size() != 0

      if (name.isEmpty) None
      else Some(Attribute(name, deprecated || deleted || obsolete, docs))
    }
  }

  def processElement(url: String): Option[Element] = {
    val document = Jsoup.parse(request(url))
    document.setBaseUri(url)

    val article = document.select("article")

    // https://developer.mozilla.org/en-US/docs/Web/HTML/Element/decorator
    if (article.select("h1").text() == "Document Deleted") None
    // https://developer.mozilla.org/en-US/docs/Web/HTML/Element/noembed
    else if (article.select("div.nonStandard").size() != 0) None
    else {
      val tag = url.split('/').last

      // Read contents between first headline ("Summary") and second ("Attributes")
      val headlines = article.select("h2")
      val (fst, snd) = (headlines.first(), headlines.get(1))
      val articleChildren = article.first().children()
      val descriptionElements = articleChildren.subList(
        fst.elementSiblingIndex() + 1,
        snd.elementSiblingIndex())

      val description = descriptionElements.asScala
        .filterNot(_.hasClass("htmlelt"))  // Filter box with meta information
        .map(_.html())
        .mkString("\n")

      Some(Element(tag, description, parseAttributes(document)))
    }
  }

  def createFiles(managedPath: File) = {
    val tagsPath = new File(managedPath, "pl/metastack/metaweb/tag")
    tagsPath.mkdirs()

    val document = Jsoup.parse(request(ElementsUrl))
    document.setBaseUri(ElementsUrl)

    val elements = document.select("""[style="vertical-align: top;"]""")
      .select("a")
      .asScala
      .map(_.absUrl("href"))
      .toSet

    AdditionalTagUrls.foreach { additionalTag =>
      if (!elements.contains(additionalTag))
        println(s"Link $additionalTag missing in index")
    }

    val globalAttrs = globalAttributes()

    val parsedElements = (elements ++ AdditionalTagUrls).flatMap(processElement)
    val elemsFiles = parsedElements.map(writeElement(tagsPath, globalAttrs, _))
    val attrsFile = writeGlobalAttrs(tagsPath, parsedElements, globalAttrs)

    elemsFiles.toSeq :+ attrsFile
  }
}