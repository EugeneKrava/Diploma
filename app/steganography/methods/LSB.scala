package steganography.methods

import play.api.libs.functional.syntax.{toFunctionalBuilderOps, unlift}
import play.api.libs.json.__

case class LSB(name: String, colors: Seq[String], bitsCount: Int) extends SteganoMethod

object LSB {
  implicit val reads = ((__ \ "name").read[String] and
    (__ \ "colors").read[Seq[String]] and
    (__ \ "bitsCount").read[Int]) (LSB.apply _)

  implicit val writes = ((__ \ "name").write[String] and
    (__ \ "colors").write[Seq[String]] and
    (__ \ "bitsCount").write[Int]) (unlift(LSB.unapply))
}
