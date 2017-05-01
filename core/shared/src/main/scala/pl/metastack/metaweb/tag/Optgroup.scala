package pl.metastack.metaweb.tag

import pl.metastack.metaweb._

/**
 * In a Web form, the <strong>HTML <code>&lt;optgroup&gt;</code> element</strong>&nbsp; creates a grouping of options within a <a href="/en-US/docs/Web/HTML/Element/select" title="The HTML select (<select>) element represents a control that presents a menu of options. The options within the menu are represented by <option> elements, which can be grouped by <optgroup> elements. Options can be pre-selected for the user."><code>&lt;select&gt;</code></a> element.

<strong>Note:</strong>&nbsp;Optgroup elements may not be nested.

 */
case class Optgroup(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[Node] = Seq.empty) extends HTMLTag {
  override type T = Optgroup
  override def tagName = "optgroup"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[Node] = children): Optgroup = Optgroup(attributes, children)
  /**
   * If this Boolean attribute is set, none of the items in this option group is selectable. Often browsers grey out such control and it won't receive any browsing events, like mouse clicks or focus-related ones.
   */
  def disabled: Boolean = attributes.contains("disabled")
  def disabled(value: Boolean): Optgroup = (if (value) copy(attributes = attributes + ("disabled" -> "")) else copy(attributes = attributes - "disabled"))
  /**
   * The name of the group of options, which the browser can use when labeling the options in the user interface. This attribute is mandatory if this element is used.
   */
  def label: scala.Option[String] = attributes.get("label").asInstanceOf[scala.Option[String]]
  def label(value: String): Optgroup = copy(attributes = attributes + ("label" -> value))
}
