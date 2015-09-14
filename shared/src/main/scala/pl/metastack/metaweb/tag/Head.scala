package pl.metastack.metaweb.tag

import pl.metastack.metarx._
import pl.metastack.metaweb.state

/**
 * The <em>HTML Head Element</em> (<strong>&lt;head&gt;</strong>) provides general information (metadata) about the document, including its title and links to or definitions of scripts and style sheets
 */
class Head extends state.Tag("head") with HTMLTag {
  /**
   * The URIs of one or more metadata profiles, separated by white space.
   */
  def profile: StateChannel[String] = attribute("profile").asInstanceOf[StateChannel[String]]
}
