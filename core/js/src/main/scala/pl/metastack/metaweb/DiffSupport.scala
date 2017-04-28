package pl.metastack.metaweb

import scala.scalajs.js
import org.scalajs.dom.ext.KeyCode
import pl.metastack.metaweb.diff._

trait Js[T <: tree.Tag] { type X <: org.scalajs.dom.html.Element }

trait DiffSupportLowPrio {
  implicit object JsTag extends Js[tree.Tag] { override type X = org.scalajs.dom.html.Element }
}

trait DiffSupport extends DiffSupportLowPrio {
  implicit object JsA extends Js[tag.A] { override type X = org.scalajs.dom.html.Anchor }
  implicit object JsB extends Js[tag.B] { override type X = org.scalajs.dom.html.Span }
  implicit object JsApplet extends Js[tag.Applet] { override type X = org.scalajs.dom.html.Applet }
  implicit object JsArea extends Js[tag.Area] { override type X = org.scalajs.dom.html.Area }
  implicit object JsAudio extends Js[tag.Audio] { override type X = org.scalajs.dom.html.Audio }
  implicit object JsBR extends Js[tag.Br] { override type X = org.scalajs.dom.html.BR }
  implicit object JsBase extends Js[tag.Base] { override type X = org.scalajs.dom.html.Base }
  implicit object JsBaseFont extends Js[tag.Basefont] { override type X = org.scalajs.dom.html.BaseFont }
  implicit object JsBody extends Js[tag.Body] { override type X = org.scalajs.dom.html.Body }
  implicit object JsButton extends Js[tag.Button] { override type X = org.scalajs.dom.html.Button }
  implicit object JsCanvas extends Js[tag.Canvas] { override type X = org.scalajs.dom.html.Canvas }
  // implicit object JsCollection extends Js[tag.Col] { override type X = org.scalajs.dom.html.Collection }
  implicit object JsDD extends Js[tag.Dd] { override type X = org.scalajs.dom.html.DD }
  implicit object JsDList extends Js[tag.Dl] { override type X = org.scalajs.dom.html.DList }
  implicit object JsDT extends Js[tag.Dt] { override type X = org.scalajs.dom.html.DT }
  implicit object JsDataList extends Js[tag.Datalist] { override type X = org.scalajs.dom.html.DataList }
  implicit object JsDirectory extends Js[tag.Dir] { override type X = org.scalajs.dom.html.Directory }
  implicit object JsDiv extends Js[tag.Div] { override type X = org.scalajs.dom.html.Div }
  implicit object JsElement extends Js[tag.HTMLTag] { override type X = org.scalajs.dom.html.Element }
  implicit object JsEmbed extends Js[tag.Embed] { override type X = org.scalajs.dom.html.Embed }
  implicit object JsFieldSet extends Js[tag.Fieldset] { override type X = org.scalajs.dom.html.FieldSet }
  implicit object JsForm extends Js[tag.Form] { override type X = org.scalajs.dom.html.Form }
  implicit object JsFrame extends Js[tag.Frame] { override type X = org.scalajs.dom.html.Frame }
  implicit object JsFrameSet extends Js[tag.Frameset] { override type X = org.scalajs.dom.html.FrameSet }
  implicit object JsH1 extends Js[tag.H1] { override type X = org.scalajs.dom.html.Heading }
  implicit object JsH2 extends Js[tag.H2] { override type X = org.scalajs.dom.html.Heading }
  implicit object JsH3 extends Js[tag.H3] { override type X = org.scalajs.dom.html.Heading }
  implicit object JsH4 extends Js[tag.H4] { override type X = org.scalajs.dom.html.Heading }
  implicit object JsH5 extends Js[tag.H5] { override type X = org.scalajs.dom.html.Heading }
  implicit object JsH6 extends Js[tag.H6] { override type X = org.scalajs.dom.html.Heading }
  implicit object JsHR extends Js[tag.Hr] { override type X = org.scalajs.dom.html.HR }
  implicit object JsHead extends Js[tag.Head] { override type X = org.scalajs.dom.html.Head }
  implicit object JsHtml extends Js[tag.Html] { override type X = org.scalajs.dom.html.Html }
  implicit object JsI extends Js[tag.I] { override type X = org.scalajs.dom.html.Span }
  implicit object JsIFrame extends Js[tag.Iframe] { override type X = org.scalajs.dom.html.IFrame }
  implicit object JsImage extends Js[tag.Img] { override type X = org.scalajs.dom.html.Image }
  implicit object JsInput extends Js[tag.Input] { override type X = org.scalajs.dom.html.Input }
  implicit object JsIsIndex extends Js[tag.Isindex] { override type X = org.scalajs.dom.html.IsIndex }
  implicit object JsLabel extends Js[tag.Label] { override type X = org.scalajs.dom.html.Label }
  implicit object JsLegend extends Js[tag.Legend] { override type X = org.scalajs.dom.html.Legend }
  implicit object JsLi extends Js[tag.Li] { override type X = org.scalajs.dom.html.LI }
  implicit object JsLink extends Js[tag.Link] { override type X = org.scalajs.dom.html.Link }
  implicit object JsMapJS extends Js[tag.Map] { override type X = org.scalajs.dom.html.Map }
  implicit object JsMenu extends Js[tag.Menu] { override type X = org.scalajs.dom.html.Menu }
  implicit object JsMeta extends Js[tag.Meta] { override type X = org.scalajs.dom.html.Meta }
  implicit object JsOList extends Js[tag.Ol] { override type X = org.scalajs.dom.html.OList }
  implicit object JsObject extends Js[tag.Object] { override type X = org.scalajs.dom.html.Object }
  implicit object JsOptGroup extends Js[tag.Optgroup] { override type X = org.scalajs.dom.html.OptGroup }
  implicit object JsOpt extends Js[tag.Option] { override type X = org.scalajs.dom.html.Option }
  implicit object JsParagraph extends Js[tag.P] { override type X = org.scalajs.dom.html.Paragraph }
  implicit object JsParam extends Js[tag.Param] { override type X = org.scalajs.dom.html.Param }
  implicit object JsPre extends Js[tag.Pre] { override type X = org.scalajs.dom.html.Pre }
  implicit object JsProgress extends Js[tag.Progress] { override type X = org.scalajs.dom.html.Progress }
  implicit object JsScript extends Js[tag.Script] { override type X = org.scalajs.dom.html.Script }
  implicit object JsSelect extends Js[tag.Select] { override type X = org.scalajs.dom.html.Select }
  implicit object JsSource extends Js[tag.Source] { override type X = org.scalajs.dom.html.Source }
  implicit object JsSpan extends Js[tag.Span] { override type X = org.scalajs.dom.html.Span }
  implicit object JsStrong extends Js[tag.Strong] { override type X = org.scalajs.dom.html.Span }
  implicit object JsStrike extends Js[tag.Strike] { override type X = org.scalajs.dom.html.Span }
  implicit object JsStyle extends Js[tag.Style] { override type X = org.scalajs.dom.html.Style }
  implicit object JsTable extends Js[tag.Table] { override type X = org.scalajs.dom.html.Table }
  implicit object JsTableRow extends Js[tag.Tr] { override type X = org.scalajs.dom.html.TableRow }
  implicit object JsTableDataCell extends Js[tag.Td] { override type X = org.scalajs.dom.html.TableDataCell }
  implicit object JsTableHeadCell extends Js[tag.Th] { override type X = org.scalajs.dom.html.TableHeaderCell }
  implicit object JsTextArea extends Js[tag.Textarea] { override type X = org.scalajs.dom.html.TextArea }
  implicit object JsTitle extends Js[tag.Title] { override type X = org.scalajs.dom.html.Title }
  implicit object JsTrack extends Js[tag.Track] { override type X = org.scalajs.dom.html.Track }
  implicit object JsUl extends Js[tag.Ul] { override type X = org.scalajs.dom.html.UList }
  implicit object JsVideo extends Js[tag.Video] { override type X = org.scalajs.dom.html.Video }

  object Window {
    def dragEnd: DomEvent[org.scalajs.dom.DragEvent] =
      new DomEvent(org.scalajs.dom.window.ondragend = _)
    def keyDown: DomEvent[org.scalajs.dom.KeyboardEvent] =
      new DomEvent(org.scalajs.dom.window.onkeydown = _)
    def dragOver: DomEvent[org.scalajs.dom.DragEvent] =
      new DomEvent(org.scalajs.dom.window.ondragover = _)
    def keyUp: DomEvent[org.scalajs.dom.KeyboardEvent] =
      new DomEvent(org.scalajs.dom.window.onkeyup = _)
    def reset: DomEvent[org.scalajs.dom.Event] =
      new DomEvent(org.scalajs.dom.window.onreset = _)
    def mouseUp: DomEvent[org.scalajs.dom.MouseEvent] =
      new DomEvent(org.scalajs.dom.window.onmouseup = _)
    def dragStart: DomEvent[org.scalajs.dom.DragEvent] =
      new DomEvent(org.scalajs.dom.window.ondragstart = _)
    def drag: DomEvent[org.scalajs.dom.DragEvent] =
      new DomEvent(org.scalajs.dom.window.ondrag = _)
    def mouseOver: DomEvent[org.scalajs.dom.MouseEvent] =
      new DomEvent(org.scalajs.dom.window.onmouseover = _)
    def dragLeave: DomEvent[org.scalajs.dom.DragEvent] =
      new DomEvent(org.scalajs.dom.window.ondragleave = _)
    def afterPrint: DomEvent[org.scalajs.dom.Event] =
      new DomEvent(org.scalajs.dom.window.onafterprint = _)
    def pause: DomEvent[org.scalajs.dom.Event] =
      new DomEvent(org.scalajs.dom.window.onpause = _)
    def beforePrint: DomEvent[org.scalajs.dom.Event] =
      new DomEvent(org.scalajs.dom.window.onbeforeprint = _)
    def mouseDown: DomEvent[org.scalajs.dom.MouseEvent] =
      new DomEvent(org.scalajs.dom.window.onmousedown = _)
    def seeked: DomEvent[org.scalajs.dom.Event] =
      new DomEvent(org.scalajs.dom.window.onseeked = _)
    def click: DomEvent[org.scalajs.dom.MouseEvent] =
      new DomEvent(org.scalajs.dom.window.onclick = _)
    def waiting: DomEvent[org.scalajs.dom.Event] =
      new DomEvent(org.scalajs.dom.window.onwaiting = _)
    def online: DomEvent[org.scalajs.dom.Event] =
      new DomEvent(org.scalajs.dom.window.ononline = _)
    def durationChange: DomEvent[org.scalajs.dom.Event] =
      new DomEvent(org.scalajs.dom.window.ondurationchange = _)
    def blur: DomEvent[org.scalajs.dom.FocusEvent] =
      new DomEvent(org.scalajs.dom.window.onblur = _)
    def emptied: DomEvent[org.scalajs.dom.Event] =
      new DomEvent(org.scalajs.dom.window.onemptied = _)
    def seeking: DomEvent[org.scalajs.dom.Event] =
      new DomEvent(org.scalajs.dom.window.onseeking = _)
    def canPlay: DomEvent[org.scalajs.dom.Event] =
      new DomEvent(org.scalajs.dom.window.oncanplay = _)
    def stalled: DomEvent[org.scalajs.dom.Event] =
      new DomEvent(org.scalajs.dom.window.onstalled = _)
    def mouseMove: DomEvent[org.scalajs.dom.MouseEvent] =
      new DomEvent(org.scalajs.dom.window.onmousemove = _)
    def offline: DomEvent[org.scalajs.dom.Event] =
      new DomEvent(org.scalajs.dom.window.onoffline = _)
    def beforeUnload: DomEvent[org.scalajs.dom.BeforeUnloadEvent] =
      new DomEvent(org.scalajs.dom.window.onbeforeunload = _)
    def rateChange: DomEvent[org.scalajs.dom.Event] =
      new DomEvent(org.scalajs.dom.window.onratechange = _)
    def storage: DomEvent[org.scalajs.dom.StorageEvent] =
      new DomEvent(org.scalajs.dom.window.onstorage = _)
    def loadStart: DomEvent[org.scalajs.dom.Event] =
      new DomEvent(org.scalajs.dom.window.onloadstart = _)
    def dragEnter: DomEvent[org.scalajs.dom.DragEvent] =
      new DomEvent(org.scalajs.dom.window.ondragenter = _)
    def submit: DomEvent[org.scalajs.dom.Event] =
      new DomEvent(org.scalajs.dom.window.onsubmit = _)
    // def progress: DomEventHandler[scala.scalajs.js.Any] =
    //   new DomEventHandler(org.scalajs.dom.window.onprogress = _)
    def dblClick: DomEvent[org.scalajs.dom.MouseEvent] =
      new DomEvent(org.scalajs.dom.window.ondblclick = _)
    def contextMenu: DomEvent[org.scalajs.dom.MouseEvent] =
      new DomEvent(org.scalajs.dom.window.oncontextmenu = _)
    def change: DomEvent[org.scalajs.dom.Event] =
      new DomEvent(org.scalajs.dom.window.onchange = _)
    def loadedMetadata: DomEvent[org.scalajs.dom.Event] =
      new DomEvent(org.scalajs.dom.window.onloadedmetadata = _)
    def play: DomEvent[org.scalajs.dom.Event] =
      new DomEvent(org.scalajs.dom.window.onplay = _)
    // def error: DomEventHandler[org.scalajs.dom.Event] =
    //   new DomEventHandler(org.scalajs.dom.window.onerror = _)
    def playing: DomEvent[org.scalajs.dom.Event] =
      new DomEvent(org.scalajs.dom.window.onplaying = _)
    def canPlayThrough: DomEvent[org.scalajs.dom.Event] =
      new DomEvent(org.scalajs.dom.window.oncanplaythrough = _)
    def abort: DomEvent[org.scalajs.dom.UIEvent] =
      new DomEvent(org.scalajs.dom.window.onabort = _)
    def readyStateChange: DomEvent[org.scalajs.dom.Event] =
      new DomEvent(org.scalajs.dom.window.onreadystatechange = _)
    def keyPress: DomEvent[org.scalajs.dom.KeyboardEvent] =
      new DomEvent(org.scalajs.dom.window.onkeypress = _)
    def loadedData: DomEvent[org.scalajs.dom.Event] =
      new DomEvent(org.scalajs.dom.window.onloadeddata = _)
    def suspend: DomEvent[org.scalajs.dom.Event] =
      new DomEvent(org.scalajs.dom.window.onsuspend = _)
    def focus: DomEvent[org.scalajs.dom.FocusEvent] =
      new DomEvent(org.scalajs.dom.window.onfocus = _)
    def message: DomEvent[org.scalajs.dom.MessageEvent] =
      new DomEvent(org.scalajs.dom.window.onmessage = _)
    def timeUpdate: DomEvent[org.scalajs.dom.Event] =
      new DomEvent(org.scalajs.dom.window.ontimeupdate = _)
    def resize: DomEvent[org.scalajs.dom.UIEvent] =
      new DomEvent(org.scalajs.dom.window.onresize = _)
    def select: DomEvent[org.scalajs.dom.UIEvent] =
      new DomEvent(org.scalajs.dom.window.onselect = _)
    def drop: DomEvent[org.scalajs.dom.DragEvent] =
      new DomEvent(org.scalajs.dom.window.ondrop = _)
    def mouseOut: DomEvent[org.scalajs.dom.MouseEvent] =
      new DomEvent(org.scalajs.dom.window.onmouseout = _)
    def ended: DomEvent[org.scalajs.dom.Event] =
      new DomEvent(org.scalajs.dom.window.onended = _)
    def hashChange: DomEvent[org.scalajs.dom.HashChangeEvent] =
      new DomEvent(org.scalajs.dom.window.onhashchange = _)
    def unload: DomEvent[org.scalajs.dom.Event] =
      new DomEvent(org.scalajs.dom.window.onunload = _)
    def scroll: DomEvent[org.scalajs.dom.UIEvent] =
      new DomEvent(org.scalajs.dom.window.onscroll = _)
    def mouseWheel: DomEvent[org.scalajs.dom.WheelEvent] =
      new DomEvent(org.scalajs.dom.window.onmousewheel = _)
    def load: DomEvent[org.scalajs.dom.Event] =
      new DomEvent(org.scalajs.dom.window.onload = _)
    def volumeChange: DomEvent[org.scalajs.dom.Event] =
      new DomEvent(org.scalajs.dom.window.onvolumechange = _)
    def input: DomEvent[org.scalajs.dom.Event] =
      new DomEvent(org.scalajs.dom.window.oninput = _)
    def popState: DomEvent[org.scalajs.dom.PopStateEvent] =
      new DomEvent(org.scalajs.dom.window.onpopstate = _)
  }

  class DomEvent[T <: org.scalajs.dom.Event](set: js.Function1[T, _] => Unit) {
    def set(f: => Unit): DomDiff = DomDiff.SetEvent(set, (_: T) => f)
    def set(f: T => Unit): DomDiff = DomDiff.SetEvent(set, f)

    def detach(): DomDiff = DomDiff.DetachEvent(set)

    def :=(diff: => Unit): DomDiff = set(diff)
    def :=(diff: T => Unit): DomDiff = set(diff)
  }

  implicit class NodeRefExtensions[T <: tree.Tag](nodeRef: NodeRef[T]) {
    def onEnter(f: String => Diff)(implicit js: Js[T], ev: T <:< tag.Input): DomDiff =
      nodeRef.keyPress := { e =>
        if (e.keyCode == KeyCode.Enter)
          f(DOM.get(nodeRef).asInstanceOf[org.scalajs.dom.html.Input].value)
        else Diff.Noop
      }

    def click(implicit js: Js[T]): DomEvent[org.scalajs.dom.MouseEvent] =
      new DomEvent(DOM.get(nodeRef).onclick = _)

    def keyPress(implicit js: Js[T]): DomEvent[org.scalajs.dom.KeyboardEvent] =
      new DomEvent(DOM.get(nodeRef).onkeypress = _)

    def submit(implicit js: Js[T]): DomEvent[org.scalajs.dom.Event] =
      new DomEvent(DOM.get(nodeRef).onsubmit = _)

    def change(implicit js: Js[T]): DomEvent[org.scalajs.dom.Event] =
      new DomEvent(DOM.get(nodeRef).onchange = _)
  }
}
