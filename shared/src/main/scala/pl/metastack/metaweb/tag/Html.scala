package pl.metastack.metaweb.tag

import pl.metastack.metarx._
import pl.metastack.metaweb.state

/**
 * The <em>HTML Root Element</em> (<strong><code>&lt;html&gt;</code></strong>) represents the root of an HTML document. All other elements must be descendants of this element.
 */
class Html extends state.Tag("html") with HTMLTag {
  /**
   * Specifies the URI of a resource manifest indicating resources that should be cached locally. See 
<a href="/en-US/docs/HTML/Using_the_application_cache" title="/en-US/docs/HTML/Using_the_application_cache">Using the application cache</a> for details.
   */
  def manifest: StateChannel[String] = attribute("manifest").asInstanceOf[StateChannel[String]]
  /**
   * Specifies the version of the HTML&nbsp;Document Type Definition that governs the current document. This attribute is not needed, because it is redundant with the version information in the document type declaration.
   */
  def version: StateChannel[String] = attribute("version").asInstanceOf[StateChannel[String]]
  /**
   * Specifies the XML Namespace of the document. Default value is "http://www.w3.org/1999/xhtml". This is required in XHTML, and optional in HTML5.
   */
  def xmlns: StateChannel[String] = attribute("xmlns").asInstanceOf[StateChannel[String]]
}
