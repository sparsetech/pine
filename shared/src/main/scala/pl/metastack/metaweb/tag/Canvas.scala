package pl.metastack.metaweb.tag

import pl.metastack.metaweb.tree

/**
 * This element includes the <a href="https://developer.mozilla.org/en-US/docs/HTML/Global_attributes">global attributes</a>.
<dt>
 <strong id="attr-height"><code>height</code></strong>
</dt> 
<dd>
 The height of the coordinate space in CSS pixels. Defaults to 150.
</dd> 
<dt>
 <strong id="attr-moz-opaque"><code>moz-opaque</code></strong> 
 <span title="This API has not been standardized."><i class="icon-warning-sign"> </i></span>
</dt> 
<dd>
 Lets the canvas know whether or not translucency will be a factor. If the canvas knows there's no translucency, painting performance can be optimized.
</dd> 
<dt>
 <strong id="attr-width"><code>width</code></strong>
</dt> 
<dd>
 The width of the coordinate space in CSS pixels. Defaults to 300.
</dd>
 */
case class Canvas(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[tree.Node] = Seq.empty) extends tree.Tag with HTMLTag {
  override def tagName = "canvas"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[tree.Node] = children): Canvas = Canvas(attributes, children)
  /**
   * The height of the coordinate space in CSS pixels. Defaults to 150.
   */
  def height: scala.Option[String] = attributes.get("height").asInstanceOf[scala.Option[String]]
  /**
   * Lets the canvas know whether or not translucency will be a factor. If the canvas knows there's no translucency, painting performance can be optimized.
   */
  def `moz-opaque`: scala.Option[String] = attributes.get("moz-opaque").asInstanceOf[scala.Option[String]]
  /**
   * The width of the coordinate space in CSS pixels. Defaults to 300.
   */
  def width: scala.Option[String] = attributes.get("width").asInstanceOf[scala.Option[String]]
}
