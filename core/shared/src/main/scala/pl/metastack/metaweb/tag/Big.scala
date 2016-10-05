package pl.metastack.metaweb.tag

import pl.metastack.metaweb.tree

/**
 * The HTML Big Element (<code>&lt;big&gt;</code>)&nbsp;makes the text <em>font size</em> one size bigger (for example, from small to medium, or from large to x-large) up to the browser's maximum font size.
<p><strong>Usage note: </strong>As it was purely presentational, this element has been removed in <a href="/en-US/docs/Web/Guide/HTML/HTML5" title="/en-US/docs/Web/Guide/HTML/HTML5">HTML5</a> and shouldn't be used anymore. Instead web developers should use <a href="/en-US/docs/Web/CSS" title="/en-US/docs/Web/CSS">CSS</a> properties.</p>
 */
case class Big(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[tree.Node] = Seq.empty) extends HTMLTag {
  override type T = Big
  override def tagName = "big"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[tree.Node] = children): Big = Big(attributes, children)
}
