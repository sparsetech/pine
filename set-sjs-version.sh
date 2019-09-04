#!/bin/sh

echo "
logLevel := Level.Warn

addSbtPlugin(\"org.scala-js\" % \"sbt-scalajs\" % \"0.6.$1\")

addSbtPlugin(\"org.xerial.sbt\" % \"sbt-sonatype\" % \"1.1\")

addSbtPlugin(\"com.jsuereth\" % \"sbt-pgp\" % \"1.0.0\")

addSbtPlugin(\"com.github.gseitz\" % \"sbt-release\" % \"1.0.3\")

addSbtPlugin(\"org.scala-native\" % \"sbt-crossproject\"         % \"0.2.2\")

addSbtPlugin(\"org.scala-native\" % \"sbt-scalajs-crossproject\" % \"0.2.2\")

addSbtPlugin(\"org.scala-native\" % \"sbt-scala-native\"         % \"0.3.2\")
" > project/plugins.sbt
