package pl.metastack.metaweb.tag

import pl.metastack.metarx._
import pl.metastack.metaweb.state

/**
 * The HTML Small Element (<span style="font-family: Courier New;">&lt;small&gt;</span>) makes the text <em>font size</em> one size smaller (for example, from large to medium, or from small to x-small) down to the browser's minimum font size.&nbsp; In HTML5, this element is repurposed to represent side-comments and small print, including copyright and legal text, independent of its styled presentation.
 */
class Small extends state.Tag("small") with HTMLTag {
}
