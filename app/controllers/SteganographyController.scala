package controllers

import com.google.inject.Inject
import dto.EncodeRequest
import play.api.libs.json.{JsValue, Json, Reads, Writes}
import play.api.mvc.{AbstractController, ControllerComponents, Request, Result}
import steganography.encoders.Encoder
import steganography.methods.{LSB, SteganoMethod}
import steganography.services.SteganoService
import utils.Constants.{internalServerError, validationFailed}

import scala.concurrent.{ExecutionContext, Future}

class SteganographyController @Inject()(cc: ControllerComponents)(implicit ec: ExecutionContext) extends AbstractController(cc) {
  def encode(method: String) = Action.async(parse.json) {
    method.toLowerCase match {
      case "lsb" => encodeForMethod[LSB]
      case "some" => encodeForMethod[LSB]
      case _ => _ => Future.successful(BadRequest(Json.toJson("")))
    }
  }

  def encodeForMethod[T <: SteganoMethod : Reads : Writes : Encoder](req: Request[JsValue]): Future[Result] =
    req.body
      .validate[EncodeRequest[T]]
      .fold(validationFailed, handleEncodeRequest)
      .recover(internalServerError)

  def handleEncodeRequest[T <: SteganoMethod : Encoder : Writes]: EncodeRequest[T] => Future[Result] = {
    case EncodeRequest(image, message, method) =>
      Future(SteganoService.encode(image, message, method)).map(res => Ok(Json.toJson(res)))
  }
}
