package pl.metastack.metaweb.tag

import pl.metastack.metaweb.tree

/**
 * The HTML Teletype Text Element (<code>&lt;tt&gt;</code>) produces an inline element displayed in the browser's default monotype font. This element was intended to style text as it would display on a fixed width display, such as a teletype. It probably is more common to display fixed width type using the <a href="/en-US/docs/Web/HTML/Element/code" title="The HTML <code> Element represents a fragment of computer code. By default, it is displayed in the browser's default monospace font."><code>&lt;code&gt;</code></a> element.
This element is obsolete. Use a more appropriate element, such as 
<a href="/en-US/docs/Web/HTML/Element/code" title="The HTML <code> Element represents a fragment of computer code. By default, it is displayed in the browser's default monospace font."><code>&lt;code&gt;</code></a> or 
<a href="/en-US/docs/Web/HTML/Element/span" title="The HTML <span> element is a generic inline container for phrasing content, which does not inherently represent anything. It can be used to group elements for styling purposes (using the class or id attributes), or because they share attribute values, such as lang. It should be used only when no other semantic element is appropriate. <span> is very much like a <div> element, but <div> is a block-level element whereas a <span> is an inline element."><code>&lt;span&gt;</code></a> with 
<a href="/fr/docs/CSS" title="/fr/docs/CSS">CSS</a>, instead.
 */
case class Tt(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[tree.Node] = Seq.empty) extends tree.Tag with HTMLTag {
  override def tagName = "tt"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[tree.Node] = children): Tt = Tt(attributes, children)
}
