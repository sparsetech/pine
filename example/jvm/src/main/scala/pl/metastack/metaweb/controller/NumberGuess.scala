package pl.metastack.metaweb.controller

import org.hyperscala.Tag
import org.hyperscala.html.tag
import org.hyperscala.ui.dynamic.DynamicTag
import org.hyperscala.web.Webpage

import pl.metastack.metaweb._

import pl.metastack.metaweb.numberguess.ViewBase

class NumberGuess extends Webpage {
  val view = new ViewBase{}.view

  val b = view.byTag[state.Tag]("body")
  b += html"""<script type="text/javascript" src="/sjs/example-fastopt.js"></script>"""
  b += html"""<script type="text/javascript" src="/sjs/example-launcher.js"></script>"""

  // TODO Serve static HTML
  val parsed = DynamicTag.from[tag.HTML](view.toHtml).create()
  parsed.head.contents.foreach(head.contents += _)
  parsed.body.contents.foreach(body.contents += _)
}