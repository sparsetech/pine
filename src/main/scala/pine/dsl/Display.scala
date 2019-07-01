package pine.dsl

sealed abstract class Display(val css: String) {
  def property: String = "display: " + css
}

object Display {
  case object Block extends Display("block")
  case object None extends Display("none")
}
