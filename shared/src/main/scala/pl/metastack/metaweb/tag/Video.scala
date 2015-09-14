package pl.metastack.metaweb.tag

import pl.metastack.metarx._
import pl.metastack.metaweb.state

/**
 * The <strong>HTML <code>&lt;video&gt;</code> element</strong> is used to embed video content. It may contain several video sources, represented using the <code>src</code> attribute or the <a href="/en-US/docs/Web/HTML/Element/source" title="The HTML <source> element is used to specify multiple media resources for <picture>, <audio> and <video> elements. It is an empty element. It is commonly used to serve the same media in multiple formats supported by different browsers."><code>&lt;source&gt;</code></a> element; the browser will choose the most suitable one.
For a list of supported formats, see <a href="/en-US/docs/Media_formats_supported_by_the_audio_and_video_elements" title="Media formats supported by the audio and video elements">Media formats supported by the audio and video elements</a>.
 */
class Video extends state.Tag("video") with HTMLTag {
  /**
   * A Boolean attribute; if specified, the video will automatically begin to play back as soon as it can do so without stopping to finish loading the data.
   */
  def autoplay: StateChannel[String] = attribute("autoplay").asInstanceOf[StateChannel[String]]
  /**
   * A Boolean attribute; if specified, the video will automatically begin buffering even if it's not set to automatically play. This should be used for cases in which it is considered likely that the video will be played (for example, if the user navigated to the page specifically to play the video, not if there happens to be a video embedded along with other content). The video is buffered until the media cache is full. 
<div class="note">
 <strong>Implementation note:</strong> though part of the early drafts of the HTML5 specification, the 
 <code>autobuffer</code> attribute has been removed in later releases. It has been removed from Gecko 2.0 and other browsers, and never implemented in some. The spec defines a new enumerated attribute, 
 <code>preload</code>, to replace the 
 <code>autobuffer</code> attribute, with a different syntax. 
 <a href="https://bugzilla.mozilla.org/show_bug.cgi?id=548523" class="external" title="FIXED: HTML 5 media attribute 'autobuffer' has been renamed to 'preload'">bug&nbsp;548523</a>
</div>
   */
  def autobuffer: StateChannel[String] = attribute("autobuffer").asInstanceOf[StateChannel[String]]
  /**
   * An attribute you can read to determine which time ranges of the media have been buffered. This attribute contains a 
<a href="/en-US/docs/Web/API/TimeRanges" title="The TimeRanges interface is used to represent a set of time ranges, primarily for the purpose of tracking which portions of media have been buffered when loading it for use by the <audio> and <video>&nbsp;elements."><code>TimeRanges</code></a> object.
   */
  def buffered: StateChannel[String] = attribute("buffered").asInstanceOf[StateChannel[String]]
  /**
   * If this attribute is present, Gecko will offer controls to allow the user to control video playback, including volume, seeking, and pause/resume playback.
   */
  def controls: StateChannel[String] = attribute("controls").asInstanceOf[StateChannel[String]]
  /**
   * This enumerated attribute indicates if the fetching of the related image must be done using CORS or not. 
<a href="/en-US/docs/CORS_Enabled_Image" title="CORS_Enabled_Image">CORS-enabled resources</a> can be reused in the 
<a href="/en-US/docs/Web/HTML/Element/canvas" title="The HTML <canvas> Element can be used to draw graphics via scripting (usually JavaScript). For example, it can be used to draw graphs, make photo compositions or even perform animations. You may (and should) provide alternate content inside the <canvas> block. That content will be rendered both on older browsers that don't support canvas and in browsers with JavaScript disabled."><code>&lt;canvas&gt;</code></a> element without being 
<em>tainted</em>. The allowed values are: 
<dl> 
 <dt>
  anonymous
 </dt> 
 <dd>
  A cross-origin request (i.e. with 
  <code>Origin:</code> HTTP header) is performed. But no credential is sent (i.e. no cookie, no X.509 certificate and no HTTP Basic authentication is sent). If the server does not give credentials to the origin site (by not setting the 
  <code>Access-Control-Allow-Origin:</code> HTTP header), the image will be 
  <em>tainted</em> and its usage restricted..
 </dd> 
 <dt>
  use-credentials
 </dt> 
 <dd>
  A cross-origin request (i.e. with 
  <code>Origin:</code> HTTP header) is performed with credential is sent (i.e. a cookie, a certificate and HTTP Basic authentication is performed). If the server does not give credentials to the origin site (through 
  <code>Access-Control-Allow-Credentials:</code> HTTP header), the image will be 
  <em>tainted</em> and its usage restricted.
 </dd> 
</dl> When not present, the resource is fetched without a CORS request (i.e. without sending the 
<code>Origin:</code> HTTP header), preventing its non-tainted used in 
<a href="/en-US/docs/Web/HTML/Element/canvas" title="The HTML <canvas> Element can be used to draw graphics via scripting (usually JavaScript). For example, it can be used to draw graphs, make photo compositions or even perform animations. You may (and should) provide alternate content inside the <canvas> block. That content will be rendered both on older browsers that don't support canvas and in browsers with JavaScript disabled."><code>&lt;canvas&gt;</code></a> elements. If invalid, it is handled as if the enumerated keyword 
<strong>anonymous</strong> was used. See 
<a href="/en-US/docs/HTML/CORS_settings_attributes" title="CORS settings attributes">CORS settings attributes</a> for additional information.
   */
  def crossorigin: StateChannel[String] = attribute("crossorigin").asInstanceOf[StateChannel[String]]
  /**
   * The height of the video's display area, in CSS pixels.
   */
  def height: StateChannel[String] = attribute("height").asInstanceOf[StateChannel[String]]
  /**
   * A Boolean attribute; if specified, we will, upon reaching the end of the video, automatically seek back to the start.
   */
  def loop: StateChannel[String] = attribute("loop").asInstanceOf[StateChannel[String]]
  /**
   * A Boolean attribute which indicates the default setting of the audio contained in the video. If set, the audio will be initially silenced. Its default value is false, meaning that the audio will be played when the video is played.
   */
  def muted: StateChannel[String] = attribute("muted").asInstanceOf[StateChannel[String]]
  /**
   * A 
<a href="/en-US/docs/Web/API/TimeRanges" title="The TimeRanges interface is used to represent a set of time ranges, primarily for the purpose of tracking which portions of media have been buffered when loading it for use by the <audio> and <video>&nbsp;elements."><code>TimeRanges</code></a> object indicating all the ranges of the video that have been played.
   */
  def played: StateChannel[String] = attribute("played").asInstanceOf[StateChannel[String]]
  /**
   * This enumerated attribute is intended to provide a hint to the browser about what the author thinks will lead to the best user experience. It may have one of the following values: 
<ul> 
 <li><span style="font-family: courier new;">none: </span>hints that either the author thinks that the user won't need to consult that video or that the server wants to minimize its traffic; in others terms this hint indicates that the video should not be cached.</li> 
 <li><span style="font-family: courier new;">metadata</span>: hints that though the author thinks that the user won't need to consult that video, fetching the metadata (e.g. length) is reasonable.</li> 
 <li><span style="font-family: courier new;">auto</span>: hints that the user needs have priority; in others terms this hint indicated that, if needed, the whole video could be downloaded, even if the user is not expected to use it.</li> 
 <li>the <em>empty string</em>: which is a synonym of the <span style="font-family: courier new;">auto </span>value.</li> 
</ul> 
<p>If not set, its default value is browser-defined (i.e. each browser can choose its own default value), though the spec advises it to be set to <span style="font-family: courier new;">metadata</span>.</p> 
<div class="note">
 <strong>Usage notes:</strong> 
 <ul> 
  <li>The <code>autoplay</code> attribute has precedence over this one as if one wants to automatically play a video, the browser will obviously need to download it. Setting both the <code>autoplay</code> and the <code>preload</code> attributes is allowed by the specification.</li> 
  <li>The browser is not forced by the specification to follow the value of this attribute; it is a mere hint.</li> 
 </ul> 
</div>
   */
  def preload: StateChannel[String] = attribute("preload").asInstanceOf[StateChannel[String]]
  /**
   * A URL indicating a poster frame to show until the user plays or seeks. If this attribute isn't specified, nothing is displayed until the first frame is available; then the first frame is displayed as the poster frame.
   */
  def poster: StateChannel[String] = attribute("poster").asInstanceOf[StateChannel[String]]
  /**
   * The URL of the video to embed. This is optional; you may instead use the 
<a href="/en-US/docs/Web/HTML/Element/source" title="The HTML <source> element is used to specify multiple media resources for <picture>, <audio> and <video> elements. It is an empty element. It is commonly used to serve the same media in multiple formats supported by different browsers."><code>&lt;source&gt;</code></a> element within the video block to specify the video to embed.
   */
  def src: StateChannel[String] = attribute("src").asInstanceOf[StateChannel[String]]
  /**
   * The width of the video's display area, in CSS pixels.
   */
  def width: StateChannel[String] = attribute("width").asInstanceOf[StateChannel[String]]
}
