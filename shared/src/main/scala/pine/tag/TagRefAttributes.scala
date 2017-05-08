package pine.tag

import pine._

trait TagRefAttributes {
  implicit class TagRefAttributesHTMLTag(tagRef: TagRef[HTMLTag]) {
    val accesskey = new Attribute[HTMLTag, scala.Option[String], String](tagRef, "accesskey")
    val `class` = new Attribute[HTMLTag, scala.Option[String], String](tagRef, "class")
    val contenteditable = new Attribute[HTMLTag, scala.Option[String], String](tagRef, "contenteditable")
    val contextmenu = new Attribute[HTMLTag, scala.Option[String], String](tagRef, "contextmenu")
    val dir = new Attribute[HTMLTag, scala.Option[String], String](tagRef, "dir")
    val draggable = new Attribute[HTMLTag, scala.Option[String], String](tagRef, "draggable")
    val dropzone = new Attribute[HTMLTag, scala.Option[String], String](tagRef, "dropzone")
    val hidden = new Attribute[HTMLTag, scala.Option[String], String](tagRef, "hidden")
    val id = new Attribute[HTMLTag, scala.Option[String], String](tagRef, "id")
    val itemid = new Attribute[HTMLTag, scala.Option[String], String](tagRef, "itemid")
    val itemprop = new Attribute[HTMLTag, scala.Option[String], String](tagRef, "itemprop")
    val itemref = new Attribute[HTMLTag, scala.Option[String], String](tagRef, "itemref")
    val itemscope = new Attribute[HTMLTag, scala.Option[String], String](tagRef, "itemscope")
    val itemtype = new Attribute[HTMLTag, scala.Option[String], String](tagRef, "itemtype")
    val lang = new Attribute[HTMLTag, scala.Option[String], String](tagRef, "lang")
    val spellcheck = new Attribute[HTMLTag, scala.Option[String], String](tagRef, "spellcheck")
    val style = new Attribute[HTMLTag, scala.Option[String], String](tagRef, "style")
    val tabindex = new Attribute[HTMLTag, scala.Option[String], String](tagRef, "tabindex")
    val title = new Attribute[HTMLTag, scala.Option[String], String](tagRef, "title")
    val translate = new Attribute[HTMLTag, scala.Option[String], String](tagRef, "translate")
  }

  implicit class TagRefAttributesA(tagRef: TagRef[A]) {
    val download = new Attribute[A, scala.Option[String], String](tagRef, "download")
    val href = new Attribute[A, scala.Option[String], String](tagRef, "href")
    val hreflang = new Attribute[A, scala.Option[String], String](tagRef, "hreflang")
    val media = new Attribute[A, scala.Option[String], String](tagRef, "media")
    val ping = new Attribute[A, scala.Option[String], String](tagRef, "ping")
    val rel = new Attribute[A, scala.Option[String], String](tagRef, "rel")
    val target = new Attribute[A, scala.Option[String], String](tagRef, "target")
    val `type` = new Attribute[A, scala.Option[String], String](tagRef, "type")
    val charset = new Attribute[A, scala.Option[String], String](tagRef, "charset")
    val coords = new Attribute[A, scala.Option[String], String](tagRef, "coords")
    val name = new Attribute[A, scala.Option[String], String](tagRef, "name")
    val rev = new Attribute[A, scala.Option[String], String](tagRef, "rev")
    val shape = new Attribute[A, scala.Option[String], String](tagRef, "shape")
    val datafld = new Attribute[A, scala.Option[String], String](tagRef, "datafld")
    val datasrc = new Attribute[A, scala.Option[String], String](tagRef, "datasrc")
    val methods = new Attribute[A, scala.Option[String], String](tagRef, "methods")
    val urn = new Attribute[A, scala.Option[String], String](tagRef, "urn")
  }

  implicit class TagRefAttributesApplet(tagRef: TagRef[Applet]) {
    val align = new Attribute[Applet, scala.Option[String], String](tagRef, "align")
    val alt = new Attribute[Applet, scala.Option[String], String](tagRef, "alt")
    val archive = new Attribute[Applet, scala.Option[String], String](tagRef, "archive")
    val code = new Attribute[Applet, scala.Option[String], String](tagRef, "code")
    val codebase = new Attribute[Applet, scala.Option[String], String](tagRef, "codebase")
    val datafld = new Attribute[Applet, scala.Option[String], String](tagRef, "datafld")
    val datasrc = new Attribute[Applet, scala.Option[String], String](tagRef, "datasrc")
    val height = new Attribute[Applet, scala.Option[String], String](tagRef, "height")
    val hspace = new Attribute[Applet, scala.Option[String], String](tagRef, "hspace")
    val mayscript = new Attribute[Applet, scala.Option[String], String](tagRef, "mayscript")
    val name = new Attribute[Applet, scala.Option[String], String](tagRef, "name")
    val `object` = new Attribute[Applet, scala.Option[String], String](tagRef, "object")
    val src = new Attribute[Applet, scala.Option[String], String](tagRef, "src")
    val vspace = new Attribute[Applet, scala.Option[String], String](tagRef, "vspace")
    val width = new Attribute[Applet, scala.Option[String], String](tagRef, "width")
  }

  implicit class TagRefAttributesArea(tagRef: TagRef[Area]) {
    val accesskey = new Attribute[Area, scala.Option[String], String](tagRef, "accesskey")
    val alt = new Attribute[Area, scala.Option[String], String](tagRef, "alt")
    val coords = new Attribute[Area, scala.Option[String], String](tagRef, "coords")
    val download = new Attribute[Area, scala.Option[String], String](tagRef, "download")
    val href = new Attribute[Area, scala.Option[String], String](tagRef, "href")
    val hreflang = new Attribute[Area, scala.Option[String], String](tagRef, "hreflang")
    val name = new Attribute[Area, scala.Option[String], String](tagRef, "name")
    val media = new Attribute[Area, scala.Option[String], String](tagRef, "media")
    val nohref = new Attribute[Area, scala.Option[String], String](tagRef, "nohref")
    val rel = new Attribute[Area, scala.Option[String], String](tagRef, "rel")
    val shape = new Attribute[Area, scala.Option[String], String](tagRef, "shape")
    val tabindex = new Attribute[Area, scala.Option[String], String](tagRef, "tabindex")
    val target = new Attribute[Area, scala.Option[String], String](tagRef, "target")
    val `type` = new Attribute[Area, scala.Option[String], String](tagRef, "type")
  }

  implicit class TagRefAttributesAudio(tagRef: TagRef[Audio]) {
    val autoplay = new Attribute[Audio, scala.Option[String], String](tagRef, "autoplay")
    val autobuffer = new Attribute[Audio, scala.Option[String], String](tagRef, "autobuffer")
    val buffered = new Attribute[Audio, scala.Option[String], String](tagRef, "buffered")
    val controls = new Attribute[Audio, scala.Option[String], String](tagRef, "controls")
    val loop = new Attribute[Audio, scala.Option[String], String](tagRef, "loop")
    val mozCurrentSampleOffset = new Attribute[Audio, scala.Option[String], String](tagRef, "mozCurrentSampleOffset")
    val muted = new Attribute[Audio, scala.Option[String], String](tagRef, "muted")
    val played = new Attribute[Audio, scala.Option[String], String](tagRef, "played")
    val preload = new Attribute[Audio, scala.Option[String], String](tagRef, "preload")
    val src = new Attribute[Audio, scala.Option[String], String](tagRef, "src")
    val volume = new Attribute[Audio, scala.Option[String], String](tagRef, "volume")
  }

  implicit class TagRefAttributesBase(tagRef: TagRef[Base]) {
    val href = new Attribute[Base, scala.Option[String], String](tagRef, "href")
    val target = new Attribute[Base, scala.Option[String], String](tagRef, "target")
  }

  implicit class TagRefAttributesBasefont(tagRef: TagRef[Basefont]) {
    val color = new Attribute[Basefont, scala.Option[String], String](tagRef, "color")
    val face = new Attribute[Basefont, scala.Option[String], String](tagRef, "face")
    val size = new Attribute[Basefont, scala.Option[String], String](tagRef, "size")
  }

  implicit class TagRefAttributesBody(tagRef: TagRef[Body]) {
    val alink = new Attribute[Body, scala.Option[String], String](tagRef, "alink")
    val background = new Attribute[Body, scala.Option[String], String](tagRef, "background")
    val bgcolor = new Attribute[Body, scala.Option[String], String](tagRef, "bgcolor")
    val bottommargin = new Attribute[Body, scala.Option[String], String](tagRef, "bottommargin")
    val leftmargin = new Attribute[Body, scala.Option[String], String](tagRef, "leftmargin")
    val link = new Attribute[Body, scala.Option[String], String](tagRef, "link")
    val onafterprint = new Attribute[Body, scala.Option[String], String](tagRef, "onafterprint")
    val onbeforeprint = new Attribute[Body, scala.Option[String], String](tagRef, "onbeforeprint")
    val onbeforeunload = new Attribute[Body, scala.Option[String], String](tagRef, "onbeforeunload")
    val onblur = new Attribute[Body, scala.Option[String], String](tagRef, "onblur")
    val onerror = new Attribute[Body, scala.Option[String], String](tagRef, "onerror")
    val onfocus = new Attribute[Body, scala.Option[String], String](tagRef, "onfocus")
    val onhashchange = new Attribute[Body, scala.Option[String], String](tagRef, "onhashchange")
    val onlanguagechange = new Attribute[Body, scala.Option[String], String](tagRef, "onlanguagechange")
    val onload = new Attribute[Body, scala.Option[String], String](tagRef, "onload")
    val onmessage = new Attribute[Body, scala.Option[String], String](tagRef, "onmessage")
    val onoffline = new Attribute[Body, scala.Option[String], String](tagRef, "onoffline")
    val ononline = new Attribute[Body, scala.Option[String], String](tagRef, "ononline")
    val onpopstate = new Attribute[Body, scala.Option[String], String](tagRef, "onpopstate")
    val onredo = new Attribute[Body, scala.Option[String], String](tagRef, "onredo")
    val onresize = new Attribute[Body, scala.Option[String], String](tagRef, "onresize")
    val onstorage = new Attribute[Body, scala.Option[String], String](tagRef, "onstorage")
    val onundo = new Attribute[Body, scala.Option[String], String](tagRef, "onundo")
    val onunload = new Attribute[Body, scala.Option[String], String](tagRef, "onunload")
    val rightmargin = new Attribute[Body, scala.Option[String], String](tagRef, "rightmargin")
    val text = new Attribute[Body, scala.Option[String], String](tagRef, "text")
    val topmargin = new Attribute[Body, scala.Option[String], String](tagRef, "topmargin")
    val vlink = new Attribute[Body, scala.Option[String], String](tagRef, "vlink")
  }

  implicit class TagRefAttributesBr(tagRef: TagRef[Br]) {
    val clear = new Attribute[Br, scala.Option[String], String](tagRef, "clear")
  }

  implicit class TagRefAttributesButton(tagRef: TagRef[Button]) {
    val autofocus = new Attribute[Button, Boolean, Boolean](tagRef, "autofocus")
    val autocomplete = new Attribute[Button, scala.Option[String], String](tagRef, "autocomplete")
    val disabled = new Attribute[Button, Boolean, Boolean](tagRef, "disabled")
    val form = new Attribute[Button, scala.Option[String], String](tagRef, "form")
    val formaction = new Attribute[Button, scala.Option[String], String](tagRef, "formaction")
    val formenctype = new Attribute[Button, scala.Option[String], String](tagRef, "formenctype")
    val formmethod = new Attribute[Button, scala.Option[String], String](tagRef, "formmethod")
    val formnovalidate = new Attribute[Button, scala.Option[String], String](tagRef, "formnovalidate")
    val formtarget = new Attribute[Button, scala.Option[String], String](tagRef, "formtarget")
    val name = new Attribute[Button, scala.Option[String], String](tagRef, "name")
    val `type` = new Attribute[Button, scala.Option[String], String](tagRef, "type")
    val value = new Attribute[Button, scala.Option[String], String](tagRef, "value")
  }

  implicit class TagRefAttributesCanvas(tagRef: TagRef[Canvas]) {
    val height = new Attribute[Canvas, scala.Option[String], String](tagRef, "height")
    val `moz-opaque` = new Attribute[Canvas, scala.Option[String], String](tagRef, "moz-opaque")
    val width = new Attribute[Canvas, scala.Option[String], String](tagRef, "width")
  }

  implicit class TagRefAttributesCaption(tagRef: TagRef[Caption]) {
    val align = new Attribute[Caption, scala.Option[String], String](tagRef, "align")
  }

  implicit class TagRefAttributesCol(tagRef: TagRef[Col]) {
    val align = new Attribute[Col, scala.Option[String], String](tagRef, "align")
    val bgcolor = new Attribute[Col, scala.Option[String], String](tagRef, "bgcolor")
    val char = new Attribute[Col, scala.Option[String], String](tagRef, "char")
    val charoff = new Attribute[Col, scala.Option[String], String](tagRef, "charoff")
    val span = new Attribute[Col, scala.Option[Long], Long](tagRef, "span")
    val valign = new Attribute[Col, scala.Option[String], String](tagRef, "valign")
    val width = new Attribute[Col, scala.Option[String], String](tagRef, "width")
  }

  implicit class TagRefAttributesColgroup(tagRef: TagRef[Colgroup]) {
    val align = new Attribute[Colgroup, scala.Option[String], String](tagRef, "align")
    val bgcolor = new Attribute[Colgroup, scala.Option[String], String](tagRef, "bgcolor")
    val char = new Attribute[Colgroup, scala.Option[String], String](tagRef, "char")
    val charoff = new Attribute[Colgroup, scala.Option[String], String](tagRef, "charoff")
    val span = new Attribute[Colgroup, scala.Option[Long], Long](tagRef, "span")
    val valign = new Attribute[Colgroup, scala.Option[String], String](tagRef, "valign")
    val width = new Attribute[Colgroup, scala.Option[String], String](tagRef, "width")
  }

  implicit class TagRefAttributesDd(tagRef: TagRef[Dd]) {
    val nowrap = new Attribute[Dd, scala.Option[String], String](tagRef, "nowrap")
  }

  implicit class TagRefAttributesDel(tagRef: TagRef[Del]) {
    val cite = new Attribute[Del, scala.Option[String], String](tagRef, "cite")
    val datetime = new Attribute[Del, scala.Option[String], String](tagRef, "datetime")
  }

  implicit class TagRefAttributesDetails(tagRef: TagRef[Details]) {
    val open = new Attribute[Details, scala.Option[String], String](tagRef, "open")
  }

  implicit class TagRefAttributesDialog(tagRef: TagRef[Dialog]) {
    val open = new Attribute[Dialog, Boolean, Boolean](tagRef, "open")
  }

  implicit class TagRefAttributesDir(tagRef: TagRef[Dir]) {
    val compact = new Attribute[Dir, scala.Option[String], String](tagRef, "compact")
  }

  implicit class TagRefAttributesDl(tagRef: TagRef[Dl]) {
    val compact = new Attribute[Dl, Boolean, Boolean](tagRef, "compact")
  }

  implicit class TagRefAttributesEmbed(tagRef: TagRef[Embed]) {
    val height = new Attribute[Embed, scala.Option[String], String](tagRef, "height")
    val src = new Attribute[Embed, scala.Option[String], String](tagRef, "src")
    val `type` = new Attribute[Embed, scala.Option[String], String](tagRef, "type")
    val width = new Attribute[Embed, scala.Option[String], String](tagRef, "width")
  }

  implicit class TagRefAttributesFieldset(tagRef: TagRef[Fieldset]) {
    val disabled = new Attribute[Fieldset, scala.Option[String], String](tagRef, "disabled")
    val form = new Attribute[Fieldset, scala.Option[String], String](tagRef, "form")
    val name = new Attribute[Fieldset, scala.Option[String], String](tagRef, "name")
  }

  implicit class TagRefAttributesForm(tagRef: TagRef[Form]) {
    val accept = new Attribute[Form, scala.Option[String], String](tagRef, "accept")
    val `accept-charset` = new Attribute[Form, scala.Option[String], String](tagRef, "accept-charset")
    val action = new Attribute[Form, scala.Option[String], String](tagRef, "action")
    val autocapitalize = new Attribute[Form, scala.Option[String], String](tagRef, "autocapitalize")
    val autocomplete = new Attribute[Form, scala.Option[String], String](tagRef, "autocomplete")
    val enctype = new Attribute[Form, scala.Option[String], String](tagRef, "enctype")
    val method = new Attribute[Form, scala.Option[String], String](tagRef, "method")
    val name = new Attribute[Form, scala.Option[String], String](tagRef, "name")
    val novalidate = new Attribute[Form, scala.Option[String], String](tagRef, "novalidate")
    val target = new Attribute[Form, scala.Option[String], String](tagRef, "target")
  }

  implicit class TagRefAttributesFrame(tagRef: TagRef[Frame]) {
    val src = new Attribute[Frame, scala.Option[String], String](tagRef, "src")
    val name = new Attribute[Frame, scala.Option[String], String](tagRef, "name")
    val noresize = new Attribute[Frame, scala.Option[String], String](tagRef, "noresize")
    val scrolling = new Attribute[Frame, scala.Option[String], String](tagRef, "scrolling")
    val marginheight = new Attribute[Frame, scala.Option[String], String](tagRef, "marginheight")
    val marginwidth = new Attribute[Frame, scala.Option[String], String](tagRef, "marginwidth")
    val frameborder = new Attribute[Frame, scala.Option[String], String](tagRef, "frameborder")
  }

  implicit class TagRefAttributesFrameset(tagRef: TagRef[Frameset]) {
    val cols = new Attribute[Frameset, scala.Option[String], String](tagRef, "cols")
    val rows = new Attribute[Frameset, scala.Option[String], String](tagRef, "rows")
  }

  implicit class TagRefAttributesHead(tagRef: TagRef[Head]) {
    val profile = new Attribute[Head, scala.Option[String], String](tagRef, "profile")
  }

  implicit class TagRefAttributesHr(tagRef: TagRef[Hr]) {
    val align = new Attribute[Hr, scala.Option[String], String](tagRef, "align")
    val color = new Attribute[Hr, scala.Option[String], String](tagRef, "color")
    val noshade = new Attribute[Hr, Boolean, Boolean](tagRef, "noshade")
    val size = new Attribute[Hr, scala.Option[String], String](tagRef, "size")
    val width = new Attribute[Hr, scala.Option[String], String](tagRef, "width")
  }

  implicit class TagRefAttributesHtml(tagRef: TagRef[Html]) {
    val manifest = new Attribute[Html, scala.Option[String], String](tagRef, "manifest")
    val version = new Attribute[Html, scala.Option[String], String](tagRef, "version")
    val xmlns = new Attribute[Html, scala.Option[String], String](tagRef, "xmlns")
  }

  implicit class TagRefAttributesIframe(tagRef: TagRef[Iframe]) {
    val align = new Attribute[Iframe, scala.Option[String], String](tagRef, "align")
    val allowfullscreen = new Attribute[Iframe, scala.Option[String], String](tagRef, "allowfullscreen")
    val frameborder = new Attribute[Iframe, scala.Option[String], String](tagRef, "frameborder")
    val height = new Attribute[Iframe, scala.Option[String], String](tagRef, "height")
    val longdesc = new Attribute[Iframe, scala.Option[String], String](tagRef, "longdesc")
    val marginheight = new Attribute[Iframe, scala.Option[String], String](tagRef, "marginheight")
    val marginwidth = new Attribute[Iframe, scala.Option[String], String](tagRef, "marginwidth")
    val mozallowfullscreen = new Attribute[Iframe, scala.Option[String], String](tagRef, "mozallowfullscreen")
    val webkitallowfullscreen = new Attribute[Iframe, scala.Option[String], String](tagRef, "webkitallowfullscreen")
    val mozapp = new Attribute[Iframe, scala.Option[String], String](tagRef, "mozapp")
    val mozbrowser = new Attribute[Iframe, scala.Option[String], String](tagRef, "mozbrowser")
    val name = new Attribute[Iframe, scala.Option[String], String](tagRef, "name")
    val remote = new Attribute[Iframe, scala.Option[String], String](tagRef, "remote")
    val scrolling = new Attribute[Iframe, scala.Option[String], String](tagRef, "scrolling")
    val sandbox = new Attribute[Iframe, scala.Option[String], String](tagRef, "sandbox")
    val seamless = new Attribute[Iframe, scala.Option[String], String](tagRef, "seamless")
    val src = new Attribute[Iframe, scala.Option[String], String](tagRef, "src")
    val srcdoc = new Attribute[Iframe, scala.Option[String], String](tagRef, "srcdoc")
    val width = new Attribute[Iframe, scala.Option[String], String](tagRef, "width")
  }

  implicit class TagRefAttributesImg(tagRef: TagRef[Img]) {
    val `align vertical-align` = new Attribute[Img, scala.Option[String], String](tagRef, "align vertical-align")
    val alt = new Attribute[Img, scala.Option[String], String](tagRef, "alt")
    val border = new Attribute[Img, scala.Option[String], String](tagRef, "border")
    val crossorigin = new Attribute[Img, scala.Option[String], String](tagRef, "crossorigin")
    val height = new Attribute[Img, scala.Option[String], String](tagRef, "height")
    val hspace = new Attribute[Img, scala.Option[String], String](tagRef, "hspace")
    val ismap = new Attribute[Img, scala.Option[String], String](tagRef, "ismap")
    val longdesc = new Attribute[Img, scala.Option[String], String](tagRef, "longdesc")
    val name = new Attribute[Img, scala.Option[String], String](tagRef, "name")
    val sizes = new Attribute[Img, scala.Option[String], String](tagRef, "sizes")
    val src = new Attribute[Img, scala.Option[String], String](tagRef, "src")
    val srcset = new Attribute[Img, scala.Option[String], String](tagRef, "srcset")
    val width = new Attribute[Img, scala.Option[String], String](tagRef, "width")
    val usemap = new Attribute[Img, scala.Option[String], String](tagRef, "usemap")
    val vspace = new Attribute[Img, scala.Option[String], String](tagRef, "vspace")
  }

  implicit class TagRefAttributesInput(tagRef: TagRef[Input]) {
    val `type` = new Attribute[Input, scala.Option[String], String](tagRef, "type")
    val accept = new Attribute[Input, scala.Option[String], String](tagRef, "accept")
    val accesskey = new Attribute[Input, scala.Option[String], String](tagRef, "accesskey")
    val mozactionhint = new Attribute[Input, scala.Option[String], String](tagRef, "mozactionhint")
    val autocapitalize = new Attribute[Input, scala.Option[String], String](tagRef, "autocapitalize")
    val autocomplete = new Attribute[Input, scala.Option[String], String](tagRef, "autocomplete")
    val autocorrect = new Attribute[Input, scala.Option[String], String](tagRef, "autocorrect")
    val autofocus = new Attribute[Input, Boolean, Boolean](tagRef, "autofocus")
    val autosave = new Attribute[Input, scala.Option[String], String](tagRef, "autosave")
    val checked = new Attribute[Input, Boolean, Boolean](tagRef, "checked")
    val disabled = new Attribute[Input, Boolean, Boolean](tagRef, "disabled")
    val form = new Attribute[Input, scala.Option[String], String](tagRef, "form")
    val formaction = new Attribute[Input, scala.Option[String], String](tagRef, "formaction")
    val formenctype = new Attribute[Input, scala.Option[String], String](tagRef, "formenctype")
    val formmethod = new Attribute[Input, scala.Option[String], String](tagRef, "formmethod")
    val formnovalidate = new Attribute[Input, scala.Option[String], String](tagRef, "formnovalidate")
    val formtarget = new Attribute[Input, scala.Option[String], String](tagRef, "formtarget")
    val height = new Attribute[Input, scala.Option[String], String](tagRef, "height")
    val incremental = new Attribute[Input, scala.Option[String], String](tagRef, "incremental")
    val inputmode = new Attribute[Input, scala.Option[String], String](tagRef, "inputmode")
    val list = new Attribute[Input, scala.Option[String], String](tagRef, "list")
    val max = new Attribute[Input, scala.Option[String], String](tagRef, "max")
    val maxlength = new Attribute[Input, scala.Option[String], String](tagRef, "maxlength")
    val min = new Attribute[Input, scala.Option[String], String](tagRef, "min")
    val minlength = new Attribute[Input, scala.Option[String], String](tagRef, "minlength")
    val multiple = new Attribute[Input, scala.Option[String], String](tagRef, "multiple")
    val name = new Attribute[Input, scala.Option[String], String](tagRef, "name")
    val pattern = new Attribute[Input, scala.Option[String], String](tagRef, "pattern")
    val placeholder = new Attribute[Input, scala.Option[String], String](tagRef, "placeholder")
    val readonly = new Attribute[Input, scala.Option[String], String](tagRef, "readonly")
    val required = new Attribute[Input, Boolean, Boolean](tagRef, "required")
    val results = new Attribute[Input, scala.Option[String], String](tagRef, "results")
    val selectionDirection = new Attribute[Input, scala.Option[String], String](tagRef, "selectionDirection")
    val size = new Attribute[Input, scala.Option[Long], Long](tagRef, "size")
    val spellcheck = new Attribute[Input, scala.Option[String], String](tagRef, "spellcheck")
    val src = new Attribute[Input, scala.Option[String], String](tagRef, "src")
    val step = new Attribute[Input, scala.Option[String], String](tagRef, "step")
    val tabindex = new Attribute[Input, scala.Option[String], String](tagRef, "tabindex")
    val usemap = new Attribute[Input, scala.Option[String], String](tagRef, "usemap")
    val value = new Attribute[Input, scala.Option[String], String](tagRef, "value")
    val width = new Attribute[Input, scala.Option[String], String](tagRef, "width")
    val `x-moz-errormessage` = new Attribute[Input, scala.Option[String], String](tagRef, "x-moz-errormessage")
  }

  implicit class TagRefAttributesIns(tagRef: TagRef[Ins]) {
    val cite = new Attribute[Ins, scala.Option[String], String](tagRef, "cite")
    val datetime = new Attribute[Ins, scala.Option[String], String](tagRef, "datetime")
  }

  implicit class TagRefAttributesIsindex(tagRef: TagRef[Isindex]) {
    val prompt = new Attribute[Isindex, scala.Option[String], String](tagRef, "prompt")
    val action = new Attribute[Isindex, scala.Option[String], String](tagRef, "action")
  }

  implicit class TagRefAttributesKeygen(tagRef: TagRef[Keygen]) {
    val autofocus = new Attribute[Keygen, scala.Option[String], String](tagRef, "autofocus")
    val challenge = new Attribute[Keygen, scala.Option[String], String](tagRef, "challenge")
    val disabled = new Attribute[Keygen, scala.Option[String], String](tagRef, "disabled")
    val form = new Attribute[Keygen, scala.Option[String], String](tagRef, "form")
    val keytype = new Attribute[Keygen, scala.Option[String], String](tagRef, "keytype")
    val name = new Attribute[Keygen, scala.Option[String], String](tagRef, "name")
  }

  implicit class TagRefAttributesLabel(tagRef: TagRef[Label]) {
    val accesskey = new Attribute[Label, scala.Option[String], String](tagRef, "accesskey")
    val `for` = new Attribute[Label, scala.Option[String], String](tagRef, "for")
    val form = new Attribute[Label, scala.Option[String], String](tagRef, "form")
  }

  implicit class TagRefAttributesLi(tagRef: TagRef[Li]) {
    val value = new Attribute[Li, scala.Option[Long], Long](tagRef, "value")
    val `type` = new Attribute[Li, scala.Option[String], String](tagRef, "type")
  }

  implicit class TagRefAttributesLink(tagRef: TagRef[Link]) {
    val charset = new Attribute[Link, scala.Option[String], String](tagRef, "charset")
    val crossorigin = new Attribute[Link, scala.Option[String], String](tagRef, "crossorigin")
    val disabled = new Attribute[Link, scala.Option[String], String](tagRef, "disabled")
    val href = new Attribute[Link, scala.Option[String], String](tagRef, "href")
    val hreflang = new Attribute[Link, scala.Option[String], String](tagRef, "hreflang")
    val media = new Attribute[Link, scala.Option[String], String](tagRef, "media")
    val methods = new Attribute[Link, scala.Option[String], String](tagRef, "methods")
    val rel = new Attribute[Link, scala.Option[String], String](tagRef, "rel")
    val rev = new Attribute[Link, scala.Option[String], String](tagRef, "rev")
    val sizes = new Attribute[Link, scala.Option[String], String](tagRef, "sizes")
    val target = new Attribute[Link, scala.Option[String], String](tagRef, "target")
    val `type` = new Attribute[Link, scala.Option[String], String](tagRef, "type")
    val integrity = new Attribute[Link, scala.Option[String], String](tagRef, "integrity")
  }

  implicit class TagRefAttributesMap(tagRef: TagRef[Map]) {
    val name = new Attribute[Map, scala.Option[String], String](tagRef, "name")
  }

  implicit class TagRefAttributesMenu(tagRef: TagRef[Menu]) {
    val label = new Attribute[Menu, scala.Option[String], String](tagRef, "label")
    val `type` = new Attribute[Menu, scala.Option[String], String](tagRef, "type")
  }

  implicit class TagRefAttributesMenuitem(tagRef: TagRef[Menuitem]) {
    val checked = new Attribute[Menuitem, scala.Option[String], String](tagRef, "checked")
    val command = new Attribute[Menuitem, scala.Option[String], String](tagRef, "command")
    val default = new Attribute[Menuitem, scala.Option[String], String](tagRef, "default")
    val disabled = new Attribute[Menuitem, scala.Option[String], String](tagRef, "disabled")
    val icon = new Attribute[Menuitem, scala.Option[String], String](tagRef, "icon")
    val label = new Attribute[Menuitem, scala.Option[String], String](tagRef, "label")
    val radiogroup = new Attribute[Menuitem, scala.Option[String], String](tagRef, "radiogroup")
    val `type` = new Attribute[Menuitem, scala.Option[String], String](tagRef, "type")
  }

  implicit class TagRefAttributesMeta(tagRef: TagRef[Meta]) {
    val charset = new Attribute[Meta, scala.Option[String], String](tagRef, "charset")
    val content = new Attribute[Meta, scala.Option[String], String](tagRef, "content")
    val `http-equiv` = new Attribute[Meta, scala.Option[String], String](tagRef, "http-equiv")
    val name = new Attribute[Meta, scala.Option[String], String](tagRef, "name")
    val scheme = new Attribute[Meta, scala.Option[String], String](tagRef, "scheme")
  }

  implicit class TagRefAttributesMeter(tagRef: TagRef[Meter]) {
    val value = new Attribute[Meter, scala.Option[String], String](tagRef, "value")
    val min = new Attribute[Meter, scala.Option[Double], Double](tagRef, "min")
    val max = new Attribute[Meter, scala.Option[Double], Double](tagRef, "max")
    val low = new Attribute[Meter, scala.Option[Double], Double](tagRef, "low")
    val high = new Attribute[Meter, scala.Option[Double], Double](tagRef, "high")
    val optimum = new Attribute[Meter, scala.Option[Double], Double](tagRef, "optimum")
    val form = new Attribute[Meter, scala.Option[String], String](tagRef, "form")
  }

  implicit class TagRefAttributesObject(tagRef: TagRef[Object]) {
    val archive = new Attribute[Object, scala.Option[String], String](tagRef, "archive")
    val border = new Attribute[Object, scala.Option[String], String](tagRef, "border")
    val classid = new Attribute[Object, scala.Option[String], String](tagRef, "classid")
    val codebase = new Attribute[Object, scala.Option[String], String](tagRef, "codebase")
    val codetype = new Attribute[Object, scala.Option[String], String](tagRef, "codetype")
    val data = new Attribute[Object, scala.Option[String], String](tagRef, "data")
    val declare = new Attribute[Object, scala.Option[String], String](tagRef, "declare")
    val form = new Attribute[Object, scala.Option[String], String](tagRef, "form")
    val height = new Attribute[Object, scala.Option[String], String](tagRef, "height")
    val name = new Attribute[Object, scala.Option[String], String](tagRef, "name")
    val standby = new Attribute[Object, scala.Option[String], String](tagRef, "standby")
    val tabindex = new Attribute[Object, scala.Option[String], String](tagRef, "tabindex")
    val `type` = new Attribute[Object, scala.Option[String], String](tagRef, "type")
    val typemustmatch = new Attribute[Object, scala.Option[String], String](tagRef, "typemustmatch")
    val usemap = new Attribute[Object, scala.Option[String], String](tagRef, "usemap")
    val width = new Attribute[Object, scala.Option[String], String](tagRef, "width")
  }

  implicit class TagRefAttributesOl(tagRef: TagRef[Ol]) {
    val compact = new Attribute[Ol, scala.Option[String], String](tagRef, "compact")
    val reversed = new Attribute[Ol, scala.Option[String], String](tagRef, "reversed")
    val start = new Attribute[Ol, scala.Option[String], String](tagRef, "start")
    val `type` = new Attribute[Ol, scala.Option[String], String](tagRef, "type")
  }

  implicit class TagRefAttributesOptgroup(tagRef: TagRef[Optgroup]) {
    val disabled = new Attribute[Optgroup, Boolean, Boolean](tagRef, "disabled")
    val label = new Attribute[Optgroup, scala.Option[String], String](tagRef, "label")
  }

  implicit class TagRefAttributesOption(tagRef: TagRef[Option]) {
    val disabled = new Attribute[Option, scala.Option[String], String](tagRef, "disabled")
    val label = new Attribute[Option, scala.Option[String], String](tagRef, "label")
    val selected = new Attribute[Option, scala.Option[String], String](tagRef, "selected")
    val value = new Attribute[Option, scala.Option[String], String](tagRef, "value")
  }

  implicit class TagRefAttributesOutput(tagRef: TagRef[Output]) {
    val `for` = new Attribute[Output, scala.Option[String], String](tagRef, "for")
    val form = new Attribute[Output, scala.Option[String], String](tagRef, "form")
    val name = new Attribute[Output, scala.Option[String], String](tagRef, "name")
  }

  implicit class TagRefAttributesParam(tagRef: TagRef[Param]) {
    val name = new Attribute[Param, scala.Option[String], String](tagRef, "name")
    val `type` = new Attribute[Param, scala.Option[String], String](tagRef, "type")
    val value = new Attribute[Param, scala.Option[String], String](tagRef, "value")
    val valuetype = new Attribute[Param, scala.Option[String], String](tagRef, "valuetype")
  }

  implicit class TagRefAttributesPre(tagRef: TagRef[Pre]) {
    val cols = new Attribute[Pre, scala.Option[String], String](tagRef, "cols")
    val width = new Attribute[Pre, scala.Option[String], String](tagRef, "width")
    val wrap = new Attribute[Pre, scala.Option[String], String](tagRef, "wrap")
  }

  implicit class TagRefAttributesProgress(tagRef: TagRef[Progress]) {
    val max = new Attribute[Progress, scala.Option[String], String](tagRef, "max")
    val value = new Attribute[Progress, scala.Option[String], String](tagRef, "value")
  }

  implicit class TagRefAttributesScript(tagRef: TagRef[Script]) {
    val async = new Attribute[Script, scala.Option[String], String](tagRef, "async")
    val src = new Attribute[Script, scala.Option[String], String](tagRef, "src")
    val `type` = new Attribute[Script, scala.Option[String], String](tagRef, "type")
    val language = new Attribute[Script, scala.Option[String], String](tagRef, "language")
    val defer = new Attribute[Script, scala.Option[String], String](tagRef, "defer")
    val crossorigin = new Attribute[Script, scala.Option[String], String](tagRef, "crossorigin")
    val integrity = new Attribute[Script, scala.Option[String], String](tagRef, "integrity")
  }

  implicit class TagRefAttributesSelect(tagRef: TagRef[Select]) {
    val autofocus = new Attribute[Select, scala.Option[String], String](tagRef, "autofocus")
    val disabled = new Attribute[Select, scala.Option[String], String](tagRef, "disabled")
    val form = new Attribute[Select, scala.Option[String], String](tagRef, "form")
    val multiple = new Attribute[Select, scala.Option[String], String](tagRef, "multiple")
    val name = new Attribute[Select, scala.Option[String], String](tagRef, "name")
    val required = new Attribute[Select, scala.Option[String], String](tagRef, "required")
    val size = new Attribute[Select, scala.Option[String], String](tagRef, "size")
  }

  implicit class TagRefAttributesSource(tagRef: TagRef[Source]) {
    val sizes = new Attribute[Source, scala.Option[String], String](tagRef, "sizes")
    val src = new Attribute[Source, scala.Option[String], String](tagRef, "src")
    val srcset = new Attribute[Source, scala.Option[String], String](tagRef, "srcset")
    val `type` = new Attribute[Source, scala.Option[String], String](tagRef, "type")
    val media = new Attribute[Source, scala.Option[String], String](tagRef, "media")
  }

  implicit class TagRefAttributesSpacer(tagRef: TagRef[Spacer]) {
    val `type` = new Attribute[Spacer, scala.Option[String], String](tagRef, "type")
    val size = new Attribute[Spacer, scala.Option[String], String](tagRef, "size")
    val width = new Attribute[Spacer, scala.Option[String], String](tagRef, "width")
    val height = new Attribute[Spacer, scala.Option[String], String](tagRef, "height")
    val align = new Attribute[Spacer, scala.Option[String], String](tagRef, "align")
  }

  implicit class TagRefAttributesStyle(tagRef: TagRef[Style]) {
    val `type` = new Attribute[Style, scala.Option[String], String](tagRef, "type")
    val media = new Attribute[Style, scala.Option[String], String](tagRef, "media")
    val scoped = new Attribute[Style, scala.Option[String], String](tagRef, "scoped")
    val title = new Attribute[Style, scala.Option[String], String](tagRef, "title")
    val disabled = new Attribute[Style, scala.Option[String], String](tagRef, "disabled")
  }

  implicit class TagRefAttributesTable(tagRef: TagRef[Table]) {
    val align = new Attribute[Table, scala.Option[String], String](tagRef, "align")
    val bgcolor = new Attribute[Table, scala.Option[String], String](tagRef, "bgcolor")
    val border = new Attribute[Table, scala.Option[String], String](tagRef, "border")
    val cellpadding = new Attribute[Table, scala.Option[String], String](tagRef, "cellpadding")
    val cellspacing = new Attribute[Table, scala.Option[String], String](tagRef, "cellspacing")
    val frame = new Attribute[Table, scala.Option[String], String](tagRef, "frame")
    val rules = new Attribute[Table, scala.Option[String], String](tagRef, "rules")
    val summary = new Attribute[Table, scala.Option[String], String](tagRef, "summary")
    val width = new Attribute[Table, scala.Option[String], String](tagRef, "width")
  }

  implicit class TagRefAttributesTbody(tagRef: TagRef[Tbody]) {
    val align = new Attribute[Tbody, scala.Option[String], String](tagRef, "align")
    val bgcolor = new Attribute[Tbody, scala.Option[String], String](tagRef, "bgcolor")
    val char = new Attribute[Tbody, scala.Option[String], String](tagRef, "char")
    val charoff = new Attribute[Tbody, scala.Option[String], String](tagRef, "charoff")
    val valign = new Attribute[Tbody, scala.Option[String], String](tagRef, "valign")
  }

  implicit class TagRefAttributesTd(tagRef: TagRef[Td]) {
    val abbr = new Attribute[Td, scala.Option[String], String](tagRef, "abbr")
    val align = new Attribute[Td, scala.Option[String], String](tagRef, "align")
    val axis = new Attribute[Td, scala.Option[String], String](tagRef, "axis")
    val bgcolor = new Attribute[Td, scala.Option[String], String](tagRef, "bgcolor")
    val char = new Attribute[Td, scala.Option[String], String](tagRef, "char")
    val charoff = new Attribute[Td, scala.Option[String], String](tagRef, "charoff")
    val colspan = new Attribute[Td, scala.Option[String], String](tagRef, "colspan")
    val headers = new Attribute[Td, scala.Option[String], String](tagRef, "headers")
    val rowspan = new Attribute[Td, scala.Option[String], String](tagRef, "rowspan")
    val scope = new Attribute[Td, scala.Option[String], String](tagRef, "scope")
    val valign = new Attribute[Td, scala.Option[String], String](tagRef, "valign")
    val width = new Attribute[Td, scala.Option[String], String](tagRef, "width")
  }

  implicit class TagRefAttributesTextarea(tagRef: TagRef[Textarea]) {
    val autocapitalize = new Attribute[Textarea, scala.Option[String], String](tagRef, "autocapitalize")
    val autocomplete = new Attribute[Textarea, scala.Option[String], String](tagRef, "autocomplete")
    val autofocus = new Attribute[Textarea, scala.Option[String], String](tagRef, "autofocus")
    val cols = new Attribute[Textarea, scala.Option[String], String](tagRef, "cols")
    val disabled = new Attribute[Textarea, scala.Option[String], String](tagRef, "disabled")
    val form = new Attribute[Textarea, scala.Option[String], String](tagRef, "form")
    val maxlength = new Attribute[Textarea, scala.Option[String], String](tagRef, "maxlength")
    val minlength = new Attribute[Textarea, scala.Option[String], String](tagRef, "minlength")
    val name = new Attribute[Textarea, scala.Option[String], String](tagRef, "name")
    val placeholder = new Attribute[Textarea, scala.Option[String], String](tagRef, "placeholder")
    val readonly = new Attribute[Textarea, scala.Option[String], String](tagRef, "readonly")
    val required = new Attribute[Textarea, scala.Option[String], String](tagRef, "required")
    val rows = new Attribute[Textarea, scala.Option[String], String](tagRef, "rows")
    val selectionDirection = new Attribute[Textarea, scala.Option[String], String](tagRef, "selectionDirection")
    val selectionEnd = new Attribute[Textarea, scala.Option[String], String](tagRef, "selectionEnd")
    val selectionStart = new Attribute[Textarea, scala.Option[String], String](tagRef, "selectionStart")
    val spellcheck = new Attribute[Textarea, scala.Option[String], String](tagRef, "spellcheck")
    val wrap = new Attribute[Textarea, scala.Option[String], String](tagRef, "wrap")
  }

  implicit class TagRefAttributesTfoot(tagRef: TagRef[Tfoot]) {
    val align = new Attribute[Tfoot, scala.Option[String], String](tagRef, "align")
    val bgcolor = new Attribute[Tfoot, scala.Option[String], String](tagRef, "bgcolor")
    val char = new Attribute[Tfoot, scala.Option[String], String](tagRef, "char")
    val charoff = new Attribute[Tfoot, scala.Option[String], String](tagRef, "charoff")
    val valign = new Attribute[Tfoot, scala.Option[String], String](tagRef, "valign")
  }

  implicit class TagRefAttributesTh(tagRef: TagRef[Th]) {
    val abbr = new Attribute[Th, scala.Option[String], String](tagRef, "abbr")
    val align = new Attribute[Th, scala.Option[String], String](tagRef, "align")
    val axis = new Attribute[Th, scala.Option[String], String](tagRef, "axis")
    val bgcolor = new Attribute[Th, scala.Option[String], String](tagRef, "bgcolor")
    val char = new Attribute[Th, scala.Option[String], String](tagRef, "char")
    val charoff = new Attribute[Th, scala.Option[String], String](tagRef, "charoff")
    val colspan = new Attribute[Th, scala.Option[String], String](tagRef, "colspan")
    val headers = new Attribute[Th, scala.Option[String], String](tagRef, "headers")
    val rowspan = new Attribute[Th, scala.Option[String], String](tagRef, "rowspan")
    val scope = new Attribute[Th, scala.Option[String], String](tagRef, "scope")
    val valign = new Attribute[Th, scala.Option[String], String](tagRef, "valign")
    val width = new Attribute[Th, scala.Option[String], String](tagRef, "width")
  }

  implicit class TagRefAttributesThead(tagRef: TagRef[Thead]) {
    val align = new Attribute[Thead, scala.Option[String], String](tagRef, "align")
    val bgcolor = new Attribute[Thead, scala.Option[String], String](tagRef, "bgcolor")
    val char = new Attribute[Thead, scala.Option[String], String](tagRef, "char")
    val charoff = new Attribute[Thead, scala.Option[String], String](tagRef, "charoff")
    val valign = new Attribute[Thead, scala.Option[String], String](tagRef, "valign")
  }

  implicit class TagRefAttributesTr(tagRef: TagRef[Tr]) {
    val align = new Attribute[Tr, scala.Option[String], String](tagRef, "align")
    val bgcolor = new Attribute[Tr, scala.Option[String], String](tagRef, "bgcolor")
    val char = new Attribute[Tr, scala.Option[String], String](tagRef, "char")
    val charoff = new Attribute[Tr, scala.Option[String], String](tagRef, "charoff")
    val valign = new Attribute[Tr, scala.Option[String], String](tagRef, "valign")
  }

  implicit class TagRefAttributesTrack(tagRef: TagRef[Track]) {
    val default = new Attribute[Track, scala.Option[String], String](tagRef, "default")
    val kind = new Attribute[Track, scala.Option[String], String](tagRef, "kind")
    val label = new Attribute[Track, scala.Option[String], String](tagRef, "label")
    val src = new Attribute[Track, scala.Option[String], String](tagRef, "src")
    val srclang = new Attribute[Track, scala.Option[String], String](tagRef, "srclang")
  }

  implicit class TagRefAttributesUl(tagRef: TagRef[Ul]) {
    val compact = new Attribute[Ul, scala.Option[String], String](tagRef, "compact")
    val `type` = new Attribute[Ul, scala.Option[String], String](tagRef, "type")
  }

  implicit class TagRefAttributesVideo(tagRef: TagRef[Video]) {
    val autoplay = new Attribute[Video, scala.Option[String], String](tagRef, "autoplay")
    val autobuffer = new Attribute[Video, scala.Option[String], String](tagRef, "autobuffer")
    val buffered = new Attribute[Video, scala.Option[String], String](tagRef, "buffered")
    val controls = new Attribute[Video, scala.Option[String], String](tagRef, "controls")
    val crossorigin = new Attribute[Video, scala.Option[String], String](tagRef, "crossorigin")
    val height = new Attribute[Video, scala.Option[String], String](tagRef, "height")
    val loop = new Attribute[Video, scala.Option[String], String](tagRef, "loop")
    val muted = new Attribute[Video, scala.Option[String], String](tagRef, "muted")
    val played = new Attribute[Video, scala.Option[String], String](tagRef, "played")
    val preload = new Attribute[Video, scala.Option[String], String](tagRef, "preload")
    val poster = new Attribute[Video, scala.Option[String], String](tagRef, "poster")
    val src = new Attribute[Video, scala.Option[String], String](tagRef, "src")
    val width = new Attribute[Video, scala.Option[String], String](tagRef, "width")
  }

}
