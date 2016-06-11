package pl.metastack.metaweb.tag

import pl.metastack.metaweb.tree

/**
 * The&nbsp;<em>HTML Embedded Object Element</em>&nbsp;(<strong>&lt;object&gt;</strong>) represents an external resource, which can be treated as an image, a nested browsing context, or a resource to be handled by a plugin.
 */
case class Object(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[tree.Node] = Seq.empty) extends tree.Tag with HTMLTag {
  override def tagName = "object"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[tree.Node] = children): Object = Object(attributes, children)
  /**
   * A space-separated list of URIs for archives of resources for the object.
   */
  def archive: scala.Option[String] = attributes.get("archive").asInstanceOf[scala.Option[String]]
  /**
   * The width of a border around the control, in pixels.
   */
  def border: scala.Option[String] = attributes.get("border").asInstanceOf[scala.Option[String]]
  /**
   * The URI of the object's implementation. It can be used together with, or in place of, the 
<strong>data</strong> attribute.
   */
  def classid: scala.Option[String] = attributes.get("classid").asInstanceOf[scala.Option[String]]
  /**
   * The base path used to resolve relative URIs specified by 
<strong>classid</strong>, 
<strong>data</strong>, or 
<strong>archive</strong>. If not specified, the default is the base URI of the current document.
   */
  def codebase: scala.Option[String] = attributes.get("codebase").asInstanceOf[scala.Option[String]]
  /**
   * The content type of the data specified by 
<strong>classid</strong>.
   */
  def codetype: scala.Option[String] = attributes.get("codetype").asInstanceOf[scala.Option[String]]
  /**
   * The address of the resource as a valid URL. At least one of 
<strong>data</strong> and 
<strong>type</strong> must be defined.
   */
  def data: scala.Option[String] = attributes.get("data").asInstanceOf[scala.Option[String]]
  /**
   * The presence of this Boolean attribute makes this element a declaration only. The object must be instantiated by a subsequent 
<code>&lt;object&gt;</code> element. In HTML5, repeat the &lt;object&gt; element completely each that that the resource is reused.
   */
  def declare: scala.Option[String] = attributes.get("declare").asInstanceOf[scala.Option[String]]
  /**
   * The form element, if any, that the object element is associated with (its 
<em>form owner</em>). The value of the attribute must be an ID of a 
<a href="/en-US/docs/Web/HTML/Element/form" title="The HTML <form> element represents a document section that contains interactive controls to submit information to a web server."><code>&lt;form&gt;</code></a> element in the same document.
   */
  def form: scala.Option[String] = attributes.get("form").asInstanceOf[scala.Option[String]]
  /**
   * The height of the displayed resource, in CSS pixels.
   */
  def height: scala.Option[String] = attributes.get("height").asInstanceOf[scala.Option[String]]
  /**
   * The name of valid browsing context (HTML5), or the name of the control (HTML 4).
   */
  def name: scala.Option[String] = attributes.get("name").asInstanceOf[scala.Option[String]]
  /**
   * A message that the browser can show while loading the object's implementation and data.
   */
  def standby: scala.Option[String] = attributes.get("standby").asInstanceOf[scala.Option[String]]
  /**
   * The 
<a href="/en-US/docs/Glossary/Content_type">content type</a> of the resource specified by 
<strong>data</strong>. At least one of 
<strong>data</strong> and 
<strong>type</strong> must be defined.
   */
  def `type`: scala.Option[String] = attributes.get("type").asInstanceOf[scala.Option[String]]
  /**
   * This Boolean attribute indicates if the 
<strong>type</strong> and the actual 
<a href="/en-US/docs/Glossary/Content_type">content type</a> resource must match in order of this one to be used.
   */
  def typemustmatch: scala.Option[String] = attributes.get("typemustmatch").asInstanceOf[scala.Option[String]]
  /**
   * A hash-name reference to a 
<a href="/en-US/docs/Web/HTML/Element/map" title="The HTML <map> element is used with <area> elements to define an image map (a clickable link area)."><code>&lt;map&gt;</code></a> element; that is a '#' followed by the value of a 
<code><a href="/en-US/docs/Web/HTML/Element/map#attr-name">name</a></code> of a map element.
   */
  def usemap: scala.Option[String] = attributes.get("usemap").asInstanceOf[scala.Option[String]]
  /**
   * The width of the display resource, in CSS pixels.
   */
  def width: scala.Option[String] = attributes.get("width").asInstanceOf[scala.Option[String]]
}
