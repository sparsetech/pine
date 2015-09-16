
    package pl.metastack.metaweb.view
    import pl.metastack.metaweb._
    object NumberGuess {
      class Message(base: NumberGuess) extends tag.H5 {
            attribute("id") := "message"
            
          }
class Input(base: NumberGuess) extends tag.Input {
            attribute("id") := "input"
attribute("type") := "number"
            
          }
class Guess(base: NumberGuess) extends tag.Button {
            attribute("id") := "guess"
attribute("type") := "submit"
            append(tree.Text("Guess"))
          }
class Reset(base: NumberGuess) extends tag.Button {
            attribute("id") := "reset"
attribute("type") := "button"
            append(tree.Text("Reset"))
          }
class Form(base: NumberGuess) extends tag.Form {
            attribute("onsubmit") := "return false"
attribute("id") := "form"
            append(tree.Text(" "))
append(base.input)
append(tree.Text(" "))
append(base.guess)
append(tree.Text(" "))
append(base.reset)
append(tree.Text(" "))
          }
    }
    class NumberGuess {
            val message = new NumberGuess.Message(this)
val input = new NumberGuess.Input(this)
val guess = new NumberGuess.Guess(this)
val reset = new NumberGuess.Reset(this)
val form = new NumberGuess.Form(this)
            val base = this
            val view = new tag.Html {
            
            append(tree.Text(" "))
append(new tag.Head {
            
            append(tree.Text(" "))
append(new tag.Meta {
            attribute("charset") := "utf-8"
            
          })
append(tree.Text(" "))
append(new tag.Title {
            
            append(tree.Text("MetaWeb example"))
          })
append(tree.Text(" "))
          })
append(tree.Text(" "))
append(new tag.Body {
            
            append(tree.Text(" "))
append(new tag.H1 {
            
            append(tree.Text("Number Guess Example"))
          })
append(tree.Text(" "))
append(base.message)
append(tree.Text(" "))
append(base.form)
append(tree.Text(" "))
          })
append(tree.Text(" "))
          }
          }
          
    