
    package pl.metastack.metaweb.view
    import org.scalajs.dom
    import pl.metastack.metaweb._
    class NumberGuessAttach extends NumberGuess {
      override val head = render.DOM.proxy[tag.Head](dom.document.head)
      override val body = render.DOM.proxy[tag.Body](dom.document.body)
      override val reset = body.byId[tag.Button]("reset")
override val message = body.byId[tag.H5]("message")
override val guess = body.byId[tag.Button]("guess")
override val form = body.byId[tag.Form]("form")
override val input = body.byId[tag.Input]("input")
    }
    