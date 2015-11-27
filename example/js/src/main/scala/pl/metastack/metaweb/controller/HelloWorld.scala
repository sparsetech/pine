package pl.metastack.metaweb.controller

import pl.metastack.metaweb
import pl.metastack.metaweb.Router
import pl.metastack.metaweb.view.NumberGuessRender

class HelloWorld(view: metaweb.view.HelloWorld) {
  view.numberguess.onclick { _ =>
    Router.replaceUrl("http://localhost:8080/numberguess")
    Router.render(new NumberGuess(new NumberGuessRender).view.body)
  }
}
