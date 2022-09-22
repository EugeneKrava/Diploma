package controllers

import play.api.mvc._

import javax.inject._
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class HealthController @Inject()(controllerComponents: ControllerComponents)(implicit ec: ExecutionContext) extends AbstractController(controllerComponents) {

  def check = Action.async {
    Future(Ok)
  }
}
