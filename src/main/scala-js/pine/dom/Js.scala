package pine.dom

import org.scalajs.dom
import pine._

trait Js[T <: Singleton] { type X <: dom.Element }

trait JsSvg [T <: Singleton] extends Js[T] { override type X <: dom.svg.Element  }
trait JsHtml[T <: Singleton] extends Js[T] { override type X <: dom.html.Element }

trait JsLowPrio {
  implicit object JsTag extends Js[Singleton] { override type X = dom.Element }
}

object Js extends JsLowPrio {
  implicit object JsA extends JsHtml[tag.A] { override type X = dom.html.Anchor }
  implicit object JsB extends JsHtml[tag.B] { override type X = dom.html.Span }
  implicit object JsArea extends JsHtml[tag.Area] { override type X = dom.html.Area }
  implicit object JsAudio extends JsHtml[tag.Audio] { override type X = dom.html.Audio }
  implicit object JsBR extends JsHtml[tag.Br] { override type X = dom.html.BR }
  implicit object JsBase extends JsHtml[tag.Base] { override type X = dom.html.Base }
  implicit object JsBody extends JsHtml[tag.Body] { override type X = dom.html.Body }
  implicit object JsButton extends JsHtml[tag.Button] { override type X = dom.html.Button }
  implicit object JsCanvas extends JsHtml[tag.Canvas] { override type X = dom.html.Canvas }
  // implicit object JsCollection extends JsHtml[tag.Col] { override type X = dom.html.Collection }
  implicit object JsDList extends JsHtml[tag.Dl] { override type X = dom.html.DList }
  implicit object JsDataList extends JsHtml[tag.Datalist] { override type X = dom.html.DataList }
  implicit object JsDiv extends JsHtml[tag.Div] { override type X = dom.html.Div }
  implicit object JsEmbed extends JsHtml[tag.Embed] { override type X = dom.html.Embed }
  implicit object JsFieldSet extends JsHtml[tag.Fieldset] { override type X = dom.html.FieldSet }
  implicit object JsForm extends JsHtml[tag.Form] { override type X = dom.html.Form }
  implicit object JsH1 extends JsHtml[tag.H1] { override type X = dom.html.Heading }
  implicit object JsH2 extends JsHtml[tag.H2] { override type X = dom.html.Heading }
  implicit object JsH3 extends JsHtml[tag.H3] { override type X = dom.html.Heading }
  implicit object JsH4 extends JsHtml[tag.H4] { override type X = dom.html.Heading }
  implicit object JsH5 extends JsHtml[tag.H5] { override type X = dom.html.Heading }
  implicit object JsH6 extends JsHtml[tag.H6] { override type X = dom.html.Heading }
  implicit object JsHR extends JsHtml[tag.Hr] { override type X = dom.html.HR }
  implicit object JsHead extends JsHtml[tag.Head] { override type X = dom.html.Head }
  implicit object JsHtml extends JsHtml[tag.Html] { override type X = dom.html.Html }
  implicit object JsI extends JsHtml[tag.I] { override type X = dom.html.Span }
  implicit object JsIFrame extends JsHtml[tag.Iframe] { override type X = dom.html.IFrame }
  implicit object JsImage extends JsHtml[tag.Img] { override type X = dom.html.Image }
  implicit object JsInput extends JsHtml[tag.Input] { override type X = dom.html.Input }
  implicit object JsLabel extends JsHtml[tag.Label] { override type X = dom.html.Label }
  implicit object JsLegend extends JsHtml[tag.Legend] { override type X = dom.html.Legend }
  implicit object JsLi extends JsHtml[tag.Li] { override type X = dom.html.LI }
  implicit object JsLink extends JsHtml[tag.Link] { override type X = dom.html.Link }
  implicit object JsMapJS extends JsHtml[tag.Map] { override type X = dom.html.Map }
  implicit object JsMenu extends JsHtml[tag.Menu] { override type X = dom.html.Menu }
  implicit object JsMeta extends JsHtml[tag.Meta] { override type X = dom.html.Meta }
  implicit object JsOList extends JsHtml[tag.Ol] { override type X = dom.html.OList }
  implicit object JsObject extends JsHtml[tag.Object] { override type X = dom.html.Object }
  implicit object JsOptGroup extends JsHtml[tag.Optgroup] { override type X = dom.html.OptGroup }
  implicit object JsOpt extends JsHtml[tag.Option] { override type X = dom.html.Option }
  implicit object JsParagraph extends JsHtml[tag.P] { override type X = dom.html.Paragraph }
  implicit object JsParam extends JsHtml[tag.Param] { override type X = dom.html.Param }
  implicit object JsPre extends JsHtml[tag.Pre] { override type X = dom.html.Pre }
  implicit object JsProgress extends JsHtml[tag.Progress] { override type X = dom.html.Progress }
  implicit object JsScript extends JsHtml[tag.Script] { override type X = dom.html.Script }
  implicit object JsSelect extends JsHtml[tag.Select] { override type X = dom.html.Select }
  implicit object JsSource extends JsHtml[tag.Source] { override type X = dom.html.Source }
  implicit object JsSpan extends JsHtml[tag.Span] { override type X = dom.html.Span }
  implicit object JsStrong extends JsHtml[tag.Strong] { override type X = dom.html.Span }
  implicit object JsStrike extends JsHtml[tag.Strike] { override type X = dom.html.Span }
  implicit object JsStyle extends JsHtml[tag.Style] { override type X = dom.html.Style }
  implicit object JsTable extends JsHtml[tag.Table] { override type X = dom.html.Table }
  implicit object JsTableRow extends JsHtml[tag.Tr] { override type X = dom.html.TableRow }
  implicit object JsTableDataCell extends JsHtml[tag.Td] { override type X = dom.html.TableCell }
  implicit object JsTableHeadCell extends JsHtml[tag.Th] { override type X = dom.html.TableCell }
  implicit object JsTextArea extends JsHtml[tag.Textarea] { override type X = dom.html.TextArea }
  implicit object JsTitle extends JsHtml[tag.Title] { override type X = dom.html.Title }
  implicit object JsTrack extends JsHtml[tag.Track] { override type X = dom.html.Track }
  implicit object JsUl extends JsHtml[tag.Ul] { override type X = dom.html.UList }
  implicit object JsVideo extends JsHtml[tag.Video] { override type X = dom.html.Video }

  implicit object JsSvg extends JsSvg[tag.Svg] { override type X = dom.svg.SVG }
}
