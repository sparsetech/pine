package pine.tag

import pine._

/**
 * The <strong>HTML <code>&lt;textarea&gt; </code>element</strong> represents a multi-line plain-text editing control.
 */
case class Textarea(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[Node] = Seq.empty) extends HTMLTag {
  override type T = Textarea
  override def tagName = "textarea"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[Node] = children): Textarea = Textarea(attributes, children)
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
   */
  def autocapitalize: scala.Option[String] = attributes.get("autocapitalize").asInstanceOf[scala.Option[String]]
  def autocapitalize(value: String): Textarea = copy(attributes = attributes + ("autocapitalize" -> value))
  /**
   * This attribute indicates whether the value of the control can be automatically completed by the browser. Possible values are: 
<ul> 
 <li><code>off</code>: The user must explicitly enter a value into this field for every use, or the document provides its own auto-completion method; the browser does not automatically complete the entry.</li> 
 <li><code>on</code>: The browser can automatically complete the value based on values that the user has entered during previous uses.</li> 
</ul> 
<p>If the <strong>autocomplete</strong> attribute is not specified on an textarea element, then the browser uses the <strong>autocomplete</strong> attribute value of the <code>&lt;textarea&gt;</code> element's form owner. The form owner is either the <code>form</code> element that this <code>&lt;textarea&gt;</code> element is a descendant of or the form element whose <strong>id</strong> is specified by the <strong>form</strong> attribute of the input element. For more information, see the <code><a href="/en-US/docs/Web/HTML/Element/form#attr-autocomplete">autocomplete</a></code> attribute in <a href="/en-US/docs/Web/HTML/Element/form" title="The HTML <form> element represents a document section that contains interactive controls to submit information to a web server."><code>&lt;form&gt;</code></a>.</p>
   */
  def autocomplete: scala.Option[String] = attributes.get("autocomplete").asInstanceOf[scala.Option[String]]
  def autocomplete(value: String): Textarea = copy(attributes = attributes + ("autocomplete" -> value))
  /**
   * This Boolean attribute lets you specify that a form control should have input focus when the page loads, unless the user overrides it, for example by typing in a different control. Only one form-associated element in a document can have this attribute specified.&nbsp;
   */
  def autofocus: scala.Option[String] = attributes.get("autofocus").asInstanceOf[scala.Option[String]]
  def autofocus(value: String): Textarea = copy(attributes = attributes + ("autofocus" -> value))
  /**
   * The visible width of the text control, in average character widths. If it is specified, it must be a positive integer. If it is not specified, the default value is 
<span style="font-family: courier new;">20</span> (HTML5).
   */
  def cols: scala.Option[String] = attributes.get("cols").asInstanceOf[scala.Option[String]]
  def cols(value: String): Textarea = copy(attributes = attributes + ("cols" -> value))
  /**
   * This Boolean attribute indicates that the user cannot interact with the control. (If this attribute is not specified, the control inherits its setting from the containing element, for example 
<a href="/en-US/docs/Web/HTML/Element/fieldset" title="The HTML <fieldset> element is used to group several controls as well as labels (<label>) within a web form."><code>&lt;fieldset&gt;</code></a>; if there is no containing element with the 
<code>disabled</code> attribute set, then the control is enabled.)
   */
  def disabled: scala.Option[String] = attributes.get("disabled").asInstanceOf[scala.Option[String]]
  def disabled(value: String): Textarea = copy(attributes = attributes + ("disabled" -> value))
  /**
   * The form element that the textarea element is associated with (its "form owner"). The value of the attribute must be an ID of a form element in the same document. If this attribute is not specified, the textarea element must be a descendant of a form element. This attribute enables you to place textarea elements anywhere within a document, not just as descendants of their form elements.
   */
  def form: scala.Option[String] = attributes.get("form").asInstanceOf[scala.Option[String]]
  def form(value: String): Textarea = copy(attributes = attributes + ("form" -> value))
  /**
   * The maximum number of characters (Unicode code points) that the user can enter. If it is not specified, the user can enter an unlimited number of characters.
   */
  def maxlength: scala.Option[String] = attributes.get("maxlength").asInstanceOf[scala.Option[String]]
  def maxlength(value: String): Textarea = copy(attributes = attributes + ("maxlength" -> value))
  /**
   * The minimum number of characters (Unicode code points) required that the user should enter.
   */
  def minlength: scala.Option[String] = attributes.get("minlength").asInstanceOf[scala.Option[String]]
  def minlength(value: String): Textarea = copy(attributes = attributes + ("minlength" -> value))
  /**
   * The name of the control.
   */
  def name: scala.Option[String] = attributes.get("name").asInstanceOf[scala.Option[String]]
  def name(value: String): Textarea = copy(attributes = attributes + ("name" -> value))
  /**
   * A hint to the user of what can be entered in the control. Carriage returns or line-feeds within the placeholder text must be treated as line breaks when rendering the hint.
   */
  def placeholder: scala.Option[String] = attributes.get("placeholder").asInstanceOf[scala.Option[String]]
  def placeholder(value: String): Textarea = copy(attributes = attributes + ("placeholder" -> value))
  /**
   * This Boolean attribute indicates that the user cannot modify the value of the control. Unlike the 
<code>disabled</code> attribute, the 
<code>readonly</code> attribute does not prevent the user from clicking or selecting in the control. The value of a read-only control is still submitted with the form.
   */
  def readonly: scala.Option[String] = attributes.get("readonly").asInstanceOf[scala.Option[String]]
  def readonly(value: String): Textarea = copy(attributes = attributes + ("readonly" -> value))
  /**
   * This attribute specifies that the user must fill in a value before submitting a form.
   */
  def required: scala.Option[String] = attributes.get("required").asInstanceOf[scala.Option[String]]
  def required(value: String): Textarea = copy(attributes = attributes + ("required" -> value))
  /**
   * The number of visible text lines for the control.
   */
  def rows: scala.Option[String] = attributes.get("rows").asInstanceOf[scala.Option[String]]
  def rows(value: String): Textarea = copy(attributes = attributes + ("rows" -> value))
  /**
   * The direction in which selection occurred. This is "forward" if the selection was made from left-to-right in an LTR locale or right-to-left in an RTL&nbsp;locale, or "backward" if the selection was made in the opposite direction. This can be "none"&nbsp;if the selection direction is unknown.
   */
  def selectionDirection: scala.Option[String] = attributes.get("selectionDirection").asInstanceOf[scala.Option[String]]
  def selectionDirection(value: String): Textarea = copy(attributes = attributes + ("selectionDirection" -> value))
  /**
   * The index to the last character in the current selection.
   */
  def selectionEnd: scala.Option[String] = attributes.get("selectionEnd").asInstanceOf[scala.Option[String]]
  def selectionEnd(value: String): Textarea = copy(attributes = attributes + ("selectionEnd" -> value))
  /**
   * The index to the first character in the current selection.
   */
  def selectionStart: scala.Option[String] = attributes.get("selectionStart").asInstanceOf[scala.Option[String]]
  def selectionStart(value: String): Textarea = copy(attributes = attributes + ("selectionStart" -> value))
  /**
   * Indicates how the control wraps text. Possible values are: 
<ul> 
 <li><span style="font-family: courier new;">hard</span>: The browser automatically inserts line breaks (CR+LF) so that each line has no more than the width of the control; the <code>cols</code> attribute must be specified.</li> 
 <li><span style="font-family: courier new;">soft</span>: The browser ensures that all line breaks in the value consist of a CR+LF pair, but does not insert any additional line breaks.</li> 
</ul> 
<p>If this attribute is not specified, <span style="font-family: courier new;">soft</span> is its default value.</p>
   */
  def wrap: scala.Option[String] = attributes.get("wrap").asInstanceOf[scala.Option[String]]
  def wrap(value: String): Textarea = copy(attributes = attributes + ("wrap" -> value))
}
