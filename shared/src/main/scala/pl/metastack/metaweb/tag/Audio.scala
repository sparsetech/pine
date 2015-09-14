package pl.metastack.metaweb.tag

import pl.metastack.metarx._
import pl.metastack.metaweb.state

/**
 * The <strong>HTML <code>&lt;audio&gt;</code> element</strong> is used to embed sound content in documents. It may contain several audio sources, represented using the <code>src</code> attribute or the <a href="/en-US/docs/Web/HTML/Element/source" title="The HTML <source> element is used to specify multiple media resources for <picture>, <audio> and <video> elements. It is an empty element. It is commonly used to serve the same media in multiple formats supported by different browsers."><code>&lt;source&gt;</code></a> element; the browser will choose the most suitable one.
Fallback content for browser not supporting the <code>&lt;audio&gt;</code> element can be added too.
You can use the Web Audio API to directly generate and manipulate audio streams from JavaScript code. See <a href="/en-US/docs/Web/API/Web_Audio_API">Web Audio API</a> for details.
 */
class Audio extends state.Tag("audio") with HTMLTag {
  /**
   * A Boolean attribute; if specified (even if the value is "false"!), the audio will automatically begin to play back as soon as it can do so without stopping to finish loading the data.
   */
  def autoplay: StateChannel[String] = attribute("autoplay").asInstanceOf[StateChannel[String]]
  /**
   * A Boolean attribute; if specified, the audio will automatically begin being downloaded, even if not set to automatically play. This continues until the media cache is full, or the entire audio file has been downloaded, whichever comes first. This should only be used when it is expected that the user will choose to play the audio; for example, if the user has navigated to a page using a "Play this audio" link. This attribute was removed in Gecko 2.0 (Firefox 4 / Thunderbird 3.3 / SeaMonkey 2.1) in favor of the 
<code>preload</code> attribute.
   */
  def autobuffer: StateChannel[String] = attribute("autobuffer").asInstanceOf[StateChannel[String]]
  /**
   * An attribute you can read to determine which time ranges of the media have been buffered. This attribute contains a 
<a href="/en-US/docs/Web/API/TimeRanges" title="The TimeRanges interface is used to represent a set of time ranges, primarily for the purpose of tracking which portions of media have been buffered when loading it for use by the <audio> and <video>&nbsp;elements."><code>TimeRanges</code></a> object.
   */
  def buffered: StateChannel[String] = attribute("buffered").asInstanceOf[StateChannel[String]]
  /**
   * If this attribute is present, the browser will offer controls to allow the user to control audio playback, including volume, seeking, and pause/resume playback.
   */
  def controls: StateChannel[String] = attribute("controls").asInstanceOf[StateChannel[String]]
  /**
   * A Boolean attribute,&nbsp;when&nbsp;specified, will&nbsp;automatically seek back to the start&nbsp;upon reaching the end of the audio.
   */
  def loop: StateChannel[String] = attribute("loop").asInstanceOf[StateChannel[String]]
  /**
   * The offset, specified as the number of samples since the beginning of the audio stream, at which the audio is currently playing.
   */
  def mozCurrentSampleOffset: StateChannel[String] = attribute("mozCurrentSampleOffset").asInstanceOf[StateChannel[String]]
  /**
   * A Boolean attribute which indicates whether the audio will be initially silenced. Its default value is false, meaning that the audio will be played.
   */
  def muted: StateChannel[String] = attribute("muted").asInstanceOf[StateChannel[String]]
  /**
   * A 
<a href="/en-US/docs/Web/API/TimeRanges" title="The TimeRanges interface is used to represent a set of time ranges, primarily for the purpose of tracking which portions of media have been buffered when loading it for use by the <audio> and <video>&nbsp;elements."><code>TimeRanges</code></a> object indicating all the ranges of the audio that have been played.
   */
  def played: StateChannel[String] = attribute("played").asInstanceOf[StateChannel[String]]
  /**
   * This enumerated attribute is intended to provide a hint to the browser about what the author thinks will lead to the best user experience. It may have one of the following values: 
<ul> 
 <li><code>none</code>: hints that either the author thinks that the user won't need to consult that audio or that the server wants to minimize its traffic; in others terms this hint indicates that the audio should not be cached;</li> 
 <li><code>metadata</code>: hints that though the author thinks that the user won't need to consult that audio, fetching the metadata (e.g. length) is reasonable;</li> 
 <li><code>auto</code>: hints that the user needs have priority; in others terms this hint indicated that, if needed, the whole audio could be downloaded, even if the user is not expected to use it;</li> 
 <li>the <em>empty string</em>: which is a synonym of the <code>auto</code> value.</li> 
</ul> 
<p>If not set, its default value is browser-defined (i.e. each browser can choose its own default value), though the spec advises it to be set to <code>metadata</code>.</p> 
<div class="note">
 <strong>Usage notes:</strong> 
 <ul> 
  <li>The <code>autoplay</code> attribute has precedence over this one as if one wants to automatically play a audio, the browser will obviously need to download it. Setting both the <code>autoplay</code> and the <code>preload</code> attributes is allowed by the specification.</li> 
  <li>The browser is not forced by the specification to follow the value of this attribute; it is a mere hint.</li> 
 </ul> 
</div>
   */
  def preload: StateChannel[String] = attribute("preload").asInstanceOf[StateChannel[String]]
  /**
   * The URL of the audio to embed. This is subject to 
<a href="/en-US/docs/HTTP_access_control">HTTP access controls</a>. This is optional; you may instead use the 
<a href="/en-US/docs/Web/HTML/Element/source" title="The HTML <source> element is used to specify multiple media resources for <picture>, <audio> and <video> elements. It is an empty element. It is commonly used to serve the same media in multiple formats supported by different browsers."><code>&lt;source&gt;</code></a> element within the audio block to specify the audio to embed.
   */
  def src: StateChannel[String] = attribute("src").asInstanceOf[StateChannel[String]]
  /**
   * The playback volume of any audio portions, in the range 0.0 (silent) to 1.0 (loudest).
   */
  def volume: StateChannel[String] = attribute("volume").asInstanceOf[StateChannel[String]]
}
