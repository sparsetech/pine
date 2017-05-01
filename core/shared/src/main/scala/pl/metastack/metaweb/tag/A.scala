package pl.metastack.metaweb.tag

import pl.metastack.metaweb._

/**
 * <span style="line-height: 21px;">This element includes the&nbsp;</span><a href="https://developer.mozilla.org/en-US/docs/HTML/Global_attributes" title="HTML/Global attributes" style="line-height: 21px;">global attributes</a><span style="line-height: 21px;">.</span>
<dt>
 <strong id="attr-download"><code>download</code></strong> 
 <span class="inlineIndicator htmlVer htmlVerInline"><a href="/en-US/docs/HTML/HTML5">HTML5</a></span>
</dt> 
<dd>
 This attribute, if present, indicates that the author intends the hyperlink to be used for downloading a resource so that when the user clicks on the link they will be prompted to save it as a local file. If the attribute has a value, the value will be used as the pre-filled file name in the Save prompt that opens when the user clicks on the link (the user can change the name before actually saving the file of course). There are no restrictions on allowed values (though 
 <code>/</code> and 
 <code>\</code> will be converted to underscores, preventing specific path hints), but you should consider that most file systems have limitations with regard to what punctuation is supported in file names, and browsers are likely to adjust file names accordingly. 
 <div class="note"> 
  <p><strong>Note:</strong></p> 
  <ul> 
   <li>Can be used with <a href="/en-US/docs/Web/API/URL.createObjectURL" title="/en-US/docs/Web/API/URL.createObjectURL"><code>blob:</code> URLs</a> and <code>data:</code> URLs, to make it easy for users to download content that is generated programmatically using JavaScript (e.g. a picture created using an online drawing Web app).</li> 
   <li>If the HTTP header <code>Content-Disposition:</code> is present and gives a different filename than this attribute, the HTTP header has priority over this attribute.</li> 
   <li>If this attribute is present and <code>Content-Disposition:</code> is set to <code>inline</code>, Firefox gives priority to <code>Content-Disposition</code>, like for the filename case, while Chrome gives priority to the <code>download</code> attribute.</li> 
   <li>This attribute is only honored for links to resources with the same-origin.</li> 
  </ul> 
 </div> 
</dd> 
<dt>
 <strong id="attr-href"><code>href</code></strong>
</dt> 
<dd>
 This was the single required attribute for anchors defining a hypertext source link, but is no longer required in HTML5. Omitting this attribute creates a placeholder link. The 
 <code>href</code> attribute indicates the link target, either a URL or a URL fragment. A URL fragment is a name preceded by a hash mark (#), which specifies an internal target location (an 
 <a href="/en-US/docs/HTML/Global_attributes#attr-id" title="Global attributes#attr-id">ID</a>) within the current document. URLs are not restricted to Web (HTTP)-based documents. URLs might use any protocol supported by the browser. For example, 
 <code>file</code>, 
 <code>ftp</code>, and 
 <code>mailto</code> work in most user agents. 
 <div class="note"> 
  <p><strong>Note:</strong> You can use the special fragment "top" to create a link back to the top of the page; for example <code>&lt;a href="#top"&gt;Return to top&lt;/a&gt;</code>. <a href="http://www.whatwg.org/specs/web-apps/current-work/multipage/history.html#scroll-to-fragid" class="external" lang="en" title="http://www.whatwg.org/specs/web-apps/current-work/multipage/history.html#scroll-to-fragid">This behavior is specified by HTML5</a>.</p> 
 </div> 
</dd> 
<dt>
 <strong id="attr-hreflang"><code>hreflang</code></strong>
</dt> 
<dd>
 This attribute indicates the language of the linked resource. It is purely advisory. Allowed values are determined by 
 <a href="http://www.ietf.org/rfc/bcp/bcp47.txt" class="external" title="http://www.ietf.org/rfc/bcp/bcp47.txt">BCP47</a> for HTML5 and by 
 <a href="http://www.ietf.org/rfc/rfc1766.txt" class="external" title="http://www.ietf.org/rfc/rfc1766.txt">RFC1766</a> for HTML4. Use this attribute only if the 
 <code><a href="/en-US/docs/Web/HTML/Element/a#attr-href">href</a></code> attribute is present.
</dd> 
<dt>
 <strong id="attr-media"><code>media</code></strong> 
 <span class="inlineIndicator htmlVer htmlVerInline"><a href="/en-US/docs/HTML/HTML5">HTML5</a></span>
</dt> 
<dd>
 This attribute specifies the media which the linked resource applies to. Its value must be a 
 <a href="/en-US/docs/CSS/Media_queries" title="CSS/Media queries">media query</a>. This attribute is mainly useful when linking to external stylesheets by allowing the user agent to pick the best adapted one for the device it runs on. 
 <div class="note"> 
  <p><strong>Usage note:</strong></p> 
  <ul> 
   <li>In HTML 4, only simple white-space-separated list of media description literals, i.e. <a href="/en-US/docs/CSS/@media" title="https://developer.mozilla.org/en-US/docs/CSS/@media">media types and groups</a>, where defined and allowed as values for this attribute, like <code>print</code>, <code>screen</code>, <code>aural</code>, <code>braille</code>, ... HTML 5 extended this to any kind of <a href="/en-US/docs/CSS/Media_queries" title="CSS/Media queries">media queries</a>, which are a superset of the allowed values of HTML 4.</li> 
   <li>Browsers not supporting the <a href="/en-US/docs/CSS/Media_queries" title="CSS/Media queries">CSS3 Media Queries</a> won't necessarily recognize the adequate link; do not forget to set fallback links, the restricted set of media queries defined in HTML 4.</li> 
  </ul> 
 </div> 
</dd> 
<dt>
 <strong id="attr-ping"><code>ping</code></strong> 
 <span class="inlineIndicator htmlVer htmlVerInline"><a href="/en-US/docs/HTML/HTML5">HTML5</a></span>
</dt> 
<dd>
 The 'ping' attribute, if present, sends the URLs of the resources a notification/ping if the user follows the hyperlink.
</dd> 
<dt>
 <strong id="attr-rel"><code>rel</code></strong>
</dt> 
<dd>
 For anchors containing the 
 <strong>href</strong> attribute, this attribute specifies the relationship of the target object to the link object. The value is a comma-separated list of 
 <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Link_types">link types values</a>. The values and their semantics will be registered by some authority that might have meaning to the document author. The default relationship, if no other is given, is void. Use this attribute only if the 
 <strong>href</strong> attribute is present.
</dd> 
<dt>
 <strong id="attr-target"><code>target</code></strong>
</dt> 
<dd>
 This attribute specifies where to display the linked resource. In HTML4, this is the name of, or a keyword for, a frame. In HTML5, it is a name of, or keyword for, a 
 <em>browsing context</em> (for example, tab, window, or inline frame). The following keywords have special meanings: 
 <ul> 
  <li><code>_self</code>: Load the response into the same HTML4 frame (or HTML5 browsing context) as the current one. This value is the default if the attribute is not specified.</li> 
  <li><code>_blank</code>: Load the response into a new unnamed HTML4 window or HTML5 browsing context.</li> 
  <li><code>_parent</code>:&nbsp;Load the response into the HTML4 frameset parent of the current frame or HTML5 parent browsing context of the current one. If there is no parent, this option behaves the same way as <code>_self</code>.</li> 
  <li><code>_top</code>: In HTML4: Load the response into the full, original window, canceling all other frames. In HTML5: Load the response into the top-level browsing context (that is, the browsing context that is an ancestor of the current one, and has no parent). If there is no parent, this option behaves the same way as <code>_self</code>.</li> 
 </ul> Use this attribute only if the 
 <strong>href</strong> attribute is present.
</dd> 
<dt>
 <strong id="attr-type"><code>type</code></strong>
</dt> 
<dd>
 This attribute specifies the media type in the form of a 
 <a href="/en-US/docs/Glossary/MIME_type" class="glossaryLink" title="MIME type: A&nbsp;MIME type&nbsp;(now properly called &quot;media type&quot;, but&nbsp;also sometimes &quot;content type&quot;) is a string sent along&nbsp;with a file indicating the file&nbsp;type (for example, a sound file might be labeled&nbsp;audio/ogg, or an image file&nbsp;image/png). It serves the same purpose as filename&nbsp;extensions traditionally do on Windows.">MIME type</a> for the link target. Generally, this is provided strictly as advisory information; however, in the future a browser might add a small icon for multimedia types. For example, a browser might add a small speaker icon when type is set to audio/wav. For a complete list of recognized MIME types, see 
 <a href="http://www.w3.org/TR/html4/references.html#ref-MIMETYPES" class="external linkification-ext" title="Linkification: http://www.w3.org/TR/html4/references.html#ref-MIMETYPES">http://www.w3.org/TR/html4/references.html#ref-MIMETYPES</a>. Use this attribute only if the 
 <code>href</code> attribute is present.
</dd>
Obsolete
<dt>
 <strong id="attr-charset"><code>charset</code></strong> 
 <span class="inlineIndicator obsolete obsoleteInline" title="">Obsolete since <a href="/en-US/docs/HTML/HTML5">HTML5</a></span>
</dt> 
<dd>
 This attribute defines the character encoding of the linked resource. The value is a space- and/or comma-delimited list of character sets as defined in 
 <a href="http://tools.ietf.org/html/rfc2045" class="external" title="http://tools.ietf.org/html/rfc2045">RFC 2045</a>. The default value is ISO-8859-1. 
 <div class="note"> 
  <p><strong>Usage note: </strong>This attribute is obsolete in HTML5 and <strong>should not be used by authors</strong>. To achieve its effect, use the HTTP Content-Type header on the linked resource.</p> 
 </div> 
</dd> 
<dt>
 <strong id="attr-coords"><code>coords</code></strong> 
 <span class="inlineIndicator htmlVer htmlVerInline"><a href="/en-US/docs/HTML">HTML 4</a></span> only, 
 <span class="inlineIndicator obsolete obsoleteInline" title="">Obsolete since <a href="/en-US/docs/HTML/HTML5">HTML5</a></span>
</dt> 
<dd>
 For use with object shapes, this attribute uses a comma-separated list of numbers to define the coordinates of the object on the page.
</dd> 
<dt>
 <strong id="attr-name"><code>name</code></strong> 
 <span class="inlineIndicator htmlVer htmlVerInline"><a href="/en-US/docs/HTML">HTML 4</a></span> only, 
 <span class="inlineIndicator obsolete obsoleteInline" title="">Obsolete since <a href="/en-US/docs/HTML/HTML5">HTML5</a></span>
</dt> 
<dd>
 This attribute is required in an anchor defining a target location within a page. A value for 
 <strong>name</strong> is similar to a value for the 
 <strong>id</strong> core attribute and should be an alphanumeric identifier unique to the document. Under the HTML 4.01 specification, 
 <strong>id</strong> and 
 <strong>name</strong> both can be used with the &lt;a&gt; element as long as they have identical values. 
 <div class="note"> 
  <p><strong>Usage note:</strong> This attribute is obsolete in HTML5, use <a href="/en-US/docs/HTML/Global_attributes#attr-id" title="HTML/Global attributes#id">global attribute <strong>id</strong></a> instead.</p> 
 </div> 
</dd> 
<dt>
 <strong id="attr-rev"><code>rev</code></strong> 
 <span class="inlineIndicator htmlVer htmlVerInline"><a href="/en-US/docs/HTML">HTML 4</a></span> only, 
 <span class="inlineIndicator obsolete obsoleteInline" title="">Obsolete since <a href="/en-US/docs/HTML/HTML5">HTML5</a></span>
</dt> 
<dd>
 This attribute specifies a reverse link, the inverse relationship of the 
 <strong>rel</strong> attribute. It is useful for indicating where an object came from, such as the author of a document.
</dd> 
<dt>
 <strong id="attr-shape"><code>shape</code></strong> 
 <span class="inlineIndicator htmlVer htmlVerInline"><a href="/en-US/docs/HTML">HTML 4</a></span> only, 
 <span class="inlineIndicator obsolete obsoleteInline" title="">Obsolete since <a href="/en-US/docs/HTML/HTML5">HTML5</a></span>
</dt> 
<dd>
 This attribute is used to define a selectable region for hypertext source links associated with a figure to create an image map. The values for the attribute are 
 <code>circle</code>, 
 <code>default</code>, 
 <code>polygon</code>, and 
 <code>rect</code>. The format of the 
 <strong>coords</strong> attribute depends on the value of shape. For 
 <code>circle</code>, the value is 
 <code>x,y,r</code> where 
 <code>x</code> and 
 <code>y</code> are the pixel coordinates for the center of the circle and 
 <code>r</code> is the radius value in pixels. For 
 <code>rect</code>, the 
 <strong>coords</strong> attribute should be 
 <code>x,y,w,h</code>. The 
 <code>x,y</code> values define the upper-left-hand corner of the rectangle, while 
 <code>w</code> and 
 <code>h</code> define the width and height respectively. A value of 
 <code>polygon</code> for 
 <strong>shape</strong> requires 
 <code>x1,y1,x2,y2,...</code> values for 
 <strong>coords</strong>. Each of the 
 <code>x,y</code> pairs defines a point in the polygon, with successive points being joined by straight lines and the last point joined to the first. The value 
 <code>default</code> for shape requires that the entire enclosed area, typically an image, be used. 
 <div class="note">
  <strong>Note: </strong>It is advisable to use the 
  <code>usemap</code> attribute for the 
  <a href="/en-US/docs/Web/HTML/Element/img" title="The&nbsp;HTML Image Element&nbsp;(<img>) represents an image of the document."><code>&lt;img&gt;</code></a> element and the associated 
  <a href="/en-US/docs/Web/HTML/Element/map" title="The HTML <map> element is used with <area> elements to define an image map (a clickable link area)."><code>&lt;map&gt;</code></a> element to define hotspots instead of the 
  <code>shape</code> attribute.
 </div> 
</dd>
Non standard
<dt>
 <strong id="attr-datafld"><code>datafld</code></strong> 
 <span title="This API has not been standardized."><i class="icon-warning-sign"> </i></span>
</dt> 
<dd>
 This attribute specifies the column name from that data source object that supplies the bound data. 
 <div class="note"> 
  <p><strong>Usage note: </strong>This attribute is non-standard and <strong>should not be used by authors</strong>. To achieve its effect, use scripting and a mechanism such as <a href="/en-US/docs/nsIXMLHttpRequest" title="XMLHttpRequest">XMLHttpRequest</a> to populate the page dynamically</p> 
 </div> 
 <table class="fullwidth-table"> 
  <tbody> 
   <tr> 
    <td rowspan="2">Support</td> 
    <td>Gecko</td> 
    <td>Presto</td> 
    <td>WebKit</td> 
    <td>Trident</td> 
   </tr> 
   <tr> 
    <td>Not implemented</td> 
    <td>Not implemented</td> 
    <td>Not implemented</td> 
    <td>IE4, IE5, IE6, IE7 (Removed in IE8)</td> 
   </tr> 
   <tr> 
    <td>Normative document</td> 
    <td colspan="4"><a href="http://msdn.microsoft.com/en-us/library/ms533703%28VS.85%29.aspx" class="external">Microsoft's Data Binding: dataFld Property (MSDN)</a></td> 
   </tr> 
  </tbody> 
 </table> 
</dd> 
<dt>
 <strong id="attr-datasrc"><code>datasrc</code></strong> 
 <span title="This API has not been standardized."><i class="icon-warning-sign"> </i></span>
</dt> 
<dd>
 This attribute indicates the ID of the data source object that supplies the data that is bound to this element. 
 <div class="note"> 
  <p><strong>Usage note: </strong>This attribute is non-standard and <strong>should not be used by authors</strong>. To achieve its effect, use scripting and a mechanism such as <a href="/en-US/docs/nsIXMLHttpRequest" title="XMLHttpRequest">XMLHttpRequest</a> to populate the page dynamically.</p> 
 </div> 
 <table class="fullwidth-table"> 
  <tbody> 
   <tr> 
    <td rowspan="2">Support</td> 
    <td>Gecko</td> 
    <td>Presto</td> 
    <td>WebKit</td> 
    <td>Trident</td> 
   </tr> 
   <tr> 
    <td>Not implemented</td> 
    <td>Not implemented</td> 
    <td>Not implemented</td> 
    <td>IE4, IE5, IE6, IE7 (Removed in IE8)</td> 
   </tr> 
   <tr> 
    <td>Normative document</td> 
    <td colspan="4"><a href="http://msdn.microsoft.com/en-us/library/ms533709(VS.85).aspx" class="external" title="http://msdn.microsoft.com/en-us/library/ms533709(VS.85).aspx">Microsoft's Data Binding: dataSrc Property (MSDN)</a></td> 
   </tr> 
  </tbody> 
 </table> 
</dd> 
<dt>
 <strong id="attr-methods"><code>methods</code></strong> 
 <span title="This API has not been standardized."><i class="icon-warning-sign"> </i></span>
</dt> 
<dd>
 The value of this attribute provides information about the functions that might be performed on an object. The values generally are given by the HTTP protocol when it is used, but it might (for similar reasons as for the title attribute) be useful to include advisory information in advance in the link. For example, the browser might choose a different rendering of a link as a function of the methods specified; something that is searchable might get a different icon, or an outside link might render with an indication of leaving the current site. This attribute is not well understood nor supported, even by the defining browser, Internet Explorer 4. 
 <a href="http://msdn.microsoft.com/en-us/library/ms534168(VS.85).aspx" class="external">Methods Property (MSDN)</a>
</dd>
<dt>
 <strong id="attr-urn"><code>urn</code></strong> 
 <span title="This API has not been standardized."><i class="icon-warning-sign"> </i></span>
</dt> 
<dd>
 This supposedly Microsoft-supported attribute relates a uniform resource name (URN) with the link. While it is based on standards work years back, the meaning of URNs is still not well defined, so this attribute is meaningless. 
 <a href="http://msdn.microsoft.com/en-us/library/ms534710(VS.85).aspx" class="external">urn Property (MSDN)</a>
</dd>
 */
case class A(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[Node] = Seq.empty) extends HTMLTag {
  override type T = A
  override def tagName = "a"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[Node] = children): A = A(attributes, children)
  /**
   * This attribute, if present, indicates that the author intends the hyperlink to be used for downloading a resource so that when the user clicks on the link they will be prompted to save it as a local file. If the attribute has a value, the value will be used as the pre-filled file name in the Save prompt that opens when the user clicks on the link (the user can change the name before actually saving the file of course). There are no restrictions on allowed values (though 
<code>/</code> and 
<code>\</code> will be converted to underscores, preventing specific path hints), but you should consider that most file systems have limitations with regard to what punctuation is supported in file names, and browsers are likely to adjust file names accordingly. 
<div class="note"> 
 <p><strong>Note:</strong></p> 
 <ul> 
  <li>Can be used with <a href="/en-US/docs/Web/API/URL.createObjectURL" title="/en-US/docs/Web/API/URL.createObjectURL"><code>blob:</code> URLs</a> and <code>data:</code> URLs, to make it easy for users to download content that is generated programmatically using JavaScript (e.g. a picture created using an online drawing Web app).</li> 
  <li>If the HTTP header <code>Content-Disposition:</code> is present and gives a different filename than this attribute, the HTTP header has priority over this attribute.</li> 
  <li>If this attribute is present and <code>Content-Disposition:</code> is set to <code>inline</code>, Firefox gives priority to <code>Content-Disposition</code>, like for the filename case, while Chrome gives priority to the <code>download</code> attribute.</li> 
  <li>This attribute is only honored for links to resources with the same-origin.</li> 
 </ul> 
</div>
   */
  def download: scala.Option[String] = attributes.get("download").asInstanceOf[scala.Option[String]]
  def download(value: String): A = copy(attributes = attributes + ("download" -> value))
  /**
   * This was the single required attribute for anchors defining a hypertext source link, but is no longer required in HTML5. Omitting this attribute creates a placeholder link. The 
<code>href</code> attribute indicates the link target, either a URL or a URL fragment. A URL fragment is a name preceded by a hash mark (#), which specifies an internal target location (an 
<a href="/en-US/docs/HTML/Global_attributes#attr-id" title="Global attributes#attr-id">ID</a>) within the current document. URLs are not restricted to Web (HTTP)-based documents. URLs might use any protocol supported by the browser. For example, 
<code>file</code>, 
<code>ftp</code>, and 
<code>mailto</code> work in most user agents. 
<div class="note"> 
 <p><strong>Note:</strong> You can use the special fragment "top" to create a link back to the top of the page; for example <code>&lt;a href="#top"&gt;Return to top&lt;/a&gt;</code>. <a href="http://www.whatwg.org/specs/web-apps/current-work/multipage/history.html#scroll-to-fragid" class="external" lang="en" title="http://www.whatwg.org/specs/web-apps/current-work/multipage/history.html#scroll-to-fragid">This behavior is specified by HTML5</a>.</p> 
</div>
   */
  def href: scala.Option[String] = attributes.get("href").asInstanceOf[scala.Option[String]]
  def href(value: String): A = copy(attributes = attributes + ("href" -> value))
  /**
   * This attribute indicates the language of the linked resource. It is purely advisory. Allowed values are determined by 
<a href="http://www.ietf.org/rfc/bcp/bcp47.txt" class="external" title="http://www.ietf.org/rfc/bcp/bcp47.txt">BCP47</a> for HTML5 and by 
<a href="http://www.ietf.org/rfc/rfc1766.txt" class="external" title="http://www.ietf.org/rfc/rfc1766.txt">RFC1766</a> for HTML4. Use this attribute only if the 
<code><a href="/en-US/docs/Web/HTML/Element/a#attr-href">href</a></code> attribute is present.
   */
  def hreflang: scala.Option[String] = attributes.get("hreflang").asInstanceOf[scala.Option[String]]
  def hreflang(value: String): A = copy(attributes = attributes + ("hreflang" -> value))
  /**
   * This attribute specifies the media which the linked resource applies to. Its value must be a 
<a href="/en-US/docs/CSS/Media_queries" title="CSS/Media queries">media query</a>. This attribute is mainly useful when linking to external stylesheets by allowing the user agent to pick the best adapted one for the device it runs on. 
<div class="note"> 
 <p><strong>Usage note:</strong></p> 
 <ul> 
  <li>In HTML 4, only simple white-space-separated list of media description literals, i.e. <a href="/en-US/docs/CSS/@media" title="https://developer.mozilla.org/en-US/docs/CSS/@media">media types and groups</a>, where defined and allowed as values for this attribute, like <code>print</code>, <code>screen</code>, <code>aural</code>, <code>braille</code>, ... HTML 5 extended this to any kind of <a href="/en-US/docs/CSS/Media_queries" title="CSS/Media queries">media queries</a>, which are a superset of the allowed values of HTML 4.</li> 
  <li>Browsers not supporting the <a href="/en-US/docs/CSS/Media_queries" title="CSS/Media queries">CSS3 Media Queries</a> won't necessarily recognize the adequate link; do not forget to set fallback links, the restricted set of media queries defined in HTML 4.</li> 
 </ul> 
</div>
   */
  def media: scala.Option[String] = attributes.get("media").asInstanceOf[scala.Option[String]]
  def media(value: String): A = copy(attributes = attributes + ("media" -> value))
  /**
   * The 'ping' attribute, if present, sends the URLs of the resources a notification/ping if the user follows the hyperlink.
   */
  def ping: scala.Option[String] = attributes.get("ping").asInstanceOf[scala.Option[String]]
  def ping(value: String): A = copy(attributes = attributes + ("ping" -> value))
  /**
   * For anchors containing the 
<strong>href</strong> attribute, this attribute specifies the relationship of the target object to the link object. The value is a comma-separated list of 
<a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Link_types">link types values</a>. The values and their semantics will be registered by some authority that might have meaning to the document author. The default relationship, if no other is given, is void. Use this attribute only if the 
<strong>href</strong> attribute is present.
   */
  def rel: scala.Option[String] = attributes.get("rel").asInstanceOf[scala.Option[String]]
  def rel(value: String): A = copy(attributes = attributes + ("rel" -> value))
  /**
   * This attribute specifies where to display the linked resource. In HTML4, this is the name of, or a keyword for, a frame. In HTML5, it is a name of, or keyword for, a 
<em>browsing context</em> (for example, tab, window, or inline frame). The following keywords have special meanings: 
<ul> 
 <li><code>_self</code>: Load the response into the same HTML4 frame (or HTML5 browsing context) as the current one. This value is the default if the attribute is not specified.</li> 
 <li><code>_blank</code>: Load the response into a new unnamed HTML4 window or HTML5 browsing context.</li> 
 <li><code>_parent</code>:&nbsp;Load the response into the HTML4 frameset parent of the current frame or HTML5 parent browsing context of the current one. If there is no parent, this option behaves the same way as <code>_self</code>.</li> 
 <li><code>_top</code>: In HTML4: Load the response into the full, original window, canceling all other frames. In HTML5: Load the response into the top-level browsing context (that is, the browsing context that is an ancestor of the current one, and has no parent). If there is no parent, this option behaves the same way as <code>_self</code>.</li> 
</ul> Use this attribute only if the 
<strong>href</strong> attribute is present.
   */
  def target: scala.Option[String] = attributes.get("target").asInstanceOf[scala.Option[String]]
  def target(value: String): A = copy(attributes = attributes + ("target" -> value))
  /**
   * This attribute specifies the media type in the form of a 
<a href="/en-US/docs/Glossary/MIME_type" class="glossaryLink" title="MIME type: A&nbsp;MIME type&nbsp;(now properly called &quot;media type&quot;, but&nbsp;also sometimes &quot;content type&quot;) is a string sent along&nbsp;with a file indicating the file&nbsp;type (for example, a sound file might be labeled&nbsp;audio/ogg, or an image file&nbsp;image/png). It serves the same purpose as filename&nbsp;extensions traditionally do on Windows.">MIME type</a> for the link target. Generally, this is provided strictly as advisory information; however, in the future a browser might add a small icon for multimedia types. For example, a browser might add a small speaker icon when type is set to audio/wav. For a complete list of recognized MIME types, see 
<a href="http://www.w3.org/TR/html4/references.html#ref-MIMETYPES" class="external linkification-ext" title="Linkification: http://www.w3.org/TR/html4/references.html#ref-MIMETYPES">http://www.w3.org/TR/html4/references.html#ref-MIMETYPES</a>. Use this attribute only if the 
<code>href</code> attribute is present.
   */
  def `type`: scala.Option[String] = attributes.get("type").asInstanceOf[scala.Option[String]]
  def `type`(value: String): A = copy(attributes = attributes + ("type" -> value))
  /**
   * This attribute defines the character encoding of the linked resource. The value is a space- and/or comma-delimited list of character sets as defined in 
<a href="http://tools.ietf.org/html/rfc2045" class="external" title="http://tools.ietf.org/html/rfc2045">RFC 2045</a>. The default value is ISO-8859-1. 
<div class="note"> 
 <p><strong>Usage note: </strong>This attribute is obsolete in HTML5 and <strong>should not be used by authors</strong>. To achieve its effect, use the HTTP Content-Type header on the linked resource.</p> 
</div>
   */
  def charset: scala.Option[String] = attributes.get("charset").asInstanceOf[scala.Option[String]]
  def charset(value: String): A = copy(attributes = attributes + ("charset" -> value))
  /**
   * For use with object shapes, this attribute uses a comma-separated list of numbers to define the coordinates of the object on the page.
   */
  def coords: scala.Option[String] = attributes.get("coords").asInstanceOf[scala.Option[String]]
  def coords(value: String): A = copy(attributes = attributes + ("coords" -> value))
  /**
   * This attribute is required in an anchor defining a target location within a page. A value for 
<strong>name</strong> is similar to a value for the 
<strong>id</strong> core attribute and should be an alphanumeric identifier unique to the document. Under the HTML 4.01 specification, 
<strong>id</strong> and 
<strong>name</strong> both can be used with the &lt;a&gt; element as long as they have identical values. 
<div class="note"> 
 <p><strong>Usage note:</strong> This attribute is obsolete in HTML5, use <a href="/en-US/docs/HTML/Global_attributes#attr-id" title="HTML/Global attributes#id">global attribute <strong>id</strong></a> instead.</p> 
</div>
   */
  def name: scala.Option[String] = attributes.get("name").asInstanceOf[scala.Option[String]]
  def name(value: String): A = copy(attributes = attributes + ("name" -> value))
  /**
   * This attribute specifies a reverse link, the inverse relationship of the 
<strong>rel</strong> attribute. It is useful for indicating where an object came from, such as the author of a document.
   */
  def rev: scala.Option[String] = attributes.get("rev").asInstanceOf[scala.Option[String]]
  def rev(value: String): A = copy(attributes = attributes + ("rev" -> value))
  /**
   * This attribute is used to define a selectable region for hypertext source links associated with a figure to create an image map. The values for the attribute are 
<code>circle</code>, 
<code>default</code>, 
<code>polygon</code>, and 
<code>rect</code>. The format of the 
<strong>coords</strong> attribute depends on the value of shape. For 
<code>circle</code>, the value is 
<code>x,y,r</code> where 
<code>x</code> and 
<code>y</code> are the pixel coordinates for the center of the circle and 
<code>r</code> is the radius value in pixels. For 
<code>rect</code>, the 
<strong>coords</strong> attribute should be 
<code>x,y,w,h</code>. The 
<code>x,y</code> values define the upper-left-hand corner of the rectangle, while 
<code>w</code> and 
<code>h</code> define the width and height respectively. A value of 
<code>polygon</code> for 
<strong>shape</strong> requires 
<code>x1,y1,x2,y2,...</code> values for 
<strong>coords</strong>. Each of the 
<code>x,y</code> pairs defines a point in the polygon, with successive points being joined by straight lines and the last point joined to the first. The value 
<code>default</code> for shape requires that the entire enclosed area, typically an image, be used. 
<div class="note">
 <strong>Note: </strong>It is advisable to use the 
 <code>usemap</code> attribute for the 
 <a href="/en-US/docs/Web/HTML/Element/img" title="The&nbsp;HTML Image Element&nbsp;(<img>) represents an image of the document."><code>&lt;img&gt;</code></a> element and the associated 
 <a href="/en-US/docs/Web/HTML/Element/map" title="The HTML <map> element is used with <area> elements to define an image map (a clickable link area)."><code>&lt;map&gt;</code></a> element to define hotspots instead of the 
 <code>shape</code> attribute.
</div>
   */
  def shape: scala.Option[String] = attributes.get("shape").asInstanceOf[scala.Option[String]]
  def shape(value: String): A = copy(attributes = attributes + ("shape" -> value))
  /**
   * This attribute specifies the column name from that data source object that supplies the bound data. 
<div class="note"> 
 <p><strong>Usage note: </strong>This attribute is non-standard and <strong>should not be used by authors</strong>. To achieve its effect, use scripting and a mechanism such as <a href="/en-US/docs/nsIXMLHttpRequest" title="XMLHttpRequest">XMLHttpRequest</a> to populate the page dynamically</p> 
</div> 
<table class="fullwidth-table"> 
 <tbody> 
  <tr> 
   <td rowspan="2">Support</td> 
   <td>Gecko</td> 
   <td>Presto</td> 
   <td>WebKit</td> 
   <td>Trident</td> 
  </tr> 
  <tr> 
   <td>Not implemented</td> 
   <td>Not implemented</td> 
   <td>Not implemented</td> 
   <td>IE4, IE5, IE6, IE7 (Removed in IE8)</td> 
  </tr> 
  <tr> 
   <td>Normative document</td> 
   <td colspan="4"><a href="http://msdn.microsoft.com/en-us/library/ms533703%28VS.85%29.aspx" class="external">Microsoft's Data Binding: dataFld Property (MSDN)</a></td> 
  </tr> 
 </tbody> 
</table>
   */
  def datafld: scala.Option[String] = attributes.get("datafld").asInstanceOf[scala.Option[String]]
  def datafld(value: String): A = copy(attributes = attributes + ("datafld" -> value))
  /**
   * This attribute indicates the ID of the data source object that supplies the data that is bound to this element. 
<div class="note"> 
 <p><strong>Usage note: </strong>This attribute is non-standard and <strong>should not be used by authors</strong>. To achieve its effect, use scripting and a mechanism such as <a href="/en-US/docs/nsIXMLHttpRequest" title="XMLHttpRequest">XMLHttpRequest</a> to populate the page dynamically.</p> 
</div> 
<table class="fullwidth-table"> 
 <tbody> 
  <tr> 
   <td rowspan="2">Support</td> 
   <td>Gecko</td> 
   <td>Presto</td> 
   <td>WebKit</td> 
   <td>Trident</td> 
  </tr> 
  <tr> 
   <td>Not implemented</td> 
   <td>Not implemented</td> 
   <td>Not implemented</td> 
   <td>IE4, IE5, IE6, IE7 (Removed in IE8)</td> 
  </tr> 
  <tr> 
   <td>Normative document</td> 
   <td colspan="4"><a href="http://msdn.microsoft.com/en-us/library/ms533709(VS.85).aspx" class="external" title="http://msdn.microsoft.com/en-us/library/ms533709(VS.85).aspx">Microsoft's Data Binding: dataSrc Property (MSDN)</a></td> 
  </tr> 
 </tbody> 
</table>
   */
  def datasrc: scala.Option[String] = attributes.get("datasrc").asInstanceOf[scala.Option[String]]
  def datasrc(value: String): A = copy(attributes = attributes + ("datasrc" -> value))
  /**
   * The value of this attribute provides information about the functions that might be performed on an object. The values generally are given by the HTTP protocol when it is used, but it might (for similar reasons as for the title attribute) be useful to include advisory information in advance in the link. For example, the browser might choose a different rendering of a link as a function of the methods specified; something that is searchable might get a different icon, or an outside link might render with an indication of leaving the current site. This attribute is not well understood nor supported, even by the defining browser, Internet Explorer 4. 
<a href="http://msdn.microsoft.com/en-us/library/ms534168(VS.85).aspx" class="external">Methods Property (MSDN)</a>
   */
  def methods: scala.Option[String] = attributes.get("methods").asInstanceOf[scala.Option[String]]
  def methods(value: String): A = copy(attributes = attributes + ("methods" -> value))
  /**
   * This supposedly Microsoft-supported attribute relates a uniform resource name (URN) with the link. While it is based on standards work years back, the meaning of URNs is still not well defined, so this attribute is meaningless. 
<a href="http://msdn.microsoft.com/en-us/library/ms534710(VS.85).aspx" class="external">urn Property (MSDN)</a>
   */
  def urn: scala.Option[String] = attributes.get("urn").asInstanceOf[scala.Option[String]]
  def urn(value: String): A = copy(attributes = attributes + ("urn" -> value))
}
