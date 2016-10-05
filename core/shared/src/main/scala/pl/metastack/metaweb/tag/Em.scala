package pl.metastack.metaweb.tag

import pl.metastack.metaweb.tree

/**
 * The&nbsp;<em>HTML Emphasis Element</em>&nbsp;(<strong>&lt;em&gt;</strong>) marks text that has stress emphasis. The <code>&lt;em&gt;</code> element can be nested, with each level of nesting indicating a greater degree of emphasis.
<strong>Usage Note:</strong> Typically this element is displayed in italic type. However, it should not be used simply to apply italic styling; use the CSS styling for that purpose. Use the 
<a href="/en-US/docs/Web/HTML/Element/cite" title="The&nbsp;HTML Citation Element&nbsp;(<cite>) represents a reference to a creative work. It must include the title of a work or a URL reference,&nbsp;which may be in an abbreviated form according to the conventions used for the addition of citation metadata."><code>&lt;cite&gt;</code></a> element to mark the title of a work (book, play, song, etc.); it is also typically styled with italic type, but carries different meaning. Use the 
<a href="/en-US/docs/Web/HTML/Element/strong" title="The HTML Strong Element (<strong>) gives text strong importance, and is typically displayed in bold."><code>&lt;strong&gt;</code></a> element to mark text that has greater importance than surrounding text.
 */
case class Em(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[tree.Node] = Seq.empty) extends HTMLTag {
  override type T = Em
  override def tagName = "em"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[tree.Node] = children): Em = Em(attributes, children)
}
