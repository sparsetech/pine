package pl.metastack.metaweb.tag

import pl.metastack.metarx._
import pl.metastack.metaweb.state

/**
 * The <strong>HTML <code>&lt;param&gt;</code> Element</strong> (or <em>HTML Parameter Element)</em> defines parameters for <a href="/en-US/docs/Web/HTML/Element/object" title="The HTML <object> Element (or HTML Embedded Object Element) represents an external resource, which can be treated as an image, a nested browsing context, or a resource to be handled by a plugin."><code>&lt;object&gt;</code></a>.
 */
class Param extends state.Tag("param") with HTMLTag {
  /**
   * Name of the parameter.
   */
  def name: StateChannel[String] = attribute("name").asInstanceOf[StateChannel[String]]
  /**
   * Only used if the 
<code>valuetype</code> is set to "ref". Specifies the MIME type of values found at the URI specified by value.
   */
  def `type`: StateChannel[String] = attribute("type").asInstanceOf[StateChannel[String]]
  /**
   * Specifies the value of the parameter.
   */
  def value: StateChannel[String] = attribute("value").asInstanceOf[StateChannel[String]]
  /**
   * Specifies the type of the 
<code>value</code> attribute. Possible values are: 
<ul> 
 <li>data: Default value. The value is passed to the object's implementation as a string.</li> 
 <li>ref: The value is a URI to a resource where run-time values are stored.</li> 
 <li>object: An ID of another <a href="/en-US/docs/Web/HTML/Element/object" title="The HTML <object> Element (or HTML Embedded Object Element) represents an external resource, which can be treated as an image, a nested browsing context, or a resource to be handled by a plugin."><code>&lt;object&gt;</code></a> in the same document.</li> 
</ul>
   */
  def valuetype: StateChannel[String] = attribute("valuetype").asInstanceOf[StateChannel[String]]
}
