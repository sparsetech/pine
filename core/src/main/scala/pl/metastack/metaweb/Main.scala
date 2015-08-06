package pl.metastack.metaweb

import pl.metastack.metarx.Var

import pl.metastack.metaweb.Macro._

object Main extends App {
  val url = Var("http://github.com/")
  val title = Var("GitHub")
  val parsedHtml = html"""<a href=$url>$title</a>"""

  // translates into:
  // val root = tag.a()
  // root.bind("href", url)
  // root += Text(title)

  parsedHtml.head match {
    case root: tag.a =>
      println(s"Current URL: ${root.href}")
      root.toHtmlLive.attach(html => println(s"HTML changed to: $html"))

      url := "http://google.com/"
      title := "Google"
      root.clear()
  }
}