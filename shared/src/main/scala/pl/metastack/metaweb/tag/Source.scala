package pl.metastack.metaweb.tag

import pl.metastack.metaweb.tree

/**
 * The <strong>HTML <code>&lt;source&gt;</code> element</strong> is used to specify multiple media resources for <a href="/en-US/docs/Web/HTML/Element/picture" title="The HTML <picture> element is a container used to specified multiple {{HTMLElement(&quot;source&quot;)}} for a specific {{HTMLElement(&quot;img&quot;)}} contained in it. The browser will choose the most suitable source according to the current layout (constraints of the box the image will appear in) of the page and the device it will be displayed on (like a normal or hiDPI device)."><code>&lt;picture&gt;</code></a>, <a href="/en-US/docs/Web/HTML/Element/audio" title="The HTML <audio> element is used to embed sound content in documents. It may contain several audio sources, represented using the src attribute or the <source> element; the browser will choose the most suitable one."><code>&lt;audio&gt;</code></a> and <a href="/en-US/docs/Web/HTML/Element/video" title="The HTML <video> element is used to embed video content. It may contain several video sources, represented using the src attribute or the <source> element; the browser will choose the most suitable one."><code>&lt;video&gt;</code></a> elements. It is an empty element. It is commonly used to serve the same media in <a href="/en-US/docs/Media_formats_supported_by_the_audio_and_video_elements" title="Media formats supported by the audio and video elements">multiple formats supported by different browsers</a>.
 */
case class Source(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[tree.Node] = Seq.empty) extends HTMLTag[Source] {
  override def tagName = "source"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[tree.Node] = children): Source = Source(attributes, children)
  /**
   * Is a list of source sizes that describes the final rendered width of the image represented by the source. Each source size consists of a comma-separated list of media condition-length pairs. This information is used by the browser to determine, before laying the page out, which image defined in 
<code><a href="/en-US/docs/Web/HTML/Element/source#attr-srcset">srcset</a></code> to use.
<br> The 
<code>sizes</code> attribute has an effect only when the 
<a href="/en-US/docs/Web/HTML/Element/source" title="The HTML <source> element is used to specify multiple media resources for <picture>, <audio> and <video> elements. It is an empty element. It is commonly used to serve the same media in multiple formats supported by different browsers."><code>&lt;source&gt;</code></a> element is the direct child of a 
<a href="/en-US/docs/Web/HTML/Element/picture" title="The HTML <picture> element is a container used to specified multiple {{HTMLElement(&quot;source&quot;)}} for a specific {{HTMLElement(&quot;img&quot;)}} contained in it. The browser will choose the most suitable source according to the current layout (constraints of the box the image will appear in) of the page and the device it will be displayed on (like a normal or hiDPI device)."><code>&lt;picture&gt;</code></a> element.
   */
  def sizes: scala.Option[String] = attributes.get("sizes").asInstanceOf[scala.Option[String]]
  def sizes(value: String): Source = copy(attributes = attributes + ("sizes" -> value)).asInstanceOf[Source]
  /**
   * Required for 
<a href="/en-US/docs/Web/HTML/Element/audio" title="The HTML <audio> element is used to embed sound content in documents. It may contain several audio sources, represented using the src attribute or the <source> element; the browser will choose the most suitable one."><code>&lt;audio&gt;</code></a> and 
<a href="/en-US/docs/Web/HTML/Element/video" title="The HTML <video> element is used to embed video content. It may contain several video sources, represented using the src attribute or the <source> element; the browser will choose the most suitable one."><code>&lt;video&gt;</code></a>, address of the media resource. The value of this attribute is ignored when the 
<code>&lt;source&gt;</code> element is placed inside a 
<a href="/en-US/docs/Web/HTML/Element/picture" title="The HTML <picture> element is a container used to specified multiple {{HTMLElement(&quot;source&quot;)}} for a specific {{HTMLElement(&quot;img&quot;)}} contained in it. The browser will choose the most suitable source according to the current layout (constraints of the box the image will appear in) of the page and the device it will be displayed on (like a normal or hiDPI device)."><code>&lt;picture&gt;</code></a> element.
   */
  def src: scala.Option[String] = attributes.get("src").asInstanceOf[scala.Option[String]]
  def src(value: String): Source = copy(attributes = attributes + ("src" -> value)).asInstanceOf[Source]
  /**
   * A list of one or more strings separated by commas indicating a set of possible images represented by the source for the browser to use. Each string is composed of: 
<ol> 
 <li>one URL to an image,</li> 
 <li>a width descriptor, that is a positive integer directly followed by <code>'w'</code>. The default value, if missing, is the infinity.</li> 
 <li>a pixel density descriptor, that is a positive floating number directly followed by <code>'x'</code>. The default value, if missing, is <code>1x</code>.</li> 
</ol> 
<p>Each string in the list must have at least a width descriptor or a pixel density descriptor to be valid. Among the list, there must be only one string containing the same tuple of width descriptor and pixel density descriptor.<br> The browser chooses the most adequate image to display at a given point of time.<br> The <code>srcset</code> attribute has an effect only when the <a href="/en-US/docs/Web/HTML/Element/source" title="The HTML <source> element is used to specify multiple media resources for <picture>, <audio> and <video> elements. It is an empty element. It is commonly used to serve the same media in multiple formats supported by different browsers."><code>&lt;source&gt;</code></a> element is the direct child of a <a href="/en-US/docs/Web/HTML/Element/picture" title="The HTML <picture> element is a container used to specified multiple {{HTMLElement(&quot;source&quot;)}} for a specific {{HTMLElement(&quot;img&quot;)}} contained in it. The browser will choose the most suitable source according to the current layout (constraints of the box the image will appear in) of the page and the device it will be displayed on (like a normal or hiDPI device)."><code>&lt;picture&gt;</code></a> element.</p>
   */
  def srcset: scala.Option[String] = attributes.get("srcset").asInstanceOf[scala.Option[String]]
  def srcset(value: String): Source = copy(attributes = attributes + ("srcset" -> value)).asInstanceOf[Source]
  /**
   * The MIME-type of the resource, optionally with a 
<code>codecs</code> parameter. See 
<a class="external" href="http://tools.ietf.org/html/rfc4281" title="http://www.rfc-editor.org/rfc/rfc4281.txt">RFC 4281</a> for information about how to specify codecs.
   */
  def `type`: scala.Option[String] = attributes.get("type").asInstanceOf[scala.Option[String]]
  def `type`(value: String): Source = copy(attributes = attributes + ("type" -> value)).asInstanceOf[Source]
  /**
   * <a class="internal" href="/en-US/docs/CSS/Media_queries" title="CSS/Media queries">Media query</a> of the resource's intended media; this should be used only in a 
<a href="/en-US/docs/Web/HTML/Element/picture" title="The HTML <picture> element is a container used to specified multiple {{HTMLElement(&quot;source&quot;)}} for a specific {{HTMLElement(&quot;img&quot;)}} contained in it. The browser will choose the most suitable source according to the current layout (constraints of the box the image will appear in) of the page and the device it will be displayed on (like a normal or hiDPI device)."><code>&lt;picture&gt;</code></a> element.
   */
  def media: scala.Option[String] = attributes.get("media").asInstanceOf[scala.Option[String]]
  def media(value: String): Source = copy(attributes = attributes + ("media" -> value)).asInstanceOf[Source]
}
