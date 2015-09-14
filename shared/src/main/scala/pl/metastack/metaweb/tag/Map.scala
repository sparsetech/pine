package pl.metastack.metaweb.tag

import pl.metastack.metarx._
import pl.metastack.metaweb.state

/**
 * This element includes the <a href="https://developer.mozilla.org/en-US/docs/HTML/Global_attributes">global attributes</a>.
<dt>
 <strong id="attr-name"><code>name</code></strong>
</dt> 
<dd>
 The name attribute gives the map a name so that it can be referenced. The attribute must be present and must have a non-empty value with no space characters. The value of the name attribute must not be a compatibility-caseless match for the value of the name attribute of another map element in the same document. If the id attribute is also specified, both attributes must have the same value.
</dd>
 */
class Map extends state.Tag("map") with HTMLTag {
  /**
   * The name attribute gives the map a name so that it can be referenced. The attribute must be present and must have a non-empty value with no space characters. The value of the name attribute must not be a compatibility-caseless match for the value of the name attribute of another map element in the same document. If the id attribute is also specified, both attributes must have the same value.
   */
  def name: StateChannel[String] = attribute("name").asInstanceOf[StateChannel[String]]
}
