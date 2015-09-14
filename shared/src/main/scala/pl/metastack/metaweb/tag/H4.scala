package pl.metastack.metaweb.tag

import pl.metastack.metarx._
import pl.metastack.metaweb.state

/**
 * <strong>Heading</strong> elements implement six levels of document headings, <code>&lt;h1&gt;</code> is the most important and <code>&lt;h6&gt;</code> is the least. A heading element briefly describes the topic of the section it introduces. Heading information may be used by user agents, for example, to construct a table of contents for a document automatically.
 */
class H4 extends state.Tag("h4") with HTMLTag {
}
