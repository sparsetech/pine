package pl.metastack.metaweb.tag

import pl.metastack.metarx._
import pl.metastack.metaweb.state

/**
 * The&nbsp;<em>HTML Description Element</em>&nbsp;(<strong>&lt;dd&gt;</strong>) indicates the description of a term in a description list (<a href="/en-US/docs/Web/HTML/Element/dl" title="The HTML <dl> Element (or HTML Description List Element) encloses a list of pairs of terms and descriptions. Common uses for this element are to implement a glossary or to display metadata (a list of key-value pairs)."><code>&lt;dl&gt;</code></a>) element. This element can occur only as a child element of a definition list and it must follow a <a href="/en-US/docs/Web/HTML/Element/dt" title="The HTML <dt> element (or HTML Definition Term Element) identifies a term in a definition list. This element can occur only as a child element of a <dl>. It is usually followed by a <dd> element; however, multiple <dt> elements in a row indicate several terms that are all defined by the immediate next <dd> element."><code>&lt;dt&gt;</code></a> element.
 */
class Dd extends state.Tag("dd") with HTMLTag {
  /**
   * If the value of this attribute is set to 
<code>yes</code>, the definition text will not wrap. The default value is 
<code>no</code>.
   */
  def nowrap: StateChannel[String] = attribute("nowrap").asInstanceOf[StateChannel[String]]
}
