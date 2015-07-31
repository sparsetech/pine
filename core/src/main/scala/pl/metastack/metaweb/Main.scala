package pl.metastack.metaweb

import pl.metastack.metarx.Var

import pl.metastack.metaweb.Macro._

object Main extends App {
  val url = Var("http://github.com/")
  val title = Var("GitHub")
  val parsedHtml = html"""<a href=$url>$title</a>"""

  // translates into:
  // val root = pl.metastack.metaweb.Tag("a")
  // root.bind("href", url)
  // root += pl.metastack.metaweb.Text(title)

  parsedHtml.head match {
    case root: Tag =>
      root.toHtmlLive.attach(println)

      url := "http://google.com/"
      title := "Google"
      root.clear()
  }
}