package pl.metastack.metaweb.tag

import pl.metastack.metaweb.tree

/**
 * The <em>HTML Body Element</em> (<strong>&lt;body&gt;</strong>) represents the content of an HTML&nbsp;document. There can be only one <code>&lt;body&gt;</code> element in a document.
 */
case class Body(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[tree.Node] = Seq.empty) extends HTMLTag {
  override type T = Body
  override def tagName = "body"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[tree.Node] = children): Body = Body(attributes, children)
  /**
   * Color of text for hyperlinks when selected. 
<em>This method is non-conforming, use CSS <a href="/en-US/docs/Web/CSS/color" title="The color property sets the foreground color of an element's text content, and its decorations. It doesn't affect any other characteristic of the element; it should really be called text-color and would have been named so, save for historical reasons and its appearance in CSS Level 1."><code>color</code></a> property in conjunction with the <a href="/en-US/docs/Web/CSS/:active" title="The :active CSS pseudo-class matches when an element is being activated by the user. It allows the page to give a feedback that the activation has been detected by the browser. When interacting with a mouse, this is typically the time between the user presses the mouse button and releases it. The :active pseudo-class is also typically matched when using the keyboard tab key. It is frequently used on <a> and <button> HTML&nbsp;elements, but may not be limited to just those."><code>:active</code></a> pseudo-class instead.</em>
   */
  def alink: scala.Option[String] = attributes.get("alink").asInstanceOf[scala.Option[String]]
  def alink(value: String): Body = copy(attributes = attributes + ("alink" -> value))
  /**
   * URI of a image to use as a background. 
<em>This method is non-conforming, use CSS <a href="/en-US/docs/Web/CSS/background" title="The background CSS property is a shorthand for setting the individual background values in a single place in the style sheet. background can be used to set the values for one or more of: background-clip, background-color, background-image, background-origin, background-position, background-repeat, background-size, and background-attachment."><code>background</code></a> property on the element instead.</em> 
<div class="note">
 <strong>Note:</strong> Starting in Gecko 7.0 (Firefox 7.0 / Thunderbird 7.0 / SeaMonkey 2.4), 
 <code>background</code> is no longer resolved as a URI; instead, it's treated as a simple string.
</div>
   */
  def background: scala.Option[String] = attributes.get("background").asInstanceOf[scala.Option[String]]
  def background(value: String): Body = copy(attributes = attributes + ("background" -> value))
  /**
   * Background color for the document. 
<em>This method is non-conforming, use CSS <a href="/en-US/docs/Web/CSS/background-color" title="The background-color CSS property sets the background color of an element, either through a color value or the keyword transparent."><code>background-color</code></a> property on the element instead.</em>
   */
  def bgcolor: scala.Option[String] = attributes.get("bgcolor").asInstanceOf[scala.Option[String]]
  def bgcolor(value: String): Body = copy(attributes = attributes + ("bgcolor" -> value))
  /**
   * The margin of the bottom of the body. 
<em>This method is non-conforming, use CSS <a href="/en-US/docs/Web/CSS/margin-bottom" title="The margin-bottom CSS property of an element sets the margin space required on the bottom of an element. A negative value is also allowed."><code>margin-bottom</code></a> property on the element instead.</em>
   */
  def bottommargin: scala.Option[String] = attributes.get("bottommargin").asInstanceOf[scala.Option[String]]
  def bottommargin(value: String): Body = copy(attributes = attributes + ("bottommargin" -> value))
  /**
   * The margin of the left of the body. 
<em>This method is non-conforming, use CSS <a href="/en-US/docs/Web/CSS/margin-left" title="The margin-left CSS property sets the margin space required on the left side of a box associated with an element. A negative value is also allowed."><code>margin-left</code></a> property on the element instead.</em>
   */
  def leftmargin: scala.Option[String] = attributes.get("leftmargin").asInstanceOf[scala.Option[String]]
  def leftmargin(value: String): Body = copy(attributes = attributes + ("leftmargin" -> value))
  /**
   * Color of text for unvisited hypertext links. 
<em>This method is non-conforming, use CSS <a href="/en-US/docs/Web/CSS/color" title="The color property sets the foreground color of an element's text content, and its decorations. It doesn't affect any other characteristic of the element; it should really be called text-color and would have been named so, save for historical reasons and its appearance in CSS Level 1."><code>color</code></a> property in conjunction with the <a href="/en-US/docs/Web/CSS/:link" title="The :link CSS pseudo-class lets you select links inside elements. This will select any link which has not yet been visited, even those already styled using selector with other link-related pseudo-classes like :hover, :active or :visited. In order to appropriately style links, you need to put the :link rule before the other ones, as defined by the LVHA-order: :link — :visited — :hover — :active. The :focus pseudo-class is usually placed right before or right after :hover, depending on the expected effect."><code>:link</code></a> pseudo-class instead.</em>
   */
  def link: scala.Option[String] = attributes.get("link").asInstanceOf[scala.Option[String]]
  def link(value: String): Body = copy(attributes = attributes + ("link" -> value))
  /**
   * Function to call after the user has printed the document.
   */
  def onafterprint: scala.Option[String] = attributes.get("onafterprint").asInstanceOf[scala.Option[String]]
  def onafterprint(value: String): Body = copy(attributes = attributes + ("onafterprint" -> value))
  /**
   * Function to call when the user requests printing of the document.
   */
  def onbeforeprint: scala.Option[String] = attributes.get("onbeforeprint").asInstanceOf[scala.Option[String]]
  def onbeforeprint(value: String): Body = copy(attributes = attributes + ("onbeforeprint" -> value))
  /**
   * Function to call when the document is about to be unloaded.
   */
  def onbeforeunload: scala.Option[String] = attributes.get("onbeforeunload").asInstanceOf[scala.Option[String]]
  def onbeforeunload(value: String): Body = copy(attributes = attributes + ("onbeforeunload" -> value))
  /**
   * Function to call when the document loses focus.
   */
  def onblur: scala.Option[String] = attributes.get("onblur").asInstanceOf[scala.Option[String]]
  def onblur(value: String): Body = copy(attributes = attributes + ("onblur" -> value))
  /**
   * Function to call when the document fails to load properly.
   */
  def onerror: scala.Option[String] = attributes.get("onerror").asInstanceOf[scala.Option[String]]
  def onerror(value: String): Body = copy(attributes = attributes + ("onerror" -> value))
  /**
   * Function to call when the document receives focus.
   */
  def onfocus: scala.Option[String] = attributes.get("onfocus").asInstanceOf[scala.Option[String]]
  def onfocus(value: String): Body = copy(attributes = attributes + ("onfocus" -> value))
  /**
   * Function to call when the fragment identifier part (starting with the hash (
<code>'#'</code>) character) of the document's current address has changed.
   */
  def onhashchange: scala.Option[String] = attributes.get("onhashchange").asInstanceOf[scala.Option[String]]
  def onhashchange(value: String): Body = copy(attributes = attributes + ("onhashchange" -> value))
  /**
   * Function to call when the preferred languages changed.
   */
  def onlanguagechange: scala.Option[String] = attributes.get("onlanguagechange").asInstanceOf[scala.Option[String]]
  def onlanguagechange(value: String): Body = copy(attributes = attributes + ("onlanguagechange" -> value))
  /**
   * Function to call when the document has finished loading.
   */
  def onload: scala.Option[String] = attributes.get("onload").asInstanceOf[scala.Option[String]]
  def onload(value: String): Body = copy(attributes = attributes + ("onload" -> value))
  /**
   * Function to call when the document has received a message.
   */
  def onmessage: scala.Option[String] = attributes.get("onmessage").asInstanceOf[scala.Option[String]]
  def onmessage(value: String): Body = copy(attributes = attributes + ("onmessage" -> value))
  /**
   * Function to call when network communication has failed.
   */
  def onoffline: scala.Option[String] = attributes.get("onoffline").asInstanceOf[scala.Option[String]]
  def onoffline(value: String): Body = copy(attributes = attributes + ("onoffline" -> value))
  /**
   * Function to call when network communication has been restored.
   */
  def ononline: scala.Option[String] = attributes.get("ononline").asInstanceOf[scala.Option[String]]
  def ononline(value: String): Body = copy(attributes = attributes + ("ononline" -> value))
  /**
   * Function to call when the user has navigated session history.
   */
  def onpopstate: scala.Option[String] = attributes.get("onpopstate").asInstanceOf[scala.Option[String]]
  def onpopstate(value: String): Body = copy(attributes = attributes + ("onpopstate" -> value))
  /**
   * Function to call when the user has moved forward in undo transaction history.
   */
  def onredo: scala.Option[String] = attributes.get("onredo").asInstanceOf[scala.Option[String]]
  def onredo(value: String): Body = copy(attributes = attributes + ("onredo" -> value))
  /**
   * Function to call when the document has been resized.
   */
  def onresize: scala.Option[String] = attributes.get("onresize").asInstanceOf[scala.Option[String]]
  def onresize(value: String): Body = copy(attributes = attributes + ("onresize" -> value))
  /**
   * Function to call when the storage area has changed.
   */
  def onstorage: scala.Option[String] = attributes.get("onstorage").asInstanceOf[scala.Option[String]]
  def onstorage(value: String): Body = copy(attributes = attributes + ("onstorage" -> value))
  /**
   * Function to call when the user has moved backward in undo transaction history.
   */
  def onundo: scala.Option[String] = attributes.get("onundo").asInstanceOf[scala.Option[String]]
  def onundo(value: String): Body = copy(attributes = attributes + ("onundo" -> value))
  /**
   * Function to call when the document is going away.
   */
  def onunload: scala.Option[String] = attributes.get("onunload").asInstanceOf[scala.Option[String]]
  def onunload(value: String): Body = copy(attributes = attributes + ("onunload" -> value))
  /**
   * The margin of the right of the body. 
<em>This method is non-conforming, use CSS <a href="/en-US/docs/Web/CSS/margin-right" title="The margin-right CSS property of an element sets the margin space required on the right side of an element. A negative value is also allowed."><code>margin-right</code></a> property on the element instead.</em>
   */
  def rightmargin: scala.Option[String] = attributes.get("rightmargin").asInstanceOf[scala.Option[String]]
  def rightmargin(value: String): Body = copy(attributes = attributes + ("rightmargin" -> value))
  /**
   * Foreground color of text. 
<em>This method is non-conforming, use CSS <a href="/en-US/docs/Web/CSS/color" title="The color property sets the foreground color of an element's text content, and its decorations. It doesn't affect any other characteristic of the element; it should really be called text-color and would have been named so, save for historical reasons and its appearance in CSS Level 1."><code>color</code></a> property on the element instead.</em>
   */
  def text: scala.Option[String] = attributes.get("text").asInstanceOf[scala.Option[String]]
  def text(value: String): Body = copy(attributes = attributes + ("text" -> value))
  /**
   * The margin of the top of the body. 
<em>This method is non-conforming, use CSS <a href="/en-US/docs/Web/CSS/margin-top" title="The margin-top CSS property of an element sets the margin space required on the top of an element. A negative value is also allowed."><code>margin-top</code></a> property on the element instead.</em>
   */
  def topmargin: scala.Option[String] = attributes.get("topmargin").asInstanceOf[scala.Option[String]]
  def topmargin(value: String): Body = copy(attributes = attributes + ("topmargin" -> value))
  /**
   * Color of text for visited hypertext links. 
<em>This method is non-conforming, use CSS <a href="/en-US/docs/Web/CSS/color" title="The color property sets the foreground color of an element's text content, and its decorations. It doesn't affect any other characteristic of the element; it should really be called text-color and would have been named so, save for historical reasons and its appearance in CSS Level 1."><code>color</code></a> property in conjunction with the <a href="/en-US/docs/Web/CSS/:visited" title="The :visited CSS pseudo-class lets you select only links that have been visited. This style may be overridden by any other link-related pseudo-classes, that is :link, :hover, and :active, appearing in subsequent rules. In order to style appropriately links, you need to put the :visited rule after the :link rule but before the other ones, defined in the LVHA-order: :link — :visited — :hover — :active."><code>:visited</code></a> pseudo-class instead.</em>
   */
  def vlink: scala.Option[String] = attributes.get("vlink").asInstanceOf[scala.Option[String]]
  def vlink(value: String): Body = copy(attributes = attributes + ("vlink" -> value))
}
