package dto

import play.api.libs.functional.syntax.toFunctionalBuilderOps
import play.api.libs.json.{Reads, __}
import steganography.methods.SteganoMethod

case class EncodeRequest[T <: SteganoMethod](image: Seq[Byte], message: String, method: T)

object EncodeRequest {
  implicit def reads[T <: SteganoMethod : Reads]: Reads[EncodeRequest[T]] = (
    (__ \ "image").read[Seq[Byte]] and
      (__ \ "message").read[String] and
      (__ \ "method").read[T]) (EncodeRequest(_, _, _))
}