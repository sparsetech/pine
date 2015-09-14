package pl.metastack.metaweb.tag

import pl.metastack.metarx._
import pl.metastack.metaweb.state

/**
 * The <em>HTML Table Head Element</em> (<code>&lt;thead&gt;</code>) defines a set of rows defining the head of the columns of the table.
 */
class Thead extends state.Tag("thead") with HTMLTag {
  /**
   * This enumerated attribute specifies how horizontal alignment of each cell content will be handled. Possible values are: 
<ul> 
 <li><code>left</code>, aligning the content to the left of the cell</li> 
 <li><code>center</code>, centering the content in the cell</li> 
 <li><code>right</code>, aligning the content to the right of the cell</li> 
 <li><code>justify</code>, inserting spaces into the textual content so that the content is justified in the cell</li> 
 <li><code>char</code>, aligning the textual content on a special character with a minimal offset, defined by the <code><a href="/en-US/docs/Web/HTML/Element/thead#attr-char">char</a></code> and <code><a href="/en-US/docs/Web/HTML/Element/thead#attr-charoff">charoff</a></code> attributes <span class="inlineIndicator unimplemented unimplementedInline">Unimplemented (see <a class="external" href="https://bugzilla.mozilla.org/show_bug.cgi?id=2212" title="character alignment not implemented (align=char, charoff=, text-align:<string>)">bug&nbsp;2212</a>)</span>.</li> 
</ul> 
<p>If this attribute is not set,&nbsp; the <span style="font-family: Courier New;">left</span> value is assumed.</p> 
<div class="note"> 
 <strong>Note: </strong>Do not use this attribute as it is obsolete (not supported) in the latest standard. 
 <ul> 
  <li>To achieve the same effect as the <span style="font-family: Courier New;">left</span>, <span style="font-family: Courier New;">center</span>, <span style="font-family: Courier New;">right</span> or <span style="font-family: Courier New;">justify</span> values, use the CSS <a href="/en-US/docs/Web/CSS/text-align" title="The text-align CSS property describes how inline content like text is aligned in its parent block element. text-align does not control the alignment of block elements itself, only their inline content."><code>text-align</code></a> property on it.</li> 
  <li>To achieve the same effect as the <span style="font-family: Courier New;">char</span> value, in CSS3, you can use the value of the <code><a href="/en-US/docs/Web/HTML/Element/thead#attr-char">char</a></code> as the value of the <a href="/en-US/docs/Web/CSS/text-align" title="The text-align CSS property describes how inline content like text is aligned in its parent block element. text-align does not control the alignment of block elements itself, only their inline content."><code>text-align</code></a> property <span class="inlineIndicator unimplemented unimplementedInline">Unimplemented</span>.</li> 
 </ul> 
</div>
   */
  def align: StateChannel[String] = attribute("align").asInstanceOf[StateChannel[String]]
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
 <strong>Usage note:&nbsp;</strong>Do not use this attribute, as it is non-standard and only implemented in some versions of Microsoft Internet Explorer: the 
 <a href="/en-US/docs/Web/HTML/Element/thead" title="The HTML Table Head Element (<thead>) defines a set of rows defining the head of the columns of the table."><code>&lt;thead&gt;</code></a> element should be styled using 
 <a href="/en/CSS" title="en/CSS">CSS</a>. To give a similar effect to the 
 <strong>bgcolor</strong> attribute, use the 
 <a href="/en/CSS" title="en/CSS">CSS</a> property 
 <a href="/en-US/docs/Web/CSS/background-color" title="The background-color CSS property sets the background color of an element, either through a color value or the keyword transparent."><code>background-color</code></a>, on the relevant 
 <a href="/en-US/docs/Web/HTML/Element/td" title="The Table cell HTML element (<td>) defines a cell of a table that contains data. It participates in the table model."><code>&lt;td&gt;</code></a> or 
 <a href="/en-US/docs/Web/HTML/Element/th" title="Editorial review completed."><code>&lt;th&gt;</code></a> elements.
</div>
   */
  def bgcolor: StateChannel[String] = attribute("bgcolor").asInstanceOf[StateChannel[String]]
  /**
   * This attribute is used to set the character to align the cells in a column on. Typical values for this include a period (.) when attempting to align numbers or monetary values. If 
<code><a href="/en-US/docs/Web/HTML/Element/tr#attr-align">align</a></code> is not set to 
<span style="font-family: Courier New;">char</span>, this attribute is ignored. 
<div class="note"> 
 <strong>Note: </strong>Do not use this attribute as it is obsolete (and not supported) in the latest standard. To achieve the same effect as the 
 <code><a href="/en-US/docs/Web/HTML/Element/thead#attr-char">char</a></code>, in CSS3, you can use the character set using the 
 <code><a href="/en-US/docs/Web/HTML/Element/thead#attr-char">char</a></code> attribute as the value of the 
 <a href="/en-US/docs/Web/CSS/text-align" title="The text-align CSS property describes how inline content like text is aligned in its parent block element. text-align does not control the alignment of block elements itself, only their inline content."><code>text-align</code></a> property 
 <span class="inlineIndicator unimplemented unimplementedInline">Unimplemented</span>.
</div>
   */
  def char: StateChannel[String] = attribute("char").asInstanceOf[StateChannel[String]]
  /**
   * This attribute is used to indicate the number of characters to offset the column data from the alignment characters specified by the 
<strong>char</strong> attribute. 
<div class="note"> 
 <strong>Note: </strong>Do not use this attribute as it is obsolete (and not supported) in the latest standard.
</div>
   */
  def charoff: StateChannel[String] = attribute("charoff").asInstanceOf[StateChannel[String]]
  /**
   * This attribute specifies the vertical alignment of the text within each row of cells of the table header. Possible values for this attribute are: 
<ul> 
 <li><span style="font-family: Courier New;">baseline</span>, which will put the text as close to the bottom of the cell as it is possible, but align it on the <a class="external" href="http://en.wikipedia.org/wiki/Baseline_%28typography%29" title="http://en.wikipedia.org/wiki/Baseline_(typography)">baseline</a> of the characters instead of the bottom of them. If characters are all of the size, this has the same effect as <span style="font-family: Courier New;">bottom</span>.</li> 
 <li><span style="font-family: Courier New;">bottom</span>, which will put the text as close to the bottom of the cell as it is possible;</li> 
 <li><span style="font-family: Courier New;">middle</span>, which will center the text in the cell;</li> 
 <li><span style="font-family: Courier New;">top</span>, which will put the text as close to the top of the cell as it is possible.</li> 
</ul> 
<div class="note"> 
 <strong>Note: </strong>Do not use this attribute as it is obsolete (and not supported) in the latest standard: instead set the CSS&nbsp;
 <a href="/en-US/docs/Web/CSS/vertical-align" title="The vertical-align CSS property specifies the vertical alignment of an inline or table-cell box."><code>vertical-align</code></a> property on it.
</div>
   */
  def valign: StateChannel[String] = attribute("valign").asInstanceOf[StateChannel[String]]
}
