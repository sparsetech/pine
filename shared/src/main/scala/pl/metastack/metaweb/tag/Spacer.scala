package pl.metastack.metaweb.tag

import pl.metastack.metarx._
import pl.metastack.metaweb.state

/**
 * <code>&lt;spacer&gt;</code> is an HTML element which is used for inserting white spaces to web pages. It was created by NetScape for achieving same effect as a single-pixel layout GIF image, which was something web designers used to use to add white spaces to web pages, without actually using a GIF. However <code>&lt;spacer&gt; </code>is not supported by any major browser and same effects can be created with various CSS rules. In Mozilla applications, support for this element was removed in <span title="(Firefox 4 / Thunderbird 3.3 / SeaMonkey 2.1)">Gecko&nbsp;2.0</span>. Therefore usage of <code>&lt;spacer&gt;</code> is unnecessary.
 */
class Spacer extends state.Tag("spacer") with HTMLTag {
  /**
   * This attribute determines type of spacer. Possible values are 
<code>horizontal</code>, 
<code>vertical</code> and 
<code>block</code>.
   */
  def `type`: StateChannel[String] = attribute("type").asInstanceOf[StateChannel[String]]
  /**
   * This attribute can be used for defining size of spacer in pixels when type is 
<code>horizontal</code> or 
<code>vertical</code>.
   */
  def size: StateChannel[String] = attribute("size").asInstanceOf[StateChannel[String]]
  /**
   * This attribute can be used for defining width of spacer in pixels when type is 
<code>block</code>.
   */
  def width: StateChannel[String] = attribute("width").asInstanceOf[StateChannel[String]]
  /**
   * This attribute can be used for defining height of spacer in pixels when type is 
<code>block</code>.
   */
  def height: StateChannel[String] = attribute("height").asInstanceOf[StateChannel[String]]
  /**
   * This attribute determines alignment of spacer. Possible values are 
<code>left</code>, 
<code>right</code> and 
<code>center</code>.
   */
  def align: StateChannel[String] = attribute("align").asInstanceOf[StateChannel[String]]
}
