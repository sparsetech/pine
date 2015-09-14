package pl.metastack.metaweb.tag

import pl.metastack.metarx._
import pl.metastack.metaweb.state

/**
 * <code>&lt;isindex&gt;</code> is an HTML element which is used for putting a text field in the document for querying document. <code>&lt;isindex&gt;</code> is intented to use inside of <a href="/en-US/docs/Web/HTML/Element/head" title="The HTML <head> element represents a collection of metadata about the document, including links to or definitions of scripts and style sheets"><code>&lt;head&gt;</code></a> element by W3C, however browsers provide support wherever it is used in the document.
This element deprecated in HTML 4.01. Because, it is not a good idea to use <code>&lt;isindex&gt;</code> for any purpose. Same effect can be created with a HTML form in a modern way.
 */
class Isindex extends state.Tag("isindex") with HTMLTag {
  /**
   * This attribute adds its value as a prompt for text field.
   */
  def prompt: StateChannel[String] = attribute("prompt").asInstanceOf[StateChannel[String]]
  /**
   * This attribute can be used in the case of needing to send query to a different URL. Action is not defined by W3C.
   */
  def action: StateChannel[String] = attribute("action").asInstanceOf[StateChannel[String]]
}
