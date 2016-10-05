package pl.metastack.metaweb.tag

import pl.metastack.metaweb.tree

/**
 * This element includes the <a href="https://developer.mozilla.org/en-US/docs/HTML/Global_attributes">global attributes</a>.
<dt>
 <strong id="attr-name"><code>name</code></strong>
</dt> 
<dd>
 The name attribute gives the map a name so that it can be referenced. The attribute must be present and must have a non-empty value with no space characters. The value of the name attribute must not be a compatibility-caseless match for the value of the name attribute of another map element in the same document. If the id attribute is also specified, both attributes must have the same value.
</dd>
 */
case class Map(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[tree.Node] = Seq.empty) extends HTMLTag {
  override type T = Map
  override def tagName = "map"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[tree.Node] = children): Map = Map(attributes, children)
  /**
   * The name attribute gives the map a name so that it can be referenced. The attribute must be present and must have a non-empty value with no space characters. The value of the name attribute must not be a compatibility-caseless match for the value of the name attribute of another map element in the same document. If the id attribute is also specified, both attributes must have the same value.
   */
  def name: scala.Option[String] = attributes.get("name").asInstanceOf[scala.Option[String]]
  def name(value: String): Map = copy(attributes = attributes + ("name" -> value))
}
