package pl.metastack.metaweb.tag

import pl.metastack.metarx._
import pl.metastack.metaweb.state

/**
 * The&nbsp;<em>HTML Inline Frame Element</em>&nbsp;(<code><strong>&lt;iframe&gt;</strong></code>) represents a nested browsing context, effectively embedding another HTML page into the current page. In HTML 4.01, a document may contain a <code>head</code> and a <code>body</code> or a <code>head</code> and a <code>frame-set</code>, but not both a <code>body</code> and a <code>frame-set</code>. However, an <code>&lt;iframe&gt;</code> can be used within a normal document body. Each browsing context has its own session history and active document. The browsing context that contains the embedded content is called the <dfn>parent</dfn> browsing context. The <dfn>top-level</dfn> browsing context (which has no parent) is typically the browser window.
 */
class Iframe extends state.Tag("iframe") with HTMLTag {
  /**
   * The alignment of this element with respect to the surrounding context.
   */
  def align: StateChannel[String] = attribute("align").asInstanceOf[StateChannel[String]]
  /**
   * This attribute can be set to 
<code>true</code> if the frame is allowed to be placed into full screen mode by calling its 
<a href="/en-US/docs/Web/API/Element/mozRequestFullScreen" title="{{ APIRef }}"><code>element.mozRequestFullScreen()</code></a> method. If this isn't set, the element can't be placed into full screen mode.
   */
  def allowfullscreen: StateChannel[String] = attribute("allowfullscreen").asInstanceOf[StateChannel[String]]
  /**
   * The value 1 (the default) tells the browser to draw a border between this frame and every other frame. The value 0 tells the browser not to draw a border between this frame and other frames.
   */
  def frameborder: StateChannel[String] = attribute("frameborder").asInstanceOf[StateChannel[String]]
  /**
   * Indicates the height of the frame 
<span class="inlineIndicator htmlVer htmlVerInline"><a href="/en-US/docs/HTML/HTML5">HTML5</a></span> in CSS pixels, or 
<span class="inlineIndicator htmlVer htmlVerInline">HTML 4.01</span> in pixels or as a percentage.
   */
  def height: StateChannel[String] = attribute("height").asInstanceOf[StateChannel[String]]
  /**
   * A URI of a long description of the frame. Due to widespread misuse, this is not helpful for non-visual browsers.
   */
  def longdesc: StateChannel[String] = attribute("longdesc").asInstanceOf[StateChannel[String]]
  /**
   * The amount of space in pixels between the frame's content and its top and bottom margins.
   */
  def marginheight: StateChannel[String] = attribute("marginheight").asInstanceOf[StateChannel[String]]
  /**
   * The amount of space in pixels between the frame's content and its left and right margins.
   */
  def marginwidth: StateChannel[String] = attribute("marginwidth").asInstanceOf[StateChannel[String]]
  /**
   * Use 
<code><strong>allowfullscreen</strong></code> instead. In Gecko 9.0 or later, this attribute can be set to 
<code>true</code> if the frame is allowed to be placed into full screen mode by calling its 
<a href="/en-US/docs/Web/API/Element/mozRequestFullScreen" title="{{ APIRef }}"><code>element.mozRequestFullScreen()</code></a> method. If this isn't set, the element can't be placed into full screen mode.
   */
  def mozallowfullscreen: StateChannel[String] = attribute("mozallowfullscreen").asInstanceOf[StateChannel[String]]
  /**
   * Use 
<code><strong>allowfullscreen</strong></code> instead. In Chrome 17 or later (and maybe earlier), this attribute can be set to 
<code>true</code> if the frame is allowed to be placed into full screen mode by calling its 
<a href="/en-US/docs/Web/API/Element/webkitRequestFullScreen" class="new" title="The documentation about this has not yet been written; please consider contributing!"><code>element.webkitRequestFullScreen()</code></a> method. If this isn't set, the element can't be placed into full screen mode.
   */
  def webkitallowfullscreen: StateChannel[String] = attribute("webkitallowfullscreen").asInstanceOf[StateChannel[String]]
  /**
   * For frames hosting an 
<a href="/en-US/docs/Apps" title="OpenWebApps">open web app</a>, this specifies the URL of the 
<a href="/en-US/docs/Apps/Manifest" title="Apps/Manifest">app manifest</a>. This ensures that the app is loaded with the right permissions. See 
<a href="/en-US/docs/DOM/Using_the_Browser_API" title="DOM/Using_the_Browser_API">Using the Browser API</a> for details. Available in Gecko 13.0 and later.
   */
  def mozapp: StateChannel[String] = attribute("mozapp").asInstanceOf[StateChannel[String]]
  /**
   * Indicates that the frame is to appear like a top-level browser window to the embedded content. This means that 
<a href="/en-US/docs/Web/API/Window/top" title="Returns a reference to the topmost window in the window hierarchy."><code>window.top</code></a>
<span id="summary_alias_container"><span id="short_desc_nonedit_display">, </span></span>
<a href="/en-US/docs/Web/API/Window/parent" title="A reference to the parent of the current window or subframe."><code>window.parent</code></a>
<span id="summary_alias_container"><span id="short_desc_nonedit_display">, </span></span>
<a href="/en-US/docs/Web/API/Window/frameElement" title="Returns the element (such as <iframe> or <object>) in which the window is embedded, or null if the window is top-level."><code>window.frameElement</code></a>,
<span id="summary_alias_container"><span id="short_desc_nonedit_display"> etc. will <em>not</em> reflect the frame hierarchy. This allows for a web browser UI to be implemented entirely with web technology, given the right permissions.</span></span> See 
<a href="/en-US/docs/DOM/Using_the_Browser_API" title="DOM/Using_the_Browser_API">Using the Browser API</a> for details. Available in Gecko 13.0 and later.
   */
  def mozbrowser: StateChannel[String] = attribute("mozbrowser").asInstanceOf[StateChannel[String]]
  /**
   * A name for the embedded browsing context (or frame). This can be used as the value of the 
<code><strong>target</strong></code> attribute of an 
<a href="/en-US/docs/Web/HTML/Element/a" title="The HTML Anchor Element (<a>) defines a hyperlink"><code>&lt;a&gt;</code></a> or 
<a href="/en-US/docs/Web/HTML/Element/form" title="The HTML <form> element represents a document section that contains interactive controls to submit information to a web server."><code>&lt;form&gt;</code></a> element, or the formtarget attribute of an 
<a href="/en-US/docs/Web/HTML/Element/input" title="The HTML <input> element is used to create interactive controls for web-based forms in order to accept data from the user. How an <input> works varies considerably depending on the value of its type attribute."><code>&lt;input&gt;</code></a> or 
<a href="/en-US/docs/Web/HTML/Element/button" title="The HTML <button> Element represents a clickable button."><code>&lt;button&gt;</code></a> element.
   */
  def name: StateChannel[String] = attribute("name").asInstanceOf[StateChannel[String]]
  /**
   * Load the frame's page in a separate content process.
   */
  def remote: StateChannel[String] = attribute("remote").asInstanceOf[StateChannel[String]]
  /**
   * Enumerated attribute indicating when the browser should provide a scroll bar (or other scrolling device) for the frame: 
<ul> 
 <li><code>auto</code>: Only when needed.</li> 
 <li><code>yes</code>: Always provide a scroll bar.</li> 
 <li><code>no</code>: Never provide a scoll bar.</li> 
</ul>
   */
  def scrolling: StateChannel[String] = attribute("scrolling").asInstanceOf[StateChannel[String]]
  /**
   * If specified as an empty string, this attribute enables extra restrictions on the content that can appear in the inline frame. The value of the attribute can either be an empty string (all the restrictions are applied), or a space-separated list of tokens that lift particular restrictions. Valid tokens are: 
<ul> 
 <li><code>allow-same-origin</code>: Allows the content to be treated as being from its normal origin. If this keyword is not used, the embedded content is treated as being from a unique origin.</li> 
 <li><code>allow-top-navigation</code>: Allows the embedded browsing context to navigate (load) content to the top-level browsing context. If this keyword is not used, this operation is not allowed.</li> 
 <li><code>allow-forms</code>: Allows the embedded browsing context to submit forms. If this keyword is not used, this operation is not allowed.</li> 
 <li><code>allow-popups</code>: Allows popups (like from <code>window.open</code>, <code>target="_blank"</code>, <code>showModalDialog</code>). If this keyword is not used, that functionality will silently fail.</li> 
 <li><code>allow-scripts</code>: Allows the embedded browsing context to run scripts (but not create pop-up windows). If this keyword is not used, this operation is not allowed.</li> 
 <li><code>allow-pointer-lock</code>: Allows the embedded browsing context to use the <a href="/en-US/docs/WebAPI/Pointer_Lock">Pointer Lock API</a>.</li> 
 <li><code>allow-unsandboxed-auxiliary</code>: (Chrome only) Allows a sandboxed document to open new windows without forcing the sandboxing flags upon them. This will allow, for example, a third-party advertisement to be safely sandboxed without forcing the same restrictions upon a landing page.</li> 
</ul> 
<div class="note"> 
 <p><strong>Note:</strong></p> 
 <ul> 
  <li>When the embedded document has the same origin as the main page, it is strongly discouraged to use both <code>allow-scripts</code> and <code>allow-same-origin</code> at the same time, as that allows the embedded document to programmatically remove the <code>sandbox</code> attribute. Although it is accepted, this case is no more secure than not using the <code>sandbox</code> attribute.</li> 
  <li>Sandboxing in general is only of minimal help if the attacker can arrange for the potentially hostile content to be displayed in the user's browser outside a sandboxed <code>iframe</code>. It is recommended that such content should be served from a <em>separate dedicated domain</em>, to limit the potential damage.</li> 
  <li>The <code>sandbox</code> attribute is not supported in Internet Explorer 9 and earlier versions.</li> 
 </ul> 
</div>
   */
  def sandbox: StateChannel[String] = attribute("sandbox").asInstanceOf[StateChannel[String]]
  /**
   * This 
<strong>Boolean attribute</strong> indicates that the browser should render the inline frame in a way that makes it appear to be part of the containing document, for example by applying CSS styles that apply to the 
<code>&lt;iframe&gt;</code>&nbsp;to the contained document before styles specified in that document, and by opening links in the contained documents in the parent browsing context (unless another setting prevents this). In XHTML, attribute minimization is forbidden, and the seamless attribute must be defined as 
<code>&lt;iframe seamless="seamless"&gt;</code>.
   */
  def seamless: StateChannel[String] = attribute("seamless").asInstanceOf[StateChannel[String]]
  /**
   * The URL of the page to embed.
   */
  def src: StateChannel[String] = attribute("src").asInstanceOf[StateChannel[String]]
  /**
   * The content of the page that the embedded context is to contain. This attribute is expected to be used together with the sandbox and seamless attributes. If a browser supports the 
<code>srcdoc</code> attribute, it will override the content specified in the 
<code>src</code> attribute (if present). If a browser does NOT support the 
<code>srcdoc</code> attribute, it will show the file specified in the 
<code>src</code> attribute instead (if present).
   */
  def srcdoc: StateChannel[String] = attribute("srcdoc").asInstanceOf[StateChannel[String]]
  /**
   * Indicates the width of the frame 
<span class="inlineIndicator htmlVer htmlVerInline"><a href="/en-US/docs/HTML/HTML5">HTML5</a></span> in CSS pixels, or 
<span class="inlineIndicator htmlVer htmlVerInline">HTML 4.01</span> in pixels or as a percentage.
   */
  def width: StateChannel[String] = attribute("width").asInstanceOf[StateChannel[String]]
}
