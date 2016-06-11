package pl.metastack.metaweb.tag

import pl.metastack.metaweb.tree

/**
 * The&nbsp;<em>HTML Table Column Group Element</em>&nbsp;(<strong>&lt;colgroup&gt;</strong>) defines a group of columns within a table.
 */
case class Colgroup(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[tree.Node] = Seq.empty) extends tree.Tag with HTMLTag {
  override def tagName = "colgroup"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[tree.Node] = children): Colgroup = Colgroup(attributes, children)
  /**
   * This enumerated attribute specifies how horizontal alignment of each column cell content will be handled. Possible values are: 
<ul> 
 <li><code>left</code>, aligning the content to the left of the cell</li> 
 <li><code>center</code>, centering the content in the cell</li> 
 <li><code>right</code>, aligning the content to the right of the cell</li> 
 <li><code>justify</code>, inserting spaces into the textual content so that the content is justified in the cell</li> 
 <li><code>char</code>, aligning the textual content on a special character with a minimal offset, defined by the <code><a href="/en-US/docs/Web/HTML/Element/col#attr-char">char</a></code> and <code><a href="/en-US/docs/Web/HTML/Element/col#attr-charoff">charoff</a></code> attributes <span class="inlineIndicator unimplemented unimplementedInline">Unimplemented (see <a href="https://bugzilla.mozilla.org/show_bug.cgi?id=2212" class="external" title="character alignment not implemented (align=char, charoff=, text-align:<string>)">bug&nbsp;2212</a>)</span>.</li> 
</ul> 
<p>If this attribute is not set, the <code>left</code> value is assumed. The descendant <a href="/en-US/docs/Web/HTML/Element/col" title="The&nbsp;HTML Table Column Element&nbsp;(<col>) defines a column within a table and is used for defining common semantics on all common cells. It is generally found within a <colgroup> element."><code>&lt;col&gt;</code></a> elements may override this value using their own <code><a href="/en-US/docs/Web/HTML/Element/col#attr-align">align</a></code> attribute.</p> 
<div class="note">
 <strong>Note: </strong>Do not use this attribute as it is obsolete (not supported) in the latest standard. 
 <ul> 
  <li>To achieve the same effect as the <code>left</code>, <code>center</code>, <code>right</code> or <code>justify</code> values: 
   <ul> 
    <li>Do not try to set the <a href="/en-US/docs/Web/CSS/text-align" title="The text-align CSS property describes how inline content like text is aligned in its parent block element. text-align does not control the alignment of block elements itself, only their inline content."><code>text-align</code></a> property on a selector giving a <a href="/en-US/docs/Web/HTML/Element/colgroup" title="The&nbsp;HTML Table Column Group Element&nbsp;(<colgroup>) defines a group of columns within a table."><code>&lt;colgroup&gt;</code></a> element. Because <a href="/en-US/docs/Web/HTML/Element/td" title="The Table cell HTML element (<td>) defines a cell of a table that contains data. It participates in the table model."><code>&lt;td&gt;</code></a> elements are not descendant of the <a href="/en-US/docs/Web/HTML/Element/colgroup" title="The&nbsp;HTML Table Column Group Element&nbsp;(<colgroup>) defines a group of columns within a table."><code>&lt;colgroup&gt;</code></a> element, they won't inherit it.</li> 
    <li>If the table doesn't use a <code><a href="/en-US/docs/Web/HTML/Element/td#attr-colspan">colspan</a></code> attribute, use one <code>td:nth-child(an+b)</code> CSS selector per column, where a is the total number of the columns in the table and b is the ordinal position of this column in the table. Only after this selector the <a href="/en-US/docs/Web/CSS/text-align" title="The text-align CSS property describes how inline content like text is aligned in its parent block element. text-align does not control the alignment of block elements itself, only their inline content."><code>text-align</code></a> property can be used.</li> 
    <li>If the table does use a <code><a href="/en-US/docs/Web/HTML/Element/td#attr-colspan">colspan</a></code> attribute, the effect can be achieved by combining adequate CSS attribute selectors like <code>[colspan=n]</code>, though this is not trivial.</li> 
   </ul> </li> 
  <li>To achieve the same effect as the <code>char</code> value, in CSS3, you can use the value of the <code><a href="/en-US/docs/Web/HTML/Element/colgroup#attr-char">char</a></code> as the value of the <a href="/en-US/docs/Web/CSS/text-align" title="The text-align CSS property describes how inline content like text is aligned in its parent block element. text-align does not control the alignment of block elements itself, only their inline content."><code>text-align</code></a> property <span class="inlineIndicator unimplemented unimplementedInline">Unimplemented</span>.</li> 
 </ul> 
</div>
   */
  def align: scala.Option[String] = attributes.get("align").asInstanceOf[scala.Option[String]]
  /**
   * This attribute defines the background color of each cell of the columns member of the column group. It is one of the 6-digit hexadecimal code as defined in 
<a href="http://www.w3.org/Graphics/Color/sRGB" class="external" title="http://www.w3.org/Graphics/Color/sRGB">sRGB</a>, prefixed by a '#'. One of the sixteen predefined color strings, as mentioned below, may be used: 
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
   <td><code>teal = "#008080"</code></td> 
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
 <strong>Usage note:&nbsp;</strong>Do not use this attribute, as it is non-standard and is only implemented in some versions of Microsoft Internet Explorer; the 
 <a href="/en-US/docs/Web/HTML/Element/colgroup" title="The&nbsp;HTML Table Column Group Element&nbsp;(<colgroup>) defines a group of columns within a table."><code>&lt;colgroup&gt;</code></a> elements should be styled using 
 <a href="/en-US/docs/CSS" title="CSS">CSS</a>. To give a similar effect to the 
 <strong>bgcolor</strong> attribute, use the 
 <a href="/en-US/docs/CSS" title="CSS">CSS</a> property 
 <a href="/en-US/docs/Web/CSS/background-color" title="The background-color CSS property sets the background color of an element, either through a color value or the keyword transparent."><code>background-color</code></a> on the relevant 
 <a href="/en-US/docs/Web/HTML/Element/td" title="The Table cell HTML element (<td>) defines a cell of a table that contains data. It participates in the table model."><code>&lt;td&gt;</code></a> elements.
</div>
   */
  def bgcolor: scala.Option[String] = attributes.get("bgcolor").asInstanceOf[scala.Option[String]]
  /**
   * This attribute specifies the 
<span id="c80j9f_6" class="c80j9f">alignment</span> of the content in a column group to a character. Typical values for this include a period (.) when attempting to align numbers or monetary values. If 
<code><a href="/en-US/docs/Web/HTML/Element/colgroup#attr-align">align</a></code> is not set to 
<code>char</code>, this attribute is ignored, though it will still be used as the default value for the 
<code><a href="/en-US/docs/Web/HTML/Element/col#attr-align">align</a></code> of the 
<a href="/en-US/docs/Web/HTML/Element/col" title="The&nbsp;HTML Table Column Element&nbsp;(<col>) defines a column within a table and is used for defining common semantics on all common cells. It is generally found within a <colgroup> element."><code>&lt;col&gt;</code></a> which are members of this column group. 
<div class="note">
 <strong>Note: </strong>Do not use this attribute as it is obsolete (and not supported) in the latest standard. To achieve the same effect as the 
 <code><a href="/en-US/docs/Web/HTML/Element/colgroup#attr-char">char</a></code>, in CSS3, you can use the character set using the 
 <code><a href="/en-US/docs/Web/HTML/Element/colgroup#attr-char">char</a></code> attribute as the value of the 
 <a href="/en-US/docs/Web/CSS/text-align" title="The text-align CSS property describes how inline content like text is aligned in its parent block element. text-align does not control the alignment of block elements itself, only their inline content."><code>text-align</code></a> property 
 <span class="inlineIndicator unimplemented unimplementedInline">Unimplemented</span>.
</div>
   */
  def char: scala.Option[String] = attributes.get("char").asInstanceOf[scala.Option[String]]
  /**
   * This attribute is used to indicate the number of characters to offset the column data from the alignment character specified by the 
<strong>char</strong> attribute. 
<div class="note">
 <strong>Note: </strong>Do not use this attribute as it is obsolete (and not supported) in the latest standard.
</div>
   */
  def charoff: scala.Option[String] = attributes.get("charoff").asInstanceOf[scala.Option[String]]
  /**
   * This attribute contains a positive integer indicating the number of consecutive columns the 
<code>&lt;colgroup&gt;</code> element spans. If not present, its default value is 
<code>1</code>. 
<div class="note">
 <strong>Note: </strong>This attribute is applied on the attributes of the column group, it has no effect on the CSS styling rules associated with it or, even more, to the cells of the column's members of the group. 
 <ul> 
  <li>The <code>span</code> attribute may not be present if there are one or more <code>&lt;col&gt;</code> elements within the <code>&lt;colgroup&gt;</code>.</li> 
 </ul> 
</div>
   */
  def span: scala.Option[Long] = attributes.get("span").asInstanceOf[scala.Option[Long]]
  /**
   * This attribute specifies the vertical alignment of the text within each cell of the column. Possible values for this attribute are: 
<ul> 
 <li><code>baseline</code>, which will put the text as close to the bottom of the cell as it is possible, but align it on the <a href="http://en.wikipedia.org/wiki/Baseline_%28typography%29" class="external" title="http://en.wikipedia.org/wiki/Baseline_(typography)">baseline</a> of the characters instead of the bottom of them. If characters are all of the size, this has the same effect as <code>bottom</code>.</li> 
 <li><code>bottom</code>, which will put the text as close to the bottom of the cell as it is possible;</li> 
 <li><code>middle</code>, which will center the text in the cell;</li> 
 <li>and <code>top</code>, which will put the text as close to the top of the cell as it is possible.</li> 
</ul> 
<div class="note">
 <strong>Note: </strong>Do not use this attribute as it is obsolete (and not supported) in the latest standard: 
 <ul> 
  <li>Do not try to set the <a href="/en-US/docs/Web/CSS/vertical-align" title="The vertical-align CSS property specifies the vertical alignment of an inline or table-cell box."><code>vertical-align</code></a> property on a selector giving a <a href="/en-US/docs/Web/HTML/Element/colgroup" title="The&nbsp;HTML Table Column Group Element&nbsp;(<colgroup>) defines a group of columns within a table."><code>&lt;colgroup&gt;</code></a> element. Because <a href="/en-US/docs/Web/HTML/Element/td" title="The Table cell HTML element (<td>) defines a cell of a table that contains data. It participates in the table model."><code>&lt;td&gt;</code></a> elements are not descendant of the <a href="/en-US/docs/Web/HTML/Element/colgroup" title="The&nbsp;HTML Table Column Group Element&nbsp;(<colgroup>) defines a group of columns within a table."><code>&lt;colgroup&gt;</code></a> element, they won't inherit it.</li> 
  <li>If the table doesn't use a <code><a href="/en-US/docs/Web/HTML/Element/td#attr-colspan">colspan</a></code> attribute, use the <code>td:nth-child(an+b)</code> CSS selector per column, where a is the total number of the columns in the table and b is the ordinal position of the column in the table. Only after this selector the <a href="/en-US/docs/Web/CSS/vertical-align" title="The vertical-align CSS property specifies the vertical alignment of an inline or table-cell box."><code>vertical-align</code></a> property can be used.</li> 
  <li>If the table does use a <code><a href="/en-US/docs/Web/HTML/Element/td#attr-colspan">colspan</a></code> attribute, the effect can be achieved by combining adequate CSS attribute selectors like <code>[colspan=n]</code>, though this is not trivial.</li> 
 </ul> 
</div>
   */
  def valign: scala.Option[String] = attributes.get("valign").asInstanceOf[scala.Option[String]]
  /**
   * This attribute specifies a default width for each column in the current column group. In addition to the standard pixel and percentage values, this attribute might take the special form 
<code>0*</code>, which means that the width of each column in the group should be the minimum width necessary to hold the column's contents. Relative widths such as 
<code>0.5*</code> also can be used.
   */
  def width: scala.Option[String] = attributes.get("width").asInstanceOf[scala.Option[String]]
}
