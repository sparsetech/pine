package pl.metastack.metaweb.tag

import pl.metastack.metarx._
import pl.metastack.metaweb.state

/**
 * <span class="seoSummary">The <strong><a href="/en-US/docs/Web/HTML">HTML</a> template element <code>&lt;template&gt;</code></strong> is a mechanism for holding client-side content that is not to be rendered when a page is loaded but may subsequently be instantiated during runtime using JavaScript.&nbsp;</span>
Think of a template as a content fragment that is being stored for subsequent use in the document. While the parser does process the contents of the <strong><code>&lt;template&gt;</code> </strong>element while loading the page, it does so only to ensure that those contents are valid; the element's contents are not rendered, however.
 */
class Template extends state.Tag("template") with HTMLTag {
}
