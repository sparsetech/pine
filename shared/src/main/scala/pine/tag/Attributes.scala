package pine.tag

import pine._

trait Attributes {
  implicit class TagRefAttributes[T <: SString](tagRef: TagRef[T]) {
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

  implicit class TagExtensions[T <: SString](tag: Tag[T]) {
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
  implicit class AExtensions(tag: Tag["a"]) {
    def download: scala.Option[String] = tag.attr("download").asInstanceOf[scala.Option[String]]
    def download(value: String): Tag["a"] = tag.setAttr("download", value)
    def href: scala.Option[String] = tag.attr("href").asInstanceOf[scala.Option[String]]
    def href(value: String): Tag["a"] = tag.setAttr("href", value)
    def hreflang: scala.Option[String] = tag.attr("hreflang").asInstanceOf[scala.Option[String]]
    def hreflang(value: String): Tag["a"] = tag.setAttr("hreflang", value)
    def media: scala.Option[String] = tag.attr("media").asInstanceOf[scala.Option[String]]
    def media(value: String): Tag["a"] = tag.setAttr("media", value)
    def ping: scala.Option[String] = tag.attr("ping").asInstanceOf[scala.Option[String]]
    def ping(value: String): Tag["a"] = tag.setAttr("ping", value)
    def rel: scala.Option[String] = tag.attr("rel").asInstanceOf[scala.Option[String]]
    def rel(value: String): Tag["a"] = tag.setAttr("rel", value)
    def target: scala.Option[String] = tag.attr("target").asInstanceOf[scala.Option[String]]
    def target(value: String): Tag["a"] = tag.setAttr("target", value)
    def `type`: scala.Option[String] = tag.attr("type").asInstanceOf[scala.Option[String]]
    def `type`(value: String): Tag["a"] = tag.setAttr("type", value)
    def charset: scala.Option[String] = tag.attr("charset").asInstanceOf[scala.Option[String]]
    def charset(value: String): Tag["a"] = tag.setAttr("charset", value)
    def coords: scala.Option[String] = tag.attr("coords").asInstanceOf[scala.Option[String]]
    def coords(value: String): Tag["a"] = tag.setAttr("coords", value)
    def name: scala.Option[String] = tag.attr("name").asInstanceOf[scala.Option[String]]
    def name(value: String): Tag["a"] = tag.setAttr("name", value)
    def rev: scala.Option[String] = tag.attr("rev").asInstanceOf[scala.Option[String]]
    def rev(value: String): Tag["a"] = tag.setAttr("rev", value)
    def shape: scala.Option[String] = tag.attr("shape").asInstanceOf[scala.Option[String]]
    def shape(value: String): Tag["a"] = tag.setAttr("shape", value)
    def datafld: scala.Option[String] = tag.attr("datafld").asInstanceOf[scala.Option[String]]
    def datafld(value: String): Tag["a"] = tag.setAttr("datafld", value)
    def datasrc: scala.Option[String] = tag.attr("datasrc").asInstanceOf[scala.Option[String]]
    def datasrc(value: String): Tag["a"] = tag.setAttr("datasrc", value)
    def methods: scala.Option[String] = tag.attr("methods").asInstanceOf[scala.Option[String]]
    def methods(value: String): Tag["a"] = tag.setAttr("methods", value)
    def urn: scala.Option[String] = tag.attr("urn").asInstanceOf[scala.Option[String]]
    def urn(value: String): Tag["a"] = tag.setAttr("urn", value)
  }

  implicit class TagRefAttributesA(tagRef: TagRef["a"]) {
    val download = new Attribute["a", scala.Option[String], String](tagRef, "download")
    val href = new Attribute["a", scala.Option[String], String](tagRef, "href")
    val hreflang = new Attribute["a", scala.Option[String], String](tagRef, "hreflang")
    val media = new Attribute["a", scala.Option[String], String](tagRef, "media")
    val ping = new Attribute["a", scala.Option[String], String](tagRef, "ping")
    val rel = new Attribute["a", scala.Option[String], String](tagRef, "rel")
    val target = new Attribute["a", scala.Option[String], String](tagRef, "target")
    val `type` = new Attribute["a", scala.Option[String], String](tagRef, "type")
    val charset = new Attribute["a", scala.Option[String], String](tagRef, "charset")
    val coords = new Attribute["a", scala.Option[String], String](tagRef, "coords")
    val name = new Attribute["a", scala.Option[String], String](tagRef, "name")
    val rev = new Attribute["a", scala.Option[String], String](tagRef, "rev")
    val shape = new Attribute["a", scala.Option[String], String](tagRef, "shape")
    val datafld = new Attribute["a", scala.Option[String], String](tagRef, "datafld")
    val datasrc = new Attribute["a", scala.Option[String], String](tagRef, "datasrc")
    val methods = new Attribute["a", scala.Option[String], String](tagRef, "methods")
    val urn = new Attribute["a", scala.Option[String], String](tagRef, "urn")
  }

  implicit class AppletExtensions(tag: Tag["applet"]) {
    def align: scala.Option[String] = tag.attr("align").asInstanceOf[scala.Option[String]]
    def align(value: String): Tag["applet"] = tag.setAttr("align", value)
    def alt: scala.Option[String] = tag.attr("alt").asInstanceOf[scala.Option[String]]
    def alt(value: String): Tag["applet"] = tag.setAttr("alt", value)
    def archive: scala.Option[String] = tag.attr("archive").asInstanceOf[scala.Option[String]]
    def archive(value: String): Tag["applet"] = tag.setAttr("archive", value)
    def code: scala.Option[String] = tag.attr("code").asInstanceOf[scala.Option[String]]
    def code(value: String): Tag["applet"] = tag.setAttr("code", value)
    def codebase: scala.Option[String] = tag.attr("codebase").asInstanceOf[scala.Option[String]]
    def codebase(value: String): Tag["applet"] = tag.setAttr("codebase", value)
    def datafld: scala.Option[String] = tag.attr("datafld").asInstanceOf[scala.Option[String]]
    def datafld(value: String): Tag["applet"] = tag.setAttr("datafld", value)
    def datasrc: scala.Option[String] = tag.attr("datasrc").asInstanceOf[scala.Option[String]]
    def datasrc(value: String): Tag["applet"] = tag.setAttr("datasrc", value)
    def height: scala.Option[String] = tag.attr("height").asInstanceOf[scala.Option[String]]
    def height(value: String): Tag["applet"] = tag.setAttr("height", value)
    def hspace: scala.Option[String] = tag.attr("hspace").asInstanceOf[scala.Option[String]]
    def hspace(value: String): Tag["applet"] = tag.setAttr("hspace", value)
    def mayscript: scala.Option[String] = tag.attr("mayscript").asInstanceOf[scala.Option[String]]
    def mayscript(value: String): Tag["applet"] = tag.setAttr("mayscript", value)
    def name: scala.Option[String] = tag.attr("name").asInstanceOf[scala.Option[String]]
    def name(value: String): Tag["applet"] = tag.setAttr("name", value)
    def `object`: scala.Option[String] = tag.attr("object").asInstanceOf[scala.Option[String]]
    def `object`(value: String): Tag["applet"] = tag.setAttr("object", value)
    def src: scala.Option[String] = tag.attr("src").asInstanceOf[scala.Option[String]]
    def src(value: String): Tag["applet"] = tag.setAttr("src", value)
    def vspace: scala.Option[String] = tag.attr("vspace").asInstanceOf[scala.Option[String]]
    def vspace(value: String): Tag["applet"] = tag.setAttr("vspace", value)
    def width: scala.Option[String] = tag.attr("width").asInstanceOf[scala.Option[String]]
    def width(value: String): Tag["applet"] = tag.setAttr("width", value)
  }

  implicit class TagRefAttributesApplet(tagRef: TagRef["applet"]) {
    val align = new Attribute["applet", scala.Option[String], String](tagRef, "align")
    val alt = new Attribute["applet", scala.Option[String], String](tagRef, "alt")
    val archive = new Attribute["applet", scala.Option[String], String](tagRef, "archive")
    val code = new Attribute["applet", scala.Option[String], String](tagRef, "code")
    val codebase = new Attribute["applet", scala.Option[String], String](tagRef, "codebase")
    val datafld = new Attribute["applet", scala.Option[String], String](tagRef, "datafld")
    val datasrc = new Attribute["applet", scala.Option[String], String](tagRef, "datasrc")
    val height = new Attribute["applet", scala.Option[String], String](tagRef, "height")
    val hspace = new Attribute["applet", scala.Option[String], String](tagRef, "hspace")
    val mayscript = new Attribute["applet", scala.Option[String], String](tagRef, "mayscript")
    val name = new Attribute["applet", scala.Option[String], String](tagRef, "name")
    val `object` = new Attribute["applet", scala.Option[String], String](tagRef, "object")
    val src = new Attribute["applet", scala.Option[String], String](tagRef, "src")
    val vspace = new Attribute["applet", scala.Option[String], String](tagRef, "vspace")
    val width = new Attribute["applet", scala.Option[String], String](tagRef, "width")
  }

  implicit class AreaExtensions(tag: Tag["area"]) {
    def alt: scala.Option[String] = tag.attr("alt").asInstanceOf[scala.Option[String]]
    def alt(value: String): Tag["area"] = tag.setAttr("alt", value)
    def coords: scala.Option[String] = tag.attr("coords").asInstanceOf[scala.Option[String]]
    def coords(value: String): Tag["area"] = tag.setAttr("coords", value)
    def download: scala.Option[String] = tag.attr("download").asInstanceOf[scala.Option[String]]
    def download(value: String): Tag["area"] = tag.setAttr("download", value)
    def href: scala.Option[String] = tag.attr("href").asInstanceOf[scala.Option[String]]
    def href(value: String): Tag["area"] = tag.setAttr("href", value)
    def hreflang: scala.Option[String] = tag.attr("hreflang").asInstanceOf[scala.Option[String]]
    def hreflang(value: String): Tag["area"] = tag.setAttr("hreflang", value)
    def name: scala.Option[String] = tag.attr("name").asInstanceOf[scala.Option[String]]
    def name(value: String): Tag["area"] = tag.setAttr("name", value)
    def media: scala.Option[String] = tag.attr("media").asInstanceOf[scala.Option[String]]
    def media(value: String): Tag["area"] = tag.setAttr("media", value)
    def nohref: scala.Option[String] = tag.attr("nohref").asInstanceOf[scala.Option[String]]
    def nohref(value: String): Tag["area"] = tag.setAttr("nohref", value)
    def rel: scala.Option[String] = tag.attr("rel").asInstanceOf[scala.Option[String]]
    def rel(value: String): Tag["area"] = tag.setAttr("rel", value)
    def shape: scala.Option[String] = tag.attr("shape").asInstanceOf[scala.Option[String]]
    def shape(value: String): Tag["area"] = tag.setAttr("shape", value)
    def target: scala.Option[String] = tag.attr("target").asInstanceOf[scala.Option[String]]
    def target(value: String): Tag["area"] = tag.setAttr("target", value)
    def `type`: scala.Option[String] = tag.attr("type").asInstanceOf[scala.Option[String]]
    def `type`(value: String): Tag["area"] = tag.setAttr("type", value)
  }

  implicit class TagRefAttributesArea(tagRef: TagRef["area"]) {
    val accesskey = new Attribute["area", scala.Option[String], String](tagRef, "accesskey")
    val alt = new Attribute["area", scala.Option[String], String](tagRef, "alt")
    val coords = new Attribute["area", scala.Option[String], String](tagRef, "coords")
    val download = new Attribute["area", scala.Option[String], String](tagRef, "download")
    val href = new Attribute["area", scala.Option[String], String](tagRef, "href")
    val hreflang = new Attribute["area", scala.Option[String], String](tagRef, "hreflang")
    val name = new Attribute["area", scala.Option[String], String](tagRef, "name")
    val media = new Attribute["area", scala.Option[String], String](tagRef, "media")
    val nohref = new Attribute["area", scala.Option[String], String](tagRef, "nohref")
    val rel = new Attribute["area", scala.Option[String], String](tagRef, "rel")
    val shape = new Attribute["area", scala.Option[String], String](tagRef, "shape")
    val tabindex = new Attribute["area", scala.Option[String], String](tagRef, "tabindex")
    val target = new Attribute["area", scala.Option[String], String](tagRef, "target")
    val `type` = new Attribute["area", scala.Option[String], String](tagRef, "type")
  }

  implicit class AudioExtensions(tag: Tag["audio"]) {
    def autoplay: scala.Option[String] = tag.attr("autoplay").asInstanceOf[scala.Option[String]]
    def autoplay(value: String): Tag["audio"] = tag.setAttr("autoplay", value)
    def autobuffer: scala.Option[String] = tag.attr("autobuffer").asInstanceOf[scala.Option[String]]
    def autobuffer(value: String): Tag["audio"] = tag.setAttr("autobuffer", value)
    def buffered: scala.Option[String] = tag.attr("buffered").asInstanceOf[scala.Option[String]]
    def buffered(value: String): Tag["audio"] = tag.setAttr("buffered", value)
    def controls: scala.Option[String] = tag.attr("controls").asInstanceOf[scala.Option[String]]
    def controls(value: String): Tag["audio"] = tag.setAttr("controls", value)
    def loop: scala.Option[String] = tag.attr("loop").asInstanceOf[scala.Option[String]]
    def loop(value: String): Tag["audio"] = tag.setAttr("loop", value)
    def mozCurrentSampleOffset: scala.Option[String] = tag.attr("mozCurrentSampleOffset").asInstanceOf[scala.Option[String]]
    def mozCurrentSampleOffset(value: String): Tag["audio"] = tag.setAttr("mozCurrentSampleOffset", value)
    def muted: scala.Option[String] = tag.attr("muted").asInstanceOf[scala.Option[String]]
    def muted(value: String): Tag["audio"] = tag.setAttr("muted", value)
    def played: scala.Option[String] = tag.attr("played").asInstanceOf[scala.Option[String]]
    def played(value: String): Tag["audio"] = tag.setAttr("played", value)
    def preload: scala.Option[String] = tag.attr("preload").asInstanceOf[scala.Option[String]]
    def preload(value: String): Tag["audio"] = tag.setAttr("preload", value)
    def src: scala.Option[String] = tag.attr("src").asInstanceOf[scala.Option[String]]
    def src(value: String): Tag["audio"] = tag.setAttr("src", value)
    def volume: scala.Option[String] = tag.attr("volume").asInstanceOf[scala.Option[String]]
    def volume(value: String): Tag["audio"] = tag.setAttr("volume", value)
  }

  implicit class TagRefAttributesAudio(tagRef: TagRef["audio"]) {
    val autoplay = new Attribute["audio", scala.Option[String], String](tagRef, "autoplay")
    val autobuffer = new Attribute["audio", scala.Option[String], String](tagRef, "autobuffer")
    val buffered = new Attribute["audio", scala.Option[String], String](tagRef, "buffered")
    val controls = new Attribute["audio", scala.Option[String], String](tagRef, "controls")
    val loop = new Attribute["audio", scala.Option[String], String](tagRef, "loop")
    val mozCurrentSampleOffset = new Attribute["audio", scala.Option[String], String](tagRef, "mozCurrentSampleOffset")
    val muted = new Attribute["audio", scala.Option[String], String](tagRef, "muted")
    val played = new Attribute["audio", scala.Option[String], String](tagRef, "played")
    val preload = new Attribute["audio", scala.Option[String], String](tagRef, "preload")
    val src = new Attribute["audio", scala.Option[String], String](tagRef, "src")
    val volume = new Attribute["audio", scala.Option[String], String](tagRef, "volume")
  }

  implicit class BaseExtensions(tag: Tag["base"]) {
    def href: scala.Option[String] = tag.attr("href").asInstanceOf[scala.Option[String]]
    def href(value: String): Tag["base"] = tag.setAttr("href", value)
    def target: scala.Option[String] = tag.attr("target").asInstanceOf[scala.Option[String]]
    def target(value: String): Tag["base"] = tag.setAttr("target", value)
  }

  implicit class TagRefAttributesBase(tagRef: TagRef["base"]) {
    val href = new Attribute["base", scala.Option[String], String](tagRef, "href")
    val target = new Attribute["base", scala.Option[String], String](tagRef, "target")
  }

  implicit class BasefontExtensions(tag: Tag["basefont"]) {
    def color: scala.Option[String] = tag.attr("color").asInstanceOf[scala.Option[String]]
    def color(value: String): Tag["basefont"] = tag.setAttr("color", value)
    def face: scala.Option[String] = tag.attr("face").asInstanceOf[scala.Option[String]]
    def face(value: String): Tag["basefont"] = tag.setAttr("face", value)
    def size: scala.Option[String] = tag.attr("size").asInstanceOf[scala.Option[String]]
    def size(value: String): Tag["basefont"] = tag.setAttr("size", value)
  }

  implicit class TagRefAttributesBasefont(tagRef: TagRef["basefont"]) {
    val color = new Attribute["basefont", scala.Option[String], String](tagRef, "color")
    val face = new Attribute["basefont", scala.Option[String], String](tagRef, "face")
    val size = new Attribute["basefont", scala.Option[String], String](tagRef, "size")
  }

  implicit class BodyExtensions(tag: Tag["body"]) {
    def alink: scala.Option[String] = tag.attr("alink").asInstanceOf[scala.Option[String]]
    def alink(value: String): Tag["body"] = tag.setAttr("alink", value)
    def background: scala.Option[String] = tag.attr("background").asInstanceOf[scala.Option[String]]
    def background(value: String): Tag["body"] = tag.setAttr("background", value)
    def bgcolor: scala.Option[String] = tag.attr("bgcolor").asInstanceOf[scala.Option[String]]
    def bgcolor(value: String): Tag["body"] = tag.setAttr("bgcolor", value)
    def bottommargin: scala.Option[String] = tag.attr("bottommargin").asInstanceOf[scala.Option[String]]
    def bottommargin(value: String): Tag["body"] = tag.setAttr("bottommargin", value)
    def leftmargin: scala.Option[String] = tag.attr("leftmargin").asInstanceOf[scala.Option[String]]
    def leftmargin(value: String): Tag["body"] = tag.setAttr("leftmargin", value)
    def link: scala.Option[String] = tag.attr("link").asInstanceOf[scala.Option[String]]
    def link(value: String): Tag["body"] = tag.setAttr("link", value)
    def rightmargin: scala.Option[String] = tag.attr("rightmargin").asInstanceOf[scala.Option[String]]
    def rightmargin(value: String): Tag["body"] = tag.setAttr("rightmargin", value)
    def text: scala.Option[String] = tag.attr("text").asInstanceOf[scala.Option[String]]
    def text(value: String): Tag["body"] = tag.setAttr("text", value)
    def topmargin: scala.Option[String] = tag.attr("topmargin").asInstanceOf[scala.Option[String]]
    def topmargin(value: String): Tag["body"] = tag.setAttr("topmargin", value)
    def vlink: scala.Option[String] = tag.attr("vlink").asInstanceOf[scala.Option[String]]
    def vlink(value: String): Tag["body"] = tag.setAttr("vlink", value)
  }

  implicit class TagRefAttributesBody(tagRef: TagRef["body"]) {
    val alink = new Attribute["body", scala.Option[String], String](tagRef, "alink")
    val background = new Attribute["body", scala.Option[String], String](tagRef, "background")
    val bgcolor = new Attribute["body", scala.Option[String], String](tagRef, "bgcolor")
    val bottommargin = new Attribute["body", scala.Option[String], String](tagRef, "bottommargin")
    val leftmargin = new Attribute["body", scala.Option[String], String](tagRef, "leftmargin")
    val link = new Attribute["body", scala.Option[String], String](tagRef, "link")
    val onafterprint = new Attribute["body", scala.Option[String], String](tagRef, "onafterprint")
    val onbeforeprint = new Attribute["body", scala.Option[String], String](tagRef, "onbeforeprint")
    val onbeforeunload = new Attribute["body", scala.Option[String], String](tagRef, "onbeforeunload")
    val onblur = new Attribute["body", scala.Option[String], String](tagRef, "onblur")
    val onerror = new Attribute["body", scala.Option[String], String](tagRef, "onerror")
    val onfocus = new Attribute["body", scala.Option[String], String](tagRef, "onfocus")
    val onhashchange = new Attribute["body", scala.Option[String], String](tagRef, "onhashchange")
    val onlanguagechange = new Attribute["body", scala.Option[String], String](tagRef, "onlanguagechange")
    val onload = new Attribute["body", scala.Option[String], String](tagRef, "onload")
    val onmessage = new Attribute["body", scala.Option[String], String](tagRef, "onmessage")
    val onoffline = new Attribute["body", scala.Option[String], String](tagRef, "onoffline")
    val ononline = new Attribute["body", scala.Option[String], String](tagRef, "ononline")
    val onpopstate = new Attribute["body", scala.Option[String], String](tagRef, "onpopstate")
    val onredo = new Attribute["body", scala.Option[String], String](tagRef, "onredo")
    val onresize = new Attribute["body", scala.Option[String], String](tagRef, "onresize")
    val onstorage = new Attribute["body", scala.Option[String], String](tagRef, "onstorage")
    val onundo = new Attribute["body", scala.Option[String], String](tagRef, "onundo")
    val onunload = new Attribute["body", scala.Option[String], String](tagRef, "onunload")
    val rightmargin = new Attribute["body", scala.Option[String], String](tagRef, "rightmargin")
    val text = new Attribute["body", scala.Option[String], String](tagRef, "text")
    val topmargin = new Attribute["body", scala.Option[String], String](tagRef, "topmargin")
    val vlink = new Attribute["body", scala.Option[String], String](tagRef, "vlink")
  }

  implicit class BrExtensions(tag: Tag["br"]) {
    def clear: scala.Option[String] = tag.attr("clear").asInstanceOf[scala.Option[String]]
    def clear(value: String): Tag["br"] = tag.setAttr("clear", value)
  }

  implicit class TagRefAttributesBr(tagRef: TagRef["br"]) {
    val clear = new Attribute["br", scala.Option[String], String](tagRef, "clear")
  }

  implicit class ButtonExtensions(tag: Tag["button"]) {
    def autofocus: Boolean = tag.attributes.contains("autofocus")
    def autofocus(value: Boolean): Tag["button"] = (if (value) tag.setAttr("autofocus", "") else tag.remAttr("autofocus"))
    def autocomplete: scala.Option[String] = tag.attr("autocomplete").asInstanceOf[scala.Option[String]]
    def autocomplete(value: String): Tag["button"] = tag.setAttr("autocomplete", value)
    def disabled: Boolean = tag.attributes.contains("disabled")
    def disabled(value: Boolean): Tag["button"] = (if (value) tag.setAttr("disabled", "") else tag.remAttr("disabled"))
    def form: scala.Option[String] = tag.attr("form").asInstanceOf[scala.Option[String]]
    def form(value: String): Tag["button"] = tag.setAttr("form", value)
    def formaction: scala.Option[String] = tag.attr("formaction").asInstanceOf[scala.Option[String]]
    def formaction(value: String): Tag["button"] = tag.setAttr("formaction", value)
    def formenctype: scala.Option[String] = tag.attr("formenctype").asInstanceOf[scala.Option[String]]
    def formenctype(value: String): Tag["button"] = tag.setAttr("formenctype", value)
    def formmethod: scala.Option[String] = tag.attr("formmethod").asInstanceOf[scala.Option[String]]
    def formmethod(value: String): Tag["button"] = tag.setAttr("formmethod", value)
    def formnovalidate: scala.Option[String] = tag.attr("formnovalidate").asInstanceOf[scala.Option[String]]
    def formnovalidate(value: String): Tag["button"] = tag.setAttr("formnovalidate", value)
    def formtarget: scala.Option[String] = tag.attr("formtarget").asInstanceOf[scala.Option[String]]
    def formtarget(value: String): Tag["button"] = tag.setAttr("formtarget", value)
    def name: scala.Option[String] = tag.attr("name").asInstanceOf[scala.Option[String]]
    def name(value: String): Tag["button"] = tag.setAttr("name", value)
    def `type`: scala.Option[String] = tag.attr("type").asInstanceOf[scala.Option[String]]
    def `type`(value: String): Tag["button"] = tag.setAttr("type", value)
    def value: scala.Option[String] = tag.attr("value").asInstanceOf[scala.Option[String]]
    def value(value: String): Tag["button"] = tag.setAttr("value", value)
  }

  implicit class TagRefAttributesButton(tagRef: TagRef["button"]) {
    val autofocus = new Attribute["button", Boolean, Boolean](tagRef, "autofocus")
    val autocomplete = new Attribute["button", scala.Option[String], String](tagRef, "autocomplete")
    val disabled = new Attribute["button", Boolean, Boolean](tagRef, "disabled")
    val form = new Attribute["button", scala.Option[String], String](tagRef, "form")
    val formaction = new Attribute["button", scala.Option[String], String](tagRef, "formaction")
    val formenctype = new Attribute["button", scala.Option[String], String](tagRef, "formenctype")
    val formmethod = new Attribute["button", scala.Option[String], String](tagRef, "formmethod")
    val formnovalidate = new Attribute["button", scala.Option[String], String](tagRef, "formnovalidate")
    val formtarget = new Attribute["button", scala.Option[String], String](tagRef, "formtarget")
    val name = new Attribute["button", scala.Option[String], String](tagRef, "name")
    val `type` = new Attribute["button", scala.Option[String], String](tagRef, "type")
    val value = new Attribute["button", scala.Option[String], String](tagRef, "value")
  }

  implicit class CanvasExtensions(tag: Tag["canvas"]) {
    def height: scala.Option[String] = tag.attr("height").asInstanceOf[scala.Option[String]]
    def height(value: String): Tag["canvas"] = tag.setAttr("height", value)
    def `moz-opaque`: scala.Option[String] = tag.attr("moz-opaque").asInstanceOf[scala.Option[String]]
    def `moz-opaque`(value: String): Tag["canvas"] = tag.setAttr("moz-opaque", value)
    def width: scala.Option[String] = tag.attr("width").asInstanceOf[scala.Option[String]]
    def width(value: String): Tag["canvas"] = tag.setAttr("width", value)
  }

  implicit class TagRefAttributesCanvas(tagRef: TagRef["canvas"]) {
    val height = new Attribute["canvas", scala.Option[String], String](tagRef, "height")
    val `moz-opaque` = new Attribute["canvas", scala.Option[String], String](tagRef, "moz-opaque")
    val width = new Attribute["canvas", scala.Option[String], String](tagRef, "width")
  }

  implicit class CaptionExtensions(tag: Tag["caption"]) {
    def align: scala.Option[String] = tag.attr("align").asInstanceOf[scala.Option[String]]
    def align(value: String): Tag["caption"] = tag.setAttr("align", value)
  }

  implicit class TagRefAttributesCaption(tagRef: TagRef["caption"]) {
    val align = new Attribute["caption", scala.Option[String], String](tagRef, "align")
  }

  implicit class ColExtensions(tag: Tag["col"]) {
    def align: scala.Option[String] = tag.attr("align").asInstanceOf[scala.Option[String]]
    def align(value: String): Tag["col"] = tag.setAttr("align", value)
    def bgcolor: scala.Option[String] = tag.attr("bgcolor").asInstanceOf[scala.Option[String]]
    def bgcolor(value: String): Tag["col"] = tag.setAttr("bgcolor", value)
    def char: scala.Option[String] = tag.attr("char").asInstanceOf[scala.Option[String]]
    def char(value: String): Tag["col"] = tag.setAttr("char", value)
    def charoff: scala.Option[String] = tag.attr("charoff").asInstanceOf[scala.Option[String]]
    def charoff(value: String): Tag["col"] = tag.setAttr("charoff", value)
    def span: scala.Option[Long] = tag.attr("span").asInstanceOf[scala.Option[Long]]
    def span(value: Long): Tag["col"] = tag.setAttr("span", value)
    def valign: scala.Option[String] = tag.attr("valign").asInstanceOf[scala.Option[String]]
    def valign(value: String): Tag["col"] = tag.setAttr("valign", value)
    def width: scala.Option[String] = tag.attr("width").asInstanceOf[scala.Option[String]]
    def width(value: String): Tag["col"] = tag.setAttr("width", value)
  }

  implicit class TagRefAttributesCol(tagRef: TagRef["col"]) {
    val align = new Attribute["col", scala.Option[String], String](tagRef, "align")
    val bgcolor = new Attribute["col", scala.Option[String], String](tagRef, "bgcolor")
    val char = new Attribute["col", scala.Option[String], String](tagRef, "char")
    val charoff = new Attribute["col", scala.Option[String], String](tagRef, "charoff")
    val span = new Attribute["col", scala.Option[Long], Long](tagRef, "span")
    val valign = new Attribute["col", scala.Option[String], String](tagRef, "valign")
    val width = new Attribute["col", scala.Option[String], String](tagRef, "width")
  }

  implicit class ColgroupExtensions(tag: Tag["colgroup"]) {
    def align: scala.Option[String] = tag.attr("align").asInstanceOf[scala.Option[String]]
    def align(value: String): Tag["colgroup"] = tag.setAttr("align", value)
    def bgcolor: scala.Option[String] = tag.attr("bgcolor").asInstanceOf[scala.Option[String]]
    def bgcolor(value: String): Tag["colgroup"] = tag.setAttr("bgcolor", value)
    def char: scala.Option[String] = tag.attr("char").asInstanceOf[scala.Option[String]]
    def char(value: String): Tag["colgroup"] = tag.setAttr("char", value)
    def charoff: scala.Option[String] = tag.attr("charoff").asInstanceOf[scala.Option[String]]
    def charoff(value: String): Tag["colgroup"] = tag.setAttr("charoff", value)
    def span: scala.Option[Long] = tag.attr("span").asInstanceOf[scala.Option[Long]]
    def span(value: Long): Tag["colgroup"] = tag.setAttr("span", value)
    def valign: scala.Option[String] = tag.attr("valign").asInstanceOf[scala.Option[String]]
    def valign(value: String): Tag["colgroup"] = tag.setAttr("valign", value)
    def width: scala.Option[String] = tag.attr("width").asInstanceOf[scala.Option[String]]
    def width(value: String): Tag["colgroup"] = tag.setAttr("width", value)
  }

  implicit class TagRefAttributesColgroup(tagRef: TagRef["colgroup"]) {
    val align = new Attribute["colgroup", scala.Option[String], String](tagRef, "align")
    val bgcolor = new Attribute["colgroup", scala.Option[String], String](tagRef, "bgcolor")
    val char = new Attribute["colgroup", scala.Option[String], String](tagRef, "char")
    val charoff = new Attribute["colgroup", scala.Option[String], String](tagRef, "charoff")
    val span = new Attribute["colgroup", scala.Option[Long], Long](tagRef, "span")
    val valign = new Attribute["colgroup", scala.Option[String], String](tagRef, "valign")
    val width = new Attribute["colgroup", scala.Option[String], String](tagRef, "width")
  }

  implicit class DdExtensions(tag: Tag["dd"]) {
    def nowrap: scala.Option[String] = tag.attr("nowrap").asInstanceOf[scala.Option[String]]
    def nowrap(value: String): Tag["dd"] = tag.setAttr("nowrap", value)
  }

  implicit class TagRefAttributesDd(tagRef: TagRef["dd"]) {
    val nowrap = new Attribute["dd", scala.Option[String], String](tagRef, "nowrap")
  }

  implicit class DelExtensions(tag: Tag["del"]) {
    def cite: scala.Option[String] = tag.attr("cite").asInstanceOf[scala.Option[String]]
    def cite(value: String): Tag["del"] = tag.setAttr("cite", value)
    def datetime: scala.Option[String] = tag.attr("datetime").asInstanceOf[scala.Option[String]]
    def datetime(value: String): Tag["del"] = tag.setAttr("datetime", value)
  }

  implicit class TagRefAttributesDel(tagRef: TagRef["del"]) {
    val cite = new Attribute["del", scala.Option[String], String](tagRef, "cite")
    val datetime = new Attribute["del", scala.Option[String], String](tagRef, "datetime")
  }

  implicit class DetailsExtensions(tag: Tag["details"]) {
    def open: scala.Option[String] = tag.attr("open").asInstanceOf[scala.Option[String]]
    def open(value: String): Tag["details"] = tag.setAttr("open", value)
  }

  implicit class TagRefAttributesDetails(tagRef: TagRef["details"]) {
    val open = new Attribute["details", scala.Option[String], String](tagRef, "open")
  }

  implicit class DialogExtensions(tag: Tag["dialog"]) {
    def open: Boolean = tag.attributes.contains("open")
    def open(value: Boolean): Tag["dialog"] = (if (value) tag.setAttr("open", "") else tag.remAttr("open"))
  }

  implicit class TagRefAttributesDialog(tagRef: TagRef["dialog"]) {
    val open = new Attribute["dialog", Boolean, Boolean](tagRef, "open")
  }

  implicit class DirExtensions(tag: Tag["dir"]) {
    def compact: scala.Option[String] = tag.attr("compact").asInstanceOf[scala.Option[String]]
    def compact(value: String): Tag["dir"] = tag.setAttr("compact", value)
  }

  implicit class TagRefAttributesDir(tagRef: TagRef["dir"]) {
    val compact = new Attribute["dir", scala.Option[String], String](tagRef, "compact")
  }

  implicit class DlExtensions(tag: Tag["dl"]) {
    def compact: Boolean = tag.attributes.contains("compact")
    def compact(value: Boolean): Tag["dl"] = (if (value) tag.setAttr("compact", "") else tag.remAttr("compact"))
  }

  implicit class TagRefAttributesDl(tagRef: TagRef["dl"]) {
    val compact = new Attribute["dl", Boolean, Boolean](tagRef, "compact")
  }

  implicit class EmbedExtensions(tag: Tag["embed"]) {
    def height: scala.Option[String] = tag.attr("height").asInstanceOf[scala.Option[String]]
    def height(value: String): Tag["embed"] = tag.setAttr("height", value)
    def src: scala.Option[String] = tag.attr("src").asInstanceOf[scala.Option[String]]
    def src(value: String): Tag["embed"] = tag.setAttr("src", value)
    def `type`: scala.Option[String] = tag.attr("type").asInstanceOf[scala.Option[String]]
    def `type`(value: String): Tag["embed"] = tag.setAttr("type", value)
    def width: scala.Option[String] = tag.attr("width").asInstanceOf[scala.Option[String]]
    def width(value: String): Tag["embed"] = tag.setAttr("width", value)
  }

  implicit class TagRefAttributesEmbed(tagRef: TagRef["embed"]) {
    val height = new Attribute["embed", scala.Option[String], String](tagRef, "height")
    val src = new Attribute["embed", scala.Option[String], String](tagRef, "src")
    val `type` = new Attribute["embed", scala.Option[String], String](tagRef, "type")
    val width = new Attribute["embed", scala.Option[String], String](tagRef, "width")
  }

  implicit class FieldsetExtensions(tag: Tag["fieldset"]) {
    def disabled: scala.Option[String] = tag.attr("disabled").asInstanceOf[scala.Option[String]]
    def disabled(value: String): Tag["fieldset"] = tag.setAttr("disabled", value)
    def form: scala.Option[String] = tag.attr("form").asInstanceOf[scala.Option[String]]
    def form(value: String): Tag["fieldset"] = tag.setAttr("form", value)
    def name: scala.Option[String] = tag.attr("name").asInstanceOf[scala.Option[String]]
    def name(value: String): Tag["fieldset"] = tag.setAttr("name", value)
  }

  implicit class TagRefAttributesFieldset(tagRef: TagRef["fieldset"]) {
    val disabled = new Attribute["fieldset", scala.Option[String], String](tagRef, "disabled")
    val form = new Attribute["fieldset", scala.Option[String], String](tagRef, "form")
    val name = new Attribute["fieldset", scala.Option[String], String](tagRef, "name")
  }

  implicit class FormExtensions(tag: Tag["form"]) {
    def accept: scala.Option[String] = tag.attr("accept").asInstanceOf[scala.Option[String]]
    def accept(value: String): Tag["form"] = tag.setAttr("accept", value)
    def `accept-charset`: scala.Option[String] = tag.attr("accept-charset").asInstanceOf[scala.Option[String]]
    def `accept-charset`(value: String): Tag["form"] = tag.setAttr("accept-charset", value)
    def action: scala.Option[String] = tag.attr("action").asInstanceOf[scala.Option[String]]
    def action(value: String): Tag["form"] = tag.setAttr("action", value)
    def autocapitalize: scala.Option[String] = tag.attr("autocapitalize").asInstanceOf[scala.Option[String]]
    def autocapitalize(value: String): Tag["form"] = tag.setAttr("autocapitalize", value)
    def autocomplete: scala.Option[String] = tag.attr("autocomplete").asInstanceOf[scala.Option[String]]
    def autocomplete(value: String): Tag["form"] = tag.setAttr("autocomplete", value)
    def enctype: scala.Option[String] = tag.attr("enctype").asInstanceOf[scala.Option[String]]
    def enctype(value: String): Tag["form"] = tag.setAttr("enctype", value)
    def method: scala.Option[String] = tag.attr("method").asInstanceOf[scala.Option[String]]
    def method(value: String): Tag["form"] = tag.setAttr("method", value)
    def name: scala.Option[String] = tag.attr("name").asInstanceOf[scala.Option[String]]
    def name(value: String): Tag["form"] = tag.setAttr("name", value)
    def novalidate: scala.Option[String] = tag.attr("novalidate").asInstanceOf[scala.Option[String]]
    def novalidate(value: String): Tag["form"] = tag.setAttr("novalidate", value)
    def target: scala.Option[String] = tag.attr("target").asInstanceOf[scala.Option[String]]
    def target(value: String): Tag["form"] = tag.setAttr("target", value)
  }

  implicit class TagRefAttributesForm(tagRef: TagRef["form"]) {
    val accept = new Attribute["form", scala.Option[String], String](tagRef, "accept")
    val `accept-charset` = new Attribute["form", scala.Option[String], String](tagRef, "accept-charset")
    val action = new Attribute["form", scala.Option[String], String](tagRef, "action")
    val autocapitalize = new Attribute["form", scala.Option[String], String](tagRef, "autocapitalize")
    val autocomplete = new Attribute["form", scala.Option[String], String](tagRef, "autocomplete")
    val enctype = new Attribute["form", scala.Option[String], String](tagRef, "enctype")
    val method = new Attribute["form", scala.Option[String], String](tagRef, "method")
    val name = new Attribute["form", scala.Option[String], String](tagRef, "name")
    val novalidate = new Attribute["form", scala.Option[String], String](tagRef, "novalidate")
    val target = new Attribute["form", scala.Option[String], String](tagRef, "target")
  }

  implicit class FrameExtensions(tag: Tag["frame"]) {
    def src: scala.Option[String] = tag.attr("src").asInstanceOf[scala.Option[String]]
    def src(value: String): Tag["frame"] = tag.setAttr("src", value)
    def name: scala.Option[String] = tag.attr("name").asInstanceOf[scala.Option[String]]
    def name(value: String): Tag["frame"] = tag.setAttr("name", value)
    def noresize: scala.Option[String] = tag.attr("noresize").asInstanceOf[scala.Option[String]]
    def noresize(value: String): Tag["frame"] = tag.setAttr("noresize", value)
    def scrolling: scala.Option[String] = tag.attr("scrolling").asInstanceOf[scala.Option[String]]
    def scrolling(value: String): Tag["frame"] = tag.setAttr("scrolling", value)
    def marginheight: scala.Option[String] = tag.attr("marginheight").asInstanceOf[scala.Option[String]]
    def marginheight(value: String): Tag["frame"] = tag.setAttr("marginheight", value)
    def marginwidth: scala.Option[String] = tag.attr("marginwidth").asInstanceOf[scala.Option[String]]
    def marginwidth(value: String): Tag["frame"] = tag.setAttr("marginwidth", value)
    def frameborder: scala.Option[String] = tag.attr("frameborder").asInstanceOf[scala.Option[String]]
    def frameborder(value: String): Tag["frame"] = tag.setAttr("frameborder", value)
  }

  implicit class TagRefAttributesFrame(tagRef: TagRef["frame"]) {
    val src = new Attribute["frame", scala.Option[String], String](tagRef, "src")
    val name = new Attribute["frame", scala.Option[String], String](tagRef, "name")
    val noresize = new Attribute["frame", scala.Option[String], String](tagRef, "noresize")
    val scrolling = new Attribute["frame", scala.Option[String], String](tagRef, "scrolling")
    val marginheight = new Attribute["frame", scala.Option[String], String](tagRef, "marginheight")
    val marginwidth = new Attribute["frame", scala.Option[String], String](tagRef, "marginwidth")
    val frameborder = new Attribute["frame", scala.Option[String], String](tagRef, "frameborder")
  }

  implicit class FramesetExtensions(tag: Tag["frameset"]) {
    def cols: scala.Option[String] = tag.attr("cols").asInstanceOf[scala.Option[String]]
    def cols(value: String): Tag["frameset"] = tag.setAttr("cols", value)
    def rows: scala.Option[String] = tag.attr("rows").asInstanceOf[scala.Option[String]]
    def rows(value: String): Tag["frameset"] = tag.setAttr("rows", value)
  }

  implicit class TagRefAttributesFrameset(tagRef: TagRef["frameset"]) {
    val cols = new Attribute["frameset", scala.Option[String], String](tagRef, "cols")
    val rows = new Attribute["frameset", scala.Option[String], String](tagRef, "rows")
  }

  implicit class HeadExtensions(tag: Tag["head"]) {
    def profile: scala.Option[String] = tag.attr("profile").asInstanceOf[scala.Option[String]]
    def profile(value: String): Tag["head"] = tag.setAttr("profile", value)
  }

  implicit class TagRefAttributesHead(tagRef: TagRef["head"]) {
    val profile = new Attribute["head", scala.Option[String], String](tagRef, "profile")
  }

  implicit class HrExtensions(tag: Tag["hr"]) {
    def align: scala.Option[String] = tag.attr("align").asInstanceOf[scala.Option[String]]
    def align(value: String): Tag["hr"] = tag.setAttr("align", value)
    def color: scala.Option[String] = tag.attr("color").asInstanceOf[scala.Option[String]]
    def color(value: String): Tag["hr"] = tag.setAttr("color", value)
    def noshade: Boolean = tag.attributes.contains("noshade")
    def noshade(value: Boolean): Tag["hr"] = (if (value) tag.setAttr("noshade", "") else tag.remAttr("noshade"))
    def size: scala.Option[String] = tag.attr("size").asInstanceOf[scala.Option[String]]
    def size(value: String): Tag["hr"] = tag.setAttr("size", value)
    def width: scala.Option[String] = tag.attr("width").asInstanceOf[scala.Option[String]]
    def width(value: String): Tag["hr"] = tag.setAttr("width", value)
  }

  implicit class TagRefAttributesHr(tagRef: TagRef["hr"]) {
    val align = new Attribute["hr", scala.Option[String], String](tagRef, "align")
    val color = new Attribute["hr", scala.Option[String], String](tagRef, "color")
    val noshade = new Attribute["hr", Boolean, Boolean](tagRef, "noshade")
    val size = new Attribute["hr", scala.Option[String], String](tagRef, "size")
    val width = new Attribute["hr", scala.Option[String], String](tagRef, "width")
  }

  implicit class HtmlExtensions(tag: Tag["html"]) {
    def manifest: scala.Option[String] = tag.attr("manifest").asInstanceOf[scala.Option[String]]
    def manifest(value: String): Tag["html"] = tag.setAttr("manifest", value)
    def version: scala.Option[String] = tag.attr("version").asInstanceOf[scala.Option[String]]
    def version(value: String): Tag["html"] = tag.setAttr("version", value)
    def xmlns: scala.Option[String] = tag.attr("xmlns").asInstanceOf[scala.Option[String]]
    def xmlns(value: String): Tag["html"] = tag.setAttr("xmlns", value)
  }

  implicit class TagRefAttributesHtml(tagRef: TagRef["html"]) {
    val manifest = new Attribute["html", scala.Option[String], String](tagRef, "manifest")
    val version = new Attribute["html", scala.Option[String], String](tagRef, "version")
    val xmlns = new Attribute["html", scala.Option[String], String](tagRef, "xmlns")
  }

  implicit class IframeExtensions(tag: Tag["iframe"]) {
    def align: scala.Option[String] = tag.attr("align").asInstanceOf[scala.Option[String]]
    def align(value: String): Tag["iframe"] = tag.setAttr("align", value)
    def allowfullscreen: scala.Option[String] = tag.attr("allowfullscreen").asInstanceOf[scala.Option[String]]
    def allowfullscreen(value: String): Tag["iframe"] = tag.setAttr("allowfullscreen", value)
    def frameborder: scala.Option[String] = tag.attr("frameborder").asInstanceOf[scala.Option[String]]
    def frameborder(value: String): Tag["iframe"] = tag.setAttr("frameborder", value)
    def height: scala.Option[String] = tag.attr("height").asInstanceOf[scala.Option[String]]
    def height(value: String): Tag["iframe"] = tag.setAttr("height", value)
    def longdesc: scala.Option[String] = tag.attr("longdesc").asInstanceOf[scala.Option[String]]
    def longdesc(value: String): Tag["iframe"] = tag.setAttr("longdesc", value)
    def marginheight: scala.Option[String] = tag.attr("marginheight").asInstanceOf[scala.Option[String]]
    def marginheight(value: String): Tag["iframe"] = tag.setAttr("marginheight", value)
    def marginwidth: scala.Option[String] = tag.attr("marginwidth").asInstanceOf[scala.Option[String]]
    def marginwidth(value: String): Tag["iframe"] = tag.setAttr("marginwidth", value)
    def mozallowfullscreen: scala.Option[String] = tag.attr("mozallowfullscreen").asInstanceOf[scala.Option[String]]
    def mozallowfullscreen(value: String): Tag["iframe"] = tag.setAttr("mozallowfullscreen", value)
    def webkitallowfullscreen: scala.Option[String] = tag.attr("webkitallowfullscreen").asInstanceOf[scala.Option[String]]
    def webkitallowfullscreen(value: String): Tag["iframe"] = tag.setAttr("webkitallowfullscreen", value)
    def mozapp: scala.Option[String] = tag.attr("mozapp").asInstanceOf[scala.Option[String]]
    def mozapp(value: String): Tag["iframe"] = tag.setAttr("mozapp", value)
    def mozbrowser: scala.Option[String] = tag.attr("mozbrowser").asInstanceOf[scala.Option[String]]
    def mozbrowser(value: String): Tag["iframe"] = tag.setAttr("mozbrowser", value)
    def name: scala.Option[String] = tag.attr("name").asInstanceOf[scala.Option[String]]
    def name(value: String): Tag["iframe"] = tag.setAttr("name", value)
    def remote: scala.Option[String] = tag.attr("remote").asInstanceOf[scala.Option[String]]
    def remote(value: String): Tag["iframe"] = tag.setAttr("remote", value)
    def scrolling: scala.Option[String] = tag.attr("scrolling").asInstanceOf[scala.Option[String]]
    def scrolling(value: String): Tag["iframe"] = tag.setAttr("scrolling", value)
    def sandbox: scala.Option[String] = tag.attr("sandbox").asInstanceOf[scala.Option[String]]
    def sandbox(value: String): Tag["iframe"] = tag.setAttr("sandbox", value)
    def seamless: scala.Option[String] = tag.attr("seamless").asInstanceOf[scala.Option[String]]
    def seamless(value: String): Tag["iframe"] = tag.setAttr("seamless", value)
    def src: scala.Option[String] = tag.attr("src").asInstanceOf[scala.Option[String]]
    def src(value: String): Tag["iframe"] = tag.setAttr("src", value)
    def srcdoc: scala.Option[String] = tag.attr("srcdoc").asInstanceOf[scala.Option[String]]
    def srcdoc(value: String): Tag["iframe"] = tag.setAttr("srcdoc", value)
    def width: scala.Option[String] = tag.attr("width").asInstanceOf[scala.Option[String]]
    def width(value: String): Tag["iframe"] = tag.setAttr("width", value)
  }

  implicit class TagRefAttributesIframe(tagRef: TagRef["iframe"]) {
    val align = new Attribute["iframe", scala.Option[String], String](tagRef, "align")
    val allowfullscreen = new Attribute["iframe", scala.Option[String], String](tagRef, "allowfullscreen")
    val frameborder = new Attribute["iframe", scala.Option[String], String](tagRef, "frameborder")
    val height = new Attribute["iframe", scala.Option[String], String](tagRef, "height")
    val longdesc = new Attribute["iframe", scala.Option[String], String](tagRef, "longdesc")
    val marginheight = new Attribute["iframe", scala.Option[String], String](tagRef, "marginheight")
    val marginwidth = new Attribute["iframe", scala.Option[String], String](tagRef, "marginwidth")
    val mozallowfullscreen = new Attribute["iframe", scala.Option[String], String](tagRef, "mozallowfullscreen")
    val webkitallowfullscreen = new Attribute["iframe", scala.Option[String], String](tagRef, "webkitallowfullscreen")
    val mozapp = new Attribute["iframe", scala.Option[String], String](tagRef, "mozapp")
    val mozbrowser = new Attribute["iframe", scala.Option[String], String](tagRef, "mozbrowser")
    val name = new Attribute["iframe", scala.Option[String], String](tagRef, "name")
    val remote = new Attribute["iframe", scala.Option[String], String](tagRef, "remote")
    val scrolling = new Attribute["iframe", scala.Option[String], String](tagRef, "scrolling")
    val sandbox = new Attribute["iframe", scala.Option[String], String](tagRef, "sandbox")
    val seamless = new Attribute["iframe", scala.Option[String], String](tagRef, "seamless")
    val src = new Attribute["iframe", scala.Option[String], String](tagRef, "src")
    val srcdoc = new Attribute["iframe", scala.Option[String], String](tagRef, "srcdoc")
    val width = new Attribute["iframe", scala.Option[String], String](tagRef, "width")
  }

  implicit class ImgExtensions(tag: Tag["img"]) {
    def `align vertical-align`: scala.Option[String] = tag.attr("align vertical-align").asInstanceOf[scala.Option[String]]
    def `align vertical-align`(value: String): Tag["img"] = tag.setAttr("align vertical-align", value)
    def alt: scala.Option[String] = tag.attr("alt").asInstanceOf[scala.Option[String]]
    def alt(value: String): Tag["img"] = tag.setAttr("alt", value)
    def border: scala.Option[String] = tag.attr("border").asInstanceOf[scala.Option[String]]
    def border(value: String): Tag["img"] = tag.setAttr("border", value)
    def crossorigin: scala.Option[String] = tag.attr("crossorigin").asInstanceOf[scala.Option[String]]
    def crossorigin(value: String): Tag["img"] = tag.setAttr("crossorigin", value)
    def height: scala.Option[String] = tag.attr("height").asInstanceOf[scala.Option[String]]
    def height(value: String): Tag["img"] = tag.setAttr("height", value)
    def hspace: scala.Option[String] = tag.attr("hspace").asInstanceOf[scala.Option[String]]
    def hspace(value: String): Tag["img"] = tag.setAttr("hspace", value)
    def ismap: scala.Option[String] = tag.attr("ismap").asInstanceOf[scala.Option[String]]
    def ismap(value: String): Tag["img"] = tag.setAttr("ismap", value)
    def longdesc: scala.Option[String] = tag.attr("longdesc").asInstanceOf[scala.Option[String]]
    def longdesc(value: String): Tag["img"] = tag.setAttr("longdesc", value)
    def name: scala.Option[String] = tag.attr("name").asInstanceOf[scala.Option[String]]
    def name(value: String): Tag["img"] = tag.setAttr("name", value)
    def sizes: scala.Option[String] = tag.attr("sizes").asInstanceOf[scala.Option[String]]
    def sizes(value: String): Tag["img"] = tag.setAttr("sizes", value)
    def src: scala.Option[String] = tag.attr("src").asInstanceOf[scala.Option[String]]
    def src(value: String): Tag["img"] = tag.setAttr("src", value)
    def srcset: scala.Option[String] = tag.attr("srcset").asInstanceOf[scala.Option[String]]
    def srcset(value: String): Tag["img"] = tag.setAttr("srcset", value)
    def width: scala.Option[String] = tag.attr("width").asInstanceOf[scala.Option[String]]
    def width(value: String): Tag["img"] = tag.setAttr("width", value)
    def usemap: scala.Option[String] = tag.attr("usemap").asInstanceOf[scala.Option[String]]
    def usemap(value: String): Tag["img"] = tag.setAttr("usemap", value)
    def vspace: scala.Option[String] = tag.attr("vspace").asInstanceOf[scala.Option[String]]
    def vspace(value: String): Tag["img"] = tag.setAttr("vspace", value)
  }

  implicit class TagRefAttributesImg(tagRef: TagRef["img"]) {
    val `align vertical-align` = new Attribute["img", scala.Option[String], String](tagRef, "align vertical-align")
    val alt = new Attribute["img", scala.Option[String], String](tagRef, "alt")
    val border = new Attribute["img", scala.Option[String], String](tagRef, "border")
    val crossorigin = new Attribute["img", scala.Option[String], String](tagRef, "crossorigin")
    val height = new Attribute["img", scala.Option[String], String](tagRef, "height")
    val hspace = new Attribute["img", scala.Option[String], String](tagRef, "hspace")
    val ismap = new Attribute["img", scala.Option[String], String](tagRef, "ismap")
    val longdesc = new Attribute["img", scala.Option[String], String](tagRef, "longdesc")
    val name = new Attribute["img", scala.Option[String], String](tagRef, "name")
    val sizes = new Attribute["img", scala.Option[String], String](tagRef, "sizes")
    val src = new Attribute["img", scala.Option[String], String](tagRef, "src")
    val srcset = new Attribute["img", scala.Option[String], String](tagRef, "srcset")
    val width = new Attribute["img", scala.Option[String], String](tagRef, "width")
    val usemap = new Attribute["img", scala.Option[String], String](tagRef, "usemap")
    val vspace = new Attribute["img", scala.Option[String], String](tagRef, "vspace")
  }

  implicit class InputExtensions(tag: Tag["input"]) {
    def `type`: scala.Option[String] = tag.attr("type").asInstanceOf[scala.Option[String]]
    def `type`(value: String): Tag["input"] = tag.setAttr("type", value)
    def accept: scala.Option[String] = tag.attr("accept").asInstanceOf[scala.Option[String]]
    def accept(value: String): Tag["input"] = tag.setAttr("accept", value)
    def mozactionhint: scala.Option[String] = tag.attr("mozactionhint").asInstanceOf[scala.Option[String]]
    def mozactionhint(value: String): Tag["input"] = tag.setAttr("mozactionhint", value)
    def autocapitalize: scala.Option[String] = tag.attr("autocapitalize").asInstanceOf[scala.Option[String]]
    def autocapitalize(value: String): Tag["input"] = tag.setAttr("autocapitalize", value)
    def autocomplete: scala.Option[String] = tag.attr("autocomplete").asInstanceOf[scala.Option[String]]
    def autocomplete(value: String): Tag["input"] = tag.setAttr("autocomplete", value)
    def autocorrect: scala.Option[String] = tag.attr("autocorrect").asInstanceOf[scala.Option[String]]
    def autocorrect(value: String): Tag["input"] = tag.setAttr("autocorrect", value)
    def autofocus: Boolean = tag.attributes.contains("autofocus")
    def autofocus(value: Boolean): Tag["input"] = (if (value) tag.setAttr("autofocus", "") else tag.remAttr("autofocus"))
    def autosave: scala.Option[String] = tag.attr("autosave").asInstanceOf[scala.Option[String]]
    def autosave(value: String): Tag["input"] = tag.setAttr("autosave", value)
    def checked: Boolean = tag.attributes.contains("checked")
    def checked(value: Boolean): Tag["input"] = (if (value) tag.setAttr("checked", "") else tag.remAttr("checked"))
    def disabled: Boolean = tag.attributes.contains("disabled")
    def disabled(value: Boolean): Tag["input"] = (if (value) tag.setAttr("disabled", "") else tag.remAttr("disabled"))
    def form: scala.Option[String] = tag.attr("form").asInstanceOf[scala.Option[String]]
    def form(value: String): Tag["input"] = tag.setAttr("form", value)
    def formaction: scala.Option[String] = tag.attr("formaction").asInstanceOf[scala.Option[String]]
    def formaction(value: String): Tag["input"] = tag.setAttr("formaction", value)
    def formenctype: scala.Option[String] = tag.attr("formenctype").asInstanceOf[scala.Option[String]]
    def formenctype(value: String): Tag["input"] = tag.setAttr("formenctype", value)
    def formmethod: scala.Option[String] = tag.attr("formmethod").asInstanceOf[scala.Option[String]]
    def formmethod(value: String): Tag["input"] = tag.setAttr("formmethod", value)
    def formnovalidate: scala.Option[String] = tag.attr("formnovalidate").asInstanceOf[scala.Option[String]]
    def formnovalidate(value: String): Tag["input"] = tag.setAttr("formnovalidate", value)
    def formtarget: scala.Option[String] = tag.attr("formtarget").asInstanceOf[scala.Option[String]]
    def formtarget(value: String): Tag["input"] = tag.setAttr("formtarget", value)
    def height: scala.Option[String] = tag.attr("height").asInstanceOf[scala.Option[String]]
    def height(value: String): Tag["input"] = tag.setAttr("height", value)
    def incremental: scala.Option[String] = tag.attr("incremental").asInstanceOf[scala.Option[String]]
    def incremental(value: String): Tag["input"] = tag.setAttr("incremental", value)
    def inputmode: scala.Option[String] = tag.attr("inputmode").asInstanceOf[scala.Option[String]]
    def inputmode(value: String): Tag["input"] = tag.setAttr("inputmode", value)
    def list: scala.Option[String] = tag.attr("list").asInstanceOf[scala.Option[String]]
    def list(value: String): Tag["input"] = tag.setAttr("list", value)
    def max: scala.Option[String] = tag.attr("max").asInstanceOf[scala.Option[String]]
    def max(value: String): Tag["input"] = tag.setAttr("max", value)
    def maxlength: scala.Option[String] = tag.attr("maxlength").asInstanceOf[scala.Option[String]]
    def maxlength(value: String): Tag["input"] = tag.setAttr("maxlength", value)
    def min: scala.Option[String] = tag.attr("min").asInstanceOf[scala.Option[String]]
    def min(value: String): Tag["input"] = tag.setAttr("min", value)
    def minlength: scala.Option[String] = tag.attr("minlength").asInstanceOf[scala.Option[String]]
    def minlength(value: String): Tag["input"] = tag.setAttr("minlength", value)
    def multiple: scala.Option[String] = tag.attr("multiple").asInstanceOf[scala.Option[String]]
    def multiple(value: String): Tag["input"] = tag.setAttr("multiple", value)
    def name: scala.Option[String] = tag.attr("name").asInstanceOf[scala.Option[String]]
    def name(value: String): Tag["input"] = tag.setAttr("name", value)
    def pattern: scala.Option[String] = tag.attr("pattern").asInstanceOf[scala.Option[String]]
    def pattern(value: String): Tag["input"] = tag.setAttr("pattern", value)
    def placeholder: scala.Option[String] = tag.attr("placeholder").asInstanceOf[scala.Option[String]]
    def placeholder(value: String): Tag["input"] = tag.setAttr("placeholder", value)
    def readonly: scala.Option[String] = tag.attr("readonly").asInstanceOf[scala.Option[String]]
    def readonly(value: String): Tag["input"] = tag.setAttr("readonly", value)
    def required: Boolean = tag.attributes.contains("required")
    def required(value: Boolean): Tag["input"] = (if (value) tag.setAttr("required", "") else tag.remAttr("required"))
    def results: scala.Option[String] = tag.attr("results").asInstanceOf[scala.Option[String]]
    def results(value: String): Tag["input"] = tag.setAttr("results", value)
    def selectionDirection: scala.Option[String] = tag.attr("selectionDirection").asInstanceOf[scala.Option[String]]
    def selectionDirection(value: String): Tag["input"] = tag.setAttr("selectionDirection", value)
    def size: scala.Option[Long] = tag.attr("size").asInstanceOf[scala.Option[Long]]
    def size(value: Long): Tag["input"] = tag.setAttr("size", value)
    def src: scala.Option[String] = tag.attr("src").asInstanceOf[scala.Option[String]]
    def src(value: String): Tag["input"] = tag.setAttr("src", value)
    def step: scala.Option[String] = tag.attr("step").asInstanceOf[scala.Option[String]]
    def step(value: String): Tag["input"] = tag.setAttr("step", value)
    def usemap: scala.Option[String] = tag.attr("usemap").asInstanceOf[scala.Option[String]]
    def usemap(value: String): Tag["input"] = tag.setAttr("usemap", value)
    def value: scala.Option[String] = tag.attr("value").asInstanceOf[scala.Option[String]]
    def value(value: String): Tag["input"] = tag.setAttr("value", value)
    def width: scala.Option[String] = tag.attr("width").asInstanceOf[scala.Option[String]]
    def width(value: String): Tag["input"] = tag.setAttr("width", value)
    def `x-moz-errormessage`: scala.Option[String] = tag.attr("x-moz-errormessage").asInstanceOf[scala.Option[String]]
    def `x-moz-errormessage`(value: String): Tag["input"] = tag.setAttr("x-moz-errormessage", value)
  }

  implicit class TagRefAttributesInput(tagRef: TagRef["input"]) {
    val `type` = new Attribute["input", scala.Option[String], String](tagRef, "type")
    val accept = new Attribute["input", scala.Option[String], String](tagRef, "accept")
    val accesskey = new Attribute["input", scala.Option[String], String](tagRef, "accesskey")
    val mozactionhint = new Attribute["input", scala.Option[String], String](tagRef, "mozactionhint")
    val autocapitalize = new Attribute["input", scala.Option[String], String](tagRef, "autocapitalize")
    val autocomplete = new Attribute["input", scala.Option[String], String](tagRef, "autocomplete")
    val autocorrect = new Attribute["input", scala.Option[String], String](tagRef, "autocorrect")
    val autofocus = new Attribute["input", Boolean, Boolean](tagRef, "autofocus")
    val autosave = new Attribute["input", scala.Option[String], String](tagRef, "autosave")
    val checked = new Attribute["input", Boolean, Boolean](tagRef, "checked")
    val disabled = new Attribute["input", Boolean, Boolean](tagRef, "disabled")
    val form = new Attribute["input", scala.Option[String], String](tagRef, "form")
    val formaction = new Attribute["input", scala.Option[String], String](tagRef, "formaction")
    val formenctype = new Attribute["input", scala.Option[String], String](tagRef, "formenctype")
    val formmethod = new Attribute["input", scala.Option[String], String](tagRef, "formmethod")
    val formnovalidate = new Attribute["input", scala.Option[String], String](tagRef, "formnovalidate")
    val formtarget = new Attribute["input", scala.Option[String], String](tagRef, "formtarget")
    val height = new Attribute["input", scala.Option[String], String](tagRef, "height")
    val incremental = new Attribute["input", scala.Option[String], String](tagRef, "incremental")
    val inputmode = new Attribute["input", scala.Option[String], String](tagRef, "inputmode")
    val list = new Attribute["input", scala.Option[String], String](tagRef, "list")
    val max = new Attribute["input", scala.Option[String], String](tagRef, "max")
    val maxlength = new Attribute["input", scala.Option[String], String](tagRef, "maxlength")
    val min = new Attribute["input", scala.Option[String], String](tagRef, "min")
    val minlength = new Attribute["input", scala.Option[String], String](tagRef, "minlength")
    val multiple = new Attribute["input", scala.Option[String], String](tagRef, "multiple")
    val name = new Attribute["input", scala.Option[String], String](tagRef, "name")
    val pattern = new Attribute["input", scala.Option[String], String](tagRef, "pattern")
    val placeholder = new Attribute["input", scala.Option[String], String](tagRef, "placeholder")
    val readonly = new Attribute["input", scala.Option[String], String](tagRef, "readonly")
    val required = new Attribute["input", Boolean, Boolean](tagRef, "required")
    val results = new Attribute["input", scala.Option[String], String](tagRef, "results")
    val selectionDirection = new Attribute["input", scala.Option[String], String](tagRef, "selectionDirection")
    val size = new Attribute["input", scala.Option[Long], Long](tagRef, "size")
    val spellcheck = new Attribute["input", scala.Option[String], String](tagRef, "spellcheck")
    val src = new Attribute["input", scala.Option[String], String](tagRef, "src")
    val step = new Attribute["input", scala.Option[String], String](tagRef, "step")
    val tabindex = new Attribute["input", scala.Option[String], String](tagRef, "tabindex")
    val usemap = new Attribute["input", scala.Option[String], String](tagRef, "usemap")
    val value = new Attribute["input", scala.Option[String], String](tagRef, "value")
    val width = new Attribute["input", scala.Option[String], String](tagRef, "width")
    val `x-moz-errormessage` = new Attribute["input", scala.Option[String], String](tagRef, "x-moz-errormessage")
  }

  implicit class InsExtensions(tag: Tag["ins"]) {
    def cite: scala.Option[String] = tag.attr("cite").asInstanceOf[scala.Option[String]]
    def cite(value: String): Tag["ins"] = tag.setAttr("cite", value)
    def datetime: scala.Option[String] = tag.attr("datetime").asInstanceOf[scala.Option[String]]
    def datetime(value: String): Tag["ins"] = tag.setAttr("datetime", value)
  }

  implicit class TagRefAttributesIns(tagRef: TagRef["ins"]) {
    val cite = new Attribute["ins", scala.Option[String], String](tagRef, "cite")
    val datetime = new Attribute["ins", scala.Option[String], String](tagRef, "datetime")
  }

  implicit class IsindexExtensions(tag: Tag["isindex"]) {
    def prompt: scala.Option[String] = tag.attr("prompt").asInstanceOf[scala.Option[String]]
    def prompt(value: String): Tag["isindex"] = tag.setAttr("prompt", value)
    def action: scala.Option[String] = tag.attr("action").asInstanceOf[scala.Option[String]]
    def action(value: String): Tag["isindex"] = tag.setAttr("action", value)
  }

  implicit class TagRefAttributesIsindex(tagRef: TagRef["isindex"]) {
    val prompt = new Attribute["isindex", scala.Option[String], String](tagRef, "prompt")
    val action = new Attribute["isindex", scala.Option[String], String](tagRef, "action")
  }

  implicit class KeygenExtensions(tag: Tag["keygen"]) {
    def autofocus: scala.Option[String] = tag.attr("autofocus").asInstanceOf[scala.Option[String]]
    def autofocus(value: String): Tag["keygen"] = tag.setAttr("autofocus", value)
    def challenge: scala.Option[String] = tag.attr("challenge").asInstanceOf[scala.Option[String]]
    def challenge(value: String): Tag["keygen"] = tag.setAttr("challenge", value)
    def disabled: scala.Option[String] = tag.attr("disabled").asInstanceOf[scala.Option[String]]
    def disabled(value: String): Tag["keygen"] = tag.setAttr("disabled", value)
    def form: scala.Option[String] = tag.attr("form").asInstanceOf[scala.Option[String]]
    def form(value: String): Tag["keygen"] = tag.setAttr("form", value)
    def keytype: scala.Option[String] = tag.attr("keytype").asInstanceOf[scala.Option[String]]
    def keytype(value: String): Tag["keygen"] = tag.setAttr("keytype", value)
    def name: scala.Option[String] = tag.attr("name").asInstanceOf[scala.Option[String]]
    def name(value: String): Tag["keygen"] = tag.setAttr("name", value)
  }

  implicit class TagRefAttributesKeygen(tagRef: TagRef["keygen"]) {
    val autofocus = new Attribute["keygen", scala.Option[String], String](tagRef, "autofocus")
    val challenge = new Attribute["keygen", scala.Option[String], String](tagRef, "challenge")
    val disabled = new Attribute["keygen", scala.Option[String], String](tagRef, "disabled")
    val form = new Attribute["keygen", scala.Option[String], String](tagRef, "form")
    val keytype = new Attribute["keygen", scala.Option[String], String](tagRef, "keytype")
    val name = new Attribute["keygen", scala.Option[String], String](tagRef, "name")
  }

  implicit class LabelExtensions(tag: Tag["label"]) {
    def `for`: scala.Option[String] = tag.attr("for").asInstanceOf[scala.Option[String]]
    def `for`(value: String): Tag["label"] = tag.setAttr("for", value)
    def form: scala.Option[String] = tag.attr("form").asInstanceOf[scala.Option[String]]
    def form(value: String): Tag["label"] = tag.setAttr("form", value)
  }

  implicit class TagRefAttributesLabel(tagRef: TagRef["label"]) {
    val accesskey = new Attribute["label", scala.Option[String], String](tagRef, "accesskey")
    val `for` = new Attribute["label", scala.Option[String], String](tagRef, "for")
    val form = new Attribute["label", scala.Option[String], String](tagRef, "form")
  }

  implicit class LiExtensions(tag: Tag["li"]) {
    def value: scala.Option[Long] = tag.attr("value").asInstanceOf[scala.Option[Long]]
    def value(value: Long): Tag["li"] = tag.setAttr("value", value)
    def `type`: scala.Option[String] = tag.attr("type").asInstanceOf[scala.Option[String]]
    def `type`(value: String): Tag["li"] = tag.setAttr("type", value)
  }

  implicit class TagRefAttributesLi(tagRef: TagRef["li"]) {
    val value = new Attribute["li", scala.Option[Long], Long](tagRef, "value")
    val `type` = new Attribute["li", scala.Option[String], String](tagRef, "type")
  }

  implicit class LinkExtensions(tag: Tag["link"]) {
    def charset: scala.Option[String] = tag.attr("charset").asInstanceOf[scala.Option[String]]
    def charset(value: String): Tag["link"] = tag.setAttr("charset", value)
    def crossorigin: scala.Option[String] = tag.attr("crossorigin").asInstanceOf[scala.Option[String]]
    def crossorigin(value: String): Tag["link"] = tag.setAttr("crossorigin", value)
    def disabled: scala.Option[String] = tag.attr("disabled").asInstanceOf[scala.Option[String]]
    def disabled(value: String): Tag["link"] = tag.setAttr("disabled", value)
    def href: scala.Option[String] = tag.attr("href").asInstanceOf[scala.Option[String]]
    def href(value: String): Tag["link"] = tag.setAttr("href", value)
    def hreflang: scala.Option[String] = tag.attr("hreflang").asInstanceOf[scala.Option[String]]
    def hreflang(value: String): Tag["link"] = tag.setAttr("hreflang", value)
    def media: scala.Option[String] = tag.attr("media").asInstanceOf[scala.Option[String]]
    def media(value: String): Tag["link"] = tag.setAttr("media", value)
    def methods: scala.Option[String] = tag.attr("methods").asInstanceOf[scala.Option[String]]
    def methods(value: String): Tag["link"] = tag.setAttr("methods", value)
    def rel: scala.Option[String] = tag.attr("rel").asInstanceOf[scala.Option[String]]
    def rel(value: String): Tag["link"] = tag.setAttr("rel", value)
    def rev: scala.Option[String] = tag.attr("rev").asInstanceOf[scala.Option[String]]
    def rev(value: String): Tag["link"] = tag.setAttr("rev", value)
    def sizes: scala.Option[String] = tag.attr("sizes").asInstanceOf[scala.Option[String]]
    def sizes(value: String): Tag["link"] = tag.setAttr("sizes", value)
    def target: scala.Option[String] = tag.attr("target").asInstanceOf[scala.Option[String]]
    def target(value: String): Tag["link"] = tag.setAttr("target", value)
    def `type`: scala.Option[String] = tag.attr("type").asInstanceOf[scala.Option[String]]
    def `type`(value: String): Tag["link"] = tag.setAttr("type", value)
    def integrity: scala.Option[String] = tag.attr("integrity").asInstanceOf[scala.Option[String]]
    def integrity(value: String): Tag["link"] = tag.setAttr("integrity", value)
  }

  implicit class TagRefAttributesLink(tagRef: TagRef["link"]) {
    val charset = new Attribute["link", scala.Option[String], String](tagRef, "charset")
    val crossorigin = new Attribute["link", scala.Option[String], String](tagRef, "crossorigin")
    val disabled = new Attribute["link", scala.Option[String], String](tagRef, "disabled")
    val href = new Attribute["link", scala.Option[String], String](tagRef, "href")
    val hreflang = new Attribute["link", scala.Option[String], String](tagRef, "hreflang")
    val media = new Attribute["link", scala.Option[String], String](tagRef, "media")
    val methods = new Attribute["link", scala.Option[String], String](tagRef, "methods")
    val rel = new Attribute["link", scala.Option[String], String](tagRef, "rel")
    val rev = new Attribute["link", scala.Option[String], String](tagRef, "rev")
    val sizes = new Attribute["link", scala.Option[String], String](tagRef, "sizes")
    val target = new Attribute["link", scala.Option[String], String](tagRef, "target")
    val `type` = new Attribute["link", scala.Option[String], String](tagRef, "type")
    val integrity = new Attribute["link", scala.Option[String], String](tagRef, "integrity")
  }

  implicit class MapExtensions(tag: Tag["map"]) {
    def name: scala.Option[String] = tag.attr("name").asInstanceOf[scala.Option[String]]
    def name(value: String): Tag["map"] = tag.setAttr("name", value)
  }

  implicit class TagRefAttributesMap(tagRef: TagRef["map"]) {
    val name = new Attribute["map", scala.Option[String], String](tagRef, "name")
  }

  implicit class MenuExtensions(tag: Tag["menu"]) {
    def label: scala.Option[String] = tag.attr("label").asInstanceOf[scala.Option[String]]
    def label(value: String): Tag["menu"] = tag.setAttr("label", value)
    def `type`: scala.Option[String] = tag.attr("type").asInstanceOf[scala.Option[String]]
    def `type`(value: String): Tag["menu"] = tag.setAttr("type", value)
  }

  implicit class TagRefAttributesMenu(tagRef: TagRef["menu"]) {
    val label = new Attribute["menu", scala.Option[String], String](tagRef, "label")
    val `type` = new Attribute["menu", scala.Option[String], String](tagRef, "type")
  }

  implicit class MenuitemExtensions(tag: Tag["menuitem"]) {
    def checked: scala.Option[String] = tag.attr("checked").asInstanceOf[scala.Option[String]]
    def checked(value: String): Tag["menuitem"] = tag.setAttr("checked", value)
    def command: scala.Option[String] = tag.attr("command").asInstanceOf[scala.Option[String]]
    def command(value: String): Tag["menuitem"] = tag.setAttr("command", value)
    def default: scala.Option[String] = tag.attr("default").asInstanceOf[scala.Option[String]]
    def default(value: String): Tag["menuitem"] = tag.setAttr("default", value)
    def disabled: scala.Option[String] = tag.attr("disabled").asInstanceOf[scala.Option[String]]
    def disabled(value: String): Tag["menuitem"] = tag.setAttr("disabled", value)
    def icon: scala.Option[String] = tag.attr("icon").asInstanceOf[scala.Option[String]]
    def icon(value: String): Tag["menuitem"] = tag.setAttr("icon", value)
    def label: scala.Option[String] = tag.attr("label").asInstanceOf[scala.Option[String]]
    def label(value: String): Tag["menuitem"] = tag.setAttr("label", value)
    def radiogroup: scala.Option[String] = tag.attr("radiogroup").asInstanceOf[scala.Option[String]]
    def radiogroup(value: String): Tag["menuitem"] = tag.setAttr("radiogroup", value)
    def `type`: scala.Option[String] = tag.attr("type").asInstanceOf[scala.Option[String]]
    def `type`(value: String): Tag["menuitem"] = tag.setAttr("type", value)
  }

  implicit class TagRefAttributesMenuitem(tagRef: TagRef["menuitem"]) {
    val checked = new Attribute["menuitem", scala.Option[String], String](tagRef, "checked")
    val command = new Attribute["menuitem", scala.Option[String], String](tagRef, "command")
    val default = new Attribute["menuitem", scala.Option[String], String](tagRef, "default")
    val disabled = new Attribute["menuitem", scala.Option[String], String](tagRef, "disabled")
    val icon = new Attribute["menuitem", scala.Option[String], String](tagRef, "icon")
    val label = new Attribute["menuitem", scala.Option[String], String](tagRef, "label")
    val radiogroup = new Attribute["menuitem", scala.Option[String], String](tagRef, "radiogroup")
    val `type` = new Attribute["menuitem", scala.Option[String], String](tagRef, "type")
  }

  implicit class MetaExtensions(tag: Tag["meta"]) {
    def charset: scala.Option[String] = tag.attr("charset").asInstanceOf[scala.Option[String]]
    def charset(value: String): Tag["meta"] = tag.setAttr("charset", value)
    def content: scala.Option[String] = tag.attr("content").asInstanceOf[scala.Option[String]]
    def content(value: String): Tag["meta"] = tag.setAttr("content", value)
    def `http-equiv`: scala.Option[String] = tag.attr("http-equiv").asInstanceOf[scala.Option[String]]
    def `http-equiv`(value: String): Tag["meta"] = tag.setAttr("http-equiv", value)
    def name: scala.Option[String] = tag.attr("name").asInstanceOf[scala.Option[String]]
    def name(value: String): Tag["meta"] = tag.setAttr("name", value)
    def scheme: scala.Option[String] = tag.attr("scheme").asInstanceOf[scala.Option[String]]
    def scheme(value: String): Tag["meta"] = tag.setAttr("scheme", value)
  }

  implicit class TagRefAttributesMeta(tagRef: TagRef["meta"]) {
    val charset = new Attribute["meta", scala.Option[String], String](tagRef, "charset")
    val content = new Attribute["meta", scala.Option[String], String](tagRef, "content")
    val `http-equiv` = new Attribute["meta", scala.Option[String], String](tagRef, "http-equiv")
    val name = new Attribute["meta", scala.Option[String], String](tagRef, "name")
    val scheme = new Attribute["meta", scala.Option[String], String](tagRef, "scheme")
  }

  implicit class MeterExtensions(tag: Tag["meter"]) {
    def value: scala.Option[String] = tag.attr("value").asInstanceOf[scala.Option[String]]
    def value(value: String): Tag["meter"] = tag.setAttr("value", value)
    def min: scala.Option[Double] = tag.attr("min").asInstanceOf[scala.Option[Double]]
    def min(value: Double): Tag["meter"] = tag.setAttr("min", value)
    def max: scala.Option[Double] = tag.attr("max").asInstanceOf[scala.Option[Double]]
    def max(value: Double): Tag["meter"] = tag.setAttr("max", value)
    def low: scala.Option[Double] = tag.attr("low").asInstanceOf[scala.Option[Double]]
    def low(value: Double): Tag["meter"] = tag.setAttr("low", value)
    def high: scala.Option[Double] = tag.attr("high").asInstanceOf[scala.Option[Double]]
    def high(value: Double): Tag["meter"] = tag.setAttr("high", value)
    def optimum: scala.Option[Double] = tag.attr("optimum").asInstanceOf[scala.Option[Double]]
    def optimum(value: Double): Tag["meter"] = tag.setAttr("optimum", value)
    def form: scala.Option[String] = tag.attr("form").asInstanceOf[scala.Option[String]]
    def form(value: String): Tag["meter"] = tag.setAttr("form", value)
  }

  implicit class TagRefAttributesMeter(tagRef: TagRef["meter"]) {
    val value = new Attribute["meter", scala.Option[String], String](tagRef, "value")
    val min = new Attribute["meter", scala.Option[Double], Double](tagRef, "min")
    val max = new Attribute["meter", scala.Option[Double], Double](tagRef, "max")
    val low = new Attribute["meter", scala.Option[Double], Double](tagRef, "low")
    val high = new Attribute["meter", scala.Option[Double], Double](tagRef, "high")
    val optimum = new Attribute["meter", scala.Option[Double], Double](tagRef, "optimum")
    val form = new Attribute["meter", scala.Option[String], String](tagRef, "form")
  }

  implicit class ObjectExtensions(tag: Tag["object"]) {
    def archive: scala.Option[String] = tag.attr("archive").asInstanceOf[scala.Option[String]]
    def archive(value: String): Tag["object"] = tag.setAttr("archive", value)
    def border: scala.Option[String] = tag.attr("border").asInstanceOf[scala.Option[String]]
    def border(value: String): Tag["object"] = tag.setAttr("border", value)
    def classid: scala.Option[String] = tag.attr("classid").asInstanceOf[scala.Option[String]]
    def classid(value: String): Tag["object"] = tag.setAttr("classid", value)
    def codebase: scala.Option[String] = tag.attr("codebase").asInstanceOf[scala.Option[String]]
    def codebase(value: String): Tag["object"] = tag.setAttr("codebase", value)
    def codetype: scala.Option[String] = tag.attr("codetype").asInstanceOf[scala.Option[String]]
    def codetype(value: String): Tag["object"] = tag.setAttr("codetype", value)
    def data: scala.Option[String] = tag.attr("data").asInstanceOf[scala.Option[String]]
    def data(value: String): Tag["object"] = tag.setAttr("data", value)
    def declare: scala.Option[String] = tag.attr("declare").asInstanceOf[scala.Option[String]]
    def declare(value: String): Tag["object"] = tag.setAttr("declare", value)
    def form: scala.Option[String] = tag.attr("form").asInstanceOf[scala.Option[String]]
    def form(value: String): Tag["object"] = tag.setAttr("form", value)
    def height: scala.Option[String] = tag.attr("height").asInstanceOf[scala.Option[String]]
    def height(value: String): Tag["object"] = tag.setAttr("height", value)
    def name: scala.Option[String] = tag.attr("name").asInstanceOf[scala.Option[String]]
    def name(value: String): Tag["object"] = tag.setAttr("name", value)
    def standby: scala.Option[String] = tag.attr("standby").asInstanceOf[scala.Option[String]]
    def standby(value: String): Tag["object"] = tag.setAttr("standby", value)
    def `type`: scala.Option[String] = tag.attr("type").asInstanceOf[scala.Option[String]]
    def `type`(value: String): Tag["object"] = tag.setAttr("type", value)
    def typemustmatch: scala.Option[String] = tag.attr("typemustmatch").asInstanceOf[scala.Option[String]]
    def typemustmatch(value: String): Tag["object"] = tag.setAttr("typemustmatch", value)
    def usemap: scala.Option[String] = tag.attr("usemap").asInstanceOf[scala.Option[String]]
    def usemap(value: String): Tag["object"] = tag.setAttr("usemap", value)
    def width: scala.Option[String] = tag.attr("width").asInstanceOf[scala.Option[String]]
    def width(value: String): Tag["object"] = tag.setAttr("width", value)
  }

  implicit class TagRefAttributesObject(tagRef: TagRef["object"]) {
    val archive = new Attribute["object", scala.Option[String], String](tagRef, "archive")
    val border = new Attribute["object", scala.Option[String], String](tagRef, "border")
    val classid = new Attribute["object", scala.Option[String], String](tagRef, "classid")
    val codebase = new Attribute["object", scala.Option[String], String](tagRef, "codebase")
    val codetype = new Attribute["object", scala.Option[String], String](tagRef, "codetype")
    val data = new Attribute["object", scala.Option[String], String](tagRef, "data")
    val declare = new Attribute["object", scala.Option[String], String](tagRef, "declare")
    val form = new Attribute["object", scala.Option[String], String](tagRef, "form")
    val height = new Attribute["object", scala.Option[String], String](tagRef, "height")
    val name = new Attribute["object", scala.Option[String], String](tagRef, "name")
    val standby = new Attribute["object", scala.Option[String], String](tagRef, "standby")
    val tabindex = new Attribute["object", scala.Option[String], String](tagRef, "tabindex")
    val `type` = new Attribute["object", scala.Option[String], String](tagRef, "type")
    val typemustmatch = new Attribute["object", scala.Option[String], String](tagRef, "typemustmatch")
    val usemap = new Attribute["object", scala.Option[String], String](tagRef, "usemap")
    val width = new Attribute["object", scala.Option[String], String](tagRef, "width")
  }

  implicit class OlExtensions(tag: Tag["ol"]) {
    def compact: scala.Option[String] = tag.attr("compact").asInstanceOf[scala.Option[String]]
    def compact(value: String): Tag["ol"] = tag.setAttr("compact", value)
    def reversed: scala.Option[String] = tag.attr("reversed").asInstanceOf[scala.Option[String]]
    def reversed(value: String): Tag["ol"] = tag.setAttr("reversed", value)
    def start: scala.Option[String] = tag.attr("start").asInstanceOf[scala.Option[String]]
    def start(value: String): Tag["ol"] = tag.setAttr("start", value)
    def `type`: scala.Option[String] = tag.attr("type").asInstanceOf[scala.Option[String]]
    def `type`(value: String): Tag["ol"] = tag.setAttr("type", value)
  }

  implicit class TagRefAttributesOl(tagRef: TagRef["ol"]) {
    val compact = new Attribute["ol", scala.Option[String], String](tagRef, "compact")
    val reversed = new Attribute["ol", scala.Option[String], String](tagRef, "reversed")
    val start = new Attribute["ol", scala.Option[String], String](tagRef, "start")
    val `type` = new Attribute["ol", scala.Option[String], String](tagRef, "type")
  }

  implicit class OptgroupExtensions(tag: Tag["optgroup"]) {
    def disabled: Boolean = tag.attributes.contains("disabled")
    def disabled(value: Boolean): Tag["optgroup"] = (if (value) tag.setAttr("disabled", "") else tag.remAttr("disabled"))
    def label: scala.Option[String] = tag.attr("label").asInstanceOf[scala.Option[String]]
    def label(value: String): Tag["optgroup"] = tag.setAttr("label", value)
  }

  implicit class TagRefAttributesOptgroup(tagRef: TagRef["optgroup"]) {
    val disabled = new Attribute["optgroup", Boolean, Boolean](tagRef, "disabled")
    val label = new Attribute["optgroup", scala.Option[String], String](tagRef, "label")
  }

  implicit class OptionExtensions(tag: Tag["option"]) {
    def disabled: scala.Option[String] = tag.attr("disabled").asInstanceOf[scala.Option[String]]
    def disabled(value: String): Tag["option"] = tag.setAttr("disabled", value)
    def label: scala.Option[String] = tag.attr("label").asInstanceOf[scala.Option[String]]
    def label(value: String): Tag["option"] = tag.setAttr("label", value)
    def selected: scala.Option[String] = tag.attr("selected").asInstanceOf[scala.Option[String]]
    def selected(value: String): Tag["option"] = tag.setAttr("selected", value)
    def value: scala.Option[String] = tag.attr("value").asInstanceOf[scala.Option[String]]
    def value(value: String): Tag["option"] = tag.setAttr("value", value)
  }

  implicit class TagRefAttributesOption(tagRef: TagRef["option"]) {
    val disabled = new Attribute["option", scala.Option[String], String](tagRef, "disabled")
    val label = new Attribute["option", scala.Option[String], String](tagRef, "label")
    val selected = new Attribute["option", scala.Option[String], String](tagRef, "selected")
    val value = new Attribute["option", scala.Option[String], String](tagRef, "value")
  }

  implicit class OutputExtensions(tag: Tag["output"]) {
    def `for`: scala.Option[String] = tag.attr("for").asInstanceOf[scala.Option[String]]
    def `for`(value: String): Tag["output"] = tag.setAttr("for", value)
    def form: scala.Option[String] = tag.attr("form").asInstanceOf[scala.Option[String]]
    def form(value: String): Tag["output"] = tag.setAttr("form", value)
    def name: scala.Option[String] = tag.attr("name").asInstanceOf[scala.Option[String]]
    def name(value: String): Tag["output"] = tag.setAttr("name", value)
  }

  implicit class TagRefAttributesOutput(tagRef: TagRef["output"]) {
    val `for` = new Attribute["output", scala.Option[String], String](tagRef, "for")
    val form = new Attribute["output", scala.Option[String], String](tagRef, "form")
    val name = new Attribute["output", scala.Option[String], String](tagRef, "name")
  }

  implicit class ParamExtensions(tag: Tag["param"]) {
    def name: scala.Option[String] = tag.attr("name").asInstanceOf[scala.Option[String]]
    def name(value: String): Tag["param"] = tag.setAttr("name", value)
    def `type`: scala.Option[String] = tag.attr("type").asInstanceOf[scala.Option[String]]
    def `type`(value: String): Tag["param"] = tag.setAttr("type", value)
    def value: scala.Option[String] = tag.attr("value").asInstanceOf[scala.Option[String]]
    def value(value: String): Tag["param"] = tag.setAttr("value", value)
    def valuetype: scala.Option[String] = tag.attr("valuetype").asInstanceOf[scala.Option[String]]
    def valuetype(value: String): Tag["param"] = tag.setAttr("valuetype", value)
  }

  implicit class TagRefAttributesParam(tagRef: TagRef["param"]) {
    val name = new Attribute["param", scala.Option[String], String](tagRef, "name")
    val `type` = new Attribute["param", scala.Option[String], String](tagRef, "type")
    val value = new Attribute["param", scala.Option[String], String](tagRef, "value")
    val valuetype = new Attribute["param", scala.Option[String], String](tagRef, "valuetype")
  }

  implicit class PreExtensions(tag: Tag["pre"]) {
    def cols: scala.Option[String] = tag.attr("cols").asInstanceOf[scala.Option[String]]
    def cols(value: String): Tag["pre"] = tag.setAttr("cols", value)
    def width: scala.Option[String] = tag.attr("width").asInstanceOf[scala.Option[String]]
    def width(value: String): Tag["pre"] = tag.setAttr("width", value)
    def wrap: scala.Option[String] = tag.attr("wrap").asInstanceOf[scala.Option[String]]
    def wrap(value: String): Tag["pre"] = tag.setAttr("wrap", value)
  }

  implicit class TagRefAttributesPre(tagRef: TagRef["pre"]) {
    val cols = new Attribute["pre", scala.Option[String], String](tagRef, "cols")
    val width = new Attribute["pre", scala.Option[String], String](tagRef, "width")
    val wrap = new Attribute["pre", scala.Option[String], String](tagRef, "wrap")
  }

  implicit class ProgressExtensions(tag: Tag["progress"]) {
    def max: scala.Option[String] = tag.attr("max").asInstanceOf[scala.Option[String]]
    def max(value: String): Tag["progress"] = tag.setAttr("max", value)
    def value: scala.Option[String] = tag.attr("value").asInstanceOf[scala.Option[String]]
    def value(value: String): Tag["progress"] = tag.setAttr("value", value)
  }

  implicit class TagRefAttributesProgress(tagRef: TagRef["progress"]) {
    val max = new Attribute["progress", scala.Option[String], String](tagRef, "max")
    val value = new Attribute["progress", scala.Option[String], String](tagRef, "value")
  }

  implicit class ScriptExtensions(tag: Tag["script"]) {
    def async: scala.Option[String] = tag.attr("async").asInstanceOf[scala.Option[String]]
    def async(value: String): Tag["script"] = tag.setAttr("async", value)
    def src: scala.Option[String] = tag.attr("src").asInstanceOf[scala.Option[String]]
    def src(value: String): Tag["script"] = tag.setAttr("src", value)
    def `type`: scala.Option[String] = tag.attr("type").asInstanceOf[scala.Option[String]]
    def `type`(value: String): Tag["script"] = tag.setAttr("type", value)
    def language: scala.Option[String] = tag.attr("language").asInstanceOf[scala.Option[String]]
    def language(value: String): Tag["script"] = tag.setAttr("language", value)
    def defer: scala.Option[String] = tag.attr("defer").asInstanceOf[scala.Option[String]]
    def defer(value: String): Tag["script"] = tag.setAttr("defer", value)
    def crossorigin: scala.Option[String] = tag.attr("crossorigin").asInstanceOf[scala.Option[String]]
    def crossorigin(value: String): Tag["script"] = tag.setAttr("crossorigin", value)
    def integrity: scala.Option[String] = tag.attr("integrity").asInstanceOf[scala.Option[String]]
    def integrity(value: String): Tag["script"] = tag.setAttr("integrity", value)
  }

  implicit class TagRefAttributesScript(tagRef: TagRef["script"]) {
    val async = new Attribute["script", scala.Option[String], String](tagRef, "async")
    val src = new Attribute["script", scala.Option[String], String](tagRef, "src")
    val `type` = new Attribute["script", scala.Option[String], String](tagRef, "type")
    val language = new Attribute["script", scala.Option[String], String](tagRef, "language")
    val defer = new Attribute["script", scala.Option[String], String](tagRef, "defer")
    val crossorigin = new Attribute["script", scala.Option[String], String](tagRef, "crossorigin")
    val integrity = new Attribute["script", scala.Option[String], String](tagRef, "integrity")
  }

  implicit class SelectExtensions(tag: Tag["select"]) {
    def autofocus: scala.Option[String] = tag.attr("autofocus").asInstanceOf[scala.Option[String]]
    def autofocus(value: String): Tag["select"] = tag.setAttr("autofocus", value)
    def disabled: scala.Option[String] = tag.attr("disabled").asInstanceOf[scala.Option[String]]
    def disabled(value: String): Tag["select"] = tag.setAttr("disabled", value)
    def form: scala.Option[String] = tag.attr("form").asInstanceOf[scala.Option[String]]
    def form(value: String): Tag["select"] = tag.setAttr("form", value)
    def multiple: scala.Option[String] = tag.attr("multiple").asInstanceOf[scala.Option[String]]
    def multiple(value: String): Tag["select"] = tag.setAttr("multiple", value)
    def name: scala.Option[String] = tag.attr("name").asInstanceOf[scala.Option[String]]
    def name(value: String): Tag["select"] = tag.setAttr("name", value)
    def required: scala.Option[String] = tag.attr("required").asInstanceOf[scala.Option[String]]
    def required(value: String): Tag["select"] = tag.setAttr("required", value)
    def size: scala.Option[String] = tag.attr("size").asInstanceOf[scala.Option[String]]
    def size(value: String): Tag["select"] = tag.setAttr("size", value)
  }

  implicit class TagRefAttributesSelect(tagRef: TagRef["select"]) {
    val autofocus = new Attribute["select", scala.Option[String], String](tagRef, "autofocus")
    val disabled = new Attribute["select", scala.Option[String], String](tagRef, "disabled")
    val form = new Attribute["select", scala.Option[String], String](tagRef, "form")
    val multiple = new Attribute["select", scala.Option[String], String](tagRef, "multiple")
    val name = new Attribute["select", scala.Option[String], String](tagRef, "name")
    val required = new Attribute["select", scala.Option[String], String](tagRef, "required")
    val size = new Attribute["select", scala.Option[String], String](tagRef, "size")
  }

  implicit class SourceExtensions(tag: Tag["source"]) {
    def sizes: scala.Option[String] = tag.attr("sizes").asInstanceOf[scala.Option[String]]
    def sizes(value: String): Tag["source"] = tag.setAttr("sizes", value)
    def src: scala.Option[String] = tag.attr("src").asInstanceOf[scala.Option[String]]
    def src(value: String): Tag["source"] = tag.setAttr("src", value)
    def srcset: scala.Option[String] = tag.attr("srcset").asInstanceOf[scala.Option[String]]
    def srcset(value: String): Tag["source"] = tag.setAttr("srcset", value)
    def `type`: scala.Option[String] = tag.attr("type").asInstanceOf[scala.Option[String]]
    def `type`(value: String): Tag["source"] = tag.setAttr("type", value)
    def media: scala.Option[String] = tag.attr("media").asInstanceOf[scala.Option[String]]
    def media(value: String): Tag["source"] = tag.setAttr("media", value)
  }

  implicit class TagRefAttributesSource(tagRef: TagRef["source"]) {
    val sizes = new Attribute["source", scala.Option[String], String](tagRef, "sizes")
    val src = new Attribute["source", scala.Option[String], String](tagRef, "src")
    val srcset = new Attribute["source", scala.Option[String], String](tagRef, "srcset")
    val `type` = new Attribute["source", scala.Option[String], String](tagRef, "type")
    val media = new Attribute["source", scala.Option[String], String](tagRef, "media")
  }

  implicit class SpacerExtensions(tag: Tag["spacer"]) {
    def `type`: scala.Option[String] = tag.attr("type").asInstanceOf[scala.Option[String]]
    def `type`(value: String): Tag["spacer"] = tag.setAttr("type", value)
    def size: scala.Option[String] = tag.attr("size").asInstanceOf[scala.Option[String]]
    def size(value: String): Tag["spacer"] = tag.setAttr("size", value)
    def width: scala.Option[String] = tag.attr("width").asInstanceOf[scala.Option[String]]
    def width(value: String): Tag["spacer"] = tag.setAttr("width", value)
    def height: scala.Option[String] = tag.attr("height").asInstanceOf[scala.Option[String]]
    def height(value: String): Tag["spacer"] = tag.setAttr("height", value)
    def align: scala.Option[String] = tag.attr("align").asInstanceOf[scala.Option[String]]
    def align(value: String): Tag["spacer"] = tag.setAttr("align", value)
  }

  implicit class TagRefAttributesSpacer(tagRef: TagRef["spacer"]) {
    val `type` = new Attribute["spacer", scala.Option[String], String](tagRef, "type")
    val size = new Attribute["spacer", scala.Option[String], String](tagRef, "size")
    val width = new Attribute["spacer", scala.Option[String], String](tagRef, "width")
    val height = new Attribute["spacer", scala.Option[String], String](tagRef, "height")
    val align = new Attribute["spacer", scala.Option[String], String](tagRef, "align")
  }

  implicit class StyleExtensions(tag: Tag["style"]) {
    def `type`: scala.Option[String] = tag.attr("type").asInstanceOf[scala.Option[String]]
    def `type`(value: String): Tag["style"] = tag.setAttr("type", value)
    def media: scala.Option[String] = tag.attr("media").asInstanceOf[scala.Option[String]]
    def media(value: String): Tag["style"] = tag.setAttr("media", value)
    def scoped: scala.Option[String] = tag.attr("scoped").asInstanceOf[scala.Option[String]]
    def scoped(value: String): Tag["style"] = tag.setAttr("scoped", value)
    def disabled: scala.Option[String] = tag.attr("disabled").asInstanceOf[scala.Option[String]]
    def disabled(value: String): Tag["style"] = tag.setAttr("disabled", value)
  }

  implicit class TagRefAttributesStyle(tagRef: TagRef["style"]) {
    val `type` = new Attribute["style", scala.Option[String], String](tagRef, "type")
    val media = new Attribute["style", scala.Option[String], String](tagRef, "media")
    val scoped = new Attribute["style", scala.Option[String], String](tagRef, "scoped")
    val title = new Attribute["style", scala.Option[String], String](tagRef, "title")
    val disabled = new Attribute["style", scala.Option[String], String](tagRef, "disabled")
  }

  implicit class TableExtensions(tag: Tag["table"]) {
    def align: scala.Option[String] = tag.attr("align").asInstanceOf[scala.Option[String]]
    def align(value: String): Tag["table"] = tag.setAttr("align", value)
    def bgcolor: scala.Option[String] = tag.attr("bgcolor").asInstanceOf[scala.Option[String]]
    def bgcolor(value: String): Tag["table"] = tag.setAttr("bgcolor", value)
    def border: scala.Option[String] = tag.attr("border").asInstanceOf[scala.Option[String]]
    def border(value: String): Tag["table"] = tag.setAttr("border", value)
    def cellpadding: scala.Option[String] = tag.attr("cellpadding").asInstanceOf[scala.Option[String]]
    def cellpadding(value: String): Tag["table"] = tag.setAttr("cellpadding", value)
    def cellspacing: scala.Option[String] = tag.attr("cellspacing").asInstanceOf[scala.Option[String]]
    def cellspacing(value: String): Tag["table"] = tag.setAttr("cellspacing", value)
    def frame: scala.Option[String] = tag.attr("frame").asInstanceOf[scala.Option[String]]
    def frame(value: String): Tag["table"] = tag.setAttr("frame", value)
    def rules: scala.Option[String] = tag.attr("rules").asInstanceOf[scala.Option[String]]
    def rules(value: String): Tag["table"] = tag.setAttr("rules", value)
    def summary: scala.Option[String] = tag.attr("summary").asInstanceOf[scala.Option[String]]
    def summary(value: String): Tag["table"] = tag.setAttr("summary", value)
    def width: scala.Option[String] = tag.attr("width").asInstanceOf[scala.Option[String]]
    def width(value: String): Tag["table"] = tag.setAttr("width", value)
  }

  implicit class TagRefAttributesTable(tagRef: TagRef["table"]) {
    val align = new Attribute["table", scala.Option[String], String](tagRef, "align")
    val bgcolor = new Attribute["table", scala.Option[String], String](tagRef, "bgcolor")
    val border = new Attribute["table", scala.Option[String], String](tagRef, "border")
    val cellpadding = new Attribute["table", scala.Option[String], String](tagRef, "cellpadding")
    val cellspacing = new Attribute["table", scala.Option[String], String](tagRef, "cellspacing")
    val frame = new Attribute["table", scala.Option[String], String](tagRef, "frame")
    val rules = new Attribute["table", scala.Option[String], String](tagRef, "rules")
    val summary = new Attribute["table", scala.Option[String], String](tagRef, "summary")
    val width = new Attribute["table", scala.Option[String], String](tagRef, "width")
  }

  implicit class TbodyExtensions(tag: Tag["tbody"]) {
    def align: scala.Option[String] = tag.attr("align").asInstanceOf[scala.Option[String]]
    def align(value: String): Tag["tbody"] = tag.setAttr("align", value)
    def bgcolor: scala.Option[String] = tag.attr("bgcolor").asInstanceOf[scala.Option[String]]
    def bgcolor(value: String): Tag["tbody"] = tag.setAttr("bgcolor", value)
    def char: scala.Option[String] = tag.attr("char").asInstanceOf[scala.Option[String]]
    def char(value: String): Tag["tbody"] = tag.setAttr("char", value)
    def charoff: scala.Option[String] = tag.attr("charoff").asInstanceOf[scala.Option[String]]
    def charoff(value: String): Tag["tbody"] = tag.setAttr("charoff", value)
    def valign: scala.Option[String] = tag.attr("valign").asInstanceOf[scala.Option[String]]
    def valign(value: String): Tag["tbody"] = tag.setAttr("valign", value)
  }

  implicit class TagRefAttributesTbody(tagRef: TagRef["tbody"]) {
    val align = new Attribute["tbody", scala.Option[String], String](tagRef, "align")
    val bgcolor = new Attribute["tbody", scala.Option[String], String](tagRef, "bgcolor")
    val char = new Attribute["tbody", scala.Option[String], String](tagRef, "char")
    val charoff = new Attribute["tbody", scala.Option[String], String](tagRef, "charoff")
    val valign = new Attribute["tbody", scala.Option[String], String](tagRef, "valign")
  }

  implicit class TdExtensions(tag: Tag["td"]) {
    def abbr: scala.Option[String] = tag.attr("abbr").asInstanceOf[scala.Option[String]]
    def abbr(value: String): Tag["td"] = tag.setAttr("abbr", value)
    def align: scala.Option[String] = tag.attr("align").asInstanceOf[scala.Option[String]]
    def align(value: String): Tag["td"] = tag.setAttr("align", value)
    def axis: scala.Option[String] = tag.attr("axis").asInstanceOf[scala.Option[String]]
    def axis(value: String): Tag["td"] = tag.setAttr("axis", value)
    def bgcolor: scala.Option[String] = tag.attr("bgcolor").asInstanceOf[scala.Option[String]]
    def bgcolor(value: String): Tag["td"] = tag.setAttr("bgcolor", value)
    def char: scala.Option[String] = tag.attr("char").asInstanceOf[scala.Option[String]]
    def char(value: String): Tag["td"] = tag.setAttr("char", value)
    def charoff: scala.Option[String] = tag.attr("charoff").asInstanceOf[scala.Option[String]]
    def charoff(value: String): Tag["td"] = tag.setAttr("charoff", value)
    def colspan: scala.Option[String] = tag.attr("colspan").asInstanceOf[scala.Option[String]]
    def colspan(value: String): Tag["td"] = tag.setAttr("colspan", value)
    def headers: scala.Option[String] = tag.attr("headers").asInstanceOf[scala.Option[String]]
    def headers(value: String): Tag["td"] = tag.setAttr("headers", value)
    def rowspan: scala.Option[String] = tag.attr("rowspan").asInstanceOf[scala.Option[String]]
    def rowspan(value: String): Tag["td"] = tag.setAttr("rowspan", value)
    def scope: scala.Option[String] = tag.attr("scope").asInstanceOf[scala.Option[String]]
    def scope(value: String): Tag["td"] = tag.setAttr("scope", value)
    def valign: scala.Option[String] = tag.attr("valign").asInstanceOf[scala.Option[String]]
    def valign(value: String): Tag["td"] = tag.setAttr("valign", value)
    def width: scala.Option[String] = tag.attr("width").asInstanceOf[scala.Option[String]]
    def width(value: String): Tag["td"] = tag.setAttr("width", value)
  }

  implicit class TagRefAttributesTd(tagRef: TagRef["td"]) {
    val abbr = new Attribute["td", scala.Option[String], String](tagRef, "abbr")
    val align = new Attribute["td", scala.Option[String], String](tagRef, "align")
    val axis = new Attribute["td", scala.Option[String], String](tagRef, "axis")
    val bgcolor = new Attribute["td", scala.Option[String], String](tagRef, "bgcolor")
    val char = new Attribute["td", scala.Option[String], String](tagRef, "char")
    val charoff = new Attribute["td", scala.Option[String], String](tagRef, "charoff")
    val colspan = new Attribute["td", scala.Option[String], String](tagRef, "colspan")
    val headers = new Attribute["td", scala.Option[String], String](tagRef, "headers")
    val rowspan = new Attribute["td", scala.Option[String], String](tagRef, "rowspan")
    val scope = new Attribute["td", scala.Option[String], String](tagRef, "scope")
    val valign = new Attribute["td", scala.Option[String], String](tagRef, "valign")
    val width = new Attribute["td", scala.Option[String], String](tagRef, "width")
  }

  implicit class TextareaExtensions(tag: Tag["textarea"]) {
    def autocapitalize: scala.Option[String] = tag.attr("autocapitalize").asInstanceOf[scala.Option[String]]
    def autocapitalize(value: String): Tag["textarea"] = tag.setAttr("autocapitalize", value)
    def autocomplete: scala.Option[String] = tag.attr("autocomplete").asInstanceOf[scala.Option[String]]
    def autocomplete(value: String): Tag["textarea"] = tag.setAttr("autocomplete", value)
    def autofocus: scala.Option[String] = tag.attr("autofocus").asInstanceOf[scala.Option[String]]
    def autofocus(value: String): Tag["textarea"] = tag.setAttr("autofocus", value)
    def cols: scala.Option[String] = tag.attr("cols").asInstanceOf[scala.Option[String]]
    def cols(value: String): Tag["textarea"] = tag.setAttr("cols", value)
    def disabled: scala.Option[String] = tag.attr("disabled").asInstanceOf[scala.Option[String]]
    def disabled(value: String): Tag["textarea"] = tag.setAttr("disabled", value)
    def form: scala.Option[String] = tag.attr("form").asInstanceOf[scala.Option[String]]
    def form(value: String): Tag["textarea"] = tag.setAttr("form", value)
    def maxlength: scala.Option[String] = tag.attr("maxlength").asInstanceOf[scala.Option[String]]
    def maxlength(value: String): Tag["textarea"] = tag.setAttr("maxlength", value)
    def minlength: scala.Option[String] = tag.attr("minlength").asInstanceOf[scala.Option[String]]
    def minlength(value: String): Tag["textarea"] = tag.setAttr("minlength", value)
    def name: scala.Option[String] = tag.attr("name").asInstanceOf[scala.Option[String]]
    def name(value: String): Tag["textarea"] = tag.setAttr("name", value)
    def placeholder: scala.Option[String] = tag.attr("placeholder").asInstanceOf[scala.Option[String]]
    def placeholder(value: String): Tag["textarea"] = tag.setAttr("placeholder", value)
    def readonly: scala.Option[String] = tag.attr("readonly").asInstanceOf[scala.Option[String]]
    def readonly(value: String): Tag["textarea"] = tag.setAttr("readonly", value)
    def required: scala.Option[String] = tag.attr("required").asInstanceOf[scala.Option[String]]
    def required(value: String): Tag["textarea"] = tag.setAttr("required", value)
    def rows: scala.Option[String] = tag.attr("rows").asInstanceOf[scala.Option[String]]
    def rows(value: String): Tag["textarea"] = tag.setAttr("rows", value)
    def selectionDirection: scala.Option[String] = tag.attr("selectionDirection").asInstanceOf[scala.Option[String]]
    def selectionDirection(value: String): Tag["textarea"] = tag.setAttr("selectionDirection", value)
    def selectionEnd: scala.Option[String] = tag.attr("selectionEnd").asInstanceOf[scala.Option[String]]
    def selectionEnd(value: String): Tag["textarea"] = tag.setAttr("selectionEnd", value)
    def selectionStart: scala.Option[String] = tag.attr("selectionStart").asInstanceOf[scala.Option[String]]
    def selectionStart(value: String): Tag["textarea"] = tag.setAttr("selectionStart", value)
    def wrap: scala.Option[String] = tag.attr("wrap").asInstanceOf[scala.Option[String]]
    def wrap(value: String): Tag["textarea"] = tag.setAttr("wrap", value)
  }

  implicit class TagRefAttributesTextarea(tagRef: TagRef["textarea"]) {
    val autocapitalize = new Attribute["textarea", scala.Option[String], String](tagRef, "autocapitalize")
    val autocomplete = new Attribute["textarea", scala.Option[String], String](tagRef, "autocomplete")
    val autofocus = new Attribute["textarea", scala.Option[String], String](tagRef, "autofocus")
    val cols = new Attribute["textarea", scala.Option[String], String](tagRef, "cols")
    val disabled = new Attribute["textarea", scala.Option[String], String](tagRef, "disabled")
    val form = new Attribute["textarea", scala.Option[String], String](tagRef, "form")
    val maxlength = new Attribute["textarea", scala.Option[String], String](tagRef, "maxlength")
    val minlength = new Attribute["textarea", scala.Option[String], String](tagRef, "minlength")
    val name = new Attribute["textarea", scala.Option[String], String](tagRef, "name")
    val placeholder = new Attribute["textarea", scala.Option[String], String](tagRef, "placeholder")
    val readonly = new Attribute["textarea", scala.Option[String], String](tagRef, "readonly")
    val required = new Attribute["textarea", scala.Option[String], String](tagRef, "required")
    val rows = new Attribute["textarea", scala.Option[String], String](tagRef, "rows")
    val selectionDirection = new Attribute["textarea", scala.Option[String], String](tagRef, "selectionDirection")
    val selectionEnd = new Attribute["textarea", scala.Option[String], String](tagRef, "selectionEnd")
    val selectionStart = new Attribute["textarea", scala.Option[String], String](tagRef, "selectionStart")
    val spellcheck = new Attribute["textarea", scala.Option[String], String](tagRef, "spellcheck")
    val wrap = new Attribute["textarea", scala.Option[String], String](tagRef, "wrap")
  }

  implicit class TfootExtensions(tag: Tag["tfoot"]) {
    def align: scala.Option[String] = tag.attr("align").asInstanceOf[scala.Option[String]]
    def align(value: String): Tag["tfoot"] = tag.setAttr("align", value)
    def bgcolor: scala.Option[String] = tag.attr("bgcolor").asInstanceOf[scala.Option[String]]
    def bgcolor(value: String): Tag["tfoot"] = tag.setAttr("bgcolor", value)
    def char: scala.Option[String] = tag.attr("char").asInstanceOf[scala.Option[String]]
    def char(value: String): Tag["tfoot"] = tag.setAttr("char", value)
    def charoff: scala.Option[String] = tag.attr("charoff").asInstanceOf[scala.Option[String]]
    def charoff(value: String): Tag["tfoot"] = tag.setAttr("charoff", value)
    def valign: scala.Option[String] = tag.attr("valign").asInstanceOf[scala.Option[String]]
    def valign(value: String): Tag["tfoot"] = tag.setAttr("valign", value)
  }

  implicit class TagRefAttributesTfoot(tagRef: TagRef["tfoot"]) {
    val align = new Attribute["tfoot", scala.Option[String], String](tagRef, "align")
    val bgcolor = new Attribute["tfoot", scala.Option[String], String](tagRef, "bgcolor")
    val char = new Attribute["tfoot", scala.Option[String], String](tagRef, "char")
    val charoff = new Attribute["tfoot", scala.Option[String], String](tagRef, "charoff")
    val valign = new Attribute["tfoot", scala.Option[String], String](tagRef, "valign")
  }

  implicit class ThExtensions(tag: Tag["th"]) {
    def abbr: scala.Option[String] = tag.attr("abbr").asInstanceOf[scala.Option[String]]
    def abbr(value: String): Tag["th"] = tag.setAttr("abbr", value)
    def align: scala.Option[String] = tag.attr("align").asInstanceOf[scala.Option[String]]
    def align(value: String): Tag["th"] = tag.setAttr("align", value)
    def axis: scala.Option[String] = tag.attr("axis").asInstanceOf[scala.Option[String]]
    def axis(value: String): Tag["th"] = tag.setAttr("axis", value)
    def bgcolor: scala.Option[String] = tag.attr("bgcolor").asInstanceOf[scala.Option[String]]
    def bgcolor(value: String): Tag["th"] = tag.setAttr("bgcolor", value)
    def char: scala.Option[String] = tag.attr("char").asInstanceOf[scala.Option[String]]
    def char(value: String): Tag["th"] = tag.setAttr("char", value)
    def charoff: scala.Option[String] = tag.attr("charoff").asInstanceOf[scala.Option[String]]
    def charoff(value: String): Tag["th"] = tag.setAttr("charoff", value)
    def colspan: scala.Option[String] = tag.attr("colspan").asInstanceOf[scala.Option[String]]
    def colspan(value: String): Tag["th"] = tag.setAttr("colspan", value)
    def headers: scala.Option[String] = tag.attr("headers").asInstanceOf[scala.Option[String]]
    def headers(value: String): Tag["th"] = tag.setAttr("headers", value)
    def rowspan: scala.Option[String] = tag.attr("rowspan").asInstanceOf[scala.Option[String]]
    def rowspan(value: String): Tag["th"] = tag.setAttr("rowspan", value)
    def scope: scala.Option[String] = tag.attr("scope").asInstanceOf[scala.Option[String]]
    def scope(value: String): Tag["th"] = tag.setAttr("scope", value)
    def valign: scala.Option[String] = tag.attr("valign").asInstanceOf[scala.Option[String]]
    def valign(value: String): Tag["th"] = tag.setAttr("valign", value)
    def width: scala.Option[String] = tag.attr("width").asInstanceOf[scala.Option[String]]
    def width(value: String): Tag["th"] = tag.setAttr("width", value)
  }

  implicit class TagRefAttributesTh(tagRef: TagRef["th"]) {
    val abbr = new Attribute["th", scala.Option[String], String](tagRef, "abbr")
    val align = new Attribute["th", scala.Option[String], String](tagRef, "align")
    val axis = new Attribute["th", scala.Option[String], String](tagRef, "axis")
    val bgcolor = new Attribute["th", scala.Option[String], String](tagRef, "bgcolor")
    val char = new Attribute["th", scala.Option[String], String](tagRef, "char")
    val charoff = new Attribute["th", scala.Option[String], String](tagRef, "charoff")
    val colspan = new Attribute["th", scala.Option[String], String](tagRef, "colspan")
    val headers = new Attribute["th", scala.Option[String], String](tagRef, "headers")
    val rowspan = new Attribute["th", scala.Option[String], String](tagRef, "rowspan")
    val scope = new Attribute["th", scala.Option[String], String](tagRef, "scope")
    val valign = new Attribute["th", scala.Option[String], String](tagRef, "valign")
    val width = new Attribute["th", scala.Option[String], String](tagRef, "width")
  }

  implicit class TheadExtensions(tag: Tag["thead"]) {
    def align: scala.Option[String] = tag.attr("align").asInstanceOf[scala.Option[String]]
    def align(value: String): Tag["thead"] = tag.setAttr("align", value)
    def bgcolor: scala.Option[String] = tag.attr("bgcolor").asInstanceOf[scala.Option[String]]
    def bgcolor(value: String): Tag["thead"] = tag.setAttr("bgcolor", value)
    def char: scala.Option[String] = tag.attr("char").asInstanceOf[scala.Option[String]]
    def char(value: String): Tag["thead"] = tag.setAttr("char", value)
    def charoff: scala.Option[String] = tag.attr("charoff").asInstanceOf[scala.Option[String]]
    def charoff(value: String): Tag["thead"] = tag.setAttr("charoff", value)
    def valign: scala.Option[String] = tag.attr("valign").asInstanceOf[scala.Option[String]]
    def valign(value: String): Tag["thead"] = tag.setAttr("valign", value)
  }

  implicit class TagRefAttributesThead(tagRef: TagRef["thead"]) {
    val align = new Attribute["thead", scala.Option[String], String](tagRef, "align")
    val bgcolor = new Attribute["thead", scala.Option[String], String](tagRef, "bgcolor")
    val char = new Attribute["thead", scala.Option[String], String](tagRef, "char")
    val charoff = new Attribute["thead", scala.Option[String], String](tagRef, "charoff")
    val valign = new Attribute["thead", scala.Option[String], String](tagRef, "valign")
  }

  implicit class TrExtensions(tag: Tag["tr"]) {
    def align: scala.Option[String] = tag.attr("align").asInstanceOf[scala.Option[String]]
    def align(value: String): Tag["tr"] = tag.setAttr("align", value)
    def bgcolor: scala.Option[String] = tag.attr("bgcolor").asInstanceOf[scala.Option[String]]
    def bgcolor(value: String): Tag["tr"] = tag.setAttr("bgcolor", value)
    def char: scala.Option[String] = tag.attr("char").asInstanceOf[scala.Option[String]]
    def char(value: String): Tag["tr"] = tag.setAttr("char", value)
    def charoff: scala.Option[String] = tag.attr("charoff").asInstanceOf[scala.Option[String]]
    def charoff(value: String): Tag["tr"] = tag.setAttr("charoff", value)
    def valign: scala.Option[String] = tag.attr("valign").asInstanceOf[scala.Option[String]]
    def valign(value: String): Tag["tr"] = tag.setAttr("valign", value)
  }

  implicit class TagRefAttributesTr(tagRef: TagRef["tr"]) {
    val align = new Attribute["tr", scala.Option[String], String](tagRef, "align")
    val bgcolor = new Attribute["tr", scala.Option[String], String](tagRef, "bgcolor")
    val char = new Attribute["tr", scala.Option[String], String](tagRef, "char")
    val charoff = new Attribute["tr", scala.Option[String], String](tagRef, "charoff")
    val valign = new Attribute["tr", scala.Option[String], String](tagRef, "valign")
  }

  implicit class TrackExtensions(tag: Tag["track"]) {
    def default: scala.Option[String] = tag.attr("default").asInstanceOf[scala.Option[String]]
    def default(value: String): Tag["track"] = tag.setAttr("default", value)
    def kind: scala.Option[String] = tag.attr("kind").asInstanceOf[scala.Option[String]]
    def kind(value: String): Tag["track"] = tag.setAttr("kind", value)
    def label: scala.Option[String] = tag.attr("label").asInstanceOf[scala.Option[String]]
    def label(value: String): Tag["track"] = tag.setAttr("label", value)
    def src: scala.Option[String] = tag.attr("src").asInstanceOf[scala.Option[String]]
    def src(value: String): Tag["track"] = tag.setAttr("src", value)
    def srclang: scala.Option[String] = tag.attr("srclang").asInstanceOf[scala.Option[String]]
    def srclang(value: String): Tag["track"] = tag.setAttr("srclang", value)
  }

  implicit class TagRefAttributesTrack(tagRef: TagRef["track"]) {
    val default = new Attribute["track", scala.Option[String], String](tagRef, "default")
    val kind = new Attribute["track", scala.Option[String], String](tagRef, "kind")
    val label = new Attribute["track", scala.Option[String], String](tagRef, "label")
    val src = new Attribute["track", scala.Option[String], String](tagRef, "src")
    val srclang = new Attribute["track", scala.Option[String], String](tagRef, "srclang")
  }

  implicit class UlExtensions(tag: Tag["ul"]) {
    def compact: scala.Option[String] = tag.attr("compact").asInstanceOf[scala.Option[String]]
    def compact(value: String): Tag["ul"] = tag.setAttr("compact", value)
    def `type`: scala.Option[String] = tag.attr("type").asInstanceOf[scala.Option[String]]
    def `type`(value: String): Tag["ul"] = tag.setAttr("type", value)
  }

  implicit class TagRefAttributesUl(tagRef: TagRef["ul"]) {
    val compact = new Attribute["ul", scala.Option[String], String](tagRef, "compact")
    val `type` = new Attribute["ul", scala.Option[String], String](tagRef, "type")
  }

  implicit class VideoExtensions(tag: Tag["video"]) {
    def autoplay: scala.Option[String] = tag.attr("autoplay").asInstanceOf[scala.Option[String]]
    def autoplay(value: String): Tag["video"] = tag.setAttr("autoplay", value)
    def autobuffer: scala.Option[String] = tag.attr("autobuffer").asInstanceOf[scala.Option[String]]
    def autobuffer(value: String): Tag["video"] = tag.setAttr("autobuffer", value)
    def buffered: scala.Option[String] = tag.attr("buffered").asInstanceOf[scala.Option[String]]
    def buffered(value: String): Tag["video"] = tag.setAttr("buffered", value)
    def controls: scala.Option[String] = tag.attr("controls").asInstanceOf[scala.Option[String]]
    def controls(value: String): Tag["video"] = tag.setAttr("controls", value)
    def crossorigin: scala.Option[String] = tag.attr("crossorigin").asInstanceOf[scala.Option[String]]
    def crossorigin(value: String): Tag["video"] = tag.setAttr("crossorigin", value)
    def height: scala.Option[String] = tag.attr("height").asInstanceOf[scala.Option[String]]
    def height(value: String): Tag["video"] = tag.setAttr("height", value)
    def loop: scala.Option[String] = tag.attr("loop").asInstanceOf[scala.Option[String]]
    def loop(value: String): Tag["video"] = tag.setAttr("loop", value)
    def muted: scala.Option[String] = tag.attr("muted").asInstanceOf[scala.Option[String]]
    def muted(value: String): Tag["video"] = tag.setAttr("muted", value)
    def played: scala.Option[String] = tag.attr("played").asInstanceOf[scala.Option[String]]
    def played(value: String): Tag["video"] = tag.setAttr("played", value)
    def preload: scala.Option[String] = tag.attr("preload").asInstanceOf[scala.Option[String]]
    def preload(value: String): Tag["video"] = tag.setAttr("preload", value)
    def poster: scala.Option[String] = tag.attr("poster").asInstanceOf[scala.Option[String]]
    def poster(value: String): Tag["video"] = tag.setAttr("poster", value)
    def src: scala.Option[String] = tag.attr("src").asInstanceOf[scala.Option[String]]
    def src(value: String): Tag["video"] = tag.setAttr("src", value)
    def width: scala.Option[String] = tag.attr("width").asInstanceOf[scala.Option[String]]
    def width(value: String): Tag["video"] = tag.setAttr("width", value)
  }

  implicit class TagRefAttributesVideo(tagRef: TagRef["video"]) {
    val autoplay = new Attribute["video", scala.Option[String], String](tagRef, "autoplay")
    val autobuffer = new Attribute["video", scala.Option[String], String](tagRef, "autobuffer")
    val buffered = new Attribute["video", scala.Option[String], String](tagRef, "buffered")
    val controls = new Attribute["video", scala.Option[String], String](tagRef, "controls")
    val crossorigin = new Attribute["video", scala.Option[String], String](tagRef, "crossorigin")
    val height = new Attribute["video", scala.Option[String], String](tagRef, "height")
    val loop = new Attribute["video", scala.Option[String], String](tagRef, "loop")
    val muted = new Attribute["video", scala.Option[String], String](tagRef, "muted")
    val played = new Attribute["video", scala.Option[String], String](tagRef, "played")
    val preload = new Attribute["video", scala.Option[String], String](tagRef, "preload")
    val poster = new Attribute["video", scala.Option[String], String](tagRef, "poster")
    val src = new Attribute["video", scala.Option[String], String](tagRef, "src")
    val width = new Attribute["video", scala.Option[String], String](tagRef, "width")
  }

}
