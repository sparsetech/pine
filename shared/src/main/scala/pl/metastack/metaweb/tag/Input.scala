package pl.metastack.metaweb.tag

import pl.metastack.metarx._
import pl.metastack.metaweb.state

/**
 * The HTML <strong><code>&lt;input&gt;</code> element</strong> is used to create interactive controls for web-based forms in order to accept data from the user. How an <code>&lt;input&gt;</code> works varies considerably depending on the value of its <code>type</code> attribute.
 */
class Input extends state.Tag("input") with HTMLTag {
  /**
   * The type of control to display. The default type is text, if this attribute is not specified. Possible values are: 
<ul> 
 <li><code>button</code>: A push button with no default behavior.</li> 
 <li><code>checkbox</code>: A check box. You must use the <strong>value</strong> attribute to define the value submitted by this item. Use the <strong>checked</strong> attribute to indicate whether this item is selected. You can also use the <strong>indeterminate</strong> attribute to indicate that the checkbox is in an indeterminate state (on most platforms, this draws a horizontal line across the checkbox).</li> 
 <li><code>color</code>: <span class="inlineIndicator htmlVer htmlVerInline"><a href="/en-US/docs/HTML/HTML5">HTML5</a></span> A control for specifying a color. A color picker's UI has no required features other than accepting simple colors as text (<a href="http://www.w3.org/TR/html5/forms.html#color-state-(type=color)" class="external">more info</a>).</li> 
 <li><code>date</code>: <span class="inlineIndicator htmlVer htmlVerInline"><a href="/en-US/docs/HTML/HTML5">HTML5</a></span> A control for entering a date (year, month, and day, with no time).</li> 
 <li><code>datetime</code>: <span class="inlineIndicator htmlVer htmlVerInline"><a href="/en-US/docs/HTML/HTML5">HTML5</a></span> A control for entering a date and time (hour, minute, second, and fraction of a second) based on UTC time zone.</li> 
 <li><code>datetime-local</code>: <span class="inlineIndicator htmlVer htmlVerInline"><a href="/en-US/docs/HTML/HTML5">HTML5</a></span> A control for entering a date and time, with no time zone.</li> 
 <li><code>email</code>: <span class="inlineIndicator htmlVer htmlVerInline"><a href="/en-US/docs/HTML/HTML5">HTML5</a></span> A field for editing an e-mail address. The input value is validated to contain either the empty string or a single valid e-mail address before submitting. The <a href="/en-US/docs/Web/CSS/:valid" title="The :valid CSS pseudo-class represents any <input> or <form> element whose content validates correctly according to the input's type setting. This allows to easily make valid fields adopt an appearance that helps the user confirm that their data is formatted properly."><code>:valid</code></a> and <a href="/en-US/docs/Web/CSS/:invalid" title="The :invalid CSS pseudo-class represents any <input> or <form> element whose content fails to validate according to the input's type setting. This allows you to easily have invalid fields adopt an appearance that helps the user identify and correct errors."><code>:invalid</code></a> CSS pseudo-classes are applied as appropriate.</li> 
 <li><code>file</code>: A control that lets the user select a file. Use the <strong>accept</strong> attribute to define the types of files that the control can select.</li> 
 <li><code>hidden</code>: A control that is not displayed, but whose value is submitted to the server.</li> 
 <li><code>image</code>: A graphical submit button. You must use the <strong>src</strong> attribute to define the source of the image and the <strong>alt</strong> attribute to define alternative text. You can use the <strong>height</strong> and <strong>width</strong> attributes to define the size of the image in pixels.</li> 
 <li><code>month</code>: <span class="inlineIndicator htmlVer htmlVerInline"><a href="/en-US/docs/HTML/HTML5">HTML5</a></span> A control for entering a month and year, with no time zone.</li> 
 <li><code>number</code>: <span class="inlineIndicator htmlVer htmlVerInline"><a href="/en-US/docs/HTML/HTML5">HTML5</a></span> A control for entering a floating point number.</li> 
 <li><code>password</code>: A single-line text field whose value is obscured. Use the <strong>maxlength</strong> attribute to specify the maximum length of the value that can be entered.</li> 
 <li><code>radio</code>: A radio button. You must use the <strong>value</strong> attribute to define the value submitted by this item. Use the <strong>checked</strong> attribute to indicate whether this item is selected by default. Radio buttons that have the same value for the <strong>name</strong> attribute are in the same "radio button group"; only one radio button in a group can be selected at a time.</li> 
 <li><code>range</code>: <span class="inlineIndicator htmlVer htmlVerInline"><a href="/en-US/docs/HTML/HTML5">HTML5</a></span> A control for entering a number whose exact value is not important. This type control uses the following default values if the corresponding attributes are not specified: 
  <ul> 
   <li><code>min</code>: 0</li> 
   <li><code>max</code>: 100</li> 
   <li><code>value</code>: <code>min</code> + (<code>max</code>-<code>min</code>)/2, or <code>min</code> if <code>max</code> is less than <code>min</code></li> 
   <li><code>step</code>: 1</li> 
  </ul> </li> 
 <li><code>reset</code>: A button that resets the contents of the form to default values.</li> 
 <li><code>search</code>: <span class="inlineIndicator htmlVer htmlVerInline"><a href="/en-US/docs/HTML/HTML5">HTML5</a></span> A single-line text field for entering search strings; line-breaks are automatically removed from the input value.</li> 
 <li><code>submit</code>: A button that submits the form.</li> 
 <li><code>tel</code>: <span class="inlineIndicator htmlVer htmlVerInline"><a href="/en-US/docs/HTML/HTML5">HTML5</a></span> A control for entering a telephone number; line-breaks are automatically removed from the input value, but no other syntax is enforced. You can use attributes such as <strong>pattern</strong> and <strong>maxlength</strong> to restrict values entered in the control. The <a href="/en-US/docs/Web/CSS/:valid" title="The :valid CSS pseudo-class represents any <input> or <form> element whose content validates correctly according to the input's type setting. This allows to easily make valid fields adopt an appearance that helps the user confirm that their data is formatted properly."><code>:valid</code></a> and <a href="/en-US/docs/Web/CSS/:invalid" title="The :invalid CSS pseudo-class represents any <input> or <form> element whose content fails to validate according to the input's type setting. This allows you to easily have invalid fields adopt an appearance that helps the user identify and correct errors."><code>:invalid</code></a> CSS pseudo-classes are applied as appropriate.</li> 
 <li><code>text</code>: A single-line text field; line-breaks are automatically removed from the input value.</li> 
 <li><code>time</code>: <span class="inlineIndicator htmlVer htmlVerInline"><a href="/en-US/docs/HTML/HTML5">HTML5</a></span> A control for entering a time value with no time zone.</li> 
 <li><code>url</code>: <span class="inlineIndicator htmlVer htmlVerInline"><a href="/en-US/docs/HTML/HTML5">HTML5</a></span> A field for editing a URL. The input value is validated to contain either the empty string or a valid absolute URL before submitting. Line-breaks and leading or trailing whitespace are automatically removed from the input value. You can use attributes such as <strong>pattern</strong> and <strong>maxlength</strong> to restrict values entered in the control. The <a href="/en-US/docs/Web/CSS/:valid" title="The :valid CSS pseudo-class represents any <input> or <form> element whose content validates correctly according to the input's type setting. This allows to easily make valid fields adopt an appearance that helps the user confirm that their data is formatted properly."><code>:valid</code></a> and <a href="/en-US/docs/Web/CSS/:invalid" title="The :invalid CSS pseudo-class represents any <input> or <form> element whose content fails to validate according to the input's type setting. This allows you to easily have invalid fields adopt an appearance that helps the user identify and correct errors."><code>:invalid</code></a> CSS pseudo-classes are applied as appropriate.</li> 
 <li><code>week</code>: <span class="inlineIndicator htmlVer htmlVerInline"><a href="/en-US/docs/HTML/HTML5">HTML5</a></span> A control for entering a date consisting of a week-year number and a week number with no time zone.</li> 
</ul>
   */
  def `type`: StateChannel[String] = attribute("type").asInstanceOf[StateChannel[String]]
  /**
   * If the value of the 
<strong>type</strong> attribute is 
<code>file</code>, this attribute indicates the types of files that the server accepts; otherwise it is ignored. The value must be a comma-separated list of unique content type specifiers: 
<ul> 
 <li>A file extension starting with the STOP character (U+002E). (E.g.: ".jpg,.png,.doc")</li> 
 <li>A valid MIME type with no extensions</li> 
 <li><code>audio/</code> representing sound files <span class="inlineIndicator htmlVer htmlVerInline"><a href="/en-US/docs/HTML/HTML5">HTML5</a></span></li> 
 <li><code>video/</code> representing video files <span class="inlineIndicator htmlVer htmlVerInline"><a href="/en-US/docs/HTML/HTML5">HTML5</a></span></li> 
 <li><code>image/</code> representing image files <span class="inlineIndicator htmlVer htmlVerInline"><a href="/en-US/docs/HTML/HTML5">HTML5</a></span></li> 
</ul>
   */
  def accept: StateChannel[String] = attribute("accept").asInstanceOf[StateChannel[String]]
  /**
   * Specifies an "action hint" used to determine how to label the enter key on mobile devices with virtual keyboards. Supported values are 
<code>go</code>, 
<code>done</code>, 
<code>next</code>, 
<code>search</code>, and 
<code>send</code>; these automatically get mapped to the appropriate string (and are case-insensitive).
   */
  def mozactionhint: StateChannel[String] = attribute("mozactionhint").asInstanceOf[StateChannel[String]]
  /**
   * This is a nonstandard attribute used by iOS Safari Mobile which controls whether and how the text value should be automatically capitalized as it is entered/edited by the user. The non-deprecated values are available in iOS 5 and later. Possible values are: 
<ul> 
 <li><code>none</code>: Completely disables automatic capitalization</li> 
 <li><code>sentences</code>: Automatically capitalize the first letter of sentences.</li> 
 <li><code>words</code>: Automatically capitalize the first letter of words.</li> 
 <li><code>characters</code>: Automatically capitalize all characters.</li> 
 <li><code>on</code>: <span title="This deprecated API should no longer be used, but will probably still work."><i class="icon-thumbs-down-alt"> </i></span> Deprecated since iOS 5.</li> 
 <li><code>off</code>: <span title="This deprecated API should no longer be used, but will probably still work."><i class="icon-thumbs-down-alt"> </i></span> Deprecated since iOS 5.</li> 
</ul> 
<a href="https://developer.apple.com/library/safari/documentation/AppleApplications/Reference/SafariHTMLRef/Articles/Attributes.html#//apple_ref/doc/uid/TP40008058-autocapitalize" class="external"><code>autocapitalize</code> documentation in the Safari HTML Reference</a>
   */
  def autocapitalize: StateChannel[String] = attribute("autocapitalize").asInstanceOf[StateChannel[String]]
  /**
   * This attribute indicates whether the value of the control can be automatically completed by the browser.
   */
  def autocomplete: StateChannel[String] = attribute("autocomplete").asInstanceOf[StateChannel[String]]
  /**
   * This is a nonstandard attribute supported by Safari that is used to control whether autocorrection should be enabled when the user is entering/editing the text value of the 
<a href="/en-US/docs/Web/HTML/Element/input" title="The HTML <input> element is used to create interactive controls for web-based forms in order to accept data from the user. How an <input> works varies considerably depending on the value of its type attribute."><code>&lt;input&gt;</code></a>. Possible attribute values are: 
<ul> 
 <li><code>on</code>: Enable autocorrection</li> 
 <li><code>off</code>: Disable autocorrection</li> 
</ul> 
<a href="https://developer.apple.com/library/safari/documentation/AppleApplications/Reference/SafariHTMLRef/Articles/Attributes.html#//apple_ref/doc/uid/TP40008058-autocorrect" class="external"><code>autocorrect</code> documentation in the Safari HTML Reference</a>
   */
  def autocorrect: StateChannel[String] = attribute("autocorrect").asInstanceOf[StateChannel[String]]
  /**
   * This Boolean attribute lets you specify that a form control should have input focus when the page loads, unless the user overrides it, for example by typing in a different control. Only one form element in a document can have the 
<strong>autofocus</strong> attribute, which is a Boolean. It cannot be applied if the 
<strong>type</strong> attribute is set to 
<code>hidden</code> (that is, you cannot automatically set focus to a hidden control).
   */
  def autofocus: StateChannel[Boolean] = attribute("autofocus").asInstanceOf[StateChannel[Boolean]]
  /**
   * This attribute should be defined as a unique value. If the value of the type attribute is 
<code>search</code>, previous search term values will persist in the dropdown across page load.
   */
  def autosave: StateChannel[String] = attribute("autosave").asInstanceOf[StateChannel[String]]
  /**
   * <p>When the value of the <strong>type</strong> attribute is <code>radio</code> or <code>checkbox</code>, the presence of this Boolean attribute indicates that the control is selected by default; otherwise it is ignored.</p> 
<p>Firefox will, unlike other browsers, by default, <a href="http://stackoverflow.com/questions/5985839/bug-with-firefox-disabled-attribute-of-input-not-resetting-when-refreshing" class="external">persist the dynamic checked state</a> of an <a href="/en-US/docs/Web/HTML/Element/input" title="The HTML <input> element is used to create interactive controls for web-based forms in order to accept data from the user. How an <input> works varies considerably depending on the value of its type attribute."><code>&lt;input&gt;</code></a> across page loads. Use the <code><a href="/en-US/docs/Web/HTML/Element/input#attr-autocomplete">autocomplete</a></code> attribute to control this feature.</p>
   */
  def checked: StateChannel[Boolean] = attribute("checked").asInstanceOf[StateChannel[Boolean]]
  /**
   * <p>This Boolean attribute indicates that the form control is not available for interaction. In particular, the <code>click</code> event <a href="https://html.spec.whatwg.org/multipage/forms.html#enabling-and-disabling-form-controls:-the-disabled-attribute" class="external">will not be dispatched</a> on disabled controls. Also, a disabled control's value isn't submitted with the form.</p> 
<p>Firefox will, unlike other browsers, by default, <a href="http://stackoverflow.com/questions/5985839/bug-with-firefox-disabled-attribute-of-input-not-resetting-when-refreshing" class="external">persist the dynamic disabled state</a> of an <a href="/en-US/docs/Web/HTML/Element/input" title="The HTML <input> element is used to create interactive controls for web-based forms in order to accept data from the user. How an <input> works varies considerably depending on the value of its type attribute."><code>&lt;input&gt;</code></a> across page loads. Use the <code><a href="/en-US/docs/Web/HTML/Element/input#attr-autocomplete">autocomplete</a></code> attribute to control this feature.</p>
   */
  def disabled: StateChannel[Boolean] = attribute("disabled").asInstanceOf[StateChannel[Boolean]]
  /**
   * The form element that the input element is associated with (its 
<em>form owner</em>). The value of the attribute must be an 
<strong>id</strong> of a 
<a href="/en-US/docs/Web/HTML/Element/form" title="The HTML <form> element represents a document section that contains interactive controls to submit information to a web server."><code>&lt;form&gt;</code></a> element in the same document. If this attribute is not specified, this 
<code>&lt;input&gt;</code> element must be a descendant of a 
<a href="/en-US/docs/Web/HTML/Element/form" title="The HTML <form> element represents a document section that contains interactive controls to submit information to a web server."><code>&lt;form&gt;</code></a> element. This attribute enables you to place 
<code>&lt;input&gt;</code> elements anywhere within a document, not just as descendants of their form elements. An input can only be associated with one form.
   */
  def form: StateChannel[state.Node] = attribute("form").asInstanceOf[StateChannel[state.Node]]
  /**
   * The URI of a program that processes the information submitted by the input element, if it is a submit button or image. If specified, it overrides the 
<code><a href="/en-US/docs/Web/HTML/Element/form#attr-action">action</a></code> attribute of the element's form owner.
   */
  def formaction: StateChannel[String] = attribute("formaction").asInstanceOf[StateChannel[String]]
  /**
   * If the input element is a submit button or image, this attribute specifies the type of content that is used to submit the form to the server. Possible values are: 
<ul> 
 <li><code>application/x-www-form-urlencoded</code>: The default value if the attribute is not specified.</li> 
 <li><code>multipart/form-data</code>: Use this value if you are using an <a href="/en-US/docs/Web/HTML/Element/input" title="The HTML <input> element is used to create interactive controls for web-based forms in order to accept data from the user. How an <input> works varies considerably depending on the value of its type attribute."><code>&lt;input&gt;</code></a> element with the <code><a href="/en-US/docs/Web/HTML/Element/input#attr-type">type</a></code> attribute set to <code>file</code>.</li> 
 <li><code>text/plain</code></li> 
</ul> 
<p>If this attribute is specified, it overrides the <code><a href="/en-US/docs/Web/HTML/Element/form#attr-enctype">enctype</a></code> attribute of the element's form owner.</p>
   */
  def formenctype: StateChannel[String] = attribute("formenctype").asInstanceOf[StateChannel[String]]
  /**
   * If the input element is a submit button or image, this attribute specifies the HTTP method that the browser uses to submit the form. Possible values are: 
<ul> 
 <li><code>post</code>: The data from the form is included in the body of the form and is sent to the server.</li> 
 <li><code>get</code>: The data from the form are appended to the <strong>form</strong> attribute URI, with a '?' as a separator, and the resulting URI is sent to the server. Use this method when the form has no side-effects and contains only ASCII characters.</li> 
</ul> 
<p>If specified, this attribute overrides the <code><a href="/en-US/docs/Web/HTML/Element/form#attr-method">method</a></code> attribute of the element's form owner.</p>
   */
  def formmethod: StateChannel[String] = attribute("formmethod").asInstanceOf[StateChannel[String]]
  /**
   * If the input element is a submit button or image, this Boolean attribute specifies that the form is not to be validated when it is submitted. If this attribute is specified, it overrides the 
<code><a href="/en-US/docs/Web/HTML/Element/form#attr-novalidate">novalidate</a></code> attribute of the element's form owner.
   */
  def formnovalidate: StateChannel[String] = attribute("formnovalidate").asInstanceOf[StateChannel[String]]
  /**
   * If the input element is a submit button or image, this attribute is a name or keyword indicating where to display the response that is received after submitting the form. This is a name of, or keyword for, a 
<em>browsing context</em> (for example, tab, window, or inline frame). If this attribute is specified, it overrides the 
<code><a href="/en-US/docs/Web/HTML/Element/form#attr-target">target</a></code> attribute of the elements's form owner. The following keywords have special meanings: 
<ul> 
 <li>_<code>self</code>: Load the response into the same browsing context as the current one. This value is the default if the attribute is not specified.</li> 
 <li><code>_blank</code>: Load the response into a new unnamed browsing context.</li> 
 <li><code>_parent</code>: Load the response into the parent browsing context of the current one. If there is no parent, this option behaves the same way as <code>_self</code>.</li> 
 <li><code>_top</code>: Load the response into the top-level browsing context (that is, the browsing context that is an ancestor of the current one, and has no parent). If there is no parent, this option behaves the same way as <code>_self</code>.</li> 
</ul>
   */
  def formtarget: StateChannel[String] = attribute("formtarget").asInstanceOf[StateChannel[String]]
  /**
   * If the value of the 
<strong>type</strong> attribute is 
<code>image</code>, this attribute defines the height of the image displayed for the button.
   */
  def height: StateChannel[String] = attribute("height").asInstanceOf[StateChannel[String]]
  /**
   * This is a nonstandard attribute supported by Safari that only applies when the 
<strong>type</strong> is 
<code>search</code>. If the attribute is present, regardless of what its value is, the 
<a href="/en-US/docs/Web/HTML/Element/input" title="The HTML <input> element is used to create interactive controls for web-based forms in order to accept data from the user. How an <input> works varies considerably depending on the value of its type attribute."><code>&lt;input&gt;</code></a> fires 
<a href="/en-US/docs/Web/Events/search"><code>search</code></a> events as the user edits the text value. The event is only fired after an implementation-defined timeout has elapsed since the most recent keystroke; new keystrokes reset the timeout. In other words, the event firing is debounced. If the attribute is absent, the 
<a href="/en-US/docs/Web/Events/search"><code>search</code></a> event is only fired when the user explicitly initiates a search (e.g. by pressing the Enter key while within field). 
<a href="https://developer.apple.com/library/safari/documentation/AppleApplications/Reference/SafariHTMLRef/Articles/Attributes.html#//apple_ref/doc/uid/TP40008058-incremental" class="external"><code>incremental</code> documentation in the Safari HTML Reference</a>
   */
  def incremental: StateChannel[String] = attribute("incremental").asInstanceOf[StateChannel[String]]
  /**
   * A hint to the browser for which keyboard to display. This attribute applies when the value of the 
<strong>type</strong> attribute is text, password, email, or url. Possible values are: 
<ul> 
 <li><code>verbatim</code>: Alphanumeric, non-prose content such as usernames and passwords.</li> 
 <li><code>latin</code>: Latin-script input in the user's preferred language with typing aids such as text prediction enabled. For human-to-computer communication such as search boxes.</li> 
 <li><code>latin-name</code>: As <em>latin</em>, but for human names.</li> 
 <li><code>latin-prose</code>: As <em>latin</em>, but with more aggressive typing aids. For human-to-human communication such as instant messaging or email.</li> 
 <li><code>full-width-latin</code>: As <em>latin-prose</em>, but for the user's secondary languages.</li> 
 <li><code>kana</code>: Kana or romaji input, typically hiragana input, using full-width characters, with support for converting to kanji. Intended for Japanese text input.</li> 
 <li><code>katakana</code>: Katakana input, using full-width characters, with support for converting to kanji. Intended for Japanese text input.</li> 
 <li><code>numeric</code>: Numeric input, including keys for the digits 0 to 9, the user's preferred thousands separator character, and the character for indicating negative numbers. Intended for numeric codes, e.g. credit card numbers. For actual numbers, prefer using &lt;input type="number"&gt;</li> 
 <li><code>tel</code>: Telephone input, including asterisk and pound key. Use &lt;input type="tel"&gt; if possible instead.</li> 
 <li><code>email</code>: Email input. Use &lt;input type="email"&gt; if possible instead.</li> 
 <li><code>url</code>: URL input. Use &lt;input type="url"&gt; if possible instead.</li> 
</ul>
   */
  def inputmode: StateChannel[String] = attribute("inputmode").asInstanceOf[StateChannel[String]]
  /**
   * Identifies a list of pre-defined options to suggest to the user. The value must be the 
<strong>id</strong> of a 
<a href="/en-US/docs/Web/HTML/Element/datalist" title="The HTML Datalist&nbsp;Element&nbsp;(<datalist>) contains a set of <option> elements that represent the values available for other controls."><code>&lt;datalist&gt;</code></a> element in the same document. The browser displays only options that are valid values for this input element. This attribute is ignored when the 
<strong>type</strong> attribute's value is 
<code>hidden</code>, 
<code>checkbox</code>, 
<code>radio</code>, 
<code>file</code>, or a button type.
   */
  def list: StateChannel[state.Node] = attribute("list").asInstanceOf[StateChannel[state.Node]]
  /**
   * The maximum (numeric or date-time) value for this item, which must not be less than its minimum (
<strong>min</strong> attribute) value.
   */
  def max: StateChannel[String] = attribute("max").asInstanceOf[StateChannel[String]]
  /**
   * If the value of the 
<strong>type</strong> attribute is 
<code>text</code>, 
<code>email</code>,
<code> search</code>, 
<code>password</code>, 
<code>tel</code>, or 
<code>url</code>, this attribute specifies the maximum number of characters (in Unicode code points) that the user can enter; for other control types, it is ignored. It can exceed the value of the 
<strong>size</strong> attribute. If it is not specified, the user can enter an unlimited number of characters. Specifying a negative number results in the default behavior; that is, the user can enter an unlimited number of characters. The constraint is evaluated only when the value of the attribute has been changed.
   */
  def maxlength: StateChannel[String] = attribute("maxlength").asInstanceOf[StateChannel[String]]
  /**
   * The minimum (numeric or date-time) value for this item, which must not be greater than its maximum (
<strong>max</strong> attribute) value.
   */
  def min: StateChannel[String] = attribute("min").asInstanceOf[StateChannel[String]]
  /**
   * If the value of the 
<strong>type</strong> attribute is 
<code>text</code>, 
<code>email</code>,
<code> search</code>, 
<code>password</code>, 
<code>tel</code>, or 
<code>url</code>, this attribute specifies the minimum number of characters (in Unicode code points) that the user can enter; for other control types, it is ignored.
   */
  def minlength: StateChannel[String] = attribute("minlength").asInstanceOf[StateChannel[String]]
  /**
   * This Boolean attribute indicates whether the user can enter more than one value. This attribute applies when the 
<strong>type</strong> attribute is set to 
<code>email</code> or 
<code>file</code>; otherwise it is ignored.
   */
  def multiple: StateChannel[String] = attribute("multiple").asInstanceOf[StateChannel[String]]
  /**
   * The name of the control, which is submitted with the form data.
   */
  def name: StateChannel[String] = attribute("name").asInstanceOf[StateChannel[String]]
  /**
   * A regular expression that the control's value is checked against. The pattern must match the entire value, not just some subset. Use the 
<strong>title</strong> attribute to describe the pattern to help the user. This attribute applies when the value of the 
<strong>type</strong> attribute is 
<code>text</code>, 
<code>search</code>, 
<code>tel</code>, 
<code>url</code> or 
<code>email</code>; otherwise it is ignored. The regular expression language is the same as JavaScript's. The pattern is not surrounded by forward slashes.
   */
  def pattern: StateChannel[String] = attribute("pattern").asInstanceOf[StateChannel[String]]
  /**
   * A hint to the user of what can be entered in the control . The placeholder text must not contain carriage returns or line-feeds. This attribute applies when the value of the 
<strong>type</strong> attribute is 
<code>text</code>, 
<code>search</code>, 
<code>tel</code>, 
<code>url</code> or 
<code>email</code>; otherwise it is ignored. 
<div class="note">
 <strong>Note:</strong> Do not use the 
 <code>placeholder</code> attribute instead of a 
 <a href="/en-US/docs/Web/HTML/Element/label" title="The HTML Label&nbsp;Element (<label>) represents a caption for an item in a user interface. It can be associated with a control either by placing the control element inside the <label> element, or by using the for attribute. Such a control is called the labeled control of the label element."><code>&lt;label&gt;</code></a> element. Their purposes are different: the 
 <a href="/en-US/docs/Web/HTML/Element/label" title="The HTML Label&nbsp;Element (<label>) represents a caption for an item in a user interface. It can be associated with a control either by placing the control element inside the <label> element, or by using the for attribute. Such a control is called the labeled control of the label element."><code>&lt;label&gt;</code></a> attribute describes the role of the form element; that is, it indicates what kind of information is expected, the 
 <code>placeholder</code> attribute is a hint about the format the content should take. There are cases in which the 
 <code>placeholder</code> attribute is never displayed to the user, so the form must be understandable without it.
</div>
   */
  def placeholder: StateChannel[String] = attribute("placeholder").asInstanceOf[StateChannel[String]]
  /**
   * This Boolean attribute indicates that the user cannot modify the value of the control. It is ignored if the value of the 
<strong>type</strong> attribute is 
<code>hidden</code>, 
<code>range</code>, 
<code>color</code>, 
<code>checkbox</code>, 
<code>radio</code>, 
<code>file</code>, or a button type (such as 
<code>button</code> or 
<code>submit</code>).
   */
  def readonly: StateChannel[String] = attribute("readonly").asInstanceOf[StateChannel[String]]
  /**
   * This attribute specifies that the user must fill in a value before submitting a form. It cannot be used when the 
<strong>type</strong> attribute is 
<code>hidden</code>, 
<code>image</code>, or a button type (
<code>submit</code>, 
<code>reset</code>, or 
<code>button</code>). The 
<a href="/en-US/docs/Web/CSS/:optional" title="The :optional CSS pseudo-class represents any <input>&nbsp;element that does not have the required attribute set on it. This allows forms to easily indicate optional fields, and to style them accordingly."><code>:optional</code></a> and 
<a href="/en-US/docs/Web/CSS/:required" title="The :required CSS pseudo-class represents any <input>&nbsp;element that has the required attribute set on it. This allows forms to easily indicate which fields must have valid data before the form can be submitted."><code>:required</code></a> CSS pseudo-classes will be applied to the field as appropriate.
   */
  def required: StateChannel[Boolean] = attribute("required").asInstanceOf[StateChannel[Boolean]]
  /**
   * This is a nonstandard attribute supported by Safari that only applies when the 
<strong>type</strong> is 
<code>search</code>. It is used to control the maximum number of entries that should be displayed in the 
<a href="/en-US/docs/Web/HTML/Element/input" title="The HTML <input> element is used to create interactive controls for web-based forms in order to accept data from the user. How an <input> works varies considerably depending on the value of its type attribute."><code>&lt;input&gt;</code></a>'s native dropdown list of past search queries. Its value should be a nonnegative decimal integer.
   */
  def results: StateChannel[String] = attribute("results").asInstanceOf[StateChannel[String]]
  /**
   * The direction in which selection occurred. This is "forward" if the selection was made from left-to-right in an LTR locale or right-to-left in an RTL locale, or "backward" if the selection was made in the opposite direction. This can be "none" if the selection direction is unknown.
   */
  def selectionDirection: StateChannel[String] = attribute("selectionDirection").asInstanceOf[StateChannel[String]]
  /**
   * The initial size of the control. This value is in pixels unless the value of the 
<strong>type</strong> attribute is 
<code>text</code> or 
<code>password</code>, in which case, it is an integer number of characters. Starting in HTML5, this attribute applies only when the 
<strong>type</strong> attribute is set to 
<code>text</code>, 
<code>search</code>, 
<code>tel</code>, 
<code>url</code>, 
<code>email</code>, or 
<code>password</code>; otherwise it is ignored. In addition, the size must be greater than zero. If you don't specify a size, a default value of 20 is used.
   */
  def size: StateChannel[Long] = attribute("size").asInstanceOf[StateChannel[Long]]
  /**
   * If the value of the 
<strong>type</strong> attribute is 
<code>image</code>, this attribute specifies a URI for the location of an image to display on the graphical submit button; otherwise it is ignored.
   */
  def src: StateChannel[String] = attribute("src").asInstanceOf[StateChannel[String]]
  /**
   * Works with the 
<strong>min</strong> and 
<strong>max</strong> attributes to limit the increments at which a numeric or date-time value can be set. It can be the string 
<code>any</code> or a positive floating point number. If this attribute is not set to 
<code>any</code>, the control accepts only values at multiples of the step value greater than the minimum.
   */
  def step: StateChannel[String] = attribute("step").asInstanceOf[StateChannel[String]]
  /**
   * The name of a 
<a href="/en-US/docs/Web/HTML/Element/map" title="The HTML <map> element is used with <area> elements to define an image map (a clickable link area)."><code>&lt;map&gt;</code></a> element to be used as an image map.
   */
  def usemap: StateChannel[String] = attribute("usemap").asInstanceOf[StateChannel[String]]
  /**
   * The initial value of the control. This attribute is optional except when the value of the 
<strong>type</strong> attribute is 
<code>radio</code> or 
<code>checkbox</code>.
<br> Note that when reloading the page, Gecko and IE 
<a href="https://bugzilla.mozilla.org/show_bug.cgi?id=46845#c186" class="external link-https">will ignore the value specified in the HTML source</a>, if the value was changed before the reload.
   */
  def value: StateChannel[String] = attribute("value").asInstanceOf[StateChannel[String]]
  /**
   * If the value of the 
<strong>type</strong> attribute is 
<code>image</code>, this attribute defines the width of the image displayed for the button.
   */
  def width: StateChannel[String] = attribute("width").asInstanceOf[StateChannel[String]]
  /**
   * This Mozilla extension allows you to specify the error message to display when a field doesn't successfully validate.
   */
  def `x-moz-errormessage`: StateChannel[String] = attribute("x-moz-errormessage").asInstanceOf[StateChannel[String]]
}
