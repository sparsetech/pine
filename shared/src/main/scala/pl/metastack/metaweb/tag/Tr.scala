package pl.metastack.metaweb.tag

import pl.metastack.metaweb.tree

/**
 * The <em>HTML Table Row Element</em> (<code>&lt;tr&gt;</code>) defines a row of cells in a table. Those can be a mix of <a href="/en-US/docs/Web/HTML/Element/td" title="The Table cell HTML element (<td>) defines a cell of a table that contains data. It participates in the table model."><code>&lt;td&gt;</code></a> and <a href="/en-US/docs/Web/HTML/Element/th" title="The HTML Table Header Cell Element (<th>) defines a cell that is a header for a group of cells of a table. The group of cells that the header refers to is defined by the scope and headers attribute."><code>&lt;th&gt;</code></a> elements.
 */
case class Tr(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[tree.Node] = Seq.empty) extends HTMLTag {
  override type T = Tr
  override def tagName = "tr"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[tree.Node] = children): Tr = Tr(attributes, children)
  /**
   * This enumerated attribute specifies how horizontal alignment of each cell content will be handled. Possible values are: 
<ul> 
 <li><code>left</code>, aligning the content to the left of the cells</li> 
 <li><code>center</code>, centering the content in the cells</li> 
 <li><code>right</code>, aligning the content to the right of the cells</li> 
 <li><code>justify</code>, widening the spaces in the textual content so that the content is justified in the cells</li> 
 <li><code>char</code>, aligning the textual content on a special character with a minimal offset, defined by the <code><a href="/en-US/docs/Web/HTML/Element/tr#attr-char">char</a></code> and <code><a href="/en-US/docs/Web/HTML/Element/tr#attr-charoff">charoff</a></code> attributes <span class="inlineIndicator unimplemented unimplementedInline">Unimplemented (see <a class="external" href="https://bugzilla.mozilla.org/show_bug.cgi?id=2212" title="character alignment not implemented (align=char, charoff=, text-align:<string>)">bug&nbsp;2212</a>)</span>.</li> 
</ul> 
<p>If this attribute is not set, the parent node's value is inherited.</p> 
<div class="note"> 
 <strong>Note: </strong>Do not use this attribute as it is obsolete (not supported) in the latest standard. 
 <ul> 
  <li>To achieve the same effect as the <code>left</code>, <code>center</code>, <code>right</code> or <code>justify</code> values, use the CSS <a href="/en-US/docs/Web/CSS/text-align" title=""><code>text-align</code></a> property on it.</li> 
  <li>To achieve the same effect as the <code>char</code> value, in CSS3, you can use the value of the <code><a href="/en-US/docs/Web/HTML/Element/tr#attr-char">char</a></code> as the value of the <a href="/en-US/docs/Web/CSS/text-align" title=""><code>text-align</code></a> property <span class="inlineIndicator unimplemented unimplementedInline">Unimplemented</span>.</li> 
 </ul> 
</div>
   */
  def align: scala.Option[String] = attributes.get("align").asInstanceOf[scala.Option[String]]
  def align(value: String): Tr = copy(attributes = attributes + ("align" -> value))
  /**
   * This attribute defines the background color of each cell of the row. It can be either an 
<a href="/en-US/docs/CSS/color_value#HTML.2fSVG.2fX11.c2.a0_Color_Keywords" title="CSS/color value#HTML.2fSVG.2fX11.c2.a0 Color Keywords">#RRGGBB code</a> or an 
<a href="/#HTML.2fSVG.2fX11.c2.a0_Color_Keywords" title="#HTML.2fSVG.2fX11.c2.a0 Color Keywords">SVG color keyword</a>. 
<div class="note"> 
 <strong>Usage note: </strong>the 
 <a href="/en-US/docs/Web/HTML/Element/tr" title="This article hasn't been written yet. Please consider contributing!"><code>&lt;tr&gt;</code></a> element should be styled using 
 <a href="/en-US/docs/CSS" title="CSS">CSS</a>. To give a similar effect to the 
 <strong>bgcolor</strong> attribute, use the 
 <a href="/en-US/docs/CSS" title="CSS">CSS</a> property 
 <a href="/en-US/docs/Web/CSS/background-color" title=""><code>background-color</code></a>.
</div>
   */
  def bgcolor: scala.Option[String] = attributes.get("bgcolor").asInstanceOf[scala.Option[String]]
  def bgcolor(value: String): Tr = copy(attributes = attributes + ("bgcolor" -> value))
  /**
   * This attribute is used to set the character to align the cells in a column on. Typical values for this include a period (.) when attempting to align numbers or monetary values. If 
<code><a href="/en-US/docs/Web/HTML/Element/tr#attr-align">align</a></code> is not set to 
<code>char</code>, this attribute is ignored. 
<div class="note"> 
 <strong>Note: </strong>Do not use this attribute as it is obsolete (and not supported) in the latest standard. To achieve the same effect as the 
 <code><a href="/en-US/docs/Web/HTML/Element/tr#attr-char">char</a></code>, in CSS3, you can use the character set using the 
 <code><a href="/en-US/docs/Web/HTML/Element/tr#attr-char">char</a></code> attribute as the value of the 
 <a href="/en-US/docs/Web/CSS/text-align" title=""><code>text-align</code></a> property 
 <span class="inlineIndicator unimplemented unimplementedInline">Unimplemented</span>.
</div>
   */
  def char: scala.Option[String] = attributes.get("char").asInstanceOf[scala.Option[String]]
  def char(value: String): Tr = copy(attributes = attributes + ("char" -> value))
  /**
   * This attribute is used to indicate the number of characters to offset the column data from the alignment characters specified by the 
<strong>char</strong> attribute. 
<div class="note"> 
 <strong>Note: </strong>Do not use this attribute as it is obsolete (and not supported) in the latest standard.
</div>
   */
  def charoff: scala.Option[String] = attributes.get("charoff").asInstanceOf[scala.Option[String]]
  def charoff(value: String): Tr = copy(attributes = attributes + ("charoff" -> value))
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
 <a href="/en-US/docs/Web/CSS/vertical-align" title=""><code>vertical-align</code></a> property on it.
</div>
   */
  def valign: scala.Option[String] = attributes.get("valign").asInstanceOf[scala.Option[String]]
  def valign(value: String): Tr = copy(attributes = attributes + ("valign" -> value))
}
