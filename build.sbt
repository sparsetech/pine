
val convertMDN = taskKey[Unit]("Generate MDN bindings")

val V = new {
  val paradise = "2.1.1"
  val scala2_11 = "2.11.11-bin-typelevel-4"
  val scala2_12 = "2.12.4-bin-typelevel-4"
  val scala2_13 = "2.13.0"
  val scalaTest = "3.0.8"
  val scalaCheck = "1.14.0"
  val scalaJsDom = "0.9.7"
}



val GlobalSettings = nocomma {
  ThisBuild / name         := "pine"
  ThisBuild / organization := "tech.sparse"
  ThisBuild / scalaVersion := V.scala2_13

  ThisBuild / pomExtra :=
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

  convertMDN := MDNParser.createFiles(new File("src/main/scala"))

  // See https://github.com/sbt/sbt/pull/2659
  incOptions := incOptions.value.withLogRecompileOnMacro(false)

  libraryDependencies ++= Seq(
    scalaOrganization.value % "scala-reflect" % scalaVersion.value % "provided",
    scalaOrganization.value % "scala-compiler" % scalaVersion.value % "provided",
  )

  scalacOptions ++= Seq(
    "-deprecation",                      // Emit warning and location for usages of deprecated APIs.
    "-encoding", "utf-8",                // Specify character encoding used by source files.
    "-explaintypes",                     // Explain type errors in more detail.
    "-feature",                          // Emit warning and location for usages of features that should be imported explicitly.
    "-language:existentials",            // Existential types (besides wildcard types) can be written and inferred
    "-language:experimental.macros",     // Allow macro definition (besides implementation and application)
    "-language:higherKinds",             // Allow higher-kinded types
    "-unchecked",                        // Enable additional warnings where generated code depends on assumptions.
    "-Xcheckinit",                       // Wrap field accessors to throw an exception on uninitialized access.
    "-Xfatal-warnings",                  // Fail the compilation if there are any warnings.
    "-Xlint:adapted-args",               // Warn if an argument list is modified to match the receiver.
    "-Xlint:delayedinit-select",         // Selecting member of DelayedInit.
    "-Xlint:doc-detached",               // A Scaladoc comment appears to be detached from its element.
    "-Xlint:inaccessible",               // Warn about inaccessible types in method signatures.
    "-Xlint:infer-any",                  // Warn when a type argument is inferred to be `Any`.
    "-Xlint:missing-interpolator",       // A string literal appears to be missing an interpolator id.
    "-Xlint:nullary-override",           // Warn when non-nullary `def f()' overrides nullary `def f'.
    "-Xlint:nullary-unit",               // Warn when nullary methods return Unit.
    "-Xlint:option-implicit",            // Option.apply used implicit view.
    "-Xlint:package-object-classes",     // Class or object defined in package object.
    "-Xlint:poly-implicit-overload",     // Parameterized overloaded implicit methods are not visible as view bounds.
    "-Xlint:private-shadow",             // A private field (or class parameter) shadows a superclass field.
    "-Xlint:stars-align",                // Pattern sequence wildcard must align with sequence component.
    "-Xlint:type-parameter-shadow",      // A local type parameter shadows a type already in scope.
//    "-Ywarn-dead-code",                  // Warn when dead code is identified.
    "-Ywarn-numeric-widen",              // Warn when numerics are widened.
  )
}

val Pre13Settings = nocomma {
  scalaOrganization := "org.typelevel"
  
  scalacOptions ++= Seq(
    "-Xfuture",                          // Turn on future language features.
    "-Xlint:by-name-right-associative",  // By-name parameter of right associative operator.
    "-Xlint:unsound-match",              // Pattern match may not be typesafe.
    "-Yliteral-types",                   // ... this is why we need the typelevel org
    "-Yno-adapted-args",                 // Do not adapt an argument list (either by inserting () or creating a tuple) to match the receiver.
    "-Ypartial-unification",             // Enable partial unification in type constructor inference
    "-Ywarn-inaccessible",               // Warn about inaccessible types in method signatures.
    "-Ywarn-infer-any",                  // Warn when a type argument is inferred to be `Any`.
    "-Ywarn-nullary-override",           // Warn when non-nullary `def f()' overrides nullary `def f'.
    "-Ywarn-nullary-unit",               // Warn when nullary methods return Unit.
  )
  
  addCompilerPlugin("org.scalamacros" %% "paradise" % V.paradise cross CrossVersion.patch)
}

val Post11Settings = nocomma {
  scalacOptions ++= Seq(
    "-Xlint:constant",                   // Evaluation of a constant arithmetic expression results in an error.
    "-Ywarn-extra-implicit",             // Warn when more than one implicit parameter section is defined.
    "-Ywarn-unused:imports",             // Warn if an import selector is not referenced.
    "-Ywarn-unused:locals",              // Warn if a local definition is unused.
    "-Ywarn-unused:patvars",             // Warn if a variable bound in a pattern is unused.
    "-Ywarn-unused:privates",            // Warn if a private member is unused.
    //    "-Ywarn-unused:implicits",           // Warn if an implicit parameter is unused.
    //    "-Ywarn-unused:params",              // Warn if a value parameter is unused.
    //    "-Ywarn-value-discard"               // Warn when non-Unit expression results are unused.
  )
}

val Scala11Settings = Pre13Settings

val Scala12Settings = Pre13Settings ++ Post11Settings

val Scala13Settings = Post11Settings ++ nocomma {
  scalacOptions += "-Ymacro-annotations"
}

val JvmSettings = nocomma {
  libraryDependencies ++= Seq(
    "org.scalatest"  %% "scalatest"   % V.scalaTest  % "test",
    "org.scalacheck" %% "scalacheck"  % V.scalaCheck % "test",
  )
}

val JsSettings = nocomma {
  libraryDependencies ++= Seq(
    "org.scalatest"  %%% "scalatest"   % V.scalaTest  % "test",
    "org.scalacheck" %%% "scalacheck"  % V.scalaCheck % "test",
    "org.scala-js"   %%% "scalajs-dom" % V.scalaJsDom,
  )

  // We need to remove and re-add this if working under the typelevel compiler
  // under the lighbend compiler it causes no harm
  // See https://github.com/scala-js/scala-js/pull/2954
  libraryDependencies ~= (_.filterNot(_.name == "scalajs-compiler"))
  addCompilerPlugin("org.scala-js" % "scalajs-compiler" % scalaJSVersion cross CrossVersion.patch)  

  Test / jsEnv := new org.scalajs.jsenv.jsdomnodejs.JSDOMNodeJSEnv
  Global / scalaJSStage := FastOptStage
}

val NativeSettings = nocomma {
  libraryDependencies ~= (_.filterNot(_.name == "nscplugin"))
  Test / excludeFilter := "*"
}

lazy val pine = (projectMatrix in file("."))
  .settings( GlobalSettings )
  .jvmPlatform(    Seq(V.scala2_13), JvmSettings    ++ Scala13Settings)
  .jvmPlatform(    Seq(V.scala2_12), JvmSettings    ++ Scala12Settings)
  .jvmPlatform(    Seq(V.scala2_11), JvmSettings    ++ Scala11Settings)
  .jsPlatform(     Seq(V.scala2_13), JsSettings     ++ Scala13Settings)
  .jsPlatform(     Seq(V.scala2_12), JsSettings     ++ Scala12Settings)
  .jsPlatform(     Seq(V.scala2_11), JsSettings     ++ Scala11Settings)
  .nativePlatform( Seq(V.scala2_11), NativeSettings ++ Pre13Settings)

