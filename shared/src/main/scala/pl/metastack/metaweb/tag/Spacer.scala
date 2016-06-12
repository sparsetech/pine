package pl.metastack.metaweb.tag

import pl.metastack.metaweb.tree

/**
 * <code>&lt;spacer&gt;</code> is an HTML element which is used for inserting white spaces to web pages. It was created by NetScape for achieving same effect as a single-pixel layout GIF image, which was something web designers used to use to add white spaces to web pages, without actually using a GIF. However <code>&lt;spacer&gt; </code>is not supported by any major browser and same effects can be created with various CSS rules. In Mozilla applications, support for this element was removed in <span title="(Firefox 4 / Thunderbird 3.3 / SeaMonkey 2.1)">Gecko&nbsp;2.0</span>. Therefore usage of <code>&lt;spacer&gt;</code> is unnecessary.
 */
case class Spacer(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[tree.Node] = Seq.empty) extends HTMLTag[Spacer] {
  override def tagName = "spacer"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[tree.Node] = children): Spacer = Spacer(attributes, children)
  /**
   * This attribute determines type of spacer. Possible values are 
<code>horizontal</code>, 
<code>vertical</code> and 
<code>block</code>.
   */
  def `type`: scala.Option[String] = attributes.get("type").asInstanceOf[scala.Option[String]]
  def `type`(value: String): Spacer = copy(attributes = attributes + ("type" -> value.toString)).asInstanceOf[Spacer]
  /**
   * This attribute can be used for defining size of spacer in pixels when type is 
<code>horizontal</code> or 
<code>vertical</code>.
   */
  def size: scala.Option[String] = attributes.get("size").asInstanceOf[scala.Option[String]]
  def size(value: String): Spacer = copy(attributes = attributes + ("size" -> value.toString)).asInstanceOf[Spacer]
  /**
   * This attribute can be used for defining width of spacer in pixels when type is 
<code>block</code>.
   */
  def width: scala.Option[String] = attributes.get("width").asInstanceOf[scala.Option[String]]
  def width(value: String): Spacer = copy(attributes = attributes + ("width" -> value.toString)).asInstanceOf[Spacer]
  /**
   * This attribute can be used for defining height of spacer in pixels when type is 
<code>block</code>.
   */
  def height: scala.Option[String] = attributes.get("height").asInstanceOf[scala.Option[String]]
  def height(value: String): Spacer = copy(attributes = attributes + ("height" -> value.toString)).asInstanceOf[Spacer]
  /**
   * This attribute determines alignment of spacer. Possible values are 
<code>left</code>, 
<code>right</code> and 
<code>center</code>.
   */
  def align: scala.Option[String] = attributes.get("align").asInstanceOf[scala.Option[String]]
  def align(value: String): Spacer = copy(attributes = attributes + ("align" -> value.toString)).asInstanceOf[Spacer]
}
