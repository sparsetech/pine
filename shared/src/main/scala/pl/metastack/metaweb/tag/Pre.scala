package pl.metastack.metaweb.tag

import pl.metastack.metarx._
import pl.metastack.metaweb.state

/**
 * The <em>HTML Preformatted Text</em>&nbsp;(<strong>&lt;pre&gt;</strong>)&nbsp;represents preformatted text. Text within this element is typically displayed in a non-proportional font exactly as it is laid out in the file. Whitespaces inside this element are displayed as typed.
 */
class Pre extends state.Tag("pre") with HTMLTag {
  /**
   * Contains the 
<em>preferred</em> count of characters that a line should have. It was a non-standard synonym of 
<code><a href="/en-US/docs/Web/HTML/Element/pre#attr-width">width</a></code>. To achieve such an effect, use CSS styling instead.
   */
  def cols: StateChannel[String] = attribute("cols").asInstanceOf[StateChannel[String]]
  /**
   * Contains the 
<em>preferred</em> count of characters that a line should have. Though technically still implemented, this attribute has no visual effect; to achieve such an effect, use CSS styling instead.
   */
  def width: StateChannel[String] = attribute("width").asInstanceOf[StateChannel[String]]
  /**
   * Is a 
<em>hint</em> indicating how the overflow must happen. In modern browser this hint is ignored and no visual effect results in its present; to achieve such an effect, use CSS styling instead.
   */
  def wrap: StateChannel[String] = attribute("wrap").asInstanceOf[StateChannel[String]]
}
