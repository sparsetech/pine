package pl.metastack.metaweb

import java.io.File

import com.outr.net.http.jetty.JettyApplication

import org.hyperscala.web.BasicWebsite
import org.hyperscala.web.Scope

object Server extends BasicWebsite with JettyApplication {
  val numberguess = page(new controller.NumberGuess, Scope.Page, "/", "/index.html")

  addFilePath("/sjs/", new File("js/target/scala-2.11/"))
}