package pl.metastack.metaweb.tag

import pl.metastack.metaweb.tree

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
case class Fieldset(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[tree.Node] = Seq.empty) extends HTMLTag[Fieldset] {
  override def tagName = "fieldset"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[tree.Node] = children): Fieldset = Fieldset(attributes, children)
  /**
   * If this Boolean attribute is set, the form controls that are its descendants, except descendants of its first optional 
<a href="/en-US/docs/Web/HTML/Element/legend" title="The HTML <legend> Element (or HTML Legend Field Element) represents a caption for the content of its parent <fieldset>."><code>&lt;legend&gt;</code></a> element, are disabled, i.e., not editable. They won't receive any browsing events, like mouse clicks or focus-related ones. Often browsers display such controls as gray.
   */
  def disabled: scala.Option[String] = attributes.get("disabled").asInstanceOf[scala.Option[String]]
  def disabled(value: String): Fieldset = copy(attributes = attributes + ("disabled" -> value)).asInstanceOf[Fieldset]
  /**
   * This attribute has the value of the 
<strong>id </strong>attribute of the 
<a href="/en-US/docs/Web/HTML/Element/form" title="The HTML <form> element represents a document section that contains interactive controls to submit information to a web server."><code>&lt;form&gt;</code></a> element its related to. Its default value is the 
<strong>id</strong> of the nearest 
<a href="/en-US/docs/Web/HTML/Element/form" title="The HTML <form> element represents a document section that contains interactive controls to submit information to a web server."><code>&lt;form&gt;</code></a> element it is a descendant of.
   */
  def form: scala.Option[String] = attributes.get("form").asInstanceOf[scala.Option[String]]
  def form(value: String): Fieldset = copy(attributes = attributes + ("form" -> value)).asInstanceOf[Fieldset]
  /**
   * The name associated with the group, which is submitted with the form data. 
<div class="note">
 The label for the field set is given by the first 
 <a href="/en-US/docs/Web/HTML/Element/legend" title="The HTML <legend> Element (or HTML Legend Field Element) represents a caption for the content of its parent <fieldset>."><code>&lt;legend&gt;</code></a> element that is a child of this field set.
</div>
   */
  def name: scala.Option[String] = attributes.get("name").asInstanceOf[scala.Option[String]]
  def name(value: String): Fieldset = copy(attributes = attributes + ("name" -> value)).asInstanceOf[Fieldset]
}
