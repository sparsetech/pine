import sbt._
import sbt.Keys._
import spray.revolver.RevolverPlugin.Revolver
import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._
import pl.metastack.metaweb.MetaWeb
import pl.metastack.metaweb.MetaWeb.autoImport._

object Build extends sbt.Build {
  val SharedSettings = Seq(
    name := "example",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := "2.11.7"
  )

  object Dependencies {
    val MetaWeb    = "0.1.1-SNAPSHOT"
    val Hyperscala = "0.10.2-SNAPSHOT"
    val OutrNet    = "1.1.6-SNAPSHOT"
  }

  lazy val root = project.in(file("."))
    .aggregate(js, jvm)
    .settings(SharedSettings: _*)
    .settings(MetaWeb.projectSettings: _*)
    .settings(
      publishArtifact := false,
      metawebTargetPackage := "pl.metastack.metaweb.view",
      metawebSubProjects := Seq("js", "jvm", "shared")
    )

  lazy val example = crossProject.in(file("."))
    .settings(SharedSettings: _*)
    .jvmSettings(Revolver.settings: _*)
    .jvmSettings(
      libraryDependencies ++= Seq(
        "pl.metastack" %% "metaweb" % Dependencies.MetaWeb,
        "org.hyperscala" %% "hyperscala-web" % Dependencies.Hyperscala,
        "org.hyperscala" %% "hyperscala-ui" % Dependencies.Hyperscala,
        "com.outr.net" %% "outrnet-jetty" % Dependencies.OutrNet
      )
    )
    .jsSettings(
      libraryDependencies ++= Seq(
        "pl.metastack" %%% "metaweb" % Dependencies.MetaWeb
      ),
      persistLauncher in Compile := true,
      persistLauncher in Test := false
    )

  lazy val js = example.js

  lazy val jvm = example.jvm.settings(
    baseDirectory in Revolver.reStart := new File("."),
    Revolver.reStart <<= Revolver.reStart dependsOn (fastOptJS in (js, Compile))
  )
}
