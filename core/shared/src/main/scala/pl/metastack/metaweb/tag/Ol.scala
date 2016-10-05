package pl.metastack.metaweb.tag

import pl.metastack.metaweb.tree

/**
 * The <strong>HTML <code>&lt;ol&gt;</code> Element</strong> (or <em>HTML Ordered List Element</em>) represents an ordered list of items. Typically, ordered-list items are displayed with a preceding numbering, which can be of any form, like numerals, letters or Romans numerals or even simple bullets. This numbered style is not defined in the HTML description of the page, but in its associated CSS, using the <a href="/en-US/docs/Web/CSS/list-style-type" title="The list-style-type property specifies the appearance of a list item element. Because it is the only property that&nbsp;defaults to display:list-item, this is usually a <li> element, but can be any element with this display value."><code>list-style-type</code></a> property.
There is no limitation to the depth and overlap of lists defined with the <a href="/en-US/docs/Web/HTML/Element/ol" title="The HTML <ol> Element (or HTML Ordered List Element) represents an ordered list of items. Typically, ordered-list items are displayed with a preceding numbering, which can be of any form, like numerals, letters or Romans numerals or even simple bullets. This numbered style is not defined in the HTML description of the page, but in its associated CSS, using the list-style-type property."><code>&lt;ol&gt;</code></a> and <a href="/en-US/docs/Web/HTML/Element/ul" title="The HTML unordered list element (<ul>) represents an unordered list of items, namely a collection of items that do not have a numerical ordering, and their order in the list is meaningless. Typically, unordered-list items are displayed with a bullet, which can be of several forms, like a dot, a circle or a squared. The bullet style is not defined in the HTML description of the page, but in its associated CSS, using the list-style-type property."><code>&lt;ul&gt;</code></a> elements.
<strong>Usage note: </strong> The 
<a href="/en-US/docs/Web/HTML/Element/ol" title="The HTML <ol> Element (or HTML Ordered List Element) represents an ordered list of items. Typically, ordered-list items are displayed with a preceding numbering, which can be of any form, like numerals, letters or Romans numerals or even simple bullets. This numbered style is not defined in the HTML description of the page, but in its associated CSS, using the list-style-type property."><code>&lt;ol&gt;</code></a> and 
<a href="/en-US/docs/Web/HTML/Element/ul" title="The HTML unordered list element (<ul>) represents an unordered list of items, namely a collection of items that do not have a numerical ordering, and their order in the list is meaningless. Typically, unordered-list items are displayed with a bullet, which can be of several forms, like a dot, a circle or a squared. The bullet style is not defined in the HTML description of the page, but in its associated CSS, using the list-style-type property."><code>&lt;ul&gt;</code></a> both represent a list of items. They differ in the way that, with the 
<a href="/en-US/docs/Web/HTML/Element/ol" title="The HTML <ol> Element (or HTML Ordered List Element) represents an ordered list of items. Typically, ordered-list items are displayed with a preceding numbering, which can be of any form, like numerals, letters or Romans numerals or even simple bullets. This numbered style is not defined in the HTML description of the page, but in its associated CSS, using the list-style-type property."><code>&lt;ol&gt;</code></a> element, the order is meaningful. As a rule of thumb to determine which one to use, try changing the order of the list items; if the meaning is changed, the 
<a href="/en-US/docs/Web/HTML/Element/ol" title="The HTML <ol> Element (or HTML Ordered List Element) represents an ordered list of items. Typically, ordered-list items are displayed with a preceding numbering, which can be of any form, like numerals, letters or Romans numerals or even simple bullets. This numbered style is not defined in the HTML description of the page, but in its associated CSS, using the list-style-type property."><code>&lt;ol&gt;</code></a> element should be used, else the 
<a href="/en-US/docs/Web/HTML/Element/ul" title="The HTML unordered list element (<ul>) represents an unordered list of items, namely a collection of items that do not have a numerical ordering, and their order in the list is meaningless. Typically, unordered-list items are displayed with a bullet, which can be of several forms, like a dot, a circle or a squared. The bullet style is not defined in the HTML description of the page, but in its associated CSS, using the list-style-type property."><code>&lt;ul&gt;</code></a> is adequate.
 */
case class Ol(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[tree.Node] = Seq.empty) extends HTMLTag {
  override type T = Ol
  override def tagName = "ol"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[tree.Node] = children): Ol = Ol(attributes, children)
  /**
   * This Boolean attribute hints that the list should be rendered in a compact style. The interpretation of this attribute depends on the user agent and it doesn't work in all browsers. 
<div class="note">
 <strong>Note:</strong>&nbsp;Do not use this attribute, as it has been deprecated: the 
 <a href="/en-US/docs/Web/HTML/Element/ol" title="The HTML <ol> Element (or HTML Ordered List Element) represents an ordered list of items. Typically, ordered-list items are displayed with a preceding numbering, which can be of any form, like numerals, letters or Romans numerals or even simple bullets. This numbered style is not defined in the HTML description of the page, but in its associated CSS, using the list-style-type property."><code>&lt;ol&gt;</code></a> element should be styled using 
 <a href="/en-US/docs/CSS" title="CSS">CSS</a>. To give an effect similar to&nbsp;the 
 <code>compact</code> attribute, the 
 <a href="/en-US/docs/CSS" title="CSS">CSS</a> property 
 <a href="/en-US/docs/Web/CSS/line-height" title="On block level elements, the line-height property specifies the minimum height of line boxes within the element."><code>line-height</code></a> can be used with a value of 
 <code>80%</code>.
</div>
   */
  def compact: scala.Option[String] = attributes.get("compact").asInstanceOf[scala.Option[String]]
  def compact(value: String): Ol = copy(attributes = attributes + ("compact" -> value))
  /**
   * This Boolean attribute specifies that the items of the item are specified in the reverse order, i.e. that the least important one is listed first.
   */
  def reversed: scala.Option[String] = attributes.get("reversed").asInstanceOf[scala.Option[String]]
  def reversed(value: String): Ol = copy(attributes = attributes + ("reversed" -> value))
  /**
   * This integer attribute specifies the start value for numbering the individual list items. Although the ordering type of list elements might be Roman numerals, such as XXXI, or letters, the value of start is always represented as a number. To start numbering elements from the letter "C", use 
<code>&lt;ol start="3"&gt;</code>. 
<div class="note">
 <strong>Note</strong>: This attribute was deprecated in HTML4, but reintroduced in HTML5.
</div>
   */
  def start: scala.Option[String] = attributes.get("start").asInstanceOf[scala.Option[String]]
  def start(value: String): Ol = copy(attributes = attributes + ("start" -> value))
  /**
   * Indicates the numbering type: 
<ul> 
 <li><code>'a'</code> indicates lowercase letters,</li> 
 <li><code>'A'</code> indicates uppercase letters,</li> 
 <li><code>'i'</code> indicates lowercase Roman numerals,</li> 
 <li><code>'I'</code> indicates uppercase Roman numerals,</li> 
 <li>and <code>'1'</code> indicates numbers (default).</li> 
</ul> 
<p>The type set is used for the entire list unless a different <code><a href="/en-US/docs/Web/HTML/Element/li#attr-type">type</a></code> attribute is used within an enclosed <a href="/en-US/docs/Web/HTML/Element/li" title="The HTML List Item Element (<li>) is used to represent an item in a list. It must be contained in a parent element: an ordered list (<ol>), an unordered list (<ul>), or a menu (<menu>). In menus and unordered lists, list items are usually displayed using bullet points. In ordered lists, they are usually displayed with an ascending counter on the left, such as a number or letter."><code>&lt;li&gt;</code></a> element.</p> 
<div class="note">
 <strong>Note:&nbsp;</strong>This attribute was deprecated in HTML4, but reintroduced in HTML5. Unless the value of the list number matters (e.g. in legal or technical documents where items are to be referenced by their number/letter), the CSS 
 <a href="/en-US/docs/Web/CSS/list-style-type" title="The list-style-type property specifies the appearance of a list item element. Because it is the only property that&nbsp;defaults to display:list-item, this is usually a <li> element, but can be any element with this display value."><code>list-style-type</code></a> property should be used instead.
</div>
   */
  def `type`: scala.Option[String] = attributes.get("type").asInstanceOf[scala.Option[String]]
  def `type`(value: String): Ol = copy(attributes = attributes + ("type" -> value))
}
