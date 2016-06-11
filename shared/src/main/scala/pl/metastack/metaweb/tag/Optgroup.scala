package pl.metastack.metaweb.tag

import pl.metastack.metaweb.tree

/**
 * In a Web form, the <strong>HTML <code>&lt;optgroup&gt;</code> element</strong>&nbsp; creates a grouping of options within a <a href="/en-US/docs/Web/HTML/Element/select" title="The HTML select (<select>) element represents a control that presents a menu of options. The options within the menu are represented by <option> elements, which can be grouped by <optgroup> elements. Options can be pre-selected for the user."><code>&lt;select&gt;</code></a> element.

<strong>Note:</strong>&nbsp;Optgroup elements may not be nested.

 */
case class Optgroup(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[tree.Node] = Seq.empty) extends tree.Tag with HTMLTag {
  override def tagName = "optgroup"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[tree.Node] = children): Optgroup = Optgroup(attributes, children)
  /**
   * If this Boolean attribute is set, none of the items in this option group is selectable. Often browsers grey out such control and it won't receive any browsing events, like mouse clicks or focus-related ones.
   */
  def disabled: scala.Option[Boolean] = attributes.get("disabled").asInstanceOf[scala.Option[Boolean]]
  /**
   * The name of the group of options, which the browser can use when labeling the options in the user interface. This attribute is mandatory if this element is used.
   */
  def label: scala.Option[String] = attributes.get("label").asInstanceOf[scala.Option[String]]
}
