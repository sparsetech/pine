package example

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

/**
  * A Service is an abstraction for a small processing unit that takes a request
  * and responds asynchronously. The communication is therefore entirely
  * message-driven. The messages are epxected to be immutable. A service can
  * have an internal state that will not be exposed. Services can be composed
  * and requests may be forwarded to other services. The concept is inspired by
  * Akka's actors.
  */
trait Service[Req, Resp] {
  val process: PartialFunction[Req, Future[Resp]]

  def produce(req: Req): Unit = process(req)

  def request(req: Req): Future[Resp] = process(req)
  def ?(req: Req): Future[Resp] = request(req)

  def compose(service: Service[Req, Resp]): Service[Req, Resp] =
    Service(process.orElse(service.process))

  def map(f: PartialFunction[Req, Req]): Service[Req, Resp] =
    Service {
      Function.unlift { req: Req =>
        process.lift(f.lift(req).getOrElse(req))
      }
    }

  def mapResponse(f: Resp => Resp): Service[Req, Resp] =
    Service {
      Function.unlift { req: Req =>
        process.lift(req).map(_.map(f))
      }
    }

  def filter(f: Req => Boolean): Service[Req, Resp] =
    Service {
      Function.unlift { req: Req =>
        if (f(req)) process.lift(req)
        else None
      }
    }
}

object Service {
  def apply[Req, Resp](f: PartialFunction[Req, Future[Resp]]): Service[Req, Resp] =
    new Service[Req, Resp] {
      val process = f
    }
}
