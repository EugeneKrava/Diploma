ThisBuild / scalaVersion := "2.13.8"

ThisBuild / version := "1.0-SNAPSHOT"

lazy val slickVersion = "5.0.2"

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    name := """steganography-service""",
    libraryDependencies ++= Seq(
      guice,
      "com.typesafe.play" %% "play-slick" % slickVersion,
      "com.typesafe.play" %% "play-slick-evolutions" % slickVersion,
      "com.h2database" % "h2" % "2.1.214",
      specs2 % Test
    )
  )