package pl.metastack.metaweb.tag

import pl.metastack.metaweb.tree

/**
 * The <em>HTML Base Element</em> (<strong>&lt;base&gt;</strong>) specifies the base URL to use for all relative URLs contained within a document. There can be only one &lt;base&gt; element in a document.&nbsp;
The base URL of a document can be queried from a script using <a class="new" href="/en-US/docs/Web/API/Document/baseURI" title="The documentation about this has not yet been written; please consider contributing!"><code>document.baseURI</code></a>.
<strong>Usage Note:</strong> If multiple 
<code>&lt;base&gt;</code> elements are specified, only the first 
<strong>href</strong> and first 
<strong>target</strong> value are used; all others are ignored.
 */
case class Base(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[tree.Node] = Seq.empty) extends HTMLTag {
  override type T = Base
  override def tagName = "base"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[tree.Node] = children): Base = Base(attributes, children)
  /**
   * The base URL to be used throughout the document for relative URL addresses. If this attribute is specified, this element must come before any other elements with attributes whose values are URLs.
<br> Absolute and relative URIs are allowed (but see note section below).
   */
  def href: scala.Option[String] = attributes.get("href").asInstanceOf[scala.Option[String]]
  def href(value: String): Base = copy(attributes = attributes + ("href" -> value))
  /**
   * A name or keyword indicating the default location to display the result when hyperlinks or forms cause navigation, for elements that do not have an explicit target reference. In HTML4, this is the name of, or a keyword for, a frame. In HTML5, it is a name of, or keyword for, a 
<em>browsing context</em> (for example, tab, window, or inline frame). The following keywords have special meanings: 
<ul> 
 <li><code>_self</code>: Load the result into the same HTML4 frame (or HTML5 browsing context) as the current one. This value is the default if the attribute is not specified.</li> 
 <li><code>_blank</code>: Load the result into a new unnamed HTML4 window or HTML5 browsing context.</li> 
 <li><code>_parent</code>: Load the result into the HTML4 frameset parent of the current frame or HTML5 parent browsing context of the current one. If there is no parent, this option behaves the same way as <code>_self</code>.</li> 
 <li><code>_top</code>: In HTML4: Load the result into the full, original window, canceling all other frames. In HTML5: Load the result into the top-level browsing context (that is, the browsing context that is an ancestor of the current one, and has no parent). If there is no parent, this option behaves the same way as <code>_self</code>.</li> 
</ul>
   */
  def target: scala.Option[String] = attributes.get("target").asInstanceOf[scala.Option[String]]
  def target(value: String): Base = copy(attributes = attributes + ("target" -> value))
}
