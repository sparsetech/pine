package pine.dom

import org.scalajs.dom._
import org.scalajs.dom.ext._

import pine._

trait Implicits {
  implicit class TagRefExtensions[T <: Singleton](tagRef: TagRef[T]) {
    def onEnter(f: String => Unit)(implicit js: Js[T], ev: T <:< tag.Input): Unit =
      tagRef.keyPress := { e =>
        if (e.keyCode == KeyCode.Enter)
          f(dom.asInstanceOf[org.scalajs.dom.html.Input].value)
      }

    /** Resolve DOM node */
    def dom(implicit js: Js[T]): js.X = {
      val node = tagRef match {
        case TagRef.ById(id)      => document.getElementById(id)
        case TagRef.ByTag(tag, _) => document.getElementsByTagName(tag).item(0)
      }

      Option(node).getOrElse(
        throw new Exception(s"Invalid node reference '$tagRef'")
      ).asInstanceOf[js.X]
    }

    /** Resolve all DOM nodes */
    def domAll(implicit js: Js[T]): List[js.X] =
      tagRef match {
        case TagRef.ByTag(tag, true) =>
          document.getElementsByTagName(tag).toList.asInstanceOf[List[js.X]]
        case _ => List(dom)
      }

    def dragEnd(implicit js: Js[T]): EventN[DragEvent] =
      new EventN(tagRef.domAll, _.ondragend = _)
    def keyDown(implicit js: Js[T]): EventN[KeyboardEvent] =
      new EventN(tagRef.domAll, _.onkeydown = _)
    def dragOver(implicit js: Js[T]): EventN[DragEvent] =
      new EventN(tagRef.domAll, _.ondragover = _)
    def keyUp(implicit js: Js[T]): EventN[KeyboardEvent] =
      new EventN(tagRef.domAll, _.onkeyup = _)
    def reset(implicit js: Js[T]): EventN[org.scalajs.dom.Event] =
      new EventN(tagRef.domAll, _.onreset = _)
    def mouseUp(implicit js: Js[T]): EventN[MouseEvent] =
      new EventN(tagRef.domAll, _.onmouseup = _)
    def dragStart(implicit js: Js[T]): EventN[DragEvent] =
      new EventN(tagRef.domAll, _.ondragstart = _)
    def drag(implicit js: Js[T]): EventN[DragEvent] =
      new EventN(tagRef.domAll, _.ondrag = _)
    def mouseOver(implicit js: Js[T]): EventN[MouseEvent] =
      new EventN(tagRef.domAll, _.onmouseover = _)
    def dragLeave(implicit js: Js[T]): EventN[DragEvent] =
      new EventN(tagRef.domAll, _.ondragleave = _)
    def pause(implicit js: Js[T]): EventN[org.scalajs.dom.Event] =
      new EventN(tagRef.domAll, _.onpause = _)
    def mouseDown(implicit js: Js[T]): EventN[MouseEvent] =
      new EventN(tagRef.domAll, _.onmousedown = _)
    def seeked(implicit js: Js[T]): EventN[org.scalajs.dom.Event] =
      new EventN(tagRef.domAll, _.onseeked = _)
    def click(implicit js: Js[T]): EventN[MouseEvent] =
      new EventN(tagRef.domAll, _.onclick = _)
    def waiting(implicit js: Js[T]): EventN[org.scalajs.dom.Event] =
      new EventN(tagRef.domAll, _.onwaiting = _)
    def durationChange(implicit js: Js[T]): EventN[org.scalajs.dom.Event] =
      new EventN(tagRef.domAll, _.ondurationchange = _)
    def blur(implicit js: Js[T]): EventN[FocusEvent] =
      new EventN(tagRef.domAll, _.onblur = _)
    def emptied(implicit js: Js[T]): EventN[org.scalajs.dom.Event] =
      new EventN(tagRef.domAll, _.onemptied = _)
    def seeking(implicit js: Js[T]): EventN[org.scalajs.dom.Event] =
      new EventN(tagRef.domAll, _.onseeking = _)
    def canPlay(implicit js: Js[T]): EventN[org.scalajs.dom.Event] =
      new EventN(tagRef.domAll, _.oncanplay = _)
    def stalled(implicit js: Js[T]): EventN[org.scalajs.dom.Event] =
      new EventN(tagRef.domAll, _.onstalled = _)
    def mouseMove(implicit js: Js[T]): EventN[MouseEvent] =
      new EventN(tagRef.domAll, _.onmousemove = _)
    def rateChange(implicit js: Js[T]): EventN[org.scalajs.dom.Event] =
      new EventN(tagRef.domAll, _.onratechange = _)
    def loadStart(implicit js: Js[T]): EventN[org.scalajs.dom.Event] =
      new EventN(tagRef.domAll, _.onloadstart = _)
    def dragEnter(implicit js: Js[T]): EventN[DragEvent] =
      new EventN(tagRef.domAll, _.ondragenter = _)
    def submit(implicit js: Js[T]): EventN[org.scalajs.dom.Event] =
      new EventN(tagRef.domAll, _.onsubmit = _)
    // def progress(implicit js: Js[T]): DomEventN[scalajs.js.Any] =
    //   new DomEventN(tagRef.domAll, _.onprogress = _)
    def dblClick(implicit js: Js[T]): EventN[MouseEvent] =
      new EventN(tagRef.domAll, _.ondblclick = _)
    def contextMenu(implicit js: Js[T]): EventN[MouseEvent] =
      new EventN(tagRef.domAll, _.oncontextmenu = _)
    def change(implicit js: Js[T]): EventN[org.scalajs.dom.Event] =
      new EventN(tagRef.domAll, _.onchange = _)
    def loadedMetadata(implicit js: Js[T]): EventN[org.scalajs.dom.Event] =
      new EventN(tagRef.domAll, _.onloadedmetadata = _)
    def play(implicit js: Js[T]): EventN[org.scalajs.dom.Event] =
      new EventN(tagRef.domAll, _.onplay = _)
    def playing(implicit js: Js[T]): EventN[org.scalajs.dom.Event] =
      new EventN(tagRef.domAll, _.onplaying = _)
    def canPlayThrough(implicit js: Js[T]): EventN[org.scalajs.dom.Event] =
      new EventN(tagRef.domAll, _.oncanplaythrough = _)
    def abort(implicit js: Js[T]): EventN[UIEvent] =
      new EventN(tagRef.domAll, _.onabort = _)
    def readyStateChange(implicit js: Js[T]): EventN[org.scalajs.dom.Event] =
      new EventN(tagRef.domAll, _.onreadystatechange = _)
    def keyPress(implicit js: Js[T]): EventN[KeyboardEvent] =
      new EventN(tagRef.domAll, _.onkeypress = _)
    def loadedData(implicit js: Js[T]): EventN[org.scalajs.dom.Event] =
      new EventN(tagRef.domAll, _.onloadeddata = _)
    def suspend(implicit js: Js[T]): EventN[org.scalajs.dom.Event] =
      new EventN(tagRef.domAll, _.onsuspend = _)
    def focus(implicit js: Js[T]): EventN[FocusEvent] =
      new EventN(tagRef.domAll, _.onfocus = _)
    def timeUpdate(implicit js: Js[T]): EventN[org.scalajs.dom.Event] =
      new EventN(tagRef.domAll, _.ontimeupdate = _)
    def select(implicit js: Js[T]): EventN[UIEvent] =
      new EventN(tagRef.domAll, _.onselect = _)
    def drop(implicit js: Js[T]): EventN[DragEvent] =
      new EventN(tagRef.domAll, _.ondrop = _)
    def mouseOut(implicit js: Js[T]): EventN[MouseEvent] =
      new EventN(tagRef.domAll, _.onmouseout = _)
    def ended(implicit js: Js[T]): EventN[org.scalajs.dom.Event] =
      new EventN(tagRef.domAll, _.onended = _)
    def scroll(implicit js: Js[T]): EventN[UIEvent] =
      new EventN(tagRef.domAll, _.onscroll = _)
    def mouseWheel(implicit js: Js[T]): EventN[WheelEvent] =
      new EventN(tagRef.domAll, _.onmousewheel = _)
    def volumeChange(implicit js: Js[T]): EventN[org.scalajs.dom.Event] =
      new EventN(tagRef.domAll, _.onvolumechange = _)
    def input(implicit js: Js[T]): EventN[org.scalajs.dom.Event] =
      new EventN(tagRef.domAll, _.oninput = _)
  }

  implicit class AttributeExtensions[T <: Singleton, G](attribute: Attribute[T, G, _]) {
    /** TODO Introduce BooleanAttribute and StringAttribute for better type-safety? */
    def get(implicit js: Js[T]): G =
      if (HtmlHelpers.BooleanAttributes.contains(attribute.name))
        attribute.parent.dom.hasAttribute(attribute.name).asInstanceOf[G]
      else Option(attribute.parent.dom.getAttribute(attribute.name)).asInstanceOf[G]
  }
}
