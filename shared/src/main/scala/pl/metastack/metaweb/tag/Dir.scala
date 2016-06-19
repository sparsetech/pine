package pl.metastack.metaweb.tag

import pl.metastack.metaweb.tree

/**
 * The <em>HTML directory element</em> (<code>&lt;dir&gt;</code>) represents a directory, namely a collection of filenames.
<strong>Usage note: </strong>Do not use this element. Though present in the early HTML specification, it has been deprecated in HTML 4, then is obsolete in 
<a href="/en-US/docs/Web/Guide/HTML/HTML5" title="/en-US/docs/Web/Guide/HTML/HTML5">HTML5</a>. Use the 
<a href="/en-US/docs/Web/HTML/Element/ul" title="The HTML unordered list element (<ul>) represents an unordered list of items, namely a collection of items that do not have a numerical ordering, and their order in the list is meaningless. Typically, unordered-list items are displayed with a bullet, which can be of several forms, like a dot, a circle or a squared. The bullet style is not defined in the HTML description of the page, but in its associated CSS, using the list-style-type property."><code>&lt;ul&gt;</code></a> instead.
 */
case class Dir(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[tree.Node] = Seq.empty) extends HTMLTag {
  override type T = Dir
  override def tagName = "dir"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[tree.Node] = children): Dir = Dir(attributes, children)
  /**
   * This Boolean attribute hints that the list should be rendered in a compact style. The interpretation of this attribute depends on the user agent and it doesn't work in all browsers. 
<div class="note"> 
 <strong>Usage note: </strong>Do not use this attribute, as it has been deprecated: the 
 <a href="/en-US/docs/Web/HTML/Element/dir" title="The HTML directory element (<dir>) represents a directory, namely a collection of filenames."><code>&lt;dir&gt;</code></a> element should be styled using 
 <a href="/en-US/docs/CSS" title="CSS">CSS</a>. To give a similar effect than the 
 <code>compact</code> attribute, the 
 <a href="/en-US/docs/CSS" title="CSS">CSS</a> property 
 <a href="/en-US/docs/Web/CSS/line-height" title="On block level elements, the line-height CSS property specifies the minimal height of line boxes within the element."><code>line-height</code></a> can be used with a value of 
 <code>80%</code>.
</div>
   */
  def compact: scala.Option[String] = attributes.get("compact").asInstanceOf[scala.Option[String]]
  def compact(value: String): Dir = copy(attributes = attributes + ("compact" -> value))
}
