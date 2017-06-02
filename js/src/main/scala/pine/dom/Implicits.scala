package pine.dom

import org.scalajs.dom._
import org.scalajs.dom.ext.KeyCode

import pine._

trait Implicits {
  implicit class TagRefExtensions[T <: Tag](tagRef: TagRef[T]) {
    def onEnter(f: String => Unit)(implicit js: Js[T], ev: T <:< tag.Input): Unit =
      tagRef.keyPress := { e =>
        if (e.keyCode == KeyCode.Enter)
          f(dom.asInstanceOf[org.scalajs.dom.html.Input].value)
      }

    /** Resolve DOM node */
    def dom(implicit js: Js[T]): js.X = {
      val node = tagRef match {
        case TagRef.ById(id)   => document.getElementById(id)
        case TagRef.ByTag(tag) => document.getElementsByTagName(tag).item(0)
      }

      Option(node).getOrElse(
        throw new Exception(s"Invalid node reference '$tagRef'")
      ).asInstanceOf[js.X]
    }

    def dragEnd(implicit js: Js[T]): Event[DragEvent] =
      new Event(dom.ondragend = _)
    def keyDown(implicit js: Js[T]): Event[KeyboardEvent] =
      new Event(dom.onkeydown = _)
    def dragOver(implicit js: Js[T]): Event[DragEvent] =
      new Event(dom.ondragover = _)
    def keyUp(implicit js: Js[T]): Event[KeyboardEvent] =
      new Event(dom.onkeyup = _)
    def reset(implicit js: Js[T]): Event[org.scalajs.dom.Event] =
      new Event(dom.onreset = _)
    def mouseUp(implicit js: Js[T]): Event[MouseEvent] =
      new Event(dom.onmouseup = _)
    def dragStart(implicit js: Js[T]): Event[DragEvent] =
      new Event(dom.ondragstart = _)
    def drag(implicit js: Js[T]): Event[DragEvent] =
      new Event(dom.ondrag = _)
    def mouseOver(implicit js: Js[T]): Event[MouseEvent] =
      new Event(dom.onmouseover = _)
    def dragLeave(implicit js: Js[T]): Event[DragEvent] =
      new Event(dom.ondragleave = _)
    def pause(implicit js: Js[T]): Event[org.scalajs.dom.Event] =
      new Event(dom.onpause = _)
    def mouseDown(implicit js: Js[T]): Event[MouseEvent] =
      new Event(dom.onmousedown = _)
    def seeked(implicit js: Js[T]): Event[org.scalajs.dom.Event] =
      new Event(dom.onseeked = _)
    def click(implicit js: Js[T]): Event[MouseEvent] =
      new Event(dom.onclick = _)
    def waiting(implicit js: Js[T]): Event[org.scalajs.dom.Event] =
      new Event(dom.onwaiting = _)
    def durationChange(implicit js: Js[T]): Event[org.scalajs.dom.Event] =
      new Event(dom.ondurationchange = _)
    def blur(implicit js: Js[T]): Event[FocusEvent] =
      new Event(dom.onblur = _)
    def emptied(implicit js: Js[T]): Event[org.scalajs.dom.Event] =
      new Event(dom.onemptied = _)
    def seeking(implicit js: Js[T]): Event[org.scalajs.dom.Event] =
      new Event(dom.onseeking = _)
    def canPlay(implicit js: Js[T]): Event[org.scalajs.dom.Event] =
      new Event(dom.oncanplay = _)
    def stalled(implicit js: Js[T]): Event[org.scalajs.dom.Event] =
      new Event(dom.onstalled = _)
    def mouseMove(implicit js: Js[T]): Event[MouseEvent] =
      new Event(dom.onmousemove = _)
    def rateChange(implicit js: Js[T]): Event[org.scalajs.dom.Event] =
      new Event(dom.onratechange = _)
    def loadStart(implicit js: Js[T]): Event[org.scalajs.dom.Event] =
      new Event(dom.onloadstart = _)
    def dragEnter(implicit js: Js[T]): Event[DragEvent] =
      new Event(dom.ondragenter = _)
    def submit(implicit js: Js[T]): Event[org.scalajs.dom.Event] =
      new Event(dom.onsubmit = _)
    // def progress(implicit js: Js[T]): DomEvent[scalajs.js.Any] =
    //   new DomEvent(dom.onprogress = _)
    def dblClick(implicit js: Js[T]): Event[MouseEvent] =
    new Event(dom.ondblclick = _)
    def contextMenu(implicit js: Js[T]): Event[MouseEvent] =
      new Event(dom.oncontextmenu = _)
    def change(implicit js: Js[T]): Event[org.scalajs.dom.Event] =
      new Event(dom.onchange = _)
    def loadedMetadata(implicit js: Js[T]): Event[org.scalajs.dom.Event] =
      new Event(dom.onloadedmetadata = _)
    def play(implicit js: Js[T]): Event[org.scalajs.dom.Event] =
      new Event(dom.onplay = _)
    def playing(implicit js: Js[T]): Event[org.scalajs.dom.Event] =
      new Event(dom.onplaying = _)
    def canPlayThrough(implicit js: Js[T]): Event[org.scalajs.dom.Event] =
      new Event(dom.oncanplaythrough = _)
    def abort(implicit js: Js[T]): Event[UIEvent] =
      new Event(dom.onabort = _)
    def readyStateChange(implicit js: Js[T]): Event[org.scalajs.dom.Event] =
      new Event(dom.onreadystatechange = _)
    def keyPress(implicit js: Js[T]): Event[KeyboardEvent] =
      new Event(dom.onkeypress = _)
    def loadedData(implicit js: Js[T]): Event[org.scalajs.dom.Event] =
      new Event(dom.onloadeddata = _)
    def suspend(implicit js: Js[T]): Event[org.scalajs.dom.Event] =
      new Event(dom.onsuspend = _)
    def focus(implicit js: Js[T]): Event[FocusEvent] =
      new Event(dom.onfocus = _)
    def timeUpdate(implicit js: Js[T]): Event[org.scalajs.dom.Event] =
      new Event(dom.ontimeupdate = _)
    def select(implicit js: Js[T]): Event[UIEvent] =
      new Event(dom.onselect = _)
    def drop(implicit js: Js[T]): Event[DragEvent] =
      new Event(dom.ondrop = _)
    def mouseOut(implicit js: Js[T]): Event[MouseEvent] =
      new Event(dom.onmouseout = _)
    def ended(implicit js: Js[T]): Event[org.scalajs.dom.Event] =
      new Event(dom.onended = _)
    def scroll(implicit js: Js[T]): Event[UIEvent] =
      new Event(dom.onscroll = _)
    def mouseWheel(implicit js: Js[T]): Event[WheelEvent] =
      new Event(dom.onmousewheel = _)
    def volumeChange(implicit js: Js[T]): Event[org.scalajs.dom.Event] =
      new Event(dom.onvolumechange = _)
    def input(implicit js: Js[T]): Event[org.scalajs.dom.Event] =
      new Event(dom.oninput = _)
  }

  implicit class AttributeExtensions[T <: Tag, G](attribute: Attribute[T, G, _]) {
    /** TODO Introduce BooleanAttribute and StringAttribute for better type-safety? */
    def get(implicit js: Js[T]): G =
      if (HtmlHelpers.BooleanAttributes.contains(attribute.name))
        attribute.parent.dom.hasAttribute(attribute.name).asInstanceOf[G]
      else Option(attribute.parent.dom.getAttribute(attribute.name)).asInstanceOf[G]
  }
}
