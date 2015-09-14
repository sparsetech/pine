package pl.metastack.metaweb.tag

import pl.metastack.metarx._
import pl.metastack.metaweb.state

/**
 * This element includes the <a href="/en-US/docs/HTML/Global_attributes">global attributes</a>.
<dt>
 <strong id="attr-disabled"><code>disabled</code></strong> 
 <span class="inlineIndicator htmlVer htmlVerInline"><a href="/en-US/docs/HTML/HTML5">HTML5</a></span>
</dt> 
<dd>
 If this Boolean attribute is set, the form controls that are its descendants, except descendants of its first optional 
 <a href="/en-US/docs/Web/HTML/Element/legend" title="The HTML <legend> Element (or HTML Legend Field Element) represents a caption for the content of its parent <fieldset>."><code>&lt;legend&gt;</code></a> element, are disabled, i.e., not editable. They won't receive any browsing events, like mouse clicks or focus-related ones. Often browsers display such controls as gray.
</dd> 
<dt>
 <strong id="attr-form"><code>form</code></strong> 
 <span class="inlineIndicator htmlVer htmlVerInline"><a href="/en-US/docs/HTML/HTML5">HTML5</a></span>
</dt> 
<dd>
 This attribute has the value of the 
 <strong>id </strong>attribute of the 
 <a href="/en-US/docs/Web/HTML/Element/form" title="The HTML <form> element represents a document section that contains interactive controls to submit information to a web server."><code>&lt;form&gt;</code></a> element its related to. Its default value is the 
 <strong>id</strong> of the nearest 
 <a href="/en-US/docs/Web/HTML/Element/form" title="The HTML <form> element represents a document section that contains interactive controls to submit information to a web server."><code>&lt;form&gt;</code></a> element it is a descendant of.
</dd> 
<dt>
 <strong id="attr-name"><code>name</code></strong> 
 <span class="inlineIndicator htmlVer htmlVerInline"><a href="/en-US/docs/HTML/HTML5">HTML5</a></span>
</dt> 
<dd>
 The name associated with the group, which is submitted with the form data. 
 <div class="note">
  The label for the field set is given by the first 
  <a href="/en-US/docs/Web/HTML/Element/legend" title="The HTML <legend> Element (or HTML Legend Field Element) represents a caption for the content of its parent <fieldset>."><code>&lt;legend&gt;</code></a> element that is a child of this field set.
 </div> 
</dd>
 */
class Fieldset extends state.Tag("fieldset") with HTMLTag {
  /**
   * If this Boolean attribute is set, the form controls that are its descendants, except descendants of its first optional 
<a href="/en-US/docs/Web/HTML/Element/legend" title="The HTML <legend> Element (or HTML Legend Field Element) represents a caption for the content of its parent <fieldset>."><code>&lt;legend&gt;</code></a> element, are disabled, i.e., not editable. They won't receive any browsing events, like mouse clicks or focus-related ones. Often browsers display such controls as gray.
   */
  def disabled: StateChannel[String] = attribute("disabled").asInstanceOf[StateChannel[String]]
  /**
   * This attribute has the value of the 
<strong>id </strong>attribute of the 
<a href="/en-US/docs/Web/HTML/Element/form" title="The HTML <form> element represents a document section that contains interactive controls to submit information to a web server."><code>&lt;form&gt;</code></a> element its related to. Its default value is the 
<strong>id</strong> of the nearest 
<a href="/en-US/docs/Web/HTML/Element/form" title="The HTML <form> element represents a document section that contains interactive controls to submit information to a web server."><code>&lt;form&gt;</code></a> element it is a descendant of.
   */
  def form: StateChannel[String] = attribute("form").asInstanceOf[StateChannel[String]]
  /**
   * The name associated with the group, which is submitted with the form data. 
<div class="note">
 The label for the field set is given by the first 
 <a href="/en-US/docs/Web/HTML/Element/legend" title="The HTML <legend> Element (or HTML Legend Field Element) represents a caption for the content of its parent <fieldset>."><code>&lt;legend&gt;</code></a> element that is a child of this field set.
</div>
   */
  def name: StateChannel[String] = attribute("name").asInstanceOf[StateChannel[String]]
}
