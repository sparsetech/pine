package pine.tag

import pine._

/**
 * The <em>HTML Table Element </em>(<code>&lt;table&gt;</code>) represents data in two dimensions or more.
<strong>Note: </strong>Prior to the creation of 
<a href="/en-US/docs/CSS" title="CSS">CSS</a>, HTML 
<a href="/en-US/docs/Web/HTML/Element/table" title="The HTML Table Element (<table>) represents data in two dimensions or more."><code>&lt;table&gt;</code></a> elements were often used as a method for page layout. This usage has been discouraged since HTML 4, and the 
<a href="/en-US/docs/Web/HTML/Element/table" title="The HTML Table Element (<table>) represents data in two dimensions or more."><code>&lt;table&gt;</code></a> element 
<strong style="font-weight: bold;">should</strong>
<strong> not</strong> be used for layout purposes. However, HTML emails are an&nbsp;exception, where tables are still commonly used for layout purposes.
 */
case class Table(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[Node] = Seq.empty) extends HTMLTag {
  override type T = Table
  override def tagName = "table"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[Node] = children): Table = Table(attributes, children)
  /**
   * &nbsp;This enumerated attribute indicates how the table must be aligned in regard of the containing document. It may have the following values: 
<ul> 
 <li><span>left</span>, meaning that the table is to be displayed to the left of the document;</li> 
 <li><span>center</span>, meaning that the table is to be displayed centered in the document;</li> 
 <li><span>right</span>, meaning that the table is to be displayed to the right of the document.</li> 
</ul> 
<div class="note">
 <strong>Note:&nbsp;</strong> 
 <ul> 
  <li><strong>Do not use this attribute</strong>, as it has been deprecated and the <a href="/en-US/docs/Web/HTML/Element/table" title="The HTML Table Element (<table>) represents data in two dimensions or more."><code>&lt;table&gt;</code></a> element should be styled using <a href="/en-US/docs/CSS" title="CSS">CSS</a>. To give an effect similar to the&nbsp;<span>align</span> attribute, the <a href="/en-US/docs/CSS" title="CSS">CSS</a> layout should be used, like <a href="/en-US/docs/Web/CSS/margin-left" title="The margin-left CSS property sets the margin space required on the left side of a box associated with an element. A negative value is also allowed."><code>margin-left</code></a> and <a href="/en-US/docs/Web/CSS/margin-right" title="The margin-right CSS property of an element sets the margin space required on the right side of an element. A negative value is also allowed."><code>margin-right</code></a> set to <code>auto</code> ( or <a href="/en-US/docs/Web/CSS/margin" title="The margin CSS property sets the margin for all four sides. It is a shorthand to avoid setting each side separately with the other margin properties: margin-top, margin-right, margin-bottom and margin-left."><code>margin</code></a> to <code>0 auto</code>) to center it.</li> 
  <li>Prior to Firefox 4, Firefox also supported, in quirks mode only, the values <code>middle</code>, <code>absmiddle</code>, and <code>abscenter</code> as synonyms of <code>center</code><em>.&nbsp; </em></li> 
 </ul> 
</div>
   */
  def align: scala.Option[String] = attributes.get("align").asInstanceOf[scala.Option[String]]
  def align(value: String): Table = copy(attributes = attributes + ("align" -> value))
  /**
   * This attribute defines the background color of the table and its content. It is one of the 6-digit hexadecimal code as defined in 
<a href="http://www.w3.org/Graphics/Color/sRGB" class="external" title="http://www.w3.org/Graphics/Color/sRGB">sRGB</a>, prefixed by a '#'. One of the sixteen predefined color strings may be used: 
<table> 
 <tbody> 
  <tr> 
   <td style="width: 24px; background-color: black;">&nbsp;</td> 
   <td><span>black</span> = "#000000"</td> 
   <td style="width: 24px; background-color: green;">&nbsp;</td> 
   <td><span>green</span> = "#008000"</td> 
  </tr> 
  <tr> 
   <td style="width: 24px; background-color: silver;">&nbsp;</td> 
   <td><span>silver</span> = "#C0C0C0"</td> 
   <td style="width: 24px; background-color: lime;">&nbsp;</td> 
   <td><span>lime</span> = "#00FF00"</td> 
  </tr> 
  <tr> 
   <td style="width: 24px; background-color: gray;">&nbsp;</td> 
   <td><span>gray</span> = "#808080"</td> 
   <td style="width: 24px; background-color: olive;">&nbsp;</td> 
   <td><span>olive</span> = "#808000"</td> 
  </tr> 
  <tr> 
   <td style="width: 24px; background-color: white;">&nbsp;</td> 
   <td><span>white</span> = "#FFFFFF"</td> 
   <td style="width: 24px; background-color: yellow;">&nbsp;</td> 
   <td><span>yellow</span> = "#FFFF00"</td> 
  </tr> 
  <tr> 
   <td style="width: 24px; background-color: maroon;">&nbsp;</td> 
   <td><span>maroon</span> = "#800000"</td> 
   <td style="width: 24px; background-color: navy;">&nbsp;</td> 
   <td><span>navy</span> = "#000080"</td> 
  </tr> 
  <tr> 
   <td style="width: 24px; background-color: red;">&nbsp;</td> 
   <td><span>red</span> = "#FF0000"</td> 
   <td style="width: 24px; background-color: blue;">&nbsp;</td> 
   <td><span>blue</span> = "#0000FF"</td> 
  </tr> 
  <tr> 
   <td style="width: 24px; background-color: purple;">&nbsp;</td> 
   <td><span>purple</span> = "#800080"</td> 
   <td style="width: 24px; background-color: teal;">&nbsp;</td> 
   <td><span>teal</span> = "#008080"</td> 
  </tr> 
  <tr> 
   <td style="width: 24px; background-color: fuchsia;">&nbsp;</td> 
   <td><span>fuchsia</span> = "#FF00FF"</td> 
   <td style="width: 24px; background-color: aqua;">&nbsp;</td> 
   <td><span>aqua</span> = "#00FFFF"</td> 
  </tr> 
 </tbody> 
</table> 
<div class="note">
 <strong>Usage note:&nbsp;</strong>Do not use this attribute, as it has been deprecated and the 
 <a href="/en-US/docs/Web/HTML/Element/table" title="The HTML Table Element (<table>) represents data in two dimensions or more."><code>&lt;table&gt;</code></a> element should be styled using 
 <a href="/en-US/docs/CSS" title="CSS">CSS</a>. To give an effect similar to the 
 <span>bgcolor</span> attribute, the 
 <a href="/en-US/docs/CSS" title="CSS">CSS</a> property 
 <a href="/en-US/docs/Web/CSS/background-color" title="The background-color CSS property sets the background color of an element, either through a color value or the keyword transparent."><code>background-color</code></a> should be used.
</div>
   */
  def bgcolor: scala.Option[String] = attributes.get("bgcolor").asInstanceOf[scala.Option[String]]
  def bgcolor(value: String): Table = copy(attributes = attributes + ("bgcolor" -> value))
  /**
   * This integer attribute defines, in pixels, the size of the frame surrounding the table. If set to 
<span>0</span>, it implies that the 
<code><a href="/en-US/docs/Web/HTML/Element/table#attr-frame">frame</a></code> attribute is set to 
<span>void</span>. 
<div class="note">
 <strong>Usage note:&nbsp;</strong>Do not use this attribute, as it has been deprecated and the 
 <a href="/en-US/docs/Web/HTML/Element/table" title="The HTML Table Element (<table>) represents data in two dimensions or more."><code>&lt;table&gt;</code></a> element should be styled using 
 <a href="/en-US/docs/CSS" title="CSS">CSS</a>. To give an effect similar to the 
 <span>border</span> attribute, the 
 <a href="/en-US/docs/CSS" title="CSS">CSS</a> properties 
 <a href="/en-US/docs/Web/CSS/border" title="The border CSS property is a shorthand property for setting the individual border property values in a single place in the style sheet. border can be used to set the values for one or more of: border-width, border-style, border-color."><code>border</code></a>, 
 <a href="/en-US/docs/Web/CSS/border-color" title="The border-color CSS property is a shorthand for setting the color of the four sides of an element's border: border-top-color, border-right-color, border-bottom-color, border-left-color"><code>border-color</code></a>, 
 <a href="/en-US/docs/Web/CSS/border-width" title="The border-width property sets the width of the border of a box. Using the shorthand property border is often more convenient."><code>border-width</code></a> and 
 <a href="/en-US/docs/Web/CSS/border-style" title="The border-style property is a shorthand property for setting the line style for all four sides of the elements border."><code>border-style</code></a> should be used.
</div>
   */
  def border: scala.Option[String] = attributes.get("border").asInstanceOf[scala.Option[String]]
  def border(value: String): Table = copy(attributes = attributes + ("border" -> value))
  /**
   * This attribute defines the space between the content of a cell and the border, displayed or not, of it. If it is a pixel length, this pixel-sized space will be applied on all four sides; if it is a percentage length, the content will be centered and the total vertical space (top and bottom) will represent this percentage. The same is true for the total horizontal space (left and right). 
<div class="note">
 <strong>Usage note:&nbsp;</strong>Do not use this attribute, as it has been deprecated and the 
 <a href="/en-US/docs/Web/HTML/Element/table" title="The HTML Table Element (<table>) represents data in two dimensions or more."><code>&lt;table&gt;</code></a> element should be styled using 
 <a href="/en-US/docs/CSS" title="CSS">CSS</a>. To give an effect similar to the 
 <span>border</span> attribute, use the 
 <a href="/en-US/docs/CSS" title="CSS">CSS</a> property 
 <a href="/en-US/docs/Web/CSS/border-collapse" title="The border-collapse CSS property determines whether a table's borders are separated or collapsed. In the separated model, adjacent cells each have their own distinct borders. In the collapsed model, adjacent table cells share borders."><code>border-collapse</code></a> with the value collapse on the&nbsp; 
 <a href="/en-US/docs/Web/HTML/Element/table" title="The HTML Table Element (<table>) represents data in two dimensions or more."><code>&lt;table&gt;</code></a> element itself, and the property 
 <a href="/en-US/docs/Web/CSS/padding" title="The padding property sets the padding space on all sides of an element. The padding area is the space between the content of the element and its border. Negative values are not allowed."><code>padding</code></a> on the 
 <a href="/en-US/docs/Web/HTML/Element/td" title="The Table cell HTML element (<td>) defines a cell of a table that contains data. It participates in the table model."><code>&lt;td&gt;</code></a>.
</div>
   */
  def cellpadding: scala.Option[String] = attributes.get("cellpadding").asInstanceOf[scala.Option[String]]
  def cellpadding(value: String): Table = copy(attributes = attributes + ("cellpadding" -> value))
  /**
   * This attribute defines the size, in percentage or in pixels, of the space between two cells (both horizontally and vertically), between the top of the table and the cells of the first row, the left of the table and the first column, the right of the table and the last column and the bottom of the table and the last row. 
<div class="note">
 <strong>Usage note:&nbsp;</strong>Do not use this attribute, as it has been deprecated and the 
 <a href="/en-US/docs/Web/HTML/Element/table" title="The HTML Table Element (<table>) represents data in two dimensions or more."><code>&lt;table&gt;</code></a> element should be styled using 
 <a href="/en-US/docs/CSS" title="CSS">CSS</a>. To give an effect similar to the cellspacing&nbsp;attribute, use the 
 <a href="/en-US/docs/CSS" title="CSS">CSS</a> property 
 <a href="/en-US/docs/Web/CSS/border-spacing" title="The border-spacing CSS property specifies the distance between the borders of adjacent table cells (only for the separated borders model). This is equivalent to the cellspacing attribute in presentational HTML, but an optional second value can be used to set different horizontal and vertical spacing."><code>border-spacing</code></a>
 <span style="line-height: 1.5;">&nbsp;on the <a href="/en-US/docs/Web/HTML/Element/table" title="The HTML Table Element (<table>) represents data in two dimensions or more."><code>&lt;table&gt;</code></a> element itself.</span>
</div>
   */
  def cellspacing: scala.Option[String] = attributes.get("cellspacing").asInstanceOf[scala.Option[String]]
  def cellspacing(value: String): Table = copy(attributes = attributes + ("cellspacing" -> value))
  /**
   * This enumerated attribute defines which side of the frame surrounding the table must be displayed. It may have the following values: 
<table style="width: 668px;"> 
 <tbody> 
  <tr> 
   <td style="width: 24px; background-color: rgb(224, 224, 224);">&nbsp;</td> 
   <td><span>above</span></td> 
   <td style="width: 24px; background-color: rgb(224, 224, 224);">&nbsp;</td> 
   <td><span>below</span></td> 
  </tr> 
  <tr> 
   <td style="width: 24px; background-color: rgb(224, 224, 224);">&nbsp;</td> 
   <td><span>hsides</span></td> 
   <td style="width: 24px; background-color: rgb(224, 224, 224);">&nbsp;</td> 
   <td><span>vsides</span></td> 
  </tr> 
  <tr> 
   <td style="width: 24px; background-color: rgb(224, 224, 224);">&nbsp;</td> 
   <td><span>lhs</span></td> 
   <td style="width: 24px; background-color: rgb(224, 224, 224);">&nbsp;</td> 
   <td><span>rhs</span></td> 
  </tr> 
  <tr> 
   <td style="width: 24px; background-color: rgb(224, 224, 224);">&nbsp;</td> 
   <td><span>border</span></td> 
   <td style="width: 24px; background-color: rgb(224, 224, 224);">&nbsp;</td> 
   <td><span>box</span></td> 
  </tr> 
  <tr> 
   <td style="width: 24px; background-color: rgb(224, 224, 224);">&nbsp;</td> 
   <td><span>void</span></td> 
  </tr> 
 </tbody> 
</table> 
<div class="note">
 <strong>Usage note:&nbsp;</strong>Do not use this attribute, as it has been deprecated and the 
 <a href="/en-US/docs/Web/HTML/Element/table" title="The HTML Table Element (<table>) represents data in two dimensions or more."><code>&lt;table&gt;</code></a> element should be styled using 
 <a href="/en-US/docs/CSS" title="CSS">CSS</a>. To give an effect similar to the 
 <span>frame</span> attribute, use the 
 <a href="/en-US/docs/CSS" title="CSS">CSS</a> properties 
 <a href="/en-US/docs/Web/CSS/border-style" title="The border-style property is a shorthand property for setting the line style for all four sides of the elements border."><code>border-style</code></a> and 
 <a href="/en-US/docs/Web/CSS/border-width" title="The border-width property sets the width of the border of a box. Using the shorthand property border is often more convenient."><code>border-width</code></a>.
</div>
   */
  def frame: scala.Option[String] = attributes.get("frame").asInstanceOf[scala.Option[String]]
  def frame(value: String): Table = copy(attributes = attributes + ("frame" -> value))
  /**
   * This enumerated attribute defines where rules, i.e. lines, should appear in a table. It can have the following values: 
<ul> 
 <li><span>none</span>, which indicates the no rules will be displayed; it is the default value;</li> 
 <li><span>groups</span>, which will make the rules to be displayed between row groups (defined by the <a href="/en-US/docs/Web/HTML/Element/thead" title="The HTML Table Head Element (<thead>) defines a set of rows defining the head of the columns of the table."><code>&lt;thead&gt;</code></a>, <a href="/en-US/docs/Web/HTML/Element/tbody" title="The HTML Table Body Element () defines one or more <tr> element data-rows to be the body of its parent <table> element (as long as no <tr> elements are immediate children of that table element.)&nbsp; In conjunction with a preceding <thead> and/or <tfoot> element, <tbody> provides additional semantic information for devices such as printers and displays. Of the parent table's child elements, <tbody> represents the content which, when longer than a page, will most likely differ for each page printed; while the content of <thead> and <tfoot> will be the same or similar for each page printed. For displays, <tbody> will enable separate scrolling of the <thead>, <tfoot>, and <caption> elements of the same parent <table> element.&nbsp; Note that unlike the <thead>, <tfoot>, and <caption> elements however, multiple&nbsp;<tbody> elements are permitted (if consecutive), allowing the data-rows in long tables to be divided into different sections, each separately formatted as needed."><code>&lt;tbody&gt;</code></a> and <a href="/en-US/docs/Web/HTML/Element/tfoot" title="The HTML Table Foot Element (<tfoot>) defines a set of rows summarizing the columns of the table."><code>&lt;tfoot&gt;</code></a> elements) and between column groups (defined by the <a href="/en-US/docs/Web/HTML/Element/col" title="The&nbsp;HTML Table Column Element&nbsp;(<col>) defines a column within a table and is used for defining common semantics on all common cells. It is generally found within a <colgroup> element."><code>&lt;col&gt;</code></a> and <a href="/en-US/docs/Web/HTML/Element/colgroup" title="The&nbsp;HTML Table Column Group Element&nbsp;(<colgroup>) defines a group of columns within a table."><code>&lt;colgroup&gt;</code></a> elements) only;</li> 
 <li><span>rows</span>, which will make the rules to be displayed between rows;</li> 
 <li><span>columns</span>, which will make the rules to be displayed between columns;</li> 
 <li><span>all</span>, which wil make the rules to be displayed between rows and columns.</li> 
</ul> 
<div class="note">
 <strong>Note</strong>: 
 <ul> 
  <li>The styling of the rules is browser-dependant and cannot be modified.</li> 
  <li>Do not use this attribute, as it has been deprecated and the rules should be defined and styled using <a href="/en-US/docs/CSS" title="CSS">CSS</a>. Use the <a href="/en-US/docs/CSS" title="CSS">CSS</a> property <a href="/en-US/docs/Web/CSS/border" title="The border CSS property is a shorthand property for setting the individual border property values in a single place in the style sheet. border can be used to set the values for one or more of: border-width, border-style, border-color."><code>border</code></a> on the adequate <a href="/en-US/docs/Web/HTML/Element/thead" title="The HTML Table Head Element (<thead>) defines a set of rows defining the head of the columns of the table."><code>&lt;thead&gt;</code></a>, <a href="/en-US/docs/Web/HTML/Element/tbody" title="The HTML Table Body Element () defines one or more <tr> element data-rows to be the body of its parent <table> element (as long as no <tr> elements are immediate children of that table element.)&nbsp; In conjunction with a preceding <thead> and/or <tfoot> element, <tbody> provides additional semantic information for devices such as printers and displays. Of the parent table's child elements, <tbody> represents the content which, when longer than a page, will most likely differ for each page printed; while the content of <thead> and <tfoot> will be the same or similar for each page printed. For displays, <tbody> will enable separate scrolling of the <thead>, <tfoot>, and <caption> elements of the same parent <table> element.&nbsp; Note that unlike the <thead>, <tfoot>, and <caption> elements however, multiple&nbsp;<tbody> elements are permitted (if consecutive), allowing the data-rows in long tables to be divided into different sections, each separately formatted as needed."><code>&lt;tbody&gt;</code></a>, <a href="/en-US/docs/Web/HTML/Element/tfoot" title="The HTML Table Foot Element (<tfoot>) defines a set of rows summarizing the columns of the table."><code>&lt;tfoot&gt;</code></a>, <a href="/en-US/docs/Web/HTML/Element/col" title="The&nbsp;HTML Table Column Element&nbsp;(<col>) defines a column within a table and is used for defining common semantics on all common cells. It is generally found within a <colgroup> element."><code>&lt;col&gt;</code></a> or <a href="/en-US/docs/Web/HTML/Element/colgroup" title="The&nbsp;HTML Table Column Group Element&nbsp;(<colgroup>) defines a group of columns within a table."><code>&lt;colgroup&gt;</code></a> elements.</li> 
 </ul> 
</div>
   */
  def rules: scala.Option[String] = attributes.get("rules").asInstanceOf[scala.Option[String]]
  def rules(value: String): Table = copy(attributes = attributes + ("rules" -> value))
  /**
   * This attribute defines an alternative text use to describe the table in user-agent unable to display it. Typically, it contents a description of it to allow visually impaired people, like blind people browsing the web using Braille screen, to get the information in it. If the information added in this attribute may also be useful for non-visually impaired people, consider using the 
<a href="/en-US/docs/Web/HTML/Element/caption" title="The HTML <caption> Element (or HTML Table Caption Element) represents the title of a table. Though it is always the first descendant of a <table>, its styling, using CSS, may place it elsewhere, relative to the table."><code>&lt;caption&gt;</code></a> instead. The summary attribute is not mandatory and may be omitted when a 
<a href="/en-US/docs/Web/HTML/Element/caption" title="The HTML <caption> Element (or HTML Table Caption Element) represents the title of a table. Though it is always the first descendant of a <table>, its styling, using CSS, may place it elsewhere, relative to the table."><code>&lt;caption&gt;</code></a> element fulfills its role. 
<div class="note">
 <strong>Usage Note: </strong>Do not use this attribute, as it has been deprecated. Instead, use one of these way of describing a table: 
 <ul> 
  <li>In prose, surrounding the table (this is the less semantic-conveying way of doing it).</li> 
  <li>In the table's <a href="/en-US/docs/Web/HTML/Element/caption" title="The HTML <caption> Element (or HTML Table Caption Element) represents the title of a table. Though it is always the first descendant of a <table>, its styling, using CSS, may place it elsewhere, relative to the table."><code>&lt;caption&gt;</code></a> element.</li> 
  <li>In a <a href="/en-US/docs/Web/HTML/Element/details" title="The HTML Details&nbsp;Element&nbsp;(<details>) is used as a disclosure widget from which the user can retrieve additional information."><code>&lt;details&gt;</code></a> element, inside the table's <a href="/en-US/docs/Web/HTML/Element/caption" title="The HTML <caption> Element (or HTML Table Caption Element) represents the title of a table. Though it is always the first descendant of a <table>, its styling, using CSS, may place it elsewhere, relative to the table."><code>&lt;caption&gt;</code></a> element.</li> 
  <li>Include the <a href="/en-US/docs/Web/HTML/Element/table" title="The HTML Table Element (<table>) represents data in two dimensions or more."><code>&lt;table&gt;</code></a> element in a <a href="/en-US/docs/Web/HTML/Element/figure" title="The HTML <figure> Element represents self-contained content, frequently with a caption&nbsp;(<figcaption>), and is&nbsp;typically referenced as a single unit. While it is related to the main flow, its position is independent of the main flow. Usually this is an image, an illustration, a diagram, a code snippet, or a schema that is referenced in the main text, but that can be moved to another page or to an appendix without affecting the main flow."><code>&lt;figure&gt;</code></a> element and add the description in prose next to it.</li> 
  <li>Include the <a href="/en-US/docs/Web/HTML/Element/table" title="The HTML Table Element (<table>) represents data in two dimensions or more."><code>&lt;table&gt;</code></a> element in a <a href="/en-US/docs/Web/HTML/Element/figure" title="The HTML <figure> Element represents self-contained content, frequently with a caption&nbsp;(<figcaption>), and is&nbsp;typically referenced as a single unit. While it is related to the main flow, its position is independent of the main flow. Usually this is an image, an illustration, a diagram, a code snippet, or a schema that is referenced in the main text, but that can be moved to another page or to an appendix without affecting the main flow."><code>&lt;figure&gt;</code></a> element and add the description in prose inside a <a href="/en-US/docs/Web/HTML/Element/figcaption" title="The HTML <figcaption> Element represents a caption or a legend associated with a figure or an illustration described by the rest of the data of the <figure> element which is its immediate ancestor which means <figcaption> can be the first or last element inside a <figure> block.&nbsp;Also, the HTML Figcaption Element&nbsp;is optional; if not provided, then the parent figure element will have no caption."><code>&lt;figcaption&gt;</code></a> element.</li> 
  <li>Adjust the table so that such description is no more needed, by using <a href="/en-US/docs/Web/HTML/Element/th" title="The HTML Table Header Cell Element (<th>) defines a cell that is a header for a group of cells of a table. The group of cells that the header refers to is defined by the scope and headers attribute."><code>&lt;th&gt;</code></a> and <a href="/en-US/docs/Web/HTML/Element/thead" title="The HTML Table Head Element (<thead>) defines a set of rows defining the head of the columns of the table."><code>&lt;thead&gt;</code></a> elements for example.</li> 
 </ul> 
</div>
   */
  def summary: scala.Option[String] = attributes.get("summary").asInstanceOf[scala.Option[String]]
  def summary(value: String): Table = copy(attributes = attributes + ("summary" -> value))
  /**
   * This attribute defines the width of the table. It may either be a pixel length or a percentage value, representing the percentage of the width of its container that the table should use. 
<div class="note">
 <strong>Usage Note: </strong>Do not use this attribute, as it has been deprecated and the rules should be defined and styled using 
 <a href="/en-US/docs/CSS" title="CSS">CSS</a>. Use the 
 <a href="/en-US/docs/CSS" title="CSS">CSS</a> property 
 <a href="/en-US/docs/Web/CSS/width" title="The width CSS property specifies the width of the content area of an element. The content area is inside the padding, border, and margin of the element."><code>width</code></a> instead.
</div>
   */
  def width: scala.Option[String] = attributes.get("width").asInstanceOf[scala.Option[String]]
  def width(value: String): Table = copy(attributes = attributes + ("width" -> value))
}
