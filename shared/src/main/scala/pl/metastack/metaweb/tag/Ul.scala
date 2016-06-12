package pl.metastack.metaweb.tag

import pl.metastack.metaweb.tree

/**
 * The HTML <em>unordered list</em> element (<code>&lt;ul&gt;</code>) represents an unordered list of items, namely a collection of items that do not have a numerical ordering, and their order in the list is meaningless. Typically, unordered-list items are displayed with a bullet, which can be of several forms, like a dot, a circle or a squared. The bullet style is not defined in the HTML description of the page, but in its associated CSS, using the <a href="/en-US/docs/Web/CSS/list-style-type" title="The list-style-type property specifies the appearance of a list item element. Because it is the only property that&nbsp;defaults to display:list-item, this is usually a <li> element, but can be any element with this display value."><code>list-style-type</code></a> property.
There is no limitation to the depth and imbrication of lists defined with the <a href="/en-US/docs/Web/HTML/Element/ol" title="The HTML <ol> Element (or HTML Ordered List Element) represents an ordered list of items. Typically, ordered-list items are displayed with a preceding numbering, which can be of any form, like numerals, letters or Romans numerals or even simple bullets. This numbered style is not defined in the HTML description of the page, but in its associated CSS, using the list-style-type property."><code>&lt;ol&gt;</code></a> and <a href="/en-US/docs/Web/HTML/Element/ul" title="The HTML unordered list element (<ul>) represents an unordered list of items, namely a collection of items that do not have a numerical ordering, and their order in the list is meaningless. Typically, unordered-list items are displayed with a bullet, which can be of several forms, like a dot, a circle or a squared. The bullet style is not defined in the HTML description of the page, but in its associated CSS, using the list-style-type property."><code>&lt;ul&gt;</code></a> elements.
<strong>Usage note: </strong> The 
<a href="/en-US/docs/Web/HTML/Element/ol" title="The HTML <ol> Element (or HTML Ordered List Element) represents an ordered list of items. Typically, ordered-list items are displayed with a preceding numbering, which can be of any form, like numerals, letters or Romans numerals or even simple bullets. This numbered style is not defined in the HTML description of the page, but in its associated CSS, using the list-style-type property."><code>&lt;ol&gt;</code></a> and 
<a href="/en-US/docs/Web/HTML/Element/ul" title="The HTML unordered list element (<ul>) represents an unordered list of items, namely a collection of items that do not have a numerical ordering, and their order in the list is meaningless. Typically, unordered-list items are displayed with a bullet, which can be of several forms, like a dot, a circle or a squared. The bullet style is not defined in the HTML description of the page, but in its associated CSS, using the list-style-type property."><code>&lt;ul&gt;</code></a> elements both represent a list of items. They differ in that, with the 
<a href="/en-US/docs/Web/HTML/Element/ol" title="The HTML <ol> Element (or HTML Ordered List Element) represents an ordered list of items. Typically, ordered-list items are displayed with a preceding numbering, which can be of any form, like numerals, letters or Romans numerals or even simple bullets. This numbered style is not defined in the HTML description of the page, but in its associated CSS, using the list-style-type property."><code>&lt;ol&gt;</code></a> element, the order is meaningful. As a rule of thumb to determine which one to use, try changing the order of the list items; if the meaning is changed, the 
<a href="/en-US/docs/Web/HTML/Element/ol" title="The HTML <ol> Element (or HTML Ordered List Element) represents an ordered list of items. Typically, ordered-list items are displayed with a preceding numbering, which can be of any form, like numerals, letters or Romans numerals or even simple bullets. This numbered style is not defined in the HTML description of the page, but in its associated CSS, using the list-style-type property."><code>&lt;ol&gt;</code></a> element should be used, otherwise you can use 
<a href="/en-US/docs/Web/HTML/Element/ul" title="The HTML unordered list element (<ul>) represents an unordered list of items, namely a collection of items that do not have a numerical ordering, and their order in the list is meaningless. Typically, unordered-list items are displayed with a bullet, which can be of several forms, like a dot, a circle or a squared. The bullet style is not defined in the HTML description of the page, but in its associated CSS, using the list-style-type property."><code>&lt;ul&gt;</code></a>.
 */
case class Ul(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[tree.Node] = Seq.empty) extends HTMLTag[Ul] {
  override def tagName = "ul"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[tree.Node] = children): Ul = Ul(attributes, children)
  /**
   * This Boolean attribute hints that the list should be rendered in a compact style. The interpretation of this attribute depends on the user agent and it doesn't work in all browsers. 
<div class="note">
 <strong>Usage note:&nbsp;</strong>Do not use this attribute, as it has been deprecated: the 
 <a href="/en-US/docs/Web/HTML/Element/ul" title="The HTML unordered list element (<ul>) represents an unordered list of items, namely a collection of items that do not have a numerical ordering, and their order in the list is meaningless. Typically, unordered-list items are displayed with a bullet, which can be of several forms, like a dot, a circle or a squared. The bullet style is not defined in the HTML description of the page, but in its associated CSS, using the list-style-type property."><code>&lt;ul&gt;</code></a> element should be styled using 
 <a href="/en/CSS" title="en/CSS">CSS</a>. To give a similar effect as the 
 <span style="font-family: courier new;">compact</span> attribute, the 
 <a href="/en/CSS" title="en/CSS">CSS</a> property 
 <a href="/en/CSS/line-height" title="en/CSS/line-height">line-height</a> can be used with a value of 
 <span style="font-family: courier new;">80%</span>.
</div>
   */
  def compact: scala.Option[String] = attributes.get("compact").asInstanceOf[scala.Option[String]]
  def compact(value: String): Ul = copy(attributes = attributes + ("compact" -> value)).asInstanceOf[Ul]
  /**
   * Used to set the bullet style for the list. The values defined under 
<a href="/en/HTML3.2" title="en/HTML3.2">HTML3.2</a> and the transitional version of 
<a href="/en/HTML4.01" title="en/HTML4.01">HTML 4.0/4.01</a> are
<span style="font-family: monospace;">:</span> 
<ul> 
 <li><code>circle</code>,</li> 
 <li><code>disc</code>,</li> 
 <li>and <code>square</code>.</li> 
</ul> 
<p>A fourth bullet type has been defined in the WebTV interface, but not all browsers support it: <code>triangle.</code></p> 
<p>If not present and if no <a href="/en/CSS" title="en/CSS">CSS</a> <a href="/en-US/docs/Web/CSS/list-style-type" title="The list-style-type property specifies the appearance of a list item element. Because it is the only property that&nbsp;defaults to display:list-item, this is usually a <li> element, but can be any element with this display value."><code>list-style-type</code></a> property does apply to the element, the user agent decide to use a kind of bullets depending on the nesting level of the list.</p> 
<div class="note">
 <strong>Usage note:</strong> Do not use this attribute, as it has been deprecated; use the 
 <a href="/en/CSS" title="en/CSS">CSS</a> 
 <a href="/en-US/docs/Web/CSS/list-style-type" title="The list-style-type property specifies the appearance of a list item element. Because it is the only property that&nbsp;defaults to display:list-item, this is usually a <li> element, but can be any element with this display value."><code>list-style-type</code></a> property instead.
</div>
   */
  def `type`: scala.Option[String] = attributes.get("type").asInstanceOf[scala.Option[String]]
  def `type`(value: String): Ul = copy(attributes = attributes + ("type" -> value)).asInstanceOf[Ul]
}
