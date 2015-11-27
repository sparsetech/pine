
    package pl.metastack.metaweb.view
    import org.scalajs.dom
    import pl.metastack.metaweb._
    class NumberGuessAttach extends NumberGuess {
      override val head = render.DOM.proxy[tag.Head](dom.document.head)
      override val body = render.DOM.proxy[tag.Body](dom.document.body)
      override val reset = render.DOM.proxy[tag.Button]("reset")
override val message = render.DOM.proxy[tag.H5]("message")
override val guess = render.DOM.proxy[tag.Button]("guess")
override val form = render.DOM.proxy[tag.Form]("form")
override val input = render.DOM.proxy[tag.Input]("input")
    }
    