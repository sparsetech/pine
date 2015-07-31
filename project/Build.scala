import sbt._
import Keys._

object BuildSettings {
  val paradiseVersion = "2.1.0-M5"
  val buildSettings = Defaults.defaultSettings ++ Seq(
    organization := "pl.metastack",
    version := "0.1.0-SNAPSHOT",
    scalacOptions ++= Seq(),
    scalaVersion := "2.11.7",
    resolvers += Resolver.sonatypeRepo("snapshots"),
    resolvers += Resolver.sonatypeRepo("releases"),
    addCompilerPlugin("org.scalamacros" % "paradise" % paradiseVersion cross CrossVersion.full)
  )
}

object MyBuild extends Build {
  import BuildSettings._

  lazy val root: Project = Project(
    "metaweb",
    file("."),
    settings = buildSettings ++ Seq(
      run <<= run in Compile in core
    )
  ).aggregate(macros, core)

  lazy val macros: Project = Project(
    "metaweb-macros",
    file("macros"),
    settings = buildSettings ++ Seq(
      libraryDependencies <+= scalaVersion("org.scala-lang" % "scala-reflect" % _),
      libraryDependencies += "pl.metastack" %% "metarx" % "0.1.0-SNAPSHOT",
      libraryDependencies += "org.scala-lang.modules" % "scala-xml_2.11" % "1.0.5"
    )
  )

  lazy val core: Project = Project(
    "metaweb-core",
    file("core"),
    settings = buildSettings
  ).dependsOn(macros)
}
