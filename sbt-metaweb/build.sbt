name := "sbt-metaweb"

organization := "pl.metastack"

scalaVersion in Global := "2.10.5"

sbtPlugin := true

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
      <url>http://github.com/tindzk/</url>
    </developer>
  </developers>
