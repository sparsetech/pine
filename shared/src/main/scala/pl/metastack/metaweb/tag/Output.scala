package pl.metastack.metaweb.tag

import pl.metastack.metarx._
import pl.metastack.metaweb.state

/**
 * The <strong>HTML <code>&lt;output&gt;</code> element</strong> represents the result of a calculation or user action.
 */
class Output extends state.Tag("output") with HTMLTag {
  /**
   * A list of IDs of other elements, indicating that those elements contributed input values to (or otherwise affected) the calculation.
   */
  def `for`: StateChannel[String] = attribute("for").asInstanceOf[StateChannel[String]]
  /**
   * The form element that this element is associated with (its "form owner"). The value of the attribute must be an ID of a form element in the same document. If this attribute is not specified, the output element must be a descendant of a form element. This attribute enables you to place output elements anywhere within a document, not just as descendants of their form elements.
   */
  def form: StateChannel[state.Node] = attribute("form").asInstanceOf[StateChannel[state.Node]]
  /**
   * The name of the element.
   */
  def name: StateChannel[String] = attribute("name").asInstanceOf[StateChannel[String]]
}
