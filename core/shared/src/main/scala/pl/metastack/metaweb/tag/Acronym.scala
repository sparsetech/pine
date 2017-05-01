package pl.metastack.metaweb.tag

import pl.metastack.metaweb._

/**
 * The HTML Acronym Element (<code>&lt;acronym&gt;)</code> allows authors to clearly indicate a sequence of characters that compose an acronym or abbreviation for a word.
<p><strong>Usage note: </strong>This element has been removed in HTML5 and shouldn't be used anymore. Instead web developers should use the <a href="/en-US/docs/Web/HTML/Element/abbr" title="The HTML <abbr> Element (or HTML Abbreviation Element) represents an abbreviation and optionally provides a full description for it. If present, the title attribute must contain this full description and nothing else."><code>&lt;abbr&gt;</code></a> element.</p>
 */
case class Acronym(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[Node] = Seq.empty) extends HTMLTag {
  override type T = Acronym
  override def tagName = "acronym"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[Node] = children): Acronym = Acronym(attributes, children)
}
