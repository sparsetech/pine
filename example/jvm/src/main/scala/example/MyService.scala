package example

import scala.concurrent.Future

object MyService extends Service[Request, Response] {
  override val process: PartialFunction[Request, Future[Response]] =
    (new service.NumberGuess).compose(new service.Books).process
}
