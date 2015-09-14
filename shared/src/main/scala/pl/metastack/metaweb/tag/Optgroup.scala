package pl.metastack.metaweb.tag

import pl.metastack.metarx._
import pl.metastack.metaweb.state

/**
 * In a Web form, the <strong>HTML <code>&lt;optgroup&gt;</code> element</strong>&nbsp; creates a grouping of options within a <a href="/en-US/docs/Web/HTML/Element/select" title="The HTML select (<select>) element represents a control that presents a menu of options. The options within the menu are represented by <option> elements, which can be grouped by <optgroup> elements. Options can be pre-selected for the user."><code>&lt;select&gt;</code></a> element.

<strong>Note:</strong>&nbsp;Optgroup elements may not be nested.

 */
class Optgroup extends state.Tag("optgroup") with HTMLTag {
  /**
   * If this Boolean attribute is set, none of the items in this option group is selectable. Often browsers grey out such control and it won't receive any browsing events, like mouse clicks or focus-related ones.
   */
  def disabled: StateChannel[Boolean] = attribute("disabled").asInstanceOf[StateChannel[Boolean]]
  /**
   * The name of the group of options, which the browser can use when labeling the options in the user interface. This attribute is mandatory if this element is used.
   */
  def label: StateChannel[String] = attribute("label").asInstanceOf[StateChannel[String]]
}
