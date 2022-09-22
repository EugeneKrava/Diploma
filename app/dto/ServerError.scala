package dto

import play.api.libs.functional.syntax.unlift
import play.api.libs.json.__


case class ServerError(message: String)

object ServerError {
  implicit val writes = (__ \ "message").write[String].contramap(unlift(ServerError.unapply))
  implicit val reads = (__ \ "message").read[String].map(ServerError.apply)
}