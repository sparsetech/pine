package pl.metastack.metaweb.tag

import pl.metastack.metarx._
import pl.metastack.metaweb.state

/**
 * The&nbsp;<em>HTML Embedded Object Element</em>&nbsp;(<strong>&lt;object&gt;</strong>) represents an external resource, which can be treated as an image, a nested browsing context, or a resource to be handled by a plugin.
 */
class Object extends state.Tag("object") with HTMLTag {
  /**
   * A space-separated list of URIs for archives of resources for the object.
   */
  def archive: StateChannel[String] = attribute("archive").asInstanceOf[StateChannel[String]]
  /**
   * The width of a border around the control, in pixels.
   */
  def border: StateChannel[String] = attribute("border").asInstanceOf[StateChannel[String]]
  /**
   * The URI of the object's implementation. It can be used together with, or in place of, the 
<strong>data</strong> attribute.
   */
  def classid: StateChannel[String] = attribute("classid").asInstanceOf[StateChannel[String]]
  /**
   * The base path used to resolve relative URIs specified by 
<strong>classid</strong>, 
<strong>data</strong>, or 
<strong>archive</strong>. If not specified, the default is the base URI of the current document.
   */
  def codebase: StateChannel[String] = attribute("codebase").asInstanceOf[StateChannel[String]]
  /**
   * The content type of the data specified by 
<strong>classid</strong>.
   */
  def codetype: StateChannel[String] = attribute("codetype").asInstanceOf[StateChannel[String]]
  /**
   * The address of the resource as a valid URL. At least one of 
<strong>data</strong> and 
<strong>type</strong> must be defined.
   */
  def data: StateChannel[String] = attribute("data").asInstanceOf[StateChannel[String]]
  /**
   * The presence of this Boolean attribute makes this element a declaration only. The object must be instantiated by a subsequent 
<code>&lt;object&gt;</code> element. In HTML5, repeat the &lt;object&gt; element completely each that that the resource is reused.
   */
  def declare: StateChannel[String] = attribute("declare").asInstanceOf[StateChannel[String]]
  /**
   * The form element, if any, that the object element is associated with (its 
<em>form owner</em>). The value of the attribute must be an ID of a 
<a href="/en-US/docs/Web/HTML/Element/form" title="The HTML <form> element represents a document section that contains interactive controls to submit information to a web server."><code>&lt;form&gt;</code></a> element in the same document.
   */
  def form: StateChannel[String] = attribute("form").asInstanceOf[StateChannel[String]]
  /**
   * The height of the displayed resource, in CSS pixels.
   */
  def height: StateChannel[String] = attribute("height").asInstanceOf[StateChannel[String]]
  /**
   * The name of valid browsing context (HTML5), or the name of the control (HTML 4).
   */
  def name: StateChannel[String] = attribute("name").asInstanceOf[StateChannel[String]]
  /**
   * A message that the browser can show while loading the object's implementation and data.
   */
  def standby: StateChannel[String] = attribute("standby").asInstanceOf[StateChannel[String]]
  /**
   * The 
<a href="/en-US/docs/Glossary/Content_type">content type</a> of the resource specified by 
<strong>data</strong>. At least one of 
<strong>data</strong> and 
<strong>type</strong> must be defined.
   */
  def `type`: StateChannel[String] = attribute("type").asInstanceOf[StateChannel[String]]
  /**
   * This Boolean attribute indicates if the 
<strong>type</strong> and the actual 
<a href="/en-US/docs/Glossary/Content_type">content type</a> resource must match in order of this one to be used.
   */
  def typemustmatch: StateChannel[String] = attribute("typemustmatch").asInstanceOf[StateChannel[String]]
  /**
   * A hash-name reference to a 
<a href="/en-US/docs/Web/HTML/Element/map" title="The HTML <map> element is used with <area> elements to define an image map (a clickable link area)."><code>&lt;map&gt;</code></a> element; that is a '#' followed by the value of a 
<code><a href="/en-US/docs/Web/HTML/Element/map#attr-name">name</a></code> of a map element.
   */
  def usemap: StateChannel[String] = attribute("usemap").asInstanceOf[StateChannel[String]]
  /**
   * The width of the display resource, in CSS pixels.
   */
  def width: StateChannel[String] = attribute("width").asInstanceOf[StateChannel[String]]
}
