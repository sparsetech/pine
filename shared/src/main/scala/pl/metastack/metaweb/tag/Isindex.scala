package pl.metastack.metaweb.tag

import pl.metastack.metaweb.tree

/**
 * <code>&lt;isindex&gt;</code> is an HTML element which is used for putting a text field in the document for querying document. <code>&lt;isindex&gt;</code> is intented to use inside of <a href="/en-US/docs/Web/HTML/Element/head" title="The HTML <head> element represents a collection of metadata about the document, including links to or definitions of scripts and style sheets"><code>&lt;head&gt;</code></a> element by W3C, however browsers provide support wherever it is used in the document.
This element deprecated in HTML 4.01. Because, it is not a good idea to use <code>&lt;isindex&gt;</code> for any purpose. Same effect can be created with a HTML form in a modern way.
 */
case class Isindex(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[tree.Node] = Seq.empty) extends HTMLTag[Isindex] {
  override def tagName = "isindex"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[tree.Node] = children): Isindex = Isindex(attributes, children)
  /**
   * This attribute adds its value as a prompt for text field.
   */
  def prompt: scala.Option[String] = attributes.get("prompt").asInstanceOf[scala.Option[String]]
  def prompt(value: String): Isindex = copy(attributes = attributes + ("prompt" -> value)).asInstanceOf[Isindex]
  /**
   * This attribute can be used in the case of needing to send query to a different URL. Action is not defined by W3C.
   */
  def action: scala.Option[String] = attributes.get("action").asInstanceOf[scala.Option[String]]
  def action(value: String): Isindex = copy(attributes = attributes + ("action" -> value)).asInstanceOf[Isindex]
}
