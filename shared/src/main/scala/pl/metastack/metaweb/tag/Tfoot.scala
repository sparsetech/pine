package pl.metastack.metaweb.tag

import pl.metastack.metaweb.tree

/**
 * The <em>HTML Table Foot Element</em> (<code>&lt;tfoot&gt;</code>) defines a set of rows summarizing the columns of the table.
 */
case class Tfoot(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[tree.Node] = Seq.empty) extends HTMLTag[Tfoot] {
  override def tagName = "tfoot"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[tree.Node] = children): Tfoot = Tfoot(attributes, children)
  /**
   * This enumerated attribute specifies how horizontal alignment of each cell content will be handled. Possible values are: 
<ul> 
 <li><span style="font-family: Courier New;">left</span>, aligning the content to the left of the cell</li> 
 <li><span style="font-family: Courier New;">center</span>, centering the content in the cell</li> 
 <li><span style="font-family: Courier New;">right</span>, aligning the content to the right of the cell</li> 
 <li><span style="font-family: Courier New;">justify</span>, inserting spaces into the textual content so that the content is justified in the cell</li> 
 <li><span style="font-family: Courier New;">char</span>, aligning the textual content on a special character with a minimal offset, defined by the <code><a href="/en-US/docs/Web/HTML/Element/tbody#attr-char">char</a></code> and <code><a href="/en-US/docs/Web/HTML/Element/tbody#attr-charoff">charoff</a></code> attributes <span class="inlineIndicator unimplemented unimplementedInline">Unimplemented (see <a class="external" href="https://bugzilla.mozilla.org/show_bug.cgi?id=2212" title="character alignment not implemented (align=char, charoff=, text-align:<string>)">bug&nbsp;2212</a>)</span>.</li> 
</ul> 
<p>If this attribute is not set,&nbsp; the <span style="font-family: Courier New;">left</span> value is assumed.</p> 
<div class="note">
 <strong>Note: </strong>Do not use this attribute as it is obsolete (not supported) in the latest standard. 
 <ul> 
  <li>To achieve the same effect as the <span style="font-family: Courier New;">left</span>, <span style="font-family: Courier New;">center</span>, <span style="font-family: Courier New;">right</span> or <span style="font-family: Courier New;">justify</span> values, use the CSS <a href="/en-US/docs/Web/CSS/text-align" title="The text-align CSS property describes how inline content like text is aligned in its parent block element. text-align does not control the alignment of block elements itself, only their inline content."><code>text-align</code></a> property on it.</li> 
  <li>To achieve the same effect as the <span style="font-family: Courier New;">char</span> value, in CSS3, you can use the value of the <code><a href="/en-US/docs/Web/HTML/Element/tfoot#attr-char">char</a></code> as the value of the <a href="/en-US/docs/Web/CSS/text-align" title="The text-align CSS property describes how inline content like text is aligned in its parent block element. text-align does not control the alignment of block elements itself, only their inline content."><code>text-align</code></a> property <span class="inlineIndicator unimplemented unimplementedInline">Unimplemented</span>.</li> 
 </ul> 
</div>
   */
  def align: scala.Option[String] = attributes.get("align").asInstanceOf[scala.Option[String]]
  def align(value: String): Tfoot = copy(attributes = attributes + ("align" -> value.toString)).asInstanceOf[Tfoot]
  /**
   * This attribute defines the background color of each cell of the column. It is one of the 6-digit hexadecimal code as defined in 
<a class="external" href="http://www.w3.org/Graphics/Color/sRGB" title="http://www.w3.org/Graphics/Color/sRGB">sRGB</a>, prefixed by a '#'. One of the sixteen predefined color strings may be used: 
<table> 
 <tbody> 
  <tr> 
   <td style="background-color: black; width: 24px; height: 24px; border-width: 1px; border-color: black; border-style: solid;">&nbsp;</td> 
   <td><span style="font-family: Courier New;">black</span> = "#000000"</td> 
   <td style="background-color: green; width: 24px; height: 24px; border-width: 1px; border-color: black; border-style: solid;">&nbsp;</td> 
   <td><span style="font-family: Courier New;">green</span> = "#008000"</td> 
  </tr> 
  <tr> 
   <td style="background-color: silver; width: 24px; height: 24px; border-width: 1px; border-color: black; border-style: solid;">&nbsp;</td> 
   <td><span style="font-family: Courier New;">silver</span> = "#C0C0C0"</td> 
   <td style="background-color: lime; width: 24px; height: 24px; border-width: 1px; border-color: black; border-style: solid;">&nbsp;</td> 
   <td><span style="font-family: Courier New;">lime</span> = "#00FF00"</td> 
  </tr> 
  <tr> 
   <td style="background-color: gray; width: 24px; height: 24px; border-width: 1px; border-color: black; border-style: solid;">&nbsp;</td> 
   <td><span style="font-family: Courier New;">gray</span> = "#808080"</td> 
   <td style="background-color: olive; width: 24px; height: 24px; border-width: 1px; border-color: black; border-style: solid;">&nbsp;</td> 
   <td><span style="font-family: Courier New;">olive</span> = "#808000"</td> 
  </tr> 
  <tr> 
   <td style="background-color: white; width: 24px; height: 24px; border-width: 1px; border-color: black; border-style: solid;">&nbsp;</td> 
   <td><span style="font-family: Courier New;">white</span> = "#FFFFFF"</td> 
   <td style="background-color: yellow; width: 24px; height: 24px; border-width: 1px; border-color: black; border-style: solid;">&nbsp;</td> 
   <td><span style="font-family: Courier New;">yellow</span> = "#FFFF00"</td> 
  </tr> 
  <tr> 
   <td style="background-color: maroon; width: 24px; height: 24px; border-width: 1px; border-color: black; border-style: solid;">&nbsp;</td> 
   <td><span style="font-family: Courier New;">maroon</span> = "#800000"</td> 
   <td style="background-color: navy; width: 24px; height: 24px; border-width: 1px; border-color: black; border-style: solid;">&nbsp;</td> 
   <td><span style="font-family: Courier New;">navy</span> = "#000080"</td> 
  </tr> 
  <tr> 
   <td style="background-color: red; width: 24px; height: 24px; border-width: 1px; border-color: black; border-style: solid;">&nbsp;</td> 
   <td><span style="font-family: Courier New;">red</span> = "#FF0000"</td> 
   <td style="background-color: blue; width: 24px; height: 24px; border-width: 1px; border-color: black; border-style: solid;">&nbsp;</td> 
   <td><span style="font-family: Courier New;">blue</span> = "#0000FF"</td> 
  </tr> 
  <tr> 
   <td style="background-color: purple; width: 24px; height: 24px; border-width: 1px; border-color: black; border-style: solid;">&nbsp;</td> 
   <td><span style="font-family: Courier New;">purple</span> = "#800080"</td> 
   <td style="background-color: teal; width: 24px; height: 24px; border-width: 1px; border-color: black; border-style: solid;">&nbsp;</td> 
   <td><span style="font-family: Courier New;">teal</span> = "#008080"</td> 
  </tr> 
  <tr> 
   <td style="background-color: fuchsia; width: 24px; height: 24px; border-width: 1px; border-color: black; border-style: solid;">&nbsp;</td> 
   <td><span style="font-family: Courier New;">fuchsia</span> = "#FF00FF"</td> 
   <td style="background-color: aqua; width: 24px; height: 24px; border-width: 1px; border-color: black; border-style: solid;">&nbsp;</td> 
   <td><span style="font-family: Courier New;">aqua</span> = "#00FFFF"</td> 
  </tr> 
 </tbody> 
</table> 
<div class="note">
 <strong>Usage note:&nbsp;</strong>Do not use this attribute, as it is non-standard and only implemented some versions of Microsoft Internet Explorer: the 
 <a href="/en-US/docs/Web/HTML/Element/tfoot" title="The HTML Table Foot Element (<tfoot>) defines a set of rows summarizing the columns of the table."><code>&lt;tfoot&gt;</code></a> element should be styled using 
 <a href="/en/CSS" title="en/CSS">CSS</a>. To give a similar effect to the 
 <strong>bgcolor</strong> attribute, use the 
 <a href="/en/CSS" title="en/CSS">CSS</a> property 
 <a href="/en-US/docs/Web/CSS/background-color" title="The background-color CSS property sets the background color of an element, either through a color value or the keyword transparent."><code>background-color</code></a>, on the relevant 
 <a href="/en-US/docs/Web/HTML/Element/td" title="The Table cell HTML element (<td>) defines a cell of a table that contains data. It participates in the table model."><code>&lt;td&gt;</code></a> or 
 <a href="/en-US/docs/Web/HTML/Element/th" title="The HTML Table Header Cell Element (<th>) defines a cell that is a header for a group of cells of a table. The group of cells that the header refers to is defined by the scope and headers attribute."><code>&lt;th&gt;</code></a> elements.
</div>
   */
  def bgcolor: scala.Option[String] = attributes.get("bgcolor").asInstanceOf[scala.Option[String]]
  def bgcolor(value: String): Tfoot = copy(attributes = attributes + ("bgcolor" -> value.toString)).asInstanceOf[Tfoot]
  /**
   * This attribute is used to set the character to align the cells in a column on. Typical values for this include a period (.) when attempting to align numbers or monetary values. If 
<code><a href="/en-US/docs/Web/HTML/Element/tfoot#attr-align">align</a></code> is not set to 
<span style="font-family: Courier New;">char</span>, this attribute is ignored. 
<div class="note">
 <strong>Note: </strong>Do not use this attribute as it is obsolete (and not supported) in the latest standard. To achieve the same effect as the 
 <code><a class="new" href="/en-US/docs/Web/HTML/Element/tbtfootody#attr-char">char</a></code>, in CSS3, you can use the character set using the 
 <code><a href="/en-US/docs/Web/HTML/Element/tfoot#attr-char">char</a></code> attribute as the value of the 
 <a href="/en-US/docs/Web/CSS/text-align" title="The text-align CSS property describes how inline content like text is aligned in its parent block element. text-align does not control the alignment of block elements itself, only their inline content."><code>text-align</code></a> property 
 <span class="inlineIndicator unimplemented unimplementedInline">Unimplemented</span>.
</div>
   */
  def char: scala.Option[String] = attributes.get("char").asInstanceOf[scala.Option[String]]
  def char(value: String): Tfoot = copy(attributes = attributes + ("char" -> value.toString)).asInstanceOf[Tfoot]
  /**
   * This attribute is used to indicate the number of characters to offset the column data from the alignment characters specified by the 
<strong>char</strong> attribute. 
<div class="note">
 <strong>Note: </strong>Do not use this attribute as it is obsolete (and not supported) in the latest standard.
</div>
   */
  def charoff: scala.Option[String] = attributes.get("charoff").asInstanceOf[scala.Option[String]]
  def charoff(value: String): Tfoot = copy(attributes = attributes + ("charoff" -> value.toString)).asInstanceOf[Tfoot]
  /**
   * This attribute specifies the vertical alignment of the text within each row of cells of the table header. Possible values for this attribute are: 
<ul> 
 <li><span style="font-family: Courier New;">baseline</span>, which will put the text as close to the bottom of the cell as it is possible, but align it on the <a class="external" href="http://en.wikipedia.org/wiki/Baseline_%28typography%29" title="http://en.wikipedia.org/wiki/Baseline_(typography)">baseline</a> of the characters instead of the bottom of them. If characters are all of the size, this has the same effect as <span style="font-family: Courier New;">bottom</span>.</li> 
 <li><span style="font-family: Courier New;">bottom</span>, which will put the text as close to the bottom of the cell as it is possible;</li> 
 <li><span style="font-family: Courier New;">middle</span>, which will center the text in the cell;</li> 
 <li>and <span style="font-family: Courier New;">top</span>, which will put the text as close to the top of the cell as it is possible.</li> 
</ul> 
<div class="note">
 <strong>Note: </strong>Do not use this attribute as it is obsolete (and not supported) in the latest standard: instead set the CSS&nbsp;
 <a href="/en-US/docs/Web/CSS/vertical-align" title="The vertical-align CSS property specifies the vertical alignment of an inline or table-cell box."><code>vertical-align</code></a> property on it.
</div>
   */
  def valign: scala.Option[String] = attributes.get("valign").asInstanceOf[scala.Option[String]]
  def valign(value: String): Tfoot = copy(attributes = attributes + ("valign" -> value.toString)).asInstanceOf[Tfoot]
}
