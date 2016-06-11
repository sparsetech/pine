package pl.metastack.metaweb.tag

import pl.metastack.metaweb.tree

/**
 * The<em> </em><em>HTML Label&nbsp;Element</em> (<code><strong>&lt;label&gt;</strong></code>) represents a caption for an item in a user interface. It can be associated with a control either by placing the control element inside the <code>&lt;label&gt;</code> element, or by using the <code>for</code> attribute. Such a control is called the <em>labeled control</em> of the label element.
 */
case class Label(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[tree.Node] = Seq.empty) extends tree.Tag with HTMLTag {
  override def tagName = "label"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[tree.Node] = children): Label = Label(attributes, children)
  /**
   * The ID of a labelable form-related element in the same document as the label element. The first such element in the document with an ID matching the value of the 
<code>for</code> attribute is the 
<em>labeled control </em>for this label element. 
<div class="note">
 <strong>Note:</strong> A label element can have both a 
 <code>for</code> attribute and a contained control element, as long as the 
 <code>for</code> attribute points to the contained control element.
</div>
   */
  def `for`: scala.Option[String] = attributes.get("for").asInstanceOf[scala.Option[String]]
  /**
   * The form element that the label element is associated with (its 
<em>form owner</em>). If specified, the value of the attribute must be the ID of a 
<a href="/en-US/docs/Web/HTML/Element/form" title="The HTML <form> element represents a document section that contains interactive controls to submit information to a web server."><code>&lt;form&gt;</code></a> element in the same document. This attribute enables you to place label elements anywhere within a document, not just as descendants of their form elements.
   */
  def form: scala.Option[tree.Node] = attributes.get("form").asInstanceOf[scala.Option[tree.Node]]
}
