package pl.metastack.metaweb.tag

import pl.metastack.metaweb.tree

/**
 * The HTML Applet Element (<code>&lt;applet&gt;</code>) identifies the inclusion of a Java applet.
<p><strong>Usage note: </strong>This element has been removed in HTML5 and shouldn't be used anymore. Instead web developers should use the more generic <a href="/en-US/docs/Web/HTML/Element/object" title="The&nbsp;HTML Embedded Object Element&nbsp;(<object>) represents an external resource, which can be treated as an image, a nested browsing context, or a resource to be handled by a plugin."><code>&lt;object&gt;</code></a> element.</p>
 */
case class Applet(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[tree.Node] = Seq.empty) extends HTMLTag[Applet] {
  override def tagName = "applet"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[tree.Node] = children): Applet = Applet(attributes, children)
  /**
   * This attribute is used to position the applet on the page relative to content that might flow around it. The HTML 4.01 specification defines values of bottom, left, middle, right, and top, whereas Microsoft and Netscape also might support 
<strong>absbottom</strong>, 
<strong>absmiddle</strong>, 
<strong>baseline</strong>, 
<strong>center</strong>, and 
<strong>texttop</strong>.
   */
  def align: scala.Option[String] = attributes.get("align").asInstanceOf[scala.Option[String]]
  def align(value: String): Applet = copy(attributes = attributes + ("align" -> value.toString)).asInstanceOf[Applet]
  /**
   * This attribute causes a descriptive text alternate to be displayed on browsers that do not support Java. Page designers should also remember that content enclosed within the 
<code>&lt;applet&gt;</code> element may also be rendered as alternative text.
   */
  def alt: scala.Option[String] = attributes.get("alt").asInstanceOf[scala.Option[String]]
  def alt(value: String): Applet = copy(attributes = attributes + ("alt" -> value.toString)).asInstanceOf[Applet]
  /**
   * This attribute refers to an archived or compressed version of the applet and its associated class files, which might help reduce download time.
   */
  def archive: scala.Option[String] = attributes.get("archive").asInstanceOf[scala.Option[String]]
  def archive(value: String): Applet = copy(attributes = attributes + ("archive" -> value.toString)).asInstanceOf[Applet]
  /**
   * This attribute specifies the URL of the applet's class file to be loaded and executed. Applet filenames are identified by a .class filename extension. The URL specified by code might be relative to the 
<code>codebase</code> attribute.
   */
  def code: scala.Option[String] = attributes.get("code").asInstanceOf[scala.Option[String]]
  def code(value: String): Applet = copy(attributes = attributes + ("code" -> value.toString)).asInstanceOf[Applet]
  /**
   * This attribute gives the absolute or relative URL of the directory where applets' .class files referenced by the code attribute are stored.
   */
  def codebase: scala.Option[String] = attributes.get("codebase").asInstanceOf[scala.Option[String]]
  def codebase(value: String): Applet = copy(attributes = attributes + ("codebase" -> value.toString)).asInstanceOf[Applet]
  /**
   * This attribute, supported by Internet Explorer 4 and higher, specifies the column name from the data source object that supplies the bound data. This attribute might be used to specify the various&nbsp;
<a href="/en-US/docs/Web/HTML/Element/param" title="The HTML <param> Element (or HTML Parameter Element) defines parameters for <object>."><code>&lt;param&gt;</code></a> elements passed to the Java applet.
   */
  def datafld: scala.Option[String] = attributes.get("datafld").asInstanceOf[scala.Option[String]]
  def datafld(value: String): Applet = copy(attributes = attributes + ("datafld" -> value.toString)).asInstanceOf[Applet]
  /**
   * Like 
<code>datafld</code>, this attribute is used for data binding under Internet Explorer 4. It indicates the id of the data source object that supplies the data that is bound to the 
<a href="/en-US/docs/Web/HTML/Element/param" title="The HTML <param> Element (or HTML Parameter Element) defines parameters for <object>."><code>&lt;param&gt;</code></a> elements associated with the applet.
   */
  def datasrc: scala.Option[String] = attributes.get("datasrc").asInstanceOf[scala.Option[String]]
  def datasrc(value: String): Applet = copy(attributes = attributes + ("datasrc" -> value.toString)).asInstanceOf[Applet]
  /**
   * This attribute specifies the height, in pixels, that the applet needs.
   */
  def height: scala.Option[String] = attributes.get("height").asInstanceOf[scala.Option[String]]
  def height(value: String): Applet = copy(attributes = attributes + ("height" -> value.toString)).asInstanceOf[Applet]
  /**
   * This attribute specifies additional horizontal space, in pixels, to be reserved on either side of the applet.
   */
  def hspace: scala.Option[String] = attributes.get("hspace").asInstanceOf[scala.Option[String]]
  def hspace(value: String): Applet = copy(attributes = attributes + ("hspace" -> value.toString)).asInstanceOf[Applet]
  /**
   * In the Netscape implementation, this attribute allows access to an applet by programs in a scripting language embedded in the document.
   */
  def mayscript: scala.Option[String] = attributes.get("mayscript").asInstanceOf[scala.Option[String]]
  def mayscript(value: String): Applet = copy(attributes = attributes + ("mayscript" -> value.toString)).asInstanceOf[Applet]
  /**
   * This attribute assigns a name to the applet so that it can be identified by other resources; particularly scripts.
   */
  def name: scala.Option[String] = attributes.get("name").asInstanceOf[scala.Option[String]]
  def name(value: String): Applet = copy(attributes = attributes + ("name" -> value.toString)).asInstanceOf[Applet]
  /**
   * This attribute specifies the URL of a serialized representation of an applet.
   */
  def `object`: scala.Option[String] = attributes.get("object").asInstanceOf[scala.Option[String]]
  def `object`(value: String): Applet = copy(attributes = attributes + ("object" -> value.toString)).asInstanceOf[Applet]
  /**
   * As defined for Internet Explorer 4 and higher, this attribute specifies a URL for an associated file for the applet. The meaning and use is unclear and not part of the HTML standard.
   */
  def src: scala.Option[String] = attributes.get("src").asInstanceOf[scala.Option[String]]
  def src(value: String): Applet = copy(attributes = attributes + ("src" -> value.toString)).asInstanceOf[Applet]
  /**
   * This attribute specifies additional vertical space, in pixels, to be reserved above and below the applet.
   */
  def vspace: scala.Option[String] = attributes.get("vspace").asInstanceOf[scala.Option[String]]
  def vspace(value: String): Applet = copy(attributes = attributes + ("vspace" -> value.toString)).asInstanceOf[Applet]
  /**
   * This attribute specifies in pixels the width that the applet needs.
   */
  def width: scala.Option[String] = attributes.get("width").asInstanceOf[scala.Option[String]]
  def width(value: String): Applet = copy(attributes = attributes + ("width" -> value.toString)).asInstanceOf[Applet]
}
