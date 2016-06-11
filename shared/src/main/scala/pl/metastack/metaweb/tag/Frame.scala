package pl.metastack.metaweb.tag

import pl.metastack.metaweb.tree

/**
 * <code>&lt;frame&gt;</code> is an HTML element which defines a particular area in which another HTML document can be displayed. A frame should be used within a <a href="/en-US/docs/Web/HTML/Element/frameset" title="<frameset> is an HTML element which is used to contain <frame> elements."><code>&lt;frameset&gt;</code></a>.
Using the <code>&lt;frame&gt;</code> element is not encouraged because of certain disadvantages such as performance problems and lack of accessibility for users with screen readers. Instead of the <code>&lt;frame&gt;</code> element, <a href="/en-US/docs/Web/HTML/Element/iframe" title="The HTML <iframe> Element (or HTML inline frame element) represents a nested browsing context, effectively embedding another HTML page into the current page. In HTML 4.01, a document may contain a head and a body or a head and a frame-set, but not both a body and a frame-set. However,an <iframe> can be used within a normal document body. Each browsing context has its own session history and active document. The browsing context that contains the embedded content is called the parent browsing context. The top-level browsing context (which has no parent) is typically the browser window."><code>&lt;iframe&gt;</code></a>&nbsp;may be preferred.
 */
case class Frame(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[tree.Node] = Seq.empty) extends tree.Tag with HTMLTag {
  override def tagName = "frame"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[tree.Node] = children): Frame = Frame(attributes, children)
  /**
   * This attribute is specify document which will be displayed by frame.
   */
  def src: scala.Option[String] = attributes.get("src").asInstanceOf[scala.Option[String]]
  /**
   * This attribute is used to labeling frames. Without labeling all links will open in the frame that they are in.
   */
  def name: scala.Option[String] = attributes.get("name").asInstanceOf[scala.Option[String]]
  /**
   * This attribute avoid resizing of frames by users.
   */
  def noresize: scala.Option[String] = attributes.get("noresize").asInstanceOf[scala.Option[String]]
  /**
   * This attribute defines existence of scrollbar. If this attribute is not used, browser put a scrollbar when necessary. There are two choices; "yes" for showing a scrollbar even when it is not necessary and "no" for do not showing a scrollbar even when it is necessary.
   */
  def scrolling: scala.Option[String] = attributes.get("scrolling").asInstanceOf[scala.Option[String]]
  /**
   * This attribute defines how tall the margin between frames will be.
   */
  def marginheight: scala.Option[String] = attributes.get("marginheight").asInstanceOf[scala.Option[String]]
  /**
   * This attribute defines how wide the margin between frames will be.
   */
  def marginwidth: scala.Option[String] = attributes.get("marginwidth").asInstanceOf[scala.Option[String]]
  /**
   * This attribute allows you to put borders for frames.
   */
  def frameborder: scala.Option[String] = attributes.get("frameborder").asInstanceOf[scala.Option[String]]
}
