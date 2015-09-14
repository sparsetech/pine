package pl.metastack.metaweb.tag

import pl.metastack.metarx._
import pl.metastack.metaweb.state

/**
 * The <em>HTML Title Element</em> (<strong>&lt;title&gt;</strong>) defines the title of the document, shown in a browser's title bar or on the page's tab. It can only contain text and any contained tags are not interpreted.
 */
class Title extends state.Tag("title") with HTMLTag {
}
