package example

import pl.metastack.metaweb._
import pl.metastack.metaweb.diff.Diff
import pl.metastack.metaweb.macros.Js

trait Routing { this: Page =>
  @Js override def register(): Diff =
    Window.popState.subscribe(_ =>
      destroy() :+ Router.renderPage(Router.resolvePage()))

  @Js def redirect(page: Page, url: String): Diff =
    destroy() :+
      Router.renderPage(page) :+
      Router.replaceUrl(url)
}
