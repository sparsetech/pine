package pl.metastack.metaweb.tag

import pl.metastack.metarx._
import pl.metastack.metaweb.state

/**
 * The <strong>HTML <code>&lt;dialog&gt;</code> element</strong> represents a dialog box or other interactive component, such as an inspector or window. <code>&lt;form&gt;</code> elements can be integrated within a dialog by specifying them with the attribute <code>method="dialog"</code>. When such a form is submitted, the dialog is closed with a <code>returnValue</code> attribute set to the <code>value</code> of the submit button used.
The <a href="/en-US/docs/Web/CSS/::backdrop" title="Each element in the top layer's stack has a ::backdrop pseudo-element. This pseudo-element is a box rendered immediately below the element (and above the element below the element in the stack, if any), within the same top layer."><code>::backdrop</code></a> CSS pseudo-element can be used to style behind a <code>&lt;dialog&gt;</code> element, for example to dim inaccessible content whilst a modal dialog is active.
 */
class Dialog extends state.Tag("dialog") with HTMLTag {
  /**
   * Indicates that the dialog is active and available for interaction. When the open attribute is not set, it shouldn't be shown to the user.
   */
  def open: StateChannel[Boolean] = attribute("open").asInstanceOf[StateChannel[Boolean]]
}
