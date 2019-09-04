#!/bin/sh

echo "
logLevel := Level.Warn

addSbtPlugin(\"org.scala-js\" % \"sbt-scalajs\" % \"0.6.$1\")

addSbtPlugin(\"org.xerial.sbt\" % \"sbt-sonatype\" % \"1.1\")

addSbtPlugin(\"com.jsuereth\" % \"sbt-pgp\" % \"1.0.0\")

addSbtPlugin(\"com.github.gseitz\" % \"sbt-release\" % \"1.0.3\")

addSbtPlugin(\"org.portable-scala\" % \"sbt-scalajs-crossproject\"      % \"0.4.0\")

addSbtPlugin(\"org.portable-scala\" % \"sbt-scala-native-crossproject\" % \"0.4.0\")

" > project/plugins.sbt
