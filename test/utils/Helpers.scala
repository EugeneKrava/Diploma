package utils

import play.api.inject.guice.GuiceApplicationBuilder

object Helpers {
  val app = GuiceApplicationBuilder()
    .configure(Map(
      "slick.dbs.default.profile" -> "slick.jdbc.H2Profile$"
    ))
    .build()
  val injector = app.injector
}
