package pine.tag

import pine._

/**
 * The <em><a href="/en-US/docs/Glossary/HTML" class="glossaryLink" title="HTML: HTML (HyperText Markup Language) is a descriptive language that specifies webpage structure.">HTML</a> Meta Element </em>(<strong>&lt;meta&gt;</strong>) represents any metadata information that cannot be represented by one of the other HTML meta-related elements (<a href="/en-US/docs/Web/HTML/Element/base" title="The HTML Base Element (<base>) specifies the base URL to use for all relative URLs contained within a document. There can be only one <base> element in a document."><code>&lt;base&gt;</code></a>, <a href="/en-US/docs/Web/HTML/Element/link" title="The HTML Link Element (<link>) specifies relationships between the current document and an external resource. Possible uses for this element include defining a relational framework for navigation. This Element is most used to link to style sheets."><code>&lt;link&gt;</code></a>, <a href="/en-US/docs/Web/HTML/Element/script" title="The HTML Script Element (<script>) is used to embed or reference an executable script within an HTML or XHTML document."><code>&lt;script&gt;</code></a>, <a href="/en-US/docs/Web/HTML/Element/style" title="The HTML Style Element (<style>) contains style information for a document, or part of a document. By default, the style instructions written inside that element are expected to be CSS."><code>&lt;style&gt;</code></a> or <a href="/en-US/docs/Web/HTML/Element/title" title="The HTML Title Element (<title>) defines the title of the document, shown in a browser's title bar or on the page's tab. It can only contain text and any contained tags are not interpreted."><code>&lt;title&gt;</code></a>).
Depending on the attributes set, the kind of metadata can be one of the following:
<li>If <code><a href="/en-US/docs/Web/HTML/Element/meta#attr-name">name</a></code> is set, it is&nbsp;<em>document-level</em> <em>metadata</em>, applying to the whole page.</li> 
<li>If <code><a href="/en-US/docs/Web/HTML/Element/meta#attr-http-equiv">http-equiv</a></code> is set, it is a&nbsp;<em>pragma directive</em>, i.e. information normally given by the web server about how the web page should be served.</li> 
<li>If <code><a href="/en-US/docs/Web/HTML/Element/meta#attr-charset">charset</a></code> is set, it is a&nbsp;<em>charset declaration</em>, i.e. the charset used for the serialized form of the webpage.&nbsp;<span class="inlineIndicator htmlVer htmlVerInline"><a href="/en-US/docs/HTML/HTML5">HTML5</a></span></li> 
<li>If <code><a href="/en-US/docs/Web/HTML/Element/meta#attr-itemprop">itemprop</a></code> is set, it is <em>user-defined metadata</em>, transparent for the user-agent as the semantics of the metadata is user-specific. <span class="spec-Living">Living Standard</span> <span class="inlineIndicator unimplemented unimplementedInline">Unimplemented</span></li>
 */
case class Meta(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[Node] = Seq.empty) extends HTMLTag {
  override type T = Meta
  override def tagName = "meta"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[Node] = children): Meta = Meta(attributes, children)
  /**
   * This attribute declares the character encoding used of the page. It can be locally overridden using the 
<strong>lang</strong> attribute on any element. This attribute is a literal string and must be one of the 
<em>preferred MIME name</em> for a character encoding as 
<a href="http://www.iana.org/assignments/character-sets" class="external" title="http://www.iana.org/assignments/character-sets">defined by the IANA</a>. Though the standard doesn't request a specific character encoding, it gives some recommendations: 
<ul> 
 <li>Authors are encouraged to use UTF-8.</li> 
 <li>Authors should not use ASCII-incompatible encodings (i.e. those that don't map the 8-bit code points 0x20 to 0x7E to the Unicode 0x0020 to 0x007E code points) as these represent a security risk: browsers not supporting them may interpret benign content as HTML&nbsp;Elements. This is the case of at least the following charsets: JIS_C6226-1983, JIS_X0212-1990, HZ-GB-2312, JOHAB, the ISO-2022 family, and the EBCDIC family.</li> 
 <li>Authors must not use CESU-8, UTF-7, BOCU-1 and SCSU, also falling in that category and not intended to be used on the web. Cross-scripting attacks with some of these encodings have been documented.</li> 
 <li>Authors should not use UTF-32 because not all HTML5 encoding algorithms can distinguish it from UTF-16.</li> 
</ul> 
<div class="note">
 <strong>Notes:</strong> 
 <ul> 
  <li>The declared character set must match the one of the page. There is no valid reason to declare an inaccurate character set.</li> 
  <li>This <a href="/en-US/docs/Web/HTML/Element/meta" title="The HTML Meta Element (<meta>) represents any metadata information that cannot be represented by one of the other HTML meta-related elements (<base>, <link>, <script>, <style> or <title>)."><code>&lt;meta&gt;</code></a> element must be inside the <a href="/en-US/docs/Web/HTML/Element/head" title="The HTML Head Element (<head>) provides general information (metadata) about the document, including its title and links to or definitions of scripts and style sheets"><code>&lt;head&gt;</code></a> element and <strong>within the 512 first bytes</strong> of the page, as some browsers only look at these first bytes before choosing a character set for the page.</li> 
  <li>This <a href="/en-US/docs/Web/HTML/Element/meta" title="The HTML Meta Element (<meta>) represents any metadata information that cannot be represented by one of the other HTML meta-related elements (<base>, <link>, <script>, <style> or <title>)."><code>&lt;meta&gt;</code></a> element is only a part of the <a href="http://www.whatwg.org/specs/web-apps/current-work/multipage/parsing.html#encoding-sniffing-algorithm" class="external" title="Algorithm charset page">algorithm to determine the character set</a> of a page that browsers apply. The HTTP&nbsp;Content-Type header and any BOM&nbsp;elements have precedence over this element.</li> 
  <li>It is good practice, and strongly recommended, to define the character set using this attribute. If no character set is defined for a page, several cross-scripting techniques may be able to harm the page user, such as the <a href="http://code.google.com/p/doctype-mirror/wiki/ArticleUtf7" class="external" title="http://code.google.com/p/doctype/wiki/ArticleUtf7">UTF-7&nbsp;fallback cross-scripting technique</a>. Always setting this meta will protect against these risks.</li> 
  <li>This <a href="/en-US/docs/Web/HTML/Element/meta" title="The HTML Meta Element (<meta>) represents any metadata information that cannot be represented by one of the other HTML meta-related elements (<base>, <link>, <script>, <style> or <title>)."><code>&lt;meta&gt;</code></a> element is a synonym for the pre-HTML5 <code>&lt;meta&nbsp;http-equiv="Content-Type" content="text/html;&nbsp;charset=<em>IANAcharset</em>"&gt; </code>where <em><code>IANAcharset</code> </em>corresponds of the value of the equivalent <code><a href="/en-US/docs/Web/HTML/Element/meta#attr-charset">charset</a></code> attribute. This syntax is still allowed, although obsolete and no more recommended.</li> 
 </ul> 
</div>
   */
  def charset: scala.Option[String] = attributes.get("charset").asInstanceOf[scala.Option[String]]
  def charset(value: String): Meta = copy(attributes = attributes + ("charset" -> value))
  /**
   * This attribute gives the value associated with the 
<code><a href="/en-US/docs/Web/HTML/Element/meta#attr-http-equiv">http-equiv</a></code> or 
<code><a href="/en-US/docs/Web/HTML/Element/meta#attr-name">name</a></code> attribute, depending of the context.
   */
  def content: scala.Option[String] = attributes.get("content").asInstanceOf[scala.Option[String]]
  def content(value: String): Meta = copy(attributes = attributes + ("content" -> value))
  /**
   * This enumerated attribute defines the pragma that can alter servers and user-agents behavior. The value of the pragma is defined using the 
<code><a href="/en-US/docs/Web/HTML/Element/meta#attr-content">content</a></code> and can be one of the following: 
<dl> 
 <dt>
  content-language 
  <span title="This is an obsolete API and is no longer guaranteed to work."><i class="icon-trash"> </i></span>
 </dt> 
 <dd>
  This pragma defines the default language of the page. 
  <div class="note">
   <strong>Usage note:</strong> do not use this pragma as it is obsolete. Use the global 
   <strong>lang</strong> attribute on the 
   <a href="/en-US/docs/Web/HTML/Element/body" title="The HTML Body Element (<body>) represents the content of an HTML&nbsp;document. There can be only one <body> element in a document."><code>&lt;body&gt;</code></a> element instead.
  </div> 
 </dd> 
 <dt>
  Content-Security-Policy
 </dt> 
 <dd>
  This attribute allows web site administrators to define 
  <a href="/en-US/docs/Web/Security/CSP/CSP_policy_directives">content policies</a> for served resources. With a few exceptions, policies mostly involve specifiying server origins and script endpoints. This helps guard against cross-site scripting attacks.
 </dd> 
 <dt>
  content-type 
  <span title="This is an obsolete API and is no longer guaranteed to work."><i class="icon-trash"> </i></span>
 </dt> 
 <dd>
  This attribute defines the 
  <a href="/en-US/docs/MIME" class="new" title="MIME">MIME type</a> of the document, eventually followed by its character set. It follows the same syntax as the HTTP 
  <code>content-type</code> entity-header field, but as it is inside an HTML Element, most values are not possible. Therefore the valid syntax for its content is the literal string '
  <code>text/html</code>' eventually followed by a character set with the following syntax:'
  <code>; charset=</code>
  <em><code>IANAcharset</code></em>' where 
  <code>IANAcharset</code> is the 
  <em>preferred MIME name</em> for a character set as 
  <a href="http://www.iana.org/assignments/character-sets" class="external" title="http://www.iana.org/assignments/character-sets">defined by the IANA.</a> 
  <div class="note">
   <strong>Usage note:</strong> 
   <ul> 
    <li>Do not use this pragma as it is obsolete. Use the <code><a href="/en-US/docs/Web/HTML/Element/meta#attr-charset">charset</a></code> attribute on the <a href="/en-US/docs/Web/HTML/Element/meta" title="The HTML Meta Element (<meta>) represents any metadata information that cannot be represented by one of the other HTML meta-related elements (<base>, <link>, <script>, <style> or <title>)."><code>&lt;meta&gt;</code></a> element instead.</li> 
    <li>As the <a href="/en-US/docs/Web/HTML/Element/meta" title="The HTML Meta Element (<meta>) represents any metadata information that cannot be represented by one of the other HTML meta-related elements (<base>, <link>, <script>, <style> or <title>)."><code>&lt;meta&gt;</code></a> may not be used to change the type of a document in an XHTML document, or in an HTML5 document following the XHTML syntax, never set MIME&nbsp;type to an XHTML MIME type that way. It would be incorrect.</li> 
    <li>Only an HTML document can use the content-type, so most of it is redundant: that's why it has been obsoleted and replaced by the <code><a href="/en-US/docs/Web/HTML/Element/meta#attr-charset">charset</a></code> attribute.</li> 
   </ul> 
  </div> 
 </dd> 
 <dt>
  default-style
 </dt> 
 <dd>
  This pragma specifies the preferred stylesheet to be used on the page. The 
  <code><a href="/en-US/docs/Web/HTML/Element/meta#attr-content">content</a></code> attribute must contain the 
  <strong>title</strong>&nbsp;of a 
  <a href="/en-US/docs/Web/HTML/Element/link" title="The HTML Link Element (<link>) specifies relationships between the current document and an external resource. Possible uses for this element include defining a relational framework for navigation. This Element is most used to link to style sheets."><code>&lt;link&gt;</code></a> element whose 
  <code><a href="/en-US/docs/Web/HTML/Element/link#attr-href">href</a></code> attribute links to a CSS stylesheet, or the 
  <strong>title</strong>&nbsp;of a 
  <a href="/en-US/docs/Web/HTML/Element/style" title="The HTML Style Element (<style>) contains style information for a document, or part of a document. By default, the style instructions written inside that element are expected to be CSS."><code>&lt;style&gt;</code></a> element which contains a 
  <a href="/en-US/docs/CSS" title="CSS">CSS</a> stylesheet.
 </dd> 
 <dt>
  refresh
 </dt> 
 <dd>
  This pragma specifies: 
  <ul> 
   <li>the number of seconds until the page should be reloaded, if the <code><a href="/en-US/docs/Web/HTML/Element/meta#attr-content">content</a></code> attribute contains only a positive integer number;</li> 
   <li>the number of seconds until the page should be redirected to another, if the <code><a href="/en-US/docs/Web/HTML/Element/meta#attr-content">content</a></code> attribute contains a positive integer number followed by the string '<code>;url=</code>' and a valid URL.</li> 
  </ul> 
 </dd> 
 <dt>
  set-cookie 
  <span title="This is an obsolete API and is no longer guaranteed to work."><i class="icon-trash"> </i></span>
 </dt> 
 <dd>
  This pragma defines a 
  <a href="/en-US/docs/cookie" class="new" title="cookie">cookie</a> for the page. Its content must follows the syntax defines in the 
  <a href="http://tools.ietf.org/html/draft-ietf-httpstate-cookie-14" class="external" title="http://tools.ietf.org/html/draft-ietf-httpstate-cookie-14">IETF HTTP Cookie Specification</a>. 
  <div class="note">
   <strong>Note:</strong> Do not use this pragma as it is obsolete. Use the HTTP header set-cookie instead.
  </div> 
 </dd> 
</dl>
   */
  def `http-equiv`: scala.Option[String] = attributes.get("http-equiv").asInstanceOf[scala.Option[String]]
  def `http-equiv`(value: String): Meta = copy(attributes = attributes + ("http-equiv" -> value))
  /**
   * This attribute defines the name of document-level metadata. It should not be set if one of the attributes 
<code><a href="/en-US/docs/Web/HTML/Element/meta#attr-itemprop">itemprop</a></code>, 
<code><a href="/en-US/docs/Web/HTML/Element/meta#attr-http-equiv">http-equiv</a></code> or 
<code><a href="/en-US/docs/Web/HTML/Element/meta#attr-charset">charset</a></code> is also set.
<br> This document-level metadata name is associated with a value, contained by the 
<code><a href="/en-US/docs/Web/HTML/Element/meta#attr-content">content</a></code> attribute. The possible values for the name element are, with their associated value, stored via the 
<code><a href="/en-US/docs/Web/HTML/Element/meta#attr-content">content</a></code> attribute: 
<ul> 
 <li><code>application-name</code>, defining the name of the web application running in the webpage; 
  <div class="note">
   <strong>Note:</strong> 
   <ul> 
    <li>Browsers may use this to identify the application. It is different from the <a href="/en-US/docs/Web/HTML/Element/title" title="The HTML Title Element (<title>) defines the title of the document, shown in a browser's title bar or on the page's tab. It can only contain text and any contained tags are not interpreted."><code>&lt;title&gt;</code></a> element, which usually consist of the application name but may also contain specific information like the document name or a status;</li> 
    <li>Simple webpages shouldn't define the application-name meta.</li> 
   </ul> 
  </div> </li> 
 <li><code>author</code>, defining, in a free format, the name of the author of the document;</li> 
 <li><code>description</code>, containing a short and accurate summary of the content of the page. Several browsers, among them Firefox and Opera, use this meta as the default description of the page when bookmarked;</li> 
 <li><code>generator</code>, containing, in a free format, the identifier to the software that generated the page;</li> 
 <li><code>keywords</code>, containing, as strings separated by commas, relevant words associated with the content of the page;</li> 
 <li><code>referrer</code> <span title="This is an experimental API that should not be used in production code."><i class="icon-beaker"> </i></span> controlling the content of the HTTP <code>Referer</code> HTTP header attached to any request sent from this document: 
  <table class="standard-table"> 
   <caption>
    Values for the content of &lt;meta name="referrer"&gt;
   </caption> 
   <thead> 
   </thead> 
   <tbody> 
    <tr> 
     <td><code>no-referrer</code></td> 
     <td>Do not send a HTTP <code>Referer</code> header.</td> 
    </tr> 
    <tr> 
     <td><code>origin</code></td> 
     <td>Send the <a href="/en-US/docs/Glossary/Origin">origin</a> of the document.</td> 
    </tr> 
    <tr> 
     <td><code>no-referrer-when-downgrade</code></td> 
     <td>Send the <a href="/en-US/docs/Glossary/Origin">origin</a> as referrer to a-priori as-much-secure destination (https-&gt;https), but doesn't send a referrer to a less secure destination (https-&gt;http). This is the default behavior.</td> 
    </tr> 
    <tr> 
     <td><code>origin-when-crossorigin</code></td> 
     <td>Send a full URL (stripped from parameters) when performing a same-origin request, but only send the <a href="/en-US/docs/Glossary/Origin">origin</a> of the document for other cases.</td> 
    </tr> 
    <tr> 
     <td><code>unsafe-URL</code></td> 
     <td>Send a full URL (stripped from parameters) when perfoming a same-origin request.</td> 
    </tr> 
   </tbody> 
  </table> 
  <div class="note"> 
   <div class="notes">
    <strong>Note:</strong> Dynamically inserting 
    <code>&lt;meta name="referrer"&gt;</code> (by document.write or appendChild) create a non-determinism when it comes to sending referrers or not. Note also that when several conflicting policies are defined, the No-referrer policy is applied.
   </div> 
  </div> </li> 
</ul> 
<p>The attribute may also have a value taken from the extended list defined on <a href="http://wiki.whatwg.org/wiki/MetaExtensions" class="external" title="http://wiki.whatwg.org/wiki/MetaExtensions">WHATWG Wiki MetaExtensions page</a>. Although none has been formally accepted yet, a few commonly used names are among the proposals:</p> 
<ul> 
 <li><code>creator</code>, defining, in a free format, the name of the creator of the document. Note that it can be the name of the institution. If there are more than one, several <a href="/en-US/docs/Web/HTML/Element/meta" title="The HTML Meta Element (<meta>) represents any metadata information that cannot be represented by one of the other HTML meta-related elements (<base>, <link>, <script>, <style> or <title>)."><code>&lt;meta&gt;</code></a> elements should be used;</li> 
 <li><code>googlebot</code>, which is a synonym of <code>robots</code>, but is only followed by Googlebot, the indexing crawler for Google;</li> 
 <li><code>publisher</code>, defining, in a free format, the name of the publisher of the document. Note that it can be the name of the institution;</li> 
 <li><code>robots</code>, defining the behavior that cooperative crawlers should have with the page. It is a comma-separated list of values taken in the following list: 
  <table class="standard-table"> 
   <caption>
    Values for the content of &lt;meta name="robots"&gt;
   </caption> 
   <thead> 
    <tr> 
     <th scope="col">Value</th> 
     <th scope="col">Description</th> 
     <th scope="col">Used by</th> 
    </tr> 
   </thead> 
   <tbody> 
    <tr> 
     <td><code>index</code></td> 
     <td>Allows the robot to index the page</td> 
     <td>All</td> 
    </tr> 
    <tr> 
     <td><code>noindex</code></td> 
     <td>Prevents the robot from indexing the page</td> 
     <td>All</td> 
    </tr> 
    <tr> 
     <td><code>follow</code></td> 
     <td>Allows the robot to follow the links on the page</td> 
     <td>All</td> 
    </tr> 
    <tr> 
     <td><code>nofollow</code></td> 
     <td>Prevents the robot from following the links on the page</td> 
     <td>All</td> 
    </tr> 
    <tr> 
     <td><code>noodp</code></td> 
     <td>Prevents the usage of the <a href="http://www.dmoz.org/" class="external" title="http://www.dmoz.org/">Open Directory Project</a> description, if any, as the description of the page in the search engine results page</td> 
     <td> <p><a href="http://www.google.com/support/webmasters/bin/answer.py?hl=en&amp;answer=79812" class="external" title="http://www.google.com/support/webmasters/bin/answer.py?hl=en&amp;answer=79812">Google</a>, <a href="http://help.yahoo.com/l/us/yahoo/search/indexing/indexing-11.html;_ylt=Arh3LHnisvRMPJKzQqmJ97JYqCN4" class="external" title="http://help.yahoo.com/l/us/yahoo/search/indexing/indexing-11.html;_ylt=Arh3LHnisvRMPJKzQqmJ97JYqCN4">Yahoo</a>, <a href="http://www.bing.com/toolbox/blogs/webmaster/archive/2008/06/03/robots-exclusion-protocol-joining-together-to-provide-better-documentation.aspx" class="external" title="http://www.bing.com/toolbox/blogs/webmaster/archive/2008/06/03/robots-exclusion-protocol-joining-together-to-provide-better-documentation.aspx">Bing</a></p> </td> 
    </tr> 
    <tr> 
     <td><code>noarchive</code></td> 
     <td>Prevents the search engine from caching the content of the page</td> 
     <td><a href="http://www.google.com/support/webmasters/bin/answer.py?hl=en&amp;answer=79812" class="external" title="http://www.google.com/support/webmasters/bin/answer.py?hl=en&amp;answer=79812">Google</a>, <a href="http://help.yahoo.com/l/us/yahoo/search/indexing/basics-10.html;_ylt=Aszma_Ly8TfhL7mn_LGWn5RYqCN4" class="external" title="http://help.yahoo.com/l/us/yahoo/search/indexing/basics-10.html;_ylt=Aszma_Ly8TfhL7mn_LGWn5RYqCN4">Yahoo</a></td> 
    </tr> 
    <tr> 
     <td><code>nosnippet</code></td> 
     <td>Prevents the display of any description of the page in the search engine results page</td> 
     <td><a href="http://www.google.com/support/webmasters/bin/answer.py?answer=35304" class="external" title="http://www.google.com/support/webmasters/bin/answer.py?answer=35304">Google</a></td> 
    </tr> 
    <tr> 
     <td><code>noimageindex</code></td> 
     <td>Prevents this page from appearing as the referring page of an indexed image</td> 
     <td><a href="http://www.google.com/support/webmasters/bin/answer.py?hl=en&amp;answer=79812" class="external" title="http://www.google.com/support/webmasters/bin/answer.py?hl=en&amp;answer=79812">Google</a></td> 
    </tr> 
    <tr> 
     <td><code>noydir</code></td> 
     <td>Prevents the usage of the Yahoo Directory description, if any, as the description of the page in the search engine results page</td> 
     <td><a href="http://help.yahoo.com/l/us/yahoo/search/indexing/indexing-11.html;_ylt=Arh3LHnisvRMPJKzQqmJ97JYqCN4" class="external" title="http://help.yahoo.com/l/us/yahoo/search/indexing/indexing-11.html;_ylt=Arh3LHnisvRMPJKzQqmJ97JYqCN4">Yahoo</a></td> 
    </tr> 
    <tr> 
     <td><code>nocache</code></td> 
     <td>Synonym of <code>noarchive</code></td> 
     <td><a href="http://www.bing.com/toolbox/blogs/webmaster/archive/2008/06/03/robots-exclusion-protocol-joining-together-to-provide-better-documentation.aspx" class="external" title="http://www.bing.com/toolbox/blogs/webmaster/archive/2008/06/03/robots-exclusion-protocol-joining-together-to-provide-better-documentation.aspx">Bing</a></td> 
    </tr> 
   </tbody> 
  </table> 
  <div class="note">
   <strong>Notes:</strong> 
   <ul> 
    <li>Only cooperative robots will follow the rules defined by the robots name. Do not expect to keep e-mail harvesters at bay with this.</li> 
    <li>The robot still needs to access the page in order to read the meta value. If you want to keep them at bay, for example to prevent bandwidth consumption, use a <em><a href="/en-US/docs/Robot_Exclusion_Protocol" class="new" title="Robot Exclusion Protocol">robots.txt</a></em> file instead (or in complement).</li> 
    <li>If you want to remove the page of an index, changing the meta to <code>noindex</code> will work, but only when the robot visit the page again. Be sure not to prevent such visits, via the <em>robots.txt</em> file for example. Some search engines have developers tools, allowing a quick removal of some page.</li> 
    <li>Some possible values are mutually exclusive, like using <code>index</code> and <code>noindex</code>, or <code>follow</code> and <code>nofollow</code>, at the same time. In these cases the behavior of the robot is undefined, and may vary from one to the other. So avoid these cases.</li> 
    <li>Some search engine crawler robots, like those of Google, Yahoo Search or Bing, support the same values on an HTTP directive, <code>X-Robot-Tags</code>: this allows them to use these pragma on non-HTML documents, like images.</li> 
   </ul> 
  </div> </li> 
 <li><code>slurp</code>, which is a synonym of <code>robots</code>, but is only followed by Slurp, the indexing crawler for Yahoo Search;</li> 
</ul> 
<p>Finally a few names are in common use, though not in progress of being standardized:</p> 
<ul> 
 <li><code>viewport</code>, which gives hints about the size of the initial size of the <a href="https://developer.mozilla.org/en-US/docs/Glossary/Viewport" title="viewport">viewport</a>. This pragma is used by several mobile devices only. 
  <table class="fullwidth-table"> 
   <caption>
    Values for the content of 
    <code>&lt;meta name="viewport"&gt;</code>
   </caption> 
   <thead> 
    <tr> 
     <th scope="col">Value</th> 
     <th scope="col">Possible values</th> 
     <th scope="col">Description</th> 
    </tr> 
   </thead> 
   <tbody> 
    <tr> 
     <td><code>width</code></td> 
     <td>a positive integer number or the literal <code>device-width</code></td> 
     <td>defines the width, in pixels, of the viewport</td> 
    </tr> 
    <tr> 
     <td><code>height</code></td> 
     <td>a positive integer number of the literal <code>device-height</code></td> 
     <td>defines the height, in pixels, of the viewport</td> 
    </tr> 
    <tr> 
     <td><code>initial-scale</code></td> 
     <td>a positive number between <code>0.0</code> and <code>10.0</code></td> 
     <td>defines the ratio between the device width (<code>device-width</code> in portrait mode or <code>device-height</code> in landscape mode) and the viewport size.</td> 
    </tr> 
    <tr> 
     <td><code>maximum-scale</code></td> 
     <td>a positive number between <code>0.0</code> and <code>10.0</code></td> 
     <td>defines the maximum value of the zoom; it must be greater or equal to the <code>minimum-scale</code> or the behavior is indeterminate.</td> 
    </tr> 
    <tr> 
     <td><code>minimum-scale</code></td> 
     <td>a positive number between <code>0.0</code> and <code>10.0</code></td> 
     <td>defines the minimum value of the zoom; it must be smaller or equal to the <code>maximum-scale</code> or the behavior is indeterminate.</td> 
    </tr> 
    <tr> 
     <td><code>user-scalable</code></td> 
     <td>a boolean value (<code>yes</code> or <code>no</code>)</td> 
     <td>If set to <code>no</code>, the user is not able to zoom in the webpage. Default value is <code>yes</code>.</td> 
    </tr> 
   </tbody> 
  </table> 
  <table class="standard-table"> 
   <thead> 
    <tr> 
     <th scope="col">Specification</th> 
     <th scope="col">Status</th> 
     <th scope="col">Comment</th> 
    </tr> 
   </thead> 
   <tbody> 
    <tr> 
     <td><a href="http://dev.w3.org/csswg/css-device-adapt/#viewport-meta" class="external" lang="en" hreflang="en">CSS Device Adaptation<br><small lang="en-US">The definition of '&lt;meta name="viewport"&gt;' in that specification.</small></a></td> 
     <td><span class="spec-WD">Working Draft</span></td> 
     <td>Non-normatively describes the Viewport META element</td> 
    </tr> 
   </tbody> 
  </table> 
  <div>
   See also: 
   <a href="/en-US/docs/Web/CSS/@viewport" title="The @viewport CSS at-rule contains a set of nested descriptors in a CSS block that is delimited by curly braces. These descriptors control viewport settings, primarily on mobile devices."><code>@viewport</code></a>
  </div> 
  <div class="note">
   <strong>Notes:</strong> 
   <ul> 
    <li>Though not standardized, this attribute is used by different mobile browsers like Safari Mobile, Firefox for Mobile or Opera Mobile.</li> 
    <li>The default values may change from one device, and browser, to another.</li> 
    <li>To learn about this pragma in Firefox for Mobile, see <a href="/en-US/docs/Mobile/Viewport_meta_tag" title="Mobile/Viewport meta tag">this article</a>.</li> 
   </ul> 
  </div> </li> 
</ul>
   */
  def name: scala.Option[String] = attributes.get("name").asInstanceOf[scala.Option[String]]
  def name(value: String): Meta = copy(attributes = attributes + ("name" -> value))
  /**
   * This attribute defines the scheme in which the metadata is described. A scheme is a context leading to the correct interpretations of the 
<code><a href="/en-US/docs/Web/HTML/Element/meta#attr-content">content</a></code> value, like a format. 
<div class="note">
 <strong>Notes:</strong> Do not use this attribute as it is obsolete. There is no replacement for it as there was no real usage for it. Omit it altogether.
</div>
   */
  def scheme: scala.Option[String] = attributes.get("scheme").asInstanceOf[scala.Option[String]]
  def scheme(value: String): Meta = copy(attributes = attributes + ("scheme" -> value))
}
