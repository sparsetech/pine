enablePlugins(ScalaJSPlugin)

name := "MetaWeb example"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.11.7"

persistLauncher in Compile := true

persistLauncher in Test := false

libraryDependencies += "pl.metastack" %%% "metaweb" % "0.1.1-SNAPSHOT"
