package pl.metastack.metaweb.tag

import pl.metastack.metaweb._

/**
 * The <strong>HTML <code>&lt;param&gt;</code> Element</strong> (or <em>HTML Parameter Element)</em> defines parameters for <a href="/en-US/docs/Web/HTML/Element/object" title="The HTML <object> Element (or HTML Embedded Object Element) represents an external resource, which can be treated as an image, a nested browsing context, or a resource to be handled by a plugin."><code>&lt;object&gt;</code></a>.
 */
case class Param(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[Node] = Seq.empty) extends HTMLTag {
  override type T = Param
  override def tagName = "param"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[Node] = children): Param = Param(attributes, children)
  /**
   * Name of the parameter.
   */
  def name: scala.Option[String] = attributes.get("name").asInstanceOf[scala.Option[String]]
  def name(value: String): Param = copy(attributes = attributes + ("name" -> value))
  /**
   * Only used if the 
<code>valuetype</code> is set to "ref". Specifies the MIME type of values found at the URI specified by value.
   */
  def `type`: scala.Option[String] = attributes.get("type").asInstanceOf[scala.Option[String]]
  def `type`(value: String): Param = copy(attributes = attributes + ("type" -> value))
  /**
   * Specifies the value of the parameter.
   */
  def value: scala.Option[String] = attributes.get("value").asInstanceOf[scala.Option[String]]
  def value(value: String): Param = copy(attributes = attributes + ("value" -> value))
  /**
   * Specifies the type of the 
<code>value</code> attribute. Possible values are: 
<ul> 
 <li>data: Default value. The value is passed to the object's implementation as a string.</li> 
 <li>ref: The value is a URI to a resource where run-time values are stored.</li> 
 <li>object: An ID of another <a href="/en-US/docs/Web/HTML/Element/object" title="The HTML <object> Element (or HTML Embedded Object Element) represents an external resource, which can be treated as an image, a nested browsing context, or a resource to be handled by a plugin."><code>&lt;object&gt;</code></a> in the same document.</li> 
</ul>
   */
  def valuetype: scala.Option[String] = attributes.get("valuetype").asInstanceOf[scala.Option[String]]
  def valuetype(value: String): Param = copy(attributes = attributes + ("valuetype" -> value))
}
