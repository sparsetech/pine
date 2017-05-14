// Shadow sbt-scalajs' crossProject and CrossType until Scala.js 1.0.0 is released
import sbtcrossproject.{crossProject, CrossType}

val Paradise   = "2.1.0"
val Scala2_11  = "2.11.11"
val Scala2_12  = "2.12.2"
val ScalaTest  = "3.0.3"
val ScalaCheck = "1.13.5"
val ScalaJsDom = "0.9.1"

val SharedSettings = Seq(
  name := "pine",
  organization := "tech.sparse",
  scalaVersion := Scala2_12,
  crossScalaVersions := Seq(Scala2_12, Scala2_11),
  pomExtra :=
    <url>https://github.com/sparsetech/pine</url>
    <licenses>
      <license>
        <name>Apache-2.0</name>
        <url>https://www.apache.org/licenses/LICENSE-2.0.html</url>
      </license>
    </licenses>
    <scm>
      <url>git@github.com:sparsetech/pine.git</url>
    </scm>
    <developers>
      <developer>
        <id>tindzk</id>
        <name>Tim Nieradzik</name>
        <url>http://github.com/tindzk</url>
      </developer>
    </developers>
)

lazy val root = project.in(file("."))
  .aggregate(pineJS, pineJVM, pineNative)
  .settings(SharedSettings: _*)
  .settings(publishArtifact := false)

val convertMDN = taskKey[Unit]("Generate MDN bindings")

lazy val pine = crossProject(JSPlatform, JVMPlatform, NativePlatform)
  .in(file("."))
  .settings(SharedSettings: _*)
  .settings(
    addCompilerPlugin("org.scalamacros" % "paradise" % Paradise cross CrossVersion.full),
    libraryDependencies += "org.scala-lang" % "scala-reflect" % scalaVersion.value,
    convertMDN := MDNParser.createFiles(new File("shared/src/main/scala"))
  )
  .jvmSettings(
    libraryDependencies ++= Seq(
      "org.scalatest"  %% "scalatest"  % ScalaTest  % "test",
      "org.scalacheck" %% "scalacheck" % ScalaCheck % "test"
    )
  ).jsSettings(
    libraryDependencies ++= Seq(
      "org.scala-js"   %%% "scalajs-dom" % ScalaJsDom,
      "org.scalatest"  %%% "scalatest"   % ScalaTest  % "test",
      "org.scalacheck" %%% "scalacheck"  % ScalaCheck % "test"
    ),
    jsDependencies += RuntimeDOM % "test",
    scalaJSStage in Global := FastOptStage
  ).nativeSettings(
    // Not available for 2.12 yet
    scalaVersion := Scala2_11,
    crossScalaVersions := Seq(Scala2_11)
  )

lazy val pineJS     = pine.js
lazy val pineJVM    = pine.jvm
lazy val pineNative = pine.native
