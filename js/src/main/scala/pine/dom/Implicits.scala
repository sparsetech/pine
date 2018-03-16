package pine.dom

import org.scalajs.dom._
import org.scalajs.dom.ext._

import pine._

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
    def onEnter(f: String => Unit)(implicit js: Js[T], ev: T <:< tag.Input): Unit =
      tagRef.keyPress := { e =>
        if (e.keyCode == KeyCode.Enter)
          f(dom.asInstanceOf[org.scalajs.dom.html.Input].value)
      }

    def dom(implicit js: Js[T]): js.X =
      domOpt(tagRef)(js).getOrElse(
        throw new Exception(s"Invalid node reference $tagRef"))

    private[dom] def resolve(implicit js: Js[T]): List[js.X] =
      tagRef match {
        case TagRef.Each(tr) => domEach(tr)(js)
        case TagRef.Opt (tr) => domOpt(tr)(js).toList
        case _               => List(dom(js))
      }

    def dragEnd(implicit js: Js[T]): EventN[DragEvent] =
      new EventN(tagRef.resolve, _.ondragend = _)
    def keyDown(implicit js: Js[T]): EventN[KeyboardEvent] =
      new EventN(tagRef.resolve, _.onkeydown = _)
    def dragOver(implicit js: Js[T]): EventN[DragEvent] =
      new EventN(tagRef.resolve, _.ondragover = _)
    def keyUp(implicit js: Js[T]): EventN[KeyboardEvent] =
      new EventN(tagRef.resolve, _.onkeyup = _)
    def reset(implicit js: Js[T]): EventN[org.scalajs.dom.Event] =
      new EventN(tagRef.resolve, _.onreset = _)
    def mouseUp(implicit js: Js[T]): EventN[MouseEvent] =
      new EventN(tagRef.resolve, _.onmouseup = _)
    def dragStart(implicit js: Js[T]): EventN[DragEvent] =
      new EventN(tagRef.resolve, _.ondragstart = _)
    def drag(implicit js: Js[T]): EventN[DragEvent] =
      new EventN(tagRef.resolve, _.ondrag = _)
    def mouseOver(implicit js: Js[T]): EventN[MouseEvent] =
      new EventN(tagRef.resolve, _.onmouseover = _)
    def dragLeave(implicit js: Js[T]): EventN[DragEvent] =
      new EventN(tagRef.resolve, _.ondragleave = _)

    // TODO See also https://github.com/scala-js/scala-js-dom/pull/314
    def cut(implicit js: Js[T]): EventN[ClipboardEvent] =
      new EventN(tagRef.resolve, _.asInstanceOf[scala.scalajs.js.Dynamic].oncut = _)
    def copy(implicit js: Js[T]): EventN[ClipboardEvent] =
      new EventN(tagRef.resolve, _.asInstanceOf[scala.scalajs.js.Dynamic].oncopy = _)
    def paste(implicit js: Js[T]): EventN[ClipboardEvent] =
      new EventN(tagRef.resolve, _.asInstanceOf[scala.scalajs.js.Dynamic].onpaste = _)

    def pause(implicit js: Js[T]): EventN[org.scalajs.dom.Event] =
      new EventN(tagRef.resolve, _.onpause = _)
    def mouseDown(implicit js: Js[T]): EventN[MouseEvent] =
      new EventN(tagRef.resolve, _.onmousedown = _)
    def seeked(implicit js: Js[T]): EventN[org.scalajs.dom.Event] =
      new EventN(tagRef.resolve, _.onseeked = _)
    def click(implicit js: Js[T]): EventN[MouseEvent] =
      new EventN(tagRef.resolve, _.onclick = _)
    def waiting(implicit js: Js[T]): EventN[org.scalajs.dom.Event] =
      new EventN(tagRef.resolve, _.onwaiting = _)
    def durationChange(implicit js: Js[T]): EventN[org.scalajs.dom.Event] =
      new EventN(tagRef.resolve, _.ondurationchange = _)
    def blur(implicit js: Js[T]): EventN[FocusEvent] =
      new EventN(tagRef.resolve, _.onblur = _)
    def emptied(implicit js: Js[T]): EventN[org.scalajs.dom.Event] =
      new EventN(tagRef.resolve, _.onemptied = _)
    def seeking(implicit js: Js[T]): EventN[org.scalajs.dom.Event] =
      new EventN(tagRef.resolve, _.onseeking = _)
    def canPlay(implicit js: Js[T]): EventN[org.scalajs.dom.Event] =
      new EventN(tagRef.resolve, _.oncanplay = _)
    def stalled(implicit js: Js[T]): EventN[org.scalajs.dom.Event] =
      new EventN(tagRef.resolve, _.onstalled = _)
    def mouseMove(implicit js: Js[T]): EventN[MouseEvent] =
      new EventN(tagRef.resolve, _.onmousemove = _)
    def rateChange(implicit js: Js[T]): EventN[org.scalajs.dom.Event] =
      new EventN(tagRef.resolve, _.onratechange = _)
    def loadStart(implicit js: Js[T]): EventN[org.scalajs.dom.Event] =
      new EventN(tagRef.resolve, _.onloadstart = _)
    def dragEnter(implicit js: Js[T]): EventN[DragEvent] =
      new EventN(tagRef.resolve, _.ondragenter = _)
    def submit(implicit js: Js[T]): EventN[org.scalajs.dom.Event] =
      new EventN(tagRef.resolve, _.onsubmit = _)
    // def progress(implicit js: Js[T]): DomEventN[scalajs.js.Any] =
    //   new DomEventN(tagRef.resolve, _.onprogress = _)
    def dblClick(implicit js: Js[T]): EventN[MouseEvent] =
      new EventN(tagRef.resolve, _.ondblclick = _)
    def contextMenu(implicit js: Js[T]): EventN[MouseEvent] =
      new EventN(tagRef.resolve, _.oncontextmenu = _)
    def change(implicit js: Js[T]): EventN[org.scalajs.dom.Event] =
      new EventN(tagRef.resolve, _.onchange = _)
    def loadedMetadata(implicit js: Js[T]): EventN[org.scalajs.dom.Event] =
      new EventN(tagRef.resolve, _.onloadedmetadata = _)
    def play(implicit js: Js[T]): EventN[org.scalajs.dom.Event] =
      new EventN(tagRef.resolve, _.onplay = _)
    def playing(implicit js: Js[T]): EventN[org.scalajs.dom.Event] =
      new EventN(tagRef.resolve, _.onplaying = _)
    def canPlayThrough(implicit js: Js[T]): EventN[org.scalajs.dom.Event] =
      new EventN(tagRef.resolve, _.oncanplaythrough = _)
    def abort(implicit js: Js[T]): EventN[UIEvent] =
      new EventN(tagRef.resolve, _.onabort = _)
    def readyStateChange(implicit js: Js[T]): EventN[org.scalajs.dom.Event] =
      new EventN(tagRef.resolve, _.onreadystatechange = _)
    def keyPress(implicit js: Js[T]): EventN[KeyboardEvent] =
      new EventN(tagRef.resolve, _.onkeypress = _)
    def loadedData(implicit js: Js[T]): EventN[org.scalajs.dom.Event] =
      new EventN(tagRef.resolve, _.onloadeddata = _)
    def suspend(implicit js: Js[T]): EventN[org.scalajs.dom.Event] =
      new EventN(tagRef.resolve, _.onsuspend = _)
    def focus(implicit js: Js[T]): EventN[FocusEvent] =
      new EventN(tagRef.resolve, _.onfocus = _)
    def timeUpdate(implicit js: Js[T]): EventN[org.scalajs.dom.Event] =
      new EventN(tagRef.resolve, _.ontimeupdate = _)
    def select(implicit js: Js[T]): EventN[UIEvent] =
      new EventN(tagRef.resolve, _.onselect = _)
    def drop(implicit js: Js[T]): EventN[DragEvent] =
      new EventN(tagRef.resolve, _.ondrop = _)
    def mouseOut(implicit js: Js[T]): EventN[MouseEvent] =
      new EventN(tagRef.resolve, _.onmouseout = _)
    def ended(implicit js: Js[T]): EventN[org.scalajs.dom.Event] =
      new EventN(tagRef.resolve, _.onended = _)
    def scroll(implicit js: Js[T]): EventN[UIEvent] =
      new EventN(tagRef.resolve, _.onscroll = _)
    def mouseWheel(implicit js: Js[T]): EventN[WheelEvent] =
      new EventN(tagRef.resolve, _.onmousewheel = _)
    def volumeChange(implicit js: Js[T]): EventN[org.scalajs.dom.Event] =
      new EventN(tagRef.resolve, _.onvolumechange = _)
    def input(implicit js: Js[T]): EventN[org.scalajs.dom.Event] =
      new EventN(tagRef.resolve, _.oninput = _)
  }

  implicit class TagRefAttributeExtensions[T <: Singleton, U](
    attribute: TagRefAttribute[T, U]
  ) {
    def get(implicit js: Js[T]): U = {
      val node = attribute.parent.dom
      attribute.codec.decode(Option(node.getAttribute(attribute.name)))
    }
  }

  implicit class TagRefTokenListAttributeExtensions[T <: Singleton, U](
    attribute: TagRefTokenListAttribute[T]
  ) {
    def get(implicit js: Js[T]): List[String] = {
      val node = attribute.parent.dom
      Option(node.getAttribute(attribute.name))
        .map(HtmlHelpers.parseTokenList).getOrElse(List.empty)
    }
  }
}
