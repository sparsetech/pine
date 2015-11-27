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

  def collectIds(node: scala.xml.Node): Map[String, String] = {
    node.label match {
      case "#PCDATA" => Map.empty
      case tag =>
        val tagAttrs = node.attributes.asAttrMap

        val childrenPaths = node.child.flatMap { n =>
          collectIds(n)
        }.toMap

        if (!tagAttrs.isDefinedAt("id")) childrenPaths
        else Map(tagAttrs("id") -> capitalise(node.label)) ++
          childrenPaths
    }
  }

  def collectPaths(node: scala.xml.Node,
                   path: Seq[String] = Seq.empty): Map[String, Seq[String]] = {
    node.label match {
      case "#PCDATA" => Map.empty
      case tag =>
        val tagAttrs = node.attributes.asAttrMap

        val fullPath =
          if (!tagAttrs.isDefinedAt("id")) path
          else path ++ Seq(toCamelCase(tagAttrs("id")))

        val childrenPaths = node.child.flatMap { n =>
          collectPaths(n, fullPath)
        }.toMap

        if (!tagAttrs.isDefinedAt("id")) childrenPaths
        else Map(toCamelCase(tagAttrs("id")) -> fullPath) ++ childrenPaths
    }
  }

  def childAttributes(node: scala.xml.Node, objName: String): Seq[String] =
    node.child.flatMap { n =>
      val tagAttrs = n.attributes.asAttrMap
      if (tagAttrs.isDefinedAt("id")) {
        val id = tagAttrs("id")
        Seq(s"""val ${toCamelCase(id)} = new $objName.${encodeId(id)}""")
      } else childAttributes(n, objName)
    }

  val extractedTags = ArrayBuffer.empty[String]

  def tagName(node: scala.xml.Node): String = {
    val tag = node.label
    Option(node.prefix).map(pfx => s"$pfx:$tag").getOrElse(tag)
  }

  def rootAttributes(root: Boolean,
                     node: scala.xml.Node): Map[String, String] =
    if (root) namespaceBinding(node.scope)
    else Map.empty

  def tagAttrs(root: Boolean, node: scala.xml.Node) =
    node.attributes.asAttrMap ++ rootAttributes(root, node)

  def strTagAttrs(root: Boolean, node: scala.xml.Node) =
    tagAttrs(root, node).map { case (k, v) =>
      s"""attribute("$k") := ${createWrappedString(v)}"""
    }.mkString("\n")

  def tagChildren(node: scala.xml.Node, objName: String): String =
    node.child.map { n =>
      val c = convert(n, objName, root = false)
      s"append($c)"
    }.mkString("\n")

  def scalaRep(node: scala.xml.Node,
               objName: String,
               root: Boolean,
               inline: Boolean): String =
    s"""tag.${capitalise(tagName(node))} {${if (inline) "" else " self =>"}
      ${if (!inline) childAttributes(node, objName).mkString("\n") else ""}
      ${strTagAttrs(root, node)}
      ${tagChildren(node, objName)}
    }"""

  def findNode(node: scala.xml.Node, tagName: String): Option[scala.xml.Node] = {
    if (node.label == tagName) Some(node)
    else node.child.collectFirst {
      case x if findNode(x, tagName).nonEmpty => findNode(x, tagName).get
    }
  }

  def convert(node: scala.xml.Node,
              objName: String,
              root: Boolean = true): String = {
    (node.label, Option(node.prefix)) match {
      case ("#PCDATA", _) => s"tree.Text(${createWrappedString(node.text)})"
      case (tag, prefix) =>
        if (root) {
          val extractedIds = collectIds(node)
            .map { case (id, tpe) => s"def ${toCamelCase(id)}: tag.$tpe" }
            .mkString("\n")

          val formattedPaths = collectPaths(node)
            .filter { case (id, path) => path.size > 1 }
            .map { case (id, path) => s"val $id = " + path.mkString(".") }
            .mkString("\n")

          val headNode = findNode(node, "head").get
          val bodyNode = findNode(node, "body").get

          s"""
          trait $objName {
            $extractedIds
            def head: tag.Head
            def body: tag.Body
          }
          class ${objName}Render extends $objName { self =>
            ${childAttributes(node, objName).mkString("\n")}
            $formattedPaths
            override val head = new ${scalaRep(headNode, objName, root, true)}
            override val body = new ${scalaRep(bodyNode, objName, root, true)}
          }
          """
        } else if (tagAttrs(root, node).isDefinedAt("id")) {
          val id = tagAttrs(root, node)("id")
          if (id == "head" || id == "body")
            throw new RuntimeException(s"ID `$id` is a reserved name")
          extractedTags += s"""class ${encodeId(id)} extends ${scalaRep(node, objName, root, false)}"""
          "self." + toCamelCase(id)
        } else s"new ${scalaRep(node, objName, root, true)}"
    }
  }

  def fileName(path: String): String = path.split('/').last

  def htmlToScala(htmlFile: String, packageName: String): String = {
    extractedTags.clear()

    val xml = XML.loadFile(htmlFile)
    val objName = (fileName _).andThen(base)(htmlFile)
    val scala = convert(xml, objName)

    s"""
    package $packageName
    import pl.metastack.metaweb._
    object $objName {
      ${extractedTags.mkString("\n")}
    }
    $scala
    """
  }

  def htmlToScalaJs(htmlFile: String,
                    packageName: String): (String, String) = {
    val xml = XML.loadFile(htmlFile)
    val objName = (fileName _).andThen(base)(htmlFile)

    val extracted = collectIds(xml).map { case (id, tpe) =>
      s"""override val ${toCamelCase(id)} = render.DOM.proxy[tag.$tpe]("$id")"""
    }.mkString("\n")

    (objName, s"""
    package $packageName
    import org.scalajs.dom
    import pl.metastack.metaweb._
    class ${objName}Attach extends $objName {
      override val head = render.DOM.proxy[tag.Head](dom.document.head)
      override val body = render.DOM.proxy[tag.Body](dom.document.body)
      $extracted
    }
    """)
  }

  def generate(subProjects: Seq[String],
               packageName: String,
               log: Logger): Seq[File] = {
    subProjects.flatMap { subProject =>
      val file = new File(subProject, "src/main/html")
      if (!file.exists()) Seq.empty
      else {
        val files = file.listFiles().toSeq
        files.filter(_.getPath.endsWith(".html")).map { file =>
          val targetPath = this.targetPath(file.getPath, packageName)
          val targetFile = new File(targetPath)

          IO.write(targetFile, htmlToScala(file.getPath, packageName))
          log.info(s"Written $targetPath")

          val (objName, code) = htmlToScalaJs(file.getPath, packageName)

          val jsAttachPath =
            new File("js/src/main/scala/" +
              packageName.replaceAllLiterally(".", "/"))
          jsAttachPath.mkdirs()
          val jsAttachFile = new File(jsAttachPath, objName + "Attach.scala")

          IO.write(jsAttachFile, code)
          log.info(s"Written ${jsAttachFile.getPath}")

          targetFile
        }
      }
    }
  }
}