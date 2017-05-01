package pl.metastack.metaweb.tag

import pl.metastack.metaweb._

/**
 * The <em>HTML Script Element</em> (<strong><code>&lt;script&gt;</code></strong>) is used to embed or reference an executable script within an <abbr title="Hypertext Markup Language">HTML</abbr> or <abbr title="Extensible Hypertext Markup Language">XHTML</abbr> document.
Scripts without <code>async</code> or <code>defer</code> attributes, as well as inline scripts, are fetched and executed immediately, before the browser continues to parse the page.
 */
case class Script(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[Node] = Seq.empty) extends HTMLTag {
  override type T = Script
  override def tagName = "script"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[Node] = children): Script = Script(attributes, children)
  /**
   * Set this Boolean attribute to indicate that the browser should, if possible, execute the script asynchronously. It has no effect on inline scripts (i.e., scripts that don't have the 
<strong>src</strong> attribute).
   */
  def async: scala.Option[String] = attributes.get("async").asInstanceOf[scala.Option[String]]
  def async(value: String): Script = copy(attributes = attributes + ("async" -> value))
  /**
   * This attribute specifies the 
<abbr>URI</abbr> of an external script; this can be used as an alternative to embedding a script directly within a document. 
<code>script</code> elements with an 
<code>src</code> attribute specified should not have a script embedded within its tags.
   */
  def src: scala.Option[String] = attributes.get("src").asInstanceOf[scala.Option[String]]
  def src(value: String): Script = copy(attributes = attributes + ("src" -> value))
  /**
   * This attribute identifies the scripting language of code embedded within a 
<code>script</code> element or referenced via the element’s 
<code>src</code> attribute. This is specified as a 
<abbr title="Multi-purpose Internet Mail Extensions">MIME</abbr> type; examples of supported 
<abbr title="Multi-purpose Internet Mail Extensions">MIME</abbr> types include 
<code>text/javascript</code>, 
<code>text/ecmascript</code>, 
<code>application/javascript</code>, and 
<code>application/ecmascript</code>. If this attribute is absent, the script is treated as JavaScript.
<br> 
<br> Note that in Firefox you can use advanced features such as let statements and other features in later JS versions, by using 
<code>type=application/javascript;version=1.8</code>. Beware, however, that&nbsp;as this is a non-standard feature, this will most likely break support for&nbsp;other browsers, in particular Chromium-based browsers.
   */
  def `type`: scala.Option[String] = attributes.get("type").asInstanceOf[scala.Option[String]]
  def `type`(value: String): Script = copy(attributes = attributes + ("type" -> value))
  /**
   * Like the 
<code>type</code> attribute, this attribute identifies the scripting language in use. Unlike the 
<code>type</code> attribute, however, this attribute’s possible values were never standardized. The 
<code>type</code> attribute should be used instead.
   */
  def language: scala.Option[String] = attributes.get("language").asInstanceOf[scala.Option[String]]
  def language(value: String): Script = copy(attributes = attributes + ("language" -> value))
  /**
   * This Boolean attribute is set to indicate to a browser that the script is meant to be executed after the document has been parsed. Since this feature hasn't yet been implemented by all other major browsers, authors should not assume that the script’s execution will actually be deferred. The 
<code>defer</code> attribute shouldn't be used on scripts that don't have the 
<code>src</code> attribute. Since Gecko 1.9.2, the 
<code>defer</code> attribute is ignored on scripts that don't have the 
<code>src</code> attribute. However, in Gecko 1.9.1 even inline scripts are deferred if the 
<code>defer</code> attribute is set.
   */
  def defer: scala.Option[String] = attributes.get("defer").asInstanceOf[scala.Option[String]]
  def defer(value: String): Script = copy(attributes = attributes + ("defer" -> value))
  /**
   * Normal 
<code>script</code> tags will pass minimal information to the 
<a href="/en-US/docs/Web/API/Window/onerror" class="new" title="The documentation about this has not yet been written; please consider contributing!"><code>window.onerror</code></a> for scripts which do not pass the standard 
<a href="/en-US/docs/HTTP_access_control">CORS</a> checks. To allow error logging for sites which use a separate domain for static media, several browsers have enabled the 
<code>crossorigin</code> attribute for scripts using the same definition as the standard img 
<code><a href="/en-US/docs/Web/HTML/Element/img#attr-crossorigin">crossorigin</a></code> attribute. Efforts to standardize this attribute are underway on the 
<a href="http://lists.whatwg.org/pipermail/whatwg-whatwg.org/2012-February/034969.html" class="external">WHATWG mailing list</a>.
   */
  def crossorigin: scala.Option[String] = attributes.get("crossorigin").asInstanceOf[scala.Option[String]]
  def crossorigin(value: String): Script = copy(attributes = attributes + ("crossorigin" -> value))
  /**
   * Contains inline metadata that a user agent can use to verify that a fetched resource has been delivered free of unexpected manipulation.&nbsp;
   */
  def integrity: scala.Option[String] = attributes.get("integrity").asInstanceOf[scala.Option[String]]
  def integrity(value: String): Script = copy(attributes = attributes + ("integrity" -> value))
}
