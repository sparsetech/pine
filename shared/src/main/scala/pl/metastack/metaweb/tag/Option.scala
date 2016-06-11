package pl.metastack.metaweb.tag

import pl.metastack.metaweb.tree

/**
 * This element includes the <a href="/en-US/docs/Web/HTML/Global_attributes">global attributes</a>.
<dt>
 <strong id="attr-disabled"><code>disabled</code></strong>
</dt> 
<dd>
 If this Boolean attribute is set, this option is not checkable. Often browsers grey out such control and it won't receive any browsing event, like mouse clicks or focus-related ones. If this attribute is not set, the element can still be disabled if one its ancestors is a disabled 
 <a href="/en-US/docs/Web/HTML/Element/optgroup" title="In a Web form, the HTML <optgroup> element&nbsp; creates a grouping of options within a <select> element."><code>&lt;optgroup&gt;</code></a> element.
</dd> 
<dt>
 <strong id="attr-label"><code>label</code></strong>
</dt> 
<dd>
 This attribute is text for the label indicating the meaning of the option. If the 
 <code><strong>label</strong></code> attribute isn't defined, its value is that of the element text content. 
 <div class="note">
  <em>Usage note: </em>the 
  <code><strong>label</strong></code> attribute is designed to contain a short label typically used in a hierarchical menu. The 
  <strong><code>value</code></strong> attribute describes a longer label designed to be used near a radio button, for example.
 </div> 
</dd> 
<dt>
 <strong id="attr-selected"><code>selected</code></strong>
</dt> 
<dd>
 If present, this Boolean attribute indicates that the option is initially selected. If the 
 <code>&lt;option&gt;</code> element is the descendant of a
 <a href="/en-US/docs/Web/HTML/Element/select" title="The HTML select (<select>) element represents a control that presents a menu of options. The options within the menu are represented by <option> elements, which can be grouped by <optgroup> elements. Options can be pre-selected for the user."><code>&lt;select&gt;</code></a> element whose 
 <code><a href="/en-US/docs/Web/HTML/Element/select#attr-multiple">multiple</a></code> attribute is not set, only one single 
 <code>&lt;option&gt;</code> of this 
 <a href="/en-US/docs/Web/HTML/Element/select" title="The HTML select (<select>) element represents a control that presents a menu of options. The options within the menu are represented by <option> elements, which can be grouped by <optgroup> elements. Options can be pre-selected for the user."><code>&lt;select&gt;</code></a> element may have the 
 <strong>selected</strong> attribute.
</dd> 
<dt>
 <strong id="attr-value"><code>value</code></strong>
</dt> 
<dd>
 The content of this attribute represents the value to be submitted with the form, should this option be selected.&nbsp;If this attribute is omitted, the value is taken from the text content of the option element.
</dd>
 */
case class Option(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[tree.Node] = Seq.empty) extends tree.Tag with HTMLTag {
  override def tagName = "option"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[tree.Node] = children): Option = Option(attributes, children)
  /**
   * If this Boolean attribute is set, this option is not checkable. Often browsers grey out such control and it won't receive any browsing event, like mouse clicks or focus-related ones. If this attribute is not set, the element can still be disabled if one its ancestors is a disabled 
<a href="/en-US/docs/Web/HTML/Element/optgroup" title="In a Web form, the HTML <optgroup> element&nbsp; creates a grouping of options within a <select> element."><code>&lt;optgroup&gt;</code></a> element.
   */
  def disabled: scala.Option[String] = attributes.get("disabled").asInstanceOf[scala.Option[String]]
  /**
   * This attribute is text for the label indicating the meaning of the option. If the 
<code><strong>label</strong></code> attribute isn't defined, its value is that of the element text content. 
<div class="note">
 <em>Usage note: </em>the 
 <code><strong>label</strong></code> attribute is designed to contain a short label typically used in a hierarchical menu. The 
 <strong><code>value</code></strong> attribute describes a longer label designed to be used near a radio button, for example.
</div>
   */
  def label: scala.Option[String] = attributes.get("label").asInstanceOf[scala.Option[String]]
  /**
   * If present, this Boolean attribute indicates that the option is initially selected. If the 
<code>&lt;option&gt;</code> element is the descendant of a
<a href="/en-US/docs/Web/HTML/Element/select" title="The HTML select (<select>) element represents a control that presents a menu of options. The options within the menu are represented by <option> elements, which can be grouped by <optgroup> elements. Options can be pre-selected for the user."><code>&lt;select&gt;</code></a> element whose 
<code><a href="/en-US/docs/Web/HTML/Element/select#attr-multiple">multiple</a></code> attribute is not set, only one single 
<code>&lt;option&gt;</code> of this 
<a href="/en-US/docs/Web/HTML/Element/select" title="The HTML select (<select>) element represents a control that presents a menu of options. The options within the menu are represented by <option> elements, which can be grouped by <optgroup> elements. Options can be pre-selected for the user."><code>&lt;select&gt;</code></a> element may have the 
<strong>selected</strong> attribute.
   */
  def selected: scala.Option[String] = attributes.get("selected").asInstanceOf[scala.Option[String]]
  /**
   * The content of this attribute represents the value to be submitted with the form, should this option be selected.&nbsp;If this attribute is omitted, the value is taken from the text content of the option element.
   */
  def value: scala.Option[String] = attributes.get("value").asInstanceOf[scala.Option[String]]
}
