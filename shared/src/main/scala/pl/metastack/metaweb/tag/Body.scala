package pl.metastack.metaweb.tag

import pl.metastack.metarx._
import pl.metastack.metaweb.state

/**
 * The <em>HTML Body Element</em> (<strong>&lt;body&gt;</strong>) represents the content of an HTML&nbsp;document. There can be only one <code>&lt;body&gt;</code> element in a document.
 */
class Body extends state.Tag("body") with HTMLTag {
  /**
   * Color of text for hyperlinks when selected. 
<em>This method is non-conforming, use CSS <a href="/en-US/docs/Web/CSS/color" title="The color property sets the foreground color of an element's text content, and its decorations. It doesn't affect any other characteristic of the element; it should really be called text-color and would have been named so, save for historical reasons and its appearance in CSS Level 1."><code>color</code></a> property in conjunction with the <a href="/en-US/docs/Web/CSS/:active" title="The :active CSS pseudo-class matches when an element is being activated by the user. It allows the page to give a feedback that the activation has been detected by the browser. When interacting with a mouse, this is typically the time between the user presses the mouse button and releases it. The :active pseudo-class is also typically matched when using the keyboard tab key. It is frequently used on <a> and <button> HTML&nbsp;elements, but may not be limited to just those."><code>:active</code></a> pseudo-class instead.</em>
   */
  def alink: StateChannel[String] = attribute("alink").asInstanceOf[StateChannel[String]]
  /**
   * URI of a image to use as a background. 
<em>This method is non-conforming, use CSS <a href="/en-US/docs/Web/CSS/background" title="The background CSS property is a shorthand for setting the individual background values in a single place in the style sheet. background can be used to set the values for one or more of: background-clip, background-color, background-image, background-origin, background-position, background-repeat, background-size, and background-attachment."><code>background</code></a> property on the element instead.</em> 
<div class="note">
 <strong>Note:</strong> Starting in Gecko 7.0 (Firefox 7.0 / Thunderbird 7.0 / SeaMonkey 2.4), 
 <code>background</code> is no longer resolved as a URI; instead, it's treated as a simple string.
</div>
   */
  def background: StateChannel[String] = attribute("background").asInstanceOf[StateChannel[String]]
  /**
   * Background color for the document. 
<em>This method is non-conforming, use CSS <a href="/en-US/docs/Web/CSS/background-color" title="The background-color CSS property sets the background color of an element, either through a color value or the keyword transparent."><code>background-color</code></a> property on the element instead.</em>
   */
  def bgcolor: StateChannel[String] = attribute("bgcolor").asInstanceOf[StateChannel[String]]
  /**
   * The margin of the bottom of the body. 
<em>This method is non-conforming, use CSS <a href="/en-US/docs/Web/CSS/margin-bottom" title="The margin-bottom CSS property of an element sets the margin space required on the bottom of an element. A negative value is also allowed."><code>margin-bottom</code></a> property on the element instead.</em>
   */
  def bottommargin: StateChannel[String] = attribute("bottommargin").asInstanceOf[StateChannel[String]]
  /**
   * The margin of the left of the body. 
<em>This method is non-conforming, use CSS <a href="/en-US/docs/Web/CSS/margin-left" title="The margin-left CSS property sets the margin space required on the left side of a box associated with an element. A negative value is also allowed."><code>margin-left</code></a> property on the element instead.</em>
   */
  def leftmargin: StateChannel[String] = attribute("leftmargin").asInstanceOf[StateChannel[String]]
  /**
   * Color of text for unvisited hypertext links. 
<em>This method is non-conforming, use CSS <a href="/en-US/docs/Web/CSS/color" title="The color property sets the foreground color of an element's text content, and its decorations. It doesn't affect any other characteristic of the element; it should really be called text-color and would have been named so, save for historical reasons and its appearance in CSS Level 1."><code>color</code></a> property in conjunction with the <a href="/en-US/docs/Web/CSS/:link" title="The :link CSS pseudo-class lets you select links inside elements. This will select any link which has not yet been visited, even those already styled using selector with other link-related pseudo-classes like :hover, :active or :visited. In order to appropriately style links, you need to put the :link rule before the other ones, as defined by the LVHA-order: :link — :visited — :hover — :active. The :focus pseudo-class is usually placed right before or right after :hover, depending on the expected effect."><code>:link</code></a> pseudo-class instead.</em>
   */
  def link: StateChannel[String] = attribute("link").asInstanceOf[StateChannel[String]]
  /**
   * Function to call after the user has printed the document.
   */
  def onafterprint: StateChannel[String] = attribute("onafterprint").asInstanceOf[StateChannel[String]]
  /**
   * Function to call when the user requests printing of the document.
   */
  def onbeforeprint: StateChannel[String] = attribute("onbeforeprint").asInstanceOf[StateChannel[String]]
  /**
   * Function to call when the document is about to be unloaded.
   */
  def onbeforeunload: StateChannel[String] = attribute("onbeforeunload").asInstanceOf[StateChannel[String]]
  /**
   * Function to call when the document loses focus.
   */
  def onblur: StateChannel[String] = attribute("onblur").asInstanceOf[StateChannel[String]]
  /**
   * Function to call when the document fails to load properly.
   */
  def onerror: StateChannel[String] = attribute("onerror").asInstanceOf[StateChannel[String]]
  /**
   * Function to call when the document receives focus.
   */
  def onfocus: StateChannel[String] = attribute("onfocus").asInstanceOf[StateChannel[String]]
  /**
   * Function to call when the fragment identifier part (starting with the hash (
<code>'#'</code>) character) of the document's current address has changed.
   */
  def onhashchange: StateChannel[String] = attribute("onhashchange").asInstanceOf[StateChannel[String]]
  /**
   * Function to call when the preferred languages changed.
   */
  def onlanguagechange: StateChannel[String] = attribute("onlanguagechange").asInstanceOf[StateChannel[String]]
  /**
   * Function to call when the document has finished loading.
   */
  def onload: StateChannel[String] = attribute("onload").asInstanceOf[StateChannel[String]]
  /**
   * Function to call when the document has received a message.
   */
  def onmessage: StateChannel[String] = attribute("onmessage").asInstanceOf[StateChannel[String]]
  /**
   * Function to call when network communication has failed.
   */
  def onoffline: StateChannel[String] = attribute("onoffline").asInstanceOf[StateChannel[String]]
  /**
   * Function to call when network communication has been restored.
   */
  def ononline: StateChannel[String] = attribute("ononline").asInstanceOf[StateChannel[String]]
  /**
   * Function to call when the user has navigated session history.
   */
  def onpopstate: StateChannel[String] = attribute("onpopstate").asInstanceOf[StateChannel[String]]
  /**
   * Function to call when the user has moved forward in undo transaction history.
   */
  def onredo: StateChannel[String] = attribute("onredo").asInstanceOf[StateChannel[String]]
  /**
   * Function to call when the document has been resized.
   */
  def onresize: StateChannel[String] = attribute("onresize").asInstanceOf[StateChannel[String]]
  /**
   * Function to call when the storage area has changed.
   */
  def onstorage: StateChannel[String] = attribute("onstorage").asInstanceOf[StateChannel[String]]
  /**
   * Function to call when the user has moved backward in undo transaction history.
   */
  def onundo: StateChannel[String] = attribute("onundo").asInstanceOf[StateChannel[String]]
  /**
   * Function to call when the document is going away.
   */
  def onunload: StateChannel[String] = attribute("onunload").asInstanceOf[StateChannel[String]]
  /**
   * The margin of the right of the body. 
<em>This method is non-conforming, use CSS <a href="/en-US/docs/Web/CSS/margin-right" title="The margin-right CSS property of an element sets the margin space required on the right side of an element. A negative value is also allowed."><code>margin-right</code></a> property on the element instead.</em>
   */
  def rightmargin: StateChannel[String] = attribute("rightmargin").asInstanceOf[StateChannel[String]]
  /**
   * Foreground color of text. 
<em>This method is non-conforming, use CSS <a href="/en-US/docs/Web/CSS/color" title="The color property sets the foreground color of an element's text content, and its decorations. It doesn't affect any other characteristic of the element; it should really be called text-color and would have been named so, save for historical reasons and its appearance in CSS Level 1."><code>color</code></a> property on the element instead.</em>
   */
  def text: StateChannel[String] = attribute("text").asInstanceOf[StateChannel[String]]
  /**
   * The margin of the top of the body. 
<em>This method is non-conforming, use CSS <a href="/en-US/docs/Web/CSS/margin-top" title="The margin-top CSS property of an element sets the margin space required on the top of an element. A negative value is also allowed."><code>margin-top</code></a> property on the element instead.</em>
   */
  def topmargin: StateChannel[String] = attribute("topmargin").asInstanceOf[StateChannel[String]]
  /**
   * Color of text for visited hypertext links. 
<em>This method is non-conforming, use CSS <a href="/en-US/docs/Web/CSS/color" title="The color property sets the foreground color of an element's text content, and its decorations. It doesn't affect any other characteristic of the element; it should really be called text-color and would have been named so, save for historical reasons and its appearance in CSS Level 1."><code>color</code></a> property in conjunction with the <a href="/en-US/docs/Web/CSS/:visited" title="The :visited CSS pseudo-class lets you select only links that have been visited. This style may be overridden by any other link-related pseudo-classes, that is :link, :hover, and :active, appearing in subsequent rules. In order to style appropriately links, you need to put the :visited rule after the :link rule but before the other ones, defined in the LVHA-order: :link — :visited — :hover — :active."><code>:visited</code></a> pseudo-class instead.</em>
   */
  def vlink: StateChannel[String] = attribute("vlink").asInstanceOf[StateChannel[String]]
}
