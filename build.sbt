val Paradise   = "2.1.0"
val Scala2_11  = "2.11.8"
val Scala2_12  = "2.12.2"
val ScalaTest  = "3.0.3"
val ScalaCheck = "1.13.5"
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
  .aggregate(coreJS, coreJVM)
  .settings(SharedSettings: _*)
  .settings(publishArtifact := false)

val convertMDN = taskKey[Unit]("Generate MDN bindings")

lazy val core = crossProject.in(file("core"))
  .settings(SharedSettings: _*)
  .settings(
    addCompilerPlugin("org.scalamacros" % "paradise" % Paradise cross CrossVersion.full),
    libraryDependencies ++= Seq(
      "org.scala-lang" %   "scala-reflect" % scalaVersion.value,
      "org.scalatest"  %%% "scalatest"     % ScalaTest  % "test",
      "org.scalacheck" %%% "scalacheck"    % ScalaCheck % "test"
    ),
    convertMDN := MDNParser.createFiles(new File("core/shared/src/main/scala"))
  )
  .jsSettings(
    libraryDependencies += "org.scala-js" %%% "scalajs-dom" % ScalaJsDom,
    jsDependencies      += RuntimeDOM % "test",
    scalaJSStage in Global := FastOptStage
  )

lazy val coreJS  = core.js
lazy val coreJVM = core.jvm

lazy val example = project.in(file("example"))
