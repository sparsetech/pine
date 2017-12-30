logLevel := Level.Warn

addSbtPlugin("org.scala-js"      % "sbt-scalajs"              % "0.6.21")
addSbtPlugin("org.scala-native"  % "sbt-crossproject"         % "0.2.2" )
addSbtPlugin("org.scala-native"  % "sbt-scalajs-crossproject" % "0.2.2" )
addSbtPlugin("org.scala-native"  % "sbt-scala-native"         % "0.3.6" )
addSbtPlugin("org.xerial.sbt"    % "sbt-sonatype"             % "2.0"   )
addSbtPlugin("com.github.gseitz" % "sbt-release"              % "1.0.7" )
