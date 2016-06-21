package example

import pl.metastack.metarouter.InstantiatedRoute
import pl.metastack.metaweb._
import pl.metastack.metaweb.diff.Diff
import pl.metastack.metaweb.macros.Js
import shapeless.HList

trait Routing { this: Page =>
  @Js override def register(): Diff =
    Window.popState.subscribe(_ =>
      destroy() :+ Router.renderPage(Router.resolvePage()))

  @Js def redirect[R <: HList, L <: HList](route: InstantiatedRoute[R, L]): Diff =
    destroy() :+
      // TODO optimise
      Router.renderPage(Routes.instantiate(route.url()).get) :+
      Router.replaceUrl(route.url())
}
