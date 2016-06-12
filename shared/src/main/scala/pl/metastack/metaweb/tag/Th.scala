package pl.metastack.metaweb.tag

import pl.metastack.metaweb.tree

/**
 * The <em>HTML Table Header Cell Element</em> (<code>&lt;th&gt;</code>) defines a cell that is a header for a group of cells of a table. The group of cells that the header refers to is defined by the <code><a href="/en-US/docs/Web/HTML/Element/th#attr-scope">scope</a></code> and <code><a href="/en-US/docs/Web/HTML/Element/th#attr-headers">headers</a></code> attribute.
 */
case class Th(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[tree.Node] = Seq.empty) extends HTMLTag[Th] {
  override def tagName = "th"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[tree.Node] = children): Th = Th(attributes, children)
  /**
   * This attribute contains a short abbreviated description of the content of the cell. Some user-agent, like speech reader, may present it before the content itself. 
<div class="note">
 <strong>Note: </strong>Do not use this attribute as it is obsolete in the latest standard: instead either consider starting the cell content by an independent abbreviated content itself or use the abbreviated content as the cell content and use the long content as the description of the cell by putting it in the 
 <strong>title</strong> attribute.
</div>
   */
  def abbr: scala.Option[String] = attributes.get("abbr").asInstanceOf[scala.Option[String]]
  def abbr(value: String): Th = copy(attributes = attributes + ("abbr" -> value.toString)).asInstanceOf[Th]
  /**
   * This enumerated attribute specifies how horizontal alignment of each cell content will be handled. Possible values are: 
<ul> 
 <li><code>left</code>, aligning the content to the left of the cell</li> 
 <li><code>center</code>, centering the content in the cell</li> 
 <li><code>right</code>, aligning the content to the right of the cell</li> 
 <li><code>justify</code>, inserting spaces into the textual content so that the content is justified in the cell</li> 
 <li><code>char</code>, aligning the textual content on a special character with a minimal offset, defined by the <code><a href="/en-US/docs/Web/HTML/Element/th#attr-char">char</a></code> and <code><a href="/en-US/docs/Web/HTML/Element/th#attr-charoff">charoff</a></code> attributes <span class="inlineIndicator unimplemented unimplementedInline">Unimplemented (see <a class="external" href="https://bugzilla.mozilla.org/show_bug.cgi?id=2212" title="character alignment not implemented (align=char, charoff=, text-align:<string>)">bug&nbsp;2212</a>)</span>.</li> 
</ul> 
<p>If this attribute is not set, the <code>left</code> value is assumed.</p> 
<div class="note">
 <strong>Note: </strong>Do not use this attribute as it is obsolete (not supported) in the latest standard. 
 <ul> 
  <li>To achieve the same effect as the <code>left</code>, <code>center</code>, <code>right</code> or <code>justify</code> values, use the CSS <a href="/en-US/docs/Web/CSS/text-align" title="The text-align CSS property describes how inline content like text is aligned in its parent block element. text-align does not control the alignment of block elements itself, only their inline content."><code>text-align</code></a> property on it.</li> 
  <li>To achieve the same effect as the <code>char</code> value, in CSS3, you can use the value of the <code><a href="/en-US/docs/Web/HTML/Element/th#attr-char">char</a></code> as the value of the <a href="/en-US/docs/Web/CSS/text-align" title="The text-align CSS property describes how inline content like text is aligned in its parent block element. text-align does not control the alignment of block elements itself, only their inline content."><code>text-align</code></a> property <span class="inlineIndicator unimplemented unimplementedInline">Unimplemented</span>.</li> 
 </ul> 
</div>
   */
  def align: scala.Option[String] = attributes.get("align").asInstanceOf[scala.Option[String]]
  def align(value: String): Th = copy(attributes = attributes + ("align" -> value.toString)).asInstanceOf[Th]
  /**
   * This attribute contains a list of space-separated strings. Each string is the id of a group of cells that this header apply to. 
<div class="note">
 <strong>Note: </strong>Do not use this attribute as it is obsolete in the latest standard: instead use the 
 <code><a href="/en-US/docs/Web/HTML/Element/th#attr-scope">scope</a></code> attribute.
</div>
   */
  def axis: scala.Option[String] = attributes.get("axis").asInstanceOf[scala.Option[String]]
  def axis(value: String): Th = copy(attributes = attributes + ("axis" -> value.toString)).asInstanceOf[Th]
  /**
   * This attribute defines the background color of each cell of the column. It is one of the 6-digit hexadecimal code as defined in 
<a class="external" href="http://www.w3.org/Graphics/Color/sRGB" title="http://www.w3.org/Graphics/Color/sRGB">sRGB</a>, prefixed by a '#'. One of the sixteen predefined color strings may be used: 
<table> 
 <tbody> 
  <tr> 
   <td style="background-color: black; width: 24px; height: 24px; border-width: 1px; border-color: black; border-style: solid;">&nbsp;</td> 
   <td><code>black</code> = "#000000"</td> 
   <td style="background-color: green; width: 24px; height: 24px; border-width: 1px; border-color: black; border-style: solid;">&nbsp;</td> 
   <td><code>green</code> = "#008000"</td> 
  </tr> 
  <tr> 
   <td style="background-color: silver; width: 24px; height: 24px; border-width: 1px; border-color: black; border-style: solid;">&nbsp;</td> 
   <td><code>silver</code> = "#C0C0C0"</td> 
   <td style="background-color: lime; width: 24px; height: 24px; border-width: 1px; border-color: black; border-style: solid;">&nbsp;</td> 
   <td><code>lime</code> = "#00FF00"</td> 
  </tr> 
  <tr> 
   <td style="background-color: gray; width: 24px; height: 24px; border-width: 1px; border-color: black; border-style: solid;">&nbsp;</td> 
   <td><code>gray</code> = "#808080"</td> 
   <td style="background-color: olive; width: 24px; height: 24px; border-width: 1px; border-color: black; border-style: solid;">&nbsp;</td> 
   <td><code>olive</code> = "#808000"</td> 
  </tr> 
  <tr> 
   <td style="background-color: white; width: 24px; height: 24px; border-width: 1px; border-color: black; border-style: solid;">&nbsp;</td> 
   <td><code>white</code> = "#FFFFFF"</td> 
   <td style="background-color: yellow; width: 24px; height: 24px; border-width: 1px; border-color: black; border-style: solid;">&nbsp;</td> 
   <td><code>yellow</code> = "#FFFF00"</td> 
  </tr> 
  <tr> 
   <td style="background-color: maroon; width: 24px; height: 24px; border-width: 1px; border-color: black; border-style: solid;">&nbsp;</td> 
   <td><code>maroon</code> = "#800000"</td> 
   <td style="background-color: navy; width: 24px; height: 24px; border-width: 1px; border-color: black; border-style: solid;">&nbsp;</td> 
   <td><code>navy</code> = "#000080"</td> 
  </tr> 
  <tr> 
   <td style="background-color: red; width: 24px; height: 24px; border-width: 1px; border-color: black; border-style: solid;">&nbsp;</td> 
   <td><code>red</code> = "#FF0000"</td> 
   <td style="background-color: blue; width: 24px; height: 24px; border-width: 1px; border-color: black; border-style: solid;">&nbsp;</td> 
   <td><code>blue</code> = "#0000FF"</td> 
  </tr> 
  <tr> 
   <td style="background-color: purple; width: 24px; height: 24px; border-width: 1px; border-color: black; border-style: solid;">&nbsp;</td> 
   <td><code>purple</code> = "#800080"</td> 
   <td style="background-color: teal; width: 24px; height: 24px; border-width: 1px; border-color: black; border-style: solid;">&nbsp;</td> 
   <td><code>teal</code> = "#008080"</td> 
  </tr> 
  <tr> 
   <td style="background-color: fuchsia; width: 24px; height: 24px; border-width: 1px; border-color: black; border-style: solid;">&nbsp;</td> 
   <td><code>fuchsia</code> = "#FF00FF"</td> 
   <td style="background-color: aqua; width: 24px; height: 24px; border-width: 1px; border-color: black; border-style: solid;">&nbsp;</td> 
   <td><code>aqua</code> = "#00FFFF"</td> 
  </tr> 
 </tbody> 
</table> 
<div class="note">
 <strong>Usage note:</strong> Do not use this attribute, as it is non-standard and only implemented some versions of Microsoft Internet Explorer: the 
 <a href="/en-US/docs/Web/HTML/Element/th" title="Editorial review completed."><code>&lt;th&gt;</code></a> element should be styled using 
 <a href="/en-US/docs/CSS" title="CSS">CSS</a>. To give a similar effect to the 
 <strong>bgcolor</strong> attribute, use the 
 <a href="/en-US/docs/CSS" title="CSS">CSS</a> property 
 <a href="/en-US/docs/Web/CSS/background-color" title="The background-color CSS property sets the background color of an element, either through a color value or the keyword transparent."><code>background-color</code></a> instead.
</div>
   */
  def bgcolor: scala.Option[String] = attributes.get("bgcolor").asInstanceOf[scala.Option[String]]
  def bgcolor(value: String): Th = copy(attributes = attributes + ("bgcolor" -> value.toString)).asInstanceOf[Th]
  /**
   * This attribute is used to set the character to align the cells in a column on. Typical values for this include a period (.) when attempting to align numbers or monetary values. If 
<code><a href="/en-US/docs/Web/HTML/Element/th#attr-align">align</a></code> is not set to 
<code>char</code>, this attribute is ignored. 
<div class="note">
 <strong>Note: </strong>Do not use this attribute as it is obsolete (and not supported) in the latest standard. To achieve the same effect as the 
 <code><a href="/en-US/docs/Web/HTML/Element/thead#attr-char">char</a></code>, in CSS3, you can use the character set using the 
 <code><a href="/en-US/docs/Web/HTML/Element/th#attr-char">char</a></code> attribute as the value of the 
 <a href="/en-US/docs/Web/CSS/text-align" title="The text-align CSS property describes how inline content like text is aligned in its parent block element. text-align does not control the alignment of block elements itself, only their inline content."><code>text-align</code></a> property 
 <span class="inlineIndicator unimplemented unimplementedInline">Unimplemented</span>.
</div>
   */
  def char: scala.Option[String] = attributes.get("char").asInstanceOf[scala.Option[String]]
  def char(value: String): Th = copy(attributes = attributes + ("char" -> value.toString)).asInstanceOf[Th]
  /**
   * This attribute is used to indicate the number of characters to offset the column data from the alignment characters specified by the 
<strong>char</strong> attribute. 
<div class="note">
 <strong>Note: </strong>Do not use this attribute as it is obsolete (and not supported) in the latest standard.
</div>
   */
  def charoff: scala.Option[String] = attributes.get("charoff").asInstanceOf[scala.Option[String]]
  def charoff(value: String): Th = copy(attributes = attributes + ("charoff" -> value.toString)).asInstanceOf[Th]
  /**
   * This attribute contains a non-negative integer value that indicates on how many columns does the cell extend. Its default value is 
<code>1</code>; if its value is set to 
<code>0</code>, it does extend until the end of the 
<a href="/en-US/docs/Web/HTML/Element/colgroup" title="The&nbsp;HTML Table Column Group Element&nbsp;(<colgroup>) defines a group of columns within a table."><code>&lt;colgroup&gt;</code></a>, eventually implicitly defined, the cell belongs to. Values higher than 1000 are clipped down to 1000.
   */
  def colspan: scala.Option[String] = attributes.get("colspan").asInstanceOf[scala.Option[String]]
  def colspan(value: String): Th = copy(attributes = attributes + ("colspan" -> value.toString)).asInstanceOf[Th]
  /**
   * This attributes a list of space-separated strings, each corresponding to the 
<strong>id</strong> attribute of the 
<a href="/en-US/docs/Web/HTML/Element/th" title="Editorial review completed."><code>&lt;th&gt;</code></a> elements that applies to this element.
   */
  def headers: scala.Option[String] = attributes.get("headers").asInstanceOf[scala.Option[String]]
  def headers(value: String): Th = copy(attributes = attributes + ("headers" -> value.toString)).asInstanceOf[Th]
  /**
   * This attribute contains a non-negative integer value that indicates on how many rows does the cell extend. Its default value is 
<code>1</code>; if its value is set to 
<code>0</code>, it does extend until the end of the table section (
<a href="/en-US/docs/Web/HTML/Element/thead" title="The HTML Table Head Element (<thead>) defines a set of rows defining the head of the columns of the table."><code>&lt;thead&gt;</code></a>, 
<a href="/en-US/docs/Web/HTML/Element/tbody" title="The HTML Table Body Element () defines one or more <tr> element data-rows to be the body of its parent <table> element (as long as no <tr> elements are immediate children of that table element.)&nbsp; In conjunction with a preceding <thead> and/or <tfoot> element, <tbody> provides additional semantic information for devices such as printers and displays. Of the parent table's child elements, <tbody> represents the content which, when longer than a page, will most likely differ for each page printed; while the content of <thead> and <tfoot> will be the same or similar for each page printed. For displays, <tbody> will enable separate scrolling of the <thead>, <tfoot>, and <caption> elements of the same parent <table> element.&nbsp; Note that unlike the <thead>, <tfoot>, and <caption> elements however, multiple&nbsp;<tbody> elements are permitted (if consecutive), allowing the data-rows in long tables to be divided into different sections, each separately formatted as needed."><code>&lt;tbody&gt;</code></a>, 
<a href="/en-US/docs/Web/HTML/Element/tfoot" title="The HTML Table Foot Element (<tfoot>) defines a set of rows summarizing the columns of the table."><code>&lt;tfoot&gt;</code></a>, eventually implicitly defined) the cell belongs to. Values higher than 65534 are clipped down to 65534.
   */
  def rowspan: scala.Option[String] = attributes.get("rowspan").asInstanceOf[scala.Option[String]]
  def rowspan(value: String): Th = copy(attributes = attributes + ("rowspan" -> value.toString)).asInstanceOf[Th]
  /**
   * This enumerated attribute defines the cells that the header defined in this 
<a href="/en-US/docs/Web/HTML/Element/th" title="Editorial review completed."><code>&lt;th&gt;</code></a> element relates to. It may have the following values: 
<ul> 
 <li><code>row</code>, which means that the header relates to all cells in the row that this element belongs to;</li> 
 <li><code>col</code>, which means that the header relates to all cells in the column that this element belongs to;</li> 
 <li><code>rowgroup</code>, which means that the header relates to all remaining cells in the row group that this element belongs to. The remaining cells are either those to the right of this element, or to his left depending of the value of<code><a href="/en-US/docs/Web/HTML/Element/table#attr-dir">dir</a></code> attribute defined on the <a href="/en-US/docs/Web/HTML/Element/table" title="The HTML Table Element (<table>) represents data in two dimensions or more."><code>&lt;table&gt;</code></a> element;</li> 
 <li><code>colgroup</code>, which means that the header relates to all remaining cells in the column group that this element belongs to;</li> 
 <li><em>auto</em></li> 
</ul>
   */
  def scope: scala.Option[String] = attributes.get("scope").asInstanceOf[scala.Option[String]]
  def scope(value: String): Th = copy(attributes = attributes + ("scope" -> value.toString)).asInstanceOf[Th]
  /**
   * This attribute specifies the vertical alignment of the text within each row of cells of the table header. Possible values for this attribute are: 
<ul> 
 <li><code>baseline</code>, which will put the text as close to the bottom of the cell as it is possible, but align it on the <a class="external" href="http://en.wikipedia.org/wiki/Baseline_%28typography%29" title="http://en.wikipedia.org/wiki/Baseline_(typography)">baseline</a> of the characters instead of the bottom of them. If characters are all of the size, this has the same effect as <code>bottom</code>.</li> 
 <li><code>bottom</code>, which will put the text as close to the bottom of the cell as it is possible;</li> 
 <li><code>middle</code>, which will center the text in the cell;</li> 
 <li>and <code>top</code>, which will put the text as close to the top of the cell as it is possible.</li> 
</ul> 
<div class="note">
 <strong>Note: </strong>Do not use this attribute as it is obsolete (and not supported) in the latest standard: instead set the CSS&nbsp;
 <a href="/en-US/docs/Web/CSS/vertical-align" title="The vertical-align CSS property specifies the vertical alignment of an inline or table-cell box."><code>vertical-align</code></a> property on it.
</div>
   */
  def valign: scala.Option[String] = attributes.get("valign").asInstanceOf[scala.Option[String]]
  def valign(value: String): Th = copy(attributes = attributes + ("valign" -> value.toString)).asInstanceOf[Th]
  /**
   * This attribute is used to define a recommended cell width. &nbsp;Properties&nbsp;
<a href="/en-US/docs/Web/API/HTMLTableElement/cellSpacing">cellspacing</a> and 
<a href="/en-US/docs/Web/API/HTMLTableElement/cellPadding">cellpadding</a> may add additional space, and element&nbsp;
<a href="/en-US/docs/Web/HTML/Element/col" title="The&nbsp;HTML Table Column Element&nbsp;(<col>) defines a column within a table and is used for defining common semantics on all common cells. It is generally found within a <colgroup> element."><code>&lt;col&gt;</code></a>&nbsp;width may also have some effect. In general, if a column's width is too narrow to show a particular cell properly, it, and thus the cells in it, may be widened when displayed. 
<div class="note">
 <strong>Note: </strong>Do not use this attribute in the latest standard: instead set the CSS 
 <a href="/en-US/docs/Web/CSS/width" title="The width CSS property specifies the width of the content area of an element. The content area is inside the padding, border, and margin of the element."><code>width</code></a> property.
</div>
   */
  def width: scala.Option[String] = attributes.get("width").asInstanceOf[scala.Option[String]]
  def width(value: String): Th = copy(attributes = attributes + ("width" -> value.toString)).asInstanceOf[Th]
}
