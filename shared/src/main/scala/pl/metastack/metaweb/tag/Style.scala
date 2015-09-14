package pl.metastack.metaweb.tag

import pl.metastack.metarx._
import pl.metastack.metaweb.state

/**
 * The <em>HTML Style Element</em> (<strong>&lt;style&gt;</strong>) contains style information for a document, or part of a document. By default, the style instructions written inside that element are expected to be <a href="/en-US/docs/Web/CSS">CSS</a>.
 */
class Style extends state.Tag("style") with HTMLTag {
  /**
   * This attribute defines the styling language as a MIME type (charset should not be specified). This attribute is optional and default to 
<code>text/css</code> if it's missing.
   */
  def `type`: StateChannel[String] = attribute("type").asInstanceOf[StateChannel[String]]
  /**
   * Which media should this style apply to. It's value is a 
<a href="/en-US/docs/Web/Guide/CSS/Media_queries">media query</a>, which default to 
<code>all</code> if the attribute is missing.
   */
  def media: StateChannel[String] = attribute("media").asInstanceOf[StateChannel[String]]
  /**
   * If this attribute is present, then the style applies only to its parent element. If absent, the style applies to the whole document.
   */
  def scoped: StateChannel[String] = attribute("scoped").asInstanceOf[StateChannel[String]]
  /**
   * If set, disables (does not apply) the style rules,&nbsp;specified within the element, to the 
<a href="/en-US/docs/Web/API/Document" title="Each web page loaded in the browser has its own document object. The Document interface serves as an entry point into the web page's content (the DOM tree, including elements such as <body> and <table>) and provides functionality which is global to the document (such as obtaining the page's URL and creating new elements in the document)."><code>Document</code></a>.
   */
  def disabled: StateChannel[String] = attribute("disabled").asInstanceOf[StateChannel[String]]
}
