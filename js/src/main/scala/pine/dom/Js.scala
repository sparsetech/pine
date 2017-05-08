package pine.dom

import org.scalajs.dom
import pine._

trait Js[T <: Tag] { type X <: dom.html.Element }

trait JsLowPrio {
  implicit object JsTag extends Js[Tag] { override type X = dom.html.Element }
}

object Js extends JsLowPrio {
  implicit object JsA extends Js[tag.A] { override type X = dom.html.Anchor }
  implicit object JsB extends Js[tag.B] { override type X = dom.html.Span }
  implicit object JsApplet extends Js[tag.Applet] { override type X = dom.html.Applet }
  implicit object JsArea extends Js[tag.Area] { override type X = dom.html.Area }
  implicit object JsAudio extends Js[tag.Audio] { override type X = dom.html.Audio }
  implicit object JsBR extends Js[tag.Br] { override type X = dom.html.BR }
  implicit object JsBase extends Js[tag.Base] { override type X = dom.html.Base }
  implicit object JsBaseFont extends Js[tag.Basefont] { override type X = dom.html.BaseFont }
  implicit object JsBody extends Js[tag.Body] { override type X = dom.html.Body }
  implicit object JsButton extends Js[tag.Button] { override type X = dom.html.Button }
  implicit object JsCanvas extends Js[tag.Canvas] { override type X = dom.html.Canvas }
  // implicit object JsCollection extends Js[tag.Col] { override type X = dom.html.Collection }
  implicit object JsDD extends Js[tag.Dd] { override type X = dom.html.DD }
  implicit object JsDList extends Js[tag.Dl] { override type X = dom.html.DList }
  implicit object JsDT extends Js[tag.Dt] { override type X = dom.html.DT }
  implicit object JsDataList extends Js[tag.Datalist] { override type X = dom.html.DataList }
  implicit object JsDirectory extends Js[tag.Dir] { override type X = dom.html.Directory }
  implicit object JsDiv extends Js[tag.Div] { override type X = dom.html.Div }
  implicit object JsElement extends Js[tag.HTMLTag] { override type X = dom.html.Element }
  implicit object JsEmbed extends Js[tag.Embed] { override type X = dom.html.Embed }
  implicit object JsFieldSet extends Js[tag.Fieldset] { override type X = dom.html.FieldSet }
  implicit object JsForm extends Js[tag.Form] { override type X = dom.html.Form }
  implicit object JsFrame extends Js[tag.Frame] { override type X = dom.html.Frame }
  implicit object JsFrameSet extends Js[tag.Frameset] { override type X = dom.html.FrameSet }
  implicit object JsH1 extends Js[tag.H1] { override type X = dom.html.Heading }
  implicit object JsH2 extends Js[tag.H2] { override type X = dom.html.Heading }
  implicit object JsH3 extends Js[tag.H3] { override type X = dom.html.Heading }
  implicit object JsH4 extends Js[tag.H4] { override type X = dom.html.Heading }
  implicit object JsH5 extends Js[tag.H5] { override type X = dom.html.Heading }
  implicit object JsH6 extends Js[tag.H6] { override type X = dom.html.Heading }
  implicit object JsHR extends Js[tag.Hr] { override type X = dom.html.HR }
  implicit object JsHead extends Js[tag.Head] { override type X = dom.html.Head }
  implicit object JsHtml extends Js[tag.Html] { override type X = dom.html.Html }
  implicit object JsI extends Js[tag.I] { override type X = dom.html.Span }
  implicit object JsIFrame extends Js[tag.Iframe] { override type X = dom.html.IFrame }
  implicit object JsImage extends Js[tag.Img] { override type X = dom.html.Image }
  implicit object JsInput extends Js[tag.Input] { override type X = dom.html.Input }
  implicit object JsIsIndex extends Js[tag.Isindex] { override type X = dom.html.IsIndex }
  implicit object JsLabel extends Js[tag.Label] { override type X = dom.html.Label }
  implicit object JsLegend extends Js[tag.Legend] { override type X = dom.html.Legend }
  implicit object JsLi extends Js[tag.Li] { override type X = dom.html.LI }
  implicit object JsLink extends Js[tag.Link] { override type X = dom.html.Link }
  implicit object JsMapJS extends Js[tag.Map] { override type X = dom.html.Map }
  implicit object JsMenu extends Js[tag.Menu] { override type X = dom.html.Menu }
  implicit object JsMeta extends Js[tag.Meta] { override type X = dom.html.Meta }
  implicit object JsOList extends Js[tag.Ol] { override type X = dom.html.OList }
  implicit object JsObject extends Js[tag.Object] { override type X = dom.html.Object }
  implicit object JsOptGroup extends Js[tag.Optgroup] { override type X = dom.html.OptGroup }
  implicit object JsOpt extends Js[tag.Option] { override type X = dom.html.Option }
  implicit object JsParagraph extends Js[tag.P] { override type X = dom.html.Paragraph }
  implicit object JsParam extends Js[tag.Param] { override type X = dom.html.Param }
  implicit object JsPre extends Js[tag.Pre] { override type X = dom.html.Pre }
  implicit object JsProgress extends Js[tag.Progress] { override type X = dom.html.Progress }
  implicit object JsScript extends Js[tag.Script] { override type X = dom.html.Script }
  implicit object JsSelect extends Js[tag.Select] { override type X = dom.html.Select }
  implicit object JsSource extends Js[tag.Source] { override type X = dom.html.Source }
  implicit object JsSpan extends Js[tag.Span] { override type X = dom.html.Span }
  implicit object JsStrong extends Js[tag.Strong] { override type X = dom.html.Span }
  implicit object JsStrike extends Js[tag.Strike] { override type X = dom.html.Span }
  implicit object JsStyle extends Js[tag.Style] { override type X = dom.html.Style }
  implicit object JsTable extends Js[tag.Table] { override type X = dom.html.Table }
  implicit object JsTableRow extends Js[tag.Tr] { override type X = dom.html.TableRow }
  implicit object JsTableDataCell extends Js[tag.Td] { override type X = dom.html.TableDataCell }
  implicit object JsTableHeadCell extends Js[tag.Th] { override type X = dom.html.TableHeaderCell }
  implicit object JsTextArea extends Js[tag.Textarea] { override type X = dom.html.TextArea }
  implicit object JsTitle extends Js[tag.Title] { override type X = dom.html.Title }
  implicit object JsTrack extends Js[tag.Track] { override type X = dom.html.Track }
  implicit object JsUl extends Js[tag.Ul] { override type X = dom.html.UList }
  implicit object JsVideo extends Js[tag.Video] { override type X = dom.html.Video }
}
