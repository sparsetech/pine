package pl.metastack.metaweb.tag

import pl.metastack.metaweb._

/**
 * The&nbsp;<em>HTML Description Element</em>&nbsp;(<strong>&lt;dd&gt;</strong>) indicates the description of a term in a description list (<a href="/en-US/docs/Web/HTML/Element/dl" title="The HTML <dl> Element (or HTML Description List Element) encloses a list of pairs of terms and descriptions. Common uses for this element are to implement a glossary or to display metadata (a list of key-value pairs)."><code>&lt;dl&gt;</code></a>) element. This element can occur only as a child element of a definition list and it must follow a <a href="/en-US/docs/Web/HTML/Element/dt" title="The HTML <dt> element (or HTML Definition Term Element) identifies a term in a definition list. This element can occur only as a child element of a <dl>. It is usually followed by a <dd> element; however, multiple <dt> elements in a row indicate several terms that are all defined by the immediate next <dd> element."><code>&lt;dt&gt;</code></a> element.
 */
case class Dd(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[Node] = Seq.empty) extends HTMLTag {
  override type T = Dd
  override def tagName = "dd"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[Node] = children): Dd = Dd(attributes, children)
  /**
   * If the value of this attribute is set to 
<code>yes</code>, the definition text will not wrap. The default value is 
<code>no</code>.
   */
  def nowrap: scala.Option[String] = attributes.get("nowrap").asInstanceOf[scala.Option[String]]
  def nowrap(value: String): Dd = copy(attributes = attributes + ("nowrap" -> value))
}
