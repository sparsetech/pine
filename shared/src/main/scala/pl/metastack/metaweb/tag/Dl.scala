package pl.metastack.metaweb.tag

import pl.metastack.metarx._
import pl.metastack.metaweb.state

/**
 * The <strong>HTML <code>&lt;dl&gt;</code> Element</strong> (or <em>HTML</em> <em>Description List Element</em>) encloses a list of pairs of terms and descriptions. Common uses for this element are to implement a glossary or to display metadata (a list of key-value pairs).
Prior to HTML5, &lt;dl&gt; was known as a Definition List.
 */
class Dl extends state.Tag("dl") with HTMLTag {
  /**
   * Forces the description to appear on the same line as the term. This attribute is currently unsupported
   */
  def compact: StateChannel[Boolean] = attribute("compact").asInstanceOf[StateChannel[Boolean]]
}
