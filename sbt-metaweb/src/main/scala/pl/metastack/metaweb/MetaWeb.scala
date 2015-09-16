package pl.metastack.metaweb

import java.io.File

import sbt._
import sbt.Keys.streams

import scala.collection.mutable.ArrayBuffer
import scala.xml.{XML, NamespaceBinding}

object MetaWeb extends AutoPlugin {
  object autoImport {
    lazy val metawebGenerate = TaskKey[Seq[File]]("metaweb-generate", "Generate Scala files for HTML templates")
    lazy val metawebTargetPackage = SettingKey[String]("metaweb-target", "Target package")
    lazy val metawebSubProjects = SettingKey[Seq[String]]("metaweb-subprojects", "Sub-projects to scan for HTML files (must be stored in src/main/html)")
  }

  import autoImport._

  override lazy val projectSettings = Seq(
    metawebSubProjects := Seq(),
    metawebTargetPackage := "view",
    metawebGenerate := generate(metawebSubProjects.value, metawebTargetPackage.value, streams.value.log)
  )

  def base(fileName: String): String =
    fileName.split('.').init.mkString(".")

  def mapToPackage(path: String, packageName: String): String =
    path.replace("src/main/html/", "src/main/scala/" + packageName.replaceAllLiterally(".", "/") + "/")

  def targetPath(htmlFile: String, packageName: String): String =
    (mapToPackage(_: String, packageName)).andThen(base)(htmlFile) + ".scala"

  def namespaceBinding(scope: NamespaceBinding): Map[String, String] =
    if (scope == null || scope.prefix == null) Map.empty
    else Map(s"xmlns:${scope.prefix}" -> scope.uri) ++
      namespaceBinding(scope.parent)

  /** @author Matt Hicks */
  def createWrappedString(s: String) =
    if (s.trim.nonEmpty) {
      val preWhitespace = s.charAt(0).isWhitespace
      val postWhitespace = s.charAt(s.length - 1).isWhitespace
      val b = new StringBuilder
      if (preWhitespace) b.append(' ')
      b.append(s.trim)
      if (postWhitespace) b.append(' ')
      val trimmed = b.toString()
      if (s.indexOf('\n') != -1) "\"\"\"%s\"\"\"".format(trimmed)
      else "\"%s\"".format(trimmed.replaceAll("\"", "\\\\\""))
    } else if (s.isEmpty) "\"\""
    else "\" \""

  /**
   * Converts space and dash separated to camel-case.
   * @author Matt Hicks
   */
  def toCamelCase(name: String) =
    "[- _]([a-zA-Z0-9])".r.replaceAllIn(name, m => m.group(1).toUpperCase)

  def encodeId(id: String): String =
    (toCamelCase _).andThen(capitalise)(id)

  def capitalise(s: String): String = s.head.toUpper + s.tail

  val extractedTags = ArrayBuffer.empty[String]
  val tagInstances = ArrayBuffer.empty[String]

  def convert(node: scala.xml.Node, root: Boolean, objName: String): String = {
    (node.label, Option(node.prefix)) match {
      case ("#PCDATA", _) => s"tree.Text(${createWrappedString(node.text)})"
      case (tag, prefix) =>
        val tagName = prefix.map(pfx => s"$pfx:$tag").getOrElse(tag)
        val rootAttributes: Map[String, String] =
          if (root) namespaceBinding(node.scope)
          else Map.empty

        val tagAttrs = node.attributes.asAttrMap ++ rootAttributes

        val strTagAttrs = tagAttrs.map { case (k, v) =>
          s"""attribute("$k") := ${createWrappedString(v)}"""
        }.mkString("\n")

        val tagChildren = node.child.map { n =>
          val c = convert(n, root = false, objName)
          s"append($c)"
        }.mkString("\n")

        val scalaRep =
          s"""tag.${capitalise(tagName)} {
            $strTagAttrs
            $tagChildren
          }"""

        if (root) {
          val t = tagInstances.mkString("\n")
          s"""class $objName {
            $t
            ${if (root) "val base = this" else ""}
            val view = new $scalaRep
          }
          """
        } else if (tagAttrs.isDefinedAt("id")) {
          val id = tagAttrs("id")
          if (id == "base" || id == "view")
            throw new RuntimeException(s"ID `$id` is a reserved name")
          extractedTags += s"""class ${encodeId(id)}(base: $objName) extends $scalaRep"""
          tagInstances += s"""val ${toCamelCase(id)} = new $objName.${encodeId(id)}(this)"""
          "base." + toCamelCase(id)
        } else s"new $scalaRep"
    }
  }

  def fileName(path: String): String = path.split('/').last

  def htmlToScala(htmlFile: String, packageName: String): String = {
    extractedTags.clear()
    tagInstances.clear()

    val xml = XML.loadFile(htmlFile)
    val objName = (fileName _).andThen(base)(htmlFile)
    val scala = convert(xml, root = true, objName)

    s"""
    package $packageName
    import pl.metastack.metaweb._
    object $objName {
      ${extractedTags.mkString("\n")}
    }
    $scala
    """
  }

  def generate(subProjects: Seq[String], packageName: String, log: Logger): Seq[File] = {
    subProjects.flatMap { subProject =>
      val file = new File(subProject, "src/main/html")
      if (!file.exists()) Seq.empty
      else {
        val files = file.listFiles().toSeq
        files.map { file =>
          val targetPath = this.targetPath(file.getPath, packageName)
          val targetFile = new File(targetPath)
          IO.write(targetFile, htmlToScala(file.getPath, packageName))
          log.info(s"Written $targetPath")
          targetFile
        }
      }
    }
  }
}