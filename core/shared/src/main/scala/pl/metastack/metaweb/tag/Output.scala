package pl.metastack.metaweb.tag

import pl.metastack.metaweb.tree

/**
 * The <strong>HTML <code>&lt;output&gt;</code> element</strong> represents the result of a calculation or user action.
 */
case class Output(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[tree.Node] = Seq.empty) extends HTMLTag {
  override type T = Output
  override def tagName = "output"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[tree.Node] = children): Output = Output(attributes, children)
  /**
   * A list of IDs of other elements, indicating that those elements contributed input values to (or otherwise affected) the calculation.
   */
  def `for`: scala.Option[String] = attributes.get("for").asInstanceOf[scala.Option[String]]
  def `for`(value: String): Output = copy(attributes = attributes + ("for" -> value))
  /**
   * The form element that this element is associated with (its "form owner"). The value of the attribute must be an ID of a form element in the same document. If this attribute is not specified, the output element must be a descendant of a form element. This attribute enables you to place output elements anywhere within a document, not just as descendants of their form elements.
   */
  def form: scala.Option[String] = attributes.get("form").asInstanceOf[scala.Option[String]]
  def form(value: String): Output = copy(attributes = attributes + ("form" -> value))
  /**
   * The name of the element.
   */
  def name: scala.Option[String] = attributes.get("name").asInstanceOf[scala.Option[String]]
  def name(value: String): Output = copy(attributes = attributes + ("name" -> value))
}
