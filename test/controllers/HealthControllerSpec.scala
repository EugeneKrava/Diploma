package controllers

import org.specs2.concurrent.ExecutionEnv
import org.specs2.mutable.Specification
import play.api.test.Helpers._
import play.api.test._
import utils.Helpers.{app, injector}

class HealthControllerSpec(implicit ee: ExecutionEnv) extends Specification {

  "HealthController GET" should {

    "return OK from a new instance of controller" in {
      val controller = new HealthController(stubControllerComponents())
      val check = controller.check.apply(FakeRequest(GET, "/check"))

      status(check) should_== OK
    }

    "return OK from the application" in {
      val controller = injector.instanceOf[HealthController]
      val check = controller.check().apply(FakeRequest(GET, "/check"))

      status(check) should_== OK
    }

    "return OK index page from the router" in {
      val request = FakeRequest(GET, "/check")
      val check = route(app, request).get

      status(check) should_== OK
    }
  }
}
