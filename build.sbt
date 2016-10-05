val Paradise   = "2.1.0"
val Scala2_11  = "2.11.8"
// val Scala2_12  = "2.12.0-RC1"
val ScalaTest  = "3.0.0"
val ScalaCheck = "1.13.2"
val ScalaJsDom = "0.9.1"
val Cats       = "0.7.2"

val SharedSettings = Seq(
  name := "MetaWeb",
  organization := "pl.metastack",
  scalaVersion := Scala2_11,
  // crossScalaVersions := Seq(Scala2_12, Scala2_11),
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
  .aggregate(coreJS, coreJVM, catsJS, catsJVM)
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

    requiresDOM := true,  // For test cases
    scalaJSStage in Global := FastOptStage,

    /* Use io.js for faster compilation of test cases */
    scalaJSUseRhino in Global := false
  )

lazy val coreJS  = core.js
lazy val coreJVM = core.jvm

lazy val example = project.in(file("example"))

lazy val cats = crossProject.in(file("cats"))
  .settings(SharedSettings: _*)
  .dependsOn(core)
  .settings(
    name := "MetaWeb-Cats"
  , libraryDependencies += "org.typelevel" %%% "cats-core" % Cats
  , libraryDependencies += "org.scalatest" %%% "scalatest" % ScalaTest % "test"
  )
  .jsSettings(
    scalaJSUseRhino in Global := false
  )

lazy val catsJS  = cats.js
lazy val catsJVM = cats.jvm
