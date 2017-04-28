package pl.metastack.metaweb

import scala.scalajs.js
import org.scalajs.dom.ext.KeyCode
import pl.metastack.metaweb.diff._

trait DiffSupportLowPrio {
  trait JS[T <: tree.Tag] { type X <: org.scalajs.dom.html.Element }
  implicit object Tag extends JS[tree.Tag] { override type X = org.scalajs.dom.html.Element }
}

trait DiffSupport extends DiffSupportLowPrio {
  implicit object A extends JS[tag.A] { override type X = org.scalajs.dom.html.Anchor }
  implicit object B extends JS[tag.B] { override type X = org.scalajs.dom.html.Span }
  implicit object Applet extends JS[tag.Applet] { override type X = org.scalajs.dom.html.Applet }
  implicit object Area extends JS[tag.Area] { override type X = org.scalajs.dom.html.Area }
  implicit object Audio extends JS[tag.Audio] { override type X = org.scalajs.dom.html.Audio }
  implicit object BR extends JS[tag.Br] { override type X = org.scalajs.dom.html.BR }
  implicit object Base extends JS[tag.Base] { override type X = org.scalajs.dom.html.Base }
  implicit object BaseFont extends JS[tag.Basefont] { override type X = org.scalajs.dom.html.BaseFont }
  implicit object Body extends JS[tag.Body] { override type X = org.scalajs.dom.html.Body }
  implicit object Button extends JS[tag.Button] { override type X = org.scalajs.dom.html.Button }
  implicit object Canvas extends JS[tag.Canvas] { override type X = org.scalajs.dom.html.Canvas }
  // implicit object Collection extends JS[tag.Col] { override type X = org.scalajs.dom.html.Collection }
  implicit object DD extends JS[tag.Dd] { override type X = org.scalajs.dom.html.DD }
  implicit object DList extends JS[tag.Dl] { override type X = org.scalajs.dom.html.DList }
  implicit object DT extends JS[tag.Dt] { override type X = org.scalajs.dom.html.DT }
  implicit object DataList extends JS[tag.Datalist] { override type X = org.scalajs.dom.html.DataList }
  implicit object Directory extends JS[tag.Dir] { override type X = org.scalajs.dom.html.Directory }
  implicit object Div extends JS[tag.Div] { override type X = org.scalajs.dom.html.Div }
  implicit object Element extends JS[tag.HTMLTag] { override type X = org.scalajs.dom.html.Element }
  implicit object Embed extends JS[tag.Embed] { override type X = org.scalajs.dom.html.Embed }
  implicit object FieldSet extends JS[tag.Fieldset] { override type X = org.scalajs.dom.html.FieldSet }
  implicit object Form extends JS[tag.Form] { override type X = org.scalajs.dom.html.Form }
  implicit object Frame extends JS[tag.Frame] { override type X = org.scalajs.dom.html.Frame }
  implicit object FrameSet extends JS[tag.Frameset] { override type X = org.scalajs.dom.html.FrameSet }
  implicit object H1 extends JS[tag.H1] { override type X = org.scalajs.dom.html.Heading }
  implicit object H2 extends JS[tag.H2] { override type X = org.scalajs.dom.html.Heading }
  implicit object H3 extends JS[tag.H3] { override type X = org.scalajs.dom.html.Heading }
  implicit object H4 extends JS[tag.H4] { override type X = org.scalajs.dom.html.Heading }
  implicit object H5 extends JS[tag.H5] { override type X = org.scalajs.dom.html.Heading }
  implicit object H6 extends JS[tag.H6] { override type X = org.scalajs.dom.html.Heading }
  implicit object HR extends JS[tag.Hr] { override type X = org.scalajs.dom.html.HR }
  implicit object Head extends JS[tag.Head] { override type X = org.scalajs.dom.html.Head }
  implicit object Html extends JS[tag.Html] { override type X = org.scalajs.dom.html.Html }
  implicit object I extends JS[tag.I] { override type X = org.scalajs.dom.html.Span }
  implicit object IFrame extends JS[tag.Iframe] { override type X = org.scalajs.dom.html.IFrame }
  implicit object Image extends JS[tag.Img] { override type X = org.scalajs.dom.html.Image }
  implicit object Input extends JS[tag.Input] { override type X = org.scalajs.dom.html.Input }
  implicit object IsIndex extends JS[tag.Isindex] { override type X = org.scalajs.dom.html.IsIndex }
  implicit object Label extends JS[tag.Label] { override type X = org.scalajs.dom.html.Label }
  implicit object Legend extends JS[tag.Legend] { override type X = org.scalajs.dom.html.Legend }
  implicit object Li extends JS[tag.Li] { override type X = org.scalajs.dom.html.LI }
  implicit object Link extends JS[tag.Link] { override type X = org.scalajs.dom.html.Link }
  implicit object Map extends JS[tag.Map] { override type X = org.scalajs.dom.html.Map }
  implicit object Menu extends JS[tag.Menu] { override type X = org.scalajs.dom.html.Menu }
  implicit object Meta extends JS[tag.Meta] { override type X = org.scalajs.dom.html.Meta }
  implicit object OList extends JS[tag.Ol] { override type X = org.scalajs.dom.html.OList }
  implicit object Object extends JS[tag.Object] { override type X = org.scalajs.dom.html.Object }
  implicit object OptGroup extends JS[tag.Optgroup] { override type X = org.scalajs.dom.html.OptGroup }
  implicit object Opt extends JS[tag.Option] { override type X = org.scalajs.dom.html.Option }
  implicit object Paragraph extends JS[tag.P] { override type X = org.scalajs.dom.html.Paragraph }
  implicit object Param extends JS[tag.Param] { override type X = org.scalajs.dom.html.Param }
  implicit object Pre extends JS[tag.Pre] { override type X = org.scalajs.dom.html.Pre }
  implicit object Progress extends JS[tag.Progress] { override type X = org.scalajs.dom.html.Progress }
  implicit object Script extends JS[tag.Script] { override type X = org.scalajs.dom.html.Script }
  implicit object Select extends JS[tag.Select] { override type X = org.scalajs.dom.html.Select }
  implicit object Source extends JS[tag.Source] { override type X = org.scalajs.dom.html.Source }
  implicit object Span extends JS[tag.Span] { override type X = org.scalajs.dom.html.Span }
  implicit object Strong extends JS[tag.Strong] { override type X = org.scalajs.dom.html.Span }
  implicit object Strike extends JS[tag.Strike] { override type X = org.scalajs.dom.html.Span }
  implicit object Style extends JS[tag.Style] { override type X = org.scalajs.dom.html.Style }
  implicit object Table extends JS[tag.Table] { override type X = org.scalajs.dom.html.Table }
  implicit object TableRow extends JS[tag.Tr] { override type X = org.scalajs.dom.html.TableRow }
  implicit object TableDataCell extends JS[tag.Td] { override type X = org.scalajs.dom.html.TableDataCell }
  implicit object TableHeadCell extends JS[tag.Th] { override type X = org.scalajs.dom.html.TableHeaderCell }
  implicit object TextArea extends JS[tag.Textarea] { override type X = org.scalajs.dom.html.TextArea }
  implicit object Title extends JS[tag.Title] { override type X = org.scalajs.dom.html.Title }
  implicit object Track extends JS[tag.Track] { override type X = org.scalajs.dom.html.Track }
  implicit object Ul extends JS[tag.Ul] { override type X = org.scalajs.dom.html.UList }
  implicit object Video extends JS[tag.Video] { override type X = org.scalajs.dom.html.Video }

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
    def attach(f: => Diff): DomDiff = DomDiff.AttachEvent(set, (_: T) => f)
    def attach(f: T => Diff): DomDiff = DomDiff.AttachEvent(set, f)

    def detach(): DomDiff = DomDiff.DetachEvent(set)

    def :=(diff: => Diff): DomDiff = attach(diff)
    def :=(diff: T => Diff): DomDiff = attach(diff)
  }

  /** TODO Introduce BooleanAttribute and StringAttribute for better type-safety? */
  implicit class AttributeExtensions[T <: tree.Tag, G](attribute: Attribute[T, G, _]) {
    def get(implicit js: JS[T]): G =
      if (HtmlHelpers.BooleanAttributes.contains(attribute.name))
        attribute.parent.dom.hasAttribute(attribute.name).asInstanceOf[G]
      else Option(attribute.parent.dom.getAttribute(attribute.name)).asInstanceOf[G]
  }

  implicit class NodeRefExtensions[T <: tree.Tag](nodeRef: NodeRef[T]) {
    def onEnter(f: String => Diff)(implicit js: JS[T], ev: T <:< tag.Input): DomDiff =
      nodeRef.keyPress.attach { e =>
        if (e.keyCode == KeyCode.Enter) f(nodeRef.dom.asInstanceOf[org.scalajs.dom.html.Input].value)
        else Diff.Noop
      }

    /** Underlying DOM node */
    def dom(implicit js: JS[T]): js.X =
      Option(org.scalajs.dom.document.getElementById(nodeRef.id)).getOrElse(
        throw new Exception(s"Node with ID '${nodeRef.id}' not found")
      ).asInstanceOf[js.X]

    def click(implicit js: JS[T]): DomEvent[org.scalajs.dom.MouseEvent] =
      new DomEvent(dom.onclick = _)

    def keyPress(implicit js: JS[T]): DomEvent[org.scalajs.dom.KeyboardEvent] =
      new DomEvent(dom.onkeypress = _)

    def submit(implicit js: JS[T]): DomEvent[org.scalajs.dom.Event] =
      new DomEvent(dom.onsubmit = _)

    def change(implicit js: JS[T]): DomEvent[org.scalajs.dom.Event] =
      new DomEvent(dom.onchange = _)
  }
}
