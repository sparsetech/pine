package pine.bench

import java.text.DecimalFormat

import org.openjdk.jol.info.GraphLayout

object PlatformUtil {
  private val decimalFormat = new DecimalFormat("0.0")

  def cliArgs(): List[String] = List()
  def format(value: Double): String = decimalFormat.format(value)
  def measure(obj: Any): Long =
    GraphLayout.parseInstance(obj.asInstanceOf[Object]).totalSize()
}
