package pl.metastack.metaweb.tag

import pl.metastack.metarx._
import pl.metastack.metaweb.state

/**
 * The HTML <em>select</em> (<code>&lt;select&gt;</code>) element represents a control that presents a menu of options. The options within the menu are represented by <code><a href="/en-US/docs/Web/HTML/Element/option" title="In a Web form, the HTML <option> element is used to create a control representing an item within a <select>, an <optgroup> or a <datalist> HTML5 element."><code>&lt;option&gt;</code></a></code> elements, which can be grouped by <code><a href="/en-US/docs/Web/HTML/Element/optgroup" title="In a Web form, the HTML <optgroup> element&nbsp; creates a grouping of options within a <select> element."><code>&lt;optgroup&gt;</code></a></code> elements. Options can be pre-selected for the user.
 */
class Select extends state.Tag("select") with HTMLTag {
  /**
   * This attribute lets you specify that a form control should have input focus when the page loads, unless the user overrides it, for example by typing in a different control. Only one form element in a document can have the 
<code>autofocus</code> attribute, which is a Boolean.
   */
  def autofocus: StateChannel[String] = attribute("autofocus").asInstanceOf[StateChannel[String]]
  /**
   * This Boolean attribute indicates that the user cannot interact with the control. If this attribute is not specified, the control inherits its setting from the containing element, for example 
<code>fieldset</code>; if there is no containing element with the 
<code>disabled</code> attribute set, then the control is enabled.
   */
  def disabled: StateChannel[String] = attribute("disabled").asInstanceOf[StateChannel[String]]
  /**
   * The form element that the select element is associated with (its "form owner"). If this attribute is specified, its value must be the ID of a form element in the same document. This enables you to place select elements anywhere within a document, not just as descendants of their form elements.
   */
  def form: StateChannel[String] = attribute("form").asInstanceOf[StateChannel[String]]
  /**
   * This Boolean attribute indicates that multiple options can be selected in the list. If it is not specified, then only one option can be selected at a time.
   */
  def multiple: StateChannel[String] = attribute("multiple").asInstanceOf[StateChannel[String]]
  /**
   * The name of the control.
   */
  def name: StateChannel[String] = attribute("name").asInstanceOf[StateChannel[String]]
  /**
   * A Boolean attribute indicating that an option with a non-empty string value must be selected.
   */
  def required: StateChannel[String] = attribute("required").asInstanceOf[StateChannel[String]]
  /**
   * If the control is presented as a scrolled list box, this attribute represents the number of rows in the list that should be visible at one time. Browsers are not required to present a select elements as a scrolled list box. The default value is 0.
   */
  def size: StateChannel[String] = attribute("size").asInstanceOf[StateChannel[String]]
}
