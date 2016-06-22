package example

import java.io.File
import java.nio.file._

import scala.collection.JavaConversions._

class FileWatcher(directory: File, onModify: String => Unit) extends Thread {
  val watcher = FileSystems.getDefault.newWatchService
  directory.toPath.register(watcher, StandardWatchEventKinds.ENTRY_MODIFY)

  start()  // Start thread

  override def run(): Unit = {
    @scala.annotation.tailrec
    def f(): Unit = {
      val key = watcher.take

      key.pollEvents.foreach { event =>
        val fileName = event.context()

        event.kind match {
          case StandardWatchEventKinds.OVERFLOW     => Thread.`yield`()
          case StandardWatchEventKinds.ENTRY_MODIFY => onModify(fileName.toString)
        }
      }

      if (key.reset) f()
    }

    f()
  }
}
