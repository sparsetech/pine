package pl.metastack.metaweb.tag

import pl.metastack.metarx._
import pl.metastack.metaweb.state

/**
 * The <strong>HTML <code>&lt;ins&gt;</code> Element</strong> (or <em>HTML Inserted Text</em>) HTML represents a range of text that has been added to a document.
 */
class Ins extends state.Tag("ins") with HTMLTag {
  /**
   * This attribute defines the URI of a resource that explains the change, like a link to some meeting minutes or a ticket in a troubleshooting sytem.
   */
  def cite: StateChannel[String] = attribute("cite").asInstanceOf[StateChannel[String]]
  /**
   * This attribute indicates the time and date of the change and must be a 
<a class="external" href="http://www.w3.org/TR/2011/WD-html5-20110525/common-microsyntaxes.html#valid-date-string-with-optional-time" title="http://www.w3.org/TR/html5/common-microsyntaxes.html#valid-date-string-with-optional-time">valid date with an optional time string</a>. If the value cannot be parsed as a date with an optional time string, the element does not have an associated time stamp.
   */
  def datetime: StateChannel[String] = attribute("datetime").asInstanceOf[StateChannel[String]]
}
