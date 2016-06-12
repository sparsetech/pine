package pl.metastack.metaweb.tag

import pl.metastack.metaweb.tree

/**
 * The <strong>HTML<em> </em><code>&lt;progress&gt;</code> Element</strong> is used to view the completion progress of a task. While the specifics of how it's displayed is left up to the browser developer, it's typically displayed as a progress bar. Javascript can be used to manipulate the value of progress bar.
 */
case class Progress(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[tree.Node] = Seq.empty) extends HTMLTag[Progress] {
  override def tagName = "progress"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[tree.Node] = children): Progress = Progress(attributes, children)
  /**
   * This attribute describes how much work the task indicated by the 
<code>progress</code> element requires. The 
<code>max</code> attribute, if present, must have a value greater than zero and be a valid floating point number.
   */
  def max: scala.Option[String] = attributes.get("max").asInstanceOf[scala.Option[String]]
  def max(value: String): Progress = copy(attributes = attributes + ("max" -> value.toString)).asInstanceOf[Progress]
  /**
   * This attribute specifies how much of the task that has been completed. It must be a valid floating point number between 0 and 
<code>max</code>, or between 0 and 1 if 
<code>max</code> is omitted. If there is no 
<code>value</code> attribute, the progress bar is indeterminate; this indicates that an activity is ongoing with no indication of how long it is expected to take.
   */
  def value: scala.Option[String] = attributes.get("value").asInstanceOf[scala.Option[String]]
  def value(value: String): Progress = copy(attributes = attributes + ("value" -> value.toString)).asInstanceOf[Progress]
}
