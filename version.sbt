version in ThisBuild := {
  import sys.process._
  val version = Seq("git", "describe", "--tags").!!.trim.tail
  println("[info] Setting version to: " + version)
  version
}
