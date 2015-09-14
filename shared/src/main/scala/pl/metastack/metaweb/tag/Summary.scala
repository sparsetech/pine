package pl.metastack.metaweb.tag

import pl.metastack.metarx._
import pl.metastack.metaweb.state

/**
 * The HTML <em>summary </em>element (<code>&lt;summary&gt;</code>) is used as a summary, caption, or legend for the content of a <a href="/en-US/docs/Web/HTML/Element/details" title="The HTML Details&nbsp;Element&nbsp;(<details>) is used as a disclosure widget from which the user can retrieve additional information."><code>&lt;details&gt;</code></a> element.
<strong>Note:</strong> If the 
<code>&lt;summary&gt;</code> element is omitted, the heading "details" will be used.
 */
class Summary extends state.Tag("summary") with HTMLTag {
}
