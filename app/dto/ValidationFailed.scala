package dto

import play.api.libs.functional.syntax.unlift
import play.api.libs.json.__

case class ValidationFailed(message: String)

object ValidationFailed {
  implicit val writes = (__ \ "message").write[String].contramap(unlift(ValidationFailed.unapply))
  implicit val reads = (__ \ "message").read[String].map(ValidationFailed.apply)
}