package pl.metastack.metaweb.tag

import pl.metastack.metaweb.tree

/**
 * The <em>HTML <code>&lt;area&gt;</code> element</em> defines a hot-spot region on an image, and optionally associates it with a <a class="glossaryLink" href="/en-US/docs/Glossary/Hyperlink" title="hypertext link: Hyperlinks connect web pages, or data items, to one another. In HTML, anchor elements define the hyperlinks from a part of a Web page, such as a text string or image, to another site, page or even a particular point within a page.">hypertext link</a>. This element is used only within a <a href="/en-US/docs/Web/HTML/Element/map" title="The HTML <map> element is used with <area> elements to define an image map (a clickable link area)."><code>&lt;map&gt;</code></a> element.
 */
case class Area(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[tree.Node] = Seq.empty) extends HTMLTag[Area] {
  override def tagName = "area"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[tree.Node] = children): Area = Area(attributes, children)
  /**
   * A text string alternative to display on browsers that do not display images. The text should be phrased so that it presents the user with the same kind of choice as the image would offer when displayed without the alternative text. In HTML4, this attribute is required, but may be the empty string (""). In HTML5, this attribute is required only if the 
<strong>href</strong> attribute is used.
   */
  def alt: scala.Option[String] = attributes.get("alt").asInstanceOf[scala.Option[String]]
  def alt(value: String): Area = copy(attributes = attributes + ("alt" -> value)).asInstanceOf[Area]
  /**
   * A set of values specifying the coordinates of the hot-spot region. The number and meaning of the values depend upon the value specified for the 
<strong>shape</strong> attribute. For a 
<code>rect</code> or rectangle shape, the 
<strong>coords</strong> value is two x,y pairs: left, top, right, and bottom. For a 
<code>circle</code> shape, the value is 
<code>x,y,r</code> where 
<code>x,y</code> is a pair specifying the center of the circle and 
<code>r</code> is a value for the radius. For a 
<code>poly</code> or polygon&lt; shape, the value is a set of x,y pairs for each point in the polygon: 
<code>x1,y1,x2,y2,x3,y3,</code> and so on. In HTML4, the values are numbers of pixels or percentages, if a percent sign (%) is appended; in HTML5, the values are numbers of CSS&nbsp;pixels.
   */
  def coords: scala.Option[String] = attributes.get("coords").asInstanceOf[scala.Option[String]]
  def coords(value: String): Area = copy(attributes = attributes + ("coords" -> value)).asInstanceOf[Area]
  /**
   * This attribute, if present, indicates that the author intends the hyperlink to be used for downloading a resource. See 
<a href="/en-US/docs/Web/HTML/Element/a" title="The HTML <a> Element (or the HTML Anchor Element) defines a hyperlink, the named target destination for a hyperlink, or both."><code>&lt;a&gt;</code></a> for a full description of the 
<code><a href="/en-US/docs/Web/HTML/Element/a#attr-download">download</a></code> attribute.
   */
  def download: scala.Option[String] = attributes.get("download").asInstanceOf[scala.Option[String]]
  def download(value: String): Area = copy(attributes = attributes + ("download" -> value)).asInstanceOf[Area]
  /**
   * The hyperlink target for the area. Its value is a valid URL. In HTML4, either this attribute or the 
<strong>nohref</strong> attribute must be present in the element. In HTML5, this attribute may be omitted; if so, the area element does not represent a hyperlink.
   */
  def href: scala.Option[String] = attributes.get("href").asInstanceOf[scala.Option[String]]
  def href(value: String): Area = copy(attributes = attributes + ("href" -> value)).asInstanceOf[Area]
  /**
   * Indicates the language of the linked resource. Allowed values are determined by 
<a class="external" href="http://www.ietf.org/rfc/bcp/bcp47.txt" title="http://www.ietf.org/rfc/bcp/bcp47.txt">BCP47</a>. Use this attribute only if the 
<strong>href</strong> attribute is present.
   */
  def hreflang: scala.Option[String] = attributes.get("hreflang").asInstanceOf[scala.Option[String]]
  def hreflang(value: String): Area = copy(attributes = attributes + ("hreflang" -> value)).asInstanceOf[Area]
  /**
   * Define a names for the clickable area so that it can be scripted by older browsers.
   */
  def name: scala.Option[String] = attributes.get("name").asInstanceOf[scala.Option[String]]
  def name(value: String): Area = copy(attributes = attributes + ("name" -> value)).asInstanceOf[Area]
  /**
   * A hint of the media for which the linked resource was designed, for example 
<code>print and screen</code>. If omitted, it defaults to 
<code>all</code>. Use this attribute only if the 
<strong>href</strong> attribute is present.
   */
  def media: scala.Option[String] = attributes.get("media").asInstanceOf[scala.Option[String]]
  def media(value: String): Area = copy(attributes = attributes + ("media" -> value)).asInstanceOf[Area]
  /**
   * Indicates that no hyperlink exists for the associated area. Either this attribute or the 
<strong>href</strong> attribute must be present in the element. 
<div class="note"> 
 <p><strong>Usage note: </strong>This attribute is obsolete in HTML5, instead omitting the <strong>href</strong> attribute is sufficient.</p> 
</div>
   */
  def nohref: scala.Option[String] = attributes.get("nohref").asInstanceOf[scala.Option[String]]
  def nohref(value: String): Area = copy(attributes = attributes + ("nohref" -> value)).asInstanceOf[Area]
  /**
   * For anchors containing the 
<strong>href</strong> attribute, this attribute specifies the relationship of the target object to the link object. The value is a comma-separated list of 
<a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Link_types">link types values</a>. The values and their semantics will be registered by some authority that might have meaning to the document author. The default relationship, if no other is given, is void. Use this attribute only if the 
<strong>href</strong> attribute is present.
   */
  def rel: scala.Option[String] = attributes.get("rel").asInstanceOf[scala.Option[String]]
  def rel(value: String): Area = copy(attributes = attributes + ("rel" -> value)).asInstanceOf[Area]
  /**
   * The shape of the associated hot spot. The specifications for HTML 5 and HTML 4 define the values 
<code>rect</code>, which defines a rectangular region; 
<code>circle</code>, which defines a circular region; 
<code>poly</code>, which defines a polygon; and 
<code>default</code>, which indicates the entire region beyond any defined shapes. Many browsers, notably Internet Explorer 4 and higher, support 
<code>circ</code>, 
<code>polygon</code>, and 
<code>rectangle</code> as valid values for 
<strong>shape</strong>; these values are 
<span title="This API has not been standardized."><i class="icon-warning-sign"> </i></span>.
   */
  def shape: scala.Option[String] = attributes.get("shape").asInstanceOf[scala.Option[String]]
  def shape(value: String): Area = copy(attributes = attributes + ("shape" -> value)).asInstanceOf[Area]
  /**
   * This attribute specifies where to display the linked resource. In HTML4, this is the name of, or a keyword for, a frame. In HTML5, it is a name of, or keyword for, a 
<em>browsing context</em> (for example, tab, window, or inline frame). The following keywords have special meanings: 
<ul> 
 <li><code>_self</code>: Load the response into the same HTML4 frame (or HTML5 browsing context) as the current one. This value is the default if the attribute is not specified.</li> 
 <li><code>_blank</code>: Load the response into a new unnamed HTML4 window or HTML5 browsing context.</li> 
 <li><code>_parent</code>: Load the response into the HTML4 frameset parent of the current frame or HTML5 parent browsing context of the current one. If there is no parent, this option behaves the same way as <code>_self</code>.</li> 
 <li><code>_top</code>: In HTML4: Load the response into the full, original window, canceling all other frames. In HTML5: Load the response into the top-level browsing context (that is, the browsing context that is an ancestor of the current one, and has no parent). If there is no parent, this option behaves the same way as <code>_self</code>.</li> 
</ul> Use this attribute only if the 
<strong>href</strong> attribute is present.
   */
  def target: scala.Option[String] = attributes.get("target").asInstanceOf[scala.Option[String]]
  def target(value: String): Area = copy(attributes = attributes + ("target" -> value)).asInstanceOf[Area]
  /**
   * This attribute specifies the media type in the form of a MIME type for the link target. Generally, this is provided strictly as advisory information; however, in the future a browser might add a small icon for multimedia types. For example, a browser might add a small speaker icon when type is set to audio/wav. For a complete list of recognized MIME types, see 
<a class="external linkification-ext" href="http://www.w3.org/TR/html4/references.html#ref-MIMETYPES" title="Linkification: http://www.w3.org/TR/html4/references.html#ref-MIMETYPES">http://www.w3.org/TR/html4/references.html#ref-MIMETYPES</a>. Use this attribute only if the 
<strong>href</strong> attribute is present.
   */
  def `type`: scala.Option[String] = attributes.get("type").asInstanceOf[scala.Option[String]]
  def `type`(value: String): Area = copy(attributes = attributes + ("type" -> value)).asInstanceOf[Area]
}
