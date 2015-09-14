package pl.metastack.metaweb.tag

import pl.metastack.metarx._
import pl.metastack.metaweb.state

trait HTMLTag { self: state.Tag =>
  /**
   * Provides a hint for generating a keyboard shortcut for the current element. This attribute consists of a space-separated list of characters. The browser should use the first one that exists on the computer keyboard layout.
   */
  def accesskey: StateChannel[String] = attribute("accesskey").asInstanceOf[StateChannel[String]]
  /**
   * Is a space-separated list of the classes of the element. Classes allows CSS and JavaScript to select and access specific elements via the 
<a href="/En/CSS/Class_selectors" title="https://developer.mozilla.org/En/CSS/Class_selectors">class selectors</a> or functions like the method 
<a href="/en-US/docs/Web/API/Document/getElementsByClassName" title="Returns an array-like object of all child elements which have all of the given class names. When called on the document object, the complete document is searched, including the root node. You may also call getElementsByClassName() on any element; it will return only elements which are descendants of the specified root element with the given class names."><code>Document.getElementsByClassName()</code></a>.
   */
  def `class`: StateChannel[String] = attribute("class").asInstanceOf[StateChannel[String]]
  /**
   * Is an enumerated attribute indicating if the element should be editable by the user. If so, the browser modifies its widget to allow editing. The attribute must take one of the following values: 
<ul> 
 <li><code>true</code> or the <em>empty string</em>, which indicates that the element must be editable;</li> 
 <li><code>false</code>, which indicates that the element must not be editable.</li> 
</ul>
   */
  def contenteditable: StateChannel[String] = attribute("contenteditable").asInstanceOf[StateChannel[String]]
  /**
   * Is the 
<code><a href="#attr-id"><strong>id</strong></a></code> of an 
<a href="/en-US/docs/Web/HTML/Element/menu" title="The HTML <menu> element represents a group of commands that a user can perform or activate. This includes both list menus, which might appear across the top of a screen, as well as context menus, such as those that might appear underneath a button after it has been clicked."><code>&lt;menu&gt;</code></a> to use as the contextual menu for this element.
   */
  def contextmenu: StateChannel[String] = attribute("contextmenu").asInstanceOf[StateChannel[String]]
  /**
   * Is an enumerated attribute indicating the directionality of the element's text. It can have the following values: 
<ul> 
 <li><code>ltr</code>, which means <em>left to right </em>and is to be used for languages that are written from the left to the right (like English);</li> 
 <li><code>rtl</code>, which means <em>right to left</em> and is to be used for languages that are written from the right to the left (like Arabic);</li> 
 <li><code>auto</code>, which let the user agent decides. It uses a basic algorithm as it parses the characters inside the element until it finds a character with a strong directionality, then apply that directionality to the whole element.</li> 
</ul>
   */
  def dir: StateChannel[String] = attribute("dir").asInstanceOf[StateChannel[String]]
  /**
   * Is an enumerated attribute indicating whether the element can be dragged, using the 
<a href="/en-us/docs/DragDrop/Drag_and_Drop">Drag and Drop API</a>. It can have the following values: 
<ul> 
 <li><code>true</code>, which indicates that the element may be dragged</li> 
 <li><code>false</code>, which indicates that the element may not be dragged.</li> 
</ul>
   */
  def draggable: StateChannel[String] = attribute("draggable").asInstanceOf[StateChannel[String]]
  /**
   * Is an enumerated attribute indicating what types of content can be dropped on an element, using the 
<a href="/En-us/docs/DragDrop/Drag_and_Drop" title="https://developer.mozilla.org/En/DragDrop/Drag_and_Drop">Drag and Drop API</a>. It can have the following values: 
<ul> 
 <li><code>copy</code>, which indicates that dropping will create a copy of the element that was dragged</li> 
 <li><code>move</code>, which indicates that the element that was dragged will be moved to this new location.</li> 
 <li><code>link</code>, will create a link to the dragged data.</li> 
</ul>
   */
  def dropzone: StateChannel[String] = attribute("dropzone").asInstanceOf[StateChannel[String]]
  /**
   * Is a Boolean attribute indicates that the element is not yet, or is no longer, 
<em>relevant</em>. For example, it can be used to hide elements of the page that can't be used until the login process has been completed. The browser won't render such elements. This attribute must not be used to hide content that could legitimately be shown.
   */
  def hidden: StateChannel[String] = attribute("hidden").asInstanceOf[StateChannel[String]]
  /**
   * Defines a unique identifier (ID) which must be unique in the whole document. Its purpose is to identify the element when linking (using a fragment identifier), scripting, or styling (with CSS).
   */
  def id: StateChannel[String] = attribute("id").asInstanceOf[StateChannel[String]]
  /**
   * 
   */
  def itemid: StateChannel[String] = attribute("itemid").asInstanceOf[StateChannel[String]]
  /**
   * 
   */
  def itemprop: StateChannel[String] = attribute("itemprop").asInstanceOf[StateChannel[String]]
  /**
   * 
   */
  def itemref: StateChannel[String] = attribute("itemref").asInstanceOf[StateChannel[String]]
  /**
   * 
   */
  def itemscope: StateChannel[String] = attribute("itemscope").asInstanceOf[StateChannel[String]]
  /**
   * These attributes are related to the 
<a class="external" href="http://www.whatwg.org/specs/web-apps/current-work/multipage/links.html#microdata" title="http://www.whatwg.org/specs/web-apps/current-work/multipage/links.html#microdata">WHATWG HTML Microdata feature</a>.
   */
  def itemtype: StateChannel[String] = attribute("itemtype").asInstanceOf[StateChannel[String]]
  /**
   * Participates in defining the language of the element, the language that non-editable elements are written in or the language that editable elements should be written in. The tag contains one single entry value in the format defines in the 
<a class="external" href="http://www.ietf.org/rfc/bcp/bcp47.txt" title="http://www.ietf.org/rfc/bcp/bcp47.txt"><em>Tags for Identifying Languages (BCP47)</em></a> IETF document. 
<a href="#attr-xml:lang"><strong>xml:lang</strong></a> has priority over it.
   */
  def lang: StateChannel[String] = attribute("lang").asInstanceOf[StateChannel[String]]
  /**
   * Is an enumerated attribute defines whether the element may be checked for spelling errors. It may have the following values: 
<ul> 
 <li><code>true</code>, which indicates that the element should be, if possible, checked for spelling errors;</li> 
 <li><code>false</code>, which indicates that the element should not be checked for spelling errors.</li> 
</ul>
   */
  def spellcheck: StateChannel[String] = attribute("spellcheck").asInstanceOf[StateChannel[String]]
  /**
   * Contains 
<a href="/en/CSS" title="en/CSS">CSS</a> styling declarations to be applied to the element. Note that it is recommended for styles to be defined in a separate file or files. This attribute and the 
<a href="/en-US/docs/Web/HTML/Element/style" title="The HTML Style Element (<style>) contains style information for a document, or part of a document. By default, the style instructions writen inside that element are expected to be CSS."><code>&lt;style&gt;</code></a> element have mainly the purpose of allowing for quick styling, for example for testing purposes.
   */
  def style: StateChannel[String] = attribute("style").asInstanceOf[StateChannel[String]]
  /**
   * Is an integer attribute indicates if the element can take input focus (is 
<em>focusable</em>), if it should participate to sequential keyboard navigation, and if so, at what position. It can takes several values: 
<ul> 
 <li>a <em>negative value</em> means that the element should be focusable, but should not be reachable via sequential keyboard navigation;</li> 
 <li><code>0</code> means that the element should be focusable and reachable via sequential keyboard navigation, but its relative order is defined by the platform convention;</li> 
 <li>a <em>positive value</em> which means should be focusable and reachable via sequential keyboard navigation; its relative order is defined by the value of the attribute: the sequential follow the increasing number of the <a href="#attr-tabindex"><strong>tabindex</strong></a>. If several elements share the same tabindex, their relative order follows their relative position in the document).</li> 
</ul>
   */
  def tabindex: StateChannel[String] = attribute("tabindex").asInstanceOf[StateChannel[String]]
  /**
   * Contains a text representing advisory information related to the element it belongs to. Such information can typically, but not necessarily, be presented to the user as a tooltip.
   */
  def title: StateChannel[String] = attribute("title").asInstanceOf[StateChannel[String]]
  /**
   * Is an enumerated attribute that is used to specify whether an element's attribute values and the values of it
<code>s</code> 
<a href="/en-US/docs/Web/API/Text" title="The Text interface represents the textual content of Element or Attr.&nbsp; If an element has no markup within its content, it has a single child implementing Text that contains the element's text.&nbsp; However, if the element contains markup, it is parsed into information items and Text nodes that form its children."><code>Text</code></a> node children are to be translated when the page is localized, or whether to leave them unchanged. It can have the following values: 
<ul> 
 <li>empty string and <code>"yes"</code>, which indicates that the element will be translated.</li> 
 <li><code>"no</code>", which indicates that the element will not be translated.</li> 
</ul>
   */
  def translate: StateChannel[String] = attribute("translate").asInstanceOf[StateChannel[String]]
}
object HTMLTag {
  def fromTag(tag: String): state.Tag =
    tag match {
      case "a" => new A
      case "acronym" => new Acronym
      case "address" => new Address
      case "applet" => new Applet
      case "area" => new Area
      case "article" => new Article
      case "audio" => new Audio
      case "b" => new B
      case "base" => new Base
      case "basefont" => new Basefont
      case "big" => new Big
      case "body" => new Body
      case "br" => new Br
      case "button" => new Button
      case "canvas" => new Canvas
      case "caption" => new Caption
      case "center" => new Center
      case "code" => new Code
      case "col" => new Col
      case "colgroup" => new Colgroup
      case "content" => new Content
      case "datalist" => new Datalist
      case "dd" => new Dd
      case "del" => new Del
      case "details" => new Details
      case "dialog" => new Dialog
      case "dir" => new Dir
      case "div" => new Div
      case "dl" => new Dl
      case "dt" => new Dt
      case "element" => new Element
      case "em" => new Em
      case "embed" => new Embed
      case "fieldset" => new Fieldset
      case "figcaption" => new Figcaption
      case "figure" => new Figure
      case "footer" => new Footer
      case "form" => new Form
      case "frame" => new Frame
      case "frameset" => new Frameset
      case "h1" => new H1
      case "h2" => new H2
      case "h3" => new H3
      case "h4" => new H4
      case "h5" => new H5
      case "h6" => new H6
      case "head" => new Head
      case "header" => new Header
      case "hgroup" => new Hgroup
      case "hr" => new Hr
      case "html" => new Html
      case "i" => new I
      case "iframe" => new Iframe
      case "img" => new Img
      case "input" => new Input
      case "ins" => new Ins
      case "isindex" => new Isindex
      case "keygen" => new Keygen
      case "label" => new Label
      case "legend" => new Legend
      case "li" => new Li
      case "link" => new Link
      case "listing" => new Listing
      case "main" => new Main
      case "map" => new Map
      case "menu" => new Menu
      case "menuitem" => new Menuitem
      case "meta" => new Meta
      case "meter" => new Meter
      case "nav" => new Nav
      case "noscript" => new Noscript
      case "object" => new Object
      case "ol" => new Ol
      case "optgroup" => new Optgroup
      case "option" => new Option
      case "output" => new Output
      case "p" => new P
      case "param" => new Param
      case "plaintext" => new Plaintext
      case "pre" => new Pre
      case "progress" => new Progress
      case "script" => new Script
      case "section" => new Section
      case "select" => new Select
      case "shadow" => new Shadow
      case "small" => new Small
      case "source" => new Source
      case "spacer" => new Spacer
      case "span" => new Span
      case "strike" => new Strike
      case "strong" => new Strong
      case "style" => new Style
      case "summary" => new Summary
      case "table" => new Table
      case "tbody" => new Tbody
      case "td" => new Td
      case "template" => new Template
      case "textarea" => new Textarea
      case "tfoot" => new Tfoot
      case "th" => new Th
      case "thead" => new Thead
      case "title" => new Title
      case "tr" => new Tr
      case "track" => new Track
      case "tt" => new Tt
      case "ul" => new Ul
      case "video" => new Video
      case "xmp" => new Xmp
    }
}
