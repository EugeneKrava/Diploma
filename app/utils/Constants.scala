package utils

import dto.{ServerError, ValidationFailed}
import play.api.libs.json._
import play.api.mvc.Result
import play.api.mvc.Results.{BadRequest, InternalServerError}

import scala.collection.Seq
import scala.concurrent.Future

object Constants {
  val validationFailed: Seq[(JsPath, Seq[JsonValidationError])] => Future[Result] =
    seq => Future.successful(BadRequest(Json.toJson(ValidationFailed(stringifyValidationErrors(seq)))))

  private def stringifyValidationErrors(value: Seq[(JsPath, Seq[JsonValidationError])]): String = {
    value.foldLeft("Invalid fields: ")((acc, current) => acc + "path: " + current._1.toString + ", errors: [" + current._2.foldLeft("")((acc, curr) => acc + ", " + curr.message) + "]")
  }

  val internalServerError: PartialFunction[Throwable, Result] = {
    case t => InternalServerError(Json.toJson(ServerError(t.getMessage)))
  }
}
