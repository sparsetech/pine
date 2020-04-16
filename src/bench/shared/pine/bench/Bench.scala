package pine.bench

import scala.collection.mutable.ListBuffer

case class Benchmark[T, U](
  description: String,
  values: List[T],
  f: T => (Long, U),
  measureMemory: Boolean
)

trait BenchmarkSuite {
  private[bench] val benchmarks = ListBuffer[Benchmark[_, _]]()

  def bench[T, U](
    description: String, values: List[T], measureMemory: Boolean
  )(f: T => (Long, U)): Unit =
    benchmarks += Benchmark[T, U](description, values, f, measureMemory)
}

/**
  * @param minimumDuration  Milliseconds for which each benchmark must be run at
  *                         least. This applies to warmup and measurement
  *                         iterations.
  */
case class Profile(
  warmUpIterations: Int,
  measurementIterations: Int,
  minimumDuration: Int,
  garbageCollection: Boolean
)

object BenchmarkRunner {
  val slowProfile = Profile(
    warmUpIterations = 1,
    measurementIterations = 3,
    minimumDuration = 2000,
    garbageCollection = true
  )

  val fastProfile = Profile(
    warmUpIterations = 0,
    measurementIterations = 2,
    minimumDuration = 500,
    garbageCollection = false
  )

  val benchmarkSuites = List(new SharedBench, new PlatformBench)

  case class MeasureResult(
    iterations: Int,
    units: Long,
    unitSize: Long,
    totalSize: Long,
    totalRunTime: Long
  )

  def measure(
    f: () => (Long, Any), profile: Profile, measureSize: Boolean
  ): MeasureResult = {
    if (profile.garbageCollection) System.gc()

    var runTime = 0L
    var iterations = 0
    var unitsCumulative = 0L
    var last: (Long, Any) = (0L, null)  // (units, result)

    while (runTime < profile.minimumDuration) {
      val start = System.currentTimeMillis()
      last = f()
      val end = System.currentTimeMillis()

      runTime += end - start
      unitsCumulative += last._1
      iterations += 1
    }

    val (unitSize, totalSize) =
      if (!measureSize) (0L, 0L)
      else {
        val (units, result) = last
        val totalSize = PlatformUtil.measure(result)
        (totalSize / units, totalSize)
      }

    val units = unitsCumulative / iterations
    MeasureResult(iterations, units, unitSize, totalSize, runTime)
  }

  def main(jvmArgs: Array[String]): Unit = {
    val args = if (jvmArgs.isEmpty) PlatformUtil.cliArgs() else jvmArgs.toList
    val profile =
      if (args.headOption.contains("slow")) slowProfile else fastProfile

    import profile._
    println(f"Warm up iterations:     $warmUpIterations")
    println(f"Measurement iterations: $measurementIterations")
    println(f"Minimum duration:       $minimumDuration ms")
    println(f"Garbage collection:     $garbageCollection")

    println()

    benchmarkSuites.foreach { b =>
      b.benchmarks.foreach { b_ =>
        val b = b_.asInstanceOf[Benchmark[Any,Any]]
        println(s"Benchmark: ${b.description}")
        val depthResults = b.values.map { v =>
          println(s"- depth=$v:")
          (0 until warmUpIterations)
            .foreach(_ => measure(() => b.f(v), profile, false))

          val results = (0 until measurementIterations)
            .map(_ => measure(() => b.f(v), profile, b.measureMemory))

          val units = results.last.units
          val iterations = results.last.iterations
          println(f"  units: $units")
          println(f"  iterations: $iterations")

          val memoryTotal = results.last.totalSize
          val memoryUnit = results.last.unitSize

          val runTimes = results.map(r =>
            r.totalRunTime.toDouble / r.iterations * 1000000)
          val unitTimeMean = runTimes.sum / results.length
          val unitTimeStdDev = math.sqrt(runTimes.map(x =>
            (x - unitTimeMean) * (x - unitTimeMean)).sum / results.length)

          println(s"  run time: ${unitTimeMean.toLong} μs/it ± ${unitTimeStdDev.toLong}")

          if (b.measureMemory)
            println(s"  memory: $memoryTotal bytes (≃ $memoryUnit bytes/unit)")

          (units, unitTimeMean, memoryTotal)
        }

        val unitGrowth = depthResults.zip(depthResults.tail)
          .map { case ((units1, _, _), (units2, _, _)) =>
            units2.toDouble / units1 }

        val timeGrowth = depthResults.zip(depthResults.tail)
          .map { case ((_, time1, _), (_, time2, _)) =>
            time2.toDouble / time1 }

        println()
        println("Summary:")
        println(s"  Unit growth: " +
                unitGrowth
                  .map(x => f"${PlatformUtil.format(x)}x")
                  .mkString(", "))
        println(s"  Run time growth: " +
                timeGrowth
                  .map(x => f"${PlatformUtil.format(x)}x")
                  .mkString(", "))

        if (b.measureMemory) {
          val memoryGrowth = depthResults
            .zip(depthResults.tail)
            .map { case ((_, _, memory1), (_, _, memory2)) =>
              memory2.toDouble / memory1 }

          println(s"  Memory growth: " +
                  memoryGrowth
                    .map(x => f"${PlatformUtil.format(x)}x")
                    .mkString(", "))
        }

        println()
      }
    }
  }
}
