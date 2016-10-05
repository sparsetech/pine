package pl.metastack.metaweb

trait PlatformSupport

object PlatformSupport {
  val DefaultIdMap: String => Option[Any] = (s: String) => None
}
