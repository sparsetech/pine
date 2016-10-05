val Scala      = "2.11.8"
val Circe      = "0.4.1"
val Finch      = "0.10.0"
val MetaWeb    = "0.2.0"
val Paradise   = "2.1.0"
val MetaRouter = "0.1.1"

val SharedSettings = Seq(
  name         := "example",
  version      := MetaWeb,
  scalaVersion := Scala,
  addCompilerPlugin(
    "org.scalamacros" % "paradise" % Paradise cross CrossVersion.full
  )
)

lazy val root = project.in(file("."))
  .aggregate(js, jvm)
  .settings(SharedSettings: _*)
  .settings(publishArtifact := false)

lazy val example = crossProject.in(file("."))
  .settings(SharedSettings: _*)
  .settings(
    publishArtifact := false
  )
  .jvmSettings(Revolver.settings: _*)
  .jvmSettings(
    libraryDependencies ++= Seq(
      "pl.metastack" %% "metaweb" % MetaWeb,
      "pl.metastack" %% "metarouter" % MetaRouter,
      "com.github.finagle" %% "finch-core" % Finch,
      "io.circe" %% "circe-core" % Circe,
      "io.circe" %% "circe-generic" % Circe,
      "io.circe" %% "circe-parser" % Circe
    )
  )
  .jsSettings(
    libraryDependencies ++= Seq(
      "pl.metastack" %%% "metaweb" % MetaWeb,
      "pl.metastack" %%% "metarouter" % MetaRouter,
      "io.circe" %%% "circe-core" % Circe,
      "io.circe" %%% "circe-generic" % Circe,
      "io.circe" %%% "circe-parser" % Circe
    ),
    persistLauncher in Compile := true,
    persistLauncher in Test := false
  )

lazy val js = example.js

lazy val jvm = example.jvm.settings(
  baseDirectory in Revolver.reStart := new File("."),
  Revolver.reStart <<= Revolver.reStart dependsOn (fastOptJS in (js, Compile))
)
