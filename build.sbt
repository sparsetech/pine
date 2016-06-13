val Paradise   = "2.1.0"
val ScalaXml   = "1.0.5"
val Scala2_11  = "2.11.8"
val Scala2_12  = "2.12.0-M4"
val ScalaTest  = "3.0.0-RC2"
val ScalaJsDom = "0.9.1"

val SharedSettings = Seq(
  name := "MetaWeb",
  organization := "pl.metastack",
  scalaVersion := Scala2_11,
  crossScalaVersions := Seq(Scala2_12, Scala2_11),
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
        <url>http://github.com/tindzk</url>
      </developer>
    </developers>
)

lazy val root = project.in(file("."))
  .aggregate(js, jvm)
  .settings(SharedSettings: _*)
  .settings(publishArtifact := false)

val convertMDN = taskKey[Unit]("Generate MDN bindings")

lazy val metaWeb = crossProject.in(file("."))
  .settings(SharedSettings: _*)
  .settings(
    addCompilerPlugin("org.scalamacros" % "paradise" % Paradise cross CrossVersion.full),
    libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-reflect" % scalaVersion.value,
      "org.scala-lang.modules" %% "scala-xml" % ScalaXml
    ),
    convertMDN := MDNParser.createFiles(new File("shared/src/main/scala"))
  )
  .jvmSettings(
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % ScalaTest % "test"
    )
  )
  .jsSettings(
    libraryDependencies ++= Seq(
      "org.scala-js" %%% "scalajs-dom" % ScalaJsDom,
      "org.scalatest" %%% "scalatest" % ScalaTest % "test"
    ),

    requiresDOM := true,  // For test cases
    scalaJSStage in Global := FastOptStage,

    /* Use io.js for faster compilation of test cases */
    scalaJSUseRhino in Global := false
  )

lazy val js = metaWeb.js
lazy val jvm = metaWeb.jvm
