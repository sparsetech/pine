package pine.tag

import pine._

trait HTMLTag extends Tag {
  /**
   * Provides a hint for generating a keyboard shortcut for the current element. This attribute consists of a space-separated list of characters. The browser should use the first one that exists on the computer keyboard layout.
   */
  def accesskey: scala.Option[String] = attributes.get("accesskey").asInstanceOf[scala.Option[String]]
  def accesskey(value: String): T = copy(attributes = attributes + ("accesskey" -> value))
  /**
   * Is a space-separated list of the classes of the element. Classes allows CSS and JavaScript to select and access specific elements via the 
<a href="/En/CSS/Class_selectors" title="https://developer.mozilla.org/En/CSS/Class_selectors">class selectors</a> or functions like the method 
<a href="/en-US/docs/Web/API/Document/getElementsByClassName" title="Returns an array-like object of all child elements which have all of the given class names. When called on the document object, the complete document is searched, including the root node. You may also call getElementsByClassName() on any element; it will return only elements which are descendants of the specified root element with the given class names."><code>Document.getElementsByClassName()</code></a>.
   */
  def `class`: scala.Option[String] = attributes.get("class").asInstanceOf[scala.Option[String]]
  def `class`(value: String): T = copy(attributes = attributes + ("class" -> value))
  /**
   * Is an enumerated attribute indicating if the element should be editable by the user. If so, the browser modifies its widget to allow editing. The attribute must take one of the following values: 
<ul> 
 <li><code>true</code> or the <em>empty string</em>, which indicates that the element must be editable;</li> 
 <li><code>false</code>, which indicates that the element must not be editable.</li> 
</ul>
   */
  def contenteditable: scala.Option[String] = attributes.get("contenteditable").asInstanceOf[scala.Option[String]]
  def contenteditable(value: String): T = copy(attributes = attributes + ("contenteditable" -> value))
  /**
   * Is the 
<code><a href="#attr-id"><strong>id</strong></a></code> of an 
<a href="/en-US/docs/Web/HTML/Element/menu" title="The HTML <menu> element represents a group of commands that a user can perform or activate. This includes both list menus, which might appear across the top of a screen, as well as context menus, such as those that might appear underneath a button after it has been clicked."><code>&lt;menu&gt;</code></a> to use as the contextual menu for this element.
   */
  def contextmenu: scala.Option[String] = attributes.get("contextmenu").asInstanceOf[scala.Option[String]]
  def contextmenu(value: String): T = copy(attributes = attributes + ("contextmenu" -> value))
  /**
   * Is an enumerated attribute indicating the directionality of the element's text. It can have the following values: 
<ul> 
 <li><code>ltr</code>, which means <em>left to right </em>and is to be used for languages that are written from the left to the right (like English);</li> 
 <li><code>rtl</code>, which means <em>right to left</em> and is to be used for languages that are written from the right to the left (like Arabic);</li> 
 <li><code>auto</code>, which let the user agent decides. It uses a basic algorithm as it parses the characters inside the element until it finds a character with a strong directionality, then apply that directionality to the whole element.</li> 
</ul>
   */
  def dir: scala.Option[String] = attributes.get("dir").asInstanceOf[scala.Option[String]]
  def dir(value: String): T = copy(attributes = attributes + ("dir" -> value))
  /**
   * Is an enumerated attribute indicating whether the element can be dragged, using the 
<a href="/en-us/docs/DragDrop/Drag_and_Drop">Drag and Drop API</a>. It can have the following values: 
<ul> 
 <li><code>true</code>, which indicates that the element may be dragged</li> 
 <li><code>false</code>, which indicates that the element may not be dragged.</li> 
</ul>
   */
  def draggable: scala.Option[String] = attributes.get("draggable").asInstanceOf[scala.Option[String]]
  def draggable(value: String): T = copy(attributes = attributes + ("draggable" -> value))
  /**
   * Is an enumerated attribute indicating what types of content can be dropped on an element, using the 
<a href="/En-us/docs/DragDrop/Drag_and_Drop" title="https://developer.mozilla.org/En/DragDrop/Drag_and_Drop">Drag and Drop API</a>. It can have the following values: 
<ul> 
 <li><code>copy</code>, which indicates that dropping will create a copy of the element that was dragged</li> 
 <li><code>move</code>, which indicates that the element that was dragged will be moved to this new location.</li> 
 <li><code>link</code>, will create a link to the dragged data.</li> 
</ul>
   */
  def dropzone: scala.Option[String] = attributes.get("dropzone").asInstanceOf[scala.Option[String]]
  def dropzone(value: String): T = copy(attributes = attributes + ("dropzone" -> value))
  /**
   * Is a Boolean attribute indicates that the element is not yet, or is no longer, 
<em>relevant</em>. For example, it can be used to hide elements of the page that can't be used until the login process has been completed. The browser won't render such elements. This attribute must not be used to hide content that could legitimately be shown.
   */
  def hidden: scala.Option[String] = attributes.get("hidden").asInstanceOf[scala.Option[String]]
  def hidden(value: String): T = copy(attributes = attributes + ("hidden" -> value))
  /**
   * Defines a unique identifier (ID) which must be unique in the whole document. Its purpose is to identify the element when linking (using a fragment identifier), scripting, or styling (with CSS).
   */
  def id: scala.Option[String] = attributes.get("id").asInstanceOf[scala.Option[String]]
  def id(value: String): T = copy(attributes = attributes + ("id" -> value))
  /**
   * 
   */
  def itemid: scala.Option[String] = attributes.get("itemid").asInstanceOf[scala.Option[String]]
  def itemid(value: String): T = copy(attributes = attributes + ("itemid" -> value))
  /**
   * 
   */
  def itemprop: scala.Option[String] = attributes.get("itemprop").asInstanceOf[scala.Option[String]]
  def itemprop(value: String): T = copy(attributes = attributes + ("itemprop" -> value))
  /**
   * 
   */
  def itemref: scala.Option[String] = attributes.get("itemref").asInstanceOf[scala.Option[String]]
  def itemref(value: String): T = copy(attributes = attributes + ("itemref" -> value))
  /**
   * 
   */
  def itemscope: scala.Option[String] = attributes.get("itemscope").asInstanceOf[scala.Option[String]]
  def itemscope(value: String): T = copy(attributes = attributes + ("itemscope" -> value))
  /**
   * These attributes are related to the 
<a class="external" href="http://www.whatwg.org/specs/web-apps/current-work/multipage/links.html#microdata" title="http://www.whatwg.org/specs/web-apps/current-work/multipage/links.html#microdata">WHATWG HTML Microdata feature</a>.
   */
  def itemtype: scala.Option[String] = attributes.get("itemtype").asInstanceOf[scala.Option[String]]
  def itemtype(value: String): T = copy(attributes = attributes + ("itemtype" -> value))
  /**
   * Participates in defining the language of the element, the language that non-editable elements are written in or the language that editable elements should be written in. The tag contains one single entry value in the format defines in the 
<a class="external" href="http://www.ietf.org/rfc/bcp/bcp47.txt" title="http://www.ietf.org/rfc/bcp/bcp47.txt"><em>Tags for Identifying Languages (BCP47)</em></a> IETF document. 
<a href="#attr-xml:lang"><strong>xml:lang</strong></a> has priority over it.
   */
  def lang: scala.Option[String] = attributes.get("lang").asInstanceOf[scala.Option[String]]
  def lang(value: String): T = copy(attributes = attributes + ("lang" -> value))
  /**
   * Is an enumerated attribute defines whether the element may be checked for spelling errors. It may have the following values: 
<ul> 
 <li><code>true</code>, which indicates that the element should be, if possible, checked for spelling errors;</li> 
 <li><code>false</code>, which indicates that the element should not be checked for spelling errors.</li> 
</ul>
   */
  def spellcheck: scala.Option[String] = attributes.get("spellcheck").asInstanceOf[scala.Option[String]]
  def spellcheck(value: String): T = copy(attributes = attributes + ("spellcheck" -> value))
  /**
   * Contains 
<a href="/en/CSS" title="en/CSS">CSS</a> styling declarations to be applied to the element. Note that it is recommended for styles to be defined in a separate file or files. This attribute and the 
<a href="/en-US/docs/Web/HTML/Element/style" title="The HTML Style Element (<style>) contains style information for a document, or part of a document. By default, the style instructions writen inside that element are expected to be CSS."><code>&lt;style&gt;</code></a> element have mainly the purpose of allowing for quick styling, for example for testing purposes.
   */
  def style: scala.Option[String] = attributes.get("style").asInstanceOf[scala.Option[String]]
  def style(value: String): T = copy(attributes = attributes + ("style" -> value))
  /**
   * Is an integer attribute indicates if the element can take input focus (is 
<em>focusable</em>), if it should participate to sequential keyboard navigation, and if so, at what position. It can takes several values: 
<ul> 
 <li>a <em>negative value</em> means that the element should be focusable, but should not be reachable via sequential keyboard navigation;</li> 
 <li><code>0</code> means that the element should be focusable and reachable via sequential keyboard navigation, but its relative order is defined by the platform convention;</li> 
 <li>a <em>positive value</em> which means should be focusable and reachable via sequential keyboard navigation; its relative order is defined by the value of the attribute: the sequential follow the increasing number of the <a href="#attr-tabindex"><strong>tabindex</strong></a>. If several elements share the same tabindex, their relative order follows their relative position in the document).</li> 
</ul>
   */
  def tabindex: scala.Option[String] = attributes.get("tabindex").asInstanceOf[scala.Option[String]]
  def tabindex(value: String): T = copy(attributes = attributes + ("tabindex" -> value))
  /**
   * Contains a text representing advisory information related to the element it belongs to. Such information can typically, but not necessarily, be presented to the user as a tooltip.
   */
  def title: scala.Option[String] = attributes.get("title").asInstanceOf[scala.Option[String]]
  def title(value: String): T = copy(attributes = attributes + ("title" -> value))
  /**
   * Is an enumerated attribute that is used to specify whether an element's attribute values and the values of it
<code>s</code> 
<a href="/en-US/docs/Web/API/Text" title="The Text interface represents the textual content of Element or Attr.&nbsp; If an element has no markup within its content, it has a single child implementing Text that contains the element's text.&nbsp; However, if the element contains markup, it is parsed into information items and Text nodes that form its children."><code>Text</code></a> node children are to be translated when the page is localized, or whether to leave them unchanged. It can have the following values: 
<ul> 
 <li>empty string and <code>"yes"</code>, which indicates that the element will be translated.</li> 
 <li><code>"no</code>", which indicates that the element will not be translated.</li> 
</ul>
   */
  def translate: scala.Option[String] = attributes.get("translate").asInstanceOf[scala.Option[String]]
  def translate(value: String): T = copy(attributes = attributes + ("translate" -> value))
}
object HTMLTag {
  def fromTag(tagName: String, attributes: Predef.Map[String, Any] = Predef.Map.empty, children: Seq[Node] = Seq.empty): Tag =
    tagName.toLowerCase match {
      case "a" => A(attributes, children)
      case "acronym" => Acronym(attributes, children)
      case "address" => Address(attributes, children)
      case "applet" => Applet(attributes, children)
      case "area" => Area(attributes, children)
      case "article" => Article(attributes, children)
      case "audio" => Audio(attributes, children)
      case "b" => B(attributes, children)
      case "base" => Base(attributes, children)
      case "basefont" => Basefont(attributes, children)
      case "big" => Big(attributes, children)
      case "body" => Body(attributes, children)
      case "br" => Br(attributes, children)
      case "button" => Button(attributes, children)
      case "canvas" => Canvas(attributes, children)
      case "caption" => Caption(attributes, children)
      case "center" => Center(attributes, children)
      case "code" => Code(attributes, children)
      case "col" => Col(attributes, children)
      case "colgroup" => Colgroup(attributes, children)
      case "content" => Content(attributes, children)
      case "datalist" => Datalist(attributes, children)
      case "dd" => Dd(attributes, children)
      case "del" => Del(attributes, children)
      case "details" => Details(attributes, children)
      case "dialog" => Dialog(attributes, children)
      case "dir" => Dir(attributes, children)
      case "div" => Div(attributes, children)
      case "dl" => Dl(attributes, children)
      case "dt" => Dt(attributes, children)
      case "em" => Em(attributes, children)
      case "embed" => Embed(attributes, children)
      case "fieldset" => Fieldset(attributes, children)
      case "figcaption" => Figcaption(attributes, children)
      case "figure" => Figure(attributes, children)
      case "footer" => Footer(attributes, children)
      case "form" => Form(attributes, children)
      case "frame" => Frame(attributes, children)
      case "frameset" => Frameset(attributes, children)
      case "h1" => H1(attributes, children)
      case "h2" => H2(attributes, children)
      case "h3" => H3(attributes, children)
      case "h4" => H4(attributes, children)
      case "h5" => H5(attributes, children)
      case "h6" => H6(attributes, children)
      case "head" => Head(attributes, children)
      case "header" => Header(attributes, children)
      case "hgroup" => Hgroup(attributes, children)
      case "hr" => Hr(attributes, children)
      case "html" => Html(attributes, children)
      case "i" => I(attributes, children)
      case "iframe" => Iframe(attributes, children)
      case "img" => Img(attributes, children)
      case "input" => Input(attributes, children)
      case "ins" => Ins(attributes, children)
      case "isindex" => Isindex(attributes, children)
      case "keygen" => Keygen(attributes, children)
      case "label" => Label(attributes, children)
      case "legend" => Legend(attributes, children)
      case "li" => Li(attributes, children)
      case "link" => Link(attributes, children)
      case "listing" => Listing(attributes, children)
      case "main" => Main(attributes, children)
      case "map" => Map(attributes, children)
      case "menu" => Menu(attributes, children)
      case "menuitem" => Menuitem(attributes, children)
      case "meta" => Meta(attributes, children)
      case "meter" => Meter(attributes, children)
      case "nav" => Nav(attributes, children)
      case "noscript" => Noscript(attributes, children)
      case "object" => Object(attributes, children)
      case "ol" => Ol(attributes, children)
      case "optgroup" => Optgroup(attributes, children)
      case "option" => Option(attributes, children)
      case "output" => Output(attributes, children)
      case "p" => P(attributes, children)
      case "param" => Param(attributes, children)
      case "plaintext" => Plaintext(attributes, children)
      case "pre" => Pre(attributes, children)
      case "progress" => Progress(attributes, children)
      case "script" => Script(attributes, children)
      case "section" => Section(attributes, children)
      case "select" => Select(attributes, children)
      case "shadow" => Shadow(attributes, children)
      case "small" => Small(attributes, children)
      case "source" => Source(attributes, children)
      case "spacer" => Spacer(attributes, children)
      case "span" => Span(attributes, children)
      case "strike" => Strike(attributes, children)
      case "strong" => Strong(attributes, children)
      case "style" => Style(attributes, children)
      case "summary" => Summary(attributes, children)
      case "table" => Table(attributes, children)
      case "tbody" => Tbody(attributes, children)
      case "td" => Td(attributes, children)
      case "template" => Template(attributes, children)
      case "textarea" => Textarea(attributes, children)
      case "tfoot" => Tfoot(attributes, children)
      case "th" => Th(attributes, children)
      case "thead" => Thead(attributes, children)
      case "title" => Title(attributes, children)
      case "tr" => Tr(attributes, children)
      case "track" => Track(attributes, children)
      case "tt" => Tt(attributes, children)
      case "ul" => Ul(attributes, children)
      case "video" => Video(attributes, children)
      case "xmp" => Xmp(attributes, children)
      case _ => CustomTag(tagName, attributes, children)
    }
}
