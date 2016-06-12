package pl.metastack.metaweb.tag

import pl.metastack.metaweb.tree

/**
 * The <em>HTML List Item Element</em> (<code>&lt;li&gt;</code>) is used to represent an item in a list. It must be contained in a parent element: an ordered list (<a href="/en-US/docs/Web/HTML/Element/ol" title="The HTML <ol> Element (or HTML Ordered List Element) represents an ordered list of items. Typically, ordered-list items are displayed with a preceding numbering, which can be of any form, like numerals, letters or Romans numerals or even simple bullets. This numbered style is not defined in the HTML description of the page, but in its associated CSS, using the list-style-type property."><code>&lt;ol&gt;</code></a>), an unordered list (<a href="/en-US/docs/Web/HTML/Element/ul" title="The HTML unordered list element (<ul>) represents an unordered list of items, namely a collection of items that do not have a numerical ordering, and their order in the list is meaningless. Typically, unordered-list items are displayed with a bullet, which can be of several forms, like a dot, a circle or a squared. The bullet style is not defined in the HTML description of the page, but in its associated CSS, using the list-style-type property."><code>&lt;ul&gt;</code></a>), or a menu (<a href="/en-US/docs/Web/HTML/Element/menu" title="The HTML <menu> element represents a group of commands that a user can perform or activate. This includes both list menus, which might appear across the top of a screen, as well as context menus, such as those that might appear underneath a button after it has been clicked."><code>&lt;menu&gt;</code></a>). In menus and unordered lists, list items are usually displayed using bullet points. In ordered lists, they are usually displayed with an ascending counter on the left, such as a number or letter.
 */
case class Li(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[tree.Node] = Seq.empty) extends HTMLTag[Li] {
  override def tagName = "li"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[tree.Node] = children): Li = Li(attributes, children)
  /**
   * This integer attribute indicates the current ordinal value of the list item as defined by the 
<a href="/en-US/docs/Web/HTML/Element/ol" title="The HTML <ol> Element (or HTML Ordered List Element) represents an ordered list of items. Typically, ordered-list items are displayed with a preceding numbering, which can be of any form, like numerals, letters or Romans numerals or even simple bullets. This numbered style is not defined in the HTML description of the page, but in its associated CSS, using the list-style-type property."><code>&lt;ol&gt;</code></a> element. The only allowed value for this attribute is a number, even if the list is displayed with Roman numerals or letters. List items that follow this one continue numbering from the value set. The 
<strong>value</strong> attribute has no meaning for unordered lists (
<a href="/en-US/docs/Web/HTML/Element/ul" title="The HTML unordered list element (<ul>) represents an unordered list of items, namely a collection of items that do not have a numerical ordering, and their order in the list is meaningless. Typically, unordered-list items are displayed with a bullet, which can be of several forms, like a dot, a circle or a squared. The bullet style is not defined in the HTML description of the page, but in its associated CSS, using the list-style-type property."><code>&lt;ul&gt;</code></a>) or for menus (
<a href="/en-US/docs/Web/HTML/Element/menu" title="The HTML <menu> element represents a group of commands that a user can perform or activate. This includes both list menus, which might appear across the top of a screen, as well as context menus, such as those that might appear underneath a button after it has been clicked."><code>&lt;menu&gt;</code></a>). 
<div class="note">
 <strong>Note</strong>: This attribute was deprecated in HTML4, but reintroduced in HTML5.
</div> 
<div class="note"> 
 <p><strong>Note:</strong> Prior to <span title="(Firefox 9.0 / Thunderbird 9.0 / SeaMonkey 2.6)">Gecko&nbsp;9.0</span>, negative values were incorrectly converted to 0. Starting in <span title="(Firefox 9.0 / Thunderbird 9.0 / SeaMonkey 2.6)">Gecko&nbsp;9.0</span> all integer values are correctly parsed.</p> 
</div>
   */
  def value: scala.Option[Long] = attributes.get("value").asInstanceOf[scala.Option[Long]]
  def value(value: Long): Li = copy(attributes = attributes + ("value" -> value.toString)).asInstanceOf[Li]
  /**
   * This character attribute indicates the numbering type: 
<ul> 
 <li><code>a</code>: lowercase letters</li> 
 <li><code>A</code>: uppercase letters</li> 
 <li><code>i</code>: lowercase Roman numerals</li> 
 <li><code>I</code>: uppercase Roman numerals</li> 
 <li><code>1</code>: numbers</li> 
</ul> This type overrides the one used by its parent 
<a href="/en-US/docs/Web/HTML/Element/ol" title="The HTML <ol> Element (or HTML Ordered List Element) represents an ordered list of items. Typically, ordered-list items are displayed with a preceding numbering, which can be of any form, like numerals, letters or Romans numerals or even simple bullets. This numbered style is not defined in the HTML description of the page, but in its associated CSS, using the list-style-type property."><code>&lt;ol&gt;</code></a> element, if any. 
<div class="note">
 <strong>Usage note:</strong> This attribute has been deprecated: use the CSS 
 <a href="/en-US/docs/Web/CSS/list-style-type" title="The list-style-type property specifies the appearance of a list item element. Because it is the only property that&nbsp;defaults to display:list-item, this is usually a <li> element, but can be any element with this display value."><code>list-style-type</code></a> property instead.
</div>
   */
  def `type`: scala.Option[String] = attributes.get("type").asInstanceOf[scala.Option[String]]
  def `type`(value: String): Li = copy(attributes = attributes + ("type" -> value.toString)).asInstanceOf[Li]
}
