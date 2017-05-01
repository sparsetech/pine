package pl.metastack.metaweb.tag

import pl.metastack.metaweb._

/**
 * The <em>HTML Link Element</em> (<strong>&lt;link&gt;</strong>) specifies relationships between the current document and an external resource. Possible uses for this element include defining a relational framework for navigation. This Element is most used to link to style sheets.
&lt;link href="style.css" rel="stylesheet"&gt;
 */
case class Link(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[Node] = Seq.empty) extends HTMLTag {
  override type T = Link
  override def tagName = "link"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[Node] = children): Link = Link(attributes, children)
  /**
   * This attribute defines the character encoding of the linked resource. The value is a space- and/or comma-delimited list of character sets as defined in 
<a href="http://tools.ietf.org/html/rfc2045" class="external">RFC 2045</a>. The default value is ISO-8859-1. 
<div class="note">
 <strong>Usage note:</strong> This attribute is obsolete in HTML5 and 
 <em>must</em> 
 <strong>not be used by authors</strong>. To achieve its effect, use the 
 <span style="font-family: courier new;">Content-Type</span>&nbsp;HTTP header on the linked resource.
</div>
   */
  def charset: scala.Option[String] = attributes.get("charset").asInstanceOf[scala.Option[String]]
  def charset(value: String): Link = copy(attributes = attributes + ("charset" -> value))
  /**
   * This enumerated attribute indicates if the fetching of the related image must be done using CORS or not. 
<a href="/en-US/docs/CORS_Enabled_Image">CORS-enabled images</a> can be reused in the 
<a href="/en-US/docs/Web/HTML/Element/canvas" title="The HTML <canvas> Element can be used to draw graphics via scripting (usually JavaScript). For example, it can be used to draw graphs, make photo compositions or even perform animations. You may (and should) provide alternate content inside the <canvas> block. That content will be rendered both on older browsers that don't support canvas and in browsers with JavaScript disabled."><code>&lt;canvas&gt;</code></a> element without being 
<em>tainted</em>. The allowed values are: 
<dl> 
 <dt>
  anonymous
 </dt> 
 <dd>
  A cross-origin request (i.e. with 
  <code>Origin:</code> HTTP header) is performed. But no credential is sent (i.e. no cookie, no X.509 certificate and no HTTP Basic authentication is sent). If the server does not give credentials to the origin site (by not setting the 
  <code>Access-Control-Allow-Origin:</code> HTTP header), the image will be 
  <em>tainted</em> and its usage restricted..
 </dd> 
 <dt>
  use-credentials
 </dt> 
 <dd>
  A cross-origin request (i.e. with 
  <code>Origin:</code> HTTP header) is performed with credential is sent (i.e. a cookie, a certificate and HTTP Basic authentication is performed). If the server does not give credentials to the origin site (through 
  <code>Access-Control-Allow-Credentials:</code> HTTP header), the image will be 
  <em>tainted</em> and its usage restricted.
 </dd> 
</dl> When not present, the resource is fetched without a CORS request (i.e. without sending the 
<code>Origin:</code> HTTP header), preventing its non-tainted used in 
<a href="/en-US/docs/Web/HTML/Element/canvas" title="The HTML <canvas> Element can be used to draw graphics via scripting (usually JavaScript). For example, it can be used to draw graphs, make photo compositions or even perform animations. You may (and should) provide alternate content inside the <canvas> block. That content will be rendered both on older browsers that don't support canvas and in browsers with JavaScript disabled."><code>&lt;canvas&gt;</code></a> elements. If invalid, it is handled as if the enumerated keyword 
<strong>anonymous</strong> was used. See 
<a href="/en-US/docs/Web/HTML/CORS_settings_attributes">CORS settings attributes</a> for additional information.
   */
  def crossorigin: scala.Option[String] = attributes.get("crossorigin").asInstanceOf[scala.Option[String]]
  def crossorigin(value: String): Link = copy(attributes = attributes + ("crossorigin" -> value))
  /**
   * This attribute is used to disable a link relationship. In conjunction with scripting, this attribute could be used to turn on and off various style sheet relationships. 
<div class="note"> 
 <p><strong>Note: </strong>While there is no <code>disabled</code> attribute in the HTML standard, there <strong>is</strong> a <code>disabled</code> attribute on the <code>HTMLLinkElement</code> DOM object.</p> 
 <p>The use of <code>disabled</code> as an HTML attribute is non-standard and only used by some browsers (<a href="https://www.w3.org/Bugs/Public/show_bug.cgi?id=27677" class="external">W3 #27677</a>). <strong style="font-weight: bold;">Do not use it</strong>. To achieve a similar effect, use one of the following techniques:</p> 
 <ul> 
  <li>If the <code>disabled</code> attribute has been added directly to the element on the page, do not include the <a href="/en-US/docs/Web/HTML/Element/link" title="The HTML Link Element (<link>) specifies relationships between the current document and an external resource. Possible uses for this element include defining a relational framework for navigation. This Element is most used to link to style sheets."><code>&lt;link&gt;</code></a> element instead;</li> 
  <li>Set the <code>disabled</code> <strong>property</strong> of the <code>StyleSheet</code> DOM object via scripting.</li> 
 </ul> 
</div>
   */
  def disabled: scala.Option[String] = attributes.get("disabled").asInstanceOf[scala.Option[String]]
  def disabled(value: String): Link = copy(attributes = attributes + ("disabled" -> value))
  /**
   * This attribute specifies the 
<a href="/en-US/docs/URIs_and_URLs">URL</a> of the linked resource. A URL might be absolute or relative.
   */
  def href: scala.Option[String] = attributes.get("href").asInstanceOf[scala.Option[String]]
  def href(value: String): Link = copy(attributes = attributes + ("href" -> value))
  /**
   * This attribute indicates the language of the linked resource. It is purely advisory. Allowed values are determined by 
<a href="http://www.ietf.org/rfc/bcp/bcp47.txt" class="external">BCP47</a> for HTML5 and by 
<a href="http://www.ietf.org/rfc/rfc1766.txt" class="external">RFC1766</a> for HTML 4. Use this attribute only if the 
<code><a href="/en-US/docs/Web/HTML/Element/a#attr-href">href</a></code> attribute is present.
   */
  def hreflang: scala.Option[String] = attributes.get("hreflang").asInstanceOf[scala.Option[String]]
  def hreflang(value: String): Link = copy(attributes = attributes + ("hreflang" -> value))
  /**
   * This attribute specifies the media which the linked resource applies to. Its value must be a 
<a href="/en-US/docs/CSS/Media_queries">media query</a>. This attribute is mainly useful when linking to external stylesheets by allowing the user agent to pick the best adapted one for the device it runs on. 
<div class="note">
 <strong>Usage note: </strong> 
 <ul> 
  <li>In HTML 4, this can only be a simple white-space-separated list of media description literals, i.e., <a href="/en-US/docs/CSS/@media">media types and groups</a>, where defined and allowed as values for this attribute, such as <code>print</code>, <code>screen</code>, <code>aural</code>, <code>braille</code>. HTML5 extended this to any kind of <a href="/en-US/docs/CSS/Media_queries">media queries</a>, which are a superset of the allowed values of HTML 4.</li> 
  <li>Browsers not supporting the <a href="/en-US/docs/CSS/Media_queries">CSS3 Media Queries</a> won't necessarily recognize the adequate link; do not forget to set fallback links, the restricted set of media queries defined in HTML 4.</li> 
 </ul> 
</div>
   */
  def media: scala.Option[String] = attributes.get("media").asInstanceOf[scala.Option[String]]
  def media(value: String): Link = copy(attributes = attributes + ("media" -> value))
  /**
   * The value of this attribute provides information about the functions that might be performed on an object. The values generally are given by the HTTP protocol when it is used, but it might (for similar reasons as for the 
<strong>title</strong> attribute) be useful to include advisory information in advance in the link. For example, the browser might choose a different rendering of a link as a function of the methods specified; something that is searchable might get a different icon, or an outside link might render with an indication of leaving the current site. This attribute is not well understood nor supported, even by the defining browser, Internet Explorer 4. See 
<a href="http://msdn.microsoft.com/en-us/library/ms534168%28VS.85%29.aspx" rel="external nofollow" class="external">Methods Property (MSDN)</a>.
   */
  def methods: scala.Option[String] = attributes.get("methods").asInstanceOf[scala.Option[String]]
  def methods(value: String): Link = copy(attributes = attributes + ("methods" -> value))
  /**
   * This attribute names a relationship of the linked document to the current document. The attribute must be a space-separated list of the 
<a href="/en-US/docs/Web/HTML/Link_types">link types values</a>. The most common use of this attribute is to specify a link to an external style sheet: the 
<strong>rel</strong> attribute is set to 
<code>stylesheet</code>, and the 
<strong>href</strong> attribute is set to the URL of an external style sheet to format the page. WebTV also supports the use of the value 
<code>next</code> for 
<strong>rel</strong> to preload the next page in a document series.
   */
  def rel: scala.Option[String] = attributes.get("rel").asInstanceOf[scala.Option[String]]
  def rel(value: String): Link = copy(attributes = attributes + ("rel" -> value))
  /**
   * The value of this attribute shows the relationship of the current document to the linked document, as defined by the 
<code><a href="/en-US/docs/Web/HTML/Element/link#attr-href">href</a></code> attribute. The attribute thus defines the reverse relationship compared to the value of the 
<strong>rel</strong> attribute. 
<a href="/en-US/docs/Web/HTML/Link_types">Link types values</a> for the attribute are similar to the possible values for 
<code><a href="/en-US/docs/Web/HTML/Element/link#attr-rel">rel</a></code>. 
<div class="note">
 <strong>Usage note: </strong>This attribute is obsolete in HTML5. 
 <strong>Do not use it</strong>. To achieve its effect, use the 
 <code><a href="/en-US/docs/Web/HTML/Element/link#attr-rel">rel</a></code> attribute with the opposite 
 <a href="/en-US/docs/Web/HTML/Link_types">link types values</a>, e.g. 
 <span style="font-family: courier new;">made</span> should be replaced by 
 <span style="font-family: courier new;">author</span>. Also this attribute doesn't mean 
 <em>revision</em> and must not be used with a version number, which is unfortunately the case on numerous sites.
</div>
   */
  def rev: scala.Option[String] = attributes.get("rev").asInstanceOf[scala.Option[String]]
  def rev(value: String): Link = copy(attributes = attributes + ("rev" -> value))
  /**
   * This attribute defines the sizes of the icons for visual media contained in the resource. It must be present only if the 
<code><a href="/en-US/docs/Web/HTML/Element/link#attr-rel">rel</a></code> contains the 
<span style="font-family: courier new;">icon</span> 
<a href="/en-US/docs/Web/HTML/Link_types">link types value</a>. It may have the following values: 
<ul> 
 <li><code>any</code>, meaning that the icon can be scaled to any size as it is in a vectorial format, like <code>image/svg+xml</code>.</li> 
 <li>a white-space separated list of sizes, each in the format <span style="font-family: courier new;"><em>&lt;width in pixels&gt;</em>x<em>&lt;height in pixels&gt;</em></span> or <span style="font-family: courier new;"><em>&lt;width in pixels&gt;</em>X<em>&lt;height in pixels&gt;</em></span>. Each of these sizes must be contained in the resource.</li> 
</ul> 
<div class="note">
 <strong>Usage note: </strong> 
 <ul> 
  <li>Most icon format are only able to store one single icon; therefore most of the time the <code><a href="/en-US/docs/Web/HTML/Global_attributes#attr-sizes">sizes</a></code> contains only one entry. Among the major browsers, only the Apple's ICNS format allows the storage of multiple icons, and this format is only supported in WebKit.</li> 
  <li>Apple's iOS does not support this attribute, hence Apple's iPhone and iPad use special, non-standard <a href="/en-US/docs/Web/HTML/Link_types">link types values</a> to define icon to be used as Web Clip or start-up placeholder: <span style="font-family: courier new;">apple-touch-icon</span> and <span style="font-family: courier new;">apple-touch-startup-icon</span>.</li> 
 </ul> 
</div>
   */
  def sizes: scala.Option[String] = attributes.get("sizes").asInstanceOf[scala.Option[String]]
  def sizes(value: String): Link = copy(attributes = attributes + ("sizes" -> value))
  /**
   * Defines the frame or window name that has the defined linking relationship or that will show the rendering of any linked resource.
   */
  def target: scala.Option[String] = attributes.get("target").asInstanceOf[scala.Option[String]]
  def target(value: String): Link = copy(attributes = attributes + ("target" -> value))
  /**
   * This attribute is used to define the type of the content linked to. The value of the attribute should be a MIME type such as 
<strong>text/html</strong>, 
<strong>text/css</strong>, and so on. The common use of this attribute is to define the type of style sheet linked and the most common current value is 
<strong>text/css</strong>, which indicates a Cascading Style Sheet format.
   */
  def `type`: scala.Option[String] = attributes.get("type").asInstanceOf[scala.Option[String]]
  def `type`(value: String): Link = copy(attributes = attributes + ("type" -> value))
  /**
   * Contains inline metadata that a user agent can use to verify that a fetched resource has been delivered free of unexpected manipulation.&nbsp;
   */
  def integrity: scala.Option[String] = attributes.get("integrity").asInstanceOf[scala.Option[String]]
  def integrity(value: String): Link = copy(attributes = attributes + ("integrity" -> value))
}
