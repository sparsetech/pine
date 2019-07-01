package pine.dom

import org.scalajs.dom._
import org.scalajs.dom.ext._

import pine.{HtmlHelpers, TagRef, TagRefAttribute, TagRefTokenSetAttribute, tag}

trait Implicits {
  /** Resolve DOM node */
  private final def domOpt[T <: Singleton](tagRef: TagRef[T])
                                          (implicit js: Js[T]): Option[js.X] =
    tagRef match {
      case TagRef.ById(id) =>
        Option(document.getElementById(id).asInstanceOf[js.X])
      case TagRef.ByTag(tag) =>
        val nodes = document.getElementsByTagName(tag)
        if (nodes.length == 0) None else Some(nodes.item(0).asInstanceOf[js.X])
      case TagRef.ByClass(cls) =>
        val nodes = document.getElementsByClassName(cls)
        if (nodes.length == 0) None else Some(nodes.item(0).asInstanceOf[js.X])
      case t => throw new Exception(s"`dom` must be called on sub-type $t")
    }

  /** Resolve all DOM nodes */
  private def domEach[T <: Singleton](tagRef: TagRef[T])
                                     (implicit js: Js[T]): List[js.X] =
    tagRef match {
      case TagRef.ByTag(tag) =>
        document.getElementsByTagName(tag).toList.asInstanceOf[List[js.X]]
      case TagRef.ByClass(cls) =>
        document.getElementsByClassName(cls).toList.asInstanceOf[List[js.X]]
      case t => throw new Exception(s"Unexpected type $t")
    }

  implicit class TagRefOptExtensions[T <: Singleton](opt: TagRef.Opt[T]) {
    def dom(implicit js: Js[T]): Option[js.X] = domOpt(opt.tagRef)(js)
  }

  implicit class TagRefEachExtensions[T <: Singleton](each: TagRef.Each[T]) {
    def dom(implicit js: Js[T]): List[js.X] = domEach(each.tagRef)(js)
  }

  implicit class TagRefExtensions[T <: Singleton](tagRef: TagRef[T]) {
    def dom(implicit js: Js[T]): js.X =
      domOpt(tagRef)(js).getOrElse(
        throw new Exception(s"Invalid node reference $tagRef"))

    private[dom] def resolve(implicit js: Js[T]): List[js.X] =
      tagRef match {
        case TagRef.Each(tr) => domEach(tr)(js)
        case TagRef.Opt (tr) => domOpt(tr)(js).toList
        case _               => List(dom(js))
      }

    def cut(implicit js: Js[T]): EventN[ClipboardEvent] =
      new EventN(tagRef.resolve, _.oncut = _)
    def copy(implicit js: Js[T]): EventN[ClipboardEvent] =
      new EventN(tagRef.resolve, _.oncopy = _)
    def paste(implicit js: Js[T]): EventN[ClipboardEvent] =
      new EventN(tagRef.resolve, _.onpaste = _)
  }

  implicit class TagRefHtmlExtensions[T <: Singleton](tagRef: TagRef[T]) {
    def onEnter(f: String => Unit)(implicit js: JsHtml[T], ev: T <:< tag.Input): Unit =
      tagRef.keyPress := { e =>
        if (e.keyCode == KeyCode.Enter)
          f(tagRef.dom.asInstanceOf[org.scalajs.dom.html.Input].value)
      }

    def dragEnd(implicit js: JsHtml[T]): EventHtml[DragEvent] =
      new EventHtml(tagRef.resolve(js), _.ondragend = _)
    def keyDown(implicit js: JsHtml[T]): EventHtml[KeyboardEvent] =
      new EventHtml(tagRef.resolve, _.onkeydown = _)
    def dragOver(implicit js: JsHtml[T]): EventHtml[DragEvent] =
      new EventHtml(tagRef.resolve, _.ondragover = _)
    def keyUp(implicit js: JsHtml[T]): EventHtml[KeyboardEvent] =
      new EventHtml(tagRef.resolve, _.onkeyup = _)
    def reset(implicit js: JsHtml[T]): EventHtml[org.scalajs.dom.Event] =
      new EventHtml(tagRef.resolve, _.onreset = _)
    def mouseUp(implicit js: JsHtml[T]): EventHtml[MouseEvent] =
      new EventHtml(tagRef.resolve, _.onmouseup = _)
    def dragStart(implicit js: JsHtml[T]): EventHtml[DragEvent] =
      new EventHtml(tagRef.resolve, _.ondragstart = _)
    def drag(implicit js: JsHtml[T]): EventHtml[DragEvent] =
      new EventHtml(tagRef.resolve, _.ondrag = _)
    def mouseOver(implicit js: JsHtml[T]): EventHtml[MouseEvent] =
      new EventHtml(tagRef.resolve, _.onmouseover = _)
    def dragLeave(implicit js: JsHtml[T]): EventHtml[DragEvent] =
      new EventHtml(tagRef.resolve, _.ondragleave = _)
    def pause(implicit js: JsHtml[T]): EventHtml[org.scalajs.dom.Event] =
      new EventHtml(tagRef.resolve, _.onpause = _)
    def mouseDown(implicit js: JsHtml[T]): EventHtml[MouseEvent] =
      new EventHtml(tagRef.resolve, _.onmousedown = _)
    def seeked(implicit js: JsHtml[T]): EventHtml[org.scalajs.dom.Event] =
      new EventHtml(tagRef.resolve, _.onseeked = _)
    def click(implicit js: JsHtml[T]): EventHtml[MouseEvent] =
      new EventHtml(tagRef.resolve, _.onclick = _)
    def waiting(implicit js: JsHtml[T]): EventHtml[org.scalajs.dom.Event] =
      new EventHtml(tagRef.resolve, _.onwaiting = _)
    def durationChange(implicit js: JsHtml[T]): EventHtml[org.scalajs.dom.Event] =
      new EventHtml(tagRef.resolve, _.ondurationchange = _)
    def blur(implicit js: JsHtml[T]): EventHtml[FocusEvent] =
      new EventHtml(tagRef.resolve, _.onblur = _)
    def emptied(implicit js: JsHtml[T]): EventHtml[org.scalajs.dom.Event] =
      new EventHtml(tagRef.resolve, _.onemptied = _)
    def seeking(implicit js: JsHtml[T]): EventHtml[org.scalajs.dom.Event] =
      new EventHtml(tagRef.resolve, _.onseeking = _)
    def canPlay(implicit js: JsHtml[T]): EventHtml[org.scalajs.dom.Event] =
      new EventHtml(tagRef.resolve, _.oncanplay = _)
    def stalled(implicit js: JsHtml[T]): EventHtml[org.scalajs.dom.Event] =
      new EventHtml(tagRef.resolve, _.onstalled = _)
    def mouseMove(implicit js: JsHtml[T]): EventHtml[MouseEvent] =
      new EventHtml(tagRef.resolve, _.onmousemove = _)
    def rateChange(implicit js: JsHtml[T]): EventHtml[org.scalajs.dom.Event] =
      new EventHtml(tagRef.resolve, _.onratechange = _)
    def loadStart(implicit js: JsHtml[T]): EventHtml[org.scalajs.dom.Event] =
      new EventHtml(tagRef.resolve, _.onloadstart = _)
    def dragEnter(implicit js: JsHtml[T]): EventHtml[DragEvent] =
      new EventHtml(tagRef.resolve, _.ondragenter = _)
    def submit(implicit js: JsHtml[T]): EventHtml[org.scalajs.dom.Event] =
      new EventHtml(tagRef.resolve, _.onsubmit = _)
    // def progress(implicit js: JsHtml[T]): DomEventHtml[scalajs.js.Any] =
    //   new DomEventHtml(tagRef.resolve, _.onprogress = _)
    def dblClick(implicit js: JsHtml[T]): EventHtml[MouseEvent] =
      new EventHtml(tagRef.resolve, _.ondblclick = _)
    def contextMenu(implicit js: JsHtml[T]): EventHtml[MouseEvent] =
      new EventHtml(tagRef.resolve, _.oncontextmenu = _)
    def change(implicit js: JsHtml[T]): EventHtml[org.scalajs.dom.Event] =
      new EventHtml(tagRef.resolve, _.onchange = _)
    def loadedMetadata(implicit js: JsHtml[T]): EventHtml[org.scalajs.dom.Event] =
      new EventHtml(tagRef.resolve, _.onloadedmetadata = _)
    def play(implicit js: JsHtml[T]): EventHtml[org.scalajs.dom.Event] =
      new EventHtml(tagRef.resolve, _.onplay = _)
    def playing(implicit js: JsHtml[T]): EventHtml[org.scalajs.dom.Event] =
      new EventHtml(tagRef.resolve, _.onplaying = _)
    def canPlayThrough(implicit js: JsHtml[T]): EventHtml[org.scalajs.dom.Event] =
      new EventHtml(tagRef.resolve, _.oncanplaythrough = _)
    def abort(implicit js: JsHtml[T]): EventHtml[UIEvent] =
      new EventHtml(tagRef.resolve, _.onabort = _)
    def readyStateChange(implicit js: JsHtml[T]): EventHtml[org.scalajs.dom.Event] =
      new EventHtml(tagRef.resolve, _.onreadystatechange = _)
    def keyPress(implicit js: JsHtml[T]): EventHtml[KeyboardEvent] =
      new EventHtml(tagRef.resolve, _.onkeypress = _)
    def loadedData(implicit js: JsHtml[T]): EventHtml[org.scalajs.dom.Event] =
      new EventHtml(tagRef.resolve, _.onloadeddata = _)
    def suspend(implicit js: JsHtml[T]): EventHtml[org.scalajs.dom.Event] =
      new EventHtml(tagRef.resolve, _.onsuspend = _)
    def focus(implicit js: JsHtml[T]): EventHtml[FocusEvent] =
      new EventHtml(tagRef.resolve, _.onfocus = _)
    def timeUpdate(implicit js: JsHtml[T]): EventHtml[org.scalajs.dom.Event] =
      new EventHtml(tagRef.resolve, _.ontimeupdate = _)
    def select(implicit js: JsHtml[T]): EventHtml[UIEvent] =
      new EventHtml(tagRef.resolve, _.onselect = _)
    def drop(implicit js: JsHtml[T]): EventHtml[DragEvent] =
      new EventHtml(tagRef.resolve, _.ondrop = _)
    def mouseOut(implicit js: JsHtml[T]): EventHtml[MouseEvent] =
      new EventHtml(tagRef.resolve, _.onmouseout = _)
    def ended(implicit js: JsHtml[T]): EventHtml[org.scalajs.dom.Event] =
      new EventHtml(tagRef.resolve, _.onended = _)
    def scroll(implicit js: JsHtml[T]): EventHtml[UIEvent] =
      new EventHtml(tagRef.resolve, _.onscroll = _)
    def mouseWheel(implicit js: JsHtml[T]): EventHtml[WheelEvent] =
      new EventHtml(tagRef.resolve, _.onmousewheel = _)
    def volumeChange(implicit js: JsHtml[T]): EventHtml[org.scalajs.dom.Event] =
      new EventHtml(tagRef.resolve, _.onvolumechange = _)
    def input(implicit js: JsHtml[T]): EventHtml[org.scalajs.dom.Event] =
      new EventHtml(tagRef.resolve, _.oninput = _)
  }

  implicit class TagRefAttributeExtensions[T <: Singleton, U](
    attribute: TagRefAttribute[T, U]
  ) {
    def get(implicit js: Js[T]): U = {
      val node = attribute.parent.dom
      attribute.codec.decode(Option(node.getAttribute(attribute.name)))
    }
  }

  implicit class TagRefTokenSetAttributeExtensions[T <: Singleton, U](
    attribute: TagRefTokenSetAttribute[T]
  ) {
    def get(implicit js: Js[T]): List[String] = {
      val node = attribute.parent.dom
      Option(node.getAttribute(attribute.name))
        .map(HtmlHelpers.parseTokenSet).getOrElse(List.empty)
    }
  }
}
