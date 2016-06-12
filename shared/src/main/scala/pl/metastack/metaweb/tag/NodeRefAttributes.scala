package pl.metastack.metaweb.tag

import pl.metastack.metaweb.diff.{Attribute, NodeRef}

trait NodeRefAttributes {
  implicit class NodeRefAttributesHTMLTag[_](nodeRef: NodeRef[HTMLTag[_]]) {
    val accesskey = new Attribute[HTMLTag[_], scala.Option[String], String](nodeRef, "accesskey")
    val `class` = new Attribute[HTMLTag[_], scala.Option[String], String](nodeRef, "class")
    val contenteditable = new Attribute[HTMLTag[_], scala.Option[String], String](nodeRef, "contenteditable")
    val contextmenu = new Attribute[HTMLTag[_], scala.Option[String], String](nodeRef, "contextmenu")
    val dir = new Attribute[HTMLTag[_], scala.Option[String], String](nodeRef, "dir")
    val draggable = new Attribute[HTMLTag[_], scala.Option[String], String](nodeRef, "draggable")
    val dropzone = new Attribute[HTMLTag[_], scala.Option[String], String](nodeRef, "dropzone")
    val hidden = new Attribute[HTMLTag[_], scala.Option[String], String](nodeRef, "hidden")
    val id = new Attribute[HTMLTag[_], scala.Option[String], String](nodeRef, "id")
    val itemid = new Attribute[HTMLTag[_], scala.Option[String], String](nodeRef, "itemid")
    val itemprop = new Attribute[HTMLTag[_], scala.Option[String], String](nodeRef, "itemprop")
    val itemref = new Attribute[HTMLTag[_], scala.Option[String], String](nodeRef, "itemref")
    val itemscope = new Attribute[HTMLTag[_], scala.Option[String], String](nodeRef, "itemscope")
    val itemtype = new Attribute[HTMLTag[_], scala.Option[String], String](nodeRef, "itemtype")
    val lang = new Attribute[HTMLTag[_], scala.Option[String], String](nodeRef, "lang")
    val spellcheck = new Attribute[HTMLTag[_], scala.Option[String], String](nodeRef, "spellcheck")
    val style = new Attribute[HTMLTag[_], scala.Option[String], String](nodeRef, "style")
    val tabindex = new Attribute[HTMLTag[_], scala.Option[String], String](nodeRef, "tabindex")
    val title = new Attribute[HTMLTag[_], scala.Option[String], String](nodeRef, "title")
    val translate = new Attribute[HTMLTag[_], scala.Option[String], String](nodeRef, "translate")
  }

  implicit class NodeRefAttributesA(nodeRef: NodeRef[A]) {
    val download = new Attribute[A, scala.Option[String], String](nodeRef, "download")
    val href = new Attribute[A, scala.Option[String], String](nodeRef, "href")
    val hreflang = new Attribute[A, scala.Option[String], String](nodeRef, "hreflang")
    val media = new Attribute[A, scala.Option[String], String](nodeRef, "media")
    val ping = new Attribute[A, scala.Option[String], String](nodeRef, "ping")
    val rel = new Attribute[A, scala.Option[String], String](nodeRef, "rel")
    val target = new Attribute[A, scala.Option[String], String](nodeRef, "target")
    val `type` = new Attribute[A, scala.Option[String], String](nodeRef, "type")
    val charset = new Attribute[A, scala.Option[String], String](nodeRef, "charset")
    val coords = new Attribute[A, scala.Option[String], String](nodeRef, "coords")
    val name = new Attribute[A, scala.Option[String], String](nodeRef, "name")
    val rev = new Attribute[A, scala.Option[String], String](nodeRef, "rev")
    val shape = new Attribute[A, scala.Option[String], String](nodeRef, "shape")
    val datafld = new Attribute[A, scala.Option[String], String](nodeRef, "datafld")
    val datasrc = new Attribute[A, scala.Option[String], String](nodeRef, "datasrc")
    val methods = new Attribute[A, scala.Option[String], String](nodeRef, "methods")
    val urn = new Attribute[A, scala.Option[String], String](nodeRef, "urn")
  }

  implicit class NodeRefAttributesApplet(nodeRef: NodeRef[Applet]) {
    val align = new Attribute[Applet, scala.Option[String], String](nodeRef, "align")
    val alt = new Attribute[Applet, scala.Option[String], String](nodeRef, "alt")
    val archive = new Attribute[Applet, scala.Option[String], String](nodeRef, "archive")
    val code = new Attribute[Applet, scala.Option[String], String](nodeRef, "code")
    val codebase = new Attribute[Applet, scala.Option[String], String](nodeRef, "codebase")
    val datafld = new Attribute[Applet, scala.Option[String], String](nodeRef, "datafld")
    val datasrc = new Attribute[Applet, scala.Option[String], String](nodeRef, "datasrc")
    val height = new Attribute[Applet, scala.Option[String], String](nodeRef, "height")
    val hspace = new Attribute[Applet, scala.Option[String], String](nodeRef, "hspace")
    val mayscript = new Attribute[Applet, scala.Option[String], String](nodeRef, "mayscript")
    val name = new Attribute[Applet, scala.Option[String], String](nodeRef, "name")
    val `object` = new Attribute[Applet, scala.Option[String], String](nodeRef, "object")
    val src = new Attribute[Applet, scala.Option[String], String](nodeRef, "src")
    val vspace = new Attribute[Applet, scala.Option[String], String](nodeRef, "vspace")
    val width = new Attribute[Applet, scala.Option[String], String](nodeRef, "width")
  }

  implicit class NodeRefAttributesArea(nodeRef: NodeRef[Area]) {
    val accesskey = new Attribute[Area, scala.Option[String], String](nodeRef, "accesskey")
    val alt = new Attribute[Area, scala.Option[String], String](nodeRef, "alt")
    val coords = new Attribute[Area, scala.Option[String], String](nodeRef, "coords")
    val download = new Attribute[Area, scala.Option[String], String](nodeRef, "download")
    val href = new Attribute[Area, scala.Option[String], String](nodeRef, "href")
    val hreflang = new Attribute[Area, scala.Option[String], String](nodeRef, "hreflang")
    val name = new Attribute[Area, scala.Option[String], String](nodeRef, "name")
    val media = new Attribute[Area, scala.Option[String], String](nodeRef, "media")
    val nohref = new Attribute[Area, scala.Option[String], String](nodeRef, "nohref")
    val rel = new Attribute[Area, scala.Option[String], String](nodeRef, "rel")
    val shape = new Attribute[Area, scala.Option[String], String](nodeRef, "shape")
    val tabindex = new Attribute[Area, scala.Option[String], String](nodeRef, "tabindex")
    val target = new Attribute[Area, scala.Option[String], String](nodeRef, "target")
    val `type` = new Attribute[Area, scala.Option[String], String](nodeRef, "type")
  }

  implicit class NodeRefAttributesAudio(nodeRef: NodeRef[Audio]) {
    val autoplay = new Attribute[Audio, scala.Option[String], String](nodeRef, "autoplay")
    val autobuffer = new Attribute[Audio, scala.Option[String], String](nodeRef, "autobuffer")
    val buffered = new Attribute[Audio, scala.Option[String], String](nodeRef, "buffered")
    val controls = new Attribute[Audio, scala.Option[String], String](nodeRef, "controls")
    val loop = new Attribute[Audio, scala.Option[String], String](nodeRef, "loop")
    val mozCurrentSampleOffset = new Attribute[Audio, scala.Option[String], String](nodeRef, "mozCurrentSampleOffset")
    val muted = new Attribute[Audio, scala.Option[String], String](nodeRef, "muted")
    val played = new Attribute[Audio, scala.Option[String], String](nodeRef, "played")
    val preload = new Attribute[Audio, scala.Option[String], String](nodeRef, "preload")
    val src = new Attribute[Audio, scala.Option[String], String](nodeRef, "src")
    val volume = new Attribute[Audio, scala.Option[String], String](nodeRef, "volume")
  }

  implicit class NodeRefAttributesBase(nodeRef: NodeRef[Base]) {
    val href = new Attribute[Base, scala.Option[String], String](nodeRef, "href")
    val target = new Attribute[Base, scala.Option[String], String](nodeRef, "target")
  }

  implicit class NodeRefAttributesBasefont(nodeRef: NodeRef[Basefont]) {
    val color = new Attribute[Basefont, scala.Option[String], String](nodeRef, "color")
    val face = new Attribute[Basefont, scala.Option[String], String](nodeRef, "face")
    val size = new Attribute[Basefont, scala.Option[String], String](nodeRef, "size")
  }

  implicit class NodeRefAttributesBody(nodeRef: NodeRef[Body]) {
    val alink = new Attribute[Body, scala.Option[String], String](nodeRef, "alink")
    val background = new Attribute[Body, scala.Option[String], String](nodeRef, "background")
    val bgcolor = new Attribute[Body, scala.Option[String], String](nodeRef, "bgcolor")
    val bottommargin = new Attribute[Body, scala.Option[String], String](nodeRef, "bottommargin")
    val leftmargin = new Attribute[Body, scala.Option[String], String](nodeRef, "leftmargin")
    val link = new Attribute[Body, scala.Option[String], String](nodeRef, "link")
    val onafterprint = new Attribute[Body, scala.Option[String], String](nodeRef, "onafterprint")
    val onbeforeprint = new Attribute[Body, scala.Option[String], String](nodeRef, "onbeforeprint")
    val onbeforeunload = new Attribute[Body, scala.Option[String], String](nodeRef, "onbeforeunload")
    val onblur = new Attribute[Body, scala.Option[String], String](nodeRef, "onblur")
    val onerror = new Attribute[Body, scala.Option[String], String](nodeRef, "onerror")
    val onfocus = new Attribute[Body, scala.Option[String], String](nodeRef, "onfocus")
    val onhashchange = new Attribute[Body, scala.Option[String], String](nodeRef, "onhashchange")
    val onlanguagechange = new Attribute[Body, scala.Option[String], String](nodeRef, "onlanguagechange")
    val onload = new Attribute[Body, scala.Option[String], String](nodeRef, "onload")
    val onmessage = new Attribute[Body, scala.Option[String], String](nodeRef, "onmessage")
    val onoffline = new Attribute[Body, scala.Option[String], String](nodeRef, "onoffline")
    val ononline = new Attribute[Body, scala.Option[String], String](nodeRef, "ononline")
    val onpopstate = new Attribute[Body, scala.Option[String], String](nodeRef, "onpopstate")
    val onredo = new Attribute[Body, scala.Option[String], String](nodeRef, "onredo")
    val onresize = new Attribute[Body, scala.Option[String], String](nodeRef, "onresize")
    val onstorage = new Attribute[Body, scala.Option[String], String](nodeRef, "onstorage")
    val onundo = new Attribute[Body, scala.Option[String], String](nodeRef, "onundo")
    val onunload = new Attribute[Body, scala.Option[String], String](nodeRef, "onunload")
    val rightmargin = new Attribute[Body, scala.Option[String], String](nodeRef, "rightmargin")
    val text = new Attribute[Body, scala.Option[String], String](nodeRef, "text")
    val topmargin = new Attribute[Body, scala.Option[String], String](nodeRef, "topmargin")
    val vlink = new Attribute[Body, scala.Option[String], String](nodeRef, "vlink")
  }

  implicit class NodeRefAttributesBr(nodeRef: NodeRef[Br]) {
    val clear = new Attribute[Br, scala.Option[String], String](nodeRef, "clear")
  }

  implicit class NodeRefAttributesButton(nodeRef: NodeRef[Button]) {
    val autofocus = new Attribute[Button, Boolean, Boolean](nodeRef, "autofocus")
    val autocomplete = new Attribute[Button, scala.Option[String], String](nodeRef, "autocomplete")
    val disabled = new Attribute[Button, Boolean, Boolean](nodeRef, "disabled")
    val form = new Attribute[Button, scala.Option[String], String](nodeRef, "form")
    val formaction = new Attribute[Button, scala.Option[String], String](nodeRef, "formaction")
    val formenctype = new Attribute[Button, scala.Option[String], String](nodeRef, "formenctype")
    val formmethod = new Attribute[Button, scala.Option[String], String](nodeRef, "formmethod")
    val formnovalidate = new Attribute[Button, scala.Option[String], String](nodeRef, "formnovalidate")
    val formtarget = new Attribute[Button, scala.Option[String], String](nodeRef, "formtarget")
    val name = new Attribute[Button, scala.Option[String], String](nodeRef, "name")
    val `type` = new Attribute[Button, scala.Option[String], String](nodeRef, "type")
    val value = new Attribute[Button, scala.Option[String], String](nodeRef, "value")
  }

  implicit class NodeRefAttributesCanvas(nodeRef: NodeRef[Canvas]) {
    val height = new Attribute[Canvas, scala.Option[String], String](nodeRef, "height")
    val `moz-opaque` = new Attribute[Canvas, scala.Option[String], String](nodeRef, "moz-opaque")
    val width = new Attribute[Canvas, scala.Option[String], String](nodeRef, "width")
  }

  implicit class NodeRefAttributesCaption(nodeRef: NodeRef[Caption]) {
    val align = new Attribute[Caption, scala.Option[String], String](nodeRef, "align")
  }

  implicit class NodeRefAttributesCol(nodeRef: NodeRef[Col]) {
    val align = new Attribute[Col, scala.Option[String], String](nodeRef, "align")
    val bgcolor = new Attribute[Col, scala.Option[String], String](nodeRef, "bgcolor")
    val char = new Attribute[Col, scala.Option[String], String](nodeRef, "char")
    val charoff = new Attribute[Col, scala.Option[String], String](nodeRef, "charoff")
    val span = new Attribute[Col, scala.Option[Long], Long](nodeRef, "span")
    val valign = new Attribute[Col, scala.Option[String], String](nodeRef, "valign")
    val width = new Attribute[Col, scala.Option[String], String](nodeRef, "width")
  }

  implicit class NodeRefAttributesColgroup(nodeRef: NodeRef[Colgroup]) {
    val align = new Attribute[Colgroup, scala.Option[String], String](nodeRef, "align")
    val bgcolor = new Attribute[Colgroup, scala.Option[String], String](nodeRef, "bgcolor")
    val char = new Attribute[Colgroup, scala.Option[String], String](nodeRef, "char")
    val charoff = new Attribute[Colgroup, scala.Option[String], String](nodeRef, "charoff")
    val span = new Attribute[Colgroup, scala.Option[Long], Long](nodeRef, "span")
    val valign = new Attribute[Colgroup, scala.Option[String], String](nodeRef, "valign")
    val width = new Attribute[Colgroup, scala.Option[String], String](nodeRef, "width")
  }

  implicit class NodeRefAttributesDd(nodeRef: NodeRef[Dd]) {
    val nowrap = new Attribute[Dd, scala.Option[String], String](nodeRef, "nowrap")
  }

  implicit class NodeRefAttributesDel(nodeRef: NodeRef[Del]) {
    val cite = new Attribute[Del, scala.Option[String], String](nodeRef, "cite")
    val datetime = new Attribute[Del, scala.Option[String], String](nodeRef, "datetime")
  }

  implicit class NodeRefAttributesDetails(nodeRef: NodeRef[Details]) {
    val open = new Attribute[Details, scala.Option[String], String](nodeRef, "open")
  }

  implicit class NodeRefAttributesDialog(nodeRef: NodeRef[Dialog]) {
    val open = new Attribute[Dialog, Boolean, Boolean](nodeRef, "open")
  }

  implicit class NodeRefAttributesDir(nodeRef: NodeRef[Dir]) {
    val compact = new Attribute[Dir, scala.Option[String], String](nodeRef, "compact")
  }

  implicit class NodeRefAttributesDl(nodeRef: NodeRef[Dl]) {
    val compact = new Attribute[Dl, Boolean, Boolean](nodeRef, "compact")
  }

  implicit class NodeRefAttributesEmbed(nodeRef: NodeRef[Embed]) {
    val height = new Attribute[Embed, scala.Option[String], String](nodeRef, "height")
    val src = new Attribute[Embed, scala.Option[String], String](nodeRef, "src")
    val `type` = new Attribute[Embed, scala.Option[String], String](nodeRef, "type")
    val width = new Attribute[Embed, scala.Option[String], String](nodeRef, "width")
  }

  implicit class NodeRefAttributesFieldset(nodeRef: NodeRef[Fieldset]) {
    val disabled = new Attribute[Fieldset, scala.Option[String], String](nodeRef, "disabled")
    val form = new Attribute[Fieldset, scala.Option[String], String](nodeRef, "form")
    val name = new Attribute[Fieldset, scala.Option[String], String](nodeRef, "name")
  }

  implicit class NodeRefAttributesForm(nodeRef: NodeRef[Form]) {
    val accept = new Attribute[Form, scala.Option[String], String](nodeRef, "accept")
    val `accept-charset` = new Attribute[Form, scala.Option[String], String](nodeRef, "accept-charset")
    val action = new Attribute[Form, scala.Option[String], String](nodeRef, "action")
    val autocapitalize = new Attribute[Form, scala.Option[String], String](nodeRef, "autocapitalize")
    val autocomplete = new Attribute[Form, scala.Option[String], String](nodeRef, "autocomplete")
    val enctype = new Attribute[Form, scala.Option[String], String](nodeRef, "enctype")
    val method = new Attribute[Form, scala.Option[String], String](nodeRef, "method")
    val name = new Attribute[Form, scala.Option[String], String](nodeRef, "name")
    val novalidate = new Attribute[Form, scala.Option[String], String](nodeRef, "novalidate")
    val target = new Attribute[Form, scala.Option[String], String](nodeRef, "target")
  }

  implicit class NodeRefAttributesFrame(nodeRef: NodeRef[Frame]) {
    val src = new Attribute[Frame, scala.Option[String], String](nodeRef, "src")
    val name = new Attribute[Frame, scala.Option[String], String](nodeRef, "name")
    val noresize = new Attribute[Frame, scala.Option[String], String](nodeRef, "noresize")
    val scrolling = new Attribute[Frame, scala.Option[String], String](nodeRef, "scrolling")
    val marginheight = new Attribute[Frame, scala.Option[String], String](nodeRef, "marginheight")
    val marginwidth = new Attribute[Frame, scala.Option[String], String](nodeRef, "marginwidth")
    val frameborder = new Attribute[Frame, scala.Option[String], String](nodeRef, "frameborder")
  }

  implicit class NodeRefAttributesFrameset(nodeRef: NodeRef[Frameset]) {
    val cols = new Attribute[Frameset, scala.Option[String], String](nodeRef, "cols")
    val rows = new Attribute[Frameset, scala.Option[String], String](nodeRef, "rows")
  }

  implicit class NodeRefAttributesHead(nodeRef: NodeRef[Head]) {
    val profile = new Attribute[Head, scala.Option[String], String](nodeRef, "profile")
  }

  implicit class NodeRefAttributesHr(nodeRef: NodeRef[Hr]) {
    val align = new Attribute[Hr, scala.Option[String], String](nodeRef, "align")
    val color = new Attribute[Hr, scala.Option[String], String](nodeRef, "color")
    val noshade = new Attribute[Hr, Boolean, Boolean](nodeRef, "noshade")
    val size = new Attribute[Hr, scala.Option[String], String](nodeRef, "size")
    val width = new Attribute[Hr, scala.Option[String], String](nodeRef, "width")
  }

  implicit class NodeRefAttributesHtml(nodeRef: NodeRef[Html]) {
    val manifest = new Attribute[Html, scala.Option[String], String](nodeRef, "manifest")
    val version = new Attribute[Html, scala.Option[String], String](nodeRef, "version")
    val xmlns = new Attribute[Html, scala.Option[String], String](nodeRef, "xmlns")
  }

  implicit class NodeRefAttributesIframe(nodeRef: NodeRef[Iframe]) {
    val align = new Attribute[Iframe, scala.Option[String], String](nodeRef, "align")
    val allowfullscreen = new Attribute[Iframe, scala.Option[String], String](nodeRef, "allowfullscreen")
    val frameborder = new Attribute[Iframe, scala.Option[String], String](nodeRef, "frameborder")
    val height = new Attribute[Iframe, scala.Option[String], String](nodeRef, "height")
    val longdesc = new Attribute[Iframe, scala.Option[String], String](nodeRef, "longdesc")
    val marginheight = new Attribute[Iframe, scala.Option[String], String](nodeRef, "marginheight")
    val marginwidth = new Attribute[Iframe, scala.Option[String], String](nodeRef, "marginwidth")
    val mozallowfullscreen = new Attribute[Iframe, scala.Option[String], String](nodeRef, "mozallowfullscreen")
    val webkitallowfullscreen = new Attribute[Iframe, scala.Option[String], String](nodeRef, "webkitallowfullscreen")
    val mozapp = new Attribute[Iframe, scala.Option[String], String](nodeRef, "mozapp")
    val mozbrowser = new Attribute[Iframe, scala.Option[String], String](nodeRef, "mozbrowser")
    val name = new Attribute[Iframe, scala.Option[String], String](nodeRef, "name")
    val remote = new Attribute[Iframe, scala.Option[String], String](nodeRef, "remote")
    val scrolling = new Attribute[Iframe, scala.Option[String], String](nodeRef, "scrolling")
    val sandbox = new Attribute[Iframe, scala.Option[String], String](nodeRef, "sandbox")
    val seamless = new Attribute[Iframe, scala.Option[String], String](nodeRef, "seamless")
    val src = new Attribute[Iframe, scala.Option[String], String](nodeRef, "src")
    val srcdoc = new Attribute[Iframe, scala.Option[String], String](nodeRef, "srcdoc")
    val width = new Attribute[Iframe, scala.Option[String], String](nodeRef, "width")
  }

  implicit class NodeRefAttributesImg(nodeRef: NodeRef[Img]) {
    val `align vertical-align` = new Attribute[Img, scala.Option[String], String](nodeRef, "align vertical-align")
    val alt = new Attribute[Img, scala.Option[String], String](nodeRef, "alt")
    val border = new Attribute[Img, scala.Option[String], String](nodeRef, "border")
    val crossorigin = new Attribute[Img, scala.Option[String], String](nodeRef, "crossorigin")
    val height = new Attribute[Img, scala.Option[String], String](nodeRef, "height")
    val hspace = new Attribute[Img, scala.Option[String], String](nodeRef, "hspace")
    val ismap = new Attribute[Img, scala.Option[String], String](nodeRef, "ismap")
    val longdesc = new Attribute[Img, scala.Option[String], String](nodeRef, "longdesc")
    val name = new Attribute[Img, scala.Option[String], String](nodeRef, "name")
    val sizes = new Attribute[Img, scala.Option[String], String](nodeRef, "sizes")
    val src = new Attribute[Img, scala.Option[String], String](nodeRef, "src")
    val srcset = new Attribute[Img, scala.Option[String], String](nodeRef, "srcset")
    val width = new Attribute[Img, scala.Option[String], String](nodeRef, "width")
    val usemap = new Attribute[Img, scala.Option[String], String](nodeRef, "usemap")
    val vspace = new Attribute[Img, scala.Option[String], String](nodeRef, "vspace")
  }

  implicit class NodeRefAttributesInput(nodeRef: NodeRef[Input]) {
    val `type` = new Attribute[Input, scala.Option[String], String](nodeRef, "type")
    val accept = new Attribute[Input, scala.Option[String], String](nodeRef, "accept")
    val accesskey = new Attribute[Input, scala.Option[String], String](nodeRef, "accesskey")
    val mozactionhint = new Attribute[Input, scala.Option[String], String](nodeRef, "mozactionhint")
    val autocapitalize = new Attribute[Input, scala.Option[String], String](nodeRef, "autocapitalize")
    val autocomplete = new Attribute[Input, scala.Option[String], String](nodeRef, "autocomplete")
    val autocorrect = new Attribute[Input, scala.Option[String], String](nodeRef, "autocorrect")
    val autofocus = new Attribute[Input, Boolean, Boolean](nodeRef, "autofocus")
    val autosave = new Attribute[Input, scala.Option[String], String](nodeRef, "autosave")
    val checked = new Attribute[Input, Boolean, Boolean](nodeRef, "checked")
    val disabled = new Attribute[Input, Boolean, Boolean](nodeRef, "disabled")
    val form = new Attribute[Input, scala.Option[String], String](nodeRef, "form")
    val formaction = new Attribute[Input, scala.Option[String], String](nodeRef, "formaction")
    val formenctype = new Attribute[Input, scala.Option[String], String](nodeRef, "formenctype")
    val formmethod = new Attribute[Input, scala.Option[String], String](nodeRef, "formmethod")
    val formnovalidate = new Attribute[Input, scala.Option[String], String](nodeRef, "formnovalidate")
    val formtarget = new Attribute[Input, scala.Option[String], String](nodeRef, "formtarget")
    val height = new Attribute[Input, scala.Option[String], String](nodeRef, "height")
    val incremental = new Attribute[Input, scala.Option[String], String](nodeRef, "incremental")
    val inputmode = new Attribute[Input, scala.Option[String], String](nodeRef, "inputmode")
    val list = new Attribute[Input, scala.Option[String], String](nodeRef, "list")
    val max = new Attribute[Input, scala.Option[String], String](nodeRef, "max")
    val maxlength = new Attribute[Input, scala.Option[String], String](nodeRef, "maxlength")
    val min = new Attribute[Input, scala.Option[String], String](nodeRef, "min")
    val minlength = new Attribute[Input, scala.Option[String], String](nodeRef, "minlength")
    val multiple = new Attribute[Input, scala.Option[String], String](nodeRef, "multiple")
    val name = new Attribute[Input, scala.Option[String], String](nodeRef, "name")
    val pattern = new Attribute[Input, scala.Option[String], String](nodeRef, "pattern")
    val placeholder = new Attribute[Input, scala.Option[String], String](nodeRef, "placeholder")
    val readonly = new Attribute[Input, scala.Option[String], String](nodeRef, "readonly")
    val required = new Attribute[Input, Boolean, Boolean](nodeRef, "required")
    val results = new Attribute[Input, scala.Option[String], String](nodeRef, "results")
    val selectionDirection = new Attribute[Input, scala.Option[String], String](nodeRef, "selectionDirection")
    val size = new Attribute[Input, scala.Option[Long], Long](nodeRef, "size")
    val spellcheck = new Attribute[Input, scala.Option[String], String](nodeRef, "spellcheck")
    val src = new Attribute[Input, scala.Option[String], String](nodeRef, "src")
    val step = new Attribute[Input, scala.Option[String], String](nodeRef, "step")
    val tabindex = new Attribute[Input, scala.Option[String], String](nodeRef, "tabindex")
    val usemap = new Attribute[Input, scala.Option[String], String](nodeRef, "usemap")
    val value = new Attribute[Input, scala.Option[String], String](nodeRef, "value")
    val width = new Attribute[Input, scala.Option[String], String](nodeRef, "width")
    val `x-moz-errormessage` = new Attribute[Input, scala.Option[String], String](nodeRef, "x-moz-errormessage")
  }

  implicit class NodeRefAttributesIns(nodeRef: NodeRef[Ins]) {
    val cite = new Attribute[Ins, scala.Option[String], String](nodeRef, "cite")
    val datetime = new Attribute[Ins, scala.Option[String], String](nodeRef, "datetime")
  }

  implicit class NodeRefAttributesIsindex(nodeRef: NodeRef[Isindex]) {
    val prompt = new Attribute[Isindex, scala.Option[String], String](nodeRef, "prompt")
    val action = new Attribute[Isindex, scala.Option[String], String](nodeRef, "action")
  }

  implicit class NodeRefAttributesKeygen(nodeRef: NodeRef[Keygen]) {
    val autofocus = new Attribute[Keygen, scala.Option[String], String](nodeRef, "autofocus")
    val challenge = new Attribute[Keygen, scala.Option[String], String](nodeRef, "challenge")
    val disabled = new Attribute[Keygen, scala.Option[String], String](nodeRef, "disabled")
    val form = new Attribute[Keygen, scala.Option[String], String](nodeRef, "form")
    val keytype = new Attribute[Keygen, scala.Option[String], String](nodeRef, "keytype")
    val name = new Attribute[Keygen, scala.Option[String], String](nodeRef, "name")
  }

  implicit class NodeRefAttributesLabel(nodeRef: NodeRef[Label]) {
    val accesskey = new Attribute[Label, scala.Option[String], String](nodeRef, "accesskey")
    val `for` = new Attribute[Label, scala.Option[String], String](nodeRef, "for")
    val form = new Attribute[Label, scala.Option[String], String](nodeRef, "form")
  }

  implicit class NodeRefAttributesLi(nodeRef: NodeRef[Li]) {
    val value = new Attribute[Li, scala.Option[Long], Long](nodeRef, "value")
    val `type` = new Attribute[Li, scala.Option[String], String](nodeRef, "type")
  }

  implicit class NodeRefAttributesLink(nodeRef: NodeRef[Link]) {
    val charset = new Attribute[Link, scala.Option[String], String](nodeRef, "charset")
    val crossorigin = new Attribute[Link, scala.Option[String], String](nodeRef, "crossorigin")
    val disabled = new Attribute[Link, scala.Option[String], String](nodeRef, "disabled")
    val href = new Attribute[Link, scala.Option[String], String](nodeRef, "href")
    val hreflang = new Attribute[Link, scala.Option[String], String](nodeRef, "hreflang")
    val media = new Attribute[Link, scala.Option[String], String](nodeRef, "media")
    val methods = new Attribute[Link, scala.Option[String], String](nodeRef, "methods")
    val rel = new Attribute[Link, scala.Option[String], String](nodeRef, "rel")
    val rev = new Attribute[Link, scala.Option[String], String](nodeRef, "rev")
    val sizes = new Attribute[Link, scala.Option[String], String](nodeRef, "sizes")
    val target = new Attribute[Link, scala.Option[String], String](nodeRef, "target")
    val `type` = new Attribute[Link, scala.Option[String], String](nodeRef, "type")
    val integrity = new Attribute[Link, scala.Option[String], String](nodeRef, "integrity")
  }

  implicit class NodeRefAttributesMap(nodeRef: NodeRef[Map]) {
    val name = new Attribute[Map, scala.Option[String], String](nodeRef, "name")
  }

  implicit class NodeRefAttributesMenu(nodeRef: NodeRef[Menu]) {
    val label = new Attribute[Menu, scala.Option[String], String](nodeRef, "label")
    val `type` = new Attribute[Menu, scala.Option[String], String](nodeRef, "type")
  }

  implicit class NodeRefAttributesMenuitem(nodeRef: NodeRef[Menuitem]) {
    val checked = new Attribute[Menuitem, scala.Option[String], String](nodeRef, "checked")
    val command = new Attribute[Menuitem, scala.Option[String], String](nodeRef, "command")
    val default = new Attribute[Menuitem, scala.Option[String], String](nodeRef, "default")
    val disabled = new Attribute[Menuitem, scala.Option[String], String](nodeRef, "disabled")
    val icon = new Attribute[Menuitem, scala.Option[String], String](nodeRef, "icon")
    val label = new Attribute[Menuitem, scala.Option[String], String](nodeRef, "label")
    val radiogroup = new Attribute[Menuitem, scala.Option[String], String](nodeRef, "radiogroup")
    val `type` = new Attribute[Menuitem, scala.Option[String], String](nodeRef, "type")
  }

  implicit class NodeRefAttributesMeta(nodeRef: NodeRef[Meta]) {
    val charset = new Attribute[Meta, scala.Option[String], String](nodeRef, "charset")
    val content = new Attribute[Meta, scala.Option[String], String](nodeRef, "content")
    val `http-equiv` = new Attribute[Meta, scala.Option[String], String](nodeRef, "http-equiv")
    val name = new Attribute[Meta, scala.Option[String], String](nodeRef, "name")
    val scheme = new Attribute[Meta, scala.Option[String], String](nodeRef, "scheme")
  }

  implicit class NodeRefAttributesMeter(nodeRef: NodeRef[Meter]) {
    val value = new Attribute[Meter, scala.Option[String], String](nodeRef, "value")
    val min = new Attribute[Meter, scala.Option[Double], Double](nodeRef, "min")
    val max = new Attribute[Meter, scala.Option[Double], Double](nodeRef, "max")
    val low = new Attribute[Meter, scala.Option[Double], Double](nodeRef, "low")
    val high = new Attribute[Meter, scala.Option[Double], Double](nodeRef, "high")
    val optimum = new Attribute[Meter, scala.Option[Double], Double](nodeRef, "optimum")
    val form = new Attribute[Meter, scala.Option[String], String](nodeRef, "form")
  }

  implicit class NodeRefAttributesObject(nodeRef: NodeRef[Object]) {
    val archive = new Attribute[Object, scala.Option[String], String](nodeRef, "archive")
    val border = new Attribute[Object, scala.Option[String], String](nodeRef, "border")
    val classid = new Attribute[Object, scala.Option[String], String](nodeRef, "classid")
    val codebase = new Attribute[Object, scala.Option[String], String](nodeRef, "codebase")
    val codetype = new Attribute[Object, scala.Option[String], String](nodeRef, "codetype")
    val data = new Attribute[Object, scala.Option[String], String](nodeRef, "data")
    val declare = new Attribute[Object, scala.Option[String], String](nodeRef, "declare")
    val form = new Attribute[Object, scala.Option[String], String](nodeRef, "form")
    val height = new Attribute[Object, scala.Option[String], String](nodeRef, "height")
    val name = new Attribute[Object, scala.Option[String], String](nodeRef, "name")
    val standby = new Attribute[Object, scala.Option[String], String](nodeRef, "standby")
    val tabindex = new Attribute[Object, scala.Option[String], String](nodeRef, "tabindex")
    val `type` = new Attribute[Object, scala.Option[String], String](nodeRef, "type")
    val typemustmatch = new Attribute[Object, scala.Option[String], String](nodeRef, "typemustmatch")
    val usemap = new Attribute[Object, scala.Option[String], String](nodeRef, "usemap")
    val width = new Attribute[Object, scala.Option[String], String](nodeRef, "width")
  }

  implicit class NodeRefAttributesOl(nodeRef: NodeRef[Ol]) {
    val compact = new Attribute[Ol, scala.Option[String], String](nodeRef, "compact")
    val reversed = new Attribute[Ol, scala.Option[String], String](nodeRef, "reversed")
    val start = new Attribute[Ol, scala.Option[String], String](nodeRef, "start")
    val `type` = new Attribute[Ol, scala.Option[String], String](nodeRef, "type")
  }

  implicit class NodeRefAttributesOptgroup(nodeRef: NodeRef[Optgroup]) {
    val disabled = new Attribute[Optgroup, Boolean, Boolean](nodeRef, "disabled")
    val label = new Attribute[Optgroup, scala.Option[String], String](nodeRef, "label")
  }

  implicit class NodeRefAttributesOption(nodeRef: NodeRef[Option]) {
    val disabled = new Attribute[Option, scala.Option[String], String](nodeRef, "disabled")
    val label = new Attribute[Option, scala.Option[String], String](nodeRef, "label")
    val selected = new Attribute[Option, scala.Option[String], String](nodeRef, "selected")
    val value = new Attribute[Option, scala.Option[String], String](nodeRef, "value")
  }

  implicit class NodeRefAttributesOutput(nodeRef: NodeRef[Output]) {
    val `for` = new Attribute[Output, scala.Option[String], String](nodeRef, "for")
    val form = new Attribute[Output, scala.Option[String], String](nodeRef, "form")
    val name = new Attribute[Output, scala.Option[String], String](nodeRef, "name")
  }

  implicit class NodeRefAttributesParam(nodeRef: NodeRef[Param]) {
    val name = new Attribute[Param, scala.Option[String], String](nodeRef, "name")
    val `type` = new Attribute[Param, scala.Option[String], String](nodeRef, "type")
    val value = new Attribute[Param, scala.Option[String], String](nodeRef, "value")
    val valuetype = new Attribute[Param, scala.Option[String], String](nodeRef, "valuetype")
  }

  implicit class NodeRefAttributesPre(nodeRef: NodeRef[Pre]) {
    val cols = new Attribute[Pre, scala.Option[String], String](nodeRef, "cols")
    val width = new Attribute[Pre, scala.Option[String], String](nodeRef, "width")
    val wrap = new Attribute[Pre, scala.Option[String], String](nodeRef, "wrap")
  }

  implicit class NodeRefAttributesProgress(nodeRef: NodeRef[Progress]) {
    val max = new Attribute[Progress, scala.Option[String], String](nodeRef, "max")
    val value = new Attribute[Progress, scala.Option[String], String](nodeRef, "value")
  }

  implicit class NodeRefAttributesScript(nodeRef: NodeRef[Script]) {
    val async = new Attribute[Script, scala.Option[String], String](nodeRef, "async")
    val src = new Attribute[Script, scala.Option[String], String](nodeRef, "src")
    val `type` = new Attribute[Script, scala.Option[String], String](nodeRef, "type")
    val language = new Attribute[Script, scala.Option[String], String](nodeRef, "language")
    val defer = new Attribute[Script, scala.Option[String], String](nodeRef, "defer")
    val crossorigin = new Attribute[Script, scala.Option[String], String](nodeRef, "crossorigin")
    val integrity = new Attribute[Script, scala.Option[String], String](nodeRef, "integrity")
  }

  implicit class NodeRefAttributesSelect(nodeRef: NodeRef[Select]) {
    val autofocus = new Attribute[Select, scala.Option[String], String](nodeRef, "autofocus")
    val disabled = new Attribute[Select, scala.Option[String], String](nodeRef, "disabled")
    val form = new Attribute[Select, scala.Option[String], String](nodeRef, "form")
    val multiple = new Attribute[Select, scala.Option[String], String](nodeRef, "multiple")
    val name = new Attribute[Select, scala.Option[String], String](nodeRef, "name")
    val required = new Attribute[Select, scala.Option[String], String](nodeRef, "required")
    val size = new Attribute[Select, scala.Option[String], String](nodeRef, "size")
  }

  implicit class NodeRefAttributesSource(nodeRef: NodeRef[Source]) {
    val sizes = new Attribute[Source, scala.Option[String], String](nodeRef, "sizes")
    val src = new Attribute[Source, scala.Option[String], String](nodeRef, "src")
    val srcset = new Attribute[Source, scala.Option[String], String](nodeRef, "srcset")
    val `type` = new Attribute[Source, scala.Option[String], String](nodeRef, "type")
    val media = new Attribute[Source, scala.Option[String], String](nodeRef, "media")
  }

  implicit class NodeRefAttributesSpacer(nodeRef: NodeRef[Spacer]) {
    val `type` = new Attribute[Spacer, scala.Option[String], String](nodeRef, "type")
    val size = new Attribute[Spacer, scala.Option[String], String](nodeRef, "size")
    val width = new Attribute[Spacer, scala.Option[String], String](nodeRef, "width")
    val height = new Attribute[Spacer, scala.Option[String], String](nodeRef, "height")
    val align = new Attribute[Spacer, scala.Option[String], String](nodeRef, "align")
  }

  implicit class NodeRefAttributesStyle(nodeRef: NodeRef[Style]) {
    val `type` = new Attribute[Style, scala.Option[String], String](nodeRef, "type")
    val media = new Attribute[Style, scala.Option[String], String](nodeRef, "media")
    val scoped = new Attribute[Style, scala.Option[String], String](nodeRef, "scoped")
    val title = new Attribute[Style, scala.Option[String], String](nodeRef, "title")
    val disabled = new Attribute[Style, scala.Option[String], String](nodeRef, "disabled")
  }

  implicit class NodeRefAttributesTable(nodeRef: NodeRef[Table]) {
    val align = new Attribute[Table, scala.Option[String], String](nodeRef, "align")
    val bgcolor = new Attribute[Table, scala.Option[String], String](nodeRef, "bgcolor")
    val border = new Attribute[Table, scala.Option[String], String](nodeRef, "border")
    val cellpadding = new Attribute[Table, scala.Option[String], String](nodeRef, "cellpadding")
    val cellspacing = new Attribute[Table, scala.Option[String], String](nodeRef, "cellspacing")
    val frame = new Attribute[Table, scala.Option[String], String](nodeRef, "frame")
    val rules = new Attribute[Table, scala.Option[String], String](nodeRef, "rules")
    val summary = new Attribute[Table, scala.Option[String], String](nodeRef, "summary")
    val width = new Attribute[Table, scala.Option[String], String](nodeRef, "width")
  }

  implicit class NodeRefAttributesTbody(nodeRef: NodeRef[Tbody]) {
    val align = new Attribute[Tbody, scala.Option[String], String](nodeRef, "align")
    val bgcolor = new Attribute[Tbody, scala.Option[String], String](nodeRef, "bgcolor")
    val char = new Attribute[Tbody, scala.Option[String], String](nodeRef, "char")
    val charoff = new Attribute[Tbody, scala.Option[String], String](nodeRef, "charoff")
    val valign = new Attribute[Tbody, scala.Option[String], String](nodeRef, "valign")
  }

  implicit class NodeRefAttributesTd(nodeRef: NodeRef[Td]) {
    val abbr = new Attribute[Td, scala.Option[String], String](nodeRef, "abbr")
    val align = new Attribute[Td, scala.Option[String], String](nodeRef, "align")
    val axis = new Attribute[Td, scala.Option[String], String](nodeRef, "axis")
    val bgcolor = new Attribute[Td, scala.Option[String], String](nodeRef, "bgcolor")
    val char = new Attribute[Td, scala.Option[String], String](nodeRef, "char")
    val charoff = new Attribute[Td, scala.Option[String], String](nodeRef, "charoff")
    val colspan = new Attribute[Td, scala.Option[String], String](nodeRef, "colspan")
    val headers = new Attribute[Td, scala.Option[String], String](nodeRef, "headers")
    val rowspan = new Attribute[Td, scala.Option[String], String](nodeRef, "rowspan")
    val scope = new Attribute[Td, scala.Option[String], String](nodeRef, "scope")
    val valign = new Attribute[Td, scala.Option[String], String](nodeRef, "valign")
    val width = new Attribute[Td, scala.Option[String], String](nodeRef, "width")
  }

  implicit class NodeRefAttributesTextarea(nodeRef: NodeRef[Textarea]) {
    val autocapitalize = new Attribute[Textarea, scala.Option[String], String](nodeRef, "autocapitalize")
    val autocomplete = new Attribute[Textarea, scala.Option[String], String](nodeRef, "autocomplete")
    val autofocus = new Attribute[Textarea, scala.Option[String], String](nodeRef, "autofocus")
    val cols = new Attribute[Textarea, scala.Option[String], String](nodeRef, "cols")
    val disabled = new Attribute[Textarea, scala.Option[String], String](nodeRef, "disabled")
    val form = new Attribute[Textarea, scala.Option[String], String](nodeRef, "form")
    val maxlength = new Attribute[Textarea, scala.Option[String], String](nodeRef, "maxlength")
    val minlength = new Attribute[Textarea, scala.Option[String], String](nodeRef, "minlength")
    val name = new Attribute[Textarea, scala.Option[String], String](nodeRef, "name")
    val placeholder = new Attribute[Textarea, scala.Option[String], String](nodeRef, "placeholder")
    val readonly = new Attribute[Textarea, scala.Option[String], String](nodeRef, "readonly")
    val required = new Attribute[Textarea, scala.Option[String], String](nodeRef, "required")
    val rows = new Attribute[Textarea, scala.Option[String], String](nodeRef, "rows")
    val selectionDirection = new Attribute[Textarea, scala.Option[String], String](nodeRef, "selectionDirection")
    val selectionEnd = new Attribute[Textarea, scala.Option[String], String](nodeRef, "selectionEnd")
    val selectionStart = new Attribute[Textarea, scala.Option[String], String](nodeRef, "selectionStart")
    val spellcheck = new Attribute[Textarea, scala.Option[String], String](nodeRef, "spellcheck")
    val wrap = new Attribute[Textarea, scala.Option[String], String](nodeRef, "wrap")
  }

  implicit class NodeRefAttributesTfoot(nodeRef: NodeRef[Tfoot]) {
    val align = new Attribute[Tfoot, scala.Option[String], String](nodeRef, "align")
    val bgcolor = new Attribute[Tfoot, scala.Option[String], String](nodeRef, "bgcolor")
    val char = new Attribute[Tfoot, scala.Option[String], String](nodeRef, "char")
    val charoff = new Attribute[Tfoot, scala.Option[String], String](nodeRef, "charoff")
    val valign = new Attribute[Tfoot, scala.Option[String], String](nodeRef, "valign")
  }

  implicit class NodeRefAttributesTh(nodeRef: NodeRef[Th]) {
    val abbr = new Attribute[Th, scala.Option[String], String](nodeRef, "abbr")
    val align = new Attribute[Th, scala.Option[String], String](nodeRef, "align")
    val axis = new Attribute[Th, scala.Option[String], String](nodeRef, "axis")
    val bgcolor = new Attribute[Th, scala.Option[String], String](nodeRef, "bgcolor")
    val char = new Attribute[Th, scala.Option[String], String](nodeRef, "char")
    val charoff = new Attribute[Th, scala.Option[String], String](nodeRef, "charoff")
    val colspan = new Attribute[Th, scala.Option[String], String](nodeRef, "colspan")
    val headers = new Attribute[Th, scala.Option[String], String](nodeRef, "headers")
    val rowspan = new Attribute[Th, scala.Option[String], String](nodeRef, "rowspan")
    val scope = new Attribute[Th, scala.Option[String], String](nodeRef, "scope")
    val valign = new Attribute[Th, scala.Option[String], String](nodeRef, "valign")
    val width = new Attribute[Th, scala.Option[String], String](nodeRef, "width")
  }

  implicit class NodeRefAttributesThead(nodeRef: NodeRef[Thead]) {
    val align = new Attribute[Thead, scala.Option[String], String](nodeRef, "align")
    val bgcolor = new Attribute[Thead, scala.Option[String], String](nodeRef, "bgcolor")
    val char = new Attribute[Thead, scala.Option[String], String](nodeRef, "char")
    val charoff = new Attribute[Thead, scala.Option[String], String](nodeRef, "charoff")
    val valign = new Attribute[Thead, scala.Option[String], String](nodeRef, "valign")
  }

  implicit class NodeRefAttributesTr(nodeRef: NodeRef[Tr]) {
    val align = new Attribute[Tr, scala.Option[String], String](nodeRef, "align")
    val bgcolor = new Attribute[Tr, scala.Option[String], String](nodeRef, "bgcolor")
    val char = new Attribute[Tr, scala.Option[String], String](nodeRef, "char")
    val charoff = new Attribute[Tr, scala.Option[String], String](nodeRef, "charoff")
    val valign = new Attribute[Tr, scala.Option[String], String](nodeRef, "valign")
  }

  implicit class NodeRefAttributesTrack(nodeRef: NodeRef[Track]) {
    val default = new Attribute[Track, scala.Option[String], String](nodeRef, "default")
    val kind = new Attribute[Track, scala.Option[String], String](nodeRef, "kind")
    val label = new Attribute[Track, scala.Option[String], String](nodeRef, "label")
    val src = new Attribute[Track, scala.Option[String], String](nodeRef, "src")
    val srclang = new Attribute[Track, scala.Option[String], String](nodeRef, "srclang")
  }

  implicit class NodeRefAttributesUl(nodeRef: NodeRef[Ul]) {
    val compact = new Attribute[Ul, scala.Option[String], String](nodeRef, "compact")
    val `type` = new Attribute[Ul, scala.Option[String], String](nodeRef, "type")
  }

  implicit class NodeRefAttributesVideo(nodeRef: NodeRef[Video]) {
    val autoplay = new Attribute[Video, scala.Option[String], String](nodeRef, "autoplay")
    val autobuffer = new Attribute[Video, scala.Option[String], String](nodeRef, "autobuffer")
    val buffered = new Attribute[Video, scala.Option[String], String](nodeRef, "buffered")
    val controls = new Attribute[Video, scala.Option[String], String](nodeRef, "controls")
    val crossorigin = new Attribute[Video, scala.Option[String], String](nodeRef, "crossorigin")
    val height = new Attribute[Video, scala.Option[String], String](nodeRef, "height")
    val loop = new Attribute[Video, scala.Option[String], String](nodeRef, "loop")
    val muted = new Attribute[Video, scala.Option[String], String](nodeRef, "muted")
    val played = new Attribute[Video, scala.Option[String], String](nodeRef, "played")
    val preload = new Attribute[Video, scala.Option[String], String](nodeRef, "preload")
    val poster = new Attribute[Video, scala.Option[String], String](nodeRef, "poster")
    val src = new Attribute[Video, scala.Option[String], String](nodeRef, "src")
    val width = new Attribute[Video, scala.Option[String], String](nodeRef, "width")
  }

}
