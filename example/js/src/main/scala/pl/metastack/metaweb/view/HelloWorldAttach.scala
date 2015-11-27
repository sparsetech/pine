
    package pl.metastack.metaweb.view
    import org.scalajs.dom
    import pl.metastack.metaweb._
    class HelloWorldAttach extends HelloWorld {
      override val head = render.DOM.proxy[tag.Head](dom.document.head)
      override val body = render.DOM.proxy[tag.Body](dom.document.body)
      override val numberguess = body.byId[tag.Button]("numberguess")
    }
    