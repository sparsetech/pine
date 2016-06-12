package pl.metastack.metaweb.tag

import pl.metastack.metaweb.tree

/**
 * <tbody> 
 <tr> 
  <td>Content categories</td> 
  <td>None</td> 
 </tr> 
 <tr> 
  <td>Permitted content</td> 
  <td>None, it is an <a href="/en-US/docs/Glossary/empty_element" class="glossaryLink" title="empty element: An empty element is an element from HTML, SVG, or MathML that cannot have any child nodes (i.e.,&nbsp;nested element or text inside an element).">empty element</a>.</td> 
 </tr> 
 <tr> 
  <td>Tag omission</td> 
  <td>As it is a void element, the start tag must be present and the end tag must not be present.</td> 
 </tr> 
 <tr> 
  <td>Permitted parent elements</td> 
  <td>A media element, before any <a href="/en-US/docs/HTML/Content_categories#Flow_content">flow content</a>.</td> 
 </tr> 
 <tr> 
  <td>Normative document</td> 
  <td><a href="http://dev.w3.org/html5/spec/Overview.html#the-track-element" rel="external nofollow" class="external">HTML5, section 4.8.9</a></td> 
 </tr> 
</tbody>
 */
case class Track(attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[tree.Node] = Seq.empty) extends HTMLTag[Track] {
  override def tagName = "track"
  override def copy(attributes: Predef.Map[String, Any] = attributes, children: Seq[tree.Node] = children): Track = Track(attributes, children)
  /**
   * This attribute indicates that the track should be enabled unless the user's preferences indicate that another track is more appropriate. This may only be used on one 
<code>track</code> element per media element.
   */
  def default: scala.Option[String] = attributes.get("default").asInstanceOf[scala.Option[String]]
  def default(value: String): Track = copy(attributes = attributes + ("default" -> value.toString)).asInstanceOf[Track]
  /**
   * How the text track is meant to be used. If omitted the default kind is 
<code>subtitles</code>. The following keywords are allowed: 
<ul> 
 <li><code>subtitles</code> 
  <ul> 
   <li>Subtitles provide translation of content that cannot be understood by the viewer. For example dialogue or text that is not English in an English language film.</li> 
   <li>Subtitles may contain additional content, usually extra background information. For example the text at the beginning of the Star Wars films, or the date, time, and location of a scene.</li> 
  </ul> </li> 
 <li><code>captions</code> 
  <ul> 
   <li>Closed captions provide a transcription and possibly a translation of audio.</li> 
   <li>It may include important non-verbal information such as music cues or sound effects. It may indicate the cue's source (e.g. music, text, character).</li> 
   <li>Suitable for users who are deaf or when the sound is muted.</li> 
  </ul> </li> 
 <li><code>descriptions</code> 
  <ul> 
   <li>Textual description of the video content.</li> 
   <li>Suitable for users who are blind or where the video cannot be seen.</li> 
  </ul> </li> 
 <li><code>chapters</code> 
  <ul> 
   <li>Chapter titles are intended to be used when the user is navigating the media resource.</li> 
  </ul> </li> 
 <li><code>metadata</code> 
  <ul> 
   <li>Tracks used by scripts. Not visible to the user.</li> 
  </ul> </li> 
</ul>
   */
  def kind: scala.Option[String] = attributes.get("kind").asInstanceOf[scala.Option[String]]
  def kind(value: String): Track = copy(attributes = attributes + ("kind" -> value.toString)).asInstanceOf[Track]
  /**
   * A user-readable title of the text track which is used by the browser when listing available text tracks.
   */
  def label: scala.Option[String] = attributes.get("label").asInstanceOf[scala.Option[String]]
  def label(value: String): Track = copy(attributes = attributes + ("label" -> value.toString)).asInstanceOf[Track]
  /**
   * Address of the track (
<code>.vtt</code> file). Must be a valid URL. This attribute must be defined.
   */
  def src: scala.Option[String] = attributes.get("src").asInstanceOf[scala.Option[String]]
  def src(value: String): Track = copy(attributes = attributes + ("src" -> value.toString)).asInstanceOf[Track]
  /**
   * Language of the track text data. It must be a valid 
<a href="http://people.w3.org/rishida/utils/subtags/" class="external">BCP 47</a> language tag. If the 
<code>kind</code> attribute is set to&nbsp;
<code>subtitles,</code> then 
<code>srclang</code> must be defined.
   */
  def srclang: scala.Option[String] = attributes.get("srclang").asInstanceOf[scala.Option[String]]
  def srclang(value: String): Track = copy(attributes = attributes + ("srclang" -> value.toString)).asInstanceOf[Track]
}
