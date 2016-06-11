package pl.metastack.metaweb.tag

import pl.metastack.metaweb.tree

/**
 * The <em>HTML Root Element</em> (<strong><code>&lt;html&gt;</code></strong>) represents the root of an HTML document. All other elements must be descendants of this element.
 */
case class Html(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[tree.Node] = Seq.empty) extends tree.Tag with HTMLTag {
  override def tagName = "html"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[tree.Node] = children): Html = Html(attributes, children)
  /**
   * Specifies the URI of a resource manifest indicating resources that should be cached locally. See 
<a href="/en-US/docs/HTML/Using_the_application_cache" title="/en-US/docs/HTML/Using_the_application_cache">Using the application cache</a> for details.
   */
  def manifest: scala.Option[String] = attributes.get("manifest").asInstanceOf[scala.Option[String]]
  /**
   * Specifies the version of the HTML&nbsp;Document Type Definition that governs the current document. This attribute is not needed, because it is redundant with the version information in the document type declaration.
   */
  def version: scala.Option[String] = attributes.get("version").asInstanceOf[scala.Option[String]]
  /**
   * Specifies the XML Namespace of the document. Default value is "http://www.w3.org/1999/xhtml". This is required in XHTML, and optional in HTML5.
   */
  def xmlns: scala.Option[String] = attributes.get("xmlns").asInstanceOf[scala.Option[String]]
}
