package pl.metastack.metaweb.tag

import pl.metastack.metarx._
import pl.metastack.metaweb.state

/**
 * The <strong>HTML <code>&lt;hr&gt;</code> element</strong> represents a thematic break between paragraph-level elements (for example, a change of scene in a story, or a shift of topic with a section). In previous versions of HTML, it represented a horizontal rule. It may still be displayed as a horizontal rule in visual browsers, but is now defined in semantic terms, rather than presentational terms.
 */
class Hr extends state.Tag("hr") with HTMLTag {
  /**
   * Sets the alignment of the rule on the page. If no value is specified, the default value is 
<code>left</code>.
   */
  def align: StateChannel[String] = attribute("align").asInstanceOf[StateChannel[String]]
  /**
   * Sets the color of the rule through color name or hexadecimal value.
   */
  def color: StateChannel[String] = attribute("color").asInstanceOf[StateChannel[String]]
  /**
   * Sets the rule to have no shading.
   */
  def noshade: StateChannel[Boolean] = attribute("noshade").asInstanceOf[StateChannel[Boolean]]
  /**
   * Sets the height, in pixels, of the rule.
   */
  def size: StateChannel[String] = attribute("size").asInstanceOf[StateChannel[String]]
  /**
   * Sets the length of the rule on the page through a pixel or percentage value.
   */
  def width: StateChannel[String] = attribute("width").asInstanceOf[StateChannel[String]]
}
