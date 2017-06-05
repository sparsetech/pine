package pine.tag

import pine._

trait Attributes {
  implicit class TagRefAttributes[T <: Singleton](tagRef: TagRef[T]) {
    val accesskey = new Attribute[T, scala.Option[String], String](tagRef, "accesskey")
    val `class` = new Attribute[T, scala.Option[String], String](tagRef, "class")
    val contenteditable = new Attribute[T, scala.Option[String], String](tagRef, "contenteditable")
    val contextmenu = new Attribute[T, scala.Option[String], String](tagRef, "contextmenu")
    val dir = new Attribute[T, scala.Option[String], String](tagRef, "dir")
    val draggable = new Attribute[T, scala.Option[String], String](tagRef, "draggable")
    val dropzone = new Attribute[T, scala.Option[String], String](tagRef, "dropzone")
    val hidden = new Attribute[T, scala.Option[String], String](tagRef, "hidden")
    val id = new Attribute[T, scala.Option[String], String](tagRef, "id")
    val itemid = new Attribute[T, scala.Option[String], String](tagRef, "itemid")
    val itemprop = new Attribute[T, scala.Option[String], String](tagRef, "itemprop")
    val itemref = new Attribute[T, scala.Option[String], String](tagRef, "itemref")
    val itemscope = new Attribute[T, scala.Option[String], String](tagRef, "itemscope")
    val itemtype = new Attribute[T, scala.Option[String], String](tagRef, "itemtype")
    val lang = new Attribute[T, scala.Option[String], String](tagRef, "lang")
    val spellcheck = new Attribute[T, scala.Option[String], String](tagRef, "spellcheck")
    val style = new Attribute[T, scala.Option[String], String](tagRef, "style")
    val tabindex = new Attribute[T, scala.Option[String], String](tagRef, "tabindex")
    val title = new Attribute[T, scala.Option[String], String](tagRef, "title")
    val translate = new Attribute[T, scala.Option[String], String](tagRef, "translate")
  }

  implicit class TagExtensions[T <: Singleton](tag: Tag[T]) {
    def accesskey: scala.Option[String] = tag.attr("accesskey").asInstanceOf[scala.Option[String]]
    def accesskey(value: String): Tag[T] = tag.setAttr("accesskey", value)
    def `class`: scala.Option[String] = tag.attr("class").asInstanceOf[scala.Option[String]]
    def `class`(value: String): Tag[T] = tag.setAttr("class", value)
    def contenteditable: scala.Option[String] = tag.attr("contenteditable").asInstanceOf[scala.Option[String]]
    def contenteditable(value: String): Tag[T] = tag.setAttr("contenteditable", value)
    def contextmenu: scala.Option[String] = tag.attr("contextmenu").asInstanceOf[scala.Option[String]]
    def contextmenu(value: String): Tag[T] = tag.setAttr("contextmenu", value)
    def dir: scala.Option[String] = tag.attr("dir").asInstanceOf[scala.Option[String]]
    def dir(value: String): Tag[T] = tag.setAttr("dir", value)
    def draggable: scala.Option[String] = tag.attr("draggable").asInstanceOf[scala.Option[String]]
    def draggable(value: String): Tag[T] = tag.setAttr("draggable", value)
    def dropzone: scala.Option[String] = tag.attr("dropzone").asInstanceOf[scala.Option[String]]
    def dropzone(value: String): Tag[T] = tag.setAttr("dropzone", value)
    def hidden: scala.Option[String] = tag.attr("hidden").asInstanceOf[scala.Option[String]]
    def hidden(value: String): Tag[T] = tag.setAttr("hidden", value)
    def id: scala.Option[String] = tag.attr("id").asInstanceOf[scala.Option[String]]
    def id(value: String): Tag[T] = tag.setAttr("id", value)
    def itemid: scala.Option[String] = tag.attr("itemid").asInstanceOf[scala.Option[String]]
    def itemid(value: String): Tag[T] = tag.setAttr("itemid", value)
    def itemprop: scala.Option[String] = tag.attr("itemprop").asInstanceOf[scala.Option[String]]
    def itemprop(value: String): Tag[T] = tag.setAttr("itemprop", value)
    def itemref: scala.Option[String] = tag.attr("itemref").asInstanceOf[scala.Option[String]]
    def itemref(value: String): Tag[T] = tag.setAttr("itemref", value)
    def itemscope: scala.Option[String] = tag.attr("itemscope").asInstanceOf[scala.Option[String]]
    def itemscope(value: String): Tag[T] = tag.setAttr("itemscope", value)
    def itemtype: scala.Option[String] = tag.attr("itemtype").asInstanceOf[scala.Option[String]]
    def itemtype(value: String): Tag[T] = tag.setAttr("itemtype", value)
    def lang: scala.Option[String] = tag.attr("lang").asInstanceOf[scala.Option[String]]
    def lang(value: String): Tag[T] = tag.setAttr("lang", value)
    def spellcheck: scala.Option[String] = tag.attr("spellcheck").asInstanceOf[scala.Option[String]]
    def spellcheck(value: String): Tag[T] = tag.setAttr("spellcheck", value)
    def style: scala.Option[String] = tag.attr("style").asInstanceOf[scala.Option[String]]
    def style(value: String): Tag[T] = tag.setAttr("style", value)
    def tabindex: scala.Option[String] = tag.attr("tabindex").asInstanceOf[scala.Option[String]]
    def tabindex(value: String): Tag[T] = tag.setAttr("tabindex", value)
    def title: scala.Option[String] = tag.attr("title").asInstanceOf[scala.Option[String]]
    def title(value: String): Tag[T] = tag.setAttr("title", value)
    def translate: scala.Option[String] = tag.attr("translate").asInstanceOf[scala.Option[String]]
    def translate(value: String): Tag[T] = tag.setAttr("translate", value)
  }

  implicit class TagAttributesA(tag: Tag[pine.tag.A]) {
    def download: scala.Option[String] = tag.attr("download").asInstanceOf[scala.Option[String]]
    def download(value: String): Tag[pine.tag.A] = tag.setAttr("download", value)
    def href: scala.Option[String] = tag.attr("href").asInstanceOf[scala.Option[String]]
    def href(value: String): Tag[pine.tag.A] = tag.setAttr("href", value)
    def hreflang: scala.Option[String] = tag.attr("hreflang").asInstanceOf[scala.Option[String]]
    def hreflang(value: String): Tag[pine.tag.A] = tag.setAttr("hreflang", value)
    def media: scala.Option[String] = tag.attr("media").asInstanceOf[scala.Option[String]]
    def media(value: String): Tag[pine.tag.A] = tag.setAttr("media", value)
    def ping: scala.Option[String] = tag.attr("ping").asInstanceOf[scala.Option[String]]
    def ping(value: String): Tag[pine.tag.A] = tag.setAttr("ping", value)
    def rel: scala.Option[String] = tag.attr("rel").asInstanceOf[scala.Option[String]]
    def rel(value: String): Tag[pine.tag.A] = tag.setAttr("rel", value)
    def target: scala.Option[String] = tag.attr("target").asInstanceOf[scala.Option[String]]
    def target(value: String): Tag[pine.tag.A] = tag.setAttr("target", value)
    def `type`: scala.Option[String] = tag.attr("type").asInstanceOf[scala.Option[String]]
    def `type`(value: String): Tag[pine.tag.A] = tag.setAttr("type", value)
    def charset: scala.Option[String] = tag.attr("charset").asInstanceOf[scala.Option[String]]
    def charset(value: String): Tag[pine.tag.A] = tag.setAttr("charset", value)
    def coords: scala.Option[String] = tag.attr("coords").asInstanceOf[scala.Option[String]]
    def coords(value: String): Tag[pine.tag.A] = tag.setAttr("coords", value)
    def name: scala.Option[String] = tag.attr("name").asInstanceOf[scala.Option[String]]
    def name(value: String): Tag[pine.tag.A] = tag.setAttr("name", value)
    def rev: scala.Option[String] = tag.attr("rev").asInstanceOf[scala.Option[String]]
    def rev(value: String): Tag[pine.tag.A] = tag.setAttr("rev", value)
    def shape: scala.Option[String] = tag.attr("shape").asInstanceOf[scala.Option[String]]
    def shape(value: String): Tag[pine.tag.A] = tag.setAttr("shape", value)
    def datafld: scala.Option[String] = tag.attr("datafld").asInstanceOf[scala.Option[String]]
    def datafld(value: String): Tag[pine.tag.A] = tag.setAttr("datafld", value)
    def datasrc: scala.Option[String] = tag.attr("datasrc").asInstanceOf[scala.Option[String]]
    def datasrc(value: String): Tag[pine.tag.A] = tag.setAttr("datasrc", value)
    def methods: scala.Option[String] = tag.attr("methods").asInstanceOf[scala.Option[String]]
    def methods(value: String): Tag[pine.tag.A] = tag.setAttr("methods", value)
    def urn: scala.Option[String] = tag.attr("urn").asInstanceOf[scala.Option[String]]
    def urn(value: String): Tag[pine.tag.A] = tag.setAttr("urn", value)
  }

  implicit class TagRefAttributesA(tagRef: TagRef[tag.A]) {
    val download = new Attribute[tag.A, scala.Option[String], String](tagRef, "download")
    val href = new Attribute[tag.A, scala.Option[String], String](tagRef, "href")
    val hreflang = new Attribute[tag.A, scala.Option[String], String](tagRef, "hreflang")
    val media = new Attribute[tag.A, scala.Option[String], String](tagRef, "media")
    val ping = new Attribute[tag.A, scala.Option[String], String](tagRef, "ping")
    val rel = new Attribute[tag.A, scala.Option[String], String](tagRef, "rel")
    val target = new Attribute[tag.A, scala.Option[String], String](tagRef, "target")
    val `type` = new Attribute[tag.A, scala.Option[String], String](tagRef, "type")
    val charset = new Attribute[tag.A, scala.Option[String], String](tagRef, "charset")
    val coords = new Attribute[tag.A, scala.Option[String], String](tagRef, "coords")
    val name = new Attribute[tag.A, scala.Option[String], String](tagRef, "name")
    val rev = new Attribute[tag.A, scala.Option[String], String](tagRef, "rev")
    val shape = new Attribute[tag.A, scala.Option[String], String](tagRef, "shape")
    val datafld = new Attribute[tag.A, scala.Option[String], String](tagRef, "datafld")
    val datasrc = new Attribute[tag.A, scala.Option[String], String](tagRef, "datasrc")
    val methods = new Attribute[tag.A, scala.Option[String], String](tagRef, "methods")
    val urn = new Attribute[tag.A, scala.Option[String], String](tagRef, "urn")
  }

  implicit class TagAttributesApplet(tag: Tag[pine.tag.Applet]) {
    def align: scala.Option[String] = tag.attr("align").asInstanceOf[scala.Option[String]]
    def align(value: String): Tag[pine.tag.Applet] = tag.setAttr("align", value)
    def alt: scala.Option[String] = tag.attr("alt").asInstanceOf[scala.Option[String]]
    def alt(value: String): Tag[pine.tag.Applet] = tag.setAttr("alt", value)
    def archive: scala.Option[String] = tag.attr("archive").asInstanceOf[scala.Option[String]]
    def archive(value: String): Tag[pine.tag.Applet] = tag.setAttr("archive", value)
    def code: scala.Option[String] = tag.attr("code").asInstanceOf[scala.Option[String]]
    def code(value: String): Tag[pine.tag.Applet] = tag.setAttr("code", value)
    def codebase: scala.Option[String] = tag.attr("codebase").asInstanceOf[scala.Option[String]]
    def codebase(value: String): Tag[pine.tag.Applet] = tag.setAttr("codebase", value)
    def datafld: scala.Option[String] = tag.attr("datafld").asInstanceOf[scala.Option[String]]
    def datafld(value: String): Tag[pine.tag.Applet] = tag.setAttr("datafld", value)
    def datasrc: scala.Option[String] = tag.attr("datasrc").asInstanceOf[scala.Option[String]]
    def datasrc(value: String): Tag[pine.tag.Applet] = tag.setAttr("datasrc", value)
    def height: scala.Option[String] = tag.attr("height").asInstanceOf[scala.Option[String]]
    def height(value: String): Tag[pine.tag.Applet] = tag.setAttr("height", value)
    def hspace: scala.Option[String] = tag.attr("hspace").asInstanceOf[scala.Option[String]]
    def hspace(value: String): Tag[pine.tag.Applet] = tag.setAttr("hspace", value)
    def mayscript: scala.Option[String] = tag.attr("mayscript").asInstanceOf[scala.Option[String]]
    def mayscript(value: String): Tag[pine.tag.Applet] = tag.setAttr("mayscript", value)
    def name: scala.Option[String] = tag.attr("name").asInstanceOf[scala.Option[String]]
    def name(value: String): Tag[pine.tag.Applet] = tag.setAttr("name", value)
    def `object`: scala.Option[String] = tag.attr("object").asInstanceOf[scala.Option[String]]
    def `object`(value: String): Tag[pine.tag.Applet] = tag.setAttr("object", value)
    def src: scala.Option[String] = tag.attr("src").asInstanceOf[scala.Option[String]]
    def src(value: String): Tag[pine.tag.Applet] = tag.setAttr("src", value)
    def vspace: scala.Option[String] = tag.attr("vspace").asInstanceOf[scala.Option[String]]
    def vspace(value: String): Tag[pine.tag.Applet] = tag.setAttr("vspace", value)
    def width: scala.Option[String] = tag.attr("width").asInstanceOf[scala.Option[String]]
    def width(value: String): Tag[pine.tag.Applet] = tag.setAttr("width", value)
  }

  implicit class TagRefAttributesApplet(tagRef: TagRef[tag.Applet]) {
    val align = new Attribute[tag.Applet, scala.Option[String], String](tagRef, "align")
    val alt = new Attribute[tag.Applet, scala.Option[String], String](tagRef, "alt")
    val archive = new Attribute[tag.Applet, scala.Option[String], String](tagRef, "archive")
    val code = new Attribute[tag.Applet, scala.Option[String], String](tagRef, "code")
    val codebase = new Attribute[tag.Applet, scala.Option[String], String](tagRef, "codebase")
    val datafld = new Attribute[tag.Applet, scala.Option[String], String](tagRef, "datafld")
    val datasrc = new Attribute[tag.Applet, scala.Option[String], String](tagRef, "datasrc")
    val height = new Attribute[tag.Applet, scala.Option[String], String](tagRef, "height")
    val hspace = new Attribute[tag.Applet, scala.Option[String], String](tagRef, "hspace")
    val mayscript = new Attribute[tag.Applet, scala.Option[String], String](tagRef, "mayscript")
    val name = new Attribute[tag.Applet, scala.Option[String], String](tagRef, "name")
    val `object` = new Attribute[tag.Applet, scala.Option[String], String](tagRef, "object")
    val src = new Attribute[tag.Applet, scala.Option[String], String](tagRef, "src")
    val vspace = new Attribute[tag.Applet, scala.Option[String], String](tagRef, "vspace")
    val width = new Attribute[tag.Applet, scala.Option[String], String](tagRef, "width")
  }

  implicit class TagAttributesArea(tag: Tag[pine.tag.Area]) {
    def alt: scala.Option[String] = tag.attr("alt").asInstanceOf[scala.Option[String]]
    def alt(value: String): Tag[pine.tag.Area] = tag.setAttr("alt", value)
    def coords: scala.Option[String] = tag.attr("coords").asInstanceOf[scala.Option[String]]
    def coords(value: String): Tag[pine.tag.Area] = tag.setAttr("coords", value)
    def download: scala.Option[String] = tag.attr("download").asInstanceOf[scala.Option[String]]
    def download(value: String): Tag[pine.tag.Area] = tag.setAttr("download", value)
    def href: scala.Option[String] = tag.attr("href").asInstanceOf[scala.Option[String]]
    def href(value: String): Tag[pine.tag.Area] = tag.setAttr("href", value)
    def hreflang: scala.Option[String] = tag.attr("hreflang").asInstanceOf[scala.Option[String]]
    def hreflang(value: String): Tag[pine.tag.Area] = tag.setAttr("hreflang", value)
    def name: scala.Option[String] = tag.attr("name").asInstanceOf[scala.Option[String]]
    def name(value: String): Tag[pine.tag.Area] = tag.setAttr("name", value)
    def media: scala.Option[String] = tag.attr("media").asInstanceOf[scala.Option[String]]
    def media(value: String): Tag[pine.tag.Area] = tag.setAttr("media", value)
    def nohref: scala.Option[String] = tag.attr("nohref").asInstanceOf[scala.Option[String]]
    def nohref(value: String): Tag[pine.tag.Area] = tag.setAttr("nohref", value)
    def rel: scala.Option[String] = tag.attr("rel").asInstanceOf[scala.Option[String]]
    def rel(value: String): Tag[pine.tag.Area] = tag.setAttr("rel", value)
    def shape: scala.Option[String] = tag.attr("shape").asInstanceOf[scala.Option[String]]
    def shape(value: String): Tag[pine.tag.Area] = tag.setAttr("shape", value)
    def target: scala.Option[String] = tag.attr("target").asInstanceOf[scala.Option[String]]
    def target(value: String): Tag[pine.tag.Area] = tag.setAttr("target", value)
    def `type`: scala.Option[String] = tag.attr("type").asInstanceOf[scala.Option[String]]
    def `type`(value: String): Tag[pine.tag.Area] = tag.setAttr("type", value)
  }

  implicit class TagRefAttributesArea(tagRef: TagRef[tag.Area]) {
    val accesskey = new Attribute[tag.Area, scala.Option[String], String](tagRef, "accesskey")
    val alt = new Attribute[tag.Area, scala.Option[String], String](tagRef, "alt")
    val coords = new Attribute[tag.Area, scala.Option[String], String](tagRef, "coords")
    val download = new Attribute[tag.Area, scala.Option[String], String](tagRef, "download")
    val href = new Attribute[tag.Area, scala.Option[String], String](tagRef, "href")
    val hreflang = new Attribute[tag.Area, scala.Option[String], String](tagRef, "hreflang")
    val name = new Attribute[tag.Area, scala.Option[String], String](tagRef, "name")
    val media = new Attribute[tag.Area, scala.Option[String], String](tagRef, "media")
    val nohref = new Attribute[tag.Area, scala.Option[String], String](tagRef, "nohref")
    val rel = new Attribute[tag.Area, scala.Option[String], String](tagRef, "rel")
    val shape = new Attribute[tag.Area, scala.Option[String], String](tagRef, "shape")
    val tabindex = new Attribute[tag.Area, scala.Option[String], String](tagRef, "tabindex")
    val target = new Attribute[tag.Area, scala.Option[String], String](tagRef, "target")
    val `type` = new Attribute[tag.Area, scala.Option[String], String](tagRef, "type")
  }

  implicit class TagAttributesAudio(tag: Tag[pine.tag.Audio]) {
    def autoplay: scala.Option[String] = tag.attr("autoplay").asInstanceOf[scala.Option[String]]
    def autoplay(value: String): Tag[pine.tag.Audio] = tag.setAttr("autoplay", value)
    def autobuffer: scala.Option[String] = tag.attr("autobuffer").asInstanceOf[scala.Option[String]]
    def autobuffer(value: String): Tag[pine.tag.Audio] = tag.setAttr("autobuffer", value)
    def buffered: scala.Option[String] = tag.attr("buffered").asInstanceOf[scala.Option[String]]
    def buffered(value: String): Tag[pine.tag.Audio] = tag.setAttr("buffered", value)
    def controls: scala.Option[String] = tag.attr("controls").asInstanceOf[scala.Option[String]]
    def controls(value: String): Tag[pine.tag.Audio] = tag.setAttr("controls", value)
    def loop: scala.Option[String] = tag.attr("loop").asInstanceOf[scala.Option[String]]
    def loop(value: String): Tag[pine.tag.Audio] = tag.setAttr("loop", value)
    def mozCurrentSampleOffset: scala.Option[String] = tag.attr("mozCurrentSampleOffset").asInstanceOf[scala.Option[String]]
    def mozCurrentSampleOffset(value: String): Tag[pine.tag.Audio] = tag.setAttr("mozCurrentSampleOffset", value)
    def muted: scala.Option[String] = tag.attr("muted").asInstanceOf[scala.Option[String]]
    def muted(value: String): Tag[pine.tag.Audio] = tag.setAttr("muted", value)
    def played: scala.Option[String] = tag.attr("played").asInstanceOf[scala.Option[String]]
    def played(value: String): Tag[pine.tag.Audio] = tag.setAttr("played", value)
    def preload: scala.Option[String] = tag.attr("preload").asInstanceOf[scala.Option[String]]
    def preload(value: String): Tag[pine.tag.Audio] = tag.setAttr("preload", value)
    def src: scala.Option[String] = tag.attr("src").asInstanceOf[scala.Option[String]]
    def src(value: String): Tag[pine.tag.Audio] = tag.setAttr("src", value)
    def volume: scala.Option[String] = tag.attr("volume").asInstanceOf[scala.Option[String]]
    def volume(value: String): Tag[pine.tag.Audio] = tag.setAttr("volume", value)
  }

  implicit class TagRefAttributesAudio(tagRef: TagRef[tag.Audio]) {
    val autoplay = new Attribute[tag.Audio, scala.Option[String], String](tagRef, "autoplay")
    val autobuffer = new Attribute[tag.Audio, scala.Option[String], String](tagRef, "autobuffer")
    val buffered = new Attribute[tag.Audio, scala.Option[String], String](tagRef, "buffered")
    val controls = new Attribute[tag.Audio, scala.Option[String], String](tagRef, "controls")
    val loop = new Attribute[tag.Audio, scala.Option[String], String](tagRef, "loop")
    val mozCurrentSampleOffset = new Attribute[tag.Audio, scala.Option[String], String](tagRef, "mozCurrentSampleOffset")
    val muted = new Attribute[tag.Audio, scala.Option[String], String](tagRef, "muted")
    val played = new Attribute[tag.Audio, scala.Option[String], String](tagRef, "played")
    val preload = new Attribute[tag.Audio, scala.Option[String], String](tagRef, "preload")
    val src = new Attribute[tag.Audio, scala.Option[String], String](tagRef, "src")
    val volume = new Attribute[tag.Audio, scala.Option[String], String](tagRef, "volume")
  }

  implicit class TagAttributesBase(tag: Tag[pine.tag.Base]) {
    def href: scala.Option[String] = tag.attr("href").asInstanceOf[scala.Option[String]]
    def href(value: String): Tag[pine.tag.Base] = tag.setAttr("href", value)
    def target: scala.Option[String] = tag.attr("target").asInstanceOf[scala.Option[String]]
    def target(value: String): Tag[pine.tag.Base] = tag.setAttr("target", value)
  }

  implicit class TagRefAttributesBase(tagRef: TagRef[tag.Base]) {
    val href = new Attribute[tag.Base, scala.Option[String], String](tagRef, "href")
    val target = new Attribute[tag.Base, scala.Option[String], String](tagRef, "target")
  }

  implicit class TagAttributesBasefont(tag: Tag[pine.tag.Basefont]) {
    def color: scala.Option[String] = tag.attr("color").asInstanceOf[scala.Option[String]]
    def color(value: String): Tag[pine.tag.Basefont] = tag.setAttr("color", value)
    def face: scala.Option[String] = tag.attr("face").asInstanceOf[scala.Option[String]]
    def face(value: String): Tag[pine.tag.Basefont] = tag.setAttr("face", value)
    def size: scala.Option[String] = tag.attr("size").asInstanceOf[scala.Option[String]]
    def size(value: String): Tag[pine.tag.Basefont] = tag.setAttr("size", value)
  }

  implicit class TagRefAttributesBasefont(tagRef: TagRef[tag.Basefont]) {
    val color = new Attribute[tag.Basefont, scala.Option[String], String](tagRef, "color")
    val face = new Attribute[tag.Basefont, scala.Option[String], String](tagRef, "face")
    val size = new Attribute[tag.Basefont, scala.Option[String], String](tagRef, "size")
  }

  implicit class TagAttributesBody(tag: Tag[pine.tag.Body]) {
    def alink: scala.Option[String] = tag.attr("alink").asInstanceOf[scala.Option[String]]
    def alink(value: String): Tag[pine.tag.Body] = tag.setAttr("alink", value)
    def background: scala.Option[String] = tag.attr("background").asInstanceOf[scala.Option[String]]
    def background(value: String): Tag[pine.tag.Body] = tag.setAttr("background", value)
    def bgcolor: scala.Option[String] = tag.attr("bgcolor").asInstanceOf[scala.Option[String]]
    def bgcolor(value: String): Tag[pine.tag.Body] = tag.setAttr("bgcolor", value)
    def bottommargin: scala.Option[String] = tag.attr("bottommargin").asInstanceOf[scala.Option[String]]
    def bottommargin(value: String): Tag[pine.tag.Body] = tag.setAttr("bottommargin", value)
    def leftmargin: scala.Option[String] = tag.attr("leftmargin").asInstanceOf[scala.Option[String]]
    def leftmargin(value: String): Tag[pine.tag.Body] = tag.setAttr("leftmargin", value)
    def link: scala.Option[String] = tag.attr("link").asInstanceOf[scala.Option[String]]
    def link(value: String): Tag[pine.tag.Body] = tag.setAttr("link", value)
    def rightmargin: scala.Option[String] = tag.attr("rightmargin").asInstanceOf[scala.Option[String]]
    def rightmargin(value: String): Tag[pine.tag.Body] = tag.setAttr("rightmargin", value)
    def text: scala.Option[String] = tag.attr("text").asInstanceOf[scala.Option[String]]
    def text(value: String): Tag[pine.tag.Body] = tag.setAttr("text", value)
    def topmargin: scala.Option[String] = tag.attr("topmargin").asInstanceOf[scala.Option[String]]
    def topmargin(value: String): Tag[pine.tag.Body] = tag.setAttr("topmargin", value)
    def vlink: scala.Option[String] = tag.attr("vlink").asInstanceOf[scala.Option[String]]
    def vlink(value: String): Tag[pine.tag.Body] = tag.setAttr("vlink", value)
  }

  implicit class TagRefAttributesBody(tagRef: TagRef[tag.Body]) {
    val alink = new Attribute[tag.Body, scala.Option[String], String](tagRef, "alink")
    val background = new Attribute[tag.Body, scala.Option[String], String](tagRef, "background")
    val bgcolor = new Attribute[tag.Body, scala.Option[String], String](tagRef, "bgcolor")
    val bottommargin = new Attribute[tag.Body, scala.Option[String], String](tagRef, "bottommargin")
    val leftmargin = new Attribute[tag.Body, scala.Option[String], String](tagRef, "leftmargin")
    val link = new Attribute[tag.Body, scala.Option[String], String](tagRef, "link")
    val onafterprint = new Attribute[tag.Body, scala.Option[String], String](tagRef, "onafterprint")
    val onbeforeprint = new Attribute[tag.Body, scala.Option[String], String](tagRef, "onbeforeprint")
    val onbeforeunload = new Attribute[tag.Body, scala.Option[String], String](tagRef, "onbeforeunload")
    val onblur = new Attribute[tag.Body, scala.Option[String], String](tagRef, "onblur")
    val onerror = new Attribute[tag.Body, scala.Option[String], String](tagRef, "onerror")
    val onfocus = new Attribute[tag.Body, scala.Option[String], String](tagRef, "onfocus")
    val onhashchange = new Attribute[tag.Body, scala.Option[String], String](tagRef, "onhashchange")
    val onlanguagechange = new Attribute[tag.Body, scala.Option[String], String](tagRef, "onlanguagechange")
    val onload = new Attribute[tag.Body, scala.Option[String], String](tagRef, "onload")
    val onmessage = new Attribute[tag.Body, scala.Option[String], String](tagRef, "onmessage")
    val onoffline = new Attribute[tag.Body, scala.Option[String], String](tagRef, "onoffline")
    val ononline = new Attribute[tag.Body, scala.Option[String], String](tagRef, "ononline")
    val onpopstate = new Attribute[tag.Body, scala.Option[String], String](tagRef, "onpopstate")
    val onredo = new Attribute[tag.Body, scala.Option[String], String](tagRef, "onredo")
    val onresize = new Attribute[tag.Body, scala.Option[String], String](tagRef, "onresize")
    val onstorage = new Attribute[tag.Body, scala.Option[String], String](tagRef, "onstorage")
    val onundo = new Attribute[tag.Body, scala.Option[String], String](tagRef, "onundo")
    val onunload = new Attribute[tag.Body, scala.Option[String], String](tagRef, "onunload")
    val rightmargin = new Attribute[tag.Body, scala.Option[String], String](tagRef, "rightmargin")
    val text = new Attribute[tag.Body, scala.Option[String], String](tagRef, "text")
    val topmargin = new Attribute[tag.Body, scala.Option[String], String](tagRef, "topmargin")
    val vlink = new Attribute[tag.Body, scala.Option[String], String](tagRef, "vlink")
  }

  implicit class TagAttributesBr(tag: Tag[pine.tag.Br]) {
    def clear: scala.Option[String] = tag.attr("clear").asInstanceOf[scala.Option[String]]
    def clear(value: String): Tag[pine.tag.Br] = tag.setAttr("clear", value)
  }

  implicit class TagRefAttributesBr(tagRef: TagRef[tag.Br]) {
    val clear = new Attribute[tag.Br, scala.Option[String], String](tagRef, "clear")
  }

  implicit class TagAttributesButton(tag: Tag[pine.tag.Button]) {
    def autofocus: Boolean = tag.attributes.contains("autofocus")
    def autofocus(value: Boolean): Tag[pine.tag.Button] = if (value) tag.setAttr("autofocus", "") else tag.remAttr("autofocus")
    def autocomplete: scala.Option[String] = tag.attr("autocomplete").asInstanceOf[scala.Option[String]]
    def autocomplete(value: String): Tag[pine.tag.Button] = tag.setAttr("autocomplete", value)
    def disabled: Boolean = tag.attributes.contains("disabled")
    def disabled(value: Boolean): Tag[pine.tag.Button] = if (value) tag.setAttr("disabled", "") else tag.remAttr("disabled")
    def form: scala.Option[String] = tag.attr("form").asInstanceOf[scala.Option[String]]
    def form(value: String): Tag[pine.tag.Button] = tag.setAttr("form", value)
    def formaction: scala.Option[String] = tag.attr("formaction").asInstanceOf[scala.Option[String]]
    def formaction(value: String): Tag[pine.tag.Button] = tag.setAttr("formaction", value)
    def formenctype: scala.Option[String] = tag.attr("formenctype").asInstanceOf[scala.Option[String]]
    def formenctype(value: String): Tag[pine.tag.Button] = tag.setAttr("formenctype", value)
    def formmethod: scala.Option[String] = tag.attr("formmethod").asInstanceOf[scala.Option[String]]
    def formmethod(value: String): Tag[pine.tag.Button] = tag.setAttr("formmethod", value)
    def formnovalidate: scala.Option[String] = tag.attr("formnovalidate").asInstanceOf[scala.Option[String]]
    def formnovalidate(value: String): Tag[pine.tag.Button] = tag.setAttr("formnovalidate", value)
    def formtarget: scala.Option[String] = tag.attr("formtarget").asInstanceOf[scala.Option[String]]
    def formtarget(value: String): Tag[pine.tag.Button] = tag.setAttr("formtarget", value)
    def name: scala.Option[String] = tag.attr("name").asInstanceOf[scala.Option[String]]
    def name(value: String): Tag[pine.tag.Button] = tag.setAttr("name", value)
    def `type`: scala.Option[String] = tag.attr("type").asInstanceOf[scala.Option[String]]
    def `type`(value: String): Tag[pine.tag.Button] = tag.setAttr("type", value)
    def value: scala.Option[String] = tag.attr("value").asInstanceOf[scala.Option[String]]
    def value(value: String): Tag[pine.tag.Button] = tag.setAttr("value", value)
  }

  implicit class TagRefAttributesButton(tagRef: TagRef[tag.Button]) {
    val autofocus = new Attribute[tag.Button, Boolean, Boolean](tagRef, "autofocus")
    val autocomplete = new Attribute[tag.Button, scala.Option[String], String](tagRef, "autocomplete")
    val disabled = new Attribute[tag.Button, Boolean, Boolean](tagRef, "disabled")
    val form = new Attribute[tag.Button, scala.Option[String], String](tagRef, "form")
    val formaction = new Attribute[tag.Button, scala.Option[String], String](tagRef, "formaction")
    val formenctype = new Attribute[tag.Button, scala.Option[String], String](tagRef, "formenctype")
    val formmethod = new Attribute[tag.Button, scala.Option[String], String](tagRef, "formmethod")
    val formnovalidate = new Attribute[tag.Button, scala.Option[String], String](tagRef, "formnovalidate")
    val formtarget = new Attribute[tag.Button, scala.Option[String], String](tagRef, "formtarget")
    val name = new Attribute[tag.Button, scala.Option[String], String](tagRef, "name")
    val `type` = new Attribute[tag.Button, scala.Option[String], String](tagRef, "type")
    val value = new Attribute[tag.Button, scala.Option[String], String](tagRef, "value")
  }

  implicit class TagAttributesCanvas(tag: Tag[pine.tag.Canvas]) {
    def height: scala.Option[String] = tag.attr("height").asInstanceOf[scala.Option[String]]
    def height(value: String): Tag[pine.tag.Canvas] = tag.setAttr("height", value)
    def `moz-opaque`: scala.Option[String] = tag.attr("moz-opaque").asInstanceOf[scala.Option[String]]
    def `moz-opaque`(value: String): Tag[pine.tag.Canvas] = tag.setAttr("moz-opaque", value)
    def width: scala.Option[String] = tag.attr("width").asInstanceOf[scala.Option[String]]
    def width(value: String): Tag[pine.tag.Canvas] = tag.setAttr("width", value)
  }

  implicit class TagRefAttributesCanvas(tagRef: TagRef[tag.Canvas]) {
    val height = new Attribute[tag.Canvas, scala.Option[String], String](tagRef, "height")
    val `moz-opaque` = new Attribute[tag.Canvas, scala.Option[String], String](tagRef, "moz-opaque")
    val width = new Attribute[tag.Canvas, scala.Option[String], String](tagRef, "width")
  }

  implicit class TagAttributesCaption(tag: Tag[pine.tag.Caption]) {
    def align: scala.Option[String] = tag.attr("align").asInstanceOf[scala.Option[String]]
    def align(value: String): Tag[pine.tag.Caption] = tag.setAttr("align", value)
  }

  implicit class TagRefAttributesCaption(tagRef: TagRef[tag.Caption]) {
    val align = new Attribute[tag.Caption, scala.Option[String], String](tagRef, "align")
  }

  implicit class TagAttributesCol(tag: Tag[pine.tag.Col]) {
    def align: scala.Option[String] = tag.attr("align").asInstanceOf[scala.Option[String]]
    def align(value: String): Tag[pine.tag.Col] = tag.setAttr("align", value)
    def bgcolor: scala.Option[String] = tag.attr("bgcolor").asInstanceOf[scala.Option[String]]
    def bgcolor(value: String): Tag[pine.tag.Col] = tag.setAttr("bgcolor", value)
    def char: scala.Option[String] = tag.attr("char").asInstanceOf[scala.Option[String]]
    def char(value: String): Tag[pine.tag.Col] = tag.setAttr("char", value)
    def charoff: scala.Option[String] = tag.attr("charoff").asInstanceOf[scala.Option[String]]
    def charoff(value: String): Tag[pine.tag.Col] = tag.setAttr("charoff", value)
    def span: scala.Option[Long] = tag.attr("span").asInstanceOf[scala.Option[Long]]
    def span(value: Long): Tag[pine.tag.Col] = tag.setAttr("span", value)
    def valign: scala.Option[String] = tag.attr("valign").asInstanceOf[scala.Option[String]]
    def valign(value: String): Tag[pine.tag.Col] = tag.setAttr("valign", value)
    def width: scala.Option[String] = tag.attr("width").asInstanceOf[scala.Option[String]]
    def width(value: String): Tag[pine.tag.Col] = tag.setAttr("width", value)
  }

  implicit class TagRefAttributesCol(tagRef: TagRef[tag.Col]) {
    val align = new Attribute[tag.Col, scala.Option[String], String](tagRef, "align")
    val bgcolor = new Attribute[tag.Col, scala.Option[String], String](tagRef, "bgcolor")
    val char = new Attribute[tag.Col, scala.Option[String], String](tagRef, "char")
    val charoff = new Attribute[tag.Col, scala.Option[String], String](tagRef, "charoff")
    val span = new Attribute[tag.Col, scala.Option[Long], Long](tagRef, "span")
    val valign = new Attribute[tag.Col, scala.Option[String], String](tagRef, "valign")
    val width = new Attribute[tag.Col, scala.Option[String], String](tagRef, "width")
  }

  implicit class TagAttributesColgroup(tag: Tag[pine.tag.Colgroup]) {
    def align: scala.Option[String] = tag.attr("align").asInstanceOf[scala.Option[String]]
    def align(value: String): Tag[pine.tag.Colgroup] = tag.setAttr("align", value)
    def bgcolor: scala.Option[String] = tag.attr("bgcolor").asInstanceOf[scala.Option[String]]
    def bgcolor(value: String): Tag[pine.tag.Colgroup] = tag.setAttr("bgcolor", value)
    def char: scala.Option[String] = tag.attr("char").asInstanceOf[scala.Option[String]]
    def char(value: String): Tag[pine.tag.Colgroup] = tag.setAttr("char", value)
    def charoff: scala.Option[String] = tag.attr("charoff").asInstanceOf[scala.Option[String]]
    def charoff(value: String): Tag[pine.tag.Colgroup] = tag.setAttr("charoff", value)
    def span: scala.Option[Long] = tag.attr("span").asInstanceOf[scala.Option[Long]]
    def span(value: Long): Tag[pine.tag.Colgroup] = tag.setAttr("span", value)
    def valign: scala.Option[String] = tag.attr("valign").asInstanceOf[scala.Option[String]]
    def valign(value: String): Tag[pine.tag.Colgroup] = tag.setAttr("valign", value)
    def width: scala.Option[String] = tag.attr("width").asInstanceOf[scala.Option[String]]
    def width(value: String): Tag[pine.tag.Colgroup] = tag.setAttr("width", value)
  }

  implicit class TagRefAttributesColgroup(tagRef: TagRef[tag.Colgroup]) {
    val align = new Attribute[tag.Colgroup, scala.Option[String], String](tagRef, "align")
    val bgcolor = new Attribute[tag.Colgroup, scala.Option[String], String](tagRef, "bgcolor")
    val char = new Attribute[tag.Colgroup, scala.Option[String], String](tagRef, "char")
    val charoff = new Attribute[tag.Colgroup, scala.Option[String], String](tagRef, "charoff")
    val span = new Attribute[tag.Colgroup, scala.Option[Long], Long](tagRef, "span")
    val valign = new Attribute[tag.Colgroup, scala.Option[String], String](tagRef, "valign")
    val width = new Attribute[tag.Colgroup, scala.Option[String], String](tagRef, "width")
  }

  implicit class TagAttributesDd(tag: Tag[pine.tag.Dd]) {
    def nowrap: scala.Option[String] = tag.attr("nowrap").asInstanceOf[scala.Option[String]]
    def nowrap(value: String): Tag[pine.tag.Dd] = tag.setAttr("nowrap", value)
  }

  implicit class TagRefAttributesDd(tagRef: TagRef[tag.Dd]) {
    val nowrap = new Attribute[tag.Dd, scala.Option[String], String](tagRef, "nowrap")
  }

  implicit class TagAttributesDel(tag: Tag[pine.tag.Del]) {
    def cite: scala.Option[String] = tag.attr("cite").asInstanceOf[scala.Option[String]]
    def cite(value: String): Tag[pine.tag.Del] = tag.setAttr("cite", value)
    def datetime: scala.Option[String] = tag.attr("datetime").asInstanceOf[scala.Option[String]]
    def datetime(value: String): Tag[pine.tag.Del] = tag.setAttr("datetime", value)
  }

  implicit class TagRefAttributesDel(tagRef: TagRef[tag.Del]) {
    val cite = new Attribute[tag.Del, scala.Option[String], String](tagRef, "cite")
    val datetime = new Attribute[tag.Del, scala.Option[String], String](tagRef, "datetime")
  }

  implicit class TagAttributesDetails(tag: Tag[pine.tag.Details]) {
    def open: scala.Option[String] = tag.attr("open").asInstanceOf[scala.Option[String]]
    def open(value: String): Tag[pine.tag.Details] = tag.setAttr("open", value)
  }

  implicit class TagRefAttributesDetails(tagRef: TagRef[tag.Details]) {
    val open = new Attribute[tag.Details, scala.Option[String], String](tagRef, "open")
  }

  implicit class TagAttributesDialog(tag: Tag[pine.tag.Dialog]) {
    def open: Boolean = tag.attributes.contains("open")
    def open(value: Boolean): Tag[pine.tag.Dialog] = if (value) tag.setAttr("open", "") else tag.remAttr("open")
  }

  implicit class TagRefAttributesDialog(tagRef: TagRef[tag.Dialog]) {
    val open = new Attribute[tag.Dialog, Boolean, Boolean](tagRef, "open")
  }

  implicit class TagAttributesDir(tag: Tag[pine.tag.Dir]) {
    def compact: scala.Option[String] = tag.attr("compact").asInstanceOf[scala.Option[String]]
    def compact(value: String): Tag[pine.tag.Dir] = tag.setAttr("compact", value)
  }

  implicit class TagRefAttributesDir(tagRef: TagRef[tag.Dir]) {
    val compact = new Attribute[tag.Dir, scala.Option[String], String](tagRef, "compact")
  }

  implicit class TagAttributesDl(tag: Tag[pine.tag.Dl]) {
    def compact: Boolean = tag.attributes.contains("compact")
    def compact(value: Boolean): Tag[pine.tag.Dl] = if (value) tag.setAttr("compact", "") else tag.remAttr("compact")
  }

  implicit class TagRefAttributesDl(tagRef: TagRef[tag.Dl]) {
    val compact = new Attribute[tag.Dl, Boolean, Boolean](tagRef, "compact")
  }

  implicit class TagAttributesEmbed(tag: Tag[pine.tag.Embed]) {
    def height: scala.Option[String] = tag.attr("height").asInstanceOf[scala.Option[String]]
    def height(value: String): Tag[pine.tag.Embed] = tag.setAttr("height", value)
    def src: scala.Option[String] = tag.attr("src").asInstanceOf[scala.Option[String]]
    def src(value: String): Tag[pine.tag.Embed] = tag.setAttr("src", value)
    def `type`: scala.Option[String] = tag.attr("type").asInstanceOf[scala.Option[String]]
    def `type`(value: String): Tag[pine.tag.Embed] = tag.setAttr("type", value)
    def width: scala.Option[String] = tag.attr("width").asInstanceOf[scala.Option[String]]
    def width(value: String): Tag[pine.tag.Embed] = tag.setAttr("width", value)
  }

  implicit class TagRefAttributesEmbed(tagRef: TagRef[tag.Embed]) {
    val height = new Attribute[tag.Embed, scala.Option[String], String](tagRef, "height")
    val src = new Attribute[tag.Embed, scala.Option[String], String](tagRef, "src")
    val `type` = new Attribute[tag.Embed, scala.Option[String], String](tagRef, "type")
    val width = new Attribute[tag.Embed, scala.Option[String], String](tagRef, "width")
  }

  implicit class TagAttributesFieldset(tag: Tag[pine.tag.Fieldset]) {
    def disabled: scala.Option[String] = tag.attr("disabled").asInstanceOf[scala.Option[String]]
    def disabled(value: String): Tag[pine.tag.Fieldset] = tag.setAttr("disabled", value)
    def form: scala.Option[String] = tag.attr("form").asInstanceOf[scala.Option[String]]
    def form(value: String): Tag[pine.tag.Fieldset] = tag.setAttr("form", value)
    def name: scala.Option[String] = tag.attr("name").asInstanceOf[scala.Option[String]]
    def name(value: String): Tag[pine.tag.Fieldset] = tag.setAttr("name", value)
  }

  implicit class TagRefAttributesFieldset(tagRef: TagRef[tag.Fieldset]) {
    val disabled = new Attribute[tag.Fieldset, scala.Option[String], String](tagRef, "disabled")
    val form = new Attribute[tag.Fieldset, scala.Option[String], String](tagRef, "form")
    val name = new Attribute[tag.Fieldset, scala.Option[String], String](tagRef, "name")
  }

  implicit class TagAttributesForm(tag: Tag[pine.tag.Form]) {
    def accept: scala.Option[String] = tag.attr("accept").asInstanceOf[scala.Option[String]]
    def accept(value: String): Tag[pine.tag.Form] = tag.setAttr("accept", value)
    def `accept-charset`: scala.Option[String] = tag.attr("accept-charset").asInstanceOf[scala.Option[String]]
    def `accept-charset`(value: String): Tag[pine.tag.Form] = tag.setAttr("accept-charset", value)
    def action: scala.Option[String] = tag.attr("action").asInstanceOf[scala.Option[String]]
    def action(value: String): Tag[pine.tag.Form] = tag.setAttr("action", value)
    def autocapitalize: scala.Option[String] = tag.attr("autocapitalize").asInstanceOf[scala.Option[String]]
    def autocapitalize(value: String): Tag[pine.tag.Form] = tag.setAttr("autocapitalize", value)
    def autocomplete: scala.Option[String] = tag.attr("autocomplete").asInstanceOf[scala.Option[String]]
    def autocomplete(value: String): Tag[pine.tag.Form] = tag.setAttr("autocomplete", value)
    def enctype: scala.Option[String] = tag.attr("enctype").asInstanceOf[scala.Option[String]]
    def enctype(value: String): Tag[pine.tag.Form] = tag.setAttr("enctype", value)
    def method: scala.Option[String] = tag.attr("method").asInstanceOf[scala.Option[String]]
    def method(value: String): Tag[pine.tag.Form] = tag.setAttr("method", value)
    def name: scala.Option[String] = tag.attr("name").asInstanceOf[scala.Option[String]]
    def name(value: String): Tag[pine.tag.Form] = tag.setAttr("name", value)
    def novalidate: scala.Option[String] = tag.attr("novalidate").asInstanceOf[scala.Option[String]]
    def novalidate(value: String): Tag[pine.tag.Form] = tag.setAttr("novalidate", value)
    def target: scala.Option[String] = tag.attr("target").asInstanceOf[scala.Option[String]]
    def target(value: String): Tag[pine.tag.Form] = tag.setAttr("target", value)
  }

  implicit class TagRefAttributesForm(tagRef: TagRef[tag.Form]) {
    val accept = new Attribute[tag.Form, scala.Option[String], String](tagRef, "accept")
    val `accept-charset` = new Attribute[tag.Form, scala.Option[String], String](tagRef, "accept-charset")
    val action = new Attribute[tag.Form, scala.Option[String], String](tagRef, "action")
    val autocapitalize = new Attribute[tag.Form, scala.Option[String], String](tagRef, "autocapitalize")
    val autocomplete = new Attribute[tag.Form, scala.Option[String], String](tagRef, "autocomplete")
    val enctype = new Attribute[tag.Form, scala.Option[String], String](tagRef, "enctype")
    val method = new Attribute[tag.Form, scala.Option[String], String](tagRef, "method")
    val name = new Attribute[tag.Form, scala.Option[String], String](tagRef, "name")
    val novalidate = new Attribute[tag.Form, scala.Option[String], String](tagRef, "novalidate")
    val target = new Attribute[tag.Form, scala.Option[String], String](tagRef, "target")
  }

  implicit class TagAttributesFrame(tag: Tag[pine.tag.Frame]) {
    def src: scala.Option[String] = tag.attr("src").asInstanceOf[scala.Option[String]]
    def src(value: String): Tag[pine.tag.Frame] = tag.setAttr("src", value)
    def name: scala.Option[String] = tag.attr("name").asInstanceOf[scala.Option[String]]
    def name(value: String): Tag[pine.tag.Frame] = tag.setAttr("name", value)
    def noresize: scala.Option[String] = tag.attr("noresize").asInstanceOf[scala.Option[String]]
    def noresize(value: String): Tag[pine.tag.Frame] = tag.setAttr("noresize", value)
    def scrolling: scala.Option[String] = tag.attr("scrolling").asInstanceOf[scala.Option[String]]
    def scrolling(value: String): Tag[pine.tag.Frame] = tag.setAttr("scrolling", value)
    def marginheight: scala.Option[String] = tag.attr("marginheight").asInstanceOf[scala.Option[String]]
    def marginheight(value: String): Tag[pine.tag.Frame] = tag.setAttr("marginheight", value)
    def marginwidth: scala.Option[String] = tag.attr("marginwidth").asInstanceOf[scala.Option[String]]
    def marginwidth(value: String): Tag[pine.tag.Frame] = tag.setAttr("marginwidth", value)
    def frameborder: scala.Option[String] = tag.attr("frameborder").asInstanceOf[scala.Option[String]]
    def frameborder(value: String): Tag[pine.tag.Frame] = tag.setAttr("frameborder", value)
  }

  implicit class TagRefAttributesFrame(tagRef: TagRef[tag.Frame]) {
    val src = new Attribute[tag.Frame, scala.Option[String], String](tagRef, "src")
    val name = new Attribute[tag.Frame, scala.Option[String], String](tagRef, "name")
    val noresize = new Attribute[tag.Frame, scala.Option[String], String](tagRef, "noresize")
    val scrolling = new Attribute[tag.Frame, scala.Option[String], String](tagRef, "scrolling")
    val marginheight = new Attribute[tag.Frame, scala.Option[String], String](tagRef, "marginheight")
    val marginwidth = new Attribute[tag.Frame, scala.Option[String], String](tagRef, "marginwidth")
    val frameborder = new Attribute[tag.Frame, scala.Option[String], String](tagRef, "frameborder")
  }

  implicit class TagAttributesFrameset(tag: Tag[pine.tag.Frameset]) {
    def cols: scala.Option[String] = tag.attr("cols").asInstanceOf[scala.Option[String]]
    def cols(value: String): Tag[pine.tag.Frameset] = tag.setAttr("cols", value)
    def rows: scala.Option[String] = tag.attr("rows").asInstanceOf[scala.Option[String]]
    def rows(value: String): Tag[pine.tag.Frameset] = tag.setAttr("rows", value)
  }

  implicit class TagRefAttributesFrameset(tagRef: TagRef[tag.Frameset]) {
    val cols = new Attribute[tag.Frameset, scala.Option[String], String](tagRef, "cols")
    val rows = new Attribute[tag.Frameset, scala.Option[String], String](tagRef, "rows")
  }

  implicit class TagAttributesHead(tag: Tag[pine.tag.Head]) {
    def profile: scala.Option[String] = tag.attr("profile").asInstanceOf[scala.Option[String]]
    def profile(value: String): Tag[pine.tag.Head] = tag.setAttr("profile", value)
  }

  implicit class TagRefAttributesHead(tagRef: TagRef[tag.Head]) {
    val profile = new Attribute[tag.Head, scala.Option[String], String](tagRef, "profile")
  }

  implicit class TagAttributesHr(tag: Tag[pine.tag.Hr]) {
    def align: scala.Option[String] = tag.attr("align").asInstanceOf[scala.Option[String]]
    def align(value: String): Tag[pine.tag.Hr] = tag.setAttr("align", value)
    def color: scala.Option[String] = tag.attr("color").asInstanceOf[scala.Option[String]]
    def color(value: String): Tag[pine.tag.Hr] = tag.setAttr("color", value)
    def noshade: Boolean = tag.attributes.contains("noshade")
    def noshade(value: Boolean): Tag[pine.tag.Hr] = if (value) tag.setAttr("noshade", "") else tag.remAttr("noshade")
    def size: scala.Option[String] = tag.attr("size").asInstanceOf[scala.Option[String]]
    def size(value: String): Tag[pine.tag.Hr] = tag.setAttr("size", value)
    def width: scala.Option[String] = tag.attr("width").asInstanceOf[scala.Option[String]]
    def width(value: String): Tag[pine.tag.Hr] = tag.setAttr("width", value)
  }

  implicit class TagRefAttributesHr(tagRef: TagRef[tag.Hr]) {
    val align = new Attribute[tag.Hr, scala.Option[String], String](tagRef, "align")
    val color = new Attribute[tag.Hr, scala.Option[String], String](tagRef, "color")
    val noshade = new Attribute[tag.Hr, Boolean, Boolean](tagRef, "noshade")
    val size = new Attribute[tag.Hr, scala.Option[String], String](tagRef, "size")
    val width = new Attribute[tag.Hr, scala.Option[String], String](tagRef, "width")
  }

  implicit class TagAttributesHtml(tag: Tag[pine.tag.Html]) {
    def manifest: scala.Option[String] = tag.attr("manifest").asInstanceOf[scala.Option[String]]
    def manifest(value: String): Tag[pine.tag.Html] = tag.setAttr("manifest", value)
    def version: scala.Option[String] = tag.attr("version").asInstanceOf[scala.Option[String]]
    def version(value: String): Tag[pine.tag.Html] = tag.setAttr("version", value)
    def xmlns: scala.Option[String] = tag.attr("xmlns").asInstanceOf[scala.Option[String]]
    def xmlns(value: String): Tag[pine.tag.Html] = tag.setAttr("xmlns", value)
  }

  implicit class TagRefAttributesHtml(tagRef: TagRef[tag.Html]) {
    val manifest = new Attribute[tag.Html, scala.Option[String], String](tagRef, "manifest")
    val version = new Attribute[tag.Html, scala.Option[String], String](tagRef, "version")
    val xmlns = new Attribute[tag.Html, scala.Option[String], String](tagRef, "xmlns")
  }

  implicit class TagAttributesIframe(tag: Tag[pine.tag.Iframe]) {
    def align: scala.Option[String] = tag.attr("align").asInstanceOf[scala.Option[String]]
    def align(value: String): Tag[pine.tag.Iframe] = tag.setAttr("align", value)
    def allowfullscreen: scala.Option[String] = tag.attr("allowfullscreen").asInstanceOf[scala.Option[String]]
    def allowfullscreen(value: String): Tag[pine.tag.Iframe] = tag.setAttr("allowfullscreen", value)
    def frameborder: scala.Option[String] = tag.attr("frameborder").asInstanceOf[scala.Option[String]]
    def frameborder(value: String): Tag[pine.tag.Iframe] = tag.setAttr("frameborder", value)
    def height: scala.Option[String] = tag.attr("height").asInstanceOf[scala.Option[String]]
    def height(value: String): Tag[pine.tag.Iframe] = tag.setAttr("height", value)
    def longdesc: scala.Option[String] = tag.attr("longdesc").asInstanceOf[scala.Option[String]]
    def longdesc(value: String): Tag[pine.tag.Iframe] = tag.setAttr("longdesc", value)
    def marginheight: scala.Option[String] = tag.attr("marginheight").asInstanceOf[scala.Option[String]]
    def marginheight(value: String): Tag[pine.tag.Iframe] = tag.setAttr("marginheight", value)
    def marginwidth: scala.Option[String] = tag.attr("marginwidth").asInstanceOf[scala.Option[String]]
    def marginwidth(value: String): Tag[pine.tag.Iframe] = tag.setAttr("marginwidth", value)
    def mozallowfullscreen: scala.Option[String] = tag.attr("mozallowfullscreen").asInstanceOf[scala.Option[String]]
    def mozallowfullscreen(value: String): Tag[pine.tag.Iframe] = tag.setAttr("mozallowfullscreen", value)
    def webkitallowfullscreen: scala.Option[String] = tag.attr("webkitallowfullscreen").asInstanceOf[scala.Option[String]]
    def webkitallowfullscreen(value: String): Tag[pine.tag.Iframe] = tag.setAttr("webkitallowfullscreen", value)
    def mozapp: scala.Option[String] = tag.attr("mozapp").asInstanceOf[scala.Option[String]]
    def mozapp(value: String): Tag[pine.tag.Iframe] = tag.setAttr("mozapp", value)
    def mozbrowser: scala.Option[String] = tag.attr("mozbrowser").asInstanceOf[scala.Option[String]]
    def mozbrowser(value: String): Tag[pine.tag.Iframe] = tag.setAttr("mozbrowser", value)
    def name: scala.Option[String] = tag.attr("name").asInstanceOf[scala.Option[String]]
    def name(value: String): Tag[pine.tag.Iframe] = tag.setAttr("name", value)
    def remote: scala.Option[String] = tag.attr("remote").asInstanceOf[scala.Option[String]]
    def remote(value: String): Tag[pine.tag.Iframe] = tag.setAttr("remote", value)
    def scrolling: scala.Option[String] = tag.attr("scrolling").asInstanceOf[scala.Option[String]]
    def scrolling(value: String): Tag[pine.tag.Iframe] = tag.setAttr("scrolling", value)
    def sandbox: scala.Option[String] = tag.attr("sandbox").asInstanceOf[scala.Option[String]]
    def sandbox(value: String): Tag[pine.tag.Iframe] = tag.setAttr("sandbox", value)
    def seamless: scala.Option[String] = tag.attr("seamless").asInstanceOf[scala.Option[String]]
    def seamless(value: String): Tag[pine.tag.Iframe] = tag.setAttr("seamless", value)
    def src: scala.Option[String] = tag.attr("src").asInstanceOf[scala.Option[String]]
    def src(value: String): Tag[pine.tag.Iframe] = tag.setAttr("src", value)
    def srcdoc: scala.Option[String] = tag.attr("srcdoc").asInstanceOf[scala.Option[String]]
    def srcdoc(value: String): Tag[pine.tag.Iframe] = tag.setAttr("srcdoc", value)
    def width: scala.Option[String] = tag.attr("width").asInstanceOf[scala.Option[String]]
    def width(value: String): Tag[pine.tag.Iframe] = tag.setAttr("width", value)
  }

  implicit class TagRefAttributesIframe(tagRef: TagRef[tag.Iframe]) {
    val align = new Attribute[tag.Iframe, scala.Option[String], String](tagRef, "align")
    val allowfullscreen = new Attribute[tag.Iframe, scala.Option[String], String](tagRef, "allowfullscreen")
    val frameborder = new Attribute[tag.Iframe, scala.Option[String], String](tagRef, "frameborder")
    val height = new Attribute[tag.Iframe, scala.Option[String], String](tagRef, "height")
    val longdesc = new Attribute[tag.Iframe, scala.Option[String], String](tagRef, "longdesc")
    val marginheight = new Attribute[tag.Iframe, scala.Option[String], String](tagRef, "marginheight")
    val marginwidth = new Attribute[tag.Iframe, scala.Option[String], String](tagRef, "marginwidth")
    val mozallowfullscreen = new Attribute[tag.Iframe, scala.Option[String], String](tagRef, "mozallowfullscreen")
    val webkitallowfullscreen = new Attribute[tag.Iframe, scala.Option[String], String](tagRef, "webkitallowfullscreen")
    val mozapp = new Attribute[tag.Iframe, scala.Option[String], String](tagRef, "mozapp")
    val mozbrowser = new Attribute[tag.Iframe, scala.Option[String], String](tagRef, "mozbrowser")
    val name = new Attribute[tag.Iframe, scala.Option[String], String](tagRef, "name")
    val remote = new Attribute[tag.Iframe, scala.Option[String], String](tagRef, "remote")
    val scrolling = new Attribute[tag.Iframe, scala.Option[String], String](tagRef, "scrolling")
    val sandbox = new Attribute[tag.Iframe, scala.Option[String], String](tagRef, "sandbox")
    val seamless = new Attribute[tag.Iframe, scala.Option[String], String](tagRef, "seamless")
    val src = new Attribute[tag.Iframe, scala.Option[String], String](tagRef, "src")
    val srcdoc = new Attribute[tag.Iframe, scala.Option[String], String](tagRef, "srcdoc")
    val width = new Attribute[tag.Iframe, scala.Option[String], String](tagRef, "width")
  }

  implicit class TagAttributesImg(tag: Tag[pine.tag.Img]) {
    def `align vertical-align`: scala.Option[String] = tag.attr("align vertical-align").asInstanceOf[scala.Option[String]]
    def `align vertical-align`(value: String): Tag[pine.tag.Img] = tag.setAttr("align vertical-align", value)
    def alt: scala.Option[String] = tag.attr("alt").asInstanceOf[scala.Option[String]]
    def alt(value: String): Tag[pine.tag.Img] = tag.setAttr("alt", value)
    def border: scala.Option[String] = tag.attr("border").asInstanceOf[scala.Option[String]]
    def border(value: String): Tag[pine.tag.Img] = tag.setAttr("border", value)
    def crossorigin: scala.Option[String] = tag.attr("crossorigin").asInstanceOf[scala.Option[String]]
    def crossorigin(value: String): Tag[pine.tag.Img] = tag.setAttr("crossorigin", value)
    def height: scala.Option[String] = tag.attr("height").asInstanceOf[scala.Option[String]]
    def height(value: String): Tag[pine.tag.Img] = tag.setAttr("height", value)
    def hspace: scala.Option[String] = tag.attr("hspace").asInstanceOf[scala.Option[String]]
    def hspace(value: String): Tag[pine.tag.Img] = tag.setAttr("hspace", value)
    def ismap: scala.Option[String] = tag.attr("ismap").asInstanceOf[scala.Option[String]]
    def ismap(value: String): Tag[pine.tag.Img] = tag.setAttr("ismap", value)
    def longdesc: scala.Option[String] = tag.attr("longdesc").asInstanceOf[scala.Option[String]]
    def longdesc(value: String): Tag[pine.tag.Img] = tag.setAttr("longdesc", value)
    def name: scala.Option[String] = tag.attr("name").asInstanceOf[scala.Option[String]]
    def name(value: String): Tag[pine.tag.Img] = tag.setAttr("name", value)
    def sizes: scala.Option[String] = tag.attr("sizes").asInstanceOf[scala.Option[String]]
    def sizes(value: String): Tag[pine.tag.Img] = tag.setAttr("sizes", value)
    def src: scala.Option[String] = tag.attr("src").asInstanceOf[scala.Option[String]]
    def src(value: String): Tag[pine.tag.Img] = tag.setAttr("src", value)
    def srcset: scala.Option[String] = tag.attr("srcset").asInstanceOf[scala.Option[String]]
    def srcset(value: String): Tag[pine.tag.Img] = tag.setAttr("srcset", value)
    def width: scala.Option[String] = tag.attr("width").asInstanceOf[scala.Option[String]]
    def width(value: String): Tag[pine.tag.Img] = tag.setAttr("width", value)
    def usemap: scala.Option[String] = tag.attr("usemap").asInstanceOf[scala.Option[String]]
    def usemap(value: String): Tag[pine.tag.Img] = tag.setAttr("usemap", value)
    def vspace: scala.Option[String] = tag.attr("vspace").asInstanceOf[scala.Option[String]]
    def vspace(value: String): Tag[pine.tag.Img] = tag.setAttr("vspace", value)
  }

  implicit class TagRefAttributesImg(tagRef: TagRef[tag.Img]) {
    val `align vertical-align` = new Attribute[tag.Img, scala.Option[String], String](tagRef, "align vertical-align")
    val alt = new Attribute[tag.Img, scala.Option[String], String](tagRef, "alt")
    val border = new Attribute[tag.Img, scala.Option[String], String](tagRef, "border")
    val crossorigin = new Attribute[tag.Img, scala.Option[String], String](tagRef, "crossorigin")
    val height = new Attribute[tag.Img, scala.Option[String], String](tagRef, "height")
    val hspace = new Attribute[tag.Img, scala.Option[String], String](tagRef, "hspace")
    val ismap = new Attribute[tag.Img, scala.Option[String], String](tagRef, "ismap")
    val longdesc = new Attribute[tag.Img, scala.Option[String], String](tagRef, "longdesc")
    val name = new Attribute[tag.Img, scala.Option[String], String](tagRef, "name")
    val sizes = new Attribute[tag.Img, scala.Option[String], String](tagRef, "sizes")
    val src = new Attribute[tag.Img, scala.Option[String], String](tagRef, "src")
    val srcset = new Attribute[tag.Img, scala.Option[String], String](tagRef, "srcset")
    val width = new Attribute[tag.Img, scala.Option[String], String](tagRef, "width")
    val usemap = new Attribute[tag.Img, scala.Option[String], String](tagRef, "usemap")
    val vspace = new Attribute[tag.Img, scala.Option[String], String](tagRef, "vspace")
  }

  implicit class TagAttributesInput(tag: Tag[pine.tag.Input]) {
    def `type`: scala.Option[String] = tag.attr("type").asInstanceOf[scala.Option[String]]
    def `type`(value: String): Tag[pine.tag.Input] = tag.setAttr("type", value)
    def accept: scala.Option[String] = tag.attr("accept").asInstanceOf[scala.Option[String]]
    def accept(value: String): Tag[pine.tag.Input] = tag.setAttr("accept", value)
    def mozactionhint: scala.Option[String] = tag.attr("mozactionhint").asInstanceOf[scala.Option[String]]
    def mozactionhint(value: String): Tag[pine.tag.Input] = tag.setAttr("mozactionhint", value)
    def autocapitalize: scala.Option[String] = tag.attr("autocapitalize").asInstanceOf[scala.Option[String]]
    def autocapitalize(value: String): Tag[pine.tag.Input] = tag.setAttr("autocapitalize", value)
    def autocomplete: scala.Option[String] = tag.attr("autocomplete").asInstanceOf[scala.Option[String]]
    def autocomplete(value: String): Tag[pine.tag.Input] = tag.setAttr("autocomplete", value)
    def autocorrect: scala.Option[String] = tag.attr("autocorrect").asInstanceOf[scala.Option[String]]
    def autocorrect(value: String): Tag[pine.tag.Input] = tag.setAttr("autocorrect", value)
    def autofocus: Boolean = tag.attributes.contains("autofocus")
    def autofocus(value: Boolean): Tag[pine.tag.Input] = if (value) tag.setAttr("autofocus", "") else tag.remAttr("autofocus")
    def autosave: scala.Option[String] = tag.attr("autosave").asInstanceOf[scala.Option[String]]
    def autosave(value: String): Tag[pine.tag.Input] = tag.setAttr("autosave", value)
    def checked: Boolean = tag.attributes.contains("checked")
    def checked(value: Boolean): Tag[pine.tag.Input] = if (value) tag.setAttr("checked", "") else tag.remAttr("checked")
    def disabled: Boolean = tag.attributes.contains("disabled")
    def disabled(value: Boolean): Tag[pine.tag.Input] = if (value) tag.setAttr("disabled", "") else tag.remAttr("disabled")
    def form: scala.Option[String] = tag.attr("form").asInstanceOf[scala.Option[String]]
    def form(value: String): Tag[pine.tag.Input] = tag.setAttr("form", value)
    def formaction: scala.Option[String] = tag.attr("formaction").asInstanceOf[scala.Option[String]]
    def formaction(value: String): Tag[pine.tag.Input] = tag.setAttr("formaction", value)
    def formenctype: scala.Option[String] = tag.attr("formenctype").asInstanceOf[scala.Option[String]]
    def formenctype(value: String): Tag[pine.tag.Input] = tag.setAttr("formenctype", value)
    def formmethod: scala.Option[String] = tag.attr("formmethod").asInstanceOf[scala.Option[String]]
    def formmethod(value: String): Tag[pine.tag.Input] = tag.setAttr("formmethod", value)
    def formnovalidate: scala.Option[String] = tag.attr("formnovalidate").asInstanceOf[scala.Option[String]]
    def formnovalidate(value: String): Tag[pine.tag.Input] = tag.setAttr("formnovalidate", value)
    def formtarget: scala.Option[String] = tag.attr("formtarget").asInstanceOf[scala.Option[String]]
    def formtarget(value: String): Tag[pine.tag.Input] = tag.setAttr("formtarget", value)
    def height: scala.Option[String] = tag.attr("height").asInstanceOf[scala.Option[String]]
    def height(value: String): Tag[pine.tag.Input] = tag.setAttr("height", value)
    def incremental: scala.Option[String] = tag.attr("incremental").asInstanceOf[scala.Option[String]]
    def incremental(value: String): Tag[pine.tag.Input] = tag.setAttr("incremental", value)
    def inputmode: scala.Option[String] = tag.attr("inputmode").asInstanceOf[scala.Option[String]]
    def inputmode(value: String): Tag[pine.tag.Input] = tag.setAttr("inputmode", value)
    def list: scala.Option[String] = tag.attr("list").asInstanceOf[scala.Option[String]]
    def list(value: String): Tag[pine.tag.Input] = tag.setAttr("list", value)
    def max: scala.Option[String] = tag.attr("max").asInstanceOf[scala.Option[String]]
    def max(value: String): Tag[pine.tag.Input] = tag.setAttr("max", value)
    def maxlength: scala.Option[String] = tag.attr("maxlength").asInstanceOf[scala.Option[String]]
    def maxlength(value: String): Tag[pine.tag.Input] = tag.setAttr("maxlength", value)
    def min: scala.Option[String] = tag.attr("min").asInstanceOf[scala.Option[String]]
    def min(value: String): Tag[pine.tag.Input] = tag.setAttr("min", value)
    def minlength: scala.Option[String] = tag.attr("minlength").asInstanceOf[scala.Option[String]]
    def minlength(value: String): Tag[pine.tag.Input] = tag.setAttr("minlength", value)
    def multiple: scala.Option[String] = tag.attr("multiple").asInstanceOf[scala.Option[String]]
    def multiple(value: String): Tag[pine.tag.Input] = tag.setAttr("multiple", value)
    def name: scala.Option[String] = tag.attr("name").asInstanceOf[scala.Option[String]]
    def name(value: String): Tag[pine.tag.Input] = tag.setAttr("name", value)
    def pattern: scala.Option[String] = tag.attr("pattern").asInstanceOf[scala.Option[String]]
    def pattern(value: String): Tag[pine.tag.Input] = tag.setAttr("pattern", value)
    def placeholder: scala.Option[String] = tag.attr("placeholder").asInstanceOf[scala.Option[String]]
    def placeholder(value: String): Tag[pine.tag.Input] = tag.setAttr("placeholder", value)
    def readonly: scala.Option[String] = tag.attr("readonly").asInstanceOf[scala.Option[String]]
    def readonly(value: String): Tag[pine.tag.Input] = tag.setAttr("readonly", value)
    def required: Boolean = tag.attributes.contains("required")
    def required(value: Boolean): Tag[pine.tag.Input] = if (value) tag.setAttr("required", "") else tag.remAttr("required")
    def results: scala.Option[String] = tag.attr("results").asInstanceOf[scala.Option[String]]
    def results(value: String): Tag[pine.tag.Input] = tag.setAttr("results", value)
    def selectionDirection: scala.Option[String] = tag.attr("selectionDirection").asInstanceOf[scala.Option[String]]
    def selectionDirection(value: String): Tag[pine.tag.Input] = tag.setAttr("selectionDirection", value)
    def size: scala.Option[Long] = tag.attr("size").asInstanceOf[scala.Option[Long]]
    def size(value: Long): Tag[pine.tag.Input] = tag.setAttr("size", value)
    def src: scala.Option[String] = tag.attr("src").asInstanceOf[scala.Option[String]]
    def src(value: String): Tag[pine.tag.Input] = tag.setAttr("src", value)
    def step: scala.Option[String] = tag.attr("step").asInstanceOf[scala.Option[String]]
    def step(value: String): Tag[pine.tag.Input] = tag.setAttr("step", value)
    def usemap: scala.Option[String] = tag.attr("usemap").asInstanceOf[scala.Option[String]]
    def usemap(value: String): Tag[pine.tag.Input] = tag.setAttr("usemap", value)
    def value: scala.Option[String] = tag.attr("value").asInstanceOf[scala.Option[String]]
    def value(value: String): Tag[pine.tag.Input] = tag.setAttr("value", value)
    def width: scala.Option[String] = tag.attr("width").asInstanceOf[scala.Option[String]]
    def width(value: String): Tag[pine.tag.Input] = tag.setAttr("width", value)
    def `x-moz-errormessage`: scala.Option[String] = tag.attr("x-moz-errormessage").asInstanceOf[scala.Option[String]]
    def `x-moz-errormessage`(value: String): Tag[pine.tag.Input] = tag.setAttr("x-moz-errormessage", value)
  }

  implicit class TagRefAttributesInput(tagRef: TagRef[tag.Input]) {
    val `type` = new Attribute[tag.Input, scala.Option[String], String](tagRef, "type")
    val accept = new Attribute[tag.Input, scala.Option[String], String](tagRef, "accept")
    val accesskey = new Attribute[tag.Input, scala.Option[String], String](tagRef, "accesskey")
    val mozactionhint = new Attribute[tag.Input, scala.Option[String], String](tagRef, "mozactionhint")
    val autocapitalize = new Attribute[tag.Input, scala.Option[String], String](tagRef, "autocapitalize")
    val autocomplete = new Attribute[tag.Input, scala.Option[String], String](tagRef, "autocomplete")
    val autocorrect = new Attribute[tag.Input, scala.Option[String], String](tagRef, "autocorrect")
    val autofocus = new Attribute[tag.Input, Boolean, Boolean](tagRef, "autofocus")
    val autosave = new Attribute[tag.Input, scala.Option[String], String](tagRef, "autosave")
    val checked = new Attribute[tag.Input, Boolean, Boolean](tagRef, "checked")
    val disabled = new Attribute[tag.Input, Boolean, Boolean](tagRef, "disabled")
    val form = new Attribute[tag.Input, scala.Option[String], String](tagRef, "form")
    val formaction = new Attribute[tag.Input, scala.Option[String], String](tagRef, "formaction")
    val formenctype = new Attribute[tag.Input, scala.Option[String], String](tagRef, "formenctype")
    val formmethod = new Attribute[tag.Input, scala.Option[String], String](tagRef, "formmethod")
    val formnovalidate = new Attribute[tag.Input, scala.Option[String], String](tagRef, "formnovalidate")
    val formtarget = new Attribute[tag.Input, scala.Option[String], String](tagRef, "formtarget")
    val height = new Attribute[tag.Input, scala.Option[String], String](tagRef, "height")
    val incremental = new Attribute[tag.Input, scala.Option[String], String](tagRef, "incremental")
    val inputmode = new Attribute[tag.Input, scala.Option[String], String](tagRef, "inputmode")
    val list = new Attribute[tag.Input, scala.Option[String], String](tagRef, "list")
    val max = new Attribute[tag.Input, scala.Option[String], String](tagRef, "max")
    val maxlength = new Attribute[tag.Input, scala.Option[String], String](tagRef, "maxlength")
    val min = new Attribute[tag.Input, scala.Option[String], String](tagRef, "min")
    val minlength = new Attribute[tag.Input, scala.Option[String], String](tagRef, "minlength")
    val multiple = new Attribute[tag.Input, scala.Option[String], String](tagRef, "multiple")
    val name = new Attribute[tag.Input, scala.Option[String], String](tagRef, "name")
    val pattern = new Attribute[tag.Input, scala.Option[String], String](tagRef, "pattern")
    val placeholder = new Attribute[tag.Input, scala.Option[String], String](tagRef, "placeholder")
    val readonly = new Attribute[tag.Input, scala.Option[String], String](tagRef, "readonly")
    val required = new Attribute[tag.Input, Boolean, Boolean](tagRef, "required")
    val results = new Attribute[tag.Input, scala.Option[String], String](tagRef, "results")
    val selectionDirection = new Attribute[tag.Input, scala.Option[String], String](tagRef, "selectionDirection")
    val size = new Attribute[tag.Input, scala.Option[Long], Long](tagRef, "size")
    val spellcheck = new Attribute[tag.Input, scala.Option[String], String](tagRef, "spellcheck")
    val src = new Attribute[tag.Input, scala.Option[String], String](tagRef, "src")
    val step = new Attribute[tag.Input, scala.Option[String], String](tagRef, "step")
    val tabindex = new Attribute[tag.Input, scala.Option[String], String](tagRef, "tabindex")
    val usemap = new Attribute[tag.Input, scala.Option[String], String](tagRef, "usemap")
    val value = new Attribute[tag.Input, scala.Option[String], String](tagRef, "value")
    val width = new Attribute[tag.Input, scala.Option[String], String](tagRef, "width")
    val `x-moz-errormessage` = new Attribute[tag.Input, scala.Option[String], String](tagRef, "x-moz-errormessage")
  }

  implicit class TagAttributesIns(tag: Tag[pine.tag.Ins]) {
    def cite: scala.Option[String] = tag.attr("cite").asInstanceOf[scala.Option[String]]
    def cite(value: String): Tag[pine.tag.Ins] = tag.setAttr("cite", value)
    def datetime: scala.Option[String] = tag.attr("datetime").asInstanceOf[scala.Option[String]]
    def datetime(value: String): Tag[pine.tag.Ins] = tag.setAttr("datetime", value)
  }

  implicit class TagRefAttributesIns(tagRef: TagRef[tag.Ins]) {
    val cite = new Attribute[tag.Ins, scala.Option[String], String](tagRef, "cite")
    val datetime = new Attribute[tag.Ins, scala.Option[String], String](tagRef, "datetime")
  }

  implicit class TagAttributesIsindex(tag: Tag[pine.tag.Isindex]) {
    def prompt: scala.Option[String] = tag.attr("prompt").asInstanceOf[scala.Option[String]]
    def prompt(value: String): Tag[pine.tag.Isindex] = tag.setAttr("prompt", value)
    def action: scala.Option[String] = tag.attr("action").asInstanceOf[scala.Option[String]]
    def action(value: String): Tag[pine.tag.Isindex] = tag.setAttr("action", value)
  }

  implicit class TagRefAttributesIsindex(tagRef: TagRef[tag.Isindex]) {
    val prompt = new Attribute[tag.Isindex, scala.Option[String], String](tagRef, "prompt")
    val action = new Attribute[tag.Isindex, scala.Option[String], String](tagRef, "action")
  }

  implicit class TagAttributesKeygen(tag: Tag[pine.tag.Keygen]) {
    def autofocus: scala.Option[String] = tag.attr("autofocus").asInstanceOf[scala.Option[String]]
    def autofocus(value: String): Tag[pine.tag.Keygen] = tag.setAttr("autofocus", value)
    def challenge: scala.Option[String] = tag.attr("challenge").asInstanceOf[scala.Option[String]]
    def challenge(value: String): Tag[pine.tag.Keygen] = tag.setAttr("challenge", value)
    def disabled: scala.Option[String] = tag.attr("disabled").asInstanceOf[scala.Option[String]]
    def disabled(value: String): Tag[pine.tag.Keygen] = tag.setAttr("disabled", value)
    def form: scala.Option[String] = tag.attr("form").asInstanceOf[scala.Option[String]]
    def form(value: String): Tag[pine.tag.Keygen] = tag.setAttr("form", value)
    def keytype: scala.Option[String] = tag.attr("keytype").asInstanceOf[scala.Option[String]]
    def keytype(value: String): Tag[pine.tag.Keygen] = tag.setAttr("keytype", value)
    def name: scala.Option[String] = tag.attr("name").asInstanceOf[scala.Option[String]]
    def name(value: String): Tag[pine.tag.Keygen] = tag.setAttr("name", value)
  }

  implicit class TagRefAttributesKeygen(tagRef: TagRef[tag.Keygen]) {
    val autofocus = new Attribute[tag.Keygen, scala.Option[String], String](tagRef, "autofocus")
    val challenge = new Attribute[tag.Keygen, scala.Option[String], String](tagRef, "challenge")
    val disabled = new Attribute[tag.Keygen, scala.Option[String], String](tagRef, "disabled")
    val form = new Attribute[tag.Keygen, scala.Option[String], String](tagRef, "form")
    val keytype = new Attribute[tag.Keygen, scala.Option[String], String](tagRef, "keytype")
    val name = new Attribute[tag.Keygen, scala.Option[String], String](tagRef, "name")
  }

  implicit class TagAttributesLabel(tag: Tag[pine.tag.Label]) {
    def `for`: scala.Option[String] = tag.attr("for").asInstanceOf[scala.Option[String]]
    def `for`(value: String): Tag[pine.tag.Label] = tag.setAttr("for", value)
    def form: scala.Option[String] = tag.attr("form").asInstanceOf[scala.Option[String]]
    def form(value: String): Tag[pine.tag.Label] = tag.setAttr("form", value)
  }

  implicit class TagRefAttributesLabel(tagRef: TagRef[tag.Label]) {
    val accesskey = new Attribute[tag.Label, scala.Option[String], String](tagRef, "accesskey")
    val `for` = new Attribute[tag.Label, scala.Option[String], String](tagRef, "for")
    val form = new Attribute[tag.Label, scala.Option[String], String](tagRef, "form")
  }

  implicit class TagAttributesLi(tag: Tag[pine.tag.Li]) {
    def value: scala.Option[Long] = tag.attr("value").asInstanceOf[scala.Option[Long]]
    def value(value: Long): Tag[pine.tag.Li] = tag.setAttr("value", value)
    def `type`: scala.Option[String] = tag.attr("type").asInstanceOf[scala.Option[String]]
    def `type`(value: String): Tag[pine.tag.Li] = tag.setAttr("type", value)
  }

  implicit class TagRefAttributesLi(tagRef: TagRef[tag.Li]) {
    val value = new Attribute[tag.Li, scala.Option[Long], Long](tagRef, "value")
    val `type` = new Attribute[tag.Li, scala.Option[String], String](tagRef, "type")
  }

  implicit class TagAttributesLink(tag: Tag[pine.tag.Link]) {
    def charset: scala.Option[String] = tag.attr("charset").asInstanceOf[scala.Option[String]]
    def charset(value: String): Tag[pine.tag.Link] = tag.setAttr("charset", value)
    def crossorigin: scala.Option[String] = tag.attr("crossorigin").asInstanceOf[scala.Option[String]]
    def crossorigin(value: String): Tag[pine.tag.Link] = tag.setAttr("crossorigin", value)
    def disabled: scala.Option[String] = tag.attr("disabled").asInstanceOf[scala.Option[String]]
    def disabled(value: String): Tag[pine.tag.Link] = tag.setAttr("disabled", value)
    def href: scala.Option[String] = tag.attr("href").asInstanceOf[scala.Option[String]]
    def href(value: String): Tag[pine.tag.Link] = tag.setAttr("href", value)
    def hreflang: scala.Option[String] = tag.attr("hreflang").asInstanceOf[scala.Option[String]]
    def hreflang(value: String): Tag[pine.tag.Link] = tag.setAttr("hreflang", value)
    def media: scala.Option[String] = tag.attr("media").asInstanceOf[scala.Option[String]]
    def media(value: String): Tag[pine.tag.Link] = tag.setAttr("media", value)
    def methods: scala.Option[String] = tag.attr("methods").asInstanceOf[scala.Option[String]]
    def methods(value: String): Tag[pine.tag.Link] = tag.setAttr("methods", value)
    def rel: scala.Option[String] = tag.attr("rel").asInstanceOf[scala.Option[String]]
    def rel(value: String): Tag[pine.tag.Link] = tag.setAttr("rel", value)
    def rev: scala.Option[String] = tag.attr("rev").asInstanceOf[scala.Option[String]]
    def rev(value: String): Tag[pine.tag.Link] = tag.setAttr("rev", value)
    def sizes: scala.Option[String] = tag.attr("sizes").asInstanceOf[scala.Option[String]]
    def sizes(value: String): Tag[pine.tag.Link] = tag.setAttr("sizes", value)
    def target: scala.Option[String] = tag.attr("target").asInstanceOf[scala.Option[String]]
    def target(value: String): Tag[pine.tag.Link] = tag.setAttr("target", value)
    def `type`: scala.Option[String] = tag.attr("type").asInstanceOf[scala.Option[String]]
    def `type`(value: String): Tag[pine.tag.Link] = tag.setAttr("type", value)
    def integrity: scala.Option[String] = tag.attr("integrity").asInstanceOf[scala.Option[String]]
    def integrity(value: String): Tag[pine.tag.Link] = tag.setAttr("integrity", value)
  }

  implicit class TagRefAttributesLink(tagRef: TagRef[tag.Link]) {
    val charset = new Attribute[tag.Link, scala.Option[String], String](tagRef, "charset")
    val crossorigin = new Attribute[tag.Link, scala.Option[String], String](tagRef, "crossorigin")
    val disabled = new Attribute[tag.Link, scala.Option[String], String](tagRef, "disabled")
    val href = new Attribute[tag.Link, scala.Option[String], String](tagRef, "href")
    val hreflang = new Attribute[tag.Link, scala.Option[String], String](tagRef, "hreflang")
    val media = new Attribute[tag.Link, scala.Option[String], String](tagRef, "media")
    val methods = new Attribute[tag.Link, scala.Option[String], String](tagRef, "methods")
    val rel = new Attribute[tag.Link, scala.Option[String], String](tagRef, "rel")
    val rev = new Attribute[tag.Link, scala.Option[String], String](tagRef, "rev")
    val sizes = new Attribute[tag.Link, scala.Option[String], String](tagRef, "sizes")
    val target = new Attribute[tag.Link, scala.Option[String], String](tagRef, "target")
    val `type` = new Attribute[tag.Link, scala.Option[String], String](tagRef, "type")
    val integrity = new Attribute[tag.Link, scala.Option[String], String](tagRef, "integrity")
  }

  implicit class TagAttributesMap(tag: Tag[pine.tag.Map]) {
    def name: scala.Option[String] = tag.attr("name").asInstanceOf[scala.Option[String]]
    def name(value: String): Tag[pine.tag.Map] = tag.setAttr("name", value)
  }

  implicit class TagRefAttributesMap(tagRef: TagRef[tag.Map]) {
    val name = new Attribute[tag.Map, scala.Option[String], String](tagRef, "name")
  }

  implicit class TagAttributesMenu(tag: Tag[pine.tag.Menu]) {
    def label: scala.Option[String] = tag.attr("label").asInstanceOf[scala.Option[String]]
    def label(value: String): Tag[pine.tag.Menu] = tag.setAttr("label", value)
    def `type`: scala.Option[String] = tag.attr("type").asInstanceOf[scala.Option[String]]
    def `type`(value: String): Tag[pine.tag.Menu] = tag.setAttr("type", value)
  }

  implicit class TagRefAttributesMenu(tagRef: TagRef[tag.Menu]) {
    val label = new Attribute[tag.Menu, scala.Option[String], String](tagRef, "label")
    val `type` = new Attribute[tag.Menu, scala.Option[String], String](tagRef, "type")
  }

  implicit class TagAttributesMenuitem(tag: Tag[pine.tag.Menuitem]) {
    def checked: scala.Option[String] = tag.attr("checked").asInstanceOf[scala.Option[String]]
    def checked(value: String): Tag[pine.tag.Menuitem] = tag.setAttr("checked", value)
    def command: scala.Option[String] = tag.attr("command").asInstanceOf[scala.Option[String]]
    def command(value: String): Tag[pine.tag.Menuitem] = tag.setAttr("command", value)
    def default: scala.Option[String] = tag.attr("default").asInstanceOf[scala.Option[String]]
    def default(value: String): Tag[pine.tag.Menuitem] = tag.setAttr("default", value)
    def disabled: scala.Option[String] = tag.attr("disabled").asInstanceOf[scala.Option[String]]
    def disabled(value: String): Tag[pine.tag.Menuitem] = tag.setAttr("disabled", value)
    def icon: scala.Option[String] = tag.attr("icon").asInstanceOf[scala.Option[String]]
    def icon(value: String): Tag[pine.tag.Menuitem] = tag.setAttr("icon", value)
    def label: scala.Option[String] = tag.attr("label").asInstanceOf[scala.Option[String]]
    def label(value: String): Tag[pine.tag.Menuitem] = tag.setAttr("label", value)
    def radiogroup: scala.Option[String] = tag.attr("radiogroup").asInstanceOf[scala.Option[String]]
    def radiogroup(value: String): Tag[pine.tag.Menuitem] = tag.setAttr("radiogroup", value)
    def `type`: scala.Option[String] = tag.attr("type").asInstanceOf[scala.Option[String]]
    def `type`(value: String): Tag[pine.tag.Menuitem] = tag.setAttr("type", value)
  }

  implicit class TagRefAttributesMenuitem(tagRef: TagRef[tag.Menuitem]) {
    val checked = new Attribute[tag.Menuitem, scala.Option[String], String](tagRef, "checked")
    val command = new Attribute[tag.Menuitem, scala.Option[String], String](tagRef, "command")
    val default = new Attribute[tag.Menuitem, scala.Option[String], String](tagRef, "default")
    val disabled = new Attribute[tag.Menuitem, scala.Option[String], String](tagRef, "disabled")
    val icon = new Attribute[tag.Menuitem, scala.Option[String], String](tagRef, "icon")
    val label = new Attribute[tag.Menuitem, scala.Option[String], String](tagRef, "label")
    val radiogroup = new Attribute[tag.Menuitem, scala.Option[String], String](tagRef, "radiogroup")
    val `type` = new Attribute[tag.Menuitem, scala.Option[String], String](tagRef, "type")
  }

  implicit class TagAttributesMeta(tag: Tag[pine.tag.Meta]) {
    def charset: scala.Option[String] = tag.attr("charset").asInstanceOf[scala.Option[String]]
    def charset(value: String): Tag[pine.tag.Meta] = tag.setAttr("charset", value)
    def content: scala.Option[String] = tag.attr("content").asInstanceOf[scala.Option[String]]
    def content(value: String): Tag[pine.tag.Meta] = tag.setAttr("content", value)
    def `http-equiv`: scala.Option[String] = tag.attr("http-equiv").asInstanceOf[scala.Option[String]]
    def `http-equiv`(value: String): Tag[pine.tag.Meta] = tag.setAttr("http-equiv", value)
    def name: scala.Option[String] = tag.attr("name").asInstanceOf[scala.Option[String]]
    def name(value: String): Tag[pine.tag.Meta] = tag.setAttr("name", value)
    def scheme: scala.Option[String] = tag.attr("scheme").asInstanceOf[scala.Option[String]]
    def scheme(value: String): Tag[pine.tag.Meta] = tag.setAttr("scheme", value)
  }

  implicit class TagRefAttributesMeta(tagRef: TagRef[tag.Meta]) {
    val charset = new Attribute[tag.Meta, scala.Option[String], String](tagRef, "charset")
    val content = new Attribute[tag.Meta, scala.Option[String], String](tagRef, "content")
    val `http-equiv` = new Attribute[tag.Meta, scala.Option[String], String](tagRef, "http-equiv")
    val name = new Attribute[tag.Meta, scala.Option[String], String](tagRef, "name")
    val scheme = new Attribute[tag.Meta, scala.Option[String], String](tagRef, "scheme")
  }

  implicit class TagAttributesMeter(tag: Tag[pine.tag.Meter]) {
    def value: scala.Option[String] = tag.attr("value").asInstanceOf[scala.Option[String]]
    def value(value: String): Tag[pine.tag.Meter] = tag.setAttr("value", value)
    def min: scala.Option[Double] = tag.attr("min").asInstanceOf[scala.Option[Double]]
    def min(value: Double): Tag[pine.tag.Meter] = tag.setAttr("min", value)
    def max: scala.Option[Double] = tag.attr("max").asInstanceOf[scala.Option[Double]]
    def max(value: Double): Tag[pine.tag.Meter] = tag.setAttr("max", value)
    def low: scala.Option[Double] = tag.attr("low").asInstanceOf[scala.Option[Double]]
    def low(value: Double): Tag[pine.tag.Meter] = tag.setAttr("low", value)
    def high: scala.Option[Double] = tag.attr("high").asInstanceOf[scala.Option[Double]]
    def high(value: Double): Tag[pine.tag.Meter] = tag.setAttr("high", value)
    def optimum: scala.Option[Double] = tag.attr("optimum").asInstanceOf[scala.Option[Double]]
    def optimum(value: Double): Tag[pine.tag.Meter] = tag.setAttr("optimum", value)
    def form: scala.Option[String] = tag.attr("form").asInstanceOf[scala.Option[String]]
    def form(value: String): Tag[pine.tag.Meter] = tag.setAttr("form", value)
  }

  implicit class TagRefAttributesMeter(tagRef: TagRef[tag.Meter]) {
    val value = new Attribute[tag.Meter, scala.Option[String], String](tagRef, "value")
    val min = new Attribute[tag.Meter, scala.Option[Double], Double](tagRef, "min")
    val max = new Attribute[tag.Meter, scala.Option[Double], Double](tagRef, "max")
    val low = new Attribute[tag.Meter, scala.Option[Double], Double](tagRef, "low")
    val high = new Attribute[tag.Meter, scala.Option[Double], Double](tagRef, "high")
    val optimum = new Attribute[tag.Meter, scala.Option[Double], Double](tagRef, "optimum")
    val form = new Attribute[tag.Meter, scala.Option[String], String](tagRef, "form")
  }

  implicit class TagAttributesObject(tag: Tag[pine.tag.Object]) {
    def archive: scala.Option[String] = tag.attr("archive").asInstanceOf[scala.Option[String]]
    def archive(value: String): Tag[pine.tag.Object] = tag.setAttr("archive", value)
    def border: scala.Option[String] = tag.attr("border").asInstanceOf[scala.Option[String]]
    def border(value: String): Tag[pine.tag.Object] = tag.setAttr("border", value)
    def classid: scala.Option[String] = tag.attr("classid").asInstanceOf[scala.Option[String]]
    def classid(value: String): Tag[pine.tag.Object] = tag.setAttr("classid", value)
    def codebase: scala.Option[String] = tag.attr("codebase").asInstanceOf[scala.Option[String]]
    def codebase(value: String): Tag[pine.tag.Object] = tag.setAttr("codebase", value)
    def codetype: scala.Option[String] = tag.attr("codetype").asInstanceOf[scala.Option[String]]
    def codetype(value: String): Tag[pine.tag.Object] = tag.setAttr("codetype", value)
    def data: scala.Option[String] = tag.attr("data").asInstanceOf[scala.Option[String]]
    def data(value: String): Tag[pine.tag.Object] = tag.setAttr("data", value)
    def declare: scala.Option[String] = tag.attr("declare").asInstanceOf[scala.Option[String]]
    def declare(value: String): Tag[pine.tag.Object] = tag.setAttr("declare", value)
    def form: scala.Option[String] = tag.attr("form").asInstanceOf[scala.Option[String]]
    def form(value: String): Tag[pine.tag.Object] = tag.setAttr("form", value)
    def height: scala.Option[String] = tag.attr("height").asInstanceOf[scala.Option[String]]
    def height(value: String): Tag[pine.tag.Object] = tag.setAttr("height", value)
    def name: scala.Option[String] = tag.attr("name").asInstanceOf[scala.Option[String]]
    def name(value: String): Tag[pine.tag.Object] = tag.setAttr("name", value)
    def standby: scala.Option[String] = tag.attr("standby").asInstanceOf[scala.Option[String]]
    def standby(value: String): Tag[pine.tag.Object] = tag.setAttr("standby", value)
    def `type`: scala.Option[String] = tag.attr("type").asInstanceOf[scala.Option[String]]
    def `type`(value: String): Tag[pine.tag.Object] = tag.setAttr("type", value)
    def typemustmatch: scala.Option[String] = tag.attr("typemustmatch").asInstanceOf[scala.Option[String]]
    def typemustmatch(value: String): Tag[pine.tag.Object] = tag.setAttr("typemustmatch", value)
    def usemap: scala.Option[String] = tag.attr("usemap").asInstanceOf[scala.Option[String]]
    def usemap(value: String): Tag[pine.tag.Object] = tag.setAttr("usemap", value)
    def width: scala.Option[String] = tag.attr("width").asInstanceOf[scala.Option[String]]
    def width(value: String): Tag[pine.tag.Object] = tag.setAttr("width", value)
  }

  implicit class TagRefAttributesObject(tagRef: TagRef[tag.Object]) {
    val archive = new Attribute[tag.Object, scala.Option[String], String](tagRef, "archive")
    val border = new Attribute[tag.Object, scala.Option[String], String](tagRef, "border")
    val classid = new Attribute[tag.Object, scala.Option[String], String](tagRef, "classid")
    val codebase = new Attribute[tag.Object, scala.Option[String], String](tagRef, "codebase")
    val codetype = new Attribute[tag.Object, scala.Option[String], String](tagRef, "codetype")
    val data = new Attribute[tag.Object, scala.Option[String], String](tagRef, "data")
    val declare = new Attribute[tag.Object, scala.Option[String], String](tagRef, "declare")
    val form = new Attribute[tag.Object, scala.Option[String], String](tagRef, "form")
    val height = new Attribute[tag.Object, scala.Option[String], String](tagRef, "height")
    val name = new Attribute[tag.Object, scala.Option[String], String](tagRef, "name")
    val standby = new Attribute[tag.Object, scala.Option[String], String](tagRef, "standby")
    val tabindex = new Attribute[tag.Object, scala.Option[String], String](tagRef, "tabindex")
    val `type` = new Attribute[tag.Object, scala.Option[String], String](tagRef, "type")
    val typemustmatch = new Attribute[tag.Object, scala.Option[String], String](tagRef, "typemustmatch")
    val usemap = new Attribute[tag.Object, scala.Option[String], String](tagRef, "usemap")
    val width = new Attribute[tag.Object, scala.Option[String], String](tagRef, "width")
  }

  implicit class TagAttributesOl(tag: Tag[pine.tag.Ol]) {
    def compact: scala.Option[String] = tag.attr("compact").asInstanceOf[scala.Option[String]]
    def compact(value: String): Tag[pine.tag.Ol] = tag.setAttr("compact", value)
    def reversed: scala.Option[String] = tag.attr("reversed").asInstanceOf[scala.Option[String]]
    def reversed(value: String): Tag[pine.tag.Ol] = tag.setAttr("reversed", value)
    def start: scala.Option[String] = tag.attr("start").asInstanceOf[scala.Option[String]]
    def start(value: String): Tag[pine.tag.Ol] = tag.setAttr("start", value)
    def `type`: scala.Option[String] = tag.attr("type").asInstanceOf[scala.Option[String]]
    def `type`(value: String): Tag[pine.tag.Ol] = tag.setAttr("type", value)
  }

  implicit class TagRefAttributesOl(tagRef: TagRef[tag.Ol]) {
    val compact = new Attribute[tag.Ol, scala.Option[String], String](tagRef, "compact")
    val reversed = new Attribute[tag.Ol, scala.Option[String], String](tagRef, "reversed")
    val start = new Attribute[tag.Ol, scala.Option[String], String](tagRef, "start")
    val `type` = new Attribute[tag.Ol, scala.Option[String], String](tagRef, "type")
  }

  implicit class TagAttributesOptgroup(tag: Tag[pine.tag.Optgroup]) {
    def disabled: Boolean = tag.attributes.contains("disabled")
    def disabled(value: Boolean): Tag[pine.tag.Optgroup] = if (value) tag.setAttr("disabled", "") else tag.remAttr("disabled")
    def label: scala.Option[String] = tag.attr("label").asInstanceOf[scala.Option[String]]
    def label(value: String): Tag[pine.tag.Optgroup] = tag.setAttr("label", value)
  }

  implicit class TagRefAttributesOptgroup(tagRef: TagRef[tag.Optgroup]) {
    val disabled = new Attribute[tag.Optgroup, Boolean, Boolean](tagRef, "disabled")
    val label = new Attribute[tag.Optgroup, scala.Option[String], String](tagRef, "label")
  }

  implicit class TagAttributesOption(tag: Tag[pine.tag.Option]) {
    def disabled: scala.Option[String] = tag.attr("disabled").asInstanceOf[scala.Option[String]]
    def disabled(value: String): Tag[pine.tag.Option] = tag.setAttr("disabled", value)
    def label: scala.Option[String] = tag.attr("label").asInstanceOf[scala.Option[String]]
    def label(value: String): Tag[pine.tag.Option] = tag.setAttr("label", value)
    def selected: scala.Option[String] = tag.attr("selected").asInstanceOf[scala.Option[String]]
    def selected(value: String): Tag[pine.tag.Option] = tag.setAttr("selected", value)
    def value: scala.Option[String] = tag.attr("value").asInstanceOf[scala.Option[String]]
    def value(value: String): Tag[pine.tag.Option] = tag.setAttr("value", value)
  }

  implicit class TagRefAttributesOption(tagRef: TagRef[tag.Option]) {
    val disabled = new Attribute[tag.Option, scala.Option[String], String](tagRef, "disabled")
    val label = new Attribute[tag.Option, scala.Option[String], String](tagRef, "label")
    val selected = new Attribute[tag.Option, scala.Option[String], String](tagRef, "selected")
    val value = new Attribute[tag.Option, scala.Option[String], String](tagRef, "value")
  }

  implicit class TagAttributesOutput(tag: Tag[pine.tag.Output]) {
    def `for`: scala.Option[String] = tag.attr("for").asInstanceOf[scala.Option[String]]
    def `for`(value: String): Tag[pine.tag.Output] = tag.setAttr("for", value)
    def form: scala.Option[String] = tag.attr("form").asInstanceOf[scala.Option[String]]
    def form(value: String): Tag[pine.tag.Output] = tag.setAttr("form", value)
    def name: scala.Option[String] = tag.attr("name").asInstanceOf[scala.Option[String]]
    def name(value: String): Tag[pine.tag.Output] = tag.setAttr("name", value)
  }

  implicit class TagRefAttributesOutput(tagRef: TagRef[tag.Output]) {
    val `for` = new Attribute[tag.Output, scala.Option[String], String](tagRef, "for")
    val form = new Attribute[tag.Output, scala.Option[String], String](tagRef, "form")
    val name = new Attribute[tag.Output, scala.Option[String], String](tagRef, "name")
  }

  implicit class TagAttributesParam(tag: Tag[pine.tag.Param]) {
    def name: scala.Option[String] = tag.attr("name").asInstanceOf[scala.Option[String]]
    def name(value: String): Tag[pine.tag.Param] = tag.setAttr("name", value)
    def `type`: scala.Option[String] = tag.attr("type").asInstanceOf[scala.Option[String]]
    def `type`(value: String): Tag[pine.tag.Param] = tag.setAttr("type", value)
    def value: scala.Option[String] = tag.attr("value").asInstanceOf[scala.Option[String]]
    def value(value: String): Tag[pine.tag.Param] = tag.setAttr("value", value)
    def valuetype: scala.Option[String] = tag.attr("valuetype").asInstanceOf[scala.Option[String]]
    def valuetype(value: String): Tag[pine.tag.Param] = tag.setAttr("valuetype", value)
  }

  implicit class TagRefAttributesParam(tagRef: TagRef[tag.Param]) {
    val name = new Attribute[tag.Param, scala.Option[String], String](tagRef, "name")
    val `type` = new Attribute[tag.Param, scala.Option[String], String](tagRef, "type")
    val value = new Attribute[tag.Param, scala.Option[String], String](tagRef, "value")
    val valuetype = new Attribute[tag.Param, scala.Option[String], String](tagRef, "valuetype")
  }

  implicit class TagAttributesPre(tag: Tag[pine.tag.Pre]) {
    def cols: scala.Option[String] = tag.attr("cols").asInstanceOf[scala.Option[String]]
    def cols(value: String): Tag[pine.tag.Pre] = tag.setAttr("cols", value)
    def width: scala.Option[String] = tag.attr("width").asInstanceOf[scala.Option[String]]
    def width(value: String): Tag[pine.tag.Pre] = tag.setAttr("width", value)
    def wrap: scala.Option[String] = tag.attr("wrap").asInstanceOf[scala.Option[String]]
    def wrap(value: String): Tag[pine.tag.Pre] = tag.setAttr("wrap", value)
  }

  implicit class TagRefAttributesPre(tagRef: TagRef[tag.Pre]) {
    val cols = new Attribute[tag.Pre, scala.Option[String], String](tagRef, "cols")
    val width = new Attribute[tag.Pre, scala.Option[String], String](tagRef, "width")
    val wrap = new Attribute[tag.Pre, scala.Option[String], String](tagRef, "wrap")
  }

  implicit class TagAttributesProgress(tag: Tag[pine.tag.Progress]) {
    def max: scala.Option[String] = tag.attr("max").asInstanceOf[scala.Option[String]]
    def max(value: String): Tag[pine.tag.Progress] = tag.setAttr("max", value)
    def value: scala.Option[String] = tag.attr("value").asInstanceOf[scala.Option[String]]
    def value(value: String): Tag[pine.tag.Progress] = tag.setAttr("value", value)
  }

  implicit class TagRefAttributesProgress(tagRef: TagRef[tag.Progress]) {
    val max = new Attribute[tag.Progress, scala.Option[String], String](tagRef, "max")
    val value = new Attribute[tag.Progress, scala.Option[String], String](tagRef, "value")
  }

  implicit class TagAttributesScript(tag: Tag[pine.tag.Script]) {
    def async: scala.Option[String] = tag.attr("async").asInstanceOf[scala.Option[String]]
    def async(value: String): Tag[pine.tag.Script] = tag.setAttr("async", value)
    def src: scala.Option[String] = tag.attr("src").asInstanceOf[scala.Option[String]]
    def src(value: String): Tag[pine.tag.Script] = tag.setAttr("src", value)
    def `type`: scala.Option[String] = tag.attr("type").asInstanceOf[scala.Option[String]]
    def `type`(value: String): Tag[pine.tag.Script] = tag.setAttr("type", value)
    def language: scala.Option[String] = tag.attr("language").asInstanceOf[scala.Option[String]]
    def language(value: String): Tag[pine.tag.Script] = tag.setAttr("language", value)
    def defer: scala.Option[String] = tag.attr("defer").asInstanceOf[scala.Option[String]]
    def defer(value: String): Tag[pine.tag.Script] = tag.setAttr("defer", value)
    def crossorigin: scala.Option[String] = tag.attr("crossorigin").asInstanceOf[scala.Option[String]]
    def crossorigin(value: String): Tag[pine.tag.Script] = tag.setAttr("crossorigin", value)
    def integrity: scala.Option[String] = tag.attr("integrity").asInstanceOf[scala.Option[String]]
    def integrity(value: String): Tag[pine.tag.Script] = tag.setAttr("integrity", value)
  }

  implicit class TagRefAttributesScript(tagRef: TagRef[tag.Script]) {
    val async = new Attribute[tag.Script, scala.Option[String], String](tagRef, "async")
    val src = new Attribute[tag.Script, scala.Option[String], String](tagRef, "src")
    val `type` = new Attribute[tag.Script, scala.Option[String], String](tagRef, "type")
    val language = new Attribute[tag.Script, scala.Option[String], String](tagRef, "language")
    val defer = new Attribute[tag.Script, scala.Option[String], String](tagRef, "defer")
    val crossorigin = new Attribute[tag.Script, scala.Option[String], String](tagRef, "crossorigin")
    val integrity = new Attribute[tag.Script, scala.Option[String], String](tagRef, "integrity")
  }

  implicit class TagAttributesSelect(tag: Tag[pine.tag.Select]) {
    def autofocus: scala.Option[String] = tag.attr("autofocus").asInstanceOf[scala.Option[String]]
    def autofocus(value: String): Tag[pine.tag.Select] = tag.setAttr("autofocus", value)
    def disabled: scala.Option[String] = tag.attr("disabled").asInstanceOf[scala.Option[String]]
    def disabled(value: String): Tag[pine.tag.Select] = tag.setAttr("disabled", value)
    def form: scala.Option[String] = tag.attr("form").asInstanceOf[scala.Option[String]]
    def form(value: String): Tag[pine.tag.Select] = tag.setAttr("form", value)
    def multiple: scala.Option[String] = tag.attr("multiple").asInstanceOf[scala.Option[String]]
    def multiple(value: String): Tag[pine.tag.Select] = tag.setAttr("multiple", value)
    def name: scala.Option[String] = tag.attr("name").asInstanceOf[scala.Option[String]]
    def name(value: String): Tag[pine.tag.Select] = tag.setAttr("name", value)
    def required: scala.Option[String] = tag.attr("required").asInstanceOf[scala.Option[String]]
    def required(value: String): Tag[pine.tag.Select] = tag.setAttr("required", value)
    def size: scala.Option[String] = tag.attr("size").asInstanceOf[scala.Option[String]]
    def size(value: String): Tag[pine.tag.Select] = tag.setAttr("size", value)
  }

  implicit class TagRefAttributesSelect(tagRef: TagRef[tag.Select]) {
    val autofocus = new Attribute[tag.Select, scala.Option[String], String](tagRef, "autofocus")
    val disabled = new Attribute[tag.Select, scala.Option[String], String](tagRef, "disabled")
    val form = new Attribute[tag.Select, scala.Option[String], String](tagRef, "form")
    val multiple = new Attribute[tag.Select, scala.Option[String], String](tagRef, "multiple")
    val name = new Attribute[tag.Select, scala.Option[String], String](tagRef, "name")
    val required = new Attribute[tag.Select, scala.Option[String], String](tagRef, "required")
    val size = new Attribute[tag.Select, scala.Option[String], String](tagRef, "size")
  }

  implicit class TagAttributesSource(tag: Tag[pine.tag.Source]) {
    def sizes: scala.Option[String] = tag.attr("sizes").asInstanceOf[scala.Option[String]]
    def sizes(value: String): Tag[pine.tag.Source] = tag.setAttr("sizes", value)
    def src: scala.Option[String] = tag.attr("src").asInstanceOf[scala.Option[String]]
    def src(value: String): Tag[pine.tag.Source] = tag.setAttr("src", value)
    def srcset: scala.Option[String] = tag.attr("srcset").asInstanceOf[scala.Option[String]]
    def srcset(value: String): Tag[pine.tag.Source] = tag.setAttr("srcset", value)
    def `type`: scala.Option[String] = tag.attr("type").asInstanceOf[scala.Option[String]]
    def `type`(value: String): Tag[pine.tag.Source] = tag.setAttr("type", value)
    def media: scala.Option[String] = tag.attr("media").asInstanceOf[scala.Option[String]]
    def media(value: String): Tag[pine.tag.Source] = tag.setAttr("media", value)
  }

  implicit class TagRefAttributesSource(tagRef: TagRef[tag.Source]) {
    val sizes = new Attribute[tag.Source, scala.Option[String], String](tagRef, "sizes")
    val src = new Attribute[tag.Source, scala.Option[String], String](tagRef, "src")
    val srcset = new Attribute[tag.Source, scala.Option[String], String](tagRef, "srcset")
    val `type` = new Attribute[tag.Source, scala.Option[String], String](tagRef, "type")
    val media = new Attribute[tag.Source, scala.Option[String], String](tagRef, "media")
  }

  implicit class TagAttributesSpacer(tag: Tag[pine.tag.Spacer]) {
    def `type`: scala.Option[String] = tag.attr("type").asInstanceOf[scala.Option[String]]
    def `type`(value: String): Tag[pine.tag.Spacer] = tag.setAttr("type", value)
    def size: scala.Option[String] = tag.attr("size").asInstanceOf[scala.Option[String]]
    def size(value: String): Tag[pine.tag.Spacer] = tag.setAttr("size", value)
    def width: scala.Option[String] = tag.attr("width").asInstanceOf[scala.Option[String]]
    def width(value: String): Tag[pine.tag.Spacer] = tag.setAttr("width", value)
    def height: scala.Option[String] = tag.attr("height").asInstanceOf[scala.Option[String]]
    def height(value: String): Tag[pine.tag.Spacer] = tag.setAttr("height", value)
    def align: scala.Option[String] = tag.attr("align").asInstanceOf[scala.Option[String]]
    def align(value: String): Tag[pine.tag.Spacer] = tag.setAttr("align", value)
  }

  implicit class TagRefAttributesSpacer(tagRef: TagRef[tag.Spacer]) {
    val `type` = new Attribute[tag.Spacer, scala.Option[String], String](tagRef, "type")
    val size = new Attribute[tag.Spacer, scala.Option[String], String](tagRef, "size")
    val width = new Attribute[tag.Spacer, scala.Option[String], String](tagRef, "width")
    val height = new Attribute[tag.Spacer, scala.Option[String], String](tagRef, "height")
    val align = new Attribute[tag.Spacer, scala.Option[String], String](tagRef, "align")
  }

  implicit class TagAttributesStyle(tag: Tag[pine.tag.Style]) {
    def `type`: scala.Option[String] = tag.attr("type").asInstanceOf[scala.Option[String]]
    def `type`(value: String): Tag[pine.tag.Style] = tag.setAttr("type", value)
    def media: scala.Option[String] = tag.attr("media").asInstanceOf[scala.Option[String]]
    def media(value: String): Tag[pine.tag.Style] = tag.setAttr("media", value)
    def scoped: scala.Option[String] = tag.attr("scoped").asInstanceOf[scala.Option[String]]
    def scoped(value: String): Tag[pine.tag.Style] = tag.setAttr("scoped", value)
    def disabled: scala.Option[String] = tag.attr("disabled").asInstanceOf[scala.Option[String]]
    def disabled(value: String): Tag[pine.tag.Style] = tag.setAttr("disabled", value)
  }

  implicit class TagRefAttributesStyle(tagRef: TagRef[tag.Style]) {
    val `type` = new Attribute[tag.Style, scala.Option[String], String](tagRef, "type")
    val media = new Attribute[tag.Style, scala.Option[String], String](tagRef, "media")
    val scoped = new Attribute[tag.Style, scala.Option[String], String](tagRef, "scoped")
    val title = new Attribute[tag.Style, scala.Option[String], String](tagRef, "title")
    val disabled = new Attribute[tag.Style, scala.Option[String], String](tagRef, "disabled")
  }

  implicit class TagAttributesTable(tag: Tag[pine.tag.Table]) {
    def align: scala.Option[String] = tag.attr("align").asInstanceOf[scala.Option[String]]
    def align(value: String): Tag[pine.tag.Table] = tag.setAttr("align", value)
    def bgcolor: scala.Option[String] = tag.attr("bgcolor").asInstanceOf[scala.Option[String]]
    def bgcolor(value: String): Tag[pine.tag.Table] = tag.setAttr("bgcolor", value)
    def border: scala.Option[String] = tag.attr("border").asInstanceOf[scala.Option[String]]
    def border(value: String): Tag[pine.tag.Table] = tag.setAttr("border", value)
    def cellpadding: scala.Option[String] = tag.attr("cellpadding").asInstanceOf[scala.Option[String]]
    def cellpadding(value: String): Tag[pine.tag.Table] = tag.setAttr("cellpadding", value)
    def cellspacing: scala.Option[String] = tag.attr("cellspacing").asInstanceOf[scala.Option[String]]
    def cellspacing(value: String): Tag[pine.tag.Table] = tag.setAttr("cellspacing", value)
    def frame: scala.Option[String] = tag.attr("frame").asInstanceOf[scala.Option[String]]
    def frame(value: String): Tag[pine.tag.Table] = tag.setAttr("frame", value)
    def rules: scala.Option[String] = tag.attr("rules").asInstanceOf[scala.Option[String]]
    def rules(value: String): Tag[pine.tag.Table] = tag.setAttr("rules", value)
    def summary: scala.Option[String] = tag.attr("summary").asInstanceOf[scala.Option[String]]
    def summary(value: String): Tag[pine.tag.Table] = tag.setAttr("summary", value)
    def width: scala.Option[String] = tag.attr("width").asInstanceOf[scala.Option[String]]
    def width(value: String): Tag[pine.tag.Table] = tag.setAttr("width", value)
  }

  implicit class TagRefAttributesTable(tagRef: TagRef[tag.Table]) {
    val align = new Attribute[tag.Table, scala.Option[String], String](tagRef, "align")
    val bgcolor = new Attribute[tag.Table, scala.Option[String], String](tagRef, "bgcolor")
    val border = new Attribute[tag.Table, scala.Option[String], String](tagRef, "border")
    val cellpadding = new Attribute[tag.Table, scala.Option[String], String](tagRef, "cellpadding")
    val cellspacing = new Attribute[tag.Table, scala.Option[String], String](tagRef, "cellspacing")
    val frame = new Attribute[tag.Table, scala.Option[String], String](tagRef, "frame")
    val rules = new Attribute[tag.Table, scala.Option[String], String](tagRef, "rules")
    val summary = new Attribute[tag.Table, scala.Option[String], String](tagRef, "summary")
    val width = new Attribute[tag.Table, scala.Option[String], String](tagRef, "width")
  }

  implicit class TagAttributesTbody(tag: Tag[pine.tag.Tbody]) {
    def align: scala.Option[String] = tag.attr("align").asInstanceOf[scala.Option[String]]
    def align(value: String): Tag[pine.tag.Tbody] = tag.setAttr("align", value)
    def bgcolor: scala.Option[String] = tag.attr("bgcolor").asInstanceOf[scala.Option[String]]
    def bgcolor(value: String): Tag[pine.tag.Tbody] = tag.setAttr("bgcolor", value)
    def char: scala.Option[String] = tag.attr("char").asInstanceOf[scala.Option[String]]
    def char(value: String): Tag[pine.tag.Tbody] = tag.setAttr("char", value)
    def charoff: scala.Option[String] = tag.attr("charoff").asInstanceOf[scala.Option[String]]
    def charoff(value: String): Tag[pine.tag.Tbody] = tag.setAttr("charoff", value)
    def valign: scala.Option[String] = tag.attr("valign").asInstanceOf[scala.Option[String]]
    def valign(value: String): Tag[pine.tag.Tbody] = tag.setAttr("valign", value)
  }

  implicit class TagRefAttributesTbody(tagRef: TagRef[tag.Tbody]) {
    val align = new Attribute[tag.Tbody, scala.Option[String], String](tagRef, "align")
    val bgcolor = new Attribute[tag.Tbody, scala.Option[String], String](tagRef, "bgcolor")
    val char = new Attribute[tag.Tbody, scala.Option[String], String](tagRef, "char")
    val charoff = new Attribute[tag.Tbody, scala.Option[String], String](tagRef, "charoff")
    val valign = new Attribute[tag.Tbody, scala.Option[String], String](tagRef, "valign")
  }

  implicit class TagAttributesTd(tag: Tag[pine.tag.Td]) {
    def abbr: scala.Option[String] = tag.attr("abbr").asInstanceOf[scala.Option[String]]
    def abbr(value: String): Tag[pine.tag.Td] = tag.setAttr("abbr", value)
    def align: scala.Option[String] = tag.attr("align").asInstanceOf[scala.Option[String]]
    def align(value: String): Tag[pine.tag.Td] = tag.setAttr("align", value)
    def axis: scala.Option[String] = tag.attr("axis").asInstanceOf[scala.Option[String]]
    def axis(value: String): Tag[pine.tag.Td] = tag.setAttr("axis", value)
    def bgcolor: scala.Option[String] = tag.attr("bgcolor").asInstanceOf[scala.Option[String]]
    def bgcolor(value: String): Tag[pine.tag.Td] = tag.setAttr("bgcolor", value)
    def char: scala.Option[String] = tag.attr("char").asInstanceOf[scala.Option[String]]
    def char(value: String): Tag[pine.tag.Td] = tag.setAttr("char", value)
    def charoff: scala.Option[String] = tag.attr("charoff").asInstanceOf[scala.Option[String]]
    def charoff(value: String): Tag[pine.tag.Td] = tag.setAttr("charoff", value)
    def colspan: scala.Option[String] = tag.attr("colspan").asInstanceOf[scala.Option[String]]
    def colspan(value: String): Tag[pine.tag.Td] = tag.setAttr("colspan", value)
    def headers: scala.Option[String] = tag.attr("headers").asInstanceOf[scala.Option[String]]
    def headers(value: String): Tag[pine.tag.Td] = tag.setAttr("headers", value)
    def rowspan: scala.Option[String] = tag.attr("rowspan").asInstanceOf[scala.Option[String]]
    def rowspan(value: String): Tag[pine.tag.Td] = tag.setAttr("rowspan", value)
    def scope: scala.Option[String] = tag.attr("scope").asInstanceOf[scala.Option[String]]
    def scope(value: String): Tag[pine.tag.Td] = tag.setAttr("scope", value)
    def valign: scala.Option[String] = tag.attr("valign").asInstanceOf[scala.Option[String]]
    def valign(value: String): Tag[pine.tag.Td] = tag.setAttr("valign", value)
    def width: scala.Option[String] = tag.attr("width").asInstanceOf[scala.Option[String]]
    def width(value: String): Tag[pine.tag.Td] = tag.setAttr("width", value)
  }

  implicit class TagRefAttributesTd(tagRef: TagRef[tag.Td]) {
    val abbr = new Attribute[tag.Td, scala.Option[String], String](tagRef, "abbr")
    val align = new Attribute[tag.Td, scala.Option[String], String](tagRef, "align")
    val axis = new Attribute[tag.Td, scala.Option[String], String](tagRef, "axis")
    val bgcolor = new Attribute[tag.Td, scala.Option[String], String](tagRef, "bgcolor")
    val char = new Attribute[tag.Td, scala.Option[String], String](tagRef, "char")
    val charoff = new Attribute[tag.Td, scala.Option[String], String](tagRef, "charoff")
    val colspan = new Attribute[tag.Td, scala.Option[String], String](tagRef, "colspan")
    val headers = new Attribute[tag.Td, scala.Option[String], String](tagRef, "headers")
    val rowspan = new Attribute[tag.Td, scala.Option[String], String](tagRef, "rowspan")
    val scope = new Attribute[tag.Td, scala.Option[String], String](tagRef, "scope")
    val valign = new Attribute[tag.Td, scala.Option[String], String](tagRef, "valign")
    val width = new Attribute[tag.Td, scala.Option[String], String](tagRef, "width")
  }

  implicit class TagAttributesTextarea(tag: Tag[pine.tag.Textarea]) {
    def autocapitalize: scala.Option[String] = tag.attr("autocapitalize").asInstanceOf[scala.Option[String]]
    def autocapitalize(value: String): Tag[pine.tag.Textarea] = tag.setAttr("autocapitalize", value)
    def autocomplete: scala.Option[String] = tag.attr("autocomplete").asInstanceOf[scala.Option[String]]
    def autocomplete(value: String): Tag[pine.tag.Textarea] = tag.setAttr("autocomplete", value)
    def autofocus: scala.Option[String] = tag.attr("autofocus").asInstanceOf[scala.Option[String]]
    def autofocus(value: String): Tag[pine.tag.Textarea] = tag.setAttr("autofocus", value)
    def cols: scala.Option[String] = tag.attr("cols").asInstanceOf[scala.Option[String]]
    def cols(value: String): Tag[pine.tag.Textarea] = tag.setAttr("cols", value)
    def disabled: scala.Option[String] = tag.attr("disabled").asInstanceOf[scala.Option[String]]
    def disabled(value: String): Tag[pine.tag.Textarea] = tag.setAttr("disabled", value)
    def form: scala.Option[String] = tag.attr("form").asInstanceOf[scala.Option[String]]
    def form(value: String): Tag[pine.tag.Textarea] = tag.setAttr("form", value)
    def maxlength: scala.Option[String] = tag.attr("maxlength").asInstanceOf[scala.Option[String]]
    def maxlength(value: String): Tag[pine.tag.Textarea] = tag.setAttr("maxlength", value)
    def minlength: scala.Option[String] = tag.attr("minlength").asInstanceOf[scala.Option[String]]
    def minlength(value: String): Tag[pine.tag.Textarea] = tag.setAttr("minlength", value)
    def name: scala.Option[String] = tag.attr("name").asInstanceOf[scala.Option[String]]
    def name(value: String): Tag[pine.tag.Textarea] = tag.setAttr("name", value)
    def placeholder: scala.Option[String] = tag.attr("placeholder").asInstanceOf[scala.Option[String]]
    def placeholder(value: String): Tag[pine.tag.Textarea] = tag.setAttr("placeholder", value)
    def readonly: scala.Option[String] = tag.attr("readonly").asInstanceOf[scala.Option[String]]
    def readonly(value: String): Tag[pine.tag.Textarea] = tag.setAttr("readonly", value)
    def required: scala.Option[String] = tag.attr("required").asInstanceOf[scala.Option[String]]
    def required(value: String): Tag[pine.tag.Textarea] = tag.setAttr("required", value)
    def rows: scala.Option[String] = tag.attr("rows").asInstanceOf[scala.Option[String]]
    def rows(value: String): Tag[pine.tag.Textarea] = tag.setAttr("rows", value)
    def selectionDirection: scala.Option[String] = tag.attr("selectionDirection").asInstanceOf[scala.Option[String]]
    def selectionDirection(value: String): Tag[pine.tag.Textarea] = tag.setAttr("selectionDirection", value)
    def selectionEnd: scala.Option[String] = tag.attr("selectionEnd").asInstanceOf[scala.Option[String]]
    def selectionEnd(value: String): Tag[pine.tag.Textarea] = tag.setAttr("selectionEnd", value)
    def selectionStart: scala.Option[String] = tag.attr("selectionStart").asInstanceOf[scala.Option[String]]
    def selectionStart(value: String): Tag[pine.tag.Textarea] = tag.setAttr("selectionStart", value)
    def wrap: scala.Option[String] = tag.attr("wrap").asInstanceOf[scala.Option[String]]
    def wrap(value: String): Tag[pine.tag.Textarea] = tag.setAttr("wrap", value)
  }

  implicit class TagRefAttributesTextarea(tagRef: TagRef[tag.Textarea]) {
    val autocapitalize = new Attribute[tag.Textarea, scala.Option[String], String](tagRef, "autocapitalize")
    val autocomplete = new Attribute[tag.Textarea, scala.Option[String], String](tagRef, "autocomplete")
    val autofocus = new Attribute[tag.Textarea, scala.Option[String], String](tagRef, "autofocus")
    val cols = new Attribute[tag.Textarea, scala.Option[String], String](tagRef, "cols")
    val disabled = new Attribute[tag.Textarea, scala.Option[String], String](tagRef, "disabled")
    val form = new Attribute[tag.Textarea, scala.Option[String], String](tagRef, "form")
    val maxlength = new Attribute[tag.Textarea, scala.Option[String], String](tagRef, "maxlength")
    val minlength = new Attribute[tag.Textarea, scala.Option[String], String](tagRef, "minlength")
    val name = new Attribute[tag.Textarea, scala.Option[String], String](tagRef, "name")
    val placeholder = new Attribute[tag.Textarea, scala.Option[String], String](tagRef, "placeholder")
    val readonly = new Attribute[tag.Textarea, scala.Option[String], String](tagRef, "readonly")
    val required = new Attribute[tag.Textarea, scala.Option[String], String](tagRef, "required")
    val rows = new Attribute[tag.Textarea, scala.Option[String], String](tagRef, "rows")
    val selectionDirection = new Attribute[tag.Textarea, scala.Option[String], String](tagRef, "selectionDirection")
    val selectionEnd = new Attribute[tag.Textarea, scala.Option[String], String](tagRef, "selectionEnd")
    val selectionStart = new Attribute[tag.Textarea, scala.Option[String], String](tagRef, "selectionStart")
    val spellcheck = new Attribute[tag.Textarea, scala.Option[String], String](tagRef, "spellcheck")
    val wrap = new Attribute[tag.Textarea, scala.Option[String], String](tagRef, "wrap")
  }

  implicit class TagAttributesTfoot(tag: Tag[pine.tag.Tfoot]) {
    def align: scala.Option[String] = tag.attr("align").asInstanceOf[scala.Option[String]]
    def align(value: String): Tag[pine.tag.Tfoot] = tag.setAttr("align", value)
    def bgcolor: scala.Option[String] = tag.attr("bgcolor").asInstanceOf[scala.Option[String]]
    def bgcolor(value: String): Tag[pine.tag.Tfoot] = tag.setAttr("bgcolor", value)
    def char: scala.Option[String] = tag.attr("char").asInstanceOf[scala.Option[String]]
    def char(value: String): Tag[pine.tag.Tfoot] = tag.setAttr("char", value)
    def charoff: scala.Option[String] = tag.attr("charoff").asInstanceOf[scala.Option[String]]
    def charoff(value: String): Tag[pine.tag.Tfoot] = tag.setAttr("charoff", value)
    def valign: scala.Option[String] = tag.attr("valign").asInstanceOf[scala.Option[String]]
    def valign(value: String): Tag[pine.tag.Tfoot] = tag.setAttr("valign", value)
  }

  implicit class TagRefAttributesTfoot(tagRef: TagRef[tag.Tfoot]) {
    val align = new Attribute[tag.Tfoot, scala.Option[String], String](tagRef, "align")
    val bgcolor = new Attribute[tag.Tfoot, scala.Option[String], String](tagRef, "bgcolor")
    val char = new Attribute[tag.Tfoot, scala.Option[String], String](tagRef, "char")
    val charoff = new Attribute[tag.Tfoot, scala.Option[String], String](tagRef, "charoff")
    val valign = new Attribute[tag.Tfoot, scala.Option[String], String](tagRef, "valign")
  }

  implicit class TagAttributesTh(tag: Tag[pine.tag.Th]) {
    def abbr: scala.Option[String] = tag.attr("abbr").asInstanceOf[scala.Option[String]]
    def abbr(value: String): Tag[pine.tag.Th] = tag.setAttr("abbr", value)
    def align: scala.Option[String] = tag.attr("align").asInstanceOf[scala.Option[String]]
    def align(value: String): Tag[pine.tag.Th] = tag.setAttr("align", value)
    def axis: scala.Option[String] = tag.attr("axis").asInstanceOf[scala.Option[String]]
    def axis(value: String): Tag[pine.tag.Th] = tag.setAttr("axis", value)
    def bgcolor: scala.Option[String] = tag.attr("bgcolor").asInstanceOf[scala.Option[String]]
    def bgcolor(value: String): Tag[pine.tag.Th] = tag.setAttr("bgcolor", value)
    def char: scala.Option[String] = tag.attr("char").asInstanceOf[scala.Option[String]]
    def char(value: String): Tag[pine.tag.Th] = tag.setAttr("char", value)
    def charoff: scala.Option[String] = tag.attr("charoff").asInstanceOf[scala.Option[String]]
    def charoff(value: String): Tag[pine.tag.Th] = tag.setAttr("charoff", value)
    def colspan: scala.Option[String] = tag.attr("colspan").asInstanceOf[scala.Option[String]]
    def colspan(value: String): Tag[pine.tag.Th] = tag.setAttr("colspan", value)
    def headers: scala.Option[String] = tag.attr("headers").asInstanceOf[scala.Option[String]]
    def headers(value: String): Tag[pine.tag.Th] = tag.setAttr("headers", value)
    def rowspan: scala.Option[String] = tag.attr("rowspan").asInstanceOf[scala.Option[String]]
    def rowspan(value: String): Tag[pine.tag.Th] = tag.setAttr("rowspan", value)
    def scope: scala.Option[String] = tag.attr("scope").asInstanceOf[scala.Option[String]]
    def scope(value: String): Tag[pine.tag.Th] = tag.setAttr("scope", value)
    def valign: scala.Option[String] = tag.attr("valign").asInstanceOf[scala.Option[String]]
    def valign(value: String): Tag[pine.tag.Th] = tag.setAttr("valign", value)
    def width: scala.Option[String] = tag.attr("width").asInstanceOf[scala.Option[String]]
    def width(value: String): Tag[pine.tag.Th] = tag.setAttr("width", value)
  }

  implicit class TagRefAttributesTh(tagRef: TagRef[tag.Th]) {
    val abbr = new Attribute[tag.Th, scala.Option[String], String](tagRef, "abbr")
    val align = new Attribute[tag.Th, scala.Option[String], String](tagRef, "align")
    val axis = new Attribute[tag.Th, scala.Option[String], String](tagRef, "axis")
    val bgcolor = new Attribute[tag.Th, scala.Option[String], String](tagRef, "bgcolor")
    val char = new Attribute[tag.Th, scala.Option[String], String](tagRef, "char")
    val charoff = new Attribute[tag.Th, scala.Option[String], String](tagRef, "charoff")
    val colspan = new Attribute[tag.Th, scala.Option[String], String](tagRef, "colspan")
    val headers = new Attribute[tag.Th, scala.Option[String], String](tagRef, "headers")
    val rowspan = new Attribute[tag.Th, scala.Option[String], String](tagRef, "rowspan")
    val scope = new Attribute[tag.Th, scala.Option[String], String](tagRef, "scope")
    val valign = new Attribute[tag.Th, scala.Option[String], String](tagRef, "valign")
    val width = new Attribute[tag.Th, scala.Option[String], String](tagRef, "width")
  }

  implicit class TagAttributesThead(tag: Tag[pine.tag.Thead]) {
    def align: scala.Option[String] = tag.attr("align").asInstanceOf[scala.Option[String]]
    def align(value: String): Tag[pine.tag.Thead] = tag.setAttr("align", value)
    def bgcolor: scala.Option[String] = tag.attr("bgcolor").asInstanceOf[scala.Option[String]]
    def bgcolor(value: String): Tag[pine.tag.Thead] = tag.setAttr("bgcolor", value)
    def char: scala.Option[String] = tag.attr("char").asInstanceOf[scala.Option[String]]
    def char(value: String): Tag[pine.tag.Thead] = tag.setAttr("char", value)
    def charoff: scala.Option[String] = tag.attr("charoff").asInstanceOf[scala.Option[String]]
    def charoff(value: String): Tag[pine.tag.Thead] = tag.setAttr("charoff", value)
    def valign: scala.Option[String] = tag.attr("valign").asInstanceOf[scala.Option[String]]
    def valign(value: String): Tag[pine.tag.Thead] = tag.setAttr("valign", value)
  }

  implicit class TagRefAttributesThead(tagRef: TagRef[tag.Thead]) {
    val align = new Attribute[tag.Thead, scala.Option[String], String](tagRef, "align")
    val bgcolor = new Attribute[tag.Thead, scala.Option[String], String](tagRef, "bgcolor")
    val char = new Attribute[tag.Thead, scala.Option[String], String](tagRef, "char")
    val charoff = new Attribute[tag.Thead, scala.Option[String], String](tagRef, "charoff")
    val valign = new Attribute[tag.Thead, scala.Option[String], String](tagRef, "valign")
  }

  implicit class TagAttributesTr(tag: Tag[pine.tag.Tr]) {
    def align: scala.Option[String] = tag.attr("align").asInstanceOf[scala.Option[String]]
    def align(value: String): Tag[pine.tag.Tr] = tag.setAttr("align", value)
    def bgcolor: scala.Option[String] = tag.attr("bgcolor").asInstanceOf[scala.Option[String]]
    def bgcolor(value: String): Tag[pine.tag.Tr] = tag.setAttr("bgcolor", value)
    def char: scala.Option[String] = tag.attr("char").asInstanceOf[scala.Option[String]]
    def char(value: String): Tag[pine.tag.Tr] = tag.setAttr("char", value)
    def charoff: scala.Option[String] = tag.attr("charoff").asInstanceOf[scala.Option[String]]
    def charoff(value: String): Tag[pine.tag.Tr] = tag.setAttr("charoff", value)
    def valign: scala.Option[String] = tag.attr("valign").asInstanceOf[scala.Option[String]]
    def valign(value: String): Tag[pine.tag.Tr] = tag.setAttr("valign", value)
  }

  implicit class TagRefAttributesTr(tagRef: TagRef[tag.Tr]) {
    val align = new Attribute[tag.Tr, scala.Option[String], String](tagRef, "align")
    val bgcolor = new Attribute[tag.Tr, scala.Option[String], String](tagRef, "bgcolor")
    val char = new Attribute[tag.Tr, scala.Option[String], String](tagRef, "char")
    val charoff = new Attribute[tag.Tr, scala.Option[String], String](tagRef, "charoff")
    val valign = new Attribute[tag.Tr, scala.Option[String], String](tagRef, "valign")
  }

  implicit class TagAttributesTrack(tag: Tag[pine.tag.Track]) {
    def default: scala.Option[String] = tag.attr("default").asInstanceOf[scala.Option[String]]
    def default(value: String): Tag[pine.tag.Track] = tag.setAttr("default", value)
    def kind: scala.Option[String] = tag.attr("kind").asInstanceOf[scala.Option[String]]
    def kind(value: String): Tag[pine.tag.Track] = tag.setAttr("kind", value)
    def label: scala.Option[String] = tag.attr("label").asInstanceOf[scala.Option[String]]
    def label(value: String): Tag[pine.tag.Track] = tag.setAttr("label", value)
    def src: scala.Option[String] = tag.attr("src").asInstanceOf[scala.Option[String]]
    def src(value: String): Tag[pine.tag.Track] = tag.setAttr("src", value)
    def srclang: scala.Option[String] = tag.attr("srclang").asInstanceOf[scala.Option[String]]
    def srclang(value: String): Tag[pine.tag.Track] = tag.setAttr("srclang", value)
  }

  implicit class TagRefAttributesTrack(tagRef: TagRef[tag.Track]) {
    val default = new Attribute[tag.Track, scala.Option[String], String](tagRef, "default")
    val kind = new Attribute[tag.Track, scala.Option[String], String](tagRef, "kind")
    val label = new Attribute[tag.Track, scala.Option[String], String](tagRef, "label")
    val src = new Attribute[tag.Track, scala.Option[String], String](tagRef, "src")
    val srclang = new Attribute[tag.Track, scala.Option[String], String](tagRef, "srclang")
  }

  implicit class TagAttributesUl(tag: Tag[pine.tag.Ul]) {
    def compact: scala.Option[String] = tag.attr("compact").asInstanceOf[scala.Option[String]]
    def compact(value: String): Tag[pine.tag.Ul] = tag.setAttr("compact", value)
    def `type`: scala.Option[String] = tag.attr("type").asInstanceOf[scala.Option[String]]
    def `type`(value: String): Tag[pine.tag.Ul] = tag.setAttr("type", value)
  }

  implicit class TagRefAttributesUl(tagRef: TagRef[tag.Ul]) {
    val compact = new Attribute[tag.Ul, scala.Option[String], String](tagRef, "compact")
    val `type` = new Attribute[tag.Ul, scala.Option[String], String](tagRef, "type")
  }

  implicit class TagAttributesVideo(tag: Tag[pine.tag.Video]) {
    def autoplay: scala.Option[String] = tag.attr("autoplay").asInstanceOf[scala.Option[String]]
    def autoplay(value: String): Tag[pine.tag.Video] = tag.setAttr("autoplay", value)
    def autobuffer: scala.Option[String] = tag.attr("autobuffer").asInstanceOf[scala.Option[String]]
    def autobuffer(value: String): Tag[pine.tag.Video] = tag.setAttr("autobuffer", value)
    def buffered: scala.Option[String] = tag.attr("buffered").asInstanceOf[scala.Option[String]]
    def buffered(value: String): Tag[pine.tag.Video] = tag.setAttr("buffered", value)
    def controls: scala.Option[String] = tag.attr("controls").asInstanceOf[scala.Option[String]]
    def controls(value: String): Tag[pine.tag.Video] = tag.setAttr("controls", value)
    def crossorigin: scala.Option[String] = tag.attr("crossorigin").asInstanceOf[scala.Option[String]]
    def crossorigin(value: String): Tag[pine.tag.Video] = tag.setAttr("crossorigin", value)
    def height: scala.Option[String] = tag.attr("height").asInstanceOf[scala.Option[String]]
    def height(value: String): Tag[pine.tag.Video] = tag.setAttr("height", value)
    def loop: scala.Option[String] = tag.attr("loop").asInstanceOf[scala.Option[String]]
    def loop(value: String): Tag[pine.tag.Video] = tag.setAttr("loop", value)
    def muted: scala.Option[String] = tag.attr("muted").asInstanceOf[scala.Option[String]]
    def muted(value: String): Tag[pine.tag.Video] = tag.setAttr("muted", value)
    def played: scala.Option[String] = tag.attr("played").asInstanceOf[scala.Option[String]]
    def played(value: String): Tag[pine.tag.Video] = tag.setAttr("played", value)
    def preload: scala.Option[String] = tag.attr("preload").asInstanceOf[scala.Option[String]]
    def preload(value: String): Tag[pine.tag.Video] = tag.setAttr("preload", value)
    def poster: scala.Option[String] = tag.attr("poster").asInstanceOf[scala.Option[String]]
    def poster(value: String): Tag[pine.tag.Video] = tag.setAttr("poster", value)
    def src: scala.Option[String] = tag.attr("src").asInstanceOf[scala.Option[String]]
    def src(value: String): Tag[pine.tag.Video] = tag.setAttr("src", value)
    def width: scala.Option[String] = tag.attr("width").asInstanceOf[scala.Option[String]]
    def width(value: String): Tag[pine.tag.Video] = tag.setAttr("width", value)
  }

  implicit class TagRefAttributesVideo(tagRef: TagRef[tag.Video]) {
    val autoplay = new Attribute[tag.Video, scala.Option[String], String](tagRef, "autoplay")
    val autobuffer = new Attribute[tag.Video, scala.Option[String], String](tagRef, "autobuffer")
    val buffered = new Attribute[tag.Video, scala.Option[String], String](tagRef, "buffered")
    val controls = new Attribute[tag.Video, scala.Option[String], String](tagRef, "controls")
    val crossorigin = new Attribute[tag.Video, scala.Option[String], String](tagRef, "crossorigin")
    val height = new Attribute[tag.Video, scala.Option[String], String](tagRef, "height")
    val loop = new Attribute[tag.Video, scala.Option[String], String](tagRef, "loop")
    val muted = new Attribute[tag.Video, scala.Option[String], String](tagRef, "muted")
    val played = new Attribute[tag.Video, scala.Option[String], String](tagRef, "played")
    val preload = new Attribute[tag.Video, scala.Option[String], String](tagRef, "preload")
    val poster = new Attribute[tag.Video, scala.Option[String], String](tagRef, "poster")
    val src = new Attribute[tag.Video, scala.Option[String], String](tagRef, "src")
    val width = new Attribute[tag.Video, scala.Option[String], String](tagRef, "width")
  }

}
