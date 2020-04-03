
logLevel := Level.Warn

// see http://eed3si9n.com/removing-commas-with-sbt-nocomma
addSbtPlugin("com.eed3si9n"       % "sbt-nocomma"       % "0.1.0")
addSbtPlugin("com.eed3si9n"       % "sbt-projectmatrix" % "0.3.0")
addSbtPlugin("org.scala-js"       % "sbt-scalajs"       % "1.2.0")
addSbtPlugin("org.scala-native"   % "sbt-scala-native"  % "0.4.0-M2")

libraryDependencies += "org.scala-js" %% "scalajs-env-jsdom-nodejs" % "1.1.0"
