
    package pl.metastack.metaweb.view
    import pl.metastack.metaweb._
    object NumberGuess {
      class Message extends tag.H5 { self =>
      
      attribute("id") := "message"
      
    }
class Input extends tag.Input { self =>
      
      attribute("id") := "input"
attribute("type") := "number"
      
    }
class Guess extends tag.Button { self =>
      
      attribute("id") := "guess"
attribute("type") := "submit"
      append(tree.Text("Guess"))
    }
class Reset extends tag.Button { self =>
      
      attribute("id") := "reset"
attribute("type") := "button"
      append(tree.Text("Reset"))
    }
class Form extends tag.Form { self =>
      val input = new NumberGuess.Input
val guess = new NumberGuess.Guess
val reset = new NumberGuess.Reset
      attribute("onsubmit") := "return false"
attribute("id") := "form"
      append(tree.Text(" "))
append(self.input)
append(tree.Text(" "))
append(self.guess)
append(tree.Text(" "))
append(self.reset)
append(tree.Text(" "))
    }
    }
    
          trait NumberGuess {
            def reset: tag.Button
def message: tag.H5
def guess: tag.Button
def form: tag.Form
def input: tag.Input
            def head: tag.Head
            def body: tag.Body
          }
          class NumberGuessRender extends NumberGuess { self =>
            val message = new NumberGuess.Message
val form = new NumberGuess.Form
            val reset = form.reset
val guess = form.guess
val input = form.input
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
      
      
      append(tree.Text("Number Guess Example"))
    })
append(tree.Text(" "))
append(self.message)
append(tree.Text(" "))
append(self.form)
append(tree.Text(" "))
    }
          }
          
    