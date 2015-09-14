package pl.metastack.metaweb.tag

import pl.metastack.metarx._
import pl.metastack.metaweb.state

/**
 * This element includes the <a href="https://developer.mozilla.org/en-US/docs/HTML/Global_attributes">global attributes</a>.
<dt>
 <strong id="attr-height"><code>height</code></strong>
</dt> 
<dd>
 The height of the coordinate space in CSS pixels. Defaults to 150.
</dd> 
<dt>
 <strong id="attr-moz-opaque"><code>moz-opaque</code></strong> 
 <span title="This API has not been standardized."><i class="icon-warning-sign"> </i></span>
</dt> 
<dd>
 Lets the canvas know whether or not translucency will be a factor. If the canvas knows there's no translucency, painting performance can be optimized.
</dd> 
<dt>
 <strong id="attr-width"><code>width</code></strong>
</dt> 
<dd>
 The width of the coordinate space in CSS pixels. Defaults to 300.
</dd>
 */
class Canvas extends state.Tag("canvas") with HTMLTag {
  /**
   * The height of the coordinate space in CSS pixels. Defaults to 150.
   */
  def height: StateChannel[String] = attribute("height").asInstanceOf[StateChannel[String]]
  /**
   * Lets the canvas know whether or not translucency will be a factor. If the canvas knows there's no translucency, painting performance can be optimized.
   */
  def `moz-opaque`: StateChannel[String] = attribute("moz-opaque").asInstanceOf[StateChannel[String]]
  /**
   * The width of the coordinate space in CSS pixels. Defaults to 300.
   */
  def width: StateChannel[String] = attribute("width").asInstanceOf[StateChannel[String]]
}
