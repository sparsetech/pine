package pine.tag

import pine._

trait Attributes {
  implicit class TagAttributes[T <: Singleton](tag: Tag[T]) {
    val accesskey = TagAttribute[T, String](tag, "accesskey")
    val `class` = TagAttribute[T, String](tag, "class")
    val contenteditable = TagAttribute[T, String](tag, "contenteditable")
    val contextmenu = TagAttribute[T, String](tag, "contextmenu")
    val dir = TagAttribute[T, String](tag, "dir")
    val draggable = TagAttribute[T, Boolean](tag, "draggable")
    val dropzone = TagAttribute[T, String](tag, "dropzone")
    val hidden = TagAttribute[T, Boolean](tag, "hidden")
    val id = TagAttribute[T, String](tag, "id")
    val itemid = TagAttribute[T, String](tag, "itemid")
    val itemprop = TagAttribute[T, String](tag, "itemprop")
    val itemref = TagAttribute[T, String](tag, "itemref")
    val itemscope = TagAttribute[T, Boolean](tag, "itemscope")
    val itemtype = TagAttribute[T, String](tag, "itemtype")
    val lang = TagAttribute[T, String](tag, "lang")
    val spellcheck = TagAttribute[T, Boolean](tag, "spellcheck")
    val style = TagAttribute[T, String](tag, "style")
    val tabindex = TagAttribute[T, String](tag, "tabindex")
    val title = TagAttribute[T, String](tag, "title")
    val translate = TagAttribute[T, Boolean](tag, "translate")
  }

  implicit class TagRefAttributes[T <: Singleton](tagRef: TagRef[T]) {
    val accesskey = TagRefAttribute[T, String](tagRef, "accesskey")
    val `class` = TagRefAttribute[T, String](tagRef, "class")
    val contenteditable = TagRefAttribute[T, String](tagRef, "contenteditable")
    val contextmenu = TagRefAttribute[T, String](tagRef, "contextmenu")
    val dir = TagRefAttribute[T, String](tagRef, "dir")
    val draggable = TagRefAttribute[T, Boolean](tagRef, "draggable")
    val dropzone = TagRefAttribute[T, String](tagRef, "dropzone")
    val hidden = TagRefAttribute[T, Boolean](tagRef, "hidden")
    val id = TagRefAttribute[T, String](tagRef, "id")
    val itemid = TagRefAttribute[T, String](tagRef, "itemid")
    val itemprop = TagRefAttribute[T, String](tagRef, "itemprop")
    val itemref = TagRefAttribute[T, String](tagRef, "itemref")
    val itemscope = TagRefAttribute[T, Boolean](tagRef, "itemscope")
    val itemtype = TagRefAttribute[T, String](tagRef, "itemtype")
    val lang = TagRefAttribute[T, String](tagRef, "lang")
    val spellcheck = TagRefAttribute[T, Boolean](tagRef, "spellcheck")
    val style = TagRefAttribute[T, String](tagRef, "style")
    val tabindex = TagRefAttribute[T, String](tagRef, "tabindex")
    val title = TagRefAttribute[T, String](tagRef, "title")
    val translate = TagRefAttribute[T, Boolean](tagRef, "translate")
  }

  implicit class TagAttributesA(tag: Tag[pine.tag.A]) {
    val download = TagAttribute[pine.tag.A, String](tag, "download")
    val href = TagAttribute[pine.tag.A, String](tag, "href")
    val hreflang = TagAttribute[pine.tag.A, String](tag, "hreflang")
    val media = TagAttribute[pine.tag.A, String](tag, "media")
    val ping = TagAttribute[pine.tag.A, String](tag, "ping")
    val rel = TagAttribute[pine.tag.A, String](tag, "rel")
    val target = TagAttribute[pine.tag.A, String](tag, "target")
    val `type` = TagAttribute[pine.tag.A, String](tag, "type")
    val charset = TagAttribute[pine.tag.A, String](tag, "charset")
    val coords = TagAttribute[pine.tag.A, String](tag, "coords")
    val name = TagAttribute[pine.tag.A, String](tag, "name")
    val rev = TagAttribute[pine.tag.A, String](tag, "rev")
    val shape = TagAttribute[pine.tag.A, String](tag, "shape")
    val datafld = TagAttribute[pine.tag.A, String](tag, "datafld")
    val datasrc = TagAttribute[pine.tag.A, String](tag, "datasrc")
    val methods = TagAttribute[pine.tag.A, String](tag, "methods")
    val urn = TagAttribute[pine.tag.A, String](tag, "urn")
  }

  implicit class TagRefAttributesA(tagRef: TagRef[tag.A]) {
    val download = TagRefAttribute[tag.A, String](tagRef, "download")
    val href = TagRefAttribute[tag.A, String](tagRef, "href")
    val hreflang = TagRefAttribute[tag.A, String](tagRef, "hreflang")
    val media = TagRefAttribute[tag.A, String](tagRef, "media")
    val ping = TagRefAttribute[tag.A, String](tagRef, "ping")
    val rel = TagRefAttribute[tag.A, String](tagRef, "rel")
    val target = TagRefAttribute[tag.A, String](tagRef, "target")
    val `type` = TagRefAttribute[tag.A, String](tagRef, "type")
    val charset = TagRefAttribute[tag.A, String](tagRef, "charset")
    val coords = TagRefAttribute[tag.A, String](tagRef, "coords")
    val name = TagRefAttribute[tag.A, String](tagRef, "name")
    val rev = TagRefAttribute[tag.A, String](tagRef, "rev")
    val shape = TagRefAttribute[tag.A, String](tagRef, "shape")
    val datafld = TagRefAttribute[tag.A, String](tagRef, "datafld")
    val datasrc = TagRefAttribute[tag.A, String](tagRef, "datasrc")
    val methods = TagRefAttribute[tag.A, String](tagRef, "methods")
    val urn = TagRefAttribute[tag.A, String](tagRef, "urn")
  }

  implicit class TagAttributesApplet(tag: Tag[pine.tag.Applet]) {
    val align = TagAttribute[pine.tag.Applet, String](tag, "align")
    val alt = TagAttribute[pine.tag.Applet, String](tag, "alt")
    val archive = TagAttribute[pine.tag.Applet, String](tag, "archive")
    val code = TagAttribute[pine.tag.Applet, String](tag, "code")
    val codebase = TagAttribute[pine.tag.Applet, String](tag, "codebase")
    val datafld = TagAttribute[pine.tag.Applet, String](tag, "datafld")
    val datasrc = TagAttribute[pine.tag.Applet, String](tag, "datasrc")
    val height = TagAttribute[pine.tag.Applet, String](tag, "height")
    val hspace = TagAttribute[pine.tag.Applet, String](tag, "hspace")
    val mayscript = TagAttribute[pine.tag.Applet, String](tag, "mayscript")
    val name = TagAttribute[pine.tag.Applet, String](tag, "name")
    val `object` = TagAttribute[pine.tag.Applet, String](tag, "object")
    val src = TagAttribute[pine.tag.Applet, String](tag, "src")
    val vspace = TagAttribute[pine.tag.Applet, String](tag, "vspace")
    val width = TagAttribute[pine.tag.Applet, String](tag, "width")
  }

  implicit class TagRefAttributesApplet(tagRef: TagRef[tag.Applet]) {
    val align = TagRefAttribute[tag.Applet, String](tagRef, "align")
    val alt = TagRefAttribute[tag.Applet, String](tagRef, "alt")
    val archive = TagRefAttribute[tag.Applet, String](tagRef, "archive")
    val code = TagRefAttribute[tag.Applet, String](tagRef, "code")
    val codebase = TagRefAttribute[tag.Applet, String](tagRef, "codebase")
    val datafld = TagRefAttribute[tag.Applet, String](tagRef, "datafld")
    val datasrc = TagRefAttribute[tag.Applet, String](tagRef, "datasrc")
    val height = TagRefAttribute[tag.Applet, String](tagRef, "height")
    val hspace = TagRefAttribute[tag.Applet, String](tagRef, "hspace")
    val mayscript = TagRefAttribute[tag.Applet, String](tagRef, "mayscript")
    val name = TagRefAttribute[tag.Applet, String](tagRef, "name")
    val `object` = TagRefAttribute[tag.Applet, String](tagRef, "object")
    val src = TagRefAttribute[tag.Applet, String](tagRef, "src")
    val vspace = TagRefAttribute[tag.Applet, String](tagRef, "vspace")
    val width = TagRefAttribute[tag.Applet, String](tagRef, "width")
  }

  implicit class TagAttributesArea(tag: Tag[pine.tag.Area]) {
    val alt = TagAttribute[pine.tag.Area, String](tag, "alt")
    val coords = TagAttribute[pine.tag.Area, String](tag, "coords")
    val download = TagAttribute[pine.tag.Area, String](tag, "download")
    val href = TagAttribute[pine.tag.Area, String](tag, "href")
    val hreflang = TagAttribute[pine.tag.Area, String](tag, "hreflang")
    val name = TagAttribute[pine.tag.Area, String](tag, "name")
    val media = TagAttribute[pine.tag.Area, String](tag, "media")
    val nohref = TagAttribute[pine.tag.Area, Boolean](tag, "nohref")
    val rel = TagAttribute[pine.tag.Area, String](tag, "rel")
    val shape = TagAttribute[pine.tag.Area, String](tag, "shape")
    val target = TagAttribute[pine.tag.Area, String](tag, "target")
    val `type` = TagAttribute[pine.tag.Area, String](tag, "type")
  }

  implicit class TagRefAttributesArea(tagRef: TagRef[tag.Area]) {
    val accesskey = TagRefAttribute[tag.Area, String](tagRef, "accesskey")
    val alt = TagRefAttribute[tag.Area, String](tagRef, "alt")
    val coords = TagRefAttribute[tag.Area, String](tagRef, "coords")
    val download = TagRefAttribute[tag.Area, String](tagRef, "download")
    val href = TagRefAttribute[tag.Area, String](tagRef, "href")
    val hreflang = TagRefAttribute[tag.Area, String](tagRef, "hreflang")
    val name = TagRefAttribute[tag.Area, String](tagRef, "name")
    val media = TagRefAttribute[tag.Area, String](tagRef, "media")
    val nohref = TagRefAttribute[tag.Area, Boolean](tagRef, "nohref")
    val rel = TagRefAttribute[tag.Area, String](tagRef, "rel")
    val shape = TagRefAttribute[tag.Area, String](tagRef, "shape")
    val tabindex = TagRefAttribute[tag.Area, String](tagRef, "tabindex")
    val target = TagRefAttribute[tag.Area, String](tagRef, "target")
    val `type` = TagRefAttribute[tag.Area, String](tagRef, "type")
  }

  implicit class TagAttributesAudio(tag: Tag[pine.tag.Audio]) {
    val autoplay = TagAttribute[pine.tag.Audio, Boolean](tag, "autoplay")
    val autobuffer = TagAttribute[pine.tag.Audio, String](tag, "autobuffer")
    val buffered = TagAttribute[pine.tag.Audio, String](tag, "buffered")
    val controls = TagAttribute[pine.tag.Audio, Boolean](tag, "controls")
    val loop = TagAttribute[pine.tag.Audio, Boolean](tag, "loop")
    val mozCurrentSampleOffset = TagAttribute[pine.tag.Audio, String](tag, "mozCurrentSampleOffset")
    val muted = TagAttribute[pine.tag.Audio, Boolean](tag, "muted")
    val played = TagAttribute[pine.tag.Audio, String](tag, "played")
    val preload = TagAttribute[pine.tag.Audio, String](tag, "preload")
    val src = TagAttribute[pine.tag.Audio, String](tag, "src")
    val volume = TagAttribute[pine.tag.Audio, String](tag, "volume")
  }

  implicit class TagRefAttributesAudio(tagRef: TagRef[tag.Audio]) {
    val autoplay = TagRefAttribute[tag.Audio, Boolean](tagRef, "autoplay")
    val autobuffer = TagRefAttribute[tag.Audio, String](tagRef, "autobuffer")
    val buffered = TagRefAttribute[tag.Audio, String](tagRef, "buffered")
    val controls = TagRefAttribute[tag.Audio, Boolean](tagRef, "controls")
    val loop = TagRefAttribute[tag.Audio, Boolean](tagRef, "loop")
    val mozCurrentSampleOffset = TagRefAttribute[tag.Audio, String](tagRef, "mozCurrentSampleOffset")
    val muted = TagRefAttribute[tag.Audio, Boolean](tagRef, "muted")
    val played = TagRefAttribute[tag.Audio, String](tagRef, "played")
    val preload = TagRefAttribute[tag.Audio, String](tagRef, "preload")
    val src = TagRefAttribute[tag.Audio, String](tagRef, "src")
    val volume = TagRefAttribute[tag.Audio, String](tagRef, "volume")
  }

  implicit class TagAttributesBase(tag: Tag[pine.tag.Base]) {
    val href = TagAttribute[pine.tag.Base, String](tag, "href")
    val target = TagAttribute[pine.tag.Base, String](tag, "target")
  }

  implicit class TagRefAttributesBase(tagRef: TagRef[tag.Base]) {
    val href = TagRefAttribute[tag.Base, String](tagRef, "href")
    val target = TagRefAttribute[tag.Base, String](tagRef, "target")
  }

  implicit class TagAttributesBasefont(tag: Tag[pine.tag.Basefont]) {
    val color = TagAttribute[pine.tag.Basefont, String](tag, "color")
    val face = TagAttribute[pine.tag.Basefont, String](tag, "face")
    val size = TagAttribute[pine.tag.Basefont, String](tag, "size")
  }

  implicit class TagRefAttributesBasefont(tagRef: TagRef[tag.Basefont]) {
    val color = TagRefAttribute[tag.Basefont, String](tagRef, "color")
    val face = TagRefAttribute[tag.Basefont, String](tagRef, "face")
    val size = TagRefAttribute[tag.Basefont, String](tagRef, "size")
  }

  implicit class TagAttributesBody(tag: Tag[pine.tag.Body]) {
    val alink = TagAttribute[pine.tag.Body, String](tag, "alink")
    val background = TagAttribute[pine.tag.Body, String](tag, "background")
    val bgcolor = TagAttribute[pine.tag.Body, String](tag, "bgcolor")
    val bottommargin = TagAttribute[pine.tag.Body, String](tag, "bottommargin")
    val leftmargin = TagAttribute[pine.tag.Body, String](tag, "leftmargin")
    val link = TagAttribute[pine.tag.Body, String](tag, "link")
    val rightmargin = TagAttribute[pine.tag.Body, String](tag, "rightmargin")
    val text = TagAttribute[pine.tag.Body, String](tag, "text")
    val topmargin = TagAttribute[pine.tag.Body, String](tag, "topmargin")
    val vlink = TagAttribute[pine.tag.Body, String](tag, "vlink")
  }

  implicit class TagRefAttributesBody(tagRef: TagRef[tag.Body]) {
    val alink = TagRefAttribute[tag.Body, String](tagRef, "alink")
    val background = TagRefAttribute[tag.Body, String](tagRef, "background")
    val bgcolor = TagRefAttribute[tag.Body, String](tagRef, "bgcolor")
    val bottommargin = TagRefAttribute[tag.Body, String](tagRef, "bottommargin")
    val leftmargin = TagRefAttribute[tag.Body, String](tagRef, "leftmargin")
    val link = TagRefAttribute[tag.Body, String](tagRef, "link")
    val rightmargin = TagRefAttribute[tag.Body, String](tagRef, "rightmargin")
    val text = TagRefAttribute[tag.Body, String](tagRef, "text")
    val topmargin = TagRefAttribute[tag.Body, String](tagRef, "topmargin")
    val vlink = TagRefAttribute[tag.Body, String](tagRef, "vlink")
  }

  implicit class TagAttributesBr(tag: Tag[pine.tag.Br]) {
    val clear = TagAttribute[pine.tag.Br, String](tag, "clear")
  }

  implicit class TagRefAttributesBr(tagRef: TagRef[tag.Br]) {
    val clear = TagRefAttribute[tag.Br, String](tagRef, "clear")
  }

  implicit class TagAttributesButton(tag: Tag[pine.tag.Button]) {
    val autofocus = TagAttribute[pine.tag.Button, Boolean](tag, "autofocus")
    val autocomplete = TagAttribute[pine.tag.Button, String](tag, "autocomplete")
    val disabled = TagAttribute[pine.tag.Button, Boolean](tag, "disabled")
    val form = TagAttribute[pine.tag.Button, String](tag, "form")
    val formaction = TagAttribute[pine.tag.Button, String](tag, "formaction")
    val formenctype = TagAttribute[pine.tag.Button, String](tag, "formenctype")
    val formmethod = TagAttribute[pine.tag.Button, String](tag, "formmethod")
    val formnovalidate = TagAttribute[pine.tag.Button, Boolean](tag, "formnovalidate")
    val formtarget = TagAttribute[pine.tag.Button, String](tag, "formtarget")
    val name = TagAttribute[pine.tag.Button, String](tag, "name")
    val `type` = TagAttribute[pine.tag.Button, String](tag, "type")
    val value = TagAttribute[pine.tag.Button, String](tag, "value")
  }

  implicit class TagRefAttributesButton(tagRef: TagRef[tag.Button]) {
    val autofocus = TagRefAttribute[tag.Button, Boolean](tagRef, "autofocus")
    val autocomplete = TagRefAttribute[tag.Button, String](tagRef, "autocomplete")
    val disabled = TagRefAttribute[tag.Button, Boolean](tagRef, "disabled")
    val form = TagRefAttribute[tag.Button, String](tagRef, "form")
    val formaction = TagRefAttribute[tag.Button, String](tagRef, "formaction")
    val formenctype = TagRefAttribute[tag.Button, String](tagRef, "formenctype")
    val formmethod = TagRefAttribute[tag.Button, String](tagRef, "formmethod")
    val formnovalidate = TagRefAttribute[tag.Button, Boolean](tagRef, "formnovalidate")
    val formtarget = TagRefAttribute[tag.Button, String](tagRef, "formtarget")
    val name = TagRefAttribute[tag.Button, String](tagRef, "name")
    val `type` = TagRefAttribute[tag.Button, String](tagRef, "type")
    val value = TagRefAttribute[tag.Button, String](tagRef, "value")
  }

  implicit class TagAttributesCanvas(tag: Tag[pine.tag.Canvas]) {
    val height = TagAttribute[pine.tag.Canvas, String](tag, "height")
    val `moz-opaque` = TagAttribute[pine.tag.Canvas, String](tag, "moz-opaque")
    val width = TagAttribute[pine.tag.Canvas, String](tag, "width")
  }

  implicit class TagRefAttributesCanvas(tagRef: TagRef[tag.Canvas]) {
    val height = TagRefAttribute[tag.Canvas, String](tagRef, "height")
    val `moz-opaque` = TagRefAttribute[tag.Canvas, String](tagRef, "moz-opaque")
    val width = TagRefAttribute[tag.Canvas, String](tagRef, "width")
  }

  implicit class TagAttributesCaption(tag: Tag[pine.tag.Caption]) {
    val align = TagAttribute[pine.tag.Caption, String](tag, "align")
  }

  implicit class TagRefAttributesCaption(tagRef: TagRef[tag.Caption]) {
    val align = TagRefAttribute[tag.Caption, String](tagRef, "align")
  }

  implicit class TagAttributesCol(tag: Tag[pine.tag.Col]) {
    val align = TagAttribute[pine.tag.Col, String](tag, "align")
    val bgcolor = TagAttribute[pine.tag.Col, String](tag, "bgcolor")
    val char = TagAttribute[pine.tag.Col, String](tag, "char")
    val charoff = TagAttribute[pine.tag.Col, String](tag, "charoff")
    val span = TagAttribute[pine.tag.Col, Long](tag, "span")
    val valign = TagAttribute[pine.tag.Col, String](tag, "valign")
    val width = TagAttribute[pine.tag.Col, String](tag, "width")
  }

  implicit class TagRefAttributesCol(tagRef: TagRef[tag.Col]) {
    val align = TagRefAttribute[tag.Col, String](tagRef, "align")
    val bgcolor = TagRefAttribute[tag.Col, String](tagRef, "bgcolor")
    val char = TagRefAttribute[tag.Col, String](tagRef, "char")
    val charoff = TagRefAttribute[tag.Col, String](tagRef, "charoff")
    val span = TagRefAttribute[tag.Col, Long](tagRef, "span")
    val valign = TagRefAttribute[tag.Col, String](tagRef, "valign")
    val width = TagRefAttribute[tag.Col, String](tagRef, "width")
  }

  implicit class TagAttributesColgroup(tag: Tag[pine.tag.Colgroup]) {
    val align = TagAttribute[pine.tag.Colgroup, String](tag, "align")
    val bgcolor = TagAttribute[pine.tag.Colgroup, String](tag, "bgcolor")
    val char = TagAttribute[pine.tag.Colgroup, String](tag, "char")
    val charoff = TagAttribute[pine.tag.Colgroup, String](tag, "charoff")
    val span = TagAttribute[pine.tag.Colgroup, Long](tag, "span")
    val valign = TagAttribute[pine.tag.Colgroup, String](tag, "valign")
    val width = TagAttribute[pine.tag.Colgroup, String](tag, "width")
  }

  implicit class TagRefAttributesColgroup(tagRef: TagRef[tag.Colgroup]) {
    val align = TagRefAttribute[tag.Colgroup, String](tagRef, "align")
    val bgcolor = TagRefAttribute[tag.Colgroup, String](tagRef, "bgcolor")
    val char = TagRefAttribute[tag.Colgroup, String](tagRef, "char")
    val charoff = TagRefAttribute[tag.Colgroup, String](tagRef, "charoff")
    val span = TagRefAttribute[tag.Colgroup, Long](tagRef, "span")
    val valign = TagRefAttribute[tag.Colgroup, String](tagRef, "valign")
    val width = TagRefAttribute[tag.Colgroup, String](tagRef, "width")
  }

  implicit class TagAttributesDd(tag: Tag[pine.tag.Dd]) {
    val nowrap = TagAttribute[pine.tag.Dd, Boolean](tag, "nowrap")
  }

  implicit class TagRefAttributesDd(tagRef: TagRef[tag.Dd]) {
    val nowrap = TagRefAttribute[tag.Dd, Boolean](tagRef, "nowrap")
  }

  implicit class TagAttributesDel(tag: Tag[pine.tag.Del]) {
    val cite = TagAttribute[pine.tag.Del, String](tag, "cite")
    val datetime = TagAttribute[pine.tag.Del, String](tag, "datetime")
  }

  implicit class TagRefAttributesDel(tagRef: TagRef[tag.Del]) {
    val cite = TagRefAttribute[tag.Del, String](tagRef, "cite")
    val datetime = TagRefAttribute[tag.Del, String](tagRef, "datetime")
  }

  implicit class TagAttributesDetails(tag: Tag[pine.tag.Details]) {
    val open = TagAttribute[pine.tag.Details, Boolean](tag, "open")
  }

  implicit class TagRefAttributesDetails(tagRef: TagRef[tag.Details]) {
    val open = TagRefAttribute[tag.Details, Boolean](tagRef, "open")
  }

  implicit class TagAttributesDialog(tag: Tag[pine.tag.Dialog]) {
    val open = TagAttribute[pine.tag.Dialog, Boolean](tag, "open")
  }

  implicit class TagRefAttributesDialog(tagRef: TagRef[tag.Dialog]) {
    val open = TagRefAttribute[tag.Dialog, Boolean](tagRef, "open")
  }

  implicit class TagAttributesDir(tag: Tag[pine.tag.Dir]) {
    val compact = TagAttribute[pine.tag.Dir, Boolean](tag, "compact")
  }

  implicit class TagRefAttributesDir(tagRef: TagRef[tag.Dir]) {
    val compact = TagRefAttribute[tag.Dir, Boolean](tagRef, "compact")
  }

  implicit class TagAttributesDl(tag: Tag[pine.tag.Dl]) {
    val compact = TagAttribute[pine.tag.Dl, Boolean](tag, "compact")
  }

  implicit class TagRefAttributesDl(tagRef: TagRef[tag.Dl]) {
    val compact = TagRefAttribute[tag.Dl, Boolean](tagRef, "compact")
  }

  implicit class TagAttributesEmbed(tag: Tag[pine.tag.Embed]) {
    val height = TagAttribute[pine.tag.Embed, String](tag, "height")
    val src = TagAttribute[pine.tag.Embed, String](tag, "src")
    val `type` = TagAttribute[pine.tag.Embed, String](tag, "type")
    val width = TagAttribute[pine.tag.Embed, String](tag, "width")
  }

  implicit class TagRefAttributesEmbed(tagRef: TagRef[tag.Embed]) {
    val height = TagRefAttribute[tag.Embed, String](tagRef, "height")
    val src = TagRefAttribute[tag.Embed, String](tagRef, "src")
    val `type` = TagRefAttribute[tag.Embed, String](tagRef, "type")
    val width = TagRefAttribute[tag.Embed, String](tagRef, "width")
  }

  implicit class TagAttributesFieldset(tag: Tag[pine.tag.Fieldset]) {
    val disabled = TagAttribute[pine.tag.Fieldset, Boolean](tag, "disabled")
    val form = TagAttribute[pine.tag.Fieldset, String](tag, "form")
    val name = TagAttribute[pine.tag.Fieldset, String](tag, "name")
  }

  implicit class TagRefAttributesFieldset(tagRef: TagRef[tag.Fieldset]) {
    val disabled = TagRefAttribute[tag.Fieldset, Boolean](tagRef, "disabled")
    val form = TagRefAttribute[tag.Fieldset, String](tagRef, "form")
    val name = TagRefAttribute[tag.Fieldset, String](tagRef, "name")
  }

  implicit class TagAttributesForm(tag: Tag[pine.tag.Form]) {
    val accept = TagAttribute[pine.tag.Form, String](tag, "accept")
    val `accept-charset` = TagAttribute[pine.tag.Form, String](tag, "accept-charset")
    val action = TagAttribute[pine.tag.Form, String](tag, "action")
    val autocapitalize = TagAttribute[pine.tag.Form, String](tag, "autocapitalize")
    val autocomplete = TagAttribute[pine.tag.Form, String](tag, "autocomplete")
    val enctype = TagAttribute[pine.tag.Form, String](tag, "enctype")
    val method = TagAttribute[pine.tag.Form, String](tag, "method")
    val name = TagAttribute[pine.tag.Form, String](tag, "name")
    val novalidate = TagAttribute[pine.tag.Form, Boolean](tag, "novalidate")
    val target = TagAttribute[pine.tag.Form, String](tag, "target")
  }

  implicit class TagRefAttributesForm(tagRef: TagRef[tag.Form]) {
    val accept = TagRefAttribute[tag.Form, String](tagRef, "accept")
    val `accept-charset` = TagRefAttribute[tag.Form, String](tagRef, "accept-charset")
    val action = TagRefAttribute[tag.Form, String](tagRef, "action")
    val autocapitalize = TagRefAttribute[tag.Form, String](tagRef, "autocapitalize")
    val autocomplete = TagRefAttribute[tag.Form, String](tagRef, "autocomplete")
    val enctype = TagRefAttribute[tag.Form, String](tagRef, "enctype")
    val method = TagRefAttribute[tag.Form, String](tagRef, "method")
    val name = TagRefAttribute[tag.Form, String](tagRef, "name")
    val novalidate = TagRefAttribute[tag.Form, Boolean](tagRef, "novalidate")
    val target = TagRefAttribute[tag.Form, String](tagRef, "target")
  }

  implicit class TagAttributesFrame(tag: Tag[pine.tag.Frame]) {
    val src = TagAttribute[pine.tag.Frame, String](tag, "src")
    val name = TagAttribute[pine.tag.Frame, String](tag, "name")
    val noresize = TagAttribute[pine.tag.Frame, Boolean](tag, "noresize")
    val scrolling = TagAttribute[pine.tag.Frame, String](tag, "scrolling")
    val marginheight = TagAttribute[pine.tag.Frame, String](tag, "marginheight")
    val marginwidth = TagAttribute[pine.tag.Frame, String](tag, "marginwidth")
    val frameborder = TagAttribute[pine.tag.Frame, String](tag, "frameborder")
  }

  implicit class TagRefAttributesFrame(tagRef: TagRef[tag.Frame]) {
    val src = TagRefAttribute[tag.Frame, String](tagRef, "src")
    val name = TagRefAttribute[tag.Frame, String](tagRef, "name")
    val noresize = TagRefAttribute[tag.Frame, Boolean](tagRef, "noresize")
    val scrolling = TagRefAttribute[tag.Frame, String](tagRef, "scrolling")
    val marginheight = TagRefAttribute[tag.Frame, String](tagRef, "marginheight")
    val marginwidth = TagRefAttribute[tag.Frame, String](tagRef, "marginwidth")
    val frameborder = TagRefAttribute[tag.Frame, String](tagRef, "frameborder")
  }

  implicit class TagAttributesFrameset(tag: Tag[pine.tag.Frameset]) {
    val cols = TagAttribute[pine.tag.Frameset, String](tag, "cols")
    val rows = TagAttribute[pine.tag.Frameset, String](tag, "rows")
  }

  implicit class TagRefAttributesFrameset(tagRef: TagRef[tag.Frameset]) {
    val cols = TagRefAttribute[tag.Frameset, String](tagRef, "cols")
    val rows = TagRefAttribute[tag.Frameset, String](tagRef, "rows")
  }

  implicit class TagAttributesHead(tag: Tag[pine.tag.Head]) {
    val profile = TagAttribute[pine.tag.Head, String](tag, "profile")
  }

  implicit class TagRefAttributesHead(tagRef: TagRef[tag.Head]) {
    val profile = TagRefAttribute[tag.Head, String](tagRef, "profile")
  }

  implicit class TagAttributesHr(tag: Tag[pine.tag.Hr]) {
    val align = TagAttribute[pine.tag.Hr, String](tag, "align")
    val color = TagAttribute[pine.tag.Hr, String](tag, "color")
    val noshade = TagAttribute[pine.tag.Hr, Boolean](tag, "noshade")
    val size = TagAttribute[pine.tag.Hr, String](tag, "size")
    val width = TagAttribute[pine.tag.Hr, String](tag, "width")
  }

  implicit class TagRefAttributesHr(tagRef: TagRef[tag.Hr]) {
    val align = TagRefAttribute[tag.Hr, String](tagRef, "align")
    val color = TagRefAttribute[tag.Hr, String](tagRef, "color")
    val noshade = TagRefAttribute[tag.Hr, Boolean](tagRef, "noshade")
    val size = TagRefAttribute[tag.Hr, String](tagRef, "size")
    val width = TagRefAttribute[tag.Hr, String](tagRef, "width")
  }

  implicit class TagAttributesHtml(tag: Tag[pine.tag.Html]) {
    val manifest = TagAttribute[pine.tag.Html, String](tag, "manifest")
    val version = TagAttribute[pine.tag.Html, String](tag, "version")
    val xmlns = TagAttribute[pine.tag.Html, String](tag, "xmlns")
  }

  implicit class TagRefAttributesHtml(tagRef: TagRef[tag.Html]) {
    val manifest = TagRefAttribute[tag.Html, String](tagRef, "manifest")
    val version = TagRefAttribute[tag.Html, String](tagRef, "version")
    val xmlns = TagRefAttribute[tag.Html, String](tagRef, "xmlns")
  }

  implicit class TagAttributesIframe(tag: Tag[pine.tag.Iframe]) {
    val align = TagAttribute[pine.tag.Iframe, String](tag, "align")
    val allowfullscreen = TagAttribute[pine.tag.Iframe, Boolean](tag, "allowfullscreen")
    val frameborder = TagAttribute[pine.tag.Iframe, String](tag, "frameborder")
    val height = TagAttribute[pine.tag.Iframe, String](tag, "height")
    val longdesc = TagAttribute[pine.tag.Iframe, String](tag, "longdesc")
    val marginheight = TagAttribute[pine.tag.Iframe, String](tag, "marginheight")
    val marginwidth = TagAttribute[pine.tag.Iframe, String](tag, "marginwidth")
    val mozallowfullscreen = TagAttribute[pine.tag.Iframe, String](tag, "mozallowfullscreen")
    val webkitallowfullscreen = TagAttribute[pine.tag.Iframe, String](tag, "webkitallowfullscreen")
    val mozapp = TagAttribute[pine.tag.Iframe, String](tag, "mozapp")
    val mozbrowser = TagAttribute[pine.tag.Iframe, String](tag, "mozbrowser")
    val name = TagAttribute[pine.tag.Iframe, String](tag, "name")
    val remote = TagAttribute[pine.tag.Iframe, String](tag, "remote")
    val scrolling = TagAttribute[pine.tag.Iframe, String](tag, "scrolling")
    val sandbox = TagAttribute[pine.tag.Iframe, String](tag, "sandbox")
    val seamless = TagAttribute[pine.tag.Iframe, Boolean](tag, "seamless")
    val src = TagAttribute[pine.tag.Iframe, String](tag, "src")
    val srcdoc = TagAttribute[pine.tag.Iframe, String](tag, "srcdoc")
    val width = TagAttribute[pine.tag.Iframe, String](tag, "width")
  }

  implicit class TagRefAttributesIframe(tagRef: TagRef[tag.Iframe]) {
    val align = TagRefAttribute[tag.Iframe, String](tagRef, "align")
    val allowfullscreen = TagRefAttribute[tag.Iframe, Boolean](tagRef, "allowfullscreen")
    val frameborder = TagRefAttribute[tag.Iframe, String](tagRef, "frameborder")
    val height = TagRefAttribute[tag.Iframe, String](tagRef, "height")
    val longdesc = TagRefAttribute[tag.Iframe, String](tagRef, "longdesc")
    val marginheight = TagRefAttribute[tag.Iframe, String](tagRef, "marginheight")
    val marginwidth = TagRefAttribute[tag.Iframe, String](tagRef, "marginwidth")
    val mozallowfullscreen = TagRefAttribute[tag.Iframe, String](tagRef, "mozallowfullscreen")
    val webkitallowfullscreen = TagRefAttribute[tag.Iframe, String](tagRef, "webkitallowfullscreen")
    val mozapp = TagRefAttribute[tag.Iframe, String](tagRef, "mozapp")
    val mozbrowser = TagRefAttribute[tag.Iframe, String](tagRef, "mozbrowser")
    val name = TagRefAttribute[tag.Iframe, String](tagRef, "name")
    val remote = TagRefAttribute[tag.Iframe, String](tagRef, "remote")
    val scrolling = TagRefAttribute[tag.Iframe, String](tagRef, "scrolling")
    val sandbox = TagRefAttribute[tag.Iframe, String](tagRef, "sandbox")
    val seamless = TagRefAttribute[tag.Iframe, Boolean](tagRef, "seamless")
    val src = TagRefAttribute[tag.Iframe, String](tagRef, "src")
    val srcdoc = TagRefAttribute[tag.Iframe, String](tagRef, "srcdoc")
    val width = TagRefAttribute[tag.Iframe, String](tagRef, "width")
  }

  implicit class TagAttributesImg(tag: Tag[pine.tag.Img]) {
    val `align vertical-align` = TagAttribute[pine.tag.Img, String](tag, "align vertical-align")
    val alt = TagAttribute[pine.tag.Img, String](tag, "alt")
    val border = TagAttribute[pine.tag.Img, String](tag, "border")
    val crossorigin = TagAttribute[pine.tag.Img, String](tag, "crossorigin")
    val height = TagAttribute[pine.tag.Img, String](tag, "height")
    val hspace = TagAttribute[pine.tag.Img, String](tag, "hspace")
    val ismap = TagAttribute[pine.tag.Img, Boolean](tag, "ismap")
    val longdesc = TagAttribute[pine.tag.Img, String](tag, "longdesc")
    val name = TagAttribute[pine.tag.Img, String](tag, "name")
    val sizes = TagAttribute[pine.tag.Img, String](tag, "sizes")
    val src = TagAttribute[pine.tag.Img, String](tag, "src")
    val srcset = TagAttribute[pine.tag.Img, String](tag, "srcset")
    val width = TagAttribute[pine.tag.Img, String](tag, "width")
    val usemap = TagAttribute[pine.tag.Img, String](tag, "usemap")
    val vspace = TagAttribute[pine.tag.Img, String](tag, "vspace")
  }

  implicit class TagRefAttributesImg(tagRef: TagRef[tag.Img]) {
    val `align vertical-align` = TagRefAttribute[tag.Img, String](tagRef, "align vertical-align")
    val alt = TagRefAttribute[tag.Img, String](tagRef, "alt")
    val border = TagRefAttribute[tag.Img, String](tagRef, "border")
    val crossorigin = TagRefAttribute[tag.Img, String](tagRef, "crossorigin")
    val height = TagRefAttribute[tag.Img, String](tagRef, "height")
    val hspace = TagRefAttribute[tag.Img, String](tagRef, "hspace")
    val ismap = TagRefAttribute[tag.Img, Boolean](tagRef, "ismap")
    val longdesc = TagRefAttribute[tag.Img, String](tagRef, "longdesc")
    val name = TagRefAttribute[tag.Img, String](tagRef, "name")
    val sizes = TagRefAttribute[tag.Img, String](tagRef, "sizes")
    val src = TagRefAttribute[tag.Img, String](tagRef, "src")
    val srcset = TagRefAttribute[tag.Img, String](tagRef, "srcset")
    val width = TagRefAttribute[tag.Img, String](tagRef, "width")
    val usemap = TagRefAttribute[tag.Img, String](tagRef, "usemap")
    val vspace = TagRefAttribute[tag.Img, String](tagRef, "vspace")
  }

  implicit class TagAttributesInput(tag: Tag[pine.tag.Input]) {
    val `type` = TagAttribute[pine.tag.Input, String](tag, "type")
    val accept = TagAttribute[pine.tag.Input, String](tag, "accept")
    val mozactionhint = TagAttribute[pine.tag.Input, String](tag, "mozactionhint")
    val autocapitalize = TagAttribute[pine.tag.Input, String](tag, "autocapitalize")
    val autocomplete = TagAttribute[pine.tag.Input, String](tag, "autocomplete")
    val autocorrect = TagAttribute[pine.tag.Input, String](tag, "autocorrect")
    val autofocus = TagAttribute[pine.tag.Input, Boolean](tag, "autofocus")
    val autosave = TagAttribute[pine.tag.Input, String](tag, "autosave")
    val checked = TagAttribute[pine.tag.Input, Boolean](tag, "checked")
    val disabled = TagAttribute[pine.tag.Input, Boolean](tag, "disabled")
    val form = TagAttribute[pine.tag.Input, String](tag, "form")
    val formaction = TagAttribute[pine.tag.Input, String](tag, "formaction")
    val formenctype = TagAttribute[pine.tag.Input, String](tag, "formenctype")
    val formmethod = TagAttribute[pine.tag.Input, String](tag, "formmethod")
    val formnovalidate = TagAttribute[pine.tag.Input, Boolean](tag, "formnovalidate")
    val formtarget = TagAttribute[pine.tag.Input, String](tag, "formtarget")
    val height = TagAttribute[pine.tag.Input, String](tag, "height")
    val incremental = TagAttribute[pine.tag.Input, String](tag, "incremental")
    val inputmode = TagAttribute[pine.tag.Input, String](tag, "inputmode")
    val list = TagAttribute[pine.tag.Input, String](tag, "list")
    val max = TagAttribute[pine.tag.Input, String](tag, "max")
    val maxlength = TagAttribute[pine.tag.Input, String](tag, "maxlength")
    val min = TagAttribute[pine.tag.Input, String](tag, "min")
    val minlength = TagAttribute[pine.tag.Input, String](tag, "minlength")
    val multiple = TagAttribute[pine.tag.Input, Boolean](tag, "multiple")
    val name = TagAttribute[pine.tag.Input, String](tag, "name")
    val pattern = TagAttribute[pine.tag.Input, String](tag, "pattern")
    val placeholder = TagAttribute[pine.tag.Input, String](tag, "placeholder")
    val readonly = TagAttribute[pine.tag.Input, Boolean](tag, "readonly")
    val required = TagAttribute[pine.tag.Input, Boolean](tag, "required")
    val results = TagAttribute[pine.tag.Input, String](tag, "results")
    val selectionDirection = TagAttribute[pine.tag.Input, String](tag, "selectionDirection")
    val size = TagAttribute[pine.tag.Input, Long](tag, "size")
    val src = TagAttribute[pine.tag.Input, String](tag, "src")
    val step = TagAttribute[pine.tag.Input, String](tag, "step")
    val usemap = TagAttribute[pine.tag.Input, String](tag, "usemap")
    val value = TagAttribute[pine.tag.Input, String](tag, "value")
    val width = TagAttribute[pine.tag.Input, String](tag, "width")
    val `x-moz-errormessage` = TagAttribute[pine.tag.Input, String](tag, "x-moz-errormessage")
  }

  implicit class TagRefAttributesInput(tagRef: TagRef[tag.Input]) {
    val `type` = TagRefAttribute[tag.Input, String](tagRef, "type")
    val accept = TagRefAttribute[tag.Input, String](tagRef, "accept")
    val accesskey = TagRefAttribute[tag.Input, String](tagRef, "accesskey")
    val mozactionhint = TagRefAttribute[tag.Input, String](tagRef, "mozactionhint")
    val autocapitalize = TagRefAttribute[tag.Input, String](tagRef, "autocapitalize")
    val autocomplete = TagRefAttribute[tag.Input, String](tagRef, "autocomplete")
    val autocorrect = TagRefAttribute[tag.Input, String](tagRef, "autocorrect")
    val autofocus = TagRefAttribute[tag.Input, Boolean](tagRef, "autofocus")
    val autosave = TagRefAttribute[tag.Input, String](tagRef, "autosave")
    val checked = TagRefAttribute[tag.Input, Boolean](tagRef, "checked")
    val disabled = TagRefAttribute[tag.Input, Boolean](tagRef, "disabled")
    val form = TagRefAttribute[tag.Input, String](tagRef, "form")
    val formaction = TagRefAttribute[tag.Input, String](tagRef, "formaction")
    val formenctype = TagRefAttribute[tag.Input, String](tagRef, "formenctype")
    val formmethod = TagRefAttribute[tag.Input, String](tagRef, "formmethod")
    val formnovalidate = TagRefAttribute[tag.Input, Boolean](tagRef, "formnovalidate")
    val formtarget = TagRefAttribute[tag.Input, String](tagRef, "formtarget")
    val height = TagRefAttribute[tag.Input, String](tagRef, "height")
    val incremental = TagRefAttribute[tag.Input, String](tagRef, "incremental")
    val inputmode = TagRefAttribute[tag.Input, String](tagRef, "inputmode")
    val list = TagRefAttribute[tag.Input, String](tagRef, "list")
    val max = TagRefAttribute[tag.Input, String](tagRef, "max")
    val maxlength = TagRefAttribute[tag.Input, String](tagRef, "maxlength")
    val min = TagRefAttribute[tag.Input, String](tagRef, "min")
    val minlength = TagRefAttribute[tag.Input, String](tagRef, "minlength")
    val multiple = TagRefAttribute[tag.Input, Boolean](tagRef, "multiple")
    val name = TagRefAttribute[tag.Input, String](tagRef, "name")
    val pattern = TagRefAttribute[tag.Input, String](tagRef, "pattern")
    val placeholder = TagRefAttribute[tag.Input, String](tagRef, "placeholder")
    val readonly = TagRefAttribute[tag.Input, Boolean](tagRef, "readonly")
    val required = TagRefAttribute[tag.Input, Boolean](tagRef, "required")
    val results = TagRefAttribute[tag.Input, String](tagRef, "results")
    val selectionDirection = TagRefAttribute[tag.Input, String](tagRef, "selectionDirection")
    val size = TagRefAttribute[tag.Input, Long](tagRef, "size")
    val spellcheck = TagRefAttribute[tag.Input, Boolean](tagRef, "spellcheck")
    val src = TagRefAttribute[tag.Input, String](tagRef, "src")
    val step = TagRefAttribute[tag.Input, String](tagRef, "step")
    val tabindex = TagRefAttribute[tag.Input, String](tagRef, "tabindex")
    val usemap = TagRefAttribute[tag.Input, String](tagRef, "usemap")
    val value = TagRefAttribute[tag.Input, String](tagRef, "value")
    val width = TagRefAttribute[tag.Input, String](tagRef, "width")
    val `x-moz-errormessage` = TagRefAttribute[tag.Input, String](tagRef, "x-moz-errormessage")
  }

  implicit class TagAttributesIns(tag: Tag[pine.tag.Ins]) {
    val cite = TagAttribute[pine.tag.Ins, String](tag, "cite")
    val datetime = TagAttribute[pine.tag.Ins, String](tag, "datetime")
  }

  implicit class TagRefAttributesIns(tagRef: TagRef[tag.Ins]) {
    val cite = TagRefAttribute[tag.Ins, String](tagRef, "cite")
    val datetime = TagRefAttribute[tag.Ins, String](tagRef, "datetime")
  }

  implicit class TagAttributesIsindex(tag: Tag[pine.tag.Isindex]) {
    val prompt = TagAttribute[pine.tag.Isindex, String](tag, "prompt")
    val action = TagAttribute[pine.tag.Isindex, String](tag, "action")
  }

  implicit class TagRefAttributesIsindex(tagRef: TagRef[tag.Isindex]) {
    val prompt = TagRefAttribute[tag.Isindex, String](tagRef, "prompt")
    val action = TagRefAttribute[tag.Isindex, String](tagRef, "action")
  }

  implicit class TagAttributesKeygen(tag: Tag[pine.tag.Keygen]) {
    val autofocus = TagAttribute[pine.tag.Keygen, Boolean](tag, "autofocus")
    val challenge = TagAttribute[pine.tag.Keygen, String](tag, "challenge")
    val disabled = TagAttribute[pine.tag.Keygen, Boolean](tag, "disabled")
    val form = TagAttribute[pine.tag.Keygen, String](tag, "form")
    val keytype = TagAttribute[pine.tag.Keygen, String](tag, "keytype")
    val name = TagAttribute[pine.tag.Keygen, String](tag, "name")
  }

  implicit class TagRefAttributesKeygen(tagRef: TagRef[tag.Keygen]) {
    val autofocus = TagRefAttribute[tag.Keygen, Boolean](tagRef, "autofocus")
    val challenge = TagRefAttribute[tag.Keygen, String](tagRef, "challenge")
    val disabled = TagRefAttribute[tag.Keygen, Boolean](tagRef, "disabled")
    val form = TagRefAttribute[tag.Keygen, String](tagRef, "form")
    val keytype = TagRefAttribute[tag.Keygen, String](tagRef, "keytype")
    val name = TagRefAttribute[tag.Keygen, String](tagRef, "name")
  }

  implicit class TagAttributesLabel(tag: Tag[pine.tag.Label]) {
    val `for` = TagAttribute[pine.tag.Label, String](tag, "for")
    val form = TagAttribute[pine.tag.Label, String](tag, "form")
  }

  implicit class TagRefAttributesLabel(tagRef: TagRef[tag.Label]) {
    val accesskey = TagRefAttribute[tag.Label, String](tagRef, "accesskey")
    val `for` = TagRefAttribute[tag.Label, String](tagRef, "for")
    val form = TagRefAttribute[tag.Label, String](tagRef, "form")
  }

  implicit class TagAttributesLi(tag: Tag[pine.tag.Li]) {
    val value = TagAttribute[pine.tag.Li, Long](tag, "value")
    val `type` = TagAttribute[pine.tag.Li, String](tag, "type")
  }

  implicit class TagRefAttributesLi(tagRef: TagRef[tag.Li]) {
    val value = TagRefAttribute[tag.Li, Long](tagRef, "value")
    val `type` = TagRefAttribute[tag.Li, String](tagRef, "type")
  }

  implicit class TagAttributesLink(tag: Tag[pine.tag.Link]) {
    val charset = TagAttribute[pine.tag.Link, String](tag, "charset")
    val crossorigin = TagAttribute[pine.tag.Link, String](tag, "crossorigin")
    val disabled = TagAttribute[pine.tag.Link, Boolean](tag, "disabled")
    val href = TagAttribute[pine.tag.Link, String](tag, "href")
    val hreflang = TagAttribute[pine.tag.Link, String](tag, "hreflang")
    val media = TagAttribute[pine.tag.Link, String](tag, "media")
    val methods = TagAttribute[pine.tag.Link, String](tag, "methods")
    val rel = TagAttribute[pine.tag.Link, String](tag, "rel")
    val rev = TagAttribute[pine.tag.Link, String](tag, "rev")
    val sizes = TagAttribute[pine.tag.Link, String](tag, "sizes")
    val target = TagAttribute[pine.tag.Link, String](tag, "target")
    val `type` = TagAttribute[pine.tag.Link, String](tag, "type")
    val integrity = TagAttribute[pine.tag.Link, String](tag, "integrity")
  }

  implicit class TagRefAttributesLink(tagRef: TagRef[tag.Link]) {
    val charset = TagRefAttribute[tag.Link, String](tagRef, "charset")
    val crossorigin = TagRefAttribute[tag.Link, String](tagRef, "crossorigin")
    val disabled = TagRefAttribute[tag.Link, Boolean](tagRef, "disabled")
    val href = TagRefAttribute[tag.Link, String](tagRef, "href")
    val hreflang = TagRefAttribute[tag.Link, String](tagRef, "hreflang")
    val media = TagRefAttribute[tag.Link, String](tagRef, "media")
    val methods = TagRefAttribute[tag.Link, String](tagRef, "methods")
    val rel = TagRefAttribute[tag.Link, String](tagRef, "rel")
    val rev = TagRefAttribute[tag.Link, String](tagRef, "rev")
    val sizes = TagRefAttribute[tag.Link, String](tagRef, "sizes")
    val target = TagRefAttribute[tag.Link, String](tagRef, "target")
    val `type` = TagRefAttribute[tag.Link, String](tagRef, "type")
    val integrity = TagRefAttribute[tag.Link, String](tagRef, "integrity")
  }

  implicit class TagAttributesMap(tag: Tag[pine.tag.Map]) {
    val name = TagAttribute[pine.tag.Map, String](tag, "name")
  }

  implicit class TagRefAttributesMap(tagRef: TagRef[tag.Map]) {
    val name = TagRefAttribute[tag.Map, String](tagRef, "name")
  }

  implicit class TagAttributesMenu(tag: Tag[pine.tag.Menu]) {
    val label = TagAttribute[pine.tag.Menu, String](tag, "label")
    val `type` = TagAttribute[pine.tag.Menu, String](tag, "type")
  }

  implicit class TagRefAttributesMenu(tagRef: TagRef[tag.Menu]) {
    val label = TagRefAttribute[tag.Menu, String](tagRef, "label")
    val `type` = TagRefAttribute[tag.Menu, String](tagRef, "type")
  }

  implicit class TagAttributesMenuitem(tag: Tag[pine.tag.Menuitem]) {
    val checked = TagAttribute[pine.tag.Menuitem, Boolean](tag, "checked")
    val command = TagAttribute[pine.tag.Menuitem, String](tag, "command")
    val default = TagAttribute[pine.tag.Menuitem, Boolean](tag, "default")
    val disabled = TagAttribute[pine.tag.Menuitem, Boolean](tag, "disabled")
    val icon = TagAttribute[pine.tag.Menuitem, String](tag, "icon")
    val label = TagAttribute[pine.tag.Menuitem, String](tag, "label")
    val radiogroup = TagAttribute[pine.tag.Menuitem, String](tag, "radiogroup")
    val `type` = TagAttribute[pine.tag.Menuitem, String](tag, "type")
  }

  implicit class TagRefAttributesMenuitem(tagRef: TagRef[tag.Menuitem]) {
    val checked = TagRefAttribute[tag.Menuitem, Boolean](tagRef, "checked")
    val command = TagRefAttribute[tag.Menuitem, String](tagRef, "command")
    val default = TagRefAttribute[tag.Menuitem, Boolean](tagRef, "default")
    val disabled = TagRefAttribute[tag.Menuitem, Boolean](tagRef, "disabled")
    val icon = TagRefAttribute[tag.Menuitem, String](tagRef, "icon")
    val label = TagRefAttribute[tag.Menuitem, String](tagRef, "label")
    val radiogroup = TagRefAttribute[tag.Menuitem, String](tagRef, "radiogroup")
    val `type` = TagRefAttribute[tag.Menuitem, String](tagRef, "type")
  }

  implicit class TagAttributesMeta(tag: Tag[pine.tag.Meta]) {
    val charset = TagAttribute[pine.tag.Meta, String](tag, "charset")
    val content = TagAttribute[pine.tag.Meta, String](tag, "content")
    val `http-equiv` = TagAttribute[pine.tag.Meta, String](tag, "http-equiv")
    val name = TagAttribute[pine.tag.Meta, String](tag, "name")
    val scheme = TagAttribute[pine.tag.Meta, String](tag, "scheme")
  }

  implicit class TagRefAttributesMeta(tagRef: TagRef[tag.Meta]) {
    val charset = TagRefAttribute[tag.Meta, String](tagRef, "charset")
    val content = TagRefAttribute[tag.Meta, String](tagRef, "content")
    val `http-equiv` = TagRefAttribute[tag.Meta, String](tagRef, "http-equiv")
    val name = TagRefAttribute[tag.Meta, String](tagRef, "name")
    val scheme = TagRefAttribute[tag.Meta, String](tagRef, "scheme")
  }

  implicit class TagAttributesMeter(tag: Tag[pine.tag.Meter]) {
    val value = TagAttribute[pine.tag.Meter, String](tag, "value")
    val min = TagAttribute[pine.tag.Meter, Double](tag, "min")
    val max = TagAttribute[pine.tag.Meter, Double](tag, "max")
    val low = TagAttribute[pine.tag.Meter, Double](tag, "low")
    val high = TagAttribute[pine.tag.Meter, Double](tag, "high")
    val optimum = TagAttribute[pine.tag.Meter, Double](tag, "optimum")
    val form = TagAttribute[pine.tag.Meter, String](tag, "form")
  }

  implicit class TagRefAttributesMeter(tagRef: TagRef[tag.Meter]) {
    val value = TagRefAttribute[tag.Meter, String](tagRef, "value")
    val min = TagRefAttribute[tag.Meter, Double](tagRef, "min")
    val max = TagRefAttribute[tag.Meter, Double](tagRef, "max")
    val low = TagRefAttribute[tag.Meter, Double](tagRef, "low")
    val high = TagRefAttribute[tag.Meter, Double](tagRef, "high")
    val optimum = TagRefAttribute[tag.Meter, Double](tagRef, "optimum")
    val form = TagRefAttribute[tag.Meter, String](tagRef, "form")
  }

  implicit class TagAttributesObject(tag: Tag[pine.tag.Object]) {
    val archive = TagAttribute[pine.tag.Object, String](tag, "archive")
    val border = TagAttribute[pine.tag.Object, String](tag, "border")
    val classid = TagAttribute[pine.tag.Object, String](tag, "classid")
    val codebase = TagAttribute[pine.tag.Object, String](tag, "codebase")
    val codetype = TagAttribute[pine.tag.Object, String](tag, "codetype")
    val data = TagAttribute[pine.tag.Object, String](tag, "data")
    val declare = TagAttribute[pine.tag.Object, Boolean](tag, "declare")
    val form = TagAttribute[pine.tag.Object, String](tag, "form")
    val height = TagAttribute[pine.tag.Object, String](tag, "height")
    val name = TagAttribute[pine.tag.Object, String](tag, "name")
    val standby = TagAttribute[pine.tag.Object, String](tag, "standby")
    val `type` = TagAttribute[pine.tag.Object, String](tag, "type")
    val typemustmatch = TagAttribute[pine.tag.Object, Boolean](tag, "typemustmatch")
    val usemap = TagAttribute[pine.tag.Object, String](tag, "usemap")
    val width = TagAttribute[pine.tag.Object, String](tag, "width")
  }

  implicit class TagRefAttributesObject(tagRef: TagRef[tag.Object]) {
    val archive = TagRefAttribute[tag.Object, String](tagRef, "archive")
    val border = TagRefAttribute[tag.Object, String](tagRef, "border")
    val classid = TagRefAttribute[tag.Object, String](tagRef, "classid")
    val codebase = TagRefAttribute[tag.Object, String](tagRef, "codebase")
    val codetype = TagRefAttribute[tag.Object, String](tagRef, "codetype")
    val data = TagRefAttribute[tag.Object, String](tagRef, "data")
    val declare = TagRefAttribute[tag.Object, Boolean](tagRef, "declare")
    val form = TagRefAttribute[tag.Object, String](tagRef, "form")
    val height = TagRefAttribute[tag.Object, String](tagRef, "height")
    val name = TagRefAttribute[tag.Object, String](tagRef, "name")
    val standby = TagRefAttribute[tag.Object, String](tagRef, "standby")
    val tabindex = TagRefAttribute[tag.Object, String](tagRef, "tabindex")
    val `type` = TagRefAttribute[tag.Object, String](tagRef, "type")
    val typemustmatch = TagRefAttribute[tag.Object, Boolean](tagRef, "typemustmatch")
    val usemap = TagRefAttribute[tag.Object, String](tagRef, "usemap")
    val width = TagRefAttribute[tag.Object, String](tagRef, "width")
  }

  implicit class TagAttributesOl(tag: Tag[pine.tag.Ol]) {
    val compact = TagAttribute[pine.tag.Ol, Boolean](tag, "compact")
    val reversed = TagAttribute[pine.tag.Ol, Boolean](tag, "reversed")
    val start = TagAttribute[pine.tag.Ol, String](tag, "start")
    val `type` = TagAttribute[pine.tag.Ol, String](tag, "type")
  }

  implicit class TagRefAttributesOl(tagRef: TagRef[tag.Ol]) {
    val compact = TagRefAttribute[tag.Ol, Boolean](tagRef, "compact")
    val reversed = TagRefAttribute[tag.Ol, Boolean](tagRef, "reversed")
    val start = TagRefAttribute[tag.Ol, String](tagRef, "start")
    val `type` = TagRefAttribute[tag.Ol, String](tagRef, "type")
  }

  implicit class TagAttributesOptgroup(tag: Tag[pine.tag.Optgroup]) {
    val disabled = TagAttribute[pine.tag.Optgroup, Boolean](tag, "disabled")
    val label = TagAttribute[pine.tag.Optgroup, String](tag, "label")
  }

  implicit class TagRefAttributesOptgroup(tagRef: TagRef[tag.Optgroup]) {
    val disabled = TagRefAttribute[tag.Optgroup, Boolean](tagRef, "disabled")
    val label = TagRefAttribute[tag.Optgroup, String](tagRef, "label")
  }

  implicit class TagAttributesOption(tag: Tag[pine.tag.Option]) {
    val disabled = TagAttribute[pine.tag.Option, Boolean](tag, "disabled")
    val label = TagAttribute[pine.tag.Option, String](tag, "label")
    val selected = TagAttribute[pine.tag.Option, Boolean](tag, "selected")
    val value = TagAttribute[pine.tag.Option, String](tag, "value")
  }

  implicit class TagRefAttributesOption(tagRef: TagRef[tag.Option]) {
    val disabled = TagRefAttribute[tag.Option, Boolean](tagRef, "disabled")
    val label = TagRefAttribute[tag.Option, String](tagRef, "label")
    val selected = TagRefAttribute[tag.Option, Boolean](tagRef, "selected")
    val value = TagRefAttribute[tag.Option, String](tagRef, "value")
  }

  implicit class TagAttributesOutput(tag: Tag[pine.tag.Output]) {
    val `for` = TagAttribute[pine.tag.Output, String](tag, "for")
    val form = TagAttribute[pine.tag.Output, String](tag, "form")
    val name = TagAttribute[pine.tag.Output, String](tag, "name")
  }

  implicit class TagRefAttributesOutput(tagRef: TagRef[tag.Output]) {
    val `for` = TagRefAttribute[tag.Output, String](tagRef, "for")
    val form = TagRefAttribute[tag.Output, String](tagRef, "form")
    val name = TagRefAttribute[tag.Output, String](tagRef, "name")
  }

  implicit class TagAttributesParam(tag: Tag[pine.tag.Param]) {
    val name = TagAttribute[pine.tag.Param, String](tag, "name")
    val `type` = TagAttribute[pine.tag.Param, String](tag, "type")
    val value = TagAttribute[pine.tag.Param, String](tag, "value")
    val valuetype = TagAttribute[pine.tag.Param, String](tag, "valuetype")
  }

  implicit class TagRefAttributesParam(tagRef: TagRef[tag.Param]) {
    val name = TagRefAttribute[tag.Param, String](tagRef, "name")
    val `type` = TagRefAttribute[tag.Param, String](tagRef, "type")
    val value = TagRefAttribute[tag.Param, String](tagRef, "value")
    val valuetype = TagRefAttribute[tag.Param, String](tagRef, "valuetype")
  }

  implicit class TagAttributesPre(tag: Tag[pine.tag.Pre]) {
    val cols = TagAttribute[pine.tag.Pre, String](tag, "cols")
    val width = TagAttribute[pine.tag.Pre, String](tag, "width")
    val wrap = TagAttribute[pine.tag.Pre, String](tag, "wrap")
  }

  implicit class TagRefAttributesPre(tagRef: TagRef[tag.Pre]) {
    val cols = TagRefAttribute[tag.Pre, String](tagRef, "cols")
    val width = TagRefAttribute[tag.Pre, String](tagRef, "width")
    val wrap = TagRefAttribute[tag.Pre, String](tagRef, "wrap")
  }

  implicit class TagAttributesProgress(tag: Tag[pine.tag.Progress]) {
    val max = TagAttribute[pine.tag.Progress, String](tag, "max")
    val value = TagAttribute[pine.tag.Progress, String](tag, "value")
  }

  implicit class TagRefAttributesProgress(tagRef: TagRef[tag.Progress]) {
    val max = TagRefAttribute[tag.Progress, String](tagRef, "max")
    val value = TagRefAttribute[tag.Progress, String](tagRef, "value")
  }

  implicit class TagAttributesScript(tag: Tag[pine.tag.Script]) {
    val async = TagAttribute[pine.tag.Script, Boolean](tag, "async")
    val src = TagAttribute[pine.tag.Script, String](tag, "src")
    val `type` = TagAttribute[pine.tag.Script, String](tag, "type")
    val language = TagAttribute[pine.tag.Script, String](tag, "language")
    val defer = TagAttribute[pine.tag.Script, Boolean](tag, "defer")
    val crossorigin = TagAttribute[pine.tag.Script, String](tag, "crossorigin")
    val integrity = TagAttribute[pine.tag.Script, String](tag, "integrity")
  }

  implicit class TagRefAttributesScript(tagRef: TagRef[tag.Script]) {
    val async = TagRefAttribute[tag.Script, Boolean](tagRef, "async")
    val src = TagRefAttribute[tag.Script, String](tagRef, "src")
    val `type` = TagRefAttribute[tag.Script, String](tagRef, "type")
    val language = TagRefAttribute[tag.Script, String](tagRef, "language")
    val defer = TagRefAttribute[tag.Script, Boolean](tagRef, "defer")
    val crossorigin = TagRefAttribute[tag.Script, String](tagRef, "crossorigin")
    val integrity = TagRefAttribute[tag.Script, String](tagRef, "integrity")
  }

  implicit class TagAttributesSelect(tag: Tag[pine.tag.Select]) {
    val autofocus = TagAttribute[pine.tag.Select, Boolean](tag, "autofocus")
    val disabled = TagAttribute[pine.tag.Select, Boolean](tag, "disabled")
    val form = TagAttribute[pine.tag.Select, String](tag, "form")
    val multiple = TagAttribute[pine.tag.Select, Boolean](tag, "multiple")
    val name = TagAttribute[pine.tag.Select, String](tag, "name")
    val required = TagAttribute[pine.tag.Select, Boolean](tag, "required")
    val size = TagAttribute[pine.tag.Select, String](tag, "size")
  }

  implicit class TagRefAttributesSelect(tagRef: TagRef[tag.Select]) {
    val autofocus = TagRefAttribute[tag.Select, Boolean](tagRef, "autofocus")
    val disabled = TagRefAttribute[tag.Select, Boolean](tagRef, "disabled")
    val form = TagRefAttribute[tag.Select, String](tagRef, "form")
    val multiple = TagRefAttribute[tag.Select, Boolean](tagRef, "multiple")
    val name = TagRefAttribute[tag.Select, String](tagRef, "name")
    val required = TagRefAttribute[tag.Select, Boolean](tagRef, "required")
    val size = TagRefAttribute[tag.Select, String](tagRef, "size")
  }

  implicit class TagAttributesSource(tag: Tag[pine.tag.Source]) {
    val sizes = TagAttribute[pine.tag.Source, String](tag, "sizes")
    val src = TagAttribute[pine.tag.Source, String](tag, "src")
    val srcset = TagAttribute[pine.tag.Source, String](tag, "srcset")
    val `type` = TagAttribute[pine.tag.Source, String](tag, "type")
    val media = TagAttribute[pine.tag.Source, String](tag, "media")
  }

  implicit class TagRefAttributesSource(tagRef: TagRef[tag.Source]) {
    val sizes = TagRefAttribute[tag.Source, String](tagRef, "sizes")
    val src = TagRefAttribute[tag.Source, String](tagRef, "src")
    val srcset = TagRefAttribute[tag.Source, String](tagRef, "srcset")
    val `type` = TagRefAttribute[tag.Source, String](tagRef, "type")
    val media = TagRefAttribute[tag.Source, String](tagRef, "media")
  }

  implicit class TagAttributesSpacer(tag: Tag[pine.tag.Spacer]) {
    val `type` = TagAttribute[pine.tag.Spacer, String](tag, "type")
    val size = TagAttribute[pine.tag.Spacer, String](tag, "size")
    val width = TagAttribute[pine.tag.Spacer, String](tag, "width")
    val height = TagAttribute[pine.tag.Spacer, String](tag, "height")
    val align = TagAttribute[pine.tag.Spacer, String](tag, "align")
  }

  implicit class TagRefAttributesSpacer(tagRef: TagRef[tag.Spacer]) {
    val `type` = TagRefAttribute[tag.Spacer, String](tagRef, "type")
    val size = TagRefAttribute[tag.Spacer, String](tagRef, "size")
    val width = TagRefAttribute[tag.Spacer, String](tagRef, "width")
    val height = TagRefAttribute[tag.Spacer, String](tagRef, "height")
    val align = TagRefAttribute[tag.Spacer, String](tagRef, "align")
  }

  implicit class TagAttributesStyle(tag: Tag[pine.tag.Style]) {
    val `type` = TagAttribute[pine.tag.Style, String](tag, "type")
    val media = TagAttribute[pine.tag.Style, String](tag, "media")
    val scoped = TagAttribute[pine.tag.Style, Boolean](tag, "scoped")
    val disabled = TagAttribute[pine.tag.Style, Boolean](tag, "disabled")
  }

  implicit class TagRefAttributesStyle(tagRef: TagRef[tag.Style]) {
    val `type` = TagRefAttribute[tag.Style, String](tagRef, "type")
    val media = TagRefAttribute[tag.Style, String](tagRef, "media")
    val scoped = TagRefAttribute[tag.Style, Boolean](tagRef, "scoped")
    val title = TagRefAttribute[tag.Style, String](tagRef, "title")
    val disabled = TagRefAttribute[tag.Style, Boolean](tagRef, "disabled")
  }

  implicit class TagAttributesTable(tag: Tag[pine.tag.Table]) {
    val align = TagAttribute[pine.tag.Table, String](tag, "align")
    val bgcolor = TagAttribute[pine.tag.Table, String](tag, "bgcolor")
    val border = TagAttribute[pine.tag.Table, String](tag, "border")
    val cellpadding = TagAttribute[pine.tag.Table, String](tag, "cellpadding")
    val cellspacing = TagAttribute[pine.tag.Table, String](tag, "cellspacing")
    val frame = TagAttribute[pine.tag.Table, String](tag, "frame")
    val rules = TagAttribute[pine.tag.Table, String](tag, "rules")
    val summary = TagAttribute[pine.tag.Table, String](tag, "summary")
    val width = TagAttribute[pine.tag.Table, String](tag, "width")
  }

  implicit class TagRefAttributesTable(tagRef: TagRef[tag.Table]) {
    val align = TagRefAttribute[tag.Table, String](tagRef, "align")
    val bgcolor = TagRefAttribute[tag.Table, String](tagRef, "bgcolor")
    val border = TagRefAttribute[tag.Table, String](tagRef, "border")
    val cellpadding = TagRefAttribute[tag.Table, String](tagRef, "cellpadding")
    val cellspacing = TagRefAttribute[tag.Table, String](tagRef, "cellspacing")
    val frame = TagRefAttribute[tag.Table, String](tagRef, "frame")
    val rules = TagRefAttribute[tag.Table, String](tagRef, "rules")
    val summary = TagRefAttribute[tag.Table, String](tagRef, "summary")
    val width = TagRefAttribute[tag.Table, String](tagRef, "width")
  }

  implicit class TagAttributesTbody(tag: Tag[pine.tag.Tbody]) {
    val align = TagAttribute[pine.tag.Tbody, String](tag, "align")
    val bgcolor = TagAttribute[pine.tag.Tbody, String](tag, "bgcolor")
    val char = TagAttribute[pine.tag.Tbody, String](tag, "char")
    val charoff = TagAttribute[pine.tag.Tbody, String](tag, "charoff")
    val valign = TagAttribute[pine.tag.Tbody, String](tag, "valign")
  }

  implicit class TagRefAttributesTbody(tagRef: TagRef[tag.Tbody]) {
    val align = TagRefAttribute[tag.Tbody, String](tagRef, "align")
    val bgcolor = TagRefAttribute[tag.Tbody, String](tagRef, "bgcolor")
    val char = TagRefAttribute[tag.Tbody, String](tagRef, "char")
    val charoff = TagRefAttribute[tag.Tbody, String](tagRef, "charoff")
    val valign = TagRefAttribute[tag.Tbody, String](tagRef, "valign")
  }

  implicit class TagAttributesTd(tag: Tag[pine.tag.Td]) {
    val abbr = TagAttribute[pine.tag.Td, String](tag, "abbr")
    val align = TagAttribute[pine.tag.Td, String](tag, "align")
    val axis = TagAttribute[pine.tag.Td, String](tag, "axis")
    val bgcolor = TagAttribute[pine.tag.Td, String](tag, "bgcolor")
    val char = TagAttribute[pine.tag.Td, String](tag, "char")
    val charoff = TagAttribute[pine.tag.Td, String](tag, "charoff")
    val colspan = TagAttribute[pine.tag.Td, String](tag, "colspan")
    val headers = TagAttribute[pine.tag.Td, String](tag, "headers")
    val rowspan = TagAttribute[pine.tag.Td, String](tag, "rowspan")
    val scope = TagAttribute[pine.tag.Td, String](tag, "scope")
    val valign = TagAttribute[pine.tag.Td, String](tag, "valign")
    val width = TagAttribute[pine.tag.Td, String](tag, "width")
  }

  implicit class TagRefAttributesTd(tagRef: TagRef[tag.Td]) {
    val abbr = TagRefAttribute[tag.Td, String](tagRef, "abbr")
    val align = TagRefAttribute[tag.Td, String](tagRef, "align")
    val axis = TagRefAttribute[tag.Td, String](tagRef, "axis")
    val bgcolor = TagRefAttribute[tag.Td, String](tagRef, "bgcolor")
    val char = TagRefAttribute[tag.Td, String](tagRef, "char")
    val charoff = TagRefAttribute[tag.Td, String](tagRef, "charoff")
    val colspan = TagRefAttribute[tag.Td, String](tagRef, "colspan")
    val headers = TagRefAttribute[tag.Td, String](tagRef, "headers")
    val rowspan = TagRefAttribute[tag.Td, String](tagRef, "rowspan")
    val scope = TagRefAttribute[tag.Td, String](tagRef, "scope")
    val valign = TagRefAttribute[tag.Td, String](tagRef, "valign")
    val width = TagRefAttribute[tag.Td, String](tagRef, "width")
  }

  implicit class TagAttributesTextarea(tag: Tag[pine.tag.Textarea]) {
    val autocapitalize = TagAttribute[pine.tag.Textarea, String](tag, "autocapitalize")
    val autocomplete = TagAttribute[pine.tag.Textarea, String](tag, "autocomplete")
    val autofocus = TagAttribute[pine.tag.Textarea, Boolean](tag, "autofocus")
    val cols = TagAttribute[pine.tag.Textarea, String](tag, "cols")
    val disabled = TagAttribute[pine.tag.Textarea, Boolean](tag, "disabled")
    val form = TagAttribute[pine.tag.Textarea, String](tag, "form")
    val maxlength = TagAttribute[pine.tag.Textarea, String](tag, "maxlength")
    val minlength = TagAttribute[pine.tag.Textarea, String](tag, "minlength")
    val name = TagAttribute[pine.tag.Textarea, String](tag, "name")
    val placeholder = TagAttribute[pine.tag.Textarea, String](tag, "placeholder")
    val readonly = TagAttribute[pine.tag.Textarea, Boolean](tag, "readonly")
    val required = TagAttribute[pine.tag.Textarea, Boolean](tag, "required")
    val rows = TagAttribute[pine.tag.Textarea, String](tag, "rows")
    val selectionDirection = TagAttribute[pine.tag.Textarea, String](tag, "selectionDirection")
    val selectionEnd = TagAttribute[pine.tag.Textarea, String](tag, "selectionEnd")
    val selectionStart = TagAttribute[pine.tag.Textarea, String](tag, "selectionStart")
    val wrap = TagAttribute[pine.tag.Textarea, String](tag, "wrap")
  }

  implicit class TagRefAttributesTextarea(tagRef: TagRef[tag.Textarea]) {
    val autocapitalize = TagRefAttribute[tag.Textarea, String](tagRef, "autocapitalize")
    val autocomplete = TagRefAttribute[tag.Textarea, String](tagRef, "autocomplete")
    val autofocus = TagRefAttribute[tag.Textarea, Boolean](tagRef, "autofocus")
    val cols = TagRefAttribute[tag.Textarea, String](tagRef, "cols")
    val disabled = TagRefAttribute[tag.Textarea, Boolean](tagRef, "disabled")
    val form = TagRefAttribute[tag.Textarea, String](tagRef, "form")
    val maxlength = TagRefAttribute[tag.Textarea, String](tagRef, "maxlength")
    val minlength = TagRefAttribute[tag.Textarea, String](tagRef, "minlength")
    val name = TagRefAttribute[tag.Textarea, String](tagRef, "name")
    val placeholder = TagRefAttribute[tag.Textarea, String](tagRef, "placeholder")
    val readonly = TagRefAttribute[tag.Textarea, Boolean](tagRef, "readonly")
    val required = TagRefAttribute[tag.Textarea, Boolean](tagRef, "required")
    val rows = TagRefAttribute[tag.Textarea, String](tagRef, "rows")
    val selectionDirection = TagRefAttribute[tag.Textarea, String](tagRef, "selectionDirection")
    val selectionEnd = TagRefAttribute[tag.Textarea, String](tagRef, "selectionEnd")
    val selectionStart = TagRefAttribute[tag.Textarea, String](tagRef, "selectionStart")
    val spellcheck = TagRefAttribute[tag.Textarea, Boolean](tagRef, "spellcheck")
    val wrap = TagRefAttribute[tag.Textarea, String](tagRef, "wrap")
  }

  implicit class TagAttributesTfoot(tag: Tag[pine.tag.Tfoot]) {
    val align = TagAttribute[pine.tag.Tfoot, String](tag, "align")
    val bgcolor = TagAttribute[pine.tag.Tfoot, String](tag, "bgcolor")
    val char = TagAttribute[pine.tag.Tfoot, String](tag, "char")
    val charoff = TagAttribute[pine.tag.Tfoot, String](tag, "charoff")
    val valign = TagAttribute[pine.tag.Tfoot, String](tag, "valign")
  }

  implicit class TagRefAttributesTfoot(tagRef: TagRef[tag.Tfoot]) {
    val align = TagRefAttribute[tag.Tfoot, String](tagRef, "align")
    val bgcolor = TagRefAttribute[tag.Tfoot, String](tagRef, "bgcolor")
    val char = TagRefAttribute[tag.Tfoot, String](tagRef, "char")
    val charoff = TagRefAttribute[tag.Tfoot, String](tagRef, "charoff")
    val valign = TagRefAttribute[tag.Tfoot, String](tagRef, "valign")
  }

  implicit class TagAttributesTh(tag: Tag[pine.tag.Th]) {
    val abbr = TagAttribute[pine.tag.Th, String](tag, "abbr")
    val align = TagAttribute[pine.tag.Th, String](tag, "align")
    val axis = TagAttribute[pine.tag.Th, String](tag, "axis")
    val bgcolor = TagAttribute[pine.tag.Th, String](tag, "bgcolor")
    val char = TagAttribute[pine.tag.Th, String](tag, "char")
    val charoff = TagAttribute[pine.tag.Th, String](tag, "charoff")
    val colspan = TagAttribute[pine.tag.Th, String](tag, "colspan")
    val headers = TagAttribute[pine.tag.Th, String](tag, "headers")
    val rowspan = TagAttribute[pine.tag.Th, String](tag, "rowspan")
    val scope = TagAttribute[pine.tag.Th, String](tag, "scope")
    val valign = TagAttribute[pine.tag.Th, String](tag, "valign")
    val width = TagAttribute[pine.tag.Th, String](tag, "width")
  }

  implicit class TagRefAttributesTh(tagRef: TagRef[tag.Th]) {
    val abbr = TagRefAttribute[tag.Th, String](tagRef, "abbr")
    val align = TagRefAttribute[tag.Th, String](tagRef, "align")
    val axis = TagRefAttribute[tag.Th, String](tagRef, "axis")
    val bgcolor = TagRefAttribute[tag.Th, String](tagRef, "bgcolor")
    val char = TagRefAttribute[tag.Th, String](tagRef, "char")
    val charoff = TagRefAttribute[tag.Th, String](tagRef, "charoff")
    val colspan = TagRefAttribute[tag.Th, String](tagRef, "colspan")
    val headers = TagRefAttribute[tag.Th, String](tagRef, "headers")
    val rowspan = TagRefAttribute[tag.Th, String](tagRef, "rowspan")
    val scope = TagRefAttribute[tag.Th, String](tagRef, "scope")
    val valign = TagRefAttribute[tag.Th, String](tagRef, "valign")
    val width = TagRefAttribute[tag.Th, String](tagRef, "width")
  }

  implicit class TagAttributesThead(tag: Tag[pine.tag.Thead]) {
    val align = TagAttribute[pine.tag.Thead, String](tag, "align")
    val bgcolor = TagAttribute[pine.tag.Thead, String](tag, "bgcolor")
    val char = TagAttribute[pine.tag.Thead, String](tag, "char")
    val charoff = TagAttribute[pine.tag.Thead, String](tag, "charoff")
    val valign = TagAttribute[pine.tag.Thead, String](tag, "valign")
  }

  implicit class TagRefAttributesThead(tagRef: TagRef[tag.Thead]) {
    val align = TagRefAttribute[tag.Thead, String](tagRef, "align")
    val bgcolor = TagRefAttribute[tag.Thead, String](tagRef, "bgcolor")
    val char = TagRefAttribute[tag.Thead, String](tagRef, "char")
    val charoff = TagRefAttribute[tag.Thead, String](tagRef, "charoff")
    val valign = TagRefAttribute[tag.Thead, String](tagRef, "valign")
  }

  implicit class TagAttributesTr(tag: Tag[pine.tag.Tr]) {
    val align = TagAttribute[pine.tag.Tr, String](tag, "align")
    val bgcolor = TagAttribute[pine.tag.Tr, String](tag, "bgcolor")
    val char = TagAttribute[pine.tag.Tr, String](tag, "char")
    val charoff = TagAttribute[pine.tag.Tr, String](tag, "charoff")
    val valign = TagAttribute[pine.tag.Tr, String](tag, "valign")
  }

  implicit class TagRefAttributesTr(tagRef: TagRef[tag.Tr]) {
    val align = TagRefAttribute[tag.Tr, String](tagRef, "align")
    val bgcolor = TagRefAttribute[tag.Tr, String](tagRef, "bgcolor")
    val char = TagRefAttribute[tag.Tr, String](tagRef, "char")
    val charoff = TagRefAttribute[tag.Tr, String](tagRef, "charoff")
    val valign = TagRefAttribute[tag.Tr, String](tagRef, "valign")
  }

  implicit class TagAttributesTrack(tag: Tag[pine.tag.Track]) {
    val default = TagAttribute[pine.tag.Track, Boolean](tag, "default")
    val kind = TagAttribute[pine.tag.Track, String](tag, "kind")
    val label = TagAttribute[pine.tag.Track, String](tag, "label")
    val src = TagAttribute[pine.tag.Track, String](tag, "src")
    val srclang = TagAttribute[pine.tag.Track, String](tag, "srclang")
  }

  implicit class TagRefAttributesTrack(tagRef: TagRef[tag.Track]) {
    val default = TagRefAttribute[tag.Track, Boolean](tagRef, "default")
    val kind = TagRefAttribute[tag.Track, String](tagRef, "kind")
    val label = TagRefAttribute[tag.Track, String](tagRef, "label")
    val src = TagRefAttribute[tag.Track, String](tagRef, "src")
    val srclang = TagRefAttribute[tag.Track, String](tagRef, "srclang")
  }

  implicit class TagAttributesUl(tag: Tag[pine.tag.Ul]) {
    val compact = TagAttribute[pine.tag.Ul, Boolean](tag, "compact")
    val `type` = TagAttribute[pine.tag.Ul, String](tag, "type")
  }

  implicit class TagRefAttributesUl(tagRef: TagRef[tag.Ul]) {
    val compact = TagRefAttribute[tag.Ul, Boolean](tagRef, "compact")
    val `type` = TagRefAttribute[tag.Ul, String](tagRef, "type")
  }

  implicit class TagAttributesVideo(tag: Tag[pine.tag.Video]) {
    val autoplay = TagAttribute[pine.tag.Video, Boolean](tag, "autoplay")
    val autobuffer = TagAttribute[pine.tag.Video, String](tag, "autobuffer")
    val buffered = TagAttribute[pine.tag.Video, String](tag, "buffered")
    val controls = TagAttribute[pine.tag.Video, Boolean](tag, "controls")
    val crossorigin = TagAttribute[pine.tag.Video, String](tag, "crossorigin")
    val height = TagAttribute[pine.tag.Video, String](tag, "height")
    val loop = TagAttribute[pine.tag.Video, Boolean](tag, "loop")
    val muted = TagAttribute[pine.tag.Video, Boolean](tag, "muted")
    val played = TagAttribute[pine.tag.Video, String](tag, "played")
    val preload = TagAttribute[pine.tag.Video, String](tag, "preload")
    val poster = TagAttribute[pine.tag.Video, String](tag, "poster")
    val src = TagAttribute[pine.tag.Video, String](tag, "src")
    val width = TagAttribute[pine.tag.Video, String](tag, "width")
  }

  implicit class TagRefAttributesVideo(tagRef: TagRef[tag.Video]) {
    val autoplay = TagRefAttribute[tag.Video, Boolean](tagRef, "autoplay")
    val autobuffer = TagRefAttribute[tag.Video, String](tagRef, "autobuffer")
    val buffered = TagRefAttribute[tag.Video, String](tagRef, "buffered")
    val controls = TagRefAttribute[tag.Video, Boolean](tagRef, "controls")
    val crossorigin = TagRefAttribute[tag.Video, String](tagRef, "crossorigin")
    val height = TagRefAttribute[tag.Video, String](tagRef, "height")
    val loop = TagRefAttribute[tag.Video, Boolean](tagRef, "loop")
    val muted = TagRefAttribute[tag.Video, Boolean](tagRef, "muted")
    val played = TagRefAttribute[tag.Video, String](tagRef, "played")
    val preload = TagRefAttribute[tag.Video, String](tagRef, "preload")
    val poster = TagRefAttribute[tag.Video, String](tagRef, "poster")
    val src = TagRefAttribute[tag.Video, String](tagRef, "src")
    val width = TagRefAttribute[tag.Video, String](tagRef, "width")
  }

}
