package pl.metastack.metaweb

import org.scalajs.dom

trait PlatformSupport
  extends DiffSupport
  with DOM.Extensions
  with tree.render.DOM.Implicit
  with diff.render.DOM.Implicit

object PlatformSupport {
  val DefaultIdMap: String => Option[Any] = (s: String) => Option(dom.document.getElementById(s))
}
