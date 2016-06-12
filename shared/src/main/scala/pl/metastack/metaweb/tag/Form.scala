package pl.metastack.metaweb.tag

import pl.metastack.metaweb.tree

/**
 * The <strong>HTML <code>&lt;form&gt;</code> element</strong> represents a document section that contains interactive controls to submit information to a web server.
It is possible to use the <a href="/en-US/docs/Web/CSS/:valid" title="The :valid CSS pseudo-class represents any <input> or <form> element whose content validates correctly according to the input's type setting. This allows to easily make valid fields adopt an appearance that helps the user confirm that their data is formatted properly."><code>:valid</code></a> and <a href="/en-US/docs/Web/CSS/:invalid" title="The :invalid CSS pseudo-class represents any <input> or <form> element whose content fails to validate according to the input's type setting. This allows you to easily have invalid fields adopt an appearance that helps the user identify and correct errors."><code>:invalid</code></a> CSS pseudo-classes to style a <code>&lt;form&gt;</code> element.
 */
case class Form(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[tree.Node] = Seq.empty) extends HTMLTag[Form] {
  override def tagName = "form"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[tree.Node] = children): Form = Form(attributes, children)
  /**
   * A comma-separated list of content types that the server accepts. 
<div class="note">
 <strong>Usage note:</strong> This attribute has been removed in HTML5 and should no longer be used. Instead, use the
 <span class="st"> <code><a href="/en-US/docs/Web/HTML/Element/input#attr-accept">accept</a></code></span> attribute of the specific 
 <a href="/en-US/docs/Web/HTML/Element/input" title="The HTML <input> element is used to create interactive controls for web-based forms in order to accept data from the user. The semantics of an <input> varies considerably depending on the value of its type attribute."><code>&lt;input&gt;</code></a> element.
</div>
   */
  def accept: scala.Option[String] = attributes.get("accept").asInstanceOf[scala.Option[String]]
  def accept(value: String): Form = copy(attributes = attributes + ("accept" -> value.toString)).asInstanceOf[Form]
  /**
   * A space- or comma-delimited list of character encodings that the server accepts. The browser uses them in the order in which they are listed. The default value, the reserved string "UNKNOWN", indicates the same encoding as that of the document containing the form element.
<br> In previous versions of HTML, the different character encodings could be delimited by spaces or commas. In HTML5, only spaces are allowed as delimiters.
   */
  def `accept-charset`: scala.Option[String] = attributes.get("accept-charset").asInstanceOf[scala.Option[String]]
  def `accept-charset`(value: String): Form = copy(attributes = attributes + ("accept-charset" -> value.toString)).asInstanceOf[Form]
  /**
   * The URI of a program that processes the form information. This value can be overridden by a 
<code><a href="/en-US/docs/Web/HTML/Element/button#attr-formaction">formaction</a></code> attribute on a 
<a href="/en-US/docs/Web/HTML/Element/button" title="The HTML <button> Element represents a clickable button."><code>&lt;button&gt;</code></a> or 
<a href="/en-US/docs/Web/HTML/Element/input" title="The HTML <input> element is used to create interactive controls for web-based forms in order to accept data from the user. The semantics of an <input> varies considerably depending on the value of its type attribute."><code>&lt;input&gt;</code></a> element.
   */
  def action: scala.Option[String] = attributes.get("action").asInstanceOf[scala.Option[String]]
  def action(value: String): Form = copy(attributes = attributes + ("action" -> value.toString)).asInstanceOf[Form]
  /**
   * This is a nonstandard attribute used by iOS Safari Mobile which controls whether and how the text value for textual form control descendants should be automatically capitalized as it is entered/edited by the user. If the 
<code>autocapitalize</code> attribute is specified on an individual form control descendant, it trumps the form-wide 
<code>autocapitalize</code> setting. The non-deprecated values are available in iOS 5 and later. The default value is 
<code>sentences</code>. Possible values are: 
<ul> 
 <li><code>none</code>: Completely disables automatic capitalization</li> 
 <li><code>sentences</code>: Automatically capitalize the first letter of sentences.</li> 
 <li><code>words</code>: Automatically capitalize the first letter of words.</li> 
 <li><code>characters</code>: Automatically capitalize all characters.</li> 
 <li><code>on</code>: <span title="This deprecated API should no longer be used, but will probably still work."><i class="icon-thumbs-down-alt"> </i></span> Deprecated since iOS 5.</li> 
 <li><code>off</code>: <span title="This deprecated API should no longer be used, but will probably still work."><i class="icon-thumbs-down-alt"> </i></span> Deprecated since iOS 5.</li> 
</ul>
   */
  def autocapitalize: scala.Option[String] = attributes.get("autocapitalize").asInstanceOf[scala.Option[String]]
  def autocapitalize(value: String): Form = copy(attributes = attributes + ("autocapitalize" -> value.toString)).asInstanceOf[Form]
  /**
   * Indicates whether input elements can by default have their values automatically completed by the browser. This setting can be overridden by an 
<code>autocomplete</code> attribute on an element belonging to the form. Possible values are: 
<ul> 
 <li><code>off</code>: The user must explicitly enter a value into each field for every use, or the document provides its own auto-completion method; the browser does not automatically complete entries.</li> 
 <li><code>on</code>: The browser can automatically complete values based on values that the user has previously entered in the form.</li> 
</ul> For most modern browsers (including Firefox 38+, Google Chrome 34+, IE 11+) setting the autocomplete attribute will not prevent a browser's password manager from asking the user if they want to store login (username and password) fields and, if they agree, from autofilling the login the next time the user visits the page. See 
<a href="/en-US/docs/Web/Security/Securing_your_site/Turning_off_form_autocompletion#The_autocomplete_attribute_and_login_fields">The autocomplete attribute and login fields</a>.
   */
  def autocomplete: scala.Option[String] = attributes.get("autocomplete").asInstanceOf[scala.Option[String]]
  def autocomplete(value: String): Form = copy(attributes = attributes + ("autocomplete" -> value.toString)).asInstanceOf[Form]
  /**
   * When the value of the 
<code>method</code> attribute is 
<code>post</code>, enctype is the 
<a class="external" href="http://en.wikipedia.org/wiki/Mime_type" title="http://en.wikipedia.org/wiki/Mime_type">MIME type</a> of content that is used to submit the form to the server. Possible values are: 
<ul> 
 <li><code>application/x-www-form-urlencoded</code>: The default value if the attribute is not specified.</li> 
 <li><code>multipart/form-data</code>: The value used for an <a href="/en-US/docs/Web/HTML/Element/input" title="The HTML <input> element is used to create interactive controls for web-based forms in order to accept data from the user. The semantics of an <input> varies considerably depending on the value of its type attribute."><code>&lt;input&gt;</code></a> element with the <code>type</code> attribute set to "file".</li> 
 <li><code>text/plain (HTML5)</code></li> 
</ul> 
<p>This value can be overridden by a <code><a href="/en-US/docs/Web/HTML/Element/button#attr-formenctype">formenctype</a></code> attribute on a <a href="/en-US/docs/Web/HTML/Element/button" title="The HTML <button> Element represents a clickable button."><code>&lt;button&gt;</code></a> or <a href="/en-US/docs/Web/HTML/Element/input" title="The HTML <input> element is used to create interactive controls for web-based forms in order to accept data from the user. The semantics of an <input> varies considerably depending on the value of its type attribute."><code>&lt;input&gt;</code></a> element.</p>
   */
  def enctype: scala.Option[String] = attributes.get("enctype").asInstanceOf[scala.Option[String]]
  def enctype(value: String): Form = copy(attributes = attributes + ("enctype" -> value.toString)).asInstanceOf[Form]
  /**
   * The 
<a href="/en-US/docs/HTTP" title="http://www.w3.org/Protocols/rfc2616/rfc2616.html">HTTP</a> method that the browser uses to submit the form. Possible values are: 
<ul> 
 <li><code>post</code>: Corresponds to the HTTP <a class="external" href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec9.html#sec9.5" title="http://www.w3.org/Protocols/rfc2616/rfc2616-sec9.html#sec9.5">POST method</a> ; form data are included in the body of the form and sent to the server.</li> 
 <li><code>get</code>: Corresponds to the HTTP <a class="external" href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec9.html#sec9.3" title="http://www.w3.org/Protocols/rfc2616/rfc2616-sec9.html#sec9.3">GET method</a>; form data are appended to the <code>action</code> attribute URI with a '?' as separator, and the resulting URI is sent to the server. Use this method when the form has no side-effects and contains only ASCII characters.</li> 
</ul> 
<p>This value can be overridden by a <code><a href="/en-US/docs/Web/HTML/Element/button#attr-formmethod">formmethod</a></code> attribute on a <a href="/en-US/docs/Web/HTML/Element/button" title="The HTML <button> Element represents a clickable button."><code>&lt;button&gt;</code></a> or <a href="/en-US/docs/Web/HTML/Element/input" title="The HTML <input> element is used to create interactive controls for web-based forms in order to accept data from the user. The semantics of an <input> varies considerably depending on the value of its type attribute."><code>&lt;input&gt;</code></a> element.</p>
   */
  def method: scala.Option[String] = attributes.get("method").asInstanceOf[scala.Option[String]]
  def method(value: String): Form = copy(attributes = attributes + ("method" -> value.toString)).asInstanceOf[Form]
  /**
   * The name of the form. In HTML 4,its use is deprecated (
<code>id</code> should be used instead). It must be unique among the forms in a document and not just an empty string in HTML 5.
   */
  def name: scala.Option[String] = attributes.get("name").asInstanceOf[scala.Option[String]]
  def name(value: String): Form = copy(attributes = attributes + ("name" -> value.toString)).asInstanceOf[Form]
  /**
   * This Boolean attribute indicates that the form is not to be validated when submitted. If this attribute is not specified (and therefore the form is validated), this default setting can be overridden by a 
<code><a href="/en-US/docs/Web/HTML/Element/button#attr-formnovalidate">formnovalidate</a></code> attribute on a 
<a href="/en-US/docs/Web/HTML/Element/button" title="The HTML <button> Element represents a clickable button."><code>&lt;button&gt;</code></a> or 
<a href="/en-US/docs/Web/HTML/Element/input" title="The HTML <input> element is used to create interactive controls for web-based forms in order to accept data from the user. The semantics of an <input> varies considerably depending on the value of its type attribute."><code>&lt;input&gt;</code></a> element belonging to the form.
   */
  def novalidate: scala.Option[String] = attributes.get("novalidate").asInstanceOf[scala.Option[String]]
  def novalidate(value: String): Form = copy(attributes = attributes + ("novalidate" -> value.toString)).asInstanceOf[Form]
  /**
   * A name or keyword indicating where to display the response that is received after submitting the form. In HTML 4, this is the name/keyword for a frame. In HTML5, it is a name/keyword for a 
<em>browsing context</em> (for example, tab, window, or inline frame). The following keywords have special meanings: 
<ul> 
 <li><code>_self</code>: Load the response into the same HTML 4 frame (or HTML5 browsing context) as the current one. This value is the default if the attribute is not specified.</li> 
 <li><code>_blank</code>: Load the response into a new unnamed HTML 4 window or HTML5 browsing context.</li> 
 <li><code>_parent</code>: Load the response into the HTML 4 frameset parent of the current frame, or HTML5 parent browsing context of the current one. If there is no parent, this option behaves the same way as <code>_self</code>.</li> 
 <li><code>_top</code>: HTML 4: Load the response into the full original window, and cancel all other frames. HTML5: Load the response into the top-level browsing context (i.e., the browsing context that is an ancestor of the current one, and has no parent). If there is no parent, this option behaves the same way as <code>_self</code>.</li> 
 <li><em>iframename</em>: The response is displayed in a named <a href="/en-US/docs/Web/HTML/Element/iframe" title="The&nbsp;HTML Inline Frame Element&nbsp;(<iframe>) represents a nested browsing context, effectively embedding another HTML page into the current page. In HTML 4.01, a document may contain a head and a body or a head and a frame-set, but not both a body and a frame-set. However, an <iframe> can be used within a normal document body. Each browsing context has its own session history and active document. The browsing context that contains the embedded content is called the parent browsing context. The top-level browsing context (which has no parent) is typically the browser window."><code>&lt;iframe&gt;</code></a>.</li> 
</ul> 
<p>HTML5: This value can be overridden by a <code><a href="/en-US/docs/Web/HTML/Element/button#attr-formtarget">formtarget</a></code> attribute on a <a href="/en-US/docs/Web/HTML/Element/button" title="The HTML <button> Element represents a clickable button."><code>&lt;button&gt;</code></a> or <a href="/en-US/docs/Web/HTML/Element/input" title="The HTML <input> element is used to create interactive controls for web-based forms in order to accept data from the user. The semantics of an <input> varies considerably depending on the value of its type attribute."><code>&lt;input&gt;</code></a> element.</p>
   */
  def target: scala.Option[String] = attributes.get("target").asInstanceOf[scala.Option[String]]
  def target(value: String): Form = copy(attributes = attributes + ("target" -> value.toString)).asInstanceOf[Form]
}
