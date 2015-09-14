package pl.metastack.metaweb.tag

import pl.metastack.metarx._
import pl.metastack.metaweb.state

/**
 * The&nbsp;<em>HTML Deleted Text Element</em>&nbsp;(<strong>&lt;del&gt;</strong>) represents a range of text that has been deleted from a document. This element is often (but need not be) rendered with strike-through text.
 */
class Del extends state.Tag("del") with HTMLTag {
  /**
   * A URI for a resource that explains the change (for example, meeting minutes).
   */
  def cite: StateChannel[String] = attribute("cite").asInstanceOf[StateChannel[String]]
  /**
   * This attribute indicates the time and date of the change and must be a 
<a href="http://www.w3.org/TR/html5/infrastructure.html#valid-date-string-with-optional-time" class="external" title="http://www.w3.org/TR/html5/common-microsyntaxes.html#valid-date-string-with-optional-time">valid date with an optional time string</a>. If the value cannot be parsed as a date with an optional time string, the element does not have an associated time stamp.
   */
  def datetime: StateChannel[String] = attribute("datetime").asInstanceOf[StateChannel[String]]
}
