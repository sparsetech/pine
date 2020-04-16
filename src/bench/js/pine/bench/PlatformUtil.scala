package pine.bench

import scala.scalajs.js
import scala.scalajs.js.JSNumberOps._
import scala.scalajs.js.annotation.JSImport

@js.native
@JSImport("object-sizeof", JSImport.Namespace)
object SizeOf extends js.Object {
  def apply(obj: js.Any): Any = js.native
}

object PlatformUtil {
  def cliArgs(): List[String] =
    if (js.isUndefined(js.Dynamic.global.process)) List()
    else js.Dynamic.global.process.argv.asInstanceOf[js.Array[String]].toList.drop(2)
  def format(value: Double): String = value.toFixed(1)
  def measure(obj: Any): Long =
    SizeOf(obj.asInstanceOf[js.Any]) match {
      case i: Int => i.toLong
      case i: Float => i.toLong  // TODO Should be Long instead of Float
    }
}
