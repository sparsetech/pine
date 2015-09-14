package pl.metastack.metaweb.tag

import pl.metastack.metarx._
import pl.metastack.metaweb.state

/**
 * The <strong>HTML <code>&lt;noscript&gt;</code> Element</strong> defines a section of html to be inserted if a script type on the page is unsupported or if scripting is currently turned off in the browser.
 */
class Noscript extends state.Tag("noscript") with HTMLTag {
}
