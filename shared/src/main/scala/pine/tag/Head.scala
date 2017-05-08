package pine.tag

import pine._

/**
 * The <em>HTML Head Element</em> (<strong>&lt;head&gt;</strong>) provides general information (metadata) about the document, including its title and links to or definitions of scripts and style sheets
 */
case class Head(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[Node] = Seq.empty) extends HTMLTag {
  override type T = Head
  override def tagName = "head"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[Node] = children): Head = Head(attributes, children)
  /**
   * The URIs of one or more metadata profiles, separated by white space.
   */
  def profile: scala.Option[String] = attributes.get("profile").asInstanceOf[scala.Option[String]]
  def profile(value: String): Head = copy(attributes = attributes + ("profile" -> value))
}
