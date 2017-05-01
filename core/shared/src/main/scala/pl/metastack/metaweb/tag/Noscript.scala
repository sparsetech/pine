package pl.metastack.metaweb.tag

import pl.metastack.metaweb._

/**
 * The <strong>HTML <code>&lt;noscript&gt;</code> Element</strong> defines a section of html to be inserted if a script type on the page is unsupported or if scripting is currently turned off in the browser.
 */
case class Noscript(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[Node] = Seq.empty) extends HTMLTag {
  override type T = Noscript
  override def tagName = "noscript"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[Node] = children): Noscript = Noscript(attributes, children)
}
