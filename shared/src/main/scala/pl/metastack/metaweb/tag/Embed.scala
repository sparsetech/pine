package pl.metastack.metaweb.tag

import pl.metastack.metarx._
import pl.metastack.metaweb.state

/**
 * The <strong>HTML <code>&lt;embed&gt;</code> Element</strong> represents an integration point for an external application or interactive content (in other words, a plug-in).

<strong>Note:</strong>&nbsp;This topic documents only the element that is defined as part of HTML5. It does not address earlier, non-standardized implementation of the element.

 */
class Embed extends state.Tag("embed") with HTMLTag {
  /**
   * The displayed height of the resource, in CSS pixels.
   */
  def height: StateChannel[String] = attribute("height").asInstanceOf[StateChannel[String]]
  /**
   * The URL&nbsp;of the resource being embedded.
   */
  def src: StateChannel[String] = attribute("src").asInstanceOf[StateChannel[String]]
  /**
   * The MIME&nbsp;type to use to select the plug-in to instantiate.
   */
  def `type`: StateChannel[String] = attribute("type").asInstanceOf[StateChannel[String]]
  /**
   * The displayed width of the resource, in CSS pixels.
   */
  def width: StateChannel[String] = attribute("width").asInstanceOf[StateChannel[String]]
}
