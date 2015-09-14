package pl.metastack.metaweb.tag

import pl.metastack.metarx._
import pl.metastack.metaweb.state

/**
 * The <strong>HTML<em> </em><code>&lt;progress&gt;</code> Element</strong> is used to view the completion progress of a task. While the specifics of how it's displayed is left up to the browser developer, it's typically displayed as a progress bar. Javascript can be used to manipulate the value of progress bar.
 */
class Progress extends state.Tag("progress") with HTMLTag {
  /**
   * This attribute describes how much work the task indicated by the 
<code>progress</code> element requires. The 
<code>max</code> attribute, if present, must have a value greater than zero and be a valid floating point number.
   */
  def max: StateChannel[String] = attribute("max").asInstanceOf[StateChannel[String]]
  /**
   * This attribute specifies how much of the task that has been completed. It must be a valid floating point number between 0 and 
<code>max</code>, or between 0 and 1 if 
<code>max</code> is omitted. If there is no 
<code>value</code> attribute, the progress bar is indeterminate; this indicates that an activity is ongoing with no indication of how long it is expected to take.
   */
  def value: StateChannel[String] = attribute("value").asInstanceOf[StateChannel[String]]
}
