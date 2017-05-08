package pl.metastack.metaweb.dom

import org.scalajs.dom._
import org.scalajs.dom.ext.KeyCode

import pl.metastack.metaweb
import pl.metastack.metaweb._

trait Implicits {
  implicit class TagRefExtensions[T <: Tag](tagRef: TagRef[T]) {
    def onEnter(f: String => Diff)(implicit js: Js[T], ev: T <:< tag.Input): Diff =
      tagRef.keyPress := { e =>
        if (e.keyCode == KeyCode.Enter)
          f(DOM.get(tagRef).asInstanceOf[org.scalajs.dom.html.Input].value)
        else metaweb.Diff.Noop
      }

    def dragEnd(implicit js: Js[T]): Event[DragEvent] =
      new Event(DOM.get(tagRef).ondragend = _)
    def keyDown(implicit js: Js[T]): Event[KeyboardEvent] =
      new Event(DOM.get(tagRef).onkeydown = _)
    def dragOver(implicit js: Js[T]): Event[DragEvent] =
      new Event(DOM.get(tagRef).ondragover = _)
    def keyUp(implicit js: Js[T]): Event[KeyboardEvent] =
      new Event(DOM.get(tagRef).onkeyup = _)
    def reset(implicit js: Js[T]): Event[org.scalajs.dom.Event] =
      new Event(DOM.get(tagRef).onreset = _)
    def mouseUp(implicit js: Js[T]): Event[MouseEvent] =
      new Event(DOM.get(tagRef).onmouseup = _)
    def dragStart(implicit js: Js[T]): Event[DragEvent] =
      new Event(DOM.get(tagRef).ondragstart = _)
    def drag(implicit js: Js[T]): Event[DragEvent] =
      new Event(DOM.get(tagRef).ondrag = _)
    def mouseOver(implicit js: Js[T]): Event[MouseEvent] =
      new Event(DOM.get(tagRef).onmouseover = _)
    def dragLeave(implicit js: Js[T]): Event[DragEvent] =
      new Event(DOM.get(tagRef).ondragleave = _)
    def pause(implicit js: Js[T]): Event[org.scalajs.dom.Event] =
      new Event(DOM.get(tagRef).onpause = _)
    def mouseDown(implicit js: Js[T]): Event[MouseEvent] =
      new Event(DOM.get(tagRef).onmousedown = _)
    def seeked(implicit js: Js[T]): Event[org.scalajs.dom.Event] =
      new Event(DOM.get(tagRef).onseeked = _)
    def click(implicit js: Js[T]): Event[MouseEvent] =
      new Event(DOM.get(tagRef).onclick = _)
    def waiting(implicit js: Js[T]): Event[org.scalajs.dom.Event] =
      new Event(DOM.get(tagRef).onwaiting = _)
    def durationChange(implicit js: Js[T]): Event[org.scalajs.dom.Event] =
      new Event(DOM.get(tagRef).ondurationchange = _)
    def blur(implicit js: Js[T]): Event[FocusEvent] =
      new Event(DOM.get(tagRef).onblur = _)
    def emptied(implicit js: Js[T]): Event[org.scalajs.dom.Event] =
      new Event(DOM.get(tagRef).onemptied = _)
    def seeking(implicit js: Js[T]): Event[org.scalajs.dom.Event] =
      new Event(DOM.get(tagRef).onseeking = _)
    def canPlay(implicit js: Js[T]): Event[org.scalajs.dom.Event] =
      new Event(DOM.get(tagRef).oncanplay = _)
    def stalled(implicit js: Js[T]): Event[org.scalajs.dom.Event] =
      new Event(DOM.get(tagRef).onstalled = _)
    def mouseMove(implicit js: Js[T]): Event[MouseEvent] =
      new Event(DOM.get(tagRef).onmousemove = _)
    def rateChange(implicit js: Js[T]): Event[org.scalajs.dom.Event] =
      new Event(DOM.get(tagRef).onratechange = _)
    def loadStart(implicit js: Js[T]): Event[org.scalajs.dom.Event] =
      new Event(DOM.get(tagRef).onloadstart = _)
    def dragEnter(implicit js: Js[T]): Event[DragEvent] =
      new Event(DOM.get(tagRef).ondragenter = _)
    def submit(implicit js: Js[T]): Event[org.scalajs.dom.Event] =
      new Event(DOM.get(tagRef).onsubmit = _)
    // def progress(implicit js: Js[T]): DomEvent[scalajs.js.Any] =
    //   new DomEvent(DOM.get(tagRef).onprogress = _)
    def dblClick(implicit js: Js[T]): Event[MouseEvent] =
    new Event(DOM.get(tagRef).ondblclick = _)
    def contextMenu(implicit js: Js[T]): Event[MouseEvent] =
      new Event(DOM.get(tagRef).oncontextmenu = _)
    def change(implicit js: Js[T]): Event[org.scalajs.dom.Event] =
      new Event(DOM.get(tagRef).onchange = _)
    def loadedMetadata(implicit js: Js[T]): Event[org.scalajs.dom.Event] =
      new Event(DOM.get(tagRef).onloadedmetadata = _)
    def play(implicit js: Js[T]): Event[org.scalajs.dom.Event] =
      new Event(DOM.get(tagRef).onplay = _)
    def playing(implicit js: Js[T]): Event[org.scalajs.dom.Event] =
      new Event(DOM.get(tagRef).onplaying = _)
    def canPlayThrough(implicit js: Js[T]): Event[org.scalajs.dom.Event] =
      new Event(DOM.get(tagRef).oncanplaythrough = _)
    def abort(implicit js: Js[T]): Event[UIEvent] =
      new Event(DOM.get(tagRef).onabort = _)
    def readyStateChange(implicit js: Js[T]): Event[org.scalajs.dom.Event] =
      new Event(DOM.get(tagRef).onreadystatechange = _)
    def keyPress(implicit js: Js[T]): Event[KeyboardEvent] =
      new Event(DOM.get(tagRef).onkeypress = _)
    def loadedData(implicit js: Js[T]): Event[org.scalajs.dom.Event] =
      new Event(DOM.get(tagRef).onloadeddata = _)
    def suspend(implicit js: Js[T]): Event[org.scalajs.dom.Event] =
      new Event(DOM.get(tagRef).onsuspend = _)
    def focus(implicit js: Js[T]): Event[FocusEvent] =
      new Event(DOM.get(tagRef).onfocus = _)
    def timeUpdate(implicit js: Js[T]): Event[org.scalajs.dom.Event] =
      new Event(DOM.get(tagRef).ontimeupdate = _)
    def select(implicit js: Js[T]): Event[UIEvent] =
      new Event(DOM.get(tagRef).onselect = _)
    def drop(implicit js: Js[T]): Event[DragEvent] =
      new Event(DOM.get(tagRef).ondrop = _)
    def mouseOut(implicit js: Js[T]): Event[MouseEvent] =
      new Event(DOM.get(tagRef).onmouseout = _)
    def ended(implicit js: Js[T]): Event[org.scalajs.dom.Event] =
      new Event(DOM.get(tagRef).onended = _)
    def scroll(implicit js: Js[T]): Event[UIEvent] =
      new Event(DOM.get(tagRef).onscroll = _)
    def mouseWheel(implicit js: Js[T]): Event[WheelEvent] =
      new Event(DOM.get(tagRef).onmousewheel = _)
    def volumeChange(implicit js: Js[T]): Event[org.scalajs.dom.Event] =
      new Event(DOM.get(tagRef).onvolumechange = _)
    def input(implicit js: Js[T]): Event[org.scalajs.dom.Event] =
      new Event(DOM.get(tagRef).oninput = _)
  }
}
