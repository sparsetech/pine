package pl.metastack.metaweb.tag

import pl.metastack.metaweb.tree

/**
 * <span class="seoSummary">The&nbsp;<em>HTML Image Element</em>&nbsp;(<strong>&lt;img&gt;</strong>) represents an image of the document.</span>
<p><strong>Usage note:</strong><br> Browsers do not always display the image referenced by the element. This is the case for non-graphical browsers (including those used by people with vision impairments), if the user chooses not to display images, or if the browser is unable to display the image because it is invalid or an <a href="#Supported_image_formats" title="HTML/Element/Img#Supported_Image_Formats">unsupported type</a>. In these cases, the browser may replace the image with the text defined in this element's <strong>alt</strong> attribute.</p>
 */
case class Img(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[tree.Node] = Seq.empty) extends HTMLTag[Img] {
  override def tagName = "img"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[tree.Node] = children): Img = Img(attributes, children)
  /**
   * The alignment of the image with respect to its surrounding context.
   */
  def `align vertical-align`: scala.Option[String] = attributes.get("align vertical-align").asInstanceOf[scala.Option[String]]
  def `align vertical-align`(value: String): Img = copy(attributes = attributes + ("align vertical-align" -> value.toString)).asInstanceOf[Img]
  /**
   * This attribute defines the alternative text describing the image. Users will see this displayed if the image URL is wrong, the image is not in one of the 
<a href="#Supported_image_formats" title="HTML/Element/Img#Supported image formats">supported formats</a>, or if the image is not yet downloaded. 
<div class="note"> 
 <p><strong>Usage note: </strong>Omitting this attribute indicates that the image <em>is</em> a key part of the content, but no textual equivalent is available. Setting this attribute to the empty string indicates that this image is <em>not</em> a key part of the content; non-visual browsers may omit it from rendering.</p> 
</div>
   */
  def alt: scala.Option[String] = attributes.get("alt").asInstanceOf[scala.Option[String]]
  def alt(value: String): Img = copy(attributes = attributes + ("alt" -> value.toString)).asInstanceOf[Img]
  /**
   * The width of a border around the image.
   */
  def border: scala.Option[String] = attributes.get("border").asInstanceOf[scala.Option[String]]
  def border(value: String): Img = copy(attributes = attributes + ("border" -> value.toString)).asInstanceOf[Img]
  /**
   * This enumerated attribute indicates if the fetching of the related image must be done using CORS or not. 
<a href="/en-US/docs/CORS_Enabled_Image" title="CORS_Enabled_Image">CORS-enabled images</a> can be reused in the 
<a href="/en-US/docs/Web/HTML/Element/canvas" title="The HTML <canvas> Element can be used to draw graphics via scripting (usually JavaScript). For example, it can be used to draw graphs, make photo compositions or even perform animations. You may (and should) provide alternate content inside the <canvas> block. That content will be rendered both on older browsers that don't support canvas and in browsers with JavaScript disabled."><code>&lt;canvas&gt;</code></a> element without being 
<em>tainted</em>. The allowed values are: 
<dl> 
 <dt>
  anonymous
 </dt> 
 <dd>
  A cross-origin request (i.e., with 
  <code>Origin:</code> HTTP header) is performed. But no credential is sent (i.e., no cookie, no X.509 certificate, and no HTTP Basic authentication is sent). If the server does not give credentials to the origin site (by not setting the 
  <code>Access-Control-Allow-Origin:</code> HTTP header), the image will be 
  <em>tainted</em> and its usage restricted.
 </dd> 
 <dt>
  use-credentials
 </dt> 
 <dd>
  A cross-origin request (i.e., with 
  <code>Origin:</code> HTTP header) performed with credential is sent (i.e., a cookie, a certificate, and HTTP Basic authentication is performed). If the server does not give credentials to the origin site (through 
  <code>Access-Control-Allow-Credentials:</code> HTTP header), the image will be 
  <em>tainted</em> and its usage restricted.
 </dd> 
</dl> When not present, the resource is fetched without a CORS request (i.e., without sending the 
<code>Origin:</code> HTTP header), preventing its non-tainted usage in 
<a href="/en-US/docs/Web/HTML/Element/canvas" title="The HTML <canvas> Element can be used to draw graphics via scripting (usually JavaScript). For example, it can be used to draw graphs, make photo compositions or even perform animations. You may (and should) provide alternate content inside the <canvas> block. That content will be rendered both on older browsers that don't support canvas and in browsers with JavaScript disabled."><code>&lt;canvas&gt;</code></a> elements. If invalid, it is handled as if the enumerated keyword 
<strong>anonymous</strong> was used. See 
<a href="/en-US/docs/HTML/CORS_settings_attributes" title="CORS settings attributes">CORS settings attributes</a> for additional information.
   */
  def crossorigin: scala.Option[String] = attributes.get("crossorigin").asInstanceOf[scala.Option[String]]
  def crossorigin(value: String): Img = copy(attributes = attributes + ("crossorigin" -> value.toString)).asInstanceOf[Img]
  /**
   * The intrinsic height of the image in 
<span class="inlineIndicator htmlVer htmlVerInline"><a href="/en-US/docs/HTML/HTML5">HTML5</a></span> CSS pixels, or 
<span class="inlineIndicator htmlVer htmlVerInline"><a href="/en-US/docs/HTML">HTML 4</a></span> in pixels or as a percentage.
   */
  def height: scala.Option[String] = attributes.get("height").asInstanceOf[scala.Option[String]]
  def height(value: String): Img = copy(attributes = attributes + ("height" -> value.toString)).asInstanceOf[Img]
  /**
   * The number of pixels of white space to insert to the left and right of the image.
   */
  def hspace: scala.Option[String] = attributes.get("hspace").asInstanceOf[scala.Option[String]]
  def hspace(value: String): Img = copy(attributes = attributes + ("hspace" -> value.toString)).asInstanceOf[Img]
  /**
   * This Boolean attribute indicates that the image is part of a server-side map. If so, the precise coordinates of a click are sent to the server. 
<div class="note"> 
 <p><strong>Usage note: </strong>This attribute is allowed only if the <code>&lt;img&gt;</code> element is a descendant of an <a href="/en-US/docs/Web/HTML/Element/a" title="The HTML <a> Element (or the HTML Anchor Element) defines a hyperlink, the named target destination for a hyperlink, or both."><code>&lt;a&gt;</code></a> element with a valid <code><a href="/en-US/docs/Web/HTML/Element/a#attr-href">href</a></code> attribute.</p> 
</div>
   */
  def ismap: scala.Option[String] = attributes.get("ismap").asInstanceOf[scala.Option[String]]
  def ismap(value: String): Img = copy(attributes = attributes + ("ismap" -> value.toString)).asInstanceOf[Img]
  /**
   * The URL of a description of the image to be displayed, which supplements the 
<strong>alt</strong> text.
   */
  def longdesc: scala.Option[String] = attributes.get("longdesc").asInstanceOf[scala.Option[String]]
  def longdesc(value: String): Img = copy(attributes = attributes + ("longdesc" -> value.toString)).asInstanceOf[Img]
  /**
   * A name for the element. It is supported in 
<span class="inlineIndicator htmlVer htmlVerInline"><a href="/en-US/docs/HTML">HTML 4</a></span> only for backward compatibility. Use the 
<strong>id</strong> attribute instead.
   */
  def name: scala.Option[String] = attributes.get("name").asInstanceOf[scala.Option[String]]
  def name(value: String): Img = copy(attributes = attributes + ("name" -> value.toString)).asInstanceOf[Img]
  /**
   * A&nbsp;list of one or more strings separated by commas indicating a set of source sizes. Each source size consists of: 
<ol> 
 <li>a media condition. This must be omitted for the last item.</li> 
 <li>a source size value.</li> 
</ol> 
<p>Source size values specify the intended display size of the image. User agents use the current source size to select one of the sources supplied by the <code>srcset</code> attribute, when those sources are described using width ('<code>w</code>') descriptors. The selected source size affects the intrinsic size of the image (the image’s display size if no CSS styling is applied). If the <code>srcset</code> attribute is absent, or contains no values with a width descriptor, then the <code>sizes</code> attribute has no effect.</p>
   */
  def sizes: scala.Option[String] = attributes.get("sizes").asInstanceOf[scala.Option[String]]
  def sizes(value: String): Img = copy(attributes = attributes + ("sizes" -> value.toString)).asInstanceOf[Img]
  /**
   * The image URL. This attribute is mandatory for the 
<code>&lt;img&gt;</code> element. On browsers supporting 
<code>srcset</code>, 
<code>src</code> is treated like a candidate image with a pixel density descriptor 
<code>1x</code> unless an image with this pixel density descriptor is already defined in 
<code>srcset</code> or 
<code>srcset</code> contains '
<code>w</code>' descriptors.
   */
  def src: scala.Option[String] = attributes.get("src").asInstanceOf[scala.Option[String]]
  def src(value: String): Img = copy(attributes = attributes + ("src" -> value.toString)).asInstanceOf[Img]
  /**
   * A list of one or more strings separated by commas indicating a set of possible image sources for the user agent to use. Each string is composed of: 
<ol> 
 <li>a URL to an image,</li> 
 <li>optionally, whitespace followed by one of: 
  <ul> 
   <li>a width descriptor, that is a positive integer directly followed by '<code>w</code>'. The width descriptor is divided by the source size given in the&nbsp;<code>sizes</code>&nbsp;attribute to calculate the effective pixel density.</li> 
   <li>a pixel density descriptor, that is a positive floating point number directly followed by '<code>x</code>'.</li> 
  </ul> </li> 
</ol> 
<p>If no descriptor is specified, the source is assigned the default descriptor: <code>1x</code>.</p> 
<p>It is invalid to mix width descriptors and pixel density descriptors in the same <code>srcset</code> attribute. Duplicate descriptors (for instance, two sources in the same <code>srcset</code>&nbsp;which are both&nbsp;described with&nbsp;'<code style="font-style: normal;">2x</code>')&nbsp;are invalid, too.</p> 
<p>User agents are given discretion to choose any one of the available sources. This provides them with significant leeway to tailor their selection based on things like user preferences or bandwidth conditions.</p>
   */
  def srcset: scala.Option[String] = attributes.get("srcset").asInstanceOf[scala.Option[String]]
  def srcset(value: String): Img = copy(attributes = attributes + ("srcset" -> value.toString)).asInstanceOf[Img]
  /**
   * The intrinsic width of the image in 
<span class="inlineIndicator htmlVer htmlVerInline"><a href="/en-US/docs/HTML/HTML5">HTML5</a></span> CSS pixels, or 
<span class="inlineIndicator htmlVer htmlVerInline"><a href="/en-US/docs/HTML">HTML 4</a></span> in pixels or as a percentage.
   */
  def width: scala.Option[String] = attributes.get("width").asInstanceOf[scala.Option[String]]
  def width(value: String): Img = copy(attributes = attributes + ("width" -> value.toString)).asInstanceOf[Img]
  /**
   * The partial URL (starting with '#') of an 
<a href="/en-US/docs/HTML/Element/map" title="HTML/Element/Map">image map</a> associated with the element. 
<div class="note"> 
 <p><strong>Usage note: </strong>You cannot use this attribute if the <code>&lt;img&gt;</code> element is a descendant of an <a href="/en-US/docs/Web/HTML/Element/a" title="The HTML <a> Element (or the HTML Anchor Element) defines a hyperlink, the named target destination for a hyperlink, or both."><code>&lt;a&gt;</code></a> or <a href="/en-US/docs/Web/HTML/Element/button" title="The HTML <button> Element represents a clickable button."><code>&lt;button&gt;</code></a> element.</p> 
</div>
   */
  def usemap: scala.Option[String] = attributes.get("usemap").asInstanceOf[scala.Option[String]]
  def usemap(value: String): Img = copy(attributes = attributes + ("usemap" -> value.toString)).asInstanceOf[Img]
  /**
   * The number of pixels of white space to insert above and below the image.
   */
  def vspace: scala.Option[String] = attributes.get("vspace").asInstanceOf[scala.Option[String]]
  def vspace(value: String): Img = copy(attributes = attributes + ("vspace" -> value.toString)).asInstanceOf[Img]
}
