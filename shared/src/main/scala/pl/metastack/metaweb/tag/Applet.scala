package pl.metastack.metaweb.tag

import pl.metastack.metarx._
import pl.metastack.metaweb.state

/**
 * The HTML Applet Element (<code>&lt;applet&gt;</code>) identifies the inclusion of a Java applet.
<p><strong>Usage note: </strong>This element has been removed in HTML5 and shouldn't be used anymore. Instead web developers should use the more generic <a href="/en-US/docs/Web/HTML/Element/object" title="The&nbsp;HTML Embedded Object Element&nbsp;(<object>) represents an external resource, which can be treated as an image, a nested browsing context, or a resource to be handled by a plugin."><code>&lt;object&gt;</code></a> element.</p>
 */
class Applet extends state.Tag("applet") with HTMLTag {
  /**
   * This attribute is used to position the applet on the page relative to content that might flow around it. The HTML 4.01 specification defines values of bottom, left, middle, right, and top, whereas Microsoft and Netscape also might support 
<strong>absbottom</strong>, 
<strong>absmiddle</strong>, 
<strong>baseline</strong>, 
<strong>center</strong>, and 
<strong>texttop</strong>.
   */
  def align: StateChannel[String] = attribute("align").asInstanceOf[StateChannel[String]]
  /**
   * This attribute causes a descriptive text alternate to be displayed on browsers that do not support Java. Page designers should also remember that content enclosed within the 
<code>&lt;applet&gt;</code> element may also be rendered as alternative text.
   */
  def alt: StateChannel[String] = attribute("alt").asInstanceOf[StateChannel[String]]
  /**
   * This attribute refers to an archived or compressed version of the applet and its associated class files, which might help reduce download time.
   */
  def archive: StateChannel[String] = attribute("archive").asInstanceOf[StateChannel[String]]
  /**
   * This attribute specifies the URL of the applet's class file to be loaded and executed. Applet filenames are identified by a .class filename extension. The URL specified by code might be relative to the 
<code>codebase</code> attribute.
   */
  def code: StateChannel[String] = attribute("code").asInstanceOf[StateChannel[String]]
  /**
   * This attribute gives the absolute or relative URL of the directory where applets' .class files referenced by the code attribute are stored.
   */
  def codebase: StateChannel[String] = attribute("codebase").asInstanceOf[StateChannel[String]]
  /**
   * This attribute, supported by Internet Explorer 4 and higher, specifies the column name from the data source object that supplies the bound data. This attribute might be used to specify the various&nbsp;
<a href="/en-US/docs/Web/HTML/Element/param" title="The HTML <param> Element (or HTML Parameter Element) defines parameters for <object>."><code>&lt;param&gt;</code></a> elements passed to the Java applet.
   */
  def datafld: StateChannel[String] = attribute("datafld").asInstanceOf[StateChannel[String]]
  /**
   * Like 
<code>datafld</code>, this attribute is used for data binding under Internet Explorer 4. It indicates the id of the data source object that supplies the data that is bound to the 
<a href="/en-US/docs/Web/HTML/Element/param" title="The HTML <param> Element (or HTML Parameter Element) defines parameters for <object>."><code>&lt;param&gt;</code></a> elements associated with the applet.
   */
  def datasrc: StateChannel[String] = attribute("datasrc").asInstanceOf[StateChannel[String]]
  /**
   * This attribute specifies the height, in pixels, that the applet needs.
   */
  def height: StateChannel[String] = attribute("height").asInstanceOf[StateChannel[String]]
  /**
   * This attribute specifies additional horizontal space, in pixels, to be reserved on either side of the applet.
   */
  def hspace: StateChannel[String] = attribute("hspace").asInstanceOf[StateChannel[String]]
  /**
   * In the Netscape implementation, this attribute allows access to an applet by programs in a scripting language embedded in the document.
   */
  def mayscript: StateChannel[String] = attribute("mayscript").asInstanceOf[StateChannel[String]]
  /**
   * This attribute assigns a name to the applet so that it can be identified by other resources; particularly scripts.
   */
  def name: StateChannel[String] = attribute("name").asInstanceOf[StateChannel[String]]
  /**
   * This attribute specifies the URL of a serialized representation of an applet.
   */
  def `object`: StateChannel[String] = attribute("object").asInstanceOf[StateChannel[String]]
  /**
   * As defined for Internet Explorer 4 and higher, this attribute specifies a URL for an associated file for the applet. The meaning and use is unclear and not part of the HTML standard.
   */
  def src: StateChannel[String] = attribute("src").asInstanceOf[StateChannel[String]]
  /**
   * This attribute specifies additional vertical space, in pixels, to be reserved above and below the applet.
   */
  def vspace: StateChannel[String] = attribute("vspace").asInstanceOf[StateChannel[String]]
  /**
   * This attribute specifies in pixels the width that the applet needs.
   */
  def width: StateChannel[String] = attribute("width").asInstanceOf[StateChannel[String]]
}
