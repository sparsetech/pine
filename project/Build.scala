import sbt._
import sbt.Keys._
import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._

object Build extends sbt.Build {
  val SharedSettings = Seq(
    name := "MetaWeb",
    organization := "pl.metastack",
    version := "0.1.2-SNAPSHOT",
    scalaVersion := "2.11.7",
    pomExtra :=
      <url>https://github.com/MetaStack-pl/MetaWeb</url>
        <licenses>
          <license>
            <name>Apache-2.0</name>
            <url>https://www.apache.org/licenses/LICENSE-2.0.html</url>
          </license>
        </licenses>
        <scm>
          <url>git@github.com:MetaStack-pl/MetaWeb.git</url>
        </scm>
        <developers>
          <developer>
            <id>tindzk</id>
            <name>Tim Nieradzik</name>
            <url>http://github.com/tindzk/</url>
          </developer>
        </developers>
  )

  object Dependencies {
    val MetaRx     = "0.1.5-SNAPSHOT"
    val MiniTest   = "0.14"
    val Paradise   = "2.1.0-M5"
    val ScalaJsDom = "0.8.2"
  }

  lazy val root = project.in(file("."))
    .aggregate(js, jvm)
    .settings(SharedSettings: _*)
    .settings(
      publishArtifact := false
    )

  val convertMDN = taskKey[Unit]("Generate MDN bindings")

  lazy val metaWeb = crossProject.in(file("."))
    .settings(SharedSettings: _*)
    .settings(
      testFrameworks += new TestFramework("minitest.runner.Framework"),

      libraryDependencies += "org.scala-lang" % "scala-reflect" % "2.11.7",
      libraryDependencies += "org.scala-lang.modules" % "scala-xml_2.11" % "1.0.5",

      addCompilerPlugin("org.scalamacros" % "paradise" % Dependencies.Paradise cross CrossVersion.full),

      convertMDN := MDNParser.createFiles(new File("shared/src/main/scala"))
    )
    .jvmSettings(
      libraryDependencies ++= Seq(
        "pl.metastack" %% "metarx" % Dependencies.MetaRx,
        "org.monifu" %% "minitest" % Dependencies.MiniTest % "test"
      )
    )
    .jsSettings(
      libraryDependencies ++= Seq(
        "org.scala-js" %%% "scalajs-dom" % Dependencies.ScalaJsDom,
        "pl.metastack" %%% "metarx" % Dependencies.MetaRx,
        "org.monifu" %%% "minitest" % Dependencies.MiniTest % "test"
      ),

      requiresDOM := true,  // For test cases
      scalaJSStage in Global := FastOptStage  // Use Node.js
    )

  lazy val js = metaWeb.js
  lazy val jvm = metaWeb.jvm
}
