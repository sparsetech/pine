import sbt._
import sbt.Keys._
import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._

object Build extends sbt.Build {
  val SharedSettings = Seq(
    organization := "pl.metastack",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := "2.11.7"
  )

  object Dependencies {
    val MetaRx   = "0.1.0"
    val MiniTest = "0.12"
    val Paradise = "2.1.0-M5"
  }

  lazy val root = project.in(file("."))
    .aggregate(js, jvm)
    .settings(
      publishArtifact := false
    )

  val convertMDN = (sourceManaged in Compile).map(MDNParser.createFiles)

  lazy val metaRx = crossProject.in(file("."))
    .settings(
      name := "MetaWeb",
      testFrameworks += new TestFramework("minitest.runner.Framework")
    )
    .settings(SharedSettings: _*)
    .jvmSettings(
      libraryDependencies ++= Seq(
        "pl.metastack" %% "metarx" % Dependencies.MetaRx,
        "org.monifu" %% "minitest" % Dependencies.MiniTest % "test"
      )
    )
    .jsSettings(
      libraryDependencies ++= Seq(
        "pl.metastack" %%% "metarx" % Dependencies.MetaRx,
        "org.monifu" %%% "minitest" % Dependencies.MiniTest % "test"
      )
    )

  lazy val metaRxMacros: Project = project.in(file("macros"))
    .settings(SharedSettings: _*)
    .settings(
      libraryDependencies += "org.scala-lang" % "scala-reflect" % "2.11.7",
      libraryDependencies += "org.scala-lang.modules" % "scala-xml_2.11" % "1.0.5",
      libraryDependencies += "pl.metastack" %% "metarx" % Dependencies.MetaRx,

      sourceGenerators in Compile <+= convertMDN,

      addCompilerPlugin("org.scalamacros" % "paradise" % Dependencies.Paradise cross CrossVersion.full)
    )

  lazy val js = metaRx.js.dependsOn(metaRxMacros)
  lazy val jvm = metaRx.jvm.dependsOn(metaRxMacros)
}
