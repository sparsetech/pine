package pl.metastack.metaweb.tag

import pl.metastack.metarx._
import pl.metastack.metaweb.state

/**
 * The <em>HTML Details&nbsp;Element</em>&nbsp;(<code><strong>&lt;details&gt;</strong></code>) is used as a disclosure widget from which the user can retrieve additional information.
 */
class Details extends state.Tag("details") with HTMLTag {
  /**
   * This Boolean attribute indicates whether the details will be shown to the user on page load. Default is 
<code>false</code> and so details will be hidden.
   */
  def open: StateChannel[String] = attribute("open").asInstanceOf[StateChannel[String]]
}
