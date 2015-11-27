
    package pl.metastack.metaweb.view
    import pl.metastack.metaweb._
    object HelloWorld {
      class Numberguess extends tag.Button { self =>
      
      attribute("id") := "numberguess"
      append(tree.Text("Number guess"))
    }
    }
    
          trait HelloWorld {
            def numberguess: tag.Button
            def head: tag.Head
            def body: tag.Body
          }
          class HelloWorldRender extends HelloWorld { self =>
            val numberguess = new HelloWorld.Numberguess
            
            override val head = new tag.Head {
      
      
      append(tree.Text(" "))
append(new tag.Meta {
      
      attribute("charset") := "utf-8"
      
    })
append(tree.Text(" "))
append(new tag.Title {
      
      
      append(tree.Text("MetaWeb example"))
    })
append(tree.Text(" "))
    }
            override val body = new tag.Body {
      
      
      append(tree.Text(" "))
append(new tag.H1 {
      
      
      append(tree.Text("Hello World"))
    })
append(tree.Text(" "))
append(self.numberguess)
append(tree.Text(" "))
    }
          }
          
    