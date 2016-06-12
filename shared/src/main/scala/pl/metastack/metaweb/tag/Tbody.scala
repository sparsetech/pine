package pl.metastack.metaweb.tag

import pl.metastack.metaweb.tree

/**
 * The HTML Table Body Element (&lt;tbody&gt;) defines one or more <a href="/en-US/docs/Web/HTML/Element/tr" title="The HTML Table Row Element (<tr>) defines a row of cells in a table. Those can be a mix of <td> and <th> elements."><code>&lt;tr&gt;</code></a> element data-rows to be the body of its parent <a href="/en-US/docs/Web/HTML/Element/table" title="The HTML Table Element (<table>) represents data in two dimensions or more."><code>&lt;table&gt;</code></a> element (as long as no &lt;tr&gt; elements are immediate children of that table element.)&nbsp; In conjunction with a preceding <a href="/en-US/docs/Web/HTML/Element/thead" title="The HTML Table Head Element (<thead>) defines a set of rows defining the head of the columns of the table."><code>&lt;thead&gt;</code></a> and/or <a href="/en-US/docs/Web/HTML/Element/tfoot" title="The HTML Table Foot Element (<tfoot>) defines a set of rows summarizing the columns of the table."><code>&lt;tfoot&gt;</code></a> element, &lt;tbody&gt; provides additional semantic information for devices such as printers and displays. Of the parent table's child elements, &lt;tbody&gt; represents the content which, when longer than a page, will most likely differ for each page printed; while the content of <a href="/en-US/docs/Web/HTML/Element/thead" title="The HTML Table Head Element (<thead>) defines a set of rows defining the head of the columns of the table."><code>&lt;thead&gt;</code></a> and <a href="/en-US/docs/Web/HTML/Element/tfoot" title="The HTML Table Foot Element (<tfoot>) defines a set of rows summarizing the columns of the table."><code>&lt;tfoot&gt;</code></a> will be the same or similar for each page printed. For displays, &lt;tbody&gt; will enable separate scrolling of the <a href="/en-US/docs/Web/HTML/Element/thead" title="The HTML Table Head Element (<thead>) defines a set of rows defining the head of the columns of the table."><code>&lt;thead&gt;</code></a>, <a href="/en-US/docs/Web/HTML/Element/tfoot" title="The HTML Table Foot Element (<tfoot>) defines a set of rows summarizing the columns of the table."><code>&lt;tfoot&gt;</code></a>, and <a href="/en-US/docs/Web/HTML/Element/caption" title="The HTML <caption> Element (or HTML Table Caption Element) represents the title of a table. Though it is always the first descendant of a <table>, its styling, using CSS, may place it elsewhere, relative to the table."><code>&lt;caption&gt;</code></a> elements of the same parent <a href="/en-US/docs/Web/HTML/Element/table" title="The HTML Table Element (<table>) represents data in two dimensions or more."><code>&lt;table&gt;</code></a> element.&nbsp; Note that unlike the &lt;thead&gt;, &lt;tfoot&gt;, and &lt;caption&gt; elements however, multiple<strong>&nbsp;</strong><span style="font-family: consolas,monaco,andale mono,monospace;">&lt;tbody&gt; </span>elements are permitted (if consecutive), allowing the data-rows in long tables to be divided into different sections, each separately formatted as needed.
&nbsp;
 */
case class Tbody(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[tree.Node] = Seq.empty) extends HTMLTag[Tbody] {
  override def tagName = "tbody"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[tree.Node] = children): Tbody = Tbody(attributes, children)
  /**
   * This enumerated attribute specifies how horizontal alignment of each cell content will be handled. Possible values are: 
<ul> 
 <li><span style="font-family: courier new;">left</span>, aligning the content to the left of the cell</li> 
 <li><span style="font-family: courier new;">center</span>, centering the content in the cell</li> 
 <li><span style="font-family: courier new;">right</span>, aligning the content to the right of the cell</li> 
 <li><span style="font-family: courier new;">justify</span>, inserting spaces into the textual content so that the content is justified in the cell</li> 
 <li><span style="font-family: courier new;">char</span>, aligning the textual content on a special character with a minimal offset, defined by the <code><a href="/en-US/docs/Web/HTML/Element/tbody#attr-char">char</a></code> and <code><a href="/en-US/docs/Web/HTML/Element/tbody#attr-charoff">charoff</a></code> attributes.</li> 
</ul> 
<p>If this attribute is not set, the <span style="font-family: courier new;">left</span> value is assumed.</p> 
<div class="note">
 <strong>Note: </strong>Do not use this attribute as it is obsolete (not supported) in the latest standard. 
 <ul> 
  <li>To achieve the same effect as the <span style="font-family: courier new;">left</span>, <span style="font-family: courier new;">center</span>, <span style="font-family: courier new;">right</span> or <span style="font-family: courier new;">justify</span> values, use the CSS <a href="/en-US/docs/Web/CSS/text-align" title="The text-align CSS property describes how inline content like text is aligned in its parent block element. text-align does not control the alignment of block elements itself, only their inline content."><code>text-align</code></a> property on it.</li> 
  <li>To achieve the same effect as the <span style="font-family: courier new;">char</span> value, in CSS3, you can use the value of the <code><a href="/en-US/docs/Web/HTML/Element/tbody#attr-char">char</a></code> as the value of the <a href="/en-US/docs/Web/CSS/text-align" title="The text-align CSS property describes how inline content like text is aligned in its parent block element. text-align does not control the alignment of block elements itself, only their inline content."><code>text-align</code></a> property <span class="inlineIndicator unimplemented unimplementedInline">Unimplemented</span>.</li> 
 </ul> 
</div>
   */
  def align: scala.Option[String] = attributes.get("align").asInstanceOf[scala.Option[String]]
  def align(value: String): Tbody = copy(attributes = attributes + ("align" -> value)).asInstanceOf[Tbody]
  /**
   * This attribute defines the background color of each cell of the column. It is one of the 6-digit hexadecimal code as defined in 
<a class="external" href="http://www.w3.org/Graphics/Color/sRGB" title="http://www.w3.org/Graphics/Color/sRGB">sRGB</a>, prefixed by a '#'. One of the sixteen predefined color strings may be used: 
<table style="width: 80%;"> 
 <tbody> 
  <tr> 
   <td style="background-color: black; width: 24px; height: 24px; border-width: 1px; border-color: black; border-style: solid;">&nbsp;</td> 
   <td><span style="font-family: courier new;">black</span> = "#000000"</td> 
   <td style="background-color: green; width: 24px; height: 24px; border-width: 1px; border-color: black; border-style: solid;">&nbsp;</td> 
   <td><span style="font-family: courier new;">green</span> = "#008000"</td> 
  </tr> 
  <tr> 
   <td style="background-color: silver; width: 24px; height: 24px; border-width: 1px; border-color: black; border-style: solid;">&nbsp;</td> 
   <td><span style="font-family: courier new;">silver</span> = "#C0C0C0"</td> 
   <td style="background-color: lime; width: 24px; height: 24px; border-width: 1px; border-color: black; border-style: solid;">&nbsp;</td> 
   <td><span style="font-family: courier new;">lime</span> = "#00FF00"</td> 
  </tr> 
  <tr> 
   <td style="background-color: gray; width: 24px; height: 24px; border-width: 1px; border-color: black; border-style: solid;">&nbsp;</td> 
   <td><span style="font-family: courier new;">gray</span> = "#808080"</td> 
   <td style="background-color: olive; width: 24px; height: 24px; border-width: 1px; border-color: black; border-style: solid;">&nbsp;</td> 
   <td><span style="font-family: courier new;">olive</span> = "#808000"</td> 
  </tr> 
  <tr> 
   <td style="background-color: white; width: 24px; height: 24px; border-width: 1px; border-color: black; border-style: solid;">&nbsp;</td> 
   <td><span style="font-family: courier new;">white</span> = "#FFFFFF"</td> 
   <td style="background-color: yellow; width: 24px; height: 24px; border-width: 1px; border-color: black; border-style: solid;">&nbsp;</td> 
   <td><span style="font-family: courier new;">yellow</span> = "#FFFF00"</td> 
  </tr> 
  <tr> 
   <td style="background-color: maroon; width: 24px; height: 24px; border-width: 1px; border-color: black; border-style: solid;">&nbsp;</td> 
   <td><span style="font-family: courier new;">maroon</span> = "#800000"</td> 
   <td style="background-color: navy; width: 24px; height: 24px; border-width: 1px; border-color: black; border-style: solid;">&nbsp;</td> 
   <td><span style="font-family: courier new;">navy</span> = "#000080"</td> 
  </tr> 
  <tr> 
   <td style="background-color: red; width: 24px; height: 24px; border-width: 1px; border-color: black; border-style: solid;">&nbsp;</td> 
   <td><span style="font-family: courier new;">red</span> = "#FF0000"</td> 
   <td style="background-color: blue; width: 24px; height: 24px; border-width: 1px; border-color: black; border-style: solid;">&nbsp;</td> 
   <td><span style="font-family: courier new;">blue</span> = "#0000FF"</td> 
  </tr> 
  <tr> 
   <td style="background-color: purple; width: 24px; height: 24px; border-width: 1px; border-color: black; border-style: solid;">&nbsp;</td> 
   <td><span style="font-family: courier new;">purple</span> = "#800080"</td> 
   <td style="background-color: teal; width: 24px; height: 24px; border-width: 1px; border-color: black; border-style: solid;">&nbsp;</td> 
   <td><span style="font-family: courier new;">teal</span> = "#008080"</td> 
  </tr> 
  <tr> 
   <td style="background-color: fuchsia; width: 24px; height: 24px; border-width: 1px; border-color: black; border-style: solid;">&nbsp;</td> 
   <td><span style="font-family: courier new;">fuchsia</span> = "#FF00FF"</td> 
   <td style="background-color: aqua; width: 24px; height: 24px; border-width: 1px; border-color: black; border-style: solid;">&nbsp;</td> 
   <td><span style="font-family: courier new;">aqua</span> = "#00FFFF"</td> 
  </tr> 
 </tbody> 
</table> 
<div class="note">
 <strong>Usage note:&nbsp;</strong>Do not use this attribute, as it is non-standard and only implemented some versions of Microsoft Internet Explorer: the 
 <a href="/en-US/docs/Web/HTML/Element/tbody" title="The HTML Table Body Element (<tbody>) defines one or more <tr> element data-rows to be the body of its parent <table> element (as long as no <tr> elements are immediate children of that table element.) &nbsp;In conjunction with a preceding <thead> and/or <tfoot> element, <tbody> provides additional semantic information for devices such as printers and displays. Of the parent table's child elements, <tbody> represents the content which, when longer than a page, will most likely differ for each page printed; while the content of <thead> and <tfoot> will be the same or similar for each page printed. For displays, <tbody> will enable separate scrolling of the <thead>, <tfoot>, and <caption> elements of the same parent <table> element. &nbsp;Note that unlike the <thead>, <tfoot>, and <caption>&nbsp;elements however, multiple&nbsp;<tbody>&nbsp;elements are permitted (if consecutive), allowing the data-rows in long tables to be divided into different sections, each separately formatted as needed."><code>&lt;tbody&gt;</code></a> element should be styled using 
 <a href="/en/CSS" title="en/CSS">CSS</a>. To give a similar effect to the 
 <strong>bgcolor</strong> attribute, use the 
 <a href="/en/CSS" title="en/CSS">CSS</a> property 
 <a href="/en-US/docs/Web/CSS/background-color" title="The background-color CSS property sets the background color of an element, either through a color value or the keyword transparent."><code>background-color</code></a>, on the relevant 
 <a href="/en-US/docs/Web/HTML/Element/td" title="The Table cell HTML element (<td>) defines a cell of a table that contains data. It participates in the table model."><code>&lt;td&gt;</code></a> or 
 <a href="/en-US/docs/Web/HTML/Element/th" title="Editorial review completed."><code>&lt;th&gt;</code></a> elements.
</div>
   */
  def bgcolor: scala.Option[String] = attributes.get("bgcolor").asInstanceOf[scala.Option[String]]
  def bgcolor(value: String): Tbody = copy(attributes = attributes + ("bgcolor" -> value)).asInstanceOf[Tbody]
  /**
   * This attribute is used to set the character to align the cells in a column on. Typical values for this include a period (.) when attempting to align numbers or monetary values. If 
<code><a href="/en-US/docs/Web/HTML/Element/tbody#attr-align">align</a></code> is not set to 
<span style="font-family: courier new;">char</span>, this attribute is ignored. 
<div class="note">
 <strong>Note: </strong>Do not use this attribute as it is obsolete (and not supported) in the latest standard. To achieve the same effect as the 
 <code><a href="/en-US/docs/Web/HTML/Element/tbody#attr-char">char</a></code>, in CSS3, you can use the character set using the 
 <code><a href="/en-US/docs/Web/HTML/Element/tbody#attr-char">char</a></code> attribute as the value of the 
 <a href="/en-US/docs/Web/CSS/text-align" title="The text-align CSS property describes how inline content like text is aligned in its parent block element. text-align does not control the alignment of block elements itself, only their inline content."><code>text-align</code></a> property 
 <span class="inlineIndicator unimplemented unimplementedInline">Unimplemented</span>.
</div>
   */
  def char: scala.Option[String] = attributes.get("char").asInstanceOf[scala.Option[String]]
  def char(value: String): Tbody = copy(attributes = attributes + ("char" -> value)).asInstanceOf[Tbody]
  /**
   * This attribute is used to indicate the number of characters to offset the column data from the alignment characters specified by the 
<strong>char</strong> attribute. 
<div class="note">
 <strong>Note: </strong>Do not use this attribute as it is obsolete (and not supported) in the latest standard.
</div>
   */
  def charoff: scala.Option[String] = attributes.get("charoff").asInstanceOf[scala.Option[String]]
  def charoff(value: String): Tbody = copy(attributes = attributes + ("charoff" -> value)).asInstanceOf[Tbody]
  /**
   * This attribute specifies the vertical alignment of the text within each row of cells of the table header. Possible values for this attribute are: 
<ul> 
 <li><span style="font-family: courier new;">baseline</span>, which will put the text as close to the bottom of the cell as it is possible, but align it on the <a class="external" href="http://en.wikipedia.org/wiki/Baseline_%28typography%29" title="http://en.wikipedia.org/wiki/Baseline_(typography)">baseline</a> of the characters instead of the bottom of them. If characters are all of the size, this has the same effect as <span style="font-family: courier new;">bottom</span>.</li> 
 <li><span style="font-family: courier new;">bottom</span>, which will put the text as close to the bottom of the cell as it is possible;</li> 
 <li><span style="font-family: courier new;">middle</span>, which will center the text in the cell;</li> 
 <li>and <span style="font-family: courier new;">top</span>, which will put the text as close to the top of the cell as it is possible.</li> 
</ul> 
<div class="note">
 <strong>Note: </strong>Do not use this attribute as it is obsolete (and not supported) in the latest standard: instead set the CSS&nbsp;
 <a href="/en-US/docs/Web/CSS/vertical-align" title="The vertical-align CSS property specifies the vertical alignment of an inline or table-cell box."><code>vertical-align</code></a> property on it.
</div>
   */
  def valign: scala.Option[String] = attributes.get("valign").asInstanceOf[scala.Option[String]]
  def valign(value: String): Tbody = copy(attributes = attributes + ("valign" -> value)).asInstanceOf[Tbody]
}
