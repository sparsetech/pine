import sbt._
import sbt.Keys._
import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._

object Build extends sbt.Build {
  val SharedSettings = Seq(
    name := "MetaWeb",
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
    .settings(SharedSettings: _*)
    .settings(
      publishArtifact := false
    )

  val convertMDN = (sourceManaged in Compile).map(MDNParser.createFiles)

  lazy val metaRx = crossProject.in(file("."))
    .settings(SharedSettings: _*)
    .settings(
      testFrameworks += new TestFramework("minitest.runner.Framework"),

      libraryDependencies += "org.scala-lang" % "scala-reflect" % "2.11.7",
      libraryDependencies += "org.scala-lang.modules" % "scala-xml_2.11" % "1.0.5",

      addCompilerPlugin("org.scalamacros" % "paradise" % Dependencies.Paradise cross CrossVersion.full),

      sourceGenerators in Compile <+= convertMDN
    )
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

  lazy val js = metaRx.js
  lazy val jvm = metaRx.jvm
}